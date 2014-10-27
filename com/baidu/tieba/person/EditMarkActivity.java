package com.baidu.tieba.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EditMarkActivity extends BaseActivity implements com.baidu.adp.widget.ListView.aa, com.baidu.adp.widget.ListView.f {
    private com.baidu.tieba.model.j bAS = null;
    private h bAT = null;
    private int bAU = -1;
    private ArrayList<MarkData> bAV = null;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015005, new e());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bAS = new com.baidu.tieba.model.j();
        this.bAS.a(new f(this, this));
        this.bAT = new h(this);
        this.bAT.f(new g(this));
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bAT.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.bAS.getCount() == 0 || this.bAS.Tl() < 0) {
            this.bAS.g(true);
            return;
        }
        this.bAT.startSync();
        this.bAS.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bAT.onDestroy();
        this.bAS.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bAT.Zz()) {
            this.bAT.ZA();
        } else if (view.getId() == this.bAT.ZB()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.bAT.CN();
            if (!this.bAS.gB(intValue)) {
                this.bAT.ZD();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.bAS.Ti().size()) {
            this.bAU = i;
            MarkData markData = this.bAS.Ti().get(i);
            MarkData markData2 = this.bAV.get(i);
            int Th = this.bAS.Th();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.oB().getMsgBookmark();
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.oB().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.oB().setMsgBookmark(0);
                }
                if (Th > 0) {
                    this.bAS.gA(Th - 1);
                } else {
                    this.bAS.gA(0);
                }
            }
            markData2.setNewCounts(0);
            if (markData != null) {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(this).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
            }
        }
        super.onItemClick(adapterView, view, i, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bAT.D(this.bAV);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra(PbActivityConfig.KEY_MARK);
                    if (markData != null && this.bAS.Ti().size() > this.bAU && this.bAU >= 0) {
                        this.bAS.Ti().get(this.bAU).setPostId(markData.getPostId());
                        this.bAS.Ti().get(this.bAU).setHostMode(markData.getHostMode());
                        this.bAS.Ti().get(this.bAU).setSequence(markData.getSequence());
                        this.bAT.ZF();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.bAS.Ti().size() > this.bAU && this.bAU >= 0) {
                        this.bAS.Ti().remove(this.bAU);
                        this.bAT.ZF();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        if (this.bAS != null && this.bAT != null) {
            this.bAS.reset();
            this.bAT.aC(true);
            this.bAS.g(true);
        }
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        if (this.bAT != null && this.bAS != null && this.bAS.hasMore()) {
            this.bAT.gU(this.bAS.getOffset());
            this.bAS.g(false);
        }
    }
}
