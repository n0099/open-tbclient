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
    private com.baidu.tieba.myCollection.baseEditMark.a cya = null;
    private m cyb = null;
    private int cyc = -1;
    private ArrayList<MarkData> cyd = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cya = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.cya.a(new g(this));
        this.cyb = new m(this);
        this.cyb.b(new h(this));
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cyb.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.cya.getCount() == 0 || this.cya.ajw() < 0) {
            this.cya.f(true);
            return;
        }
        this.cyb.startSync();
        this.cya.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cyb.onDestroy();
        this.cya.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cyb.ajk()) {
            this.cyb.changeEditState();
        } else if (view.getId() == this.cyb.ajl()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.cyb.Lq();
            if (!this.cya.kc(intValue)) {
                this.cyb.Pe();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.cya.ajt().size()) {
            this.cyc = i;
            MarkData markData = this.cya.ajt().get(i);
            MarkData markData2 = this.cyd.get(i);
            int ajs = this.cya.ajs();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.xv().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xv().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xv().setMsgBookmark(0);
                }
                if (ajs > 0) {
                    this.cya.kb(ajs - 1);
                } else {
                    this.cya.kb(0);
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
        this.cyb.R(this.cyd);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra(PbActivityConfig.KEY_MARK);
                    if (markData != null && this.cya.ajt().size() > this.cyc && this.cyc >= 0) {
                        this.cya.ajt().get(this.cyc).setPostId(markData.getPostId());
                        this.cya.ajt().get(this.cyc).setHostMode(markData.getHostMode());
                        this.cya.ajt().get(this.cyc).setSequence(markData.getSequence());
                        this.cyb.ajn();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.cya.ajt().size() > this.cyc && this.cyc >= 0) {
                        this.cya.ajt().remove(this.cyc);
                        this.cyb.ajn();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        if (this.cya != null && this.cyb != null) {
            this.cya.reset();
            this.cyb.bu(true);
            this.cya.f(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cyb != null && this.cya != null && this.cya.hasMore()) {
            this.cyb.ka(this.cya.getOffset());
            this.cya.f(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.cyb != null && this.cyb.KS()) {
            this.cyb.changeEditState();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
