package com.baidu.tieba.myCollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EditMarkActivity extends BaseActivity<EditMarkActivity> implements ab, com.baidu.adp.widget.ListView.g {
    private com.baidu.tbadk.baseEditMark.a byn = null;
    private g byo = null;
    private int byp = -1;
    private ArrayList<MarkData> byq = null;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015005, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.byn = new com.baidu.tbadk.baseEditMark.a();
        this.byn.a(new b(this, this));
        this.byo = new g(this);
        this.byo.b(new c(this));
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.byo.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.byn.getCount() == 0 || this.byn.lh() < 0) {
            this.byn.c((Boolean) true);
            return;
        }
        this.byo.startSync();
        this.byn.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.byo.onDestroy();
        this.byn.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.byo.WC()) {
            this.byo.WD();
        } else if (view.getId() == this.byo.WE()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.byo.DN();
            if (!this.byn.aN(intValue)) {
                this.byo.Oz();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.byn.le().size()) {
            this.byp = i;
            MarkData markData = this.byn.le().get(i);
            MarkData markData2 = this.byq.get(i);
            int ld = this.byn.ld();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.rY().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.m255getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.rY().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.rY().setMsgBookmark(0);
                }
                if (ld > 0) {
                    this.byn.aM(ld - 1);
                } else {
                    this.byn.aM(0);
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
        this.byo.H(this.byq);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra(PbActivityConfig.KEY_MARK);
                    if (markData != null && this.byn.le().size() > this.byp && this.byp >= 0) {
                        this.byn.le().get(this.byp).setPostId(markData.getPostId());
                        this.byn.le().get(this.byp).setHostMode(markData.getHostMode());
                        this.byn.le().get(this.byp).setSequence(markData.getSequence());
                        this.byo.WG();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.byn.le().size() > this.byp && this.byp >= 0) {
                        this.byn.le().remove(this.byp);
                        this.byo.WG();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        if (this.byn != null && this.byo != null) {
            this.byn.reset();
            this.byo.aR(true);
            this.byn.c((Boolean) false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        if (this.byo != null && this.byn != null && this.byn.hasMore()) {
            this.byo.gW(this.byn.getOffset());
            this.byn.c((Boolean) false);
        }
    }
}
