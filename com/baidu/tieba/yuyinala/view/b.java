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
/* loaded from: classes10.dex */
public class b {
    private LinearLayout bZT;
    private LinearLayout bta;
    private CommonEmptyView btf;
    private ArrayList<com.baidu.tieba.yuyinala.data.c> ieB;
    private BdListView ieu;
    private String mRoomId;
    private View mRootView;
    private com.baidu.tieba.yuyinala.adapter.a oDG;
    private com.baidu.tieba.yuyinala.view.a oDH;
    private AlaRankListHeaderView oDI;
    private g oDJ;
    private TextView oDK;
    private AlaRankListActivity ofc;

    /* loaded from: classes10.dex */
    public interface a {
        void ep(View view);
    }

    public b(AlaRankListActivity alaRankListActivity, String str) {
        this.ofc = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.ofc).inflate(a.g.yuyin_ala_rank_fragment_layout, (ViewGroup) null);
        this.ieu = (BdListView) this.mRootView.findViewById(a.f.ala_rank_list_view);
        this.oDG = new com.baidu.tieba.yuyinala.adapter.a(this.ofc, this.mRoomId);
        this.ieu.setAdapter((ListAdapter) this.oDG);
        this.oDI = new AlaRankListHeaderView(this.ofc, this.mRoomId);
        this.ieu.addHeaderView(this.oDI);
        this.bZT = (LinearLayout) LayoutInflater.from(this.ofc).inflate(a.g.yuyin_hour_rank_list_footer_view, (ViewGroup) null);
        this.oDK = (TextView) this.bZT.findViewById(a.f.tv_footer);
        this.ieu.addFooterView(this.bZT);
        this.bZT.setVisibility(0);
        this.bta = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
        this.oDH = new com.baidu.tieba.yuyinala.view.a(this.ofc, this.mRoomId);
        this.bta.addView(this.oDH.getView(), new LinearLayout.LayoutParams(-1, -2));
        this.btf = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_rank_list_empty);
        this.ieu.setEmptyView(this.btf);
        this.oDH.a(new a() { // from class: com.baidu.tieba.yuyinala.view.b.1
            @Override // com.baidu.tieba.yuyinala.view.b.a
            public void ep(View view) {
                MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tieba.yuyinala.data.c> arrayList) {
        if (this.oDG != null) {
            this.ieB = arrayList;
            this.oDG.setData(arrayList);
        }
    }

    public void c(i iVar) {
        this.oDI.b(iVar);
    }

    public void wt(int i) {
        if (this.oDI != null) {
            this.oDI.setHourHeaderInfoVisible(i);
        }
    }

    public void fp(int i) {
        if (this.bZT != null) {
            this.bZT.setVisibility(i);
        }
    }

    public void VK(String str) {
        if (this.oDK != null) {
            this.oDK.setText(str);
        }
    }

    public void wu(int i) {
        this.ieu.setVisibility(i);
    }

    public void b(g gVar) {
        if (gVar == null) {
            if (this.oDH != null) {
                this.oDH.getView().setVisibility(8);
                return;
            }
            return;
        }
        this.oDJ = gVar;
        View view = null;
        if (this.oDH != null) {
            this.oDH.a(gVar);
            this.oDH.getView().setVisibility(0);
            view = this.oDH.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
        }
    }

    public void cov() {
        if (this.oDH != null) {
            this.oDH.getView().setVisibility(8);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        this.btf.reset();
        this.btf.setTitle("网络不给力，请稍后重试");
        this.btf.setRefreshButton("重新加载", onClickListener);
        this.btf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.btf.setTextColor(this.ofc.getResources().getColor(a.c.sdk_color_525252));
        this.btf.setVisibility(0);
    }

    public void Vq() {
        this.btf.setVisibility(8);
    }

    public void dI(boolean z) {
        if (z) {
            this.btf.reset();
            this.btf.setTitle("还没有房间上榜哦~");
            this.btf.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.btf.setTextColor(this.ofc.getResources().getColor(a.c.sdk_color_525252));
            this.btf.setVisibility(0);
            return;
        }
        this.btf.setVisibility(8);
    }

    public void release() {
    }

    public View getView() {
        return this.mRootView;
    }
}
