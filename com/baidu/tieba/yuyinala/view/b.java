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
    private BdListView ijo;
    private ArrayList<com.baidu.tieba.yuyinala.data.c> ijv;
    private String mRoomId;
    private View mRootView;
    private com.baidu.tieba.yuyinala.adapter.a oNQ;
    private com.baidu.tieba.yuyinala.view.a oNR;
    private AlaRankListHeaderView oNS;
    private g oNT;
    private TextView oNU;
    private AlaRankListActivity ooW;

    /* loaded from: classes11.dex */
    public interface a {
        void en(View view);
    }

    public b(AlaRankListActivity alaRankListActivity, String str) {
        this.ooW = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.ooW).inflate(a.g.yuyin_ala_rank_fragment_layout, (ViewGroup) null);
        this.ijo = (BdListView) this.mRootView.findViewById(a.f.ala_rank_list_view);
        this.oNQ = new com.baidu.tieba.yuyinala.adapter.a(this.ooW, this.mRoomId);
        this.ijo.setAdapter((ListAdapter) this.oNQ);
        this.oNS = new AlaRankListHeaderView(this.ooW, this.mRoomId);
        this.ijo.addHeaderView(this.oNS);
        this.cdZ = (LinearLayout) LayoutInflater.from(this.ooW).inflate(a.g.yuyin_hour_rank_list_footer_view, (ViewGroup) null);
        this.oNU = (TextView) this.cdZ.findViewById(a.f.tv_footer);
        this.ijo.addFooterView(this.cdZ);
        this.cdZ.setVisibility(0);
        this.bwE = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
        this.oNR = new com.baidu.tieba.yuyinala.view.a(this.ooW, this.mRoomId);
        this.bwE.addView(this.oNR.getView(), new LinearLayout.LayoutParams(-1, -2));
        this.bwJ = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_rank_list_empty);
        this.ijo.setEmptyView(this.bwJ);
        this.oNR.a(new a() { // from class: com.baidu.tieba.yuyinala.view.b.1
            @Override // com.baidu.tieba.yuyinala.view.b.a
            public void en(View view) {
                MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tieba.yuyinala.data.c> arrayList) {
        if (this.oNQ != null) {
            this.ijv = arrayList;
            this.oNQ.setData(arrayList);
        }
    }

    public void c(i iVar) {
        this.oNS.b(iVar);
    }

    public void wE(int i) {
        if (this.oNS != null) {
            this.oNS.setHourHeaderInfoVisible(i);
        }
    }

    public void fv(int i) {
        if (this.cdZ != null) {
            this.cdZ.setVisibility(i);
        }
    }

    public void WK(String str) {
        if (this.oNU != null) {
            this.oNU.setText(str);
        }
    }

    public void wF(int i) {
        this.ijo.setVisibility(i);
    }

    public void b(g gVar) {
        if (gVar == null) {
            if (this.oNR != null) {
                this.oNR.getView().setVisibility(8);
                return;
            }
            return;
        }
        this.oNT = gVar;
        View view = null;
        if (this.oNR != null) {
            this.oNR.a(gVar);
            this.oNR.getView().setVisibility(0);
            view = this.oNR.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
        }
    }

    public void cpA() {
        if (this.oNR != null) {
            this.oNR.getView().setVisibility(8);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        this.bwJ.reset();
        this.bwJ.setTitle("网络不给力，请稍后重试");
        this.bwJ.setRefreshButton("重新加载", onClickListener);
        this.bwJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bwJ.setTextColor(this.ooW.getResources().getColor(a.c.sdk_color_525252));
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
            this.bwJ.setTextColor(this.ooW.getResources().getColor(a.c.sdk_color_525252));
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
