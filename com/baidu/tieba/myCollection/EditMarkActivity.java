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
import com.baidu.tbadk.core.view.r;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes.dex */
public class EditMarkActivity extends BaseActivity<EditMarkActivity> implements BdListView.e, r.a {
    private com.baidu.tieba.myCollection.baseEditMark.a cEH = null;
    private m cEI = null;
    private int cEJ = -1;
    private ArrayList<MarkData> cEK = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cEH = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.cEH.a(new g(this));
        this.cEI = new m(this);
        this.cEI.d(new h(this));
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cEI.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.cEH.getCount() == 0 || this.cEH.anu() < 0) {
            this.cEH.f(true);
            return;
        }
        this.cEI.startSync();
        this.cEH.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cEI.onDestroy();
        this.cEH.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cEI.anh()) {
            this.cEI.ani();
        } else if (view.getId() == this.cEI.anj()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.cEI.Nj();
            if (!this.cEH.kC(intValue)) {
                this.cEI.Rh();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.cEH.anr().size()) {
            this.cEJ = i;
            MarkData markData = this.cEH.anr().get(i);
            MarkData markData2 = this.cEK.get(i);
            int anq = this.cEH.anq();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.yN().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgBookmark(0);
                }
                if (anq > 0) {
                    this.cEH.kB(anq - 1);
                } else {
                    this.cEH.kB(0);
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
        this.cEI.S(this.cEK);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra(PbActivityConfig.KEY_MARK);
                    if (markData != null && this.cEH.anr().size() > this.cEJ && this.cEJ >= 0) {
                        this.cEH.anr().get(this.cEJ).setPostId(markData.getPostId());
                        this.cEH.anr().get(this.cEJ).setHostMode(markData.getHostMode());
                        this.cEH.anr().get(this.cEJ).setSequence(markData.getSequence());
                        this.cEI.anl();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.cEH.anr().size() > this.cEJ && this.cEJ >= 0) {
                        this.cEH.anr().remove(this.cEJ);
                        this.cEI.anl();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void az(boolean z) {
        if (this.cEH != null && this.cEI != null) {
            this.cEH.reset();
            this.cEI.bw(true);
            this.cEH.f(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nv() {
        if (this.cEI != null && this.cEH != null && this.cEH.hasMore()) {
            this.cEI.kA(this.cEH.getOffset());
            this.cEH.f(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.cEI != null && this.cEI.MJ()) {
            this.cEI.ani();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
