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
/* loaded from: classes11.dex */
public class b {
    private LinearLayout bwE;
    private CommonEmptyView bwJ;
    private LinearLayout cdZ;
    private BdListView ijC;
    private ArrayList<com.baidu.tieba.yuyinala.data.c> ijJ;
    private String mRoomId;
    private View mRootView;
    private com.baidu.tieba.yuyinala.adapter.a oOq;
    private com.baidu.tieba.yuyinala.view.a oOr;
    private AlaRankListHeaderView oOs;
    private g oOt;
    private TextView oOu;
    private AlaRankListActivity opx;

    /* loaded from: classes11.dex */
    public interface a {
        void en(View view);
    }

    public b(AlaRankListActivity alaRankListActivity, String str) {
        this.opx = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.opx).inflate(a.g.yuyin_ala_rank_fragment_layout, (ViewGroup) null);
        this.ijC = (BdListView) this.mRootView.findViewById(a.f.ala_rank_list_view);
        this.oOq = new com.baidu.tieba.yuyinala.adapter.a(this.opx, this.mRoomId);
        this.ijC.setAdapter((ListAdapter) this.oOq);
        this.oOs = new AlaRankListHeaderView(this.opx, this.mRoomId);
        this.ijC.addHeaderView(this.oOs);
        this.cdZ = (LinearLayout) LayoutInflater.from(this.opx).inflate(a.g.yuyin_hour_rank_list_footer_view, (ViewGroup) null);
        this.oOu = (TextView) this.cdZ.findViewById(a.f.tv_footer);
        this.ijC.addFooterView(this.cdZ);
        this.cdZ.setVisibility(0);
        this.bwE = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
        this.oOr = new com.baidu.tieba.yuyinala.view.a(this.opx, this.mRoomId);
        this.bwE.addView(this.oOr.getView(), new LinearLayout.LayoutParams(-1, -2));
        this.bwJ = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_rank_list_empty);
        this.ijC.setEmptyView(this.bwJ);
        this.oOr.a(new a() { // from class: com.baidu.tieba.yuyinala.view.b.1
            @Override // com.baidu.tieba.yuyinala.view.b.a
            public void en(View view) {
                MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tieba.yuyinala.data.c> arrayList) {
        if (this.oOq != null) {
            this.ijJ = arrayList;
            this.oOq.setData(arrayList);
        }
    }

    public void c(i iVar) {
        this.oOs.b(iVar);
    }

    public void wE(int i) {
        if (this.oOs != null) {
            this.oOs.setHourHeaderInfoVisible(i);
        }
    }

    public void fv(int i) {
        if (this.cdZ != null) {
            this.cdZ.setVisibility(i);
        }
    }

    public void WW(String str) {
        if (this.oOu != null) {
            this.oOu.setText(str);
        }
    }

    public void wF(int i) {
        this.ijC.setVisibility(i);
    }

    public void b(g gVar) {
        if (gVar == null) {
            if (this.oOr != null) {
                this.oOr.getView().setVisibility(8);
                return;
            }
            return;
        }
        this.oOt = gVar;
        View view = null;
        if (this.oOr != null) {
            this.oOr.a(gVar);
            this.oOr.getView().setVisibility(0);
            view = this.oOr.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
        }
    }

    public void cpH() {
        if (this.oOr != null) {
            this.oOr.getView().setVisibility(8);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        this.bwJ.reset();
        this.bwJ.setTitle("网络不给力，请稍后重试");
        this.bwJ.setRefreshButton("重新加载", onClickListener);
        this.bwJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bwJ.setTextColor(this.opx.getResources().getColor(a.c.sdk_color_525252));
        this.bwJ.setVisibility(0);
    }

    public void WZ() {
        this.bwJ.setVisibility(8);
    }

    public void dQ(boolean z) {
        if (z) {
            this.bwJ.reset();
            this.bwJ.setTitle("还没有房间上榜哦~");
            this.bwJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bwJ.setTextColor(this.opx.getResources().getColor(a.c.sdk_color_525252));
            this.bwJ.setVisibility(0);
            return;
        }
        this.bwJ.setVisibility(8);
    }

    public void release() {
    }

    public View getView() {
        return this.mRootView;
    }
}
