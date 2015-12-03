package com.baidu.tieba.myCollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.q;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes.dex */
public class EditMarkActivity extends BaseActivity<EditMarkActivity> implements BdListView.e, q.a {
    private com.baidu.tieba.myCollection.baseEditMark.a ctY = null;
    private m ctZ = null;
    private int cua = -1;
    private ArrayList<MarkData> cub = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ctY = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.ctY.a(new g(this));
        this.ctZ = new m(this);
        this.ctZ.b(new h(this));
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ctZ.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.ctY.getCount() == 0 || this.ctY.aij() < 0) {
            this.ctY.f(true);
            return;
        }
        this.ctZ.startSync();
        this.ctY.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ctZ.onDestroy();
        this.ctY.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ctZ.ahX()) {
            this.ctZ.changeEditState();
        } else if (view.getId() == this.ctZ.ahY()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.ctZ.KX();
            if (!this.ctY.jE(intValue)) {
                this.ctZ.OM();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.ctY.aig().size()) {
            this.cua = i;
            MarkData markData = this.ctY.aig().get(i);
            MarkData markData2 = this.cub.get(i);
            int aif = this.ctY.aif();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.xJ().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xJ().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xJ().setMsgBookmark(0);
                }
                if (aif > 0) {
                    this.ctY.jD(aif - 1);
                } else {
                    this.ctY.jD(0);
                }
            }
            markData2.setNewCounts(0);
            if (markData != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
            }
        }
        super.onItemClick(adapterView, view, i, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ctZ.S(this.cub);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra(PbActivityConfig.KEY_MARK);
                    if (markData != null && this.ctY.aig().size() > this.cua && this.cua >= 0) {
                        this.ctY.aig().get(this.cua).setPostId(markData.getPostId());
                        this.ctY.aig().get(this.cua).setHostMode(markData.getHostMode());
                        this.ctY.aig().get(this.cua).setSequence(markData.getSequence());
                        this.ctZ.aia();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.ctY.aig().size() > this.cua && this.cua >= 0) {
                        this.ctY.aig().remove(this.cua);
                        this.ctZ.aia();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        if (this.ctY != null && this.ctZ != null) {
            this.ctY.reset();
            this.ctZ.bu(true);
            this.ctY.f(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.ctZ != null && this.ctY != null && this.ctY.hasMore()) {
            this.ctZ.jC(this.ctY.getOffset());
            this.ctY.f(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.ctZ != null && this.ctZ.Kz()) {
            this.ctZ.changeEditState();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
