package com.baidu.tieba.myCollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s extends com.baidu.tbadk.c.b implements View.OnClickListener, BdListView.e, r.a {
    private ArrayList<MarkData> cEK;
    private com.baidu.tieba.myCollection.baseEditMark.a cEH = null;
    private x cFd = null;
    private int cEJ = -1;
    private final CustomMessageListener MF = new t(this, 2000994);

    public static final s ano() {
        return new s();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        anp();
        registerListener(this.MF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(t.h.edit_mark_activity, (ViewGroup) null);
        this.cEH = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.cFd = new x(this, inflate);
        this.cFd.d(new u(this));
        this.cEH.a(new v(this));
        refresh();
        return inflate;
    }

    private void refresh() {
        if (this.cEH.getCount() == 0 || this.cEH.anu() < 0) {
            this.cFd.kA(this.cEH.getOffset());
            return;
        }
        this.cFd.startSync();
        this.cEH.startSync();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cFd != null) {
            this.cFd.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cFd != null) {
            this.cFd.S(this.cEK);
            this.SQ = (this.cEK == null || this.cEK.isEmpty()) ? false : true;
            aZ(1);
        }
    }

    @Override // com.baidu.tbadk.c.b, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cFd.ajv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cFd.onDestroy();
        this.cEH.onDestroy();
    }

    private void anp() {
        registerListener(new w(this, CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.cFd.anj()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.cFd.Nj();
            if (!this.cEH.kC(intValue)) {
                this.cFd.Rh();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.cEH.anr().size()) {
            this.cEJ = i;
            MarkData markData = this.cEH.anr().get(i);
            MarkData markData2 = this.cEK.get(i);
            int anq = this.cEH.anq();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.yN().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgBookmark(0);
                }
                if (anq > 0) {
                    this.cEH.kB(anq - 1);
                } else {
                    this.cEH.kB(0);
                }
            }
            markData2.setNewCounts(0);
            if (markData != null) {
                if (markData.isPhotoLiveThread()) {
                    TiebaStatic.log("c10252");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), markData.getThreadId()).bD(17001).cm(markData.getPostId()).co("from_mark").rC()));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
                }
            }
        }
        super.onItemClick(adapterView, view, i, j);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (17001 == i) {
                MarkData markData = (MarkData) intent.getSerializableExtra(PbActivityConfig.KEY_MARK);
                if (this.cEH != null && markData != null && this.cFd != null && com.baidu.tbadk.core.util.x.o(this.cEH.anr()) > this.cEJ && this.cEJ >= 0) {
                    this.cEH.anr().get(this.cEJ).setPostId(markData.getPostId());
                    this.cEH.anr().get(this.cEJ).setHostMode(markData.getHostMode());
                    this.cEH.anr().get(this.cEJ).setSequence(markData.getSequence());
                    this.cFd.anl();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.cEH != null && this.cFd != null && com.baidu.tbadk.core.util.x.o(this.cEH.anr()) > this.cEJ && this.cEJ >= 0) {
            this.cEH.anr().remove(this.cEJ);
            this.cFd.anl();
        }
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void az(boolean z) {
        if (this.cEH != null && this.cFd != null) {
            this.cEH.reset();
            this.cFd.bw(true);
            this.cEH.f(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nv() {
        if (this.cFd != null && this.cEH != null && this.cEH.hasMore()) {
            this.cFd.kA(this.cEH.getOffset());
            this.cEH.f(false);
        }
    }

    @Override // com.baidu.tbadk.c.b
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.c.b
    public boolean qP() {
        return this.cEK == null || this.cEK.isEmpty();
    }
}
