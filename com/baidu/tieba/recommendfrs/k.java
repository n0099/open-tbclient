package com.baidu.tieba.recommendfrs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.TagInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class k extends FrameLayout implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, BdListView.e {
    private BdListView aRC;
    private boolean aRJ;
    private boolean aRK;
    private PbListView aVj;
    private int amj;
    private boolean bcr;
    private com.baidu.tbadk.f.f cWx;
    private j doe;
    private long dof;
    private com.baidu.tieba.recommendfrs.a dog;
    private c doh;
    private TagInfo doi;
    private com.baidu.tieba.recommendfrs.data.f doj;
    private boolean dok;
    private CustomMessageListener dol;
    private boolean mHasMore;
    private com.baidu.tbadk.core.view.t mPullView;
    private TbPageContext<?> pageContext;

    public k(Context context) {
        super(context);
        this.dok = false;
        this.dol = new l(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB_FROM_POP_WINDOW);
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        i(context, LayoutInflater.from(context).inflate(n.h.recommend_frs_activity, this));
        this.doe = new j(this.pageContext, null);
        this.aRC.setAdapter((ListAdapter) this.doe);
        this.amj = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds120);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.dol.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dol);
        }
    }

    public void setCallback(com.baidu.tieba.recommendfrs.a aVar) {
        this.dog = aVar;
    }

    public void setScrollCallback(c cVar) {
        this.doh = cVar;
    }

    public void axW() {
        this.dof = System.currentTimeMillis();
        if (this.doi != null && !StringUtils.isNull(this.doi.tag_name)) {
            TiebaStatic.log(new av("kantie_1").aa("obj_name", this.doi.tag_name));
        }
        if (!this.aRK) {
            if (this.aRJ && !com.baidu.adp.lib.util.k.jh()) {
                if (this.doe.DT() <= 0) {
                    this.doe.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.amj), NoDataViewFactory.d.cM(n.j.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    this.doe.notifyDataSetChanged();
                    return;
                }
                return;
            }
            if (this.dok) {
                this.dok = false;
                com.baidu.adp.lib.h.h.hj().postDelayed(new m(this), 200L);
            } else {
                axZ();
            }
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.dof) / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axZ() {
        a(this, false, getResources().getDimensionPixelSize(n.e.ds300));
        startLoad();
    }

    private void i(Context context, View view) {
        this.aRC = (BdListView) view.findViewById(n.g.listview);
        this.mPullView = new com.baidu.tbadk.core.view.t(this.pageContext);
        this.aRC.setPullRefresh(this.mPullView);
        this.aVj = new PbListView(context);
        this.aVj.mT();
        this.aVj.cP(TbadkCoreApplication.m411getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.aRC.setOnSrollToBottomListener(this);
        this.aRC.setOnItemClickListener(this);
        this.aRC.setOnScrollListener(this);
    }

    public void a(com.baidu.tieba.recommendfrs.data.f fVar, boolean z) {
        if (this.aRC != null) {
            this.aRC.completePullRefresh();
        }
        if (this.aVj != null) {
            this.aVj.vP();
        }
        if (fVar == null) {
            au(this);
            this.doe.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.amj), NoDataViewFactory.d.cM(n.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.doe.notifyDataSetChanged();
            return;
        }
        this.doj = fVar;
        this.bcr = false;
        this.aRK = fVar.aym();
        this.aRJ = fVar.ayl();
        this.doi = fVar.ayn();
        setHasMore(fVar.hasMore());
        List<Object> ayo = fVar.ayo();
        if (this.doe != null) {
            if (ayo == null || ayo.size() <= 0) {
                if (this.aRJ && this.aRK) {
                    this.doe.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.amj), NoDataViewFactory.d.cM(n.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    setHasMore(false);
                } else {
                    this.doe.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
            }
            this.doe.s(ayo);
        }
        if (z) {
            this.aRC.setSelection(fVar.ayk());
        }
        if (this.aRK || (ayo != null && !ayo.isEmpty())) {
            au(this);
        }
    }

    public void reload() {
        if (this.aRC != null) {
            this.aRC.setSelection(0);
            this.aRC.nb();
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.aRC != null) {
            if (this.mHasMore) {
                if (this.aVj != null && this.aVj.getView().getParent() == null) {
                    this.aRC.setNextPage(this.aVj);
                    return;
                }
                return;
            }
            this.aRC.setNextPage(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad() {
        if (this.aRJ) {
            this.dog.b(1, this.doi.tag_code.longValue(), 0L);
        } else {
            this.dog.bC(this.doi.tag_code.longValue());
        }
    }

    public void af(String str, int i) {
        if (this.aRC != null) {
            this.aRC.completePullRefresh();
        }
        this.bcr = false;
        this.aVj.vP();
        if (this.doe.DT() <= 0 && this.aRJ) {
            this.doe.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.amj), NoDataViewFactory.d.dN(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.doe.s(new ArrayList());
        }
        au(this);
    }

    private void i(long j, String str) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), j, str)));
    }

    private void lU(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getContext()).createNormalCfg(str, null, null)));
    }

    private void b(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.pageContext.getContext(), String.valueOf(zhiBoInfoTW.thread_id)).cp("from_frs").bo(18003).rf()));
            TiebaStatic.log("c10258");
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = this.doe.getItem(i);
        if (item instanceof com.baidu.tieba.recommendfrs.data.j) {
            com.baidu.tieba.recommendfrs.data.j jVar = (com.baidu.tieba.recommendfrs.data.j) item;
            String str = null;
            if (jVar.ayw() != null && !jVar.ayw().isEmpty()) {
                str = jVar.ayw().get(0);
            }
            if (jVar.ayx() == 33) {
                b(jVar.ayy());
            } else if (jVar.ayz() == 1) {
                i(jVar.ayv(), str);
                TiebaStatic.log(new av("kantie_card").aa("obj_name", jVar.dpt).r("obj_type", 1).r("obj_locate", i).aa("obj_source", jVar.dpu).r("obj_param1", 1).aa("abtest", jVar.abtest));
            } else if (jVar.ayz() == 3) {
                lU(new StringBuilder(String.valueOf(jVar.getThreadId())).toString());
                TiebaStatic.log(new av("kantie_card").aa("obj_name", jVar.dpt).r("obj_type", 2).r("obj_locate", i).aa("obj_source", jVar.dpu).r("obj_param1", 1).aa("abtest", jVar.abtest));
            }
            com.baidu.tieba.tbadkCore.util.q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && !readThreadHistory.mD(String.valueOf(jVar.getThreadId()))) {
                readThreadHistory.mC(String.valueOf(jVar.getThreadId()));
                this.doe.A(item);
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore && com.baidu.adp.lib.util.k.jh() && !this.bcr) {
            this.bcr = true;
            this.aVj.startLoadData();
            if (this.dog != null) {
                if (this.doe == null) {
                    this.dog.b(1, this.doi.tag_code.longValue(), 0L);
                    return;
                }
                com.baidu.tieba.recommendfrs.data.j axY = this.doe.axY();
                if (axY != null) {
                    this.dog.b(this.doj != null ? this.doj.getPn() + 1 : 1, this.doi.tag_code.longValue(), axY.ays());
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.pageContext, this);
        as.d(this, n.d.cp_bg_line_d, i);
        if (this.doe != null) {
            this.doe.a(this.pageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cP(i);
        }
        if (this.aVj != null) {
            this.aVj.cP(i);
        }
    }

    public boolean bF(long j) {
        return this.doi != null && j == this.doi.tag_code.longValue();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.doh != null && this.doi != null) {
            this.doh.e(this.doi.tag_code.longValue(), this.aRC.getFirstVisiblePosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements r.a {
        private a() {
        }

        /* synthetic */ a(k kVar, a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.view.r.a
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(k.this.getContext(), "kantie_update", null);
            if (k.this.dog != null) {
                k.this.startLoad();
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.cWx == null) {
            if (i < 0) {
                this.cWx = new com.baidu.tbadk.f.f(getContext());
            } else {
                this.cWx = new com.baidu.tbadk.f.f(getContext(), i);
            }
            this.cWx.tr();
        }
        this.cWx.b(view, z);
        if (this.mPullView != null) {
            this.mPullView.R(false);
        }
        if (this.doe != null) {
            this.doe.bz(false);
            this.doe.notifyDataSetChanged();
        }
    }

    private void au(View view) {
        if (this.cWx != null) {
            this.cWx.u(view);
            this.cWx = null;
        }
        if (this.mPullView != null) {
            this.mPullView.R(true);
        }
        if (this.doe != null) {
            this.doe.bz(true);
            this.doe.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
    }
}
