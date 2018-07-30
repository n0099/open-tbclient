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
    private com.baidu.tieba.myCollection.baseEditMark.a fjG = null;
    private c fjH = null;
    private int fjI = -1;
    private ArrayList<MarkData> fjJ = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fjG = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.fjG.a(new d() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.1
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        EditMarkActivity.this.fjH.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.fjH.a(r1, EditMarkActivity.this.fjG, ((Boolean) objArr[2]).booleanValue());
                        EditMarkActivity.this.fjJ = EditMarkActivity.this.fjG.aWX();
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        EditMarkActivity.this.fjH.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.fjH.a(r1, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        EditMarkActivity.this.fjH.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            EditMarkActivity.this.fjH.startRefresh(EditMarkActivity.this.fjG.getOffset());
                            EditMarkActivity.this.fjG.e(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        EditMarkActivity.this.fjH.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, EditMarkActivity.this.fjG);
                    }
                } catch (Exception e) {
                    BdLog.d(e.getMessage());
                }
            }
        });
        this.fjH = new c(this);
        this.fjH.c(new a.b() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                EditMarkActivity.this.fjH.startRefresh(EditMarkActivity.this.fjG.getOffset());
                EditMarkActivity.this.fjG.e(true);
            }
        });
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fjH.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.fjG.getCount() == 0 || this.fjG.aXa() < 0) {
            this.fjG.e(true);
            return;
        }
        this.fjH.startSync();
        this.fjG.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fjH.onDestroy();
        this.fjG.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fjH.aWJ()) {
            this.fjH.aWK();
        } else if (view.getId() == this.fjH.aWL()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.fjH.apS();
            if (!this.fjG.qa(intValue)) {
                this.fjH.azi();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.fjG.aWX().size()) {
            this.fjI = i;
            MarkData markData = this.fjG.aWX().get(i);
            MarkData markData2 = this.fjJ.get(i);
            int aWW = this.fjG.aWW();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.Dl().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().setMsgBookmark(0);
                }
                if (aWW > 0) {
                    this.fjG.pZ(aWW - 1);
                } else {
                    this.fjG.pZ(0);
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
        this.fjH.ak(this.fjJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                    if (markData != null && this.fjG.aWX().size() > this.fjI && this.fjI >= 0) {
                        this.fjG.aWX().get(this.fjI).setPostId(markData.getPostId());
                        this.fjG.aWX().get(this.fjI).setHostMode(markData.getHostMode());
                        this.fjG.aWX().get(this.fjI).setSequence(markData.getSequence());
                        this.fjH.aWN();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.fjG.aWX().size() > this.fjI && this.fjI >= 0) {
                        this.fjG.aWX().remove(this.fjI);
                        this.fjH.aWN();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aS(boolean z) {
        if (this.fjG != null && this.fjH != null) {
            this.fjG.reset();
            this.fjH.bQ(true);
            this.fjG.e(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fjH != null && this.fjG != null && this.fjG.hasMore()) {
            this.fjH.startRefresh(this.fjG.getOffset());
            this.fjG.e(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.fjH != null && this.fjH.aoT()) {
            this.fjH.aWK();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
