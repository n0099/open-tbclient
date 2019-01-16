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
    private com.baidu.tieba.myCollection.baseEditMark.a fKB = null;
    private c fKC = null;
    private int fKD = -1;
    private ArrayList<MarkData> fKE = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fKB = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.fKB.a(new d() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.1
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        EditMarkActivity.this.fKC.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.fKC.a(r1, EditMarkActivity.this.fKB, ((Boolean) objArr[2]).booleanValue());
                        EditMarkActivity.this.fKE = EditMarkActivity.this.fKB.beT();
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        EditMarkActivity.this.fKC.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.fKC.a(r1, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        EditMarkActivity.this.fKC.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            EditMarkActivity.this.fKC.startRefresh(EditMarkActivity.this.fKB.getOffset());
                            EditMarkActivity.this.fKB.e(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        EditMarkActivity.this.fKC.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, EditMarkActivity.this.fKB);
                    }
                } catch (Exception e) {
                    BdLog.d(e.getMessage());
                }
            }
        });
        this.fKC = new c(this);
        this.fKC.c(new a.b() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                EditMarkActivity.this.fKC.startRefresh(EditMarkActivity.this.fKB.getOffset());
                EditMarkActivity.this.fKB.e(true);
            }
        });
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fKC.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.fKB.getCount() == 0 || this.fKB.beW() < 0) {
            this.fKB.e(true);
            return;
        }
        this.fKC.startSync();
        this.fKB.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fKC.onDestroy();
        this.fKB.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fKC.beH()) {
            this.fKC.beI();
        } else if (view.getId() == this.fKC.beJ()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.fKC.axy();
            if (!this.fKB.se(intValue)) {
                this.fKC.aHb();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.fKB.beT().size()) {
            this.fKD = i;
            MarkData markData = this.fKB.beT().get(i);
            MarkData markData2 = this.fKE.get(i);
            int beS = this.fKB.beS();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.If().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.If().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.If().setMsgBookmark(0);
                }
                if (beS > 0) {
                    this.fKB.sd(beS - 1);
                } else {
                    this.fKB.sd(0);
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
        this.fKC.aj(this.fKE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                    if (markData != null && this.fKB.beT().size() > this.fKD && this.fKD >= 0) {
                        this.fKB.beT().get(this.fKD).setPostId(markData.getPostId());
                        this.fKB.beT().get(this.fKD).setHostMode(markData.getHostMode());
                        this.fKB.beT().get(this.fKD).setSequence(markData.getSequence());
                        this.fKC.beL();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.fKB.beT().size() > this.fKD && this.fKD >= 0) {
                        this.fKB.beT().remove(this.fKD);
                        this.fKC.beL();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bI(boolean z) {
        if (this.fKB != null && this.fKC != null) {
            this.fKB.reset();
            this.fKC.cH(true);
            this.fKB.e(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fKC != null && this.fKB != null && this.fKB.hasMore()) {
            this.fKC.startRefresh(this.fKB.getOffset());
            this.fKB.e(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.fKC != null && this.fKC.awC()) {
            this.fKC.beI();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
