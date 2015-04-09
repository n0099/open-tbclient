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
    private com.baidu.tieba.myCollection.baseEditMark.a bDV = null;
    private f bDW = null;
    private int bDX = -1;
    private ArrayList<MarkData> bDY = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bDV = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.bDV.a(new a(this, this));
        this.bDW = new f(this);
        this.bDW.a(new b(this));
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bDW.onChangeSkinType(i);
    }

    private void refresh() {
        if (this.bDV.getCount() == 0 || this.bDV.Ym() < 0) {
            this.bDV.e(true);
            return;
        }
        this.bDW.startSync();
        this.bDV.startSync();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bDW.onDestroy();
        this.bDV.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bDW.Yb()) {
            this.bDW.Yc();
        } else if (view.getId() == this.bDW.Yd()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.bDW.HS();
            if (!this.bDV.ha(intValue)) {
                this.bDW.Qw();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.bDV.Yj().size()) {
            this.bDX = i;
            MarkData markData = this.bDV.Yj().get(i);
            MarkData markData2 = this.bDY.get(i);
            int Yi = this.bDV.Yi();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.uZ().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.uZ().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.uZ().setMsgBookmark(0);
                }
                if (Yi > 0) {
                    this.bDV.gZ(Yi - 1);
                } else {
                    this.bDV.gZ(0);
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
        this.bDW.J(this.bDY);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra(PbActivityConfig.KEY_MARK);
                    if (markData != null && this.bDV.Yj().size() > this.bDX && this.bDX >= 0) {
                        this.bDV.Yj().get(this.bDX).setPostId(markData.getPostId());
                        this.bDV.Yj().get(this.bDX).setHostMode(markData.getHostMode());
                        this.bDV.Yj().get(this.bDX).setSequence(markData.getSequence());
                        this.bDW.Yf();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.bDV.Yj().size() > this.bDX && this.bDX >= 0) {
                        this.bDV.Yj().remove(this.bDX);
                        this.bDW.Yf();
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
        if (this.bDV != null && this.bDW != null) {
            this.bDV.reset();
            this.bDW.aV(true);
            this.bDV.e(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (this.bDW != null && this.bDV != null && this.bDV.hasMore()) {
            this.bDW.gY(this.bDV.getOffset());
            this.bDV.e(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.bDW != null && this.bDW.Hu()) {
            this.bDW.Yc();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
