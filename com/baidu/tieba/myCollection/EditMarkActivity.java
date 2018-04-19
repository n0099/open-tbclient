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
    private com.baidu.tieba.myCollection.baseEditMark.a eTa = null;
    private c eTb = null;
    private int eTc = -1;
    private ArrayList<MarkData> eTd = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eTa = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.eTa.a(new d() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.1
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        EditMarkActivity.this.eTb.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.eTb.a(r1, EditMarkActivity.this.eTa, ((Boolean) objArr[2]).booleanValue());
                        EditMarkActivity.this.eTd = EditMarkActivity.this.eTa.aSY();
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        EditMarkActivity.this.eTb.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.eTb.a(r1, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        EditMarkActivity.this.eTb.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            EditMarkActivity.this.eTb.startRefresh(EditMarkActivity.this.eTa.getOffset());
                            EditMarkActivity.this.eTa.d(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        EditMarkActivity.this.eTb.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, EditMarkActivity.this.eTa);
                    }
                } catch (Exception e) {
                    BdLog.d(e.getMessage());
                }
            }
        });
        this.eTb = new c(this);
        this.eTb.c(new a.b() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                EditMarkActivity.this.eTb.startRefresh(EditMarkActivity.this.eTa.getOffset());
                EditMarkActivity.this.eTa.d(true);
            }
        });
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eTb.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.eTa.getCount() == 0 || this.eTa.aTb() < 0) {
            this.eTa.d(true);
            return;
        }
        this.eTb.startSync();
        this.eTa.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eTb.onDestroy();
        this.eTa.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.eTb.aSK()) {
            this.eTb.aSL();
        } else if (view2.getId() == this.eTb.aSM()) {
            int intValue = ((Integer) view2.getTag()).intValue();
            this.eTb.alR();
            if (!this.eTa.pL(intValue)) {
                this.eTb.atM();
            }
        }
        super.onClick(view2);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        if (i >= 0 && i < this.eTa.aSY().size()) {
            this.eTc = i;
            MarkData markData = this.eTa.aSY().get(i);
            MarkData markData2 = this.eTd.get(i);
            int aSX = this.eTa.aSX();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.zx().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgBookmark(0);
                }
                if (aSX > 0) {
                    this.eTa.pK(aSX - 1);
                } else {
                    this.eTa.pK(0);
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
        this.eTb.ai(this.eTd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                    if (markData != null && this.eTa.aSY().size() > this.eTc && this.eTc >= 0) {
                        this.eTa.aSY().get(this.eTc).setPostId(markData.getPostId());
                        this.eTa.aSY().get(this.eTc).setHostMode(markData.getHostMode());
                        this.eTa.aSY().get(this.eTc).setSequence(markData.getSequence());
                        this.eTb.aSO();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.eTa.aSY().size() > this.eTc && this.eTc >= 0) {
                        this.eTa.aSY().remove(this.eTc);
                        this.eTb.aSO();
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
        if (this.eTa != null && this.eTb != null) {
            this.eTa.reset();
            this.eTb.bL(true);
            this.eTa.d(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eTb != null && this.eTa != null && this.eTa.hasMore()) {
            this.eTb.startRefresh(this.eTa.getOffset());
            this.eTa.d(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.eTb != null && this.eTb.akS()) {
            this.eTb.aSL();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
