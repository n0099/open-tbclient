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
    private com.baidu.tieba.myCollection.baseEditMark.a fGP = null;
    private c fGQ = null;
    private int fGR = -1;
    private ArrayList<MarkData> fGS = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fGP = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.fGP.a(new d() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.1
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        EditMarkActivity.this.fGQ.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.fGQ.a(r1, EditMarkActivity.this.fGP, ((Boolean) objArr[2]).booleanValue());
                        EditMarkActivity.this.fGS = EditMarkActivity.this.fGP.bdH();
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        EditMarkActivity.this.fGQ.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.fGQ.a(r1, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        EditMarkActivity.this.fGQ.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            EditMarkActivity.this.fGQ.startRefresh(EditMarkActivity.this.fGP.getOffset());
                            EditMarkActivity.this.fGP.e(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        EditMarkActivity.this.fGQ.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, EditMarkActivity.this.fGP);
                    }
                } catch (Exception e) {
                    BdLog.d(e.getMessage());
                }
            }
        });
        this.fGQ = new c(this);
        this.fGQ.c(new a.b() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                EditMarkActivity.this.fGQ.startRefresh(EditMarkActivity.this.fGP.getOffset());
                EditMarkActivity.this.fGP.e(true);
            }
        });
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fGQ.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.fGP.getCount() == 0 || this.fGP.bdK() < 0) {
            this.fGP.e(true);
            return;
        }
        this.fGQ.startSync();
        this.fGP.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fGQ.onDestroy();
        this.fGP.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fGQ.bdt()) {
            this.fGQ.bdu();
        } else if (view.getId() == this.fGQ.bdv()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.fGQ.awm();
            if (!this.fGP.rP(intValue)) {
                this.fGQ.aFP();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.fGP.bdH().size()) {
            this.fGR = i;
            MarkData markData = this.fGP.bdH().get(i);
            MarkData markData2 = this.fGS.get(i);
            int bdG = this.fGP.bdG();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.HP().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.HP().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.HP().setMsgBookmark(0);
                }
                if (bdG > 0) {
                    this.fGP.rO(bdG - 1);
                } else {
                    this.fGP.rO(0);
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
        this.fGQ.aj(this.fGS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                    if (markData != null && this.fGP.bdH().size() > this.fGR && this.fGR >= 0) {
                        this.fGP.bdH().get(this.fGR).setPostId(markData.getPostId());
                        this.fGP.bdH().get(this.fGR).setHostMode(markData.getHostMode());
                        this.fGP.bdH().get(this.fGR).setSequence(markData.getSequence());
                        this.fGQ.bdx();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.fGP.bdH().size() > this.fGR && this.fGR >= 0) {
                        this.fGP.bdH().remove(this.fGR);
                        this.fGQ.bdx();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bH(boolean z) {
        if (this.fGP != null && this.fGQ != null) {
            this.fGP.reset();
            this.fGQ.cE(true);
            this.fGP.e(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fGQ != null && this.fGP != null && this.fGP.hasMore()) {
            this.fGQ.startRefresh(this.fGP.getOffset());
            this.fGP.e(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.fGQ != null && this.fGQ.avq()) {
            this.fGQ.bdu();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
