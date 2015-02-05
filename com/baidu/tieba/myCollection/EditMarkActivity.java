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
    private com.baidu.tbadk.baseEditMark.a bym = null;
    private g byn = null;
    private int byo = -1;
    private ArrayList<MarkData> byp = null;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015005, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bym = new com.baidu.tbadk.baseEditMark.a();
        this.bym.a(new b(this, this));
        this.byn = new g(this);
        this.byn.b(new c(this));
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.byn.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.bym.getCount() == 0 || this.bym.la() < 0) {
            this.bym.c((Boolean) true);
            return;
        }
        this.byn.startSync();
        this.bym.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.byn.onDestroy();
        this.bym.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.byn.Wx()) {
            this.byn.Wy();
        } else if (view.getId() == this.byn.Wz()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.byn.DH();
            if (!this.bym.aN(intValue)) {
                this.byn.Ou();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.bym.kX().size()) {
            this.byo = i;
            MarkData markData = this.bym.kX().get(i);
            MarkData markData2 = this.byp.get(i);
            int kW = this.bym.kW();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.rS().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.m255getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.rS().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.rS().setMsgBookmark(0);
                }
                if (kW > 0) {
                    this.bym.aM(kW - 1);
                } else {
                    this.bym.aM(0);
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
        this.byn.H(this.byp);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra(PbActivityConfig.KEY_MARK);
                    if (markData != null && this.bym.kX().size() > this.byo && this.byo >= 0) {
                        this.bym.kX().get(this.byo).setPostId(markData.getPostId());
                        this.bym.kX().get(this.byo).setHostMode(markData.getHostMode());
                        this.bym.kX().get(this.byo).setSequence(markData.getSequence());
                        this.byn.WB();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.bym.kX().size() > this.byo && this.byo >= 0) {
                        this.bym.kX().remove(this.byo);
                        this.byn.WB();
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
        if (this.bym != null && this.byn != null) {
            this.bym.reset();
            this.byn.aR(true);
            this.bym.c((Boolean) false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        if (this.byn != null && this.bym != null && this.bym.hasMore()) {
            this.byn.gW(this.bym.getOffset());
            this.bym.c((Boolean) false);
        }
    }
}
