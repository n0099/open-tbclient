package com.baidu.tieba.myCollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.aj;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EditMarkActivity extends BaseActivity<EditMarkActivity> implements x, aj {
    private com.baidu.tieba.myCollection.baseEditMark.a bGR = null;
    private f bGS = null;
    private int bGT = -1;
    private ArrayList<MarkData> bGU = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bGR = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.bGR.a(new a(this, this));
        this.bGS = new f(this);
        this.bGS.a(new b(this));
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bGS.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.bGR.getCount() == 0 || this.bGR.ZN() < 0) {
            this.bGR.e(true);
            return;
        }
        this.bGS.startSync();
        this.bGR.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bGS.onDestroy();
        this.bGR.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bGS.ZB()) {
            this.bGS.ZC();
        } else if (view.getId() == this.bGS.ZD()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.bGS.IT();
            if (!this.bGR.hr(intValue)) {
                this.bGS.RL();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.bGR.ZK().size()) {
            this.bGT = i;
            MarkData markData = this.bGR.ZK().get(i);
            MarkData markData2 = this.bGU.get(i);
            int ZJ = this.bGR.ZJ();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.vJ().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.vJ().setMsgBookmark(0);
                }
                if (ZJ > 0) {
                    this.bGR.hq(ZJ - 1);
                } else {
                    this.bGR.hq(0);
                }
            }
            markData2.setNewCounts(0);
            if (markData != null) {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
            }
        }
        super.onItemClick(adapterView, view, i, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bGS.G(this.bGU);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra(PbActivityConfig.KEY_MARK);
                    if (markData != null && this.bGR.ZK().size() > this.bGT && this.bGT >= 0) {
                        this.bGR.ZK().get(this.bGT).setPostId(markData.getPostId());
                        this.bGR.ZK().get(this.bGT).setHostMode(markData.getHostMode());
                        this.bGR.ZK().get(this.bGT).setSequence(markData.getSequence());
                        this.bGS.ZF();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.bGR.ZK().size() > this.bGT && this.bGT >= 0) {
                        this.bGR.ZK().remove(this.bGT);
                        this.bGS.ZF();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        if (this.bGR != null && this.bGS != null) {
            this.bGR.reset();
            this.bGS.bc(true);
            this.bGR.e(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (this.bGS != null && this.bGR != null && this.bGR.hasMore()) {
            this.bGS.hp(this.bGR.getOffset());
            this.bGR.e(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.bGS != null && this.bGS.Iv()) {
            this.bGS.ZC();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
