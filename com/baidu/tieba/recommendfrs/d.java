package com.baidu.tieba.recommendfrs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.base.h;
import com.baidu.adp.base.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.f.f;
import com.baidu.tieba.n;
import com.baidu.tieba.recommendfrs.data.e;
import com.baidu.tieba.tbadkCore.util.p;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcFrsPage.ExcellentTagInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class d extends FrameLayout implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, BdListView.e {
    private BdListView aNK;
    private boolean aNR;
    private boolean aNS;
    private PbListView aRt;
    private boolean aYs;
    private int ald;
    private f cRU;
    private c dio;
    private long dip;
    private com.baidu.tieba.recommendfrs.a diq;
    private b dir;
    private ExcellentTagInfo dis;
    private com.baidu.tieba.recommendfrs.data.a dit;
    private boolean mHasMore;
    private s mPullView;
    private TbPageContext<?> pageContext;

    public d(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        h<?> C = l.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        j(context, LayoutInflater.from(context).inflate(n.g.recommend_frs_activity, this));
        this.dio = new c(this.pageContext, null);
        this.aNK.setAdapter((ListAdapter) this.dio);
        this.ald = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds120);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void setCallback(com.baidu.tieba.recommendfrs.a aVar) {
        this.diq = aVar;
    }

    public void setScrollCallback(b bVar) {
        this.dir = bVar;
    }

    public void awc() {
        this.dip = System.currentTimeMillis();
        if (!this.aNS) {
            if (this.aNR && !k.jg()) {
                if (this.dio.Ee() <= 0) {
                    this.dio.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ald), NoDataViewFactory.d.cS(n.i.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    this.dio.notifyDataSetChanged();
                    return;
                }
                return;
            }
            a(this, false, getResources().getDimensionPixelSize(n.d.ds300));
            startLoad();
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.dip) / 1000));
        }
    }

    private void j(Context context, View view) {
        this.aNK = (BdListView) view.findViewById(n.f.listview);
        this.mPullView = new s(this.pageContext);
        this.aNK.setPullRefresh(this.mPullView);
        this.aRt = new PbListView(context);
        this.aRt.nv();
        this.aRt.cV(TbadkCoreApplication.m411getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.aNK.setOnSrollToBottomListener(this);
        this.aNK.setOnItemClickListener(this);
        this.aNK.setOnScrollListener(this);
    }

    public void a(com.baidu.tieba.recommendfrs.data.a aVar, boolean z) {
        if (this.aNK != null) {
            this.aNK.completePullRefresh();
        }
        if (this.aRt != null) {
            this.aRt.wf();
        }
        if (aVar == null) {
            ao(this);
            this.dio.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ald), NoDataViewFactory.d.cS(n.i.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.dio.notifyDataSetChanged();
            return;
        }
        this.dit = aVar;
        this.aYs = false;
        this.aNS = aVar.awg();
        this.aNR = aVar.awf();
        this.dis = aVar.awh();
        setHasMore(aVar.hasMore());
        List<Object> awi = aVar.awi();
        if (this.dio != null) {
            if (awi == null || awi.size() <= 0) {
                if (this.aNR && this.aNS) {
                    this.dio.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ald), NoDataViewFactory.d.cS(n.i.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                } else {
                    this.dio.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
            }
            if (this.dis != null && !StringUtils.isNull(this.dis.tag_name) && y.k(awi) > 0) {
                TiebaStatic.log(new av("kantie_1").ab("obj_name", this.dis.tag_name));
            }
            this.dio.r(awi);
        }
        if (z) {
            this.aNK.setSelection(aVar.awe());
        }
        if (this.aNS || (awi != null && !awi.isEmpty())) {
            ao(this);
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.aNK != null) {
            if (this.mHasMore) {
                if (this.aRt != null && this.aRt.getView().getParent() == null) {
                    this.aNK.setNextPage(this.aRt);
                    return;
                }
                return;
            }
            this.aNK.setNextPage(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad() {
        if (this.aNR) {
            this.diq.b(1, this.dis.tag_code.longValue(), 0L);
        } else {
            this.diq.bv(this.dis.tag_code.longValue());
        }
    }

    public void ae(String str, int i) {
        if (this.aNK != null) {
            this.aNK.completePullRefresh();
        }
        this.aYs = false;
        this.aRt.wf();
        if (this.dio.Ee() <= 0 && this.aNR) {
            this.dio.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ald), NoDataViewFactory.d.dK(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.dio.r(new ArrayList());
        }
        ao(this);
    }

    private void i(long j, String str) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), j, str)));
    }

    private void lW(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getContext()).createNormalCfg(str, null, null)));
    }

    private void b(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.pageContext.getContext(), String.valueOf(zhiBoInfoTW.thread_id)).cn("from_frs").bv(18003).rw()));
            TiebaStatic.log("c10258");
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = this.dio.getItem(i);
        if (item instanceof e) {
            e eVar = (e) item;
            String str = null;
            if (eVar.aws() != null && !eVar.aws().isEmpty()) {
                str = eVar.aws().get(0);
            }
            if (eVar.awt() == 33) {
                b(eVar.awu());
            } else if (eVar.awv() == 1) {
                i(eVar.awr(), str);
                TiebaStatic.log(new av("kantie_card").ab("obj_name", eVar.diR).r("obj_type", 1).r("obj_locate", i).ab("obj_source", eVar.diS).r("obj_param1", 1).ab("abtest", eVar.abtest));
            } else if (eVar.awv() == 3) {
                lW(new StringBuilder(String.valueOf(eVar.getThreadId())).toString());
                TiebaStatic.log(new av("kantie_card").ab("obj_name", eVar.diR).r("obj_type", 2).r("obj_locate", i).ab("obj_source", eVar.diS).r("obj_param1", 1).ab("abtest", eVar.abtest));
            }
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && !readThreadHistory.mF(String.valueOf(eVar.getThreadId()))) {
                readThreadHistory.mE(String.valueOf(eVar.getThreadId()));
                this.dio.A(item);
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore && k.jg() && !this.aYs) {
            this.aYs = true;
            this.aRt.startLoadData();
            if (this.diq != null) {
                if (this.dio == null) {
                    this.diq.b(1, this.dis.tag_code.longValue(), 0L);
                    return;
                }
                e awb = this.dio.awb();
                if (awb != null) {
                    this.diq.b(this.dit != null ? this.dit.getPn() + 1 : 1, this.dis.tag_code.longValue(), awb.awo());
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.pageContext, this);
        as.d(this, n.c.cp_bg_line_d, i);
        if (this.dio != null) {
            this.dio.a(this.pageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cV(i);
        }
        if (this.aRt != null) {
            this.aRt.cV(i);
        }
    }

    public boolean bw(long j) {
        return this.dis != null && j == this.dis.tag_code.longValue();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.dir != null && this.dis != null) {
            this.dir.d(this.dis.tag_code.longValue(), this.aNK.getFirstVisiblePosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements q.a {
        private a() {
        }

        /* synthetic */ a(d dVar, a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.view.q.a
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(d.this.getContext(), "kantie_update", null);
            if (d.this.diq != null) {
                d.this.startLoad();
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.cRU == null) {
            if (i < 0) {
                this.cRU = new f(getContext());
            } else {
                this.cRU = new f(getContext(), i);
            }
            this.cRU.tH();
        }
        this.cRU.b(view, z);
        if (this.mPullView != null) {
            this.mPullView.U(false);
        }
        if (this.dio != null) {
            this.dio.bz(false);
            this.dio.notifyDataSetChanged();
        }
    }

    private void ao(View view) {
        if (this.cRU != null) {
            this.cRU.v(view);
            this.cRU = null;
        }
        if (this.mPullView != null) {
            this.mPullView.U(true);
        }
        if (this.dio != null) {
            this.dio.bz(true);
            this.dio.notifyDataSetChanged();
        }
    }
}
