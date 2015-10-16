package com.baidu.tieba.recommendfrs;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.base.h;
import com.baidu.adp.base.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChosenPostActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.e.f;
import com.baidu.tieba.i;
import com.baidu.tieba.recommendfrs.a.m;
import com.baidu.tieba.tbadkCore.util.p;
import java.util.ArrayList;
import java.util.List;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class d extends FrameLayout implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, BdListView.e {
    private BdListView aKp;
    private boolean aKw;
    private boolean aKx;
    private boolean aSW;
    private PbListView aWW;
    private int ajk;
    private m cIi;
    private TextView cIj;
    private c cIk;
    private int cIl;
    private int cIm;
    private int cIn;
    private long cIo;
    private com.baidu.tieba.recommendfrs.a cIp;
    private f cIq;
    private b cIr;
    private String cIs;
    private boolean cIt;
    private boolean mHasMore;
    private r mPullView;
    private TbPageContext<?> pageContext;

    public d(Context context) {
        super(context);
        this.cIl = 0;
        this.cIm = 0;
        this.cIn = 0;
        this.cIt = false;
        init(context);
    }

    private void init(Context context) {
        h<?> C = l.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        g(context, LayoutInflater.from(context).inflate(i.g.recommend_frs_activity, this));
        this.cIk = new c(this.pageContext, null);
        this.aKp.setAdapter((ListAdapter) this.cIk);
        this.cIl = k.K(context);
        this.cIm = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60);
        this.cIn = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds20);
        this.ajk = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds120);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void setCallback(com.baidu.tieba.recommendfrs.a aVar) {
        this.cIp = aVar;
    }

    public void setScrollCallback(b bVar) {
        this.cIr = bVar;
    }

    public void apQ() {
        this.cIo = System.currentTimeMillis();
        if (!this.aKx) {
            if (this.aKw && !k.jd()) {
                if (this.cIk.Dn() <= 0) {
                    this.cIk.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajk), NoDataViewFactory.d.cK(i.h.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    this.cIk.notifyDataSetChanged();
                    return;
                }
                return;
            }
            a((View) this, false, getResources().getDimensionPixelSize(i.d.ds300));
            startLoad();
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.cIo) / 1000));
        }
    }

    private void g(Context context, View view) {
        this.cIj = (TextView) view.findViewById(i.f.time);
        this.cIj.setVisibility(8);
        this.aKp = (BdListView) view.findViewById(i.f.listview);
        this.mPullView = new r(this.pageContext);
        this.aKp.setPullRefresh(this.mPullView);
        this.aWW = new PbListView(context);
        this.aWW.no();
        this.aWW.cN(TbadkCoreApplication.m411getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.aKp.setOnSrollToBottomListener(this);
        this.aKp.setOnItemClickListener(this);
        this.aKp.setOnScrollListener(this);
    }

    public void a(com.baidu.tieba.recommendfrs.data.e eVar, boolean z) {
        if (this.aKp != null) {
            this.aKp.completePullRefresh();
        }
        if (this.aWW != null) {
            this.aWW.vy();
        }
        if (eVar == null) {
            ap(this);
            this.cIk.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajk), NoDataViewFactory.d.cK(i.h.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cIk.notifyDataSetChanged();
            return;
        }
        this.aSW = false;
        this.aKx = eVar.aql();
        this.aKw = eVar.aqk();
        this.cIs = eVar.getTag();
        this.cIt = eVar.aqi();
        setHasMore(eVar.hasMore());
        bo(eVar.aqn());
        List<Object> aqm = eVar.aqm();
        if (this.cIk != null) {
            if (aqm == null || aqm.size() <= 0) {
                if (this.aKw && this.aKx) {
                    this.cIk.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajk), NoDataViewFactory.d.cK(i.h.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                } else {
                    this.cIk.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
            }
            this.cIk.r(aqm);
        }
        if (z) {
            this.aKp.setSelection(eVar.aqj());
        }
        if (this.aKx || (aqm != null && !aqm.isEmpty())) {
            ap(this);
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.aKp != null) {
            if (this.mHasMore) {
                if (this.aWW != null && this.aWW.getView().getParent() == null) {
                    this.aKp.setNextPage(this.aWW);
                    return;
                }
                return;
            }
            this.aKp.setNextPage(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad() {
        if (this.aKw) {
            this.cIp.b(0, this.cIs, 0);
        } else {
            this.cIp.kV(this.cIs);
        }
    }

    public void Z(String str, int i) {
        if (this.aKp != null) {
            this.aKp.completePullRefresh();
        }
        this.aSW = false;
        this.aWW.vy();
        if (this.cIk.Dn() <= 0 && this.aKw) {
            this.cIk.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajk), NoDataViewFactory.d.dC(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cIk.r(new ArrayList());
        }
        ap(this);
    }

    private void bo(List<com.baidu.tieba.recommendfrs.data.a> list) {
        if (list == null || list.isEmpty()) {
            if (this.cIi != null) {
                this.aKp.removeHeaderView(this.cIi.getView());
                this.cIi = null;
                return;
            }
            return;
        }
        if (this.cIi == null) {
            apR();
            this.aKp.addHeaderView(this.cIi.getView());
        }
        this.cIi.setTitle(UtilHelper.getFixedText(list.get(0).apV(), 14, true));
        this.cIi.setData(list);
    }

    private void apR() {
        this.cIi = new m(getContext());
        this.cIi.e(this.pageContext);
        this.cIi.a(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(String str, String str2) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), com.baidu.adp.lib.g.b.c(str, 0L), str2)));
    }

    private void a(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.pageContext.getContext(), String.valueOf(zhiBoInfoTW.thread_id)).ci("from_frs").bs(18003).rk()));
            TiebaStatic.log("c10258");
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v13 long)] */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = this.cIk.getItem(i);
        if (item instanceof com.baidu.tieba.recommendfrs.data.b) {
            com.baidu.tieba.recommendfrs.data.b bVar = (com.baidu.tieba.recommendfrs.data.b) item;
            String str = (bVar.aqc() == null || bVar.aqc().isEmpty()) ? null : bVar.aqc().get(0);
            TiebaStatic.eventStat(getContext(), "kantie_card", null, 1, PbChosenActivityConfig.KEY_TID, Long.valueOf(bVar.aqb()));
            if (bVar.aqf() == 33) {
                a(bVar.aqg());
            } else {
                bb(String.valueOf(bVar.aqb()), str);
            }
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && !readThreadHistory.lL(String.valueOf(bVar.aqb()))) {
                readThreadHistory.lK(String.valueOf(bVar.aqb()));
                this.cIk.A(item);
            }
        } else if (item instanceof com.baidu.tieba.recommendfrs.data.c) {
            TiebaStatic.eventStat(getContext(), "kantie_3", null);
            long longValue = ((com.baidu.tieba.recommendfrs.data.c) item).aqh().thread_id.longValue();
            TiebaStatic.eventStat(getContext(), "kantie_card", null, 1, PbChosenActivityConfig.KEY_TID, Long.valueOf(longValue));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getContext()).createNormalCfg(new StringBuilder().append(longValue).toString(), null, "")));
        } else if ((item instanceof com.baidu.tieba.recommendfrs.data.d) && ((com.baidu.tieba.recommendfrs.data.d) item).getType() == "text_type_check_more" && bd.ah(getContext())) {
            TiebaStatic.eventStat(getContext(), "kantie_4", null);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChosenPostActivityConfig(getContext())));
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i <= 1 || !this.cIt) {
            if (this.cIj.getVisibility() != 8) {
                this.cIj.setVisibility(8);
                return;
            }
            return;
        }
        Object item = this.cIk.getItem(i - this.aKp.getHeaderViewsCount());
        if (item instanceof String) {
            this.cIj.setText((String) item);
            this.cIj.setVisibility(0);
        } else if (item instanceof com.baidu.tieba.recommendfrs.data.i) {
            this.cIj.setVisibility(0);
            this.cIj.setText(((com.baidu.tieba.recommendfrs.data.i) item).aqv());
        }
        if (this.cIk.getItem(this.aKp.pointToPosition(0, this.cIj.getBottom() + 5) - this.aKp.getHeaderViewsCount()) instanceof String) {
            fN(true);
        } else {
            fN(false);
        }
    }

    private void fN(boolean z) {
        View childAt = this.aKp.getChildAt(0);
        int bottom = childAt != null ? childAt.getBottom() + this.cIn : 0;
        if (z && bottom < this.cIm) {
            this.cIj.layout(0, bottom - this.cIm, this.cIl, bottom);
        } else {
            this.cIj.layout(0, 0, this.cIl, this.cIm);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore && k.jd() && !this.aSW) {
            this.aSW = true;
            this.aWW.startLoadData();
            if (this.cIp != null) {
                if (this.cIk == null) {
                    this.cIp.b(0, this.cIs, 0);
                    return;
                }
                com.baidu.tieba.recommendfrs.data.b apP = this.cIk.apP();
                if (apP != null) {
                    this.cIp.b(apP.aqd(), this.cIs, apP.apY());
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.h.a.a(this.pageContext, this);
        an.d(this, i.c.cp_bg_line_d, i);
        if (this.cIk != null) {
            this.cIk.a(this.pageContext, i);
        }
        if (this.cIi != null) {
            this.cIi.e(this.pageContext);
        }
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
        if (this.aWW != null) {
            this.aWW.cN(i);
        }
    }

    public boolean kW(String str) {
        return TextUtils.equals(str, this.cIs);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.cIr != null) {
            this.cIr.Y(this.cIs, this.aKp.getFirstVisiblePosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements p.a {
        private a() {
        }

        /* synthetic */ a(d dVar, a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.view.p.a
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(d.this.getContext(), "kantie_update", null);
            if (d.this.cIp != null) {
                d.this.startLoad();
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.cIq == null) {
            if (i < 0) {
                this.cIq = new f(getContext());
            } else {
                this.cIq = new f(getContext(), i);
            }
            this.cIq.tc();
        }
        this.cIq.b(view, z);
        if (this.mPullView != null) {
            this.mPullView.U(false);
        }
        if (this.cIk != null) {
            this.cIk.bo(false);
            this.cIk.notifyDataSetChanged();
        }
    }

    private void ap(View view) {
        if (this.cIq != null) {
            this.cIq.u(view);
            this.cIq = null;
        }
        if (this.mPullView != null) {
            this.mPullView.U(true);
        }
        if (this.cIk != null) {
            this.cIk.bo(true);
            this.cIk.notifyDataSetChanged();
        }
    }
}
