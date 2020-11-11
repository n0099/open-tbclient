package com.baidu.tieba.yuyinala.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.message.SupportRoom;
import com.baidu.live.message.YuyinSupportRoomMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import com.baidu.tieba.yuyinala.data.g;
import com.baidu.tieba.yuyinala.data.i;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {
    private LinearLayout bUt;
    private TextView bUu;
    private LinearLayout bpE;
    private CommonEmptyView bpJ;
    private BdListView hLY;
    private ArrayList<com.baidu.tieba.yuyinala.data.c> hMf;
    private String mRoomId;
    private View mRootView;
    private AlaRankListActivity nRy;
    private com.baidu.tieba.yuyinala.adapter.a ojS;
    private com.baidu.tieba.yuyinala.view.a ojT;
    private AlaRankListHeaderView ojU;
    private g ojV;

    /* loaded from: classes4.dex */
    public interface a {
        void dN(View view);
    }

    public b(AlaRankListActivity alaRankListActivity, String str) {
        this.nRy = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nRy).inflate(a.g.yuyin_ala_rank_fragment_layout, (ViewGroup) null);
        this.hLY = (BdListView) this.mRootView.findViewById(a.f.ala_rank_list_view);
        this.ojS = new com.baidu.tieba.yuyinala.adapter.a(this.nRy, this.mRoomId);
        this.hLY.setAdapter((ListAdapter) this.ojS);
        this.ojU = new AlaRankListHeaderView(this.nRy, this.mRoomId);
        this.hLY.addHeaderView(this.ojU);
        this.bUt = (LinearLayout) LayoutInflater.from(this.nRy).inflate(a.g.yuyin_hour_rank_list_footer_view, (ViewGroup) null);
        this.bUu = (TextView) this.bUt.findViewById(a.f.tv_footer);
        this.hLY.addFooterView(this.bUt);
        this.bUt.setVisibility(0);
        this.bpE = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
        this.ojT = new com.baidu.tieba.yuyinala.view.a(this.nRy, this.mRoomId);
        this.bpE.addView(this.ojT.getView(), new LinearLayout.LayoutParams(-1, -2));
        this.bpJ = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_rank_list_empty);
        this.hLY.setEmptyView(this.bpJ);
        this.ojT.a(new a() { // from class: com.baidu.tieba.yuyinala.view.b.1
            @Override // com.baidu.tieba.yuyinala.view.b.a
            public void dN(View view) {
                MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tieba.yuyinala.data.c> arrayList) {
        if (this.ojS != null) {
            this.hMf = arrayList;
            this.ojS.setData(arrayList);
        }
    }

    public void c(i iVar) {
        this.ojU.b(iVar);
    }

    public void wI(int i) {
        if (this.ojU != null) {
            this.ojU.setHourHeaderInfoVisible(i);
        }
    }

    public void gB(int i) {
        if (this.bUt != null) {
            this.bUt.setVisibility(i);
        }
    }

    public void Wg(String str) {
        if (this.bUu != null) {
            this.bUu.setText(str);
        }
    }

    public void wJ(int i) {
        this.hLY.setVisibility(i);
    }

    public void b(g gVar) {
        if (gVar == null) {
            if (this.ojT != null) {
                this.ojT.getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ojV = gVar;
        View view = null;
        if (this.ojT != null) {
            this.ojT.a(gVar);
            this.ojT.getView().setVisibility(0);
            view = this.ojT.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
        }
    }

    public void clK() {
        if (this.ojT != null) {
            this.ojT.getView().setVisibility(8);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.bpJ.reset();
        this.bpJ.setTitle("网络不给力，请稍后重试");
        this.bpJ.setRefreshButton("重新加载", onClickListener);
        this.bpJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bpJ.setTextColor(this.nRy.getResources().getColor(a.c.sdk_color_525252));
        this.bpJ.setVisibility(0);
    }

    public void Wk() {
        this.bpJ.setVisibility(8);
    }

    public void dq(boolean z) {
        if (z) {
            this.bpJ.reset();
            this.bpJ.setTitle("还没有房间上榜哦~");
            this.bpJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bpJ.setTextColor(this.nRy.getResources().getColor(a.c.sdk_color_525252));
            this.bpJ.setVisibility(0);
            return;
        }
        this.bpJ.setVisibility(8);
    }

    public void release() {
    }

    public View getView() {
        return this.mRootView;
    }
}
