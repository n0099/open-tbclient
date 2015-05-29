package com.baidu.tieba.recommendfrs;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChosenPostActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bq;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.al;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.o;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.recommendfrs.a.k;
import com.baidu.tieba.recommendfrs.data.f;
import com.baidu.tieba.recommendfrs.data.h;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.l;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import tbclient.FineFrsPage.EverydayThread;
import tbclient.FineFrsPage.FineThreadInfo;
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class b extends BaseFragment implements x {
    private BdListView aDB;
    private NoNetworkView aDC;
    private boolean aDI;
    private boolean aDJ;
    private boolean aKl;
    private PbListView aOf;
    private long cbA;
    private String cbB;
    private boolean cbC = false;
    private int cbD = 0;
    private com.baidu.tieba.recommendfrs.control.a.b cbv;
    private k cbw;
    private TextView cbx;
    private a cby;
    private int[] cbz;
    private boolean mHasMore;
    private al mPullView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(r.recommend_frs_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.cbA = System.currentTimeMillis();
            TiebaStatic.eventStat(getFragmentActivity(), "kantie_entry", null);
            if (this.aDJ) {
                at(true);
                return;
            } else if (this.aDI && !n.isNetOk()) {
                at(true);
                return;
            } else if (isShow()) {
                this.aDB.no();
                return;
            } else {
                return;
            }
        }
        TiebaStatic.eventStat(getFragmentActivity(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.cbA) / 1000));
    }

    private void at(boolean z) {
        if (this.cby != null) {
            for (Object obj : this.cby.CM()) {
                if (obj instanceof com.baidu.tieba.recommendfrs.data.b) {
                    ((com.baidu.tieba.recommendfrs.data.b) obj).eB(z);
                } else if (obj instanceof com.baidu.tieba.recommendfrs.data.c) {
                    ((com.baidu.tieba.recommendfrs.data.c) obj).eB(z);
                }
            }
            if (this.cbw != null) {
                this.cbw.setIsShowImage(z);
            }
            this.cby.notifyDataSetChanged();
            System.gc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        v(getView());
        this.cbz = new int[2];
        this.cbz[0] = n.M(getFragmentActivity());
        this.cbz[1] = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(o.ds60);
        this.cby = new a(getPageContext(), null);
        this.aDB.setAdapter((ListAdapter) this.cby);
    }

    private void v(View view) {
        this.aDC = (NoNetworkView) view.findViewById(q.view_no_network);
        this.cbx = (TextView) view.findViewById(q.time);
        this.cbx.setVisibility(8);
        this.aDB = (BdListView) view.findViewById(q.listview);
        this.mPullView = new al(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.aDB.setPullRefresh(this.mPullView);
        this.aOf = new PbListView(getFragmentActivity());
        this.aOf.ng();
        this.aOf.cy(TbadkCoreApplication.m411getInst().getSkinType());
        this.aOf.setOnClickListener(new c(this));
        this.mPullView.a(new d(this));
        this.aDB.setOnSrollToBottomListener(this);
        this.aDB.setOnItemClickListener(this);
        this.aDB.setOnScrollListener(this);
    }

    public void clear() {
        at(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ahq() {
        com.baidu.tieba.recommendfrs.data.b bVar;
        if (this.cby == null) {
            return 0;
        }
        for (int count = this.cby.getCount() - 1; count >= 0; count--) {
            Object item = this.cby.getItem(count);
            if ((item instanceof com.baidu.tieba.recommendfrs.data.b) && (bVar = (com.baidu.tieba.recommendfrs.data.b) item) != null) {
                return bVar.ahy();
            }
        }
        return 0;
    }

    public void a(com.baidu.tieba.recommendfrs.control.a.b bVar) {
        this.cbv = bVar;
    }

    public void a(boolean z, f fVar, boolean z2) {
        List<Object> list;
        this.aDB.completePullRefresh();
        this.aOf.ux();
        this.aKl = false;
        if (z) {
            this.aDJ = true;
        } else {
            this.aDI = true;
        }
        if (fVar != null) {
            this.mHasMore = fVar.getHasMore();
            if (this.mHasMore) {
                if (this.aOf.getView().getParent() == null) {
                    this.aDB.setNextPage(this.aOf);
                }
            } else {
                this.aDB.setNextPage(null);
            }
            List<Object> a = a(z2, fVar);
            if (z2) {
                list = this.cby.CM();
                list.addAll(a);
            } else if (a != null && a.size() > 0) {
                b(fVar.ahC(), fVar.ahG());
                list = a;
            } else {
                b(null, fVar.ahG());
                list = a;
            }
            if (list != null && list.size() <= 0) {
                this.cby.a(aa.a(NoDataViewFactory.ImgType.NODATA), ab.cv(t.invite_friend_no_data_now), (z) null, (FrameLayout.LayoutParams) null);
            }
            this.cby.s(list);
        }
    }

    public void Q(String str, int i) {
        this.aKl = false;
        this.aOf.ux();
        if (this.cby.CN() <= 0 && this.aDI) {
            this.cby.a(aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(o.ds80)), ab.dq(str), (z) null, (FrameLayout.LayoutParams) null);
            this.cby.s(new ArrayList());
        }
        this.aDB.completePullRefresh();
    }

    private void b(List<com.baidu.tieba.recommendfrs.data.a> list, boolean z) {
        if (list == null || list.isEmpty()) {
            if (this.cbw != null) {
                this.aDB.removeHeaderView(this.cbw);
                this.cbw = null;
                return;
            }
            return;
        }
        if (this.cbw == null) {
            ey(z);
            this.cbw.setTitle(UtilHelper.getFixedText(list.get(0).aht(), 14, true));
            this.aDB.addHeaderView(this.cbw);
        }
        this.cbw.setData(list);
    }

    private void ey(boolean z) {
        this.cbw = new k(getFragmentActivity());
        this.cbw.d(getPageContext());
        this.cbw.setIsShowImage(z);
        this.cbw.setCoverFlowViewCallBack(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(String str, String str2) {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_9", "click", 1, new Object[0]);
        sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.c(str, 0L), str2)));
    }

    private List<Object> a(boolean z, f fVar) {
        ArrayList arrayList = new ArrayList();
        if (fVar == null || fVar.ahE() == null) {
            return arrayList;
        }
        String str = null;
        int i = 0;
        for (EverydayThread everydayThread : fVar.ahE()) {
            if (this.cbC && (z || !arrayList.isEmpty())) {
                arrayList.add(new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(everydayThread.show_time.intValue() * 1000)));
            }
            List<FineThreadInfo> list = everydayThread.fine_thread_list;
            if (list != null) {
                if (everydayThread.show_time != null) {
                    i = everydayThread.show_time.intValue();
                    str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(everydayThread.show_time.intValue() * 1000));
                }
                int size = list.size();
                int i2 = 0;
                while (i2 < size) {
                    FineThreadInfo fineThreadInfo = list.get(i2);
                    if (fineThreadInfo != null) {
                        com.baidu.tieba.recommendfrs.data.b bVar = new com.baidu.tieba.recommendfrs.data.b();
                        bVar.a(fineThreadInfo);
                        bVar.jb(str);
                        bVar.eA(i2 != size + (-1));
                        bVar.eB(fVar.ahG());
                        arrayList.add(bVar);
                    }
                    i2++;
                }
            }
        }
        if (i >= this.cbD) {
            this.cbD = i;
            List<Hot_Thread> ahD = fVar.ahD();
            if (ahD != null && ahD.size() > 0) {
                arrayList.add(new com.baidu.tieba.recommendfrs.data.d("text_type_title", str));
                arrayList.addAll(a(ahD, str, fVar.ahG()));
                arrayList.add(new com.baidu.tieba.recommendfrs.data.d("text_type_check_more", str));
            }
        }
        if (!arrayList.isEmpty() && (arrayList.get(arrayList.size() - 1) instanceof com.baidu.tieba.recommendfrs.data.b)) {
            com.baidu.tieba.recommendfrs.data.b bVar2 = (com.baidu.tieba.recommendfrs.data.b) arrayList.get(arrayList.size() - 1);
            if (this.cbC) {
                bVar2.eA(false);
            } else {
                bVar2.eA(true);
            }
        }
        return arrayList;
    }

    private List<com.baidu.tieba.recommendfrs.data.c> a(List<Hot_Thread> list, String str, boolean z) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Hot_Thread hot_Thread : list) {
            if (hot_Thread != null) {
                new com.baidu.tieba.recommendfrs.data.c(hot_Thread, str).eB(z);
                arrayList.add(new com.baidu.tieba.recommendfrs.data.c(hot_Thread, str));
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v12 long)] */
    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        Object item = this.cby.getItem(i);
        if (item instanceof com.baidu.tieba.recommendfrs.data.b) {
            com.baidu.tieba.recommendfrs.data.b bVar = (com.baidu.tieba.recommendfrs.data.b) item;
            String str = (bVar.ahx() == null || bVar.ahx().isEmpty()) ? null : bVar.ahx().get(0);
            TiebaStatic.eventStat(getFragmentActivity(), "kantie_card", null, 1, PbChosenActivityConfig.KEY_TID, Long.valueOf(bVar.ahw()));
            aX(String.valueOf(bVar.ahw()), str);
            l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && !readThreadHistory.jL(String.valueOf(bVar.ahw()))) {
                readThreadHistory.jK(String.valueOf(bVar.ahw()));
                this.cby.y(item);
            }
        } else if (item instanceof com.baidu.tieba.recommendfrs.data.c) {
            TiebaStatic.eventStat(getActivity(), "kantie_3", null);
            long longValue = ((com.baidu.tieba.recommendfrs.data.c) item).ahA().thread_id.longValue();
            TiebaStatic.eventStat(getFragmentActivity(), "kantie_card", null, 1, PbChosenActivityConfig.KEY_TID, Long.valueOf(longValue));
            sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(new StringBuilder().append(longValue).toString(), null, "")));
        } else if ((item instanceof com.baidu.tieba.recommendfrs.data.d) && ((com.baidu.tieba.recommendfrs.data.d) item).getType() == "text_type_check_more" && bq.ae(getActivity())) {
            TiebaStatic.eventStat(getActivity(), "kantie_4", null);
            sendMessage(new CustomMessage(2002001, new ChosenPostActivityConfig(getActivity())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i == 1 || !this.cbC) {
            this.cbx.setVisibility(8);
            return;
        }
        Object item = this.cby.getItem(i - this.aDB.getHeaderViewsCount());
        if (item instanceof String) {
            this.cbx.setText((String) item);
            this.cbx.setVisibility(0);
        } else if (item instanceof h) {
            this.cbx.setVisibility(0);
            this.cbx.setText(((h) item).ahI());
        }
        if (this.cby.getItem(this.aDB.pointToPosition(0, this.cbx.getBottom() + 5) - this.aDB.getHeaderViewsCount()) instanceof String) {
            ez(true);
        } else {
            ez(false);
        }
    }

    private void ez(boolean z) {
        View childAt = this.aDB.getChildAt(0);
        int bottom = childAt != null ? childAt.getBottom() : 0;
        if (z && bottom < this.cbz[1]) {
            this.cbx.layout(0, bottom - this.cbz[1], this.cbz[0], bottom);
        } else {
            this.cbx.layout(0, 0, this.cbz[0], this.cbz[1]);
        }
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (this.mHasMore && n.isNetOk() && !this.aKl) {
            this.aKl = true;
            this.aOf.startLoadData();
            this.cbv.B(ahq(), this.cbB);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.f.a.a(getPageContext(), getView());
        if (this.cby != null) {
            this.cby.a(getPageContext(), i);
        }
        if (this.cbw != null) {
            this.cbw.d(getPageContext());
        }
        if (this.aDC != null) {
            this.aDC.onChangeSkinType(getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.cy(i);
        }
        if (this.aOf != null) {
            this.aOf.cy(i);
        }
    }

    public void iV(String str) {
        this.cbB = str;
        if (TextUtils.equals(str, "头条")) {
            this.cbC = true;
        }
    }
}
