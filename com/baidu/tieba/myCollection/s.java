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
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s extends com.baidu.tbadk.c.b implements View.OnClickListener, BdListView.e, q.a {
    private ArrayList<MarkData> cub;
    private com.baidu.tieba.myCollection.baseEditMark.a ctY = null;
    private x cuw = null;
    private int cua = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new t(this, 2000994);

    public static final s aid() {
        return new s();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerNavigationBarEditStateListener();
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(n.g.edit_mark_activity, (ViewGroup) null);
        this.ctY = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.cuw = new x(this, inflate);
        this.cuw.b(new u(this));
        this.ctY.a(new v(this));
        refresh();
        return inflate;
    }

    private void refresh() {
        if (this.ctY.getCount() == 0 || this.ctY.aij() < 0) {
            this.cuw.jC(this.ctY.getOffset());
            return;
        }
        this.cuw.startSync();
        this.ctY.startSync();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cuw.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.cuw.S(this.cub);
        this.mIsEnableEdit = (this.cub == null || this.cub.isEmpty()) ? false : true;
        sendEditEnableMessage(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cuw.aie();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cuw.onDestroy();
        this.ctY.onDestroy();
    }

    private void registerNavigationBarEditStateListener() {
        registerListener(new w(this, CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.cuw.ahY()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.cuw.KX();
            if (!this.ctY.jE(intValue)) {
                this.cuw.OM();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.ctY.aig().size()) {
            this.cua = i;
            MarkData markData = this.ctY.aig().get(i);
            MarkData markData2 = this.cub.get(i);
            int aif = this.ctY.aif();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.xJ().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xJ().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xJ().setMsgBookmark(0);
                }
                if (aif > 0) {
                    this.ctY.jD(aif - 1);
                } else {
                    this.ctY.jD(0);
                }
            }
            markData2.setNewCounts(0);
            if (markData != null) {
                if (markData.isPhotoLiveThread()) {
                    TiebaStatic.log("c10252");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), markData.getThreadId()).bv(17001).cl(markData.getPostId()).cn("from_mark").rw()));
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
                    if (markData != null && this.ctY.aig().size() > this.cua && this.cua >= 0) {
                        this.ctY.aig().get(this.cua).setPostId(markData.getPostId());
                        this.ctY.aig().get(this.cua).setHostMode(markData.getHostMode());
                        this.ctY.aig().get(this.cua).setSequence(markData.getSequence());
                        this.cuw.aia();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.ctY.aig().size() > this.cua && this.cua >= 0) {
                        this.ctY.aig().remove(this.cua);
                        this.cuw.aia();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        if (this.ctY != null && this.cuw != null) {
            this.ctY.reset();
            this.cuw.bu(true);
            this.ctY.f(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cuw != null && this.ctY != null && this.ctY.hasMore()) {
            this.cuw.jC(this.ctY.getOffset());
            this.ctY.f(false);
        }
    }

    @Override // com.baidu.tbadk.c.b
    public int getType() {
        return 1;
    }
}
