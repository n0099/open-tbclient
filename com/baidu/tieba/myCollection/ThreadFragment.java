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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, BdListView.e, g.b {
    private ArrayList<MarkData> fjJ;
    private com.baidu.tieba.myCollection.baseEditMark.a fjG = null;
    private g fkm = null;
    private int fjI = -1;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.myCollection.ThreadFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.jE()) {
                    ThreadFragment.this.fkm.azi();
                    ThreadFragment.this.fkm.completePullRefresh();
                    ThreadFragment.this.fkm.bQ(false);
                    ThreadFragment.this.fkm.fs(false);
                    return;
                }
                ThreadFragment.this.fjG.e(false);
                ThreadFragment.this.fkm.fs(true);
            }
        }
    };
    private final CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myCollection.ThreadFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (ThreadFragment.this.fjJ != null && data != null) {
                    if (data.aDu != null && AntiHelper.a(ThreadFragment.this.getActivity(), data.aDu, ThreadFragment.this.mInjectListener) != null) {
                        TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arq));
                    }
                    if (data.Gp) {
                        Iterator it = ThreadFragment.this.fjJ.iterator();
                        while (it.hasNext()) {
                            MarkData markData = (MarkData) it.next();
                            if (markData != null && ap.equals(markData.getUesrId(), data.toUid)) {
                                markData.metaData.setIsLike(data.isAttention);
                                markData.setLikeInPage(data.isAttention);
                            }
                        }
                        if (data.isAttention) {
                            l.showToast(ThreadFragment.this.getPageContext().getPageActivity(), d.j.attention_success);
                        }
                        ThreadFragment.this.fkm.aWN();
                    }
                }
            }
        }
    };
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.myCollection.ThreadFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arq));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arq));
        }
    };

    public static final ThreadFragment aWT() {
        return new ThreadFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aWU();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.edit_mark_activity, (ViewGroup) null);
        this.fjG = new com.baidu.tieba.myCollection.baseEditMark.a();
        this.fkm = new g(this, inflate);
        this.fkm.c(new a.b() { // from class: com.baidu.tieba.myCollection.ThreadFragment.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                ThreadFragment.this.fkm.startRefresh(ThreadFragment.this.fjG.getOffset());
                ThreadFragment.this.fjG.e(true);
            }
        });
        this.fkm.fs(j.jE());
        this.fjG.a(new d() { // from class: com.baidu.tieba.myCollection.ThreadFragment.2
            @Override // com.baidu.tieba.myCollection.d
            public void callback(Object... objArr) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        ThreadFragment.this.fkm.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.fkm.a(r3, ThreadFragment.this.fjG, ((Boolean) objArr[2]).booleanValue());
                        ThreadFragment.this.fjJ = ThreadFragment.this.fjG.aWX();
                        ThreadFragment threadFragment = ThreadFragment.this;
                        if (ThreadFragment.this.fjJ != null && !ThreadFragment.this.fjJ.isEmpty()) {
                            r2 = true;
                        }
                        threadFragment.abG = r2;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        ThreadFragment.this.fkm.completePullRefresh();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        ThreadFragment.this.fkm.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                        ThreadFragment.this.fkm.a(ThreadFragment.this.fjG, false);
                        ThreadFragment.this.abG = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        ThreadFragment.this.fkm.a(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            ThreadFragment.this.fkm.startRefresh(ThreadFragment.this.fjG.getOffset());
                            ThreadFragment.this.fjG.e(true);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        ThreadFragment.this.fkm.a(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, ThreadFragment.this.fjG);
                        ThreadFragment.this.fjJ = ThreadFragment.this.fjG.aWX();
                        ThreadFragment.this.abG = (ThreadFragment.this.fjJ == null || ThreadFragment.this.fjJ.isEmpty()) ? false : true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                ThreadFragment.this.bd(1);
            }
        });
        return inflate;
    }

    private void refresh() {
        if (this.fjG.getCount() == 0) {
            this.fkm.startRefresh(this.fjG.getOffset());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fkm != null) {
            this.fkm.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fkm != null) {
            this.fkm.ak(this.fjJ);
            this.abG = (this.fjJ == null || this.fjJ.isEmpty()) ? false : true;
            bd(1);
            refresh();
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.fkm.aWV();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.fkm.onDestroy();
        this.fjG.onDestroy();
        super.onDestroy();
    }

    private void aWU() {
        registerListener(new CustomMessageListener(2022208) { // from class: com.baidu.tieba.myCollection.ThreadFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Bundle) {
                    Bundle bundle = (Bundle) customResponsedMessage.getData();
                    if (bundle.getInt("fragment_type", -1) == ThreadFragment.this.getType()) {
                        ThreadFragment.this.fkm.iV(bundle.getBoolean("is_edit_state", false));
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        MarkData markData = (MarkData) w.d(this.fjJ, intValue);
        if (markData != null) {
            boolean isShareThread = markData.isShareThread();
            an anVar = new an("c12529");
            if (view.getId() == this.fkm.iW(isShareThread)) {
                if (this.fkm.dFz == null || this.fkm.dFz.isRefreshDone()) {
                    this.fkm.apS();
                    if (!this.fjG.qa(intValue)) {
                        this.fkm.azi();
                    }
                } else {
                    return;
                }
            } else if (view.getId() == this.fkm.iX(isShareThread)) {
                this.fkm.e(markData);
                anVar.r("obj_locate", 1);
            } else if (view.getId() == this.fkm.iY(isShareThread)) {
                anVar.r("obj_locate", 3);
                d(markData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
            }
            anVar.af("tid", markData.getId());
            anVar.af(VideoPlayActivityConfig.OBJ_ID, markData.getUesrId());
            TiebaStatic.log(anVar);
            super.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.fjG.aWX().size()) {
            this.fjI = i;
            MarkData markData = this.fjG.aWX().get(i);
            MarkData markData2 = this.fjJ.get(i);
            an anVar = new an("c12529");
            anVar.r("obj_locate", 2);
            anVar.af("tid", markData2.getId());
            anVar.af(VideoPlayActivityConfig.OBJ_ID, markData2.getUesrId());
            TiebaStatic.log(anVar);
            d(markData2);
            markData2.setRedTipShow(false);
            if (markData != null) {
                if (markData.isManga()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            ba.aU(getPageContext().getPageActivity());
                        } else {
                            sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), markData.getCartoonId(), markData.getChapterId(), 3)));
                        }
                    } else {
                        l.showToast(getPageContext().getPageActivity(), d.j.manga_plugin_not_install_tip);
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
        if (markData != null && this.fjG != null) {
            int aWW = this.fjG.aWW();
            int msgBookmark = com.baidu.tbadk.coreExtra.messageCenter.a.Dl().getMsgBookmark();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (msgBookmark > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().setMsgBookmark(msgBookmark - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().setMsgBookmark(0);
                }
                if (aWW > 0) {
                    this.fjG.pZ(aWW - 1);
                } else {
                    this.fjG.pZ(0);
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
                if (this.fjG != null && markData != null && this.fkm != null && w.y(this.fjG.aWX()) > this.fjI && this.fjI >= 0) {
                    this.fjG.aWX().get(this.fjI).setPostId(markData.getPostId());
                    this.fjG.aWX().get(this.fjI).setHostMode(markData.getHostMode());
                    this.fjG.aWX().get(this.fjI).setSequence(markData.getSequence());
                    this.fkm.aWN();
                }
            }
        } else if (i2 == 1 && 17001 == i && this.fjG != null && this.fkm != null && w.y(this.fjG.aWX()) > this.fjI && this.fjI >= 0) {
            this.fjG.aWX().remove(this.fjI);
            this.fkm.aWN();
            this.fkm.a(this.fjG, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aS(boolean z) {
        if (this.fjG != null && this.fkm != null) {
            this.fjG.reset();
            this.fkm.bQ(true);
            this.fjG.e(false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fkm != null && this.fjG != null && this.fjG.hasMore()) {
            this.fkm.startRefresh(this.fjG.getOffset());
            this.fjG.e(false);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        return 1;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean sH() {
        return this.fjJ == null || this.fjJ.isEmpty();
    }
}
