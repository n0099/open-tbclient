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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.collectTab.CollectFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, BdListView.e, g.b {
    private ArrayList<MarkData> fjx;
    private com.baidu.tieba.myCollection.baseEditMark.a fju = null;
    private g fka = null;
    private int fjw = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.myCollection.ThreadFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.jD()) {
                    ThreadFragment.this.fka.ayD();
                    ThreadFragment.this.fka.completePullRefresh();
                    ThreadFragment.this.fka.bS(false);
                    ThreadFragment.this.fka.fr(false);
                    return;
                }
                ThreadFragment.this.fju.d(false);
                ThreadFragment.this.fka.fr(true);
            }
        }
    };
    private final CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myCollection.ThreadFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.fjx != null && data != null) {
                    if (data.aDu != null && AntiHelper.a(ThreadFragment.this.getActivity(), data.aDu, ThreadFragment.this.mInjectListener) != null) {
                        TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arP));
                    }
                    if (data.Gr) {
                        Iterator it = ThreadFragment.this.fjx.iterator();
                        while (it.hasNext()) {
                            MarkData markData = (MarkData) it.next();
                            if (markData != null && ap.equals(markData.getUesrId(), data.toUid)) {
                                markData.metaData.setIsLike(data.isAttention);
                                markData.setLikeInPage(data.isAttention);
                            }
                        }
                        if (data.isAttention) {
                            l.showToast(ThreadFragment.this.getPageContext().getPageActivity(), d.k.attention_success);
                        }
                        ThreadFragment.this.fka.aYr();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.ThreadFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arP));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arP));
        }
    };

    public static final ThreadFragment aYx() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aYy();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.edit_mark_activity, (ViewGroup) null);
        this.fju = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.fka = new g(this, inflate);
        this.fka.c(new a.b() { // from class: com.baidu.tieba.myCollection.ThreadFragment.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                ThreadFragment.this.fka.startRefresh(ThreadFragment.this.fju.getOffset());
                ThreadFragment.this.fju.d(true);
            }
        });
        this.fka.fr(j.jD());
        this.fju.a(new d() { // from class: com.baidu.tieba.myCollection.ThreadFragment.2
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        ThreadFragment.this.fka.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.fka.a(r3, ThreadFragment.this.fju, ((Boolean) objArr[2]).booleanValue());
                        ThreadFragment.this.fjx = ThreadFragment.this.fju.aYB();
                        ThreadFragment threadFragment = ThreadFragment.this;
                        if (ThreadFragment.this.fjx != null && !ThreadFragment.this.fjx.isEmpty()) {
                            r2 = true;
                        }
                        threadFragment.acc = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        ThreadFragment.this.fka.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.fka.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        ThreadFragment.this.fka.a(ThreadFragment.this.fju, false);
                        ThreadFragment.this.acc = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        ThreadFragment.this.fka.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            ThreadFragment.this.fka.startRefresh(ThreadFragment.this.fju.getOffset());
                            ThreadFragment.this.fju.d(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        ThreadFragment.this.fka.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.fju);
                        ThreadFragment.this.fjx = ThreadFragment.this.fju.aYB();
                        ThreadFragment.this.acc = (ThreadFragment.this.fjx == null || ThreadFragment.this.fjx.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                ThreadFragment.this.bb(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.fju.getCount() == 0) {
            this.fka.startRefresh(this.fju.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fka != null) {
            this.fka.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fka != null) {
            this.fka.am(this.fjx);
            this.acc = (this.fjx == null || this.fjx.isEmpty()) ? false : true;
            bb(1);
            refresh();
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.fka.aYz();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.fka.onDestroy();
        this.fju.onDestroy();
        super.onDestroy();
    }

    private void aYy() {
        registerListener(new CustomMessageListener(2022208) { // from class: com.baidu.tieba.myCollection.ThreadFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.getType()) {
                        ThreadFragment.this.fka.jj(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) w.d(this.fjx, intValue);
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            an anVar = new an("c12529");
            if (view.getId() == this.fka.jk(isShareThread)) {
                if (this.fka.dCN == null || this.fka.dCN.isRefreshDone()) {
                    this.fka.aps();
                    if (!this.fju.qd(intValue)) {
                        this.fka.ayD();
                    }
                } else {
                    return;
                }
            } else if (view.getId() == this.fka.jl(isShareThread)) {
                this.fka.e(markData);
                anVar.r("obj_locate", 1);
            } else if (view.getId() == this.fka.jm(isShareThread)) {
                anVar.r("obj_locate", 3);
                d(markData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
            }
            anVar.ah("tid", markData.getId());
            anVar.ah(VideoPlayActivityConfig.OBJ_ID, markData.getUesrId());
            TiebaStatic.log(anVar);
            super.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.fju.aYB().size()) {
            this.fjw = i;
            MarkData markData = this.fju.aYB().get(i);
            MarkData markData2 = this.fjx.get(i);
            an anVar = new an("c12529");
            anVar.r("obj_locate", 2);
            anVar.ah("tid", markData2.getId());
            anVar.ah(VideoPlayActivityConfig.OBJ_ID, markData2.getUesrId());
            TiebaStatic.log(anVar);
            d(markData2);
            markData2.setRedTipShow(false);
            if (markData != null) {
                if (markData.isManga()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            bb.aT(getPageContext().getPageActivity());
                        } else {
                            sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), markData.getCartoonId(), markData.getChapterId(), 3)));
                        }
                    } else {
                        l.showToast(getPageContext().getPageActivity(), d.k.manga_plugin_not_install_tip);
                    }
                } else {
                    PbActivityConfig createMarkCfg = new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001);
                    createMarkCfg.setStartFrom(10);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createMarkCfg));
                }
            }
        }
        super.onItemClick(adapterView, view, i, j);
    }

    private void d(MarkData markData) {
        if (markData != null && this.fju != null) {
            int aYA = this.fju.aYA();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.Dp().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dp().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dp().setMsgBookmark(0);
                }
                if (aYA > 0) {
                    this.fju.qc(aYA - 1);
                } else {
                    this.fju.qc(0);
                }
            }
            markData.setNewCounts(0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (17001 == i) {
                MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                if (this.fju != null && markData != null && this.fka != null && w.z(this.fju.aYB()) > this.fjw && this.fjw >= 0) {
                    this.fju.aYB().get(this.fjw).setPostId(markData.getPostId());
                    this.fju.aYB().get(this.fjw).setHostMode(markData.getHostMode());
                    this.fju.aYB().get(this.fjw).setSequence(markData.getSequence());
                    this.fka.aYr();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.fju != null && this.fka != null && w.z(this.fju.aYB()) > this.fjw && this.fjw >= 0) {
            this.fju.aYB().remove(this.fjw);
            this.fka.aYr();
            this.fka.a(this.fju, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aU(boolean z) {
        if (this.fju != null && this.fka != null) {
            this.fju.reset();
            this.fka.bS(true);
            this.fju.d(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fka != null && this.fju != null && this.fju.hasMore()) {
            this.fka.startRefresh(this.fju.getOffset());
            this.fju.d(false);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean sV() {
        return this.fjx == null || this.fjx.isEmpty();
    }
}
