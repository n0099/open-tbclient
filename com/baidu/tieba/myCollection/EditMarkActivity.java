package com.baidu.tieba.myCollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.j;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes3.dex */
public class EditMarkActivity extends BaseActivity<EditMarkActivity> implements BdListView.e, j.b {
    private com.baidu.tieba.myCollection.baseEditMark.a fzZ = null;
    private c fAa = null;
    private int fAb = -1;
    private ArrayList<MarkData> fAc = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fzZ = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.fzZ.a(new d() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.1
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        EditMarkActivity.this.fAa.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.fAa.a(r1, EditMarkActivity.this.fzZ, ((Boolean) objArr[2]).booleanValue());
                        EditMarkActivity.this.fAc = EditMarkActivity.this.fzZ.bbR();
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        EditMarkActivity.this.fAa.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.fAa.a(r1, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        EditMarkActivity.this.fAa.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            EditMarkActivity.this.fAa.startRefresh(EditMarkActivity.this.fzZ.getOffset());
                            EditMarkActivity.this.fzZ.e(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        EditMarkActivity.this.fAa.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, EditMarkActivity.this.fzZ);
                    }
                } catch (Exception e) {
                    BdLog.d(e.getMessage());
                }
            }
        });
        this.fAa = new c(this);
        this.fAa.c(new a.b() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                EditMarkActivity.this.fAa.startRefresh(EditMarkActivity.this.fzZ.getOffset());
                EditMarkActivity.this.fzZ.e(true);
            }
        });
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fAa.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.fzZ.getCount() == 0 || this.fzZ.bbU() < 0) {
            this.fzZ.e(true);
            return;
        }
        this.fAa.startSync();
        this.fzZ.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fAa.onDestroy();
        this.fzZ.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fAa.bbD()) {
            this.fAa.bbE();
        } else if (view.getId() == this.fAa.bbF()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.fAa.auB();
            if (!this.fzZ.rv(intValue)) {
                this.fAa.aEd();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.fzZ.bbR().size()) {
            this.fAb = i;
            MarkData markData = this.fzZ.bbR().get(i);
            MarkData markData2 = this.fAc.get(i);
            int bbQ = this.fzZ.bbQ();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.GL().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.GL().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.GL().setMsgBookmark(0);
                }
                if (bbQ > 0) {
                    this.fzZ.ru(bbQ - 1);
                } else {
                    this.fzZ.ru(0);
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
        this.fAa.aj(this.fAc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                    if (markData != null && this.fzZ.bbR().size() > this.fAb && this.fAb >= 0) {
                        this.fzZ.bbR().get(this.fAb).setPostId(markData.getPostId());
                        this.fzZ.bbR().get(this.fAb).setHostMode(markData.getHostMode());
                        this.fzZ.bbR().get(this.fAb).setSequence(markData.getSequence());
                        this.fAa.bbH();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.fzZ.bbR().size() > this.fAb && this.fAb >= 0) {
                        this.fzZ.bbR().remove(this.fAb);
                        this.fAa.bbH();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bG(boolean z) {
        if (this.fzZ != null && this.fAa != null) {
            this.fzZ.reset();
            this.fAa.cD(true);
            this.fzZ.e(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fAa != null && this.fzZ != null && this.fzZ.hasMore()) {
            this.fAa.startRefresh(this.fzZ.getOffset());
            this.fzZ.e(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.fAa != null && this.fAa.atE()) {
            this.fAa.bbE();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
