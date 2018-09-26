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
    private com.baidu.tieba.myCollection.baseEditMark.a fqW = null;
    private c fqX = null;
    private int fqY = -1;
    private ArrayList<MarkData> fqZ = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fqW = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.fqW.a(new d() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.1
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        EditMarkActivity.this.fqX.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.fqX.a(r1, EditMarkActivity.this.fqW, ((Boolean) objArr[2]).booleanValue());
                        EditMarkActivity.this.fqZ = EditMarkActivity.this.fqW.aZg();
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        EditMarkActivity.this.fqX.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.fqX.a(r1, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        EditMarkActivity.this.fqX.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            EditMarkActivity.this.fqX.startRefresh(EditMarkActivity.this.fqW.getOffset());
                            EditMarkActivity.this.fqW.e(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        EditMarkActivity.this.fqX.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, EditMarkActivity.this.fqW);
                    }
                } catch (Exception e) {
                    BdLog.d(e.getMessage());
                }
            }
        });
        this.fqX = new c(this);
        this.fqX.c(new a.b() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                EditMarkActivity.this.fqX.startRefresh(EditMarkActivity.this.fqW.getOffset());
                EditMarkActivity.this.fqW.e(true);
            }
        });
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fqX.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.fqW.getCount() == 0 || this.fqW.aZj() < 0) {
            this.fqW.e(true);
            return;
        }
        this.fqX.startSync();
        this.fqW.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fqX.onDestroy();
        this.fqW.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fqX.aYS()) {
            this.fqX.aYT();
        } else if (view.getId() == this.fqX.aYU()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.fqX.arG();
            if (!this.fqW.qE(intValue)) {
                this.fqX.aBo();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.fqW.aZg().size()) {
            this.fqY = i;
            MarkData markData = this.fqW.aZg().get(i);
            MarkData markData2 = this.fqZ.get(i);
            int aZf = this.fqW.aZf();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.Ey().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Ey().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Ey().setMsgBookmark(0);
                }
                if (aZf > 0) {
                    this.fqW.qD(aZf - 1);
                } else {
                    this.fqW.qD(0);
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
        this.fqX.ak(this.fqZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                    if (markData != null && this.fqW.aZg().size() > this.fqY && this.fqY >= 0) {
                        this.fqW.aZg().get(this.fqY).setPostId(markData.getPostId());
                        this.fqW.aZg().get(this.fqY).setHostMode(markData.getHostMode());
                        this.fqW.aZg().get(this.fqY).setSequence(markData.getSequence());
                        this.fqX.aYW();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.fqW.aZg().size() > this.fqY && this.fqY >= 0) {
                        this.fqW.aZg().remove(this.fqY);
                        this.fqX.aYW();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bf(boolean z) {
        if (this.fqW != null && this.fqX != null) {
            this.fqW.reset();
            this.fqX.cd(true);
            this.fqW.e(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fqX != null && this.fqW != null && this.fqW.hasMore()) {
            this.fqX.startRefresh(this.fqW.getOffset());
            this.fqW.e(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.fqX != null && this.fqX.aqI()) {
            this.fqX.aYT();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
