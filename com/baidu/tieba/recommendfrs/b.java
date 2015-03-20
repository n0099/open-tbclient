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
    private boolean aBE;
    private boolean aBF;
    private BdListView aBx;
    private NoNetworkView aBy;
    private boolean aHV;
    private com.baidu.tieba.recommendfrs.a.b bXA;
    private com.baidu.tieba.recommendfrs.b.c bXB;
    private PbListView bXC;
    private TextView bXD;
    private com.baidu.tbadk.mvc.j.b<Object, com.baidu.tbadk.mvc.e.c, com.baidu.tbadk.mvc.j.a<Object, com.baidu.tbadk.mvc.e.c>> bXE;
    private int[] bXF;
    private long bXG;
    private boolean mHasMore;
    private ag mPullView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FS();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(w.recommend_frs_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.bXG = System.currentTimeMillis();
            TiebaStatic.eventStat(getFragmentActivity(), "kantie_entry", null);
            if (!this.aBF) {
                if (!this.aBE || n.isNetOk()) {
                    this.aBx.mX();
                    return;
                }
                return;
            }
            return;
        }
        TiebaStatic.eventStat(getFragmentActivity(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.bXG) / 1000));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        s(getView());
        this.bXF = new int[2];
        this.bXF[0] = n.M(getFragmentActivity());
        this.bXF[1] = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.ds60);
        this.bXE = new c(this, getPageContext(), new Class[]{com.baidu.tieba.recommendfrs.b.a.class, com.baidu.tieba.recommendfrs.b.b.class, com.baidu.tieba.recommendfrs.b.e.class}, new int[]{w.recommend_frs_item_pic, w.recommend_frs_item_pics, w.recommend_frs_item_time_divider}, null);
        this.aBx.setAdapter((ListAdapter) this.bXE);
    }

    private void s(View view) {
        this.aBy = (NoNetworkView) view.findViewById(v.view_no_network);
        this.bXD = (TextView) view.findViewById(v.time);
        this.bXD.setVisibility(8);
        this.aBx = (BdListView) view.findViewById(v.listview);
        this.mPullView = new ag(getPageContext());
        this.aBx.setPullRefresh(this.mPullView);
        this.bXC = new PbListView(getFragmentActivity());
        this.bXC.mN();
        this.mPullView.a(new d(this));
        this.aBx.setOnSrollToBottomListener(this);
        this.aBx.setOnItemClickListener(this);
        this.aBx.setOnScrollListener(this);
    }

    private int afx() {
        com.baidu.tieba.recommendfrs.data.b bVar;
        if (this.bXE == null) {
            return 0;
        }
        Object item = this.bXE.getItem(this.bXE.getCount() - 1);
        if (!(item instanceof com.baidu.tieba.recommendfrs.data.b) || (bVar = (com.baidu.tieba.recommendfrs.data.b) item) == null) {
            return 0;
        }
        return bVar.afC();
    }

    private void FS() {
        this.bXA = new com.baidu.tieba.recommendfrs.a.b(getPageContext());
        this.bXA.a(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(List<com.baidu.tieba.recommendfrs.data.a> list) {
        if (list == null || list.isEmpty()) {
            if (this.bXB != null) {
                this.aBx.removeHeaderView(this.bXB);
                this.bXB = null;
                return;
            }
            return;
        }
        if (this.bXB == null) {
            afy();
            this.bXB.setTitle(UtilHelper.getFixedText(list.get(0).afz(), 14, true));
            this.aBx.addHeaderView(this.bXB);
        }
        this.bXB.setData(list);
    }

    private void afy() {
        this.bXB = new com.baidu.tieba.recommendfrs.b.c(getFragmentActivity());
        this.bXB.f(getPageContext());
        this.bXB.setCoverFlowViewCallBack(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(String str, String str2) {
        sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(str, 0L), str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Object> a(boolean z, com.baidu.tieba.recommendfrs.data.c cVar) {
        ArrayList arrayList = new ArrayList();
        if (cVar == null || cVar.afG() == null) {
            return arrayList;
        }
        for (EverydayThread everydayThread : cVar.afG()) {
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
                        bVar.hK(intValue);
                        bVar.en(i != size + (-1));
                        arrayList.add(bVar);
                    }
                    i++;
                }
            }
        }
        if (!arrayList.isEmpty() && (arrayList.get(arrayList.size() - 1) instanceof com.baidu.tieba.recommendfrs.data.b)) {
            ((com.baidu.tieba.recommendfrs.data.b) arrayList.get(arrayList.size() - 1)).en(true);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = null;
        super.onItemClick(adapterView, view, i, j);
        TiebaStatic.eventStat(getFragmentActivity(), "kantie_card", null);
        Object item = this.bXE.getItem(i);
        if (item instanceof com.baidu.tieba.recommendfrs.data.b) {
            com.baidu.tieba.recommendfrs.data.b bVar = (com.baidu.tieba.recommendfrs.data.b) item;
            if (bVar.afB() != null && !bVar.afB().isEmpty()) {
                str = bVar.afB().get(0);
            }
            aS(String.valueOf(bVar.afA()), str);
            l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && !readThreadHistory.iO(String.valueOf(bVar.afA()))) {
                readThreadHistory.iN(String.valueOf(bVar.afA()));
                this.bXE.y(item);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i == 1) {
            this.bXD.setVisibility(8);
            return;
        }
        Object item = this.bXE.getItem(i - this.aBx.getHeaderViewsCount());
        if (item instanceof Integer) {
            this.bXD.setText(com.baidu.tieba.recommendfrs.a.b.hN(((Integer) item).intValue()));
            this.bXD.setVisibility(0);
        }
        if (this.bXE.getItem(this.aBx.pointToPosition(0, this.bXD.getBottom() + 5) - this.aBx.getHeaderViewsCount()) instanceof Integer) {
            if (item instanceof com.baidu.tieba.recommendfrs.data.b) {
                this.bXD.setText(com.baidu.tieba.recommendfrs.a.b.hN(((com.baidu.tieba.recommendfrs.data.b) item).afD()));
            }
            em(true);
            return;
        }
        em(false);
    }

    private void em(boolean z) {
        View childAt = this.aBx.getChildAt(0);
        int bottom = childAt != null ? childAt.getBottom() : 0;
        if (z && bottom < this.bXF[1]) {
            this.bXD.layout(0, bottom - this.bXF[1], this.bXF[0], bottom);
        } else {
            this.bXD.layout(0, 0, this.bXF[0], this.bXF[1]);
        }
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (this.mHasMore && n.isNetOk() && !this.aHV) {
            this.aHV = true;
            this.bXC.startLoadData();
            this.bXA.hM(afx());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.f.a.a(getPageContext(), getView());
        if (this.bXE != null) {
            this.bXE.a(getPageContext(), i);
        }
        if (this.bXB != null) {
            this.bXB.f(getPageContext());
        }
        if (this.aBy != null) {
            this.aBy.onChangeSkinType(getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.ct(i);
        }
        if (this.bXC != null) {
            this.bXC.ct(i);
        }
    }
}
