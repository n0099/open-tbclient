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
import com.baidu.tbadk.core.view.g;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes3.dex */
public class EditMarkActivity extends BaseActivity<EditMarkActivity> implements BdListView.e, g.b {
    private com.baidu.tieba.myCollection.baseEditMark.a fjA = null;
    private c fjB = null;
    private int fjC = -1;
    private ArrayList<MarkData> fjD = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fjA = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.fjA.a(new d() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.1
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        EditMarkActivity.this.fjB.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.fjB.a(r1, EditMarkActivity.this.fjA, ((Boolean) objArr[2]).booleanValue());
                        EditMarkActivity.this.fjD = EditMarkActivity.this.fjA.aWT();
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        EditMarkActivity.this.fjB.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.fjB.a(r1, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        EditMarkActivity.this.fjB.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            EditMarkActivity.this.fjB.startRefresh(EditMarkActivity.this.fjA.getOffset());
                            EditMarkActivity.this.fjA.e(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        EditMarkActivity.this.fjB.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, EditMarkActivity.this.fjA);
                    }
                } catch (Exception e) {
                    BdLog.d(e.getMessage());
                }
            }
        });
        this.fjB = new c(this);
        this.fjB.c(new a.b() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                EditMarkActivity.this.fjB.startRefresh(EditMarkActivity.this.fjA.getOffset());
                EditMarkActivity.this.fjA.e(true);
            }
        });
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fjB.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.fjA.getCount() == 0 || this.fjA.aWW() < 0) {
            this.fjA.e(true);
            return;
        }
        this.fjB.startSync();
        this.fjA.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fjB.onDestroy();
        this.fjA.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fjB.aWF()) {
            this.fjB.aWG();
        } else if (view.getId() == this.fjB.aWH()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.fjB.apS();
            if (!this.fjA.qa(intValue)) {
                this.fjB.azg();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.fjA.aWT().size()) {
            this.fjC = i;
            MarkData markData = this.fjA.aWT().get(i);
            MarkData markData2 = this.fjD.get(i);
            int aWS = this.fjA.aWS();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.Dl().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().setMsgBookmark(0);
                }
                if (aWS > 0) {
                    this.fjA.pZ(aWS - 1);
                } else {
                    this.fjA.pZ(0);
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
        this.fjB.ak(this.fjD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                    if (markData != null && this.fjA.aWT().size() > this.fjC && this.fjC >= 0) {
                        this.fjA.aWT().get(this.fjC).setPostId(markData.getPostId());
                        this.fjA.aWT().get(this.fjC).setHostMode(markData.getHostMode());
                        this.fjA.aWT().get(this.fjC).setSequence(markData.getSequence());
                        this.fjB.aWJ();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.fjA.aWT().size() > this.fjC && this.fjC >= 0) {
                        this.fjA.aWT().remove(this.fjC);
                        this.fjB.aWJ();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aT(boolean z) {
        if (this.fjA != null && this.fjB != null) {
            this.fjA.reset();
            this.fjB.bR(true);
            this.fjA.e(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fjB != null && this.fjA != null && this.fjA.hasMore()) {
            this.fjB.startRefresh(this.fjA.getOffset());
            this.fjA.e(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.fjB != null && this.fjB.aoT()) {
            this.fjB.aWG();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
