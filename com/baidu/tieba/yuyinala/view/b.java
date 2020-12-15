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
    private LinearLayout bXZ;
    private TextView bYa;
    private LinearLayout btb;
    private CommonEmptyView btg;
    private BdListView hWB;
    private ArrayList<com.baidu.tieba.yuyinala.data.c> hWI;
    private String mRoomId;
    private View mRootView;
    private g oAA;
    private com.baidu.tieba.yuyinala.adapter.a oAx;
    private com.baidu.tieba.yuyinala.view.a oAy;
    private AlaRankListHeaderView oAz;
    private AlaRankListActivity oib;

    /* loaded from: classes4.dex */
    public interface a {
        void ef(View view);
    }

    public b(AlaRankListActivity alaRankListActivity, String str) {
        this.oib = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.oib).inflate(a.g.yuyin_ala_rank_fragment_layout, (ViewGroup) null);
        this.hWB = (BdListView) this.mRootView.findViewById(a.f.ala_rank_list_view);
        this.oAx = new com.baidu.tieba.yuyinala.adapter.a(this.oib, this.mRoomId);
        this.hWB.setAdapter((ListAdapter) this.oAx);
        this.oAz = new AlaRankListHeaderView(this.oib, this.mRoomId);
        this.hWB.addHeaderView(this.oAz);
        this.bXZ = (LinearLayout) LayoutInflater.from(this.oib).inflate(a.g.yuyin_hour_rank_list_footer_view, (ViewGroup) null);
        this.bYa = (TextView) this.bXZ.findViewById(a.f.tv_footer);
        this.hWB.addFooterView(this.bXZ);
        this.bXZ.setVisibility(0);
        this.btb = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
        this.oAy = new com.baidu.tieba.yuyinala.view.a(this.oib, this.mRoomId);
        this.btb.addView(this.oAy.getView(), new LinearLayout.LayoutParams(-1, -2));
        this.btg = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_rank_list_empty);
        this.hWB.setEmptyView(this.btg);
        this.oAy.a(new a() { // from class: com.baidu.tieba.yuyinala.view.b.1
            @Override // com.baidu.tieba.yuyinala.view.b.a
            public void ef(View view) {
                MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tieba.yuyinala.data.c> arrayList) {
        if (this.oAx != null) {
            this.hWI = arrayList;
            this.oAx.setData(arrayList);
        }
    }

    public void c(i iVar) {
        this.oAz.b(iVar);
    }

    public void xM(int i) {
        if (this.oAz != null) {
            this.oAz.setHourHeaderInfoVisible(i);
        }
    }

    public void gV(int i) {
        if (this.bXZ != null) {
            this.bXZ.setVisibility(i);
        }
    }

    public void Xg(String str) {
        if (this.bYa != null) {
            this.bYa.setText(str);
        }
    }

    public void xN(int i) {
        this.hWB.setVisibility(i);
    }

    public void b(g gVar) {
        if (gVar == null) {
            if (this.oAy != null) {
                this.oAy.getView().setVisibility(8);
                return;
            }
            return;
        }
        this.oAA = gVar;
        View view = null;
        if (this.oAy != null) {
            this.oAy.a(gVar);
            this.oAy.getView().setVisibility(0);
            view = this.oAy.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
        }
    }

    public void cpt() {
        if (this.oAy != null) {
            this.oAy.getView().setVisibility(8);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.btg.reset();
        this.btg.setTitle("网络不给力，请稍后重试");
        this.btg.setRefreshButton("重新加载", onClickListener);
        this.btg.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.btg.setTextColor(this.oib.getResources().getColor(a.c.sdk_color_525252));
        this.btg.setVisibility(0);
    }

    public void Yb() {
        this.btg.setVisibility(8);
    }

    public void dG(boolean z) {
        if (z) {
            this.btg.reset();
            this.btg.setTitle("还没有房间上榜哦~");
            this.btg.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.btg.setTextColor(this.oib.getResources().getColor(a.c.sdk_color_525252));
            this.btg.setVisibility(0);
            return;
        }
        this.btg.setVisibility(8);
    }

    public void release() {
    }

    public View getView() {
        return this.mRootView;
    }
}
