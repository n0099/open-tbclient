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
import com.baidu.tbadk.core.view.e;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes3.dex */
public class EditMarkActivity extends BaseActivity<EditMarkActivity> implements BdListView.e, e.b {
    private com.baidu.tieba.myCollection.baseEditMark.a eUe = null;
    private c eUf = null;
    private int eUg = -1;
    private ArrayList<MarkData> eUh = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eUe = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.eUe.a(new d() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.1
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        EditMarkActivity.this.eUf.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.eUf.a(r1, EditMarkActivity.this.eUe, ((Boolean) objArr[2]).booleanValue());
                        EditMarkActivity.this.eUh = EditMarkActivity.this.eUe.aSY();
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        EditMarkActivity.this.eUf.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.eUf.a(r1, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        EditMarkActivity.this.eUf.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            EditMarkActivity.this.eUf.startRefresh(EditMarkActivity.this.eUe.getOffset());
                            EditMarkActivity.this.eUe.d(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        EditMarkActivity.this.eUf.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, EditMarkActivity.this.eUe);
                    }
                } catch (Exception e) {
                    BdLog.d(e.getMessage());
                }
            }
        });
        this.eUf = new c(this);
        this.eUf.c(new a.b() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                EditMarkActivity.this.eUf.startRefresh(EditMarkActivity.this.eUe.getOffset());
                EditMarkActivity.this.eUe.d(true);
            }
        });
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eUf.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.eUe.getCount() == 0 || this.eUe.aTb() < 0) {
            this.eUe.d(true);
            return;
        }
        this.eUf.startSync();
        this.eUe.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eUf.onDestroy();
        this.eUe.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.eUf.aSK()) {
            this.eUf.aSL();
        } else if (view2.getId() == this.eUf.aSM()) {
            int intValue = ((Integer) view2.getTag()).intValue();
            this.eUf.alR();
            if (!this.eUe.pK(intValue)) {
                this.eUf.atL();
            }
        }
        super.onClick(view2);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        if (i >= 0 && i < this.eUe.aSY().size()) {
            this.eUg = i;
            MarkData markData = this.eUe.aSY().get(i);
            MarkData markData2 = this.eUh.get(i);
            int aSX = this.eUe.aSX();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.zw().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.zw().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.zw().setMsgBookmark(0);
                }
                if (aSX > 0) {
                    this.eUe.pJ(aSX - 1);
                } else {
                    this.eUe.pJ(0);
                }
            }
            markData2.setNewCounts(0);
            if (markData != null) {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
            }
        }
        super.onItemClick(adapterView, view2, i, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eUf.ai(this.eUh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                    if (markData != null && this.eUe.aSY().size() > this.eUg && this.eUg >= 0) {
                        this.eUe.aSY().get(this.eUg).setPostId(markData.getPostId());
                        this.eUe.aSY().get(this.eUg).setHostMode(markData.getHostMode());
                        this.eUe.aSY().get(this.eUg).setSequence(markData.getSequence());
                        this.eUf.aSO();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.eUe.aSY().size() > this.eUg && this.eUg >= 0) {
                        this.eUe.aSY().remove(this.eUg);
                        this.eUf.aSO();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.e.b
    public void aO(boolean z) {
        if (this.eUe != null && this.eUf != null) {
            this.eUe.reset();
            this.eUf.bL(true);
            this.eUe.d(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eUf != null && this.eUe != null && this.eUe.hasMore()) {
            this.eUf.startRefresh(this.eUe.getOffset());
            this.eUe.d(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.eUf != null && this.eUf.akS()) {
            this.eUf.aSL();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
