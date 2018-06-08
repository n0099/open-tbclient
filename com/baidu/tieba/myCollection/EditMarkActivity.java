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
import com.baidu.tbadk.core.view.f;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes3.dex */
public class EditMarkActivity extends BaseActivity<EditMarkActivity> implements BdListView.e, f.b {
    private com.baidu.tieba.myCollection.baseEditMark.a ffw = null;
    private c ffx = null;
    private int ffy = -1;
    private ArrayList<MarkData> ffz = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ffw = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.ffw.a(new d() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.1
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        EditMarkActivity.this.ffx.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.ffx.a(r1, EditMarkActivity.this.ffw, ((Boolean) objArr[2]).booleanValue());
                        EditMarkActivity.this.ffz = EditMarkActivity.this.ffw.aXU();
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        EditMarkActivity.this.ffx.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r1 = (String) objArr[1];
                        }
                        EditMarkActivity.this.ffx.a(r1, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        EditMarkActivity.this.ffx.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            EditMarkActivity.this.ffx.startRefresh(EditMarkActivity.this.ffw.getOffset());
                            EditMarkActivity.this.ffw.d(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        EditMarkActivity.this.ffx.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, EditMarkActivity.this.ffw);
                    }
                } catch (Exception e) {
                    BdLog.d(e.getMessage());
                }
            }
        });
        this.ffx = new c(this);
        this.ffx.c(new a.b() { // from class: com.baidu.tieba.myCollection.EditMarkActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                EditMarkActivity.this.ffx.startRefresh(EditMarkActivity.this.ffw.getOffset());
                EditMarkActivity.this.ffw.d(true);
            }
        });
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ffx.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.ffw.getCount() == 0 || this.ffw.aXX() < 0) {
            this.ffw.d(true);
            return;
        }
        this.ffx.startSync();
        this.ffw.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ffx.onDestroy();
        this.ffw.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ffx.aXG()) {
            this.ffx.aXH();
        } else if (view.getId() == this.ffx.aXI()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.ffx.apX();
            if (!this.ffw.pW(intValue)) {
                this.ffx.axY();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.ffw.aXU().size()) {
            this.ffy = i;
            MarkData markData = this.ffw.aXU().get(i);
            MarkData markData2 = this.ffz.get(i);
            int aXT = this.ffw.aXT();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.CX().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.CX().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.CX().setMsgBookmark(0);
                }
                if (aXT > 0) {
                    this.ffw.pV(aXT - 1);
                } else {
                    this.ffw.pV(0);
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
        this.ffx.ai(this.ffz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                    if (markData != null && this.ffw.aXU().size() > this.ffy && this.ffy >= 0) {
                        this.ffw.aXU().get(this.ffy).setPostId(markData.getPostId());
                        this.ffw.aXU().get(this.ffy).setHostMode(markData.getHostMode());
                        this.ffw.aXU().get(this.ffy).setSequence(markData.getSequence());
                        this.ffx.aXK();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.ffw.aXU().size() > this.ffy && this.ffy >= 0) {
                        this.ffw.aXU().remove(this.ffy);
                        this.ffx.aXK();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.f.b
    public void aS(boolean z) {
        if (this.ffw != null && this.ffx != null) {
            this.ffw.reset();
            this.ffx.bP(true);
            this.ffw.d(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.ffx != null && this.ffw != null && this.ffw.hasMore()) {
            this.ffx.startRefresh(this.ffw.getOffset());
            this.ffw.d(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.ffx != null && this.ffx.aoY()) {
            this.ffx.aXH();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
