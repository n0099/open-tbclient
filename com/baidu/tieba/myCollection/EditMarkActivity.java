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
    private com.baidu.tieba.myCollection.baseEditMark.a fyC = null;
    private c fyD = null;
    private int fyE = -1;
    private ArrayList<MarkData> fyF = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fyC = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.fyC.a(new d() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.1
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        EditMarkActivity.this.fyD.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.fyD.a(r1, EditMarkActivity.this.fyC, ((Boolean) objArr[2]).booleanValue());
                        EditMarkActivity.this.fyF = EditMarkActivity.this.fyC.bcs();
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        EditMarkActivity.this.fyD.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.fyD.a(r1, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        EditMarkActivity.this.fyD.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            EditMarkActivity.this.fyD.startRefresh(EditMarkActivity.this.fyC.getOffset());
                            EditMarkActivity.this.fyC.e(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        EditMarkActivity.this.fyD.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, EditMarkActivity.this.fyC);
                    }
                } catch (Exception e) {
                    BdLog.d(e.getMessage());
                }
            }
        });
        this.fyD = new c(this);
        this.fyD.c(new a.b() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                EditMarkActivity.this.fyD.startRefresh(EditMarkActivity.this.fyC.getOffset());
                EditMarkActivity.this.fyC.e(true);
            }
        });
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fyD.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.fyC.getCount() == 0 || this.fyC.bcv() < 0) {
            this.fyC.e(true);
            return;
        }
        this.fyD.startSync();
        this.fyC.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fyD.onDestroy();
        this.fyC.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fyD.bce()) {
            this.fyD.bcf();
        } else if (view.getId() == this.fyD.bcg()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.fyD.avd();
            if (!this.fyC.rc(intValue)) {
                this.fyD.aEH();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.fyC.bcs().size()) {
            this.fyE = i;
            MarkData markData = this.fyC.bcs().get(i);
            MarkData markData2 = this.fyF.get(i);
            int bcr = this.fyC.bcr();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.Gz().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gz().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gz().setMsgBookmark(0);
                }
                if (bcr > 0) {
                    this.fyC.rb(bcr - 1);
                } else {
                    this.fyC.rb(0);
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
        this.fyD.ak(this.fyF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                    if (markData != null && this.fyC.bcs().size() > this.fyE && this.fyE >= 0) {
                        this.fyC.bcs().get(this.fyE).setPostId(markData.getPostId());
                        this.fyC.bcs().get(this.fyE).setHostMode(markData.getHostMode());
                        this.fyC.bcs().get(this.fyE).setSequence(markData.getSequence());
                        this.fyD.bci();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.fyC.bcs().size() > this.fyE && this.fyE >= 0) {
                        this.fyC.bcs().remove(this.fyE);
                        this.fyD.bci();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bp(boolean z) {
        if (this.fyC != null && this.fyD != null) {
            this.fyC.reset();
            this.fyD.cm(true);
            this.fyC.e(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fyD != null && this.fyC != null && this.fyC.hasMore()) {
            this.fyD.startRefresh(this.fyC.getOffset());
            this.fyC.e(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.fyD != null && this.fyD.auf()) {
            this.fyD.bcf();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
