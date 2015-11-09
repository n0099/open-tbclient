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
import com.baidu.tbadk.core.view.p;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes.dex */
public class EditMarkActivity extends BaseActivity<EditMarkActivity> implements BdListView.e, p.a {
    private com.baidu.tieba.myCollection.baseEditMark.a cbZ = null;
    private j cca = null;
    private int ccb = -1;
    private ArrayList<MarkData> ccc = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cbZ = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.cbZ.a(new e(this));
        this.cca = new j(this);
        this.cca.b(new f(this));
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cca.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.cbZ.getCount() == 0 || this.cbZ.adW() < 0) {
            this.cbZ.f(true);
            return;
        }
        this.cca.startSync();
        this.cbZ.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cca.onDestroy();
        this.cbZ.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cca.adJ()) {
            this.cca.changeEditState();
        } else if (view.getId() == this.cca.adK()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.cca.JC();
            if (!this.cbZ.iN(intValue)) {
                this.cca.Nk();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.cbZ.adT().size()) {
            this.ccb = i;
            MarkData markData = this.cbZ.adT().get(i);
            MarkData markData2 = this.ccc.get(i);
            int adS = this.cbZ.adS();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.wM().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgBookmark(0);
                }
                if (adS > 0) {
                    this.cbZ.iM(adS - 1);
                } else {
                    this.cbZ.iM(0);
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
        this.cca.M(this.ccc);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra(PbActivityConfig.KEY_MARK);
                    if (markData != null && this.cbZ.adT().size() > this.ccb && this.ccb >= 0) {
                        this.cbZ.adT().get(this.ccb).setPostId(markData.getPostId());
                        this.cbZ.adT().get(this.ccb).setHostMode(markData.getHostMode());
                        this.cbZ.adT().get(this.ccb).setSequence(markData.getSequence());
                        this.cca.adM();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.cbZ.adT().size() > this.ccb && this.ccb >= 0) {
                        this.cbZ.adT().remove(this.ccb);
                        this.cca.adM();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        if (this.cbZ != null && this.cca != null) {
            this.cbZ.reset();
            this.cca.bm(true);
            this.cbZ.f(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cca != null && this.cbZ != null && this.cbZ.hasMore()) {
            this.cca.iL(this.cbZ.getOffset());
            this.cbZ.f(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.cca != null && this.cca.Jd()) {
            this.cca.changeEditState();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
