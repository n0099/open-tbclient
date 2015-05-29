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
    private com.baidu.tieba.myCollection.baseEditMark.a bGQ = null;
    private f bGR = null;
    private int bGS = -1;
    private ArrayList<MarkData> bGT = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bGQ = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.bGQ.a(new a(this, this));
        this.bGR = new f(this);
        this.bGR.a(new b(this));
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bGR.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.bGQ.getCount() == 0 || this.bGQ.ZM() < 0) {
            this.bGQ.e(true);
            return;
        }
        this.bGR.startSync();
        this.bGQ.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bGR.onDestroy();
        this.bGQ.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bGR.ZA()) {
            this.bGR.ZB();
        } else if (view.getId() == this.bGR.ZC()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.bGR.IS();
            if (!this.bGQ.hr(intValue)) {
                this.bGR.RK();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.bGQ.ZJ().size()) {
            this.bGS = i;
            MarkData markData = this.bGQ.ZJ().get(i);
            MarkData markData2 = this.bGT.get(i);
            int ZI = this.bGQ.ZI();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.vJ().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.vJ().setMsgBookmark(0);
                }
                if (ZI > 0) {
                    this.bGQ.hq(ZI - 1);
                } else {
                    this.bGQ.hq(0);
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
        this.bGR.G(this.bGT);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra(PbActivityConfig.KEY_MARK);
                    if (markData != null && this.bGQ.ZJ().size() > this.bGS && this.bGS >= 0) {
                        this.bGQ.ZJ().get(this.bGS).setPostId(markData.getPostId());
                        this.bGQ.ZJ().get(this.bGS).setHostMode(markData.getHostMode());
                        this.bGQ.ZJ().get(this.bGS).setSequence(markData.getSequence());
                        this.bGR.ZE();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.bGQ.ZJ().size() > this.bGS && this.bGS >= 0) {
                        this.bGQ.ZJ().remove(this.bGS);
                        this.bGR.ZE();
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
        if (this.bGQ != null && this.bGR != null) {
            this.bGQ.reset();
            this.bGR.bc(true);
            this.bGQ.e(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (this.bGR != null && this.bGQ != null && this.bGQ.hasMore()) {
            this.bGR.hp(this.bGQ.getOffset());
            this.bGQ.e(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.bGR != null && this.bGR.Iu()) {
            this.bGR.ZB();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
