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
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.b.b implements View.OnClickListener, BdListView.e, p.a {
    private ArrayList<MarkData> cbq;
    private com.baidu.tieba.myCollection.baseEditMark.a cbn = null;
    private u cbJ = null;
    private int cbp = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new q(this, 2000994);

    public static final p adz() {
        return new p();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerNavigationBarEditStateListener();
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(i.g.edit_mark_activity, (ViewGroup) null);
        this.cbn = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.cbJ = new u(this, inflate);
        this.cbJ.b(new r(this));
        this.cbn.a(new s(this));
        refresh();
        return inflate;
    }

    private void refresh() {
        if (this.cbn.getCount() == 0 || this.cbn.adF() < 0) {
            this.cbJ.iy(this.cbn.getOffset());
            return;
        }
        this.cbJ.startSync();
        this.cbn.startSync();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cbJ.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.cbJ.M(this.cbq);
        this.mIsEnableEdit = (this.cbq == null || this.cbq.isEmpty()) ? false : true;
        sendEditEnableMessage(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cbJ.adA();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cbJ.onDestroy();
        this.cbn.onDestroy();
    }

    private void registerNavigationBarEditStateListener() {
        registerListener(new t(this, CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.cbJ.adt()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.cbJ.Jq();
            if (!this.cbn.iA(intValue)) {
                this.cbJ.MW();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.cbn.adC().size()) {
            this.cbp = i;
            MarkData markData = this.cbn.adC().get(i);
            MarkData markData2 = this.cbq.get(i);
            int adB = this.cbn.adB();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.wK().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wK().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wK().setMsgBookmark(0);
                }
                if (adB > 0) {
                    this.cbn.iz(adB - 1);
                } else {
                    this.cbn.iz(0);
                }
            }
            markData2.setNewCounts(0);
            if (markData != null) {
                if (markData.isPhotoLiveThread()) {
                    TiebaStatic.log("c10252");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), markData.getThreadId()).bs(17001).cf(markData.getPostId()).ch("from_mark").rk()));
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
                    if (markData != null && this.cbn.adC().size() > this.cbp && this.cbp >= 0) {
                        this.cbn.adC().get(this.cbp).setPostId(markData.getPostId());
                        this.cbn.adC().get(this.cbp).setHostMode(markData.getHostMode());
                        this.cbn.adC().get(this.cbp).setSequence(markData.getSequence());
                        this.cbJ.adv();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.cbn.adC().size() > this.cbp && this.cbp >= 0) {
                        this.cbn.adC().remove(this.cbp);
                        this.cbJ.adv();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        if (this.cbn != null && this.cbJ != null) {
            this.cbn.reset();
            this.cbJ.bj(true);
            this.cbn.f(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cbJ != null && this.cbn != null && this.cbn.hasMore()) {
            this.cbJ.iy(this.cbn.getOffset());
            this.cbn.f(false);
        }
    }

    @Override // com.baidu.tbadk.b.b
    public int getType() {
        return 1;
    }
}
