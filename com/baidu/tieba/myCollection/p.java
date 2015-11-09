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
    private ArrayList<MarkData> ccc;
    private com.baidu.tieba.myCollection.baseEditMark.a cbZ = null;
    private u ccv = null;
    private int ccb = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new q(this, 2000994);

    public static final p adQ() {
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
        this.cbZ = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.ccv = new u(this, inflate);
        this.ccv.b(new r(this));
        this.cbZ.a(new s(this));
        refresh();
        return inflate;
    }

    private void refresh() {
        if (this.cbZ.getCount() == 0 || this.cbZ.adW() < 0) {
            this.ccv.iL(this.cbZ.getOffset());
            return;
        }
        this.ccv.startSync();
        this.cbZ.startSync();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ccv.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.ccv.M(this.ccc);
        this.mIsEnableEdit = (this.ccc == null || this.ccc.isEmpty()) ? false : true;
        sendEditEnableMessage(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.ccv.adR();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.ccv.onDestroy();
        this.cbZ.onDestroy();
    }

    private void registerNavigationBarEditStateListener() {
        registerListener(new t(this, CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.ccv.adK()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.ccv.JC();
            if (!this.cbZ.iN(intValue)) {
                this.ccv.Nk();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.cbZ.adT().size()) {
            this.ccb = i;
            MarkData markData = this.cbZ.adT().get(i);
            MarkData markData2 = this.ccc.get(i);
            int adS = this.cbZ.adS();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.wM().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgBookmark(0);
                }
                if (adS > 0) {
                    this.cbZ.iM(adS - 1);
                } else {
                    this.cbZ.iM(0);
                }
            }
            markData2.setNewCounts(0);
            if (markData != null) {
                if (markData.isPhotoLiveThread()) {
                    TiebaStatic.log("c10252");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), markData.getThreadId()).bs(17001).ce(markData.getPostId()).cg("from_mark").ri()));
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
                    if (markData != null && this.cbZ.adT().size() > this.ccb && this.ccb >= 0) {
                        this.cbZ.adT().get(this.ccb).setPostId(markData.getPostId());
                        this.cbZ.adT().get(this.ccb).setHostMode(markData.getHostMode());
                        this.cbZ.adT().get(this.ccb).setSequence(markData.getSequence());
                        this.ccv.adM();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.cbZ.adT().size() > this.ccb && this.ccb >= 0) {
                        this.cbZ.adT().remove(this.ccb);
                        this.ccv.adM();
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
        if (this.cbZ != null && this.ccv != null) {
            this.cbZ.reset();
            this.ccv.bm(true);
            this.cbZ.f(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.ccv != null && this.cbZ != null && this.cbZ.hasMore()) {
            this.ccv.iL(this.cbZ.getOffset());
            this.cbZ.f(false);
        }
    }

    @Override // com.baidu.tbadk.b.b
    public int getType() {
        return 1;
    }
}
