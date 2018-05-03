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
    private com.baidu.tieba.myCollection.baseEditMark.a eSX = null;
    private c eSY = null;
    private int eSZ = -1;
    private ArrayList<MarkData> eTa = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eSX = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.eSX.a(new d() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.1
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        EditMarkActivity.this.eSY.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.eSY.a(r1, EditMarkActivity.this.eSX, ((Boolean) objArr[2]).booleanValue());
                        EditMarkActivity.this.eTa = EditMarkActivity.this.eSX.aSY();
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        EditMarkActivity.this.eSY.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.eSY.a(r1, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        EditMarkActivity.this.eSY.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            EditMarkActivity.this.eSY.startRefresh(EditMarkActivity.this.eSX.getOffset());
                            EditMarkActivity.this.eSX.d(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        EditMarkActivity.this.eSY.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, EditMarkActivity.this.eSX);
                    }
                } catch (Exception e) {
                    BdLog.d(e.getMessage());
                }
            }
        });
        this.eSY = new c(this);
        this.eSY.c(new a.b() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                EditMarkActivity.this.eSY.startRefresh(EditMarkActivity.this.eSX.getOffset());
                EditMarkActivity.this.eSX.d(true);
            }
        });
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eSY.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.eSX.getCount() == 0 || this.eSX.aTb() < 0) {
            this.eSX.d(true);
            return;
        }
        this.eSY.startSync();
        this.eSX.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eSY.onDestroy();
        this.eSX.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.eSY.aSK()) {
            this.eSY.aSL();
        } else if (view2.getId() == this.eSY.aSM()) {
            int intValue = ((Integer) view2.getTag()).intValue();
            this.eSY.alR();
            if (!this.eSX.pL(intValue)) {
                this.eSY.atM();
            }
        }
        super.onClick(view2);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        if (i >= 0 && i < this.eSX.aSY().size()) {
            this.eSZ = i;
            MarkData markData = this.eSX.aSY().get(i);
            MarkData markData2 = this.eTa.get(i);
            int aSX = this.eSX.aSX();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.zx().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgBookmark(0);
                }
                if (aSX > 0) {
                    this.eSX.pK(aSX - 1);
                } else {
                    this.eSX.pK(0);
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
        this.eSY.ai(this.eTa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                    if (markData != null && this.eSX.aSY().size() > this.eSZ && this.eSZ >= 0) {
                        this.eSX.aSY().get(this.eSZ).setPostId(markData.getPostId());
                        this.eSX.aSY().get(this.eSZ).setHostMode(markData.getHostMode());
                        this.eSX.aSY().get(this.eSZ).setSequence(markData.getSequence());
                        this.eSY.aSO();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.eSX.aSY().size() > this.eSZ && this.eSZ >= 0) {
                        this.eSX.aSY().remove(this.eSZ);
                        this.eSY.aSO();
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
        if (this.eSX != null && this.eSY != null) {
            this.eSX.reset();
            this.eSY.bL(true);
            this.eSX.d(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eSY != null && this.eSX != null && this.eSX.hasMore()) {
            this.eSY.startRefresh(this.eSX.getOffset());
            this.eSX.d(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.eSY != null && this.eSY.akS()) {
            this.eSY.aSL();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
