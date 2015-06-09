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
    private BdListView aDC;
    private NoNetworkView aDD;
    private boolean aDJ;
    private boolean aDK;
    private boolean aKm;
    private PbListView aOg;
    private int[] cbA;
    private long cbB;
    private String cbC;
    private boolean cbD = false;
    private int cbE = 0;
    private com.baidu.tieba.recommendfrs.control.a.b cbw;
    private k cbx;
    private TextView cby;
    private a cbz;
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
            this.cbB = System.currentTimeMillis();
            TiebaStatic.eventStat(getFragmentActivity(), "kantie_entry", null);
            if (this.aDK) {
                at(true);
                return;
            } else if (this.aDJ && !n.isNetOk()) {
                at(true);
                return;
            } else if (isShow()) {
                this.aDC.no();
                return;
            } else {
                return;
            }
        }
        TiebaStatic.eventStat(getFragmentActivity(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.cbB) / 1000));
    }

    private void at(boolean z) {
        if (this.cbz != null) {
            for (Object obj : this.cbz.CN()) {
                if (obj instanceof com.baidu.tieba.recommendfrs.data.b) {
                    ((com.baidu.tieba.recommendfrs.data.b) obj).eB(z);
                } else if (obj instanceof com.baidu.tieba.recommendfrs.data.c) {
                    ((com.baidu.tieba.recommendfrs.data.c) obj).eB(z);
                }
            }
            if (this.cbx != null) {
                this.cbx.setIsShowImage(z);
            }
            this.cbz.notifyDataSetChanged();
            System.gc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        v(getView());
        this.cbA = new int[2];
        this.cbA[0] = n.M(getFragmentActivity());
        this.cbA[1] = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(o.ds60);
        this.cbz = new a(getPageContext(), null);
        this.aDC.setAdapter((ListAdapter) this.cbz);
    }

    private void v(View view) {
        this.aDD = (NoNetworkView) view.findViewById(q.view_no_network);
        this.cby = (TextView) view.findViewById(q.time);
        this.cby.setVisibility(8);
        this.aDC = (BdListView) view.findViewById(q.listview);
        this.mPullView = new al(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.aDC.setPullRefresh(this.mPullView);
        this.aOg = new PbListView(getFragmentActivity());
        this.aOg.ng();
        this.aOg.cy(TbadkCoreApplication.m411getInst().getSkinType());
        this.aOg.setOnClickListener(new c(this));
        this.mPullView.a(new d(this));
        this.aDC.setOnSrollToBottomListener(this);
        this.aDC.setOnItemClickListener(this);
        this.aDC.setOnScrollListener(this);
    }

    public void clear() {
        at(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ahr() {
        com.baidu.tieba.recommendfrs.data.b bVar;
        if (this.cbz == null) {
            return 0;
        }
        for (int count = this.cbz.getCount() - 1; count >= 0; count--) {
            Object item = this.cbz.getItem(count);
            if ((item instanceof com.baidu.tieba.recommendfrs.data.b) && (bVar = (com.baidu.tieba.recommendfrs.data.b) item) != null) {
                return bVar.ahz();
            }
        }
        return 0;
    }

    public void a(com.baidu.tieba.recommendfrs.control.a.b bVar) {
        this.cbw = bVar;
    }

    public void a(boolean z, f fVar, boolean z2) {
        List<Object> list;
        this.aDC.completePullRefresh();
        this.aOg.ux();
        this.aKm = false;
        if (z) {
            this.aDK = true;
        } else {
            this.aDJ = true;
        }
        if (fVar != null) {
            this.mHasMore = fVar.getHasMore();
            if (this.mHasMore) {
                if (this.aOg.getView().getParent() == null) {
                    this.aDC.setNextPage(this.aOg);
                }
            } else {
                this.aDC.setNextPage(null);
            }
            List<Object> a = a(z2, fVar);
            if (z2) {
                list = this.cbz.CN();
                list.addAll(a);
            } else if (a != null && a.size() > 0) {
                b(fVar.ahD(), fVar.ahH());
                list = a;
            } else {
                b(null, fVar.ahH());
                list = a;
            }
            if (list != null && list.size() <= 0) {
                this.cbz.a(aa.a(NoDataViewFactory.ImgType.NODATA), ab.cv(t.invite_friend_no_data_now), (z) null, (FrameLayout.LayoutParams) null);
            }
            this.cbz.s(list);
        }
    }

    public void Q(String str, int i) {
        this.aKm = false;
        if (this.aOg != null) {
            this.aOg.ux();
        }
        if (this.cbz.CO() <= 0 && this.aDJ) {
            this.cbz.a(aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(o.ds80)), ab.dq(str), (z) null, (FrameLayout.LayoutParams) null);
            this.cbz.s(new ArrayList());
        }
        this.aDC.completePullRefresh();
    }

    private void b(List<com.baidu.tieba.recommendfrs.data.a> list, boolean z) {
        if (list == null || list.isEmpty()) {
            if (this.cbx != null) {
                this.aDC.removeHeaderView(this.cbx);
                this.cbx = null;
                return;
            }
            return;
        }
        if (this.cbx == null) {
            ey(z);
            this.cbx.setTitle(UtilHelper.getFixedText(list.get(0).ahu(), 14, true));
            this.aDC.addHeaderView(this.cbx);
        }
        this.cbx.setData(list);
    }

    private void ey(boolean z) {
        this.cbx = new k(getFragmentActivity());
        this.cbx.d(getPageContext());
        this.cbx.setIsShowImage(z);
        this.cbx.setCoverFlowViewCallBack(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(String str, String str2) {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_9", "click", 1, new Object[0]);
        sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.c(str, 0L), str2)));
    }

    private List<Object> a(boolean z, f fVar) {
        ArrayList arrayList = new ArrayList();
        if (fVar == null || fVar.ahF() == null) {
            return arrayList;
        }
        String str = null;
        int i = 0;
        for (EverydayThread everydayThread : fVar.ahF()) {
            if (this.cbD && (z || !arrayList.isEmpty())) {
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
                        bVar.eB(fVar.ahH());
                        arrayList.add(bVar);
                    }
                    i2++;
                }
            }
        }
        if (i >= this.cbE) {
            this.cbE = i;
            List<Hot_Thread> ahE = fVar.ahE();
            if (ahE != null && ahE.size() > 0) {
                arrayList.add(new com.baidu.tieba.recommendfrs.data.d("text_type_title", str));
                arrayList.addAll(a(ahE, str, fVar.ahH()));
                arrayList.add(new com.baidu.tieba.recommendfrs.data.d("text_type_check_more", str));
            }
        }
        if (!arrayList.isEmpty() && (arrayList.get(arrayList.size() - 1) instanceof com.baidu.tieba.recommendfrs.data.b)) {
            com.baidu.tieba.recommendfrs.data.b bVar2 = (com.baidu.tieba.recommendfrs.data.b) arrayList.get(arrayList.size() - 1);
            if (this.cbD) {
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
        Object item = this.cbz.getItem(i);
        if (item instanceof com.baidu.tieba.recommendfrs.data.b) {
            com.baidu.tieba.recommendfrs.data.b bVar = (com.baidu.tieba.recommendfrs.data.b) item;
            String str = (bVar.ahy() == null || bVar.ahy().isEmpty()) ? null : bVar.ahy().get(0);
            TiebaStatic.eventStat(getFragmentActivity(), "kantie_card", null, 1, PbChosenActivityConfig.KEY_TID, Long.valueOf(bVar.ahx()));
            aX(String.valueOf(bVar.ahx()), str);
            l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && !readThreadHistory.jL(String.valueOf(bVar.ahx()))) {
                readThreadHistory.jK(String.valueOf(bVar.ahx()));
                this.cbz.y(item);
            }
        } else if (item instanceof com.baidu.tieba.recommendfrs.data.c) {
            TiebaStatic.eventStat(getActivity(), "kantie_3", null);
            long longValue = ((com.baidu.tieba.recommendfrs.data.c) item).ahB().thread_id.longValue();
            TiebaStatic.eventStat(getFragmentActivity(), "kantie_card", null, 1, PbChosenActivityConfig.KEY_TID, Long.valueOf(longValue));
            sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(new StringBuilder().append(longValue).toString(), null, "")));
        } else if ((item instanceof com.baidu.tieba.recommendfrs.data.d) && ((com.baidu.tieba.recommendfrs.data.d) item).getType() == "text_type_check_more" && bq.ae(getActivity())) {
            TiebaStatic.eventStat(getActivity(), "kantie_4", null);
            sendMessage(new CustomMessage(2002001, new ChosenPostActivityConfig(getActivity())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i == 1 || !this.cbD) {
            this.cby.setVisibility(8);
            return;
        }
        Object item = this.cbz.getItem(i - this.aDC.getHeaderViewsCount());
        if (item instanceof String) {
            this.cby.setText((String) item);
            this.cby.setVisibility(0);
        } else if (item instanceof h) {
            this.cby.setVisibility(0);
            this.cby.setText(((h) item).ahJ());
        }
        if (this.cbz.getItem(this.aDC.pointToPosition(0, this.cby.getBottom() + 5) - this.aDC.getHeaderViewsCount()) instanceof String) {
            ez(true);
        } else {
            ez(false);
        }
    }

    private void ez(boolean z) {
        View childAt = this.aDC.getChildAt(0);
        int bottom = childAt != null ? childAt.getBottom() : 0;
        if (z && bottom < this.cbA[1]) {
            this.cby.layout(0, bottom - this.cbA[1], this.cbA[0], bottom);
        } else {
            this.cby.layout(0, 0, this.cbA[0], this.cbA[1]);
        }
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (this.mHasMore && n.isNetOk() && !this.aKm) {
            this.aKm = true;
            this.aOg.startLoadData();
            this.cbw.B(ahr(), this.cbC);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.f.a.a(getPageContext(), getView());
        if (this.cbz != null) {
            this.cbz.a(getPageContext(), i);
        }
        if (this.cbx != null) {
            this.cbx.d(getPageContext());
        }
        if (this.aDD != null) {
            this.aDD.onChangeSkinType(getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.cy(i);
        }
        if (this.aOg != null) {
            this.aOg.cy(i);
        }
    }

    public void iV(String str) {
        this.cbC = str;
        if (TextUtils.equals(str, "头条")) {
            this.cbD = true;
        }
    }
}
