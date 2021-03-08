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
    private LinearLayout bye;
    private CommonEmptyView byj;
    private LinearLayout cfz;
    private BdListView ill;
    private ArrayList<com.baidu.tieba.yuyinala.data.c> ils;
    private String mRoomId;
    private View mRootView;
    private com.baidu.tieba.yuyinala.adapter.a oQv;
    private com.baidu.tieba.yuyinala.view.a oQw;
    private AlaRankListHeaderView oQx;
    private g oQy;
    private TextView oQz;
    private AlaRankListActivity orD;

    /* loaded from: classes10.dex */
    public interface a {
        void en(View view);
    }

    public b(AlaRankListActivity alaRankListActivity, String str) {
        this.orD = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.orD).inflate(a.g.yuyin_ala_rank_fragment_layout, (ViewGroup) null);
        this.ill = (BdListView) this.mRootView.findViewById(a.f.ala_rank_list_view);
        this.oQv = new com.baidu.tieba.yuyinala.adapter.a(this.orD, this.mRoomId);
        this.ill.setAdapter((ListAdapter) this.oQv);
        this.oQx = new AlaRankListHeaderView(this.orD, this.mRoomId);
        this.ill.addHeaderView(this.oQx);
        this.cfz = (LinearLayout) LayoutInflater.from(this.orD).inflate(a.g.yuyin_hour_rank_list_footer_view, (ViewGroup) null);
        this.oQz = (TextView) this.cfz.findViewById(a.f.tv_footer);
        this.ill.addFooterView(this.cfz);
        this.cfz.setVisibility(0);
        this.bye = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
        this.oQw = new com.baidu.tieba.yuyinala.view.a(this.orD, this.mRoomId);
        this.bye.addView(this.oQw.getView(), new LinearLayout.LayoutParams(-1, -2));
        this.byj = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_rank_list_empty);
        this.ill.setEmptyView(this.byj);
        this.oQw.a(new a() { // from class: com.baidu.tieba.yuyinala.view.b.1
            @Override // com.baidu.tieba.yuyinala.view.b.a
            public void en(View view) {
                MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tieba.yuyinala.data.c> arrayList) {
        if (this.oQv != null) {
            this.ils = arrayList;
            this.oQv.setData(arrayList);
        }
    }

    public void c(i iVar) {
        this.oQx.b(iVar);
    }

    public void wF(int i) {
        if (this.oQx != null) {
            this.oQx.setHourHeaderInfoVisible(i);
        }
    }

    public void fw(int i) {
        if (this.cfz != null) {
            this.cfz.setVisibility(i);
        }
    }

    public void Xd(String str) {
        if (this.oQz != null) {
            this.oQz.setText(str);
        }
    }

    public void wG(int i) {
        this.ill.setVisibility(i);
    }

    public void b(g gVar) {
        if (gVar == null) {
            if (this.oQw != null) {
                this.oQw.getView().setVisibility(8);
                return;
            }
            return;
        }
        this.oQy = gVar;
        View view = null;
        if (this.oQw != null) {
            this.oQw.a(gVar);
            this.oQw.getView().setVisibility(0);
            view = this.oQw.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
        }
    }

    public void cpN() {
        if (this.oQw != null) {
            this.oQw.getView().setVisibility(8);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        this.byj.reset();
        this.byj.setTitle("网络不给力，请稍后重试");
        this.byj.setRefreshButton("重新加载", onClickListener);
        this.byj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.byj.setTextColor(this.orD.getResources().getColor(a.c.sdk_color_525252));
        this.byj.setVisibility(0);
    }

    public void Xc() {
        this.byj.setVisibility(8);
    }

    public void dQ(boolean z) {
        if (z) {
            this.byj.reset();
            this.byj.setTitle("还没有房间上榜哦~");
            this.byj.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.byj.setTextColor(this.orD.getResources().getColor(a.c.sdk_color_525252));
            this.byj.setVisibility(0);
            return;
        }
        this.byj.setVisibility(8);
    }

    public void release() {
    }

    public View getView() {
        return this.mRootView;
    }
}
