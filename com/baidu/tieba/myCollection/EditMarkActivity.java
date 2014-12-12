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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EditMarkActivity extends BaseActivity<EditMarkActivity> implements ab, com.baidu.adp.widget.ListView.g {
    private com.baidu.tbadk.baseEditMark.a bwE = null;
    private g bwF = null;
    private int bwG = -1;
    private ArrayList<MarkData> bwH = null;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015005, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bwE = new com.baidu.tbadk.baseEditMark.a();
        this.bwE.a(new b(this, this));
        this.bwF = new g(this);
        this.bwF.c(new c(this));
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bwF.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.bwE.getCount() == 0 || this.bwE.lh() < 0) {
            this.bwE.c((Boolean) true);
            return;
        }
        this.bwF.startSync();
        this.bwE.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bwF.onDestroy();
        this.bwE.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bwF.VX()) {
            this.bwF.VY();
        } else if (view.getId() == this.bwF.VZ()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.bwF.Do();
            if (!this.bwE.aI(intValue)) {
                this.bwF.Od();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.bwE.le().size()) {
            this.bwG = i;
            MarkData markData = this.bwE.le().get(i);
            MarkData markData2 = this.bwH.get(i);
            int ld = this.bwE.ld();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.rI().getMsgBookmark();
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.rI().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.rI().setMsgBookmark(0);
                }
                if (ld > 0) {
                    this.bwE.aH(ld - 1);
                } else {
                    this.bwE.aH(0);
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
        this.bwF.G(this.bwH);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra(PbActivityConfig.KEY_MARK);
                    if (markData != null && this.bwE.le().size() > this.bwG && this.bwG >= 0) {
                        this.bwE.le().get(this.bwG).setPostId(markData.getPostId());
                        this.bwE.le().get(this.bwG).setHostMode(markData.getHostMode());
                        this.bwE.le().get(this.bwG).setSequence(markData.getSequence());
                        this.bwF.Wb();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.bwE.le().size() > this.bwG && this.bwG >= 0) {
                        this.bwE.le().remove(this.bwG);
                        this.bwF.Wb();
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
        if (this.bwE != null && this.bwF != null) {
            this.bwE.reset();
            this.bwF.aP(true);
            this.bwE.c((Boolean) false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        if (this.bwF != null && this.bwE != null && this.bwE.hasMore()) {
            this.bwF.gN(this.bwE.getOffset());
            this.bwE.c((Boolean) false);
        }
    }
}
