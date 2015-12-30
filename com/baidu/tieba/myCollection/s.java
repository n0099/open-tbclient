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
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s extends com.baidu.tbadk.c.b implements View.OnClickListener, BdListView.e, r.a {
    private ArrayList<MarkData> cyd;
    private com.baidu.tieba.myCollection.baseEditMark.a cya = null;
    private x cyw = null;
    private int cyc = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new t(this, 2000994);

    public static final s ajq() {
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
        View inflate = layoutInflater.inflate(n.h.edit_mark_activity, (ViewGroup) null);
        this.cya = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.cyw = new x(this, inflate);
        this.cyw.b(new u(this));
        this.cya.a(new v(this));
        refresh();
        return inflate;
    }

    private void refresh() {
        if (this.cya.getCount() == 0 || this.cya.ajw() < 0) {
            this.cyw.ka(this.cya.getOffset());
            return;
        }
        this.cyw.startSync();
        this.cya.startSync();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cyw != null) {
            this.cyw.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cyw != null) {
            this.cyw.R(this.cyd);
            this.mIsEnableEdit = (this.cyd == null || this.cyd.isEmpty()) ? false : true;
            sendEditEnableMessage(1);
        }
    }

    @Override // com.baidu.tbadk.c.b, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cyw.ajr();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cyw.onDestroy();
        this.cya.onDestroy();
    }

    private void registerNavigationBarEditStateListener() {
        registerListener(new w(this, CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.cyw.ajl()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.cyw.Lq();
            if (!this.cya.kc(intValue)) {
                this.cyw.Pe();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.cya.ajt().size()) {
            this.cyc = i;
            MarkData markData = this.cya.ajt().get(i);
            MarkData markData2 = this.cyd.get(i);
            int ajs = this.cya.ajs();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.xv().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_content", "is_redpoint", markData2.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData2.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xv().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xv().setMsgBookmark(0);
                }
                if (ajs > 0) {
                    this.cya.kb(ajs - 1);
                } else {
                    this.cya.kb(0);
                }
            }
            markData2.setNewCounts(0);
            if (markData != null) {
                if (markData.isPhotoLiveThread()) {
                    TiebaStatic.log("c10252");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), markData.getThreadId()).bo(17001).cn(markData.getPostId()).cp("from_mark").rf()));
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
                    if (this.cya != null && markData != null && this.cyw != null && com.baidu.tbadk.core.util.y.l(this.cya.ajt()) > this.cyc && this.cyc >= 0) {
                        this.cya.ajt().get(this.cyc).setPostId(markData.getPostId());
                        this.cya.ajt().get(this.cyc).setHostMode(markData.getHostMode());
                        this.cya.ajt().get(this.cyc).setSequence(markData.getSequence());
                        this.cyw.ajn();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.cya != null && this.cyw != null && com.baidu.tbadk.core.util.y.l(this.cya.ajt()) > this.cyc && this.cyc >= 0) {
                        this.cya.ajt().remove(this.cyc);
                        this.cyw.ajn();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        if (this.cya != null && this.cyw != null) {
            this.cya.reset();
            this.cyw.bu(true);
            this.cya.f(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cyw != null && this.cya != null && this.cya.hasMore()) {
            this.cyw.ka(this.cya.getOffset());
            this.cya.f(false);
        }
    }

    @Override // com.baidu.tbadk.c.b
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.c.b
    public boolean isEmptyData() {
        return this.cyd == null || this.cyd.isEmpty();
    }
}
