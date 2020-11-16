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
    private LinearLayout bSJ;
    private TextView bSK;
    private LinearLayout bnT;
    private CommonEmptyView bnY;
    private BdListView hLF;
    private ArrayList<com.baidu.tieba.yuyinala.data.c> hLM;
    private String mRoomId;
    private View mRootView;
    private AlaRankListActivity nTb;
    private com.baidu.tieba.yuyinala.adapter.a olv;
    private com.baidu.tieba.yuyinala.view.a olw;
    private AlaRankListHeaderView olx;
    private g oly;

    /* loaded from: classes4.dex */
    public interface a {
        void dU(View view);
    }

    public b(AlaRankListActivity alaRankListActivity, String str) {
        this.nTb = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nTb).inflate(a.g.yuyin_ala_rank_fragment_layout, (ViewGroup) null);
        this.hLF = (BdListView) this.mRootView.findViewById(a.f.ala_rank_list_view);
        this.olv = new com.baidu.tieba.yuyinala.adapter.a(this.nTb, this.mRoomId);
        this.hLF.setAdapter((ListAdapter) this.olv);
        this.olx = new AlaRankListHeaderView(this.nTb, this.mRoomId);
        this.hLF.addHeaderView(this.olx);
        this.bSJ = (LinearLayout) LayoutInflater.from(this.nTb).inflate(a.g.yuyin_hour_rank_list_footer_view, (ViewGroup) null);
        this.bSK = (TextView) this.bSJ.findViewById(a.f.tv_footer);
        this.hLF.addFooterView(this.bSJ);
        this.bSJ.setVisibility(0);
        this.bnT = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
        this.olw = new com.baidu.tieba.yuyinala.view.a(this.nTb, this.mRoomId);
        this.bnT.addView(this.olw.getView(), new LinearLayout.LayoutParams(-1, -2));
        this.bnY = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_rank_list_empty);
        this.hLF.setEmptyView(this.bnY);
        this.olw.a(new a() { // from class: com.baidu.tieba.yuyinala.view.b.1
            @Override // com.baidu.tieba.yuyinala.view.b.a
            public void dU(View view) {
                MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tieba.yuyinala.data.c> arrayList) {
        if (this.olv != null) {
            this.hLM = arrayList;
            this.olv.setData(arrayList);
        }
    }

    public void c(i iVar) {
        this.olx.b(iVar);
    }

    public void xg(int i) {
        if (this.olx != null) {
            this.olx.setHourHeaderInfoVisible(i);
        }
    }

    public void gx(int i) {
        if (this.bSJ != null) {
            this.bSJ.setVisibility(i);
        }
    }

    public void VR(String str) {
        if (this.bSK != null) {
            this.bSK.setText(str);
        }
    }

    public void xh(int i) {
        this.hLF.setVisibility(i);
    }

    public void b(g gVar) {
        if (gVar == null) {
            if (this.olw != null) {
                this.olw.getView().setVisibility(8);
                return;
            }
            return;
        }
        this.oly = gVar;
        View view = null;
        if (this.olw != null) {
            this.olw.a(gVar);
            this.olw.getView().setVisibility(0);
            view = this.olw.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
        }
    }

    public void cld() {
        if (this.olw != null) {
            this.olw.getView().setVisibility(8);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.bnY.reset();
        this.bnY.setTitle("网络不给力，请稍后重试");
        this.bnY.setRefreshButton("重新加载", onClickListener);
        this.bnY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bnY.setTextColor(this.nTb.getResources().getColor(a.c.sdk_color_525252));
        this.bnY.setVisibility(0);
    }

    public void VB() {
        this.bnY.setVisibility(8);
    }

    public void ds(boolean z) {
        if (z) {
            this.bnY.reset();
            this.bnY.setTitle("还没有房间上榜哦~");
            this.bnY.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bnY.setTextColor(this.nTb.getResources().getColor(a.c.sdk_color_525252));
            this.bnY.setVisibility(0);
            return;
        }
        this.bnY.setVisibility(8);
    }

    public void release() {
    }

    public View getView() {
        return this.mRootView;
    }
}
