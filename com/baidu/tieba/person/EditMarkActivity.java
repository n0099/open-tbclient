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
    private com.baidu.tieba.model.j bBg = null;
    private h bBh = null;
    private int bBi = -1;
    private ArrayList<MarkData> bBj = null;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015005, new e());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bBg = new com.baidu.tieba.model.j();
        this.bBg.a(new f(this, this));
        this.bBh = new h(this);
        this.bBh.f(new g(this));
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bBh.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.bBg.getCount() == 0 || this.bBg.To() < 0) {
            this.bBg.g(true);
            return;
        }
        this.bBh.startSync();
        this.bBg.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bBh.onDestroy();
        this.bBg.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bBh.ZC()) {
            this.bBh.ZD();
        } else if (view.getId() == this.bBh.ZE()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.bBh.CP();
            if (!this.bBg.gB(intValue)) {
                this.bBh.Hx();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.bBg.Tl().size()) {
            this.bBi = i;
            MarkData markData = this.bBg.Tl().get(i);
            MarkData markData2 = this.bBj.get(i);
            int Tk = this.bBg.Tk();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.oD().getMsgBookmark();
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.oD().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.oD().setMsgBookmark(0);
                }
                if (Tk > 0) {
                    this.bBg.gA(Tk - 1);
                } else {
                    this.bBg.gA(0);
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
        this.bBh.E(this.bBj);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra(PbActivityConfig.KEY_MARK);
                    if (markData != null && this.bBg.Tl().size() > this.bBi && this.bBi >= 0) {
                        this.bBg.Tl().get(this.bBi).setPostId(markData.getPostId());
                        this.bBg.Tl().get(this.bBi).setHostMode(markData.getHostMode());
                        this.bBg.Tl().get(this.bBi).setSequence(markData.getSequence());
                        this.bBh.ZH();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.bBg.Tl().size() > this.bBi && this.bBi >= 0) {
                        this.bBg.Tl().remove(this.bBi);
                        this.bBh.ZH();
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
        if (this.bBg != null && this.bBh != null) {
            this.bBg.reset();
            this.bBh.aC(true);
            this.bBg.g(true);
        }
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        if (this.bBh != null && this.bBg != null && this.bBg.hasMore()) {
            this.bBh.gU(this.bBg.getOffset());
            this.bBg.g(false);
        }
    }
}
