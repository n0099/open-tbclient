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
    private LinearLayout bOJ;
    private TextView bOK;
    private LinearLayout bol;
    private CommonEmptyView boq;
    private BdListView hGb;
    private ArrayList<com.baidu.tieba.yuyinala.data.c> hGi;
    private String mRoomId;
    private View mRootView;
    private AlaRankListActivity nLE;
    private com.baidu.tieba.yuyinala.adapter.a oaM;
    private com.baidu.tieba.yuyinala.view.a oaN;
    private AlaRankListHeaderView oaO;
    private g oaP;

    /* loaded from: classes4.dex */
    public interface a {
        void dI(View view);
    }

    public b(AlaRankListActivity alaRankListActivity, String str) {
        this.nLE = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nLE).inflate(a.h.yuyin_ala_rank_fragment_layout, (ViewGroup) null);
        this.hGb = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.oaM = new com.baidu.tieba.yuyinala.adapter.a(this.nLE, this.mRoomId);
        this.hGb.setAdapter((ListAdapter) this.oaM);
        this.oaO = new AlaRankListHeaderView(this.nLE, this.mRoomId);
        this.hGb.addHeaderView(this.oaO);
        this.bOJ = (LinearLayout) LayoutInflater.from(this.nLE).inflate(a.h.yuyin_hour_rank_list_footer_view, (ViewGroup) null);
        this.bOK = (TextView) this.bOJ.findViewById(a.g.tv_footer);
        this.hGb.addFooterView(this.bOJ);
        this.bOJ.setVisibility(0);
        this.bol = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        this.oaN = new com.baidu.tieba.yuyinala.view.a(this.nLE, this.mRoomId);
        this.bol.addView(this.oaN.getView(), new LinearLayout.LayoutParams(-1, -2));
        this.boq = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.hGb.setEmptyView(this.boq);
        this.oaN.a(new a() { // from class: com.baidu.tieba.yuyinala.view.b.1
            @Override // com.baidu.tieba.yuyinala.view.b.a
            public void dI(View view) {
                MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tieba.yuyinala.data.c> arrayList) {
        if (this.oaM != null) {
            this.hGi = arrayList;
            this.oaM.setData(arrayList);
        }
    }

    public void c(i iVar) {
        this.oaO.b(iVar);
    }

    public void wv(int i) {
        if (this.oaO != null) {
            this.oaO.setHourHeaderInfoVisible(i);
        }
    }

    public void gr(int i) {
        if (this.bOJ != null) {
            this.bOJ.setVisibility(i);
        }
    }

    public void VD(String str) {
        if (this.bOK != null) {
            this.bOK.setText(str);
        }
    }

    public void ww(int i) {
        this.hGb.setVisibility(i);
    }

    public void b(g gVar) {
        if (gVar == null) {
            if (this.oaN != null) {
                this.oaN.getView().setVisibility(8);
                return;
            }
            return;
        }
        this.oaP = gVar;
        View view = null;
        if (this.oaN != null) {
            this.oaN.a(gVar);
            this.oaN.getView().setVisibility(0);
            view = this.oaN.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
        }
    }

    public void cji() {
        if (this.oaN != null) {
            this.oaN.getView().setVisibility(8);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.boq.reset();
        this.boq.setTitle("网络不给力，请稍后重试");
        this.boq.setRefreshButton("重新加载", onClickListener);
        this.boq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.boq.setTextColor(this.nLE.getResources().getColor(a.d.sdk_color_525252));
        this.boq.setVisibility(0);
    }

    public void TK() {
        this.boq.setVisibility(8);
    }

    public void dj(boolean z) {
        if (z) {
            this.boq.reset();
            this.boq.setTitle("还没有房间上榜哦~");
            this.boq.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.boq.setTextColor(this.nLE.getResources().getColor(a.d.sdk_color_525252));
            this.boq.setVisibility(0);
            return;
        }
        this.boq.setVisibility(8);
    }

    public void release() {
    }

    public View getView() {
        return this.mRootView;
    }
}
