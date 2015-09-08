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
import com.baidu.tbadk.core.view.x;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes.dex */
public class EditMarkActivity extends BaseActivity<EditMarkActivity> implements BdListView.e, x.a {
    private com.baidu.tieba.myCollection.baseEditMark.a bXB = null;
    private j bXC = null;
    private int bXD = -1;
    private ArrayList<MarkData> bXE = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bXB = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.bXB.a(new e(this));
        this.bXC = new j(this);
        this.bXC.b(new f(this));
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bXC.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.bXB.getCount() == 0 || this.bXB.acm() < 0) {
            this.bXB.f(true);
            return;
        }
        this.bXC.startSync();
        this.bXB.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bXC.onDestroy();
        this.bXB.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bXC.aca()) {
            this.bXC.changeEditState();
        } else if (view.getId() == this.bXC.acb()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.bXC.Jv();
            if (!this.bXB.is(intValue)) {
                this.bXC.MX();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.bXB.acj().size()) {
            this.bXD = i;
            MarkData markData = this.bXB.acj().get(i);
            MarkData markData2 = this.bXE.get(i);
            int aci = this.bXB.aci();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.wZ().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgBookmark(0);
                }
                if (aci > 0) {
                    this.bXB.ir(aci - 1);
                } else {
                    this.bXB.ir(0);
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
        this.bXC.M(this.bXE);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra(PbActivityConfig.KEY_MARK);
                    if (markData != null && this.bXB.acj().size() > this.bXD && this.bXD >= 0) {
                        this.bXB.acj().get(this.bXD).setPostId(markData.getPostId());
                        this.bXB.acj().get(this.bXD).setHostMode(markData.getHostMode());
                        this.bXB.acj().get(this.bXD).setSequence(markData.getSequence());
                        this.bXC.acd();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.bXB.acj().size() > this.bXD && this.bXD >= 0) {
                        this.bXB.acj().remove(this.bXD);
                        this.bXC.acd();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        if (this.bXB != null && this.bXC != null) {
            this.bXB.reset();
            this.bXC.bl(true);
            this.bXB.f(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.bXC != null && this.bXB != null && this.bXB.hasMore()) {
            this.bXC.iq(this.bXB.getOffset());
            this.bXB.f(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.bXC != null && this.bXC.IW()) {
            this.bXC.changeEditState();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
