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
    private ArrayList<com.baidu.tieba.yuyinala.data.c> hWG;
    private BdListView hWz;
    private String mRoomId;
    private View mRootView;
    private com.baidu.tieba.yuyinala.adapter.a oAv;
    private com.baidu.tieba.yuyinala.view.a oAw;
    private AlaRankListHeaderView oAx;
    private g oAy;
    private AlaRankListActivity ohZ;

    /* loaded from: classes4.dex */
    public interface a {
        void ef(View view);
    }

    public b(AlaRankListActivity alaRankListActivity, String str) {
        this.ohZ = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.ohZ).inflate(a.g.yuyin_ala_rank_fragment_layout, (ViewGroup) null);
        this.hWz = (BdListView) this.mRootView.findViewById(a.f.ala_rank_list_view);
        this.oAv = new com.baidu.tieba.yuyinala.adapter.a(this.ohZ, this.mRoomId);
        this.hWz.setAdapter((ListAdapter) this.oAv);
        this.oAx = new AlaRankListHeaderView(this.ohZ, this.mRoomId);
        this.hWz.addHeaderView(this.oAx);
        this.bXZ = (LinearLayout) LayoutInflater.from(this.ohZ).inflate(a.g.yuyin_hour_rank_list_footer_view, (ViewGroup) null);
        this.bYa = (TextView) this.bXZ.findViewById(a.f.tv_footer);
        this.hWz.addFooterView(this.bXZ);
        this.bXZ.setVisibility(0);
        this.btb = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
        this.oAw = new com.baidu.tieba.yuyinala.view.a(this.ohZ, this.mRoomId);
        this.btb.addView(this.oAw.getView(), new LinearLayout.LayoutParams(-1, -2));
        this.btg = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_rank_list_empty);
        this.hWz.setEmptyView(this.btg);
        this.oAw.a(new a() { // from class: com.baidu.tieba.yuyinala.view.b.1
            @Override // com.baidu.tieba.yuyinala.view.b.a
            public void ef(View view) {
                MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tieba.yuyinala.data.c> arrayList) {
        if (this.oAv != null) {
            this.hWG = arrayList;
            this.oAv.setData(arrayList);
        }
    }

    public void c(i iVar) {
        this.oAx.b(iVar);
    }

    public void xM(int i) {
        if (this.oAx != null) {
            this.oAx.setHourHeaderInfoVisible(i);
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
        this.hWz.setVisibility(i);
    }

    public void b(g gVar) {
        if (gVar == null) {
            if (this.oAw != null) {
                this.oAw.getView().setVisibility(8);
                return;
            }
            return;
        }
        this.oAy = gVar;
        View view = null;
        if (this.oAw != null) {
            this.oAw.a(gVar);
            this.oAw.getView().setVisibility(0);
            view = this.oAw.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
        }
    }

    public void cps() {
        if (this.oAw != null) {
            this.oAw.getView().setVisibility(8);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.btg.reset();
        this.btg.setTitle("网络不给力，请稍后重试");
        this.btg.setRefreshButton("重新加载", onClickListener);
        this.btg.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.btg.setTextColor(this.ohZ.getResources().getColor(a.c.sdk_color_525252));
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
            this.btg.setTextColor(this.ohZ.getResources().getColor(a.c.sdk_color_525252));
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
