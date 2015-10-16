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
    private ArrayList<MarkData> cbB;
    private com.baidu.tieba.myCollection.baseEditMark.a cby = null;
    private u cbU = null;
    private int cbA = -1;
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
        this.cby = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.cbU = new u(this, inflate);
        this.cbU.b(new r(this));
        this.cby.a(new s(this));
        refresh();
        return inflate;
    }

    private void refresh() {
        if (this.cby.getCount() == 0 || this.cby.adF() < 0) {
            this.cbU.iy(this.cby.getOffset());
            return;
        }
        this.cbU.startSync();
        this.cby.startSync();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cbU.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.cbU.M(this.cbB);
        this.mIsEnableEdit = (this.cbB == null || this.cbB.isEmpty()) ? false : true;
        sendEditEnableMessage(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cbU.adA();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cbU.onDestroy();
        this.cby.onDestroy();
    }

    private void registerNavigationBarEditStateListener() {
        registerListener(new t(this, CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.cbU.adt()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.cbU.Jq();
            if (!this.cby.iA(intValue)) {
                this.cbU.MW();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.cby.adC().size()) {
            this.cbA = i;
            MarkData markData = this.cby.adC().get(i);
            MarkData markData2 = this.cbB.get(i);
            int adB = this.cby.adB();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.wK().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wK().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wK().setMsgBookmark(0);
                }
                if (adB > 0) {
                    this.cby.iz(adB - 1);
                } else {
                    this.cby.iz(0);
                }
            }
            markData2.setNewCounts(0);
            if (markData != null) {
                if (markData.isPhotoLiveThread()) {
                    TiebaStatic.log("c10252");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), markData.getThreadId()).bs(17001).cg(markData.getPostId()).ci("from_mark").rk()));
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
                    if (markData != null && this.cby.adC().size() > this.cbA && this.cbA >= 0) {
                        this.cby.adC().get(this.cbA).setPostId(markData.getPostId());
                        this.cby.adC().get(this.cbA).setHostMode(markData.getHostMode());
                        this.cby.adC().get(this.cbA).setSequence(markData.getSequence());
                        this.cbU.adv();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.cby.adC().size() > this.cbA && this.cbA >= 0) {
                        this.cby.adC().remove(this.cbA);
                        this.cbU.adv();
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
        if (this.cby != null && this.cbU != null) {
            this.cby.reset();
            this.cbU.bj(true);
            this.cby.f(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cbU != null && this.cby != null && this.cby.hasMore()) {
            this.cbU.iy(this.cby.getOffset());
            this.cby.f(false);
        }
    }

    @Override // com.baidu.tbadk.b.b
    public int getType() {
        return 1;
    }
}
