package com.baidu.tieba.myCollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ae;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EditMarkActivity extends BaseActivity<EditMarkActivity> implements x, ae {
    private com.baidu.tieba.myCollection.baseEditMark.a bDI = null;
    private f bDJ = null;
    private int bDK = -1;
    private ArrayList<MarkData> bDL = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bDI = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.bDI.a(new a(this, this));
        this.bDJ = new f(this);
        this.bDJ.a(new b(this));
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bDJ.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.bDI.getCount() == 0 || this.bDI.Ya() < 0) {
            this.bDI.e(true);
            return;
        }
        this.bDJ.startSync();
        this.bDI.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bDJ.onDestroy();
        this.bDI.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bDJ.XP()) {
            this.bDJ.XQ();
        } else if (view.getId() == this.bDJ.XR()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.bDJ.HM();
            if (!this.bDI.gY(intValue)) {
                this.bDJ.Qj();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.bDI.XX().size()) {
            this.bDK = i;
            MarkData markData = this.bDI.XX().get(i);
            MarkData markData2 = this.bDL.get(i);
            int XW = this.bDI.XW();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.uT().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.uT().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.uT().setMsgBookmark(0);
                }
                if (XW > 0) {
                    this.bDI.gX(XW - 1);
                } else {
                    this.bDI.gX(0);
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
        this.bDJ.H(this.bDL);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra(PbActivityConfig.KEY_MARK);
                    if (markData != null && this.bDI.XX().size() > this.bDK && this.bDK >= 0) {
                        this.bDI.XX().get(this.bDK).setPostId(markData.getPostId());
                        this.bDI.XX().get(this.bDK).setHostMode(markData.getHostMode());
                        this.bDI.XX().get(this.bDK).setSequence(markData.getSequence());
                        this.bDJ.XT();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.bDI.XX().size() > this.bDK && this.bDK >= 0) {
                        this.bDI.XX().remove(this.bDK);
                        this.bDJ.XT();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        if (this.bDI != null && this.bDJ != null) {
            this.bDI.reset();
            this.bDJ.aV(true);
            this.bDI.e(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (this.bDJ != null && this.bDI != null && this.bDI.hasMore()) {
            this.bDJ.gW(this.bDI.getOffset());
            this.bDI.e(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.bDJ != null && this.bDJ.Ho()) {
            this.bDJ.XQ();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
