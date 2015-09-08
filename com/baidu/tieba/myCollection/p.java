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
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.b.b implements View.OnClickListener, BdListView.e, x.a {
    private ArrayList<MarkData> bXE;
    private com.baidu.tieba.myCollection.baseEditMark.a bXB = null;
    private u bXX = null;
    private int bXD = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new q(this, 2000994);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerNavigationBarEditStateListener();
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(i.g.edit_mark_activity, (ViewGroup) null);
        this.bXB = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.bXX = new u(this, inflate);
        this.bXX.b(new r(this));
        this.bXB.a(new s(this));
        refresh();
        return inflate;
    }

    private void refresh() {
        if (this.bXB.getCount() == 0 || this.bXB.acm() < 0) {
            this.bXB.f(true);
            return;
        }
        this.bXX.startSync();
        this.bXB.startSync();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bXX.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bXX.M(this.bXE);
        this.mIsEnableEdit = (this.bXE == null || this.bXE.isEmpty()) ? false : true;
        sendEditEnableMessage(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.bXX.ach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.bXX.onDestroy();
        this.bXB.onDestroy();
    }

    private void registerNavigationBarEditStateListener() {
        registerListener(new t(this, CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.bXX.acb()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.bXX.Jv();
            if (!this.bXB.is(intValue)) {
                this.bXX.MX();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.bXB.acj().size()) {
            this.bXD = i;
            MarkData markData = this.bXB.acj().get(i);
            MarkData markData2 = this.bXE.get(i);
            int aci = this.bXB.aci();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.wZ().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgBookmark(0);
                }
                if (aci > 0) {
                    this.bXB.ir(aci - 1);
                } else {
                    this.bXB.ir(0);
                }
            }
            markData2.setNewCounts(0);
            if (markData != null) {
                if (markData.isPhotoLiveThread()) {
                    TiebaStatic.log("c10252");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), markData.getThreadId()).bs(17001).cf(markData.getPostId()).ch("from_mark").ro()));
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
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra(PbActivityConfig.KEY_MARK);
                    if (markData != null && this.bXB.acj().size() > this.bXD && this.bXD >= 0) {
                        this.bXB.acj().get(this.bXD).setPostId(markData.getPostId());
                        this.bXB.acj().get(this.bXD).setHostMode(markData.getHostMode());
                        this.bXB.acj().get(this.bXD).setSequence(markData.getSequence());
                        this.bXX.acd();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.bXB.acj().size() > this.bXD && this.bXD >= 0) {
                        this.bXB.acj().remove(this.bXD);
                        this.bXX.acd();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        if (this.bXB != null && this.bXX != null) {
            this.bXB.reset();
            this.bXX.bl(true);
            this.bXB.f(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.bXX != null && this.bXB != null && this.bXB.hasMore()) {
            this.bXX.iq(this.bXB.getOffset());
            this.bXB.f(false);
        }
    }

    @Override // com.baidu.tbadk.b.b
    public int getType() {
        return 1;
    }
}
