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
    private com.baidu.tieba.myCollection.baseEditMark.a fju = null;
    private c fjv = null;
    private int fjw = -1;
    private ArrayList<MarkData> fjx = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fju = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.fju.a(new d() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.1
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        EditMarkActivity.this.fjv.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.fjv.a(r1, EditMarkActivity.this.fju, ((Boolean) objArr[2]).booleanValue());
                        EditMarkActivity.this.fjx = EditMarkActivity.this.fju.aYB();
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        EditMarkActivity.this.fjv.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.fjv.a(r1, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        EditMarkActivity.this.fjv.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            EditMarkActivity.this.fjv.startRefresh(EditMarkActivity.this.fju.getOffset());
                            EditMarkActivity.this.fju.d(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        EditMarkActivity.this.fjv.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, EditMarkActivity.this.fju);
                    }
                } catch (Exception e) {
                    BdLog.d(e.getMessage());
                }
            }
        });
        this.fjv = new c(this);
        this.fjv.c(new a.b() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                EditMarkActivity.this.fjv.startRefresh(EditMarkActivity.this.fju.getOffset());
                EditMarkActivity.this.fju.d(true);
            }
        });
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fjv.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.fju.getCount() == 0 || this.fju.aYE() < 0) {
            this.fju.d(true);
            return;
        }
        this.fjv.startSync();
        this.fju.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fjv.onDestroy();
        this.fju.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fjv.aYn()) {
            this.fjv.aYo();
        } else if (view.getId() == this.fjv.aYp()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.fjv.aps();
            if (!this.fju.qd(intValue)) {
                this.fjv.ayD();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.fju.aYB().size()) {
            this.fjw = i;
            MarkData markData = this.fju.aYB().get(i);
            MarkData markData2 = this.fjx.get(i);
            int aYA = this.fju.aYA();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.Dp().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dp().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dp().setMsgBookmark(0);
                }
                if (aYA > 0) {
                    this.fju.qc(aYA - 1);
                } else {
                    this.fju.qc(0);
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
        this.fjv.am(this.fjx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                    if (markData != null && this.fju.aYB().size() > this.fjw && this.fjw >= 0) {
                        this.fju.aYB().get(this.fjw).setPostId(markData.getPostId());
                        this.fju.aYB().get(this.fjw).setHostMode(markData.getHostMode());
                        this.fju.aYB().get(this.fjw).setSequence(markData.getSequence());
                        this.fjv.aYr();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.fju.aYB().size() > this.fjw && this.fjw >= 0) {
                        this.fju.aYB().remove(this.fjw);
                        this.fjv.aYr();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aU(boolean z) {
        if (this.fju != null && this.fjv != null) {
            this.fju.reset();
            this.fjv.bS(true);
            this.fju.d(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fjv != null && this.fju != null && this.fju.hasMore()) {
            this.fjv.startRefresh(this.fju.getOffset());
            this.fju.d(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.fjv != null && this.fjv.aot()) {
            this.fjv.aYo();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
