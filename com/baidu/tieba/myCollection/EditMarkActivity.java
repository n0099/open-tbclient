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
    private com.baidu.tieba.myCollection.baseEditMark.a fyl = null;
    private c fym = null;
    private int fyn = -1;
    private ArrayList<MarkData> fyo = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fyl = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.fyl.a(new d() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.1
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        EditMarkActivity.this.fym.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.fym.a(r1, EditMarkActivity.this.fyl, ((Boolean) objArr[2]).booleanValue());
                        EditMarkActivity.this.fyo = EditMarkActivity.this.fyl.aYd();
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        EditMarkActivity.this.fym.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.fym.a(r1, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        EditMarkActivity.this.fym.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            EditMarkActivity.this.fym.startRefresh(EditMarkActivity.this.fyl.getOffset());
                            EditMarkActivity.this.fyl.d(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        EditMarkActivity.this.fym.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, EditMarkActivity.this.fyl);
                    }
                } catch (Exception e) {
                    BdLog.d(e.getMessage());
                }
            }
        });
        this.fym = new c(this);
        this.fym.c(new a.b() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                EditMarkActivity.this.fym.startRefresh(EditMarkActivity.this.fyl.getOffset());
                EditMarkActivity.this.fyl.d(true);
            }
        });
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fym.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.fyl.getCount() == 0 || this.fyl.aYg() < 0) {
            this.fyl.d(true);
            return;
        }
        this.fym.startSync();
        this.fyl.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fym.onDestroy();
        this.fyl.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fym.aXP()) {
            this.fym.aXQ();
        } else if (view.getId() == this.fym.aXR()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.fym.arB();
            if (!this.fyl.sq(intValue)) {
                this.fym.aIH();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.fyl.aYd().size()) {
            this.fyn = i;
            MarkData markData = this.fyl.aYd().get(i);
            MarkData markData2 = this.fyo.get(i);
            int aYc = this.fyl.aYc();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.GJ().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.GJ().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.GJ().setMsgBookmark(0);
                }
                if (aYc > 0) {
                    this.fyl.sp(aYc - 1);
                } else {
                    this.fyl.sp(0);
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
        this.fym.ah(this.fyo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                    if (markData != null && this.fyl.aYd().size() > this.fyn && this.fyn >= 0) {
                        this.fyl.aYd().get(this.fyn).setPostId(markData.getPostId());
                        this.fyl.aYd().get(this.fyn).setHostMode(markData.getHostMode());
                        this.fyl.aYd().get(this.fyn).setSequence(markData.getSequence());
                        this.fym.aXT();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.fyl.aYd().size() > this.fyn && this.fyn >= 0) {
                        this.fyl.aYd().remove(this.fyn);
                        this.fym.aXT();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bw(boolean z) {
        if (this.fyl != null && this.fym != null) {
            this.fyl.reset();
            this.fym.ct(true);
            this.fyl.d(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fym != null && this.fyl != null && this.fyl.hasMore()) {
            this.fym.startRefresh(this.fyl.getOffset());
            this.fyl.d(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.fym != null && this.fym.aqI()) {
            this.fym.aXQ();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
