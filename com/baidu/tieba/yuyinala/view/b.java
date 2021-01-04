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
    private LinearLayout bxO;
    private CommonEmptyView bxT;
    private LinearLayout ceJ;
    private BdListView ijb;
    private ArrayList<com.baidu.tieba.yuyinala.data.c> iji;
    private String mRoomId;
    private View mRootView;
    private com.baidu.tieba.yuyinala.adapter.a oIl;
    private com.baidu.tieba.yuyinala.view.a oIm;
    private AlaRankListHeaderView oIn;
    private g oIo;
    private TextView oIp;
    private AlaRankListActivity ojJ;

    /* loaded from: classes11.dex */
    public interface a {
        void ep(View view);
    }

    public b(AlaRankListActivity alaRankListActivity, String str) {
        this.ojJ = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.ojJ).inflate(a.g.yuyin_ala_rank_fragment_layout, (ViewGroup) null);
        this.ijb = (BdListView) this.mRootView.findViewById(a.f.ala_rank_list_view);
        this.oIl = new com.baidu.tieba.yuyinala.adapter.a(this.ojJ, this.mRoomId);
        this.ijb.setAdapter((ListAdapter) this.oIl);
        this.oIn = new AlaRankListHeaderView(this.ojJ, this.mRoomId);
        this.ijb.addHeaderView(this.oIn);
        this.ceJ = (LinearLayout) LayoutInflater.from(this.ojJ).inflate(a.g.yuyin_hour_rank_list_footer_view, (ViewGroup) null);
        this.oIp = (TextView) this.ceJ.findViewById(a.f.tv_footer);
        this.ijb.addFooterView(this.ceJ);
        this.ceJ.setVisibility(0);
        this.bxO = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
        this.oIm = new com.baidu.tieba.yuyinala.view.a(this.ojJ, this.mRoomId);
        this.bxO.addView(this.oIm.getView(), new LinearLayout.LayoutParams(-1, -2));
        this.bxT = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_rank_list_empty);
        this.ijb.setEmptyView(this.bxT);
        this.oIm.a(new a() { // from class: com.baidu.tieba.yuyinala.view.b.1
            @Override // com.baidu.tieba.yuyinala.view.b.a
            public void ep(View view) {
                MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
            }
        });
    }

    public void setDatas(ArrayList<com.baidu.tieba.yuyinala.data.c> arrayList) {
        if (this.oIl != null) {
            this.iji = arrayList;
            this.oIl.setData(arrayList);
        }
    }

    public void c(i iVar) {
        this.oIn.b(iVar);
    }

    public void xZ(int i) {
        if (this.oIn != null) {
            this.oIn.setHourHeaderInfoVisible(i);
        }
    }

    public void gW(int i) {
        if (this.ceJ != null) {
            this.ceJ.setVisibility(i);
        }
    }

    public void WT(String str) {
        if (this.oIp != null) {
            this.oIp.setText(str);
        }
    }

    public void ya(int i) {
        this.ijb.setVisibility(i);
    }

    public void b(g gVar) {
        if (gVar == null) {
            if (this.oIm != null) {
                this.oIm.getView().setVisibility(8);
                return;
            }
            return;
        }
        this.oIo = gVar;
        View view = null;
        if (this.oIm != null) {
            this.oIm.a(gVar);
            this.oIm.getView().setVisibility(0);
            view = this.oIm.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
        }
    }

    public void csm() {
        if (this.oIm != null) {
            this.oIm.getView().setVisibility(8);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        this.bxT.reset();
        this.bxT.setTitle("网络不给力，请稍后重试");
        this.bxT.setRefreshButton("重新加载", onClickListener);
        this.bxT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bxT.setTextColor(this.ojJ.getResources().getColor(a.c.sdk_color_525252));
        this.bxT.setVisibility(0);
    }

    public void Zi() {
        this.bxT.setVisibility(8);
    }

    public void dM(boolean z) {
        if (z) {
            this.bxT.reset();
            this.bxT.setTitle("还没有房间上榜哦~");
            this.bxT.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bxT.setTextColor(this.ojJ.getResources().getColor(a.c.sdk_color_525252));
            this.bxT.setVisibility(0);
            return;
        }
        this.bxT.setVisibility(8);
    }

    public void release() {
    }

    public View getView() {
        return this.mRootView;
    }
}
