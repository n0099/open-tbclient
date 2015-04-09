package com.baidu.tieba.recommendfrs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.ag;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.l;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.FineFrsPage.EverydayThread;
import tbclient.FineFrsPage.FineThreadInfo;
/* loaded from: classes.dex */
public class b extends BaseFragment implements x {
    private BdListView aBF;
    private NoNetworkView aBG;
    private boolean aBM;
    private boolean aBN;
    private boolean aId;
    private PbListView aLV;
    private com.baidu.tieba.recommendfrs.a.b bXQ;
    private com.baidu.tieba.recommendfrs.b.c bXR;
    private TextView bXS;
    private com.baidu.tbadk.mvc.j.b<Object, com.baidu.tbadk.mvc.e.c, com.baidu.tbadk.mvc.j.a<Object, com.baidu.tbadk.mvc.e.c>> bXT;
    private int[] bXU;
    private long bXV;
    private boolean mHasMore;
    private ag mPullView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FY();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(w.recommend_frs_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.bXV = System.currentTimeMillis();
            TiebaStatic.eventStat(getFragmentActivity(), "kantie_entry", null);
            if (!this.aBN) {
                if (!this.aBM || n.isNetOk()) {
                    this.aBF.mX();
                    return;
                }
                return;
            }
            return;
        }
        TiebaStatic.eventStat(getFragmentActivity(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.bXV) / 1000));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        s(getView());
        this.bXU = new int[2];
        this.bXU[0] = n.M(getFragmentActivity());
        this.bXU[1] = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.ds60);
        this.bXT = new c(this, getPageContext(), new Class[]{com.baidu.tieba.recommendfrs.b.a.class, com.baidu.tieba.recommendfrs.b.b.class, com.baidu.tieba.recommendfrs.b.e.class}, new int[]{w.recommend_frs_item_pic, w.recommend_frs_item_pics, w.recommend_frs_item_time_divider}, null);
        this.aBF.setAdapter((ListAdapter) this.bXT);
    }

    private void s(View view) {
        this.aBG = (NoNetworkView) view.findViewById(v.view_no_network);
        this.bXS = (TextView) view.findViewById(v.time);
        this.bXS.setVisibility(8);
        this.aBF = (BdListView) view.findViewById(v.listview);
        this.mPullView = new ag(getPageContext());
        this.aBF.setPullRefresh(this.mPullView);
        this.aLV = new PbListView(getFragmentActivity());
        this.aLV.mN();
        this.mPullView.a(new d(this));
        this.aBF.setOnSrollToBottomListener(this);
        this.aBF.setOnItemClickListener(this);
        this.aBF.setOnScrollListener(this);
    }

    private int afM() {
        com.baidu.tieba.recommendfrs.data.b bVar;
        if (this.bXT == null) {
            return 0;
        }
        Object item = this.bXT.getItem(this.bXT.getCount() - 1);
        if (!(item instanceof com.baidu.tieba.recommendfrs.data.b) || (bVar = (com.baidu.tieba.recommendfrs.data.b) item) == null) {
            return 0;
        }
        return bVar.afR();
    }

    private void FY() {
        this.bXQ = new com.baidu.tieba.recommendfrs.a.b(getPageContext());
        this.bXQ.a(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(List<com.baidu.tieba.recommendfrs.data.a> list) {
        if (list == null || list.isEmpty()) {
            if (this.bXR != null) {
                this.aBF.removeHeaderView(this.bXR);
                this.bXR = null;
                return;
            }
            return;
        }
        if (this.bXR == null) {
            afN();
            this.bXR.setTitle(UtilHelper.getFixedText(list.get(0).afO(), 14, true));
            this.aBF.addHeaderView(this.bXR);
        }
        this.bXR.setData(list);
    }

    private void afN() {
        this.bXR = new com.baidu.tieba.recommendfrs.b.c(getFragmentActivity());
        this.bXR.f(getPageContext());
        this.bXR.setCoverFlowViewCallBack(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(String str, String str2) {
        sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(str, 0L), str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Object> a(boolean z, com.baidu.tieba.recommendfrs.data.c cVar) {
        ArrayList arrayList = new ArrayList();
        if (cVar == null || cVar.afV() == null) {
            return arrayList;
        }
        for (EverydayThread everydayThread : cVar.afV()) {
            if (z || !arrayList.isEmpty()) {
                arrayList.add(everydayThread.show_time);
            }
            List<FineThreadInfo> list = everydayThread.fine_thread_list;
            if (list != null) {
                int intValue = everydayThread.show_time != null ? everydayThread.show_time.intValue() : 0;
                int size = list.size();
                int i = 0;
                while (i < size) {
                    FineThreadInfo fineThreadInfo = list.get(i);
                    if (fineThreadInfo != null) {
                        com.baidu.tieba.recommendfrs.data.b bVar = new com.baidu.tieba.recommendfrs.data.b();
                        bVar.a(fineThreadInfo);
                        bVar.hN(intValue);
                        bVar.el(i != size + (-1));
                        arrayList.add(bVar);
                    }
                    i++;
                }
            }
        }
        if (!arrayList.isEmpty() && (arrayList.get(arrayList.size() - 1) instanceof com.baidu.tieba.recommendfrs.data.b)) {
            ((com.baidu.tieba.recommendfrs.data.b) arrayList.get(arrayList.size() - 1)).el(true);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = null;
        super.onItemClick(adapterView, view, i, j);
        TiebaStatic.eventStat(getFragmentActivity(), "kantie_card", null);
        Object item = this.bXT.getItem(i);
        if (item instanceof com.baidu.tieba.recommendfrs.data.b) {
            com.baidu.tieba.recommendfrs.data.b bVar = (com.baidu.tieba.recommendfrs.data.b) item;
            if (bVar.afQ() != null && !bVar.afQ().isEmpty()) {
                str = bVar.afQ().get(0);
            }
            aS(String.valueOf(bVar.afP()), str);
            l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && !readThreadHistory.iR(String.valueOf(bVar.afP()))) {
                readThreadHistory.iQ(String.valueOf(bVar.afP()));
                this.bXT.y(item);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i == 1) {
            this.bXS.setVisibility(8);
            return;
        }
        Object item = this.bXT.getItem(i - this.aBF.getHeaderViewsCount());
        if (item instanceof Integer) {
            this.bXS.setText(com.baidu.tieba.recommendfrs.a.b.hQ(((Integer) item).intValue()));
            this.bXS.setVisibility(0);
        }
        if (this.bXT.getItem(this.aBF.pointToPosition(0, this.bXS.getBottom() + 5) - this.aBF.getHeaderViewsCount()) instanceof Integer) {
            if (item instanceof com.baidu.tieba.recommendfrs.data.b) {
                this.bXS.setText(com.baidu.tieba.recommendfrs.a.b.hQ(((com.baidu.tieba.recommendfrs.data.b) item).afS()));
            }
            ek(true);
            return;
        }
        ek(false);
    }

    private void ek(boolean z) {
        View childAt = this.aBF.getChildAt(0);
        int bottom = childAt != null ? childAt.getBottom() : 0;
        if (z && bottom < this.bXU[1]) {
            this.bXS.layout(0, bottom - this.bXU[1], this.bXU[0], bottom);
        } else {
            this.bXS.layout(0, 0, this.bXU[0], this.bXU[1]);
        }
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (this.mHasMore && n.isNetOk() && !this.aId) {
            this.aId = true;
            this.aLV.startLoadData();
            this.bXQ.hP(afM());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.f.a.a(getPageContext(), getView());
        if (this.bXT != null) {
            this.bXT.a(getPageContext(), i);
        }
        if (this.bXR != null) {
            this.bXR.f(getPageContext());
        }
        if (this.aBG != null) {
            this.aBG.onChangeSkinType(getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.ct(i);
        }
        if (this.aLV != null) {
            this.aLV.ct(i);
        }
    }
}
