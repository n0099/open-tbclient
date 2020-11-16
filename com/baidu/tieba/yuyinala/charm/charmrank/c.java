package com.baidu.tieba.yuyinala.charm.charmrank;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.i;
import com.baidu.live.message.SupportRoom;
import com.baidu.live.message.YuyinSupportRoomMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private LinearLayout bnT;
    private CommonEmptyView bnY;
    private TextView fPh;
    private int guU;
    private PbListView gvb;
    private View.OnClickListener gvn = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private View gwv;
    private View gww;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private int mUserType;
    private String nSF;
    private YuyinCharmRankTotalActivity nUr;
    private e nUs;
    private TextView nUt;
    private com.baidu.tieba.yuyinala.charm.charmrank.a nUu;

    /* loaded from: classes4.dex */
    public interface a {
        void dU(View view);
    }

    public c(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.nUr = yuyinCharmRankTotalActivity;
        this.guU = i;
        this.nSF = str;
        this.mLiveId = str2;
        this.mUserType = i2;
        this.mRootView = this.nUr.getLayoutInflater().inflate(a.g.yuyin_charm_rank_total_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bnY = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.nUt = (TextView) this.mRootView.findViewById(a.f.top_text_right);
        this.gwv = this.mRootView.findViewById(a.f.toLogin_layout);
        this.gww = this.mRootView.findViewById(a.f.toLogin_text);
        this.gww.setOnClickListener(this.gvn);
        if (!TbadkCoreApplication.isLogin() && this.guU == 0) {
            this.gwv.setVisibility(0);
        } else {
            this.gwv.setVisibility(8);
        }
        this.nUs = new e(yuyinCharmRankTotalActivity.getPageContext(), this.guU, this.nSF, this.mLiveId);
        this.mListView.setAdapter((ListAdapter) this.nUs);
        this.mListView.setEmptyView(this.bnY);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                c.this.a(c.this.nUs.getItem(i3));
            }
        });
        this.fPh = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.guU == 0) {
            this.fPh.setText("按今日在本房间贡献的魅力值排序");
        } else {
            this.fPh.setText("按今日在本房间收到的魅力值排序");
        }
        if (this.guU == 0 && TbadkCoreApplication.isLogin()) {
            this.bnT = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
            this.nUu = new com.baidu.tieba.yuyinala.charm.charmrank.a(this.nUr, this.nSF);
            this.bnT.addView(this.nUu.getView(), new LinearLayout.LayoutParams(-1, -2));
            this.nUu.a(new a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.2
                @Override // com.baidu.tieba.yuyinala.charm.charmrank.c.a
                public void dU(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
                }
            });
        }
        if (this.gvb == null) {
            this.gvb = new PbListView(this.nUr);
            this.gvb.setTextColor(this.nUr.getResources().getColor(a.c.sdk_color_858585));
            this.gvb.setSkinType(0);
            this.gvb.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gvb.setmTextSize(14.0f);
            this.gvb.createView();
            this.gvb.setHeight(BdUtilHelper.dip2px(this.nUr, 60.0f));
        }
    }

    public void gj(List<i.b> list) {
        this.nUs.setData(list);
    }

    public void ds(boolean z) {
        if (z) {
            this.bnY.reset();
            this.bnY.setTitle("还没有人上榜哦~");
            this.bnY.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bnY.setTextColor(this.nUr.getResources().getColor(a.c.sdk_color_525252));
            this.bnY.setVisibility(0);
            return;
        }
        this.bnY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.b bVar) {
        if (bVar != null) {
            this.nUr.finish();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.nUr.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(bVar.user_uk), bVar.user_name, bVar.bd_portrait, 0, bVar.level_id, null, null, 0L, 0L, 0L, 0, "", this.mLiveId, false, "", null, bVar.user_name, "")));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void m(View.OnClickListener onClickListener) {
        this.bnY.reset();
        this.bnY.setTitle("网络加载失败了哦~");
        this.bnY.setRefreshButton("重新加载", onClickListener);
        this.bnY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bnY.setTextColor(this.nUr.getResources().getColor(a.c.sdk_color_525252));
        this.bnY.setVisibility(0);
    }

    public void VB() {
        this.bnY.setVisibility(8);
    }

    public void Gy(String str) {
        this.mListView.setNextPage(this.gvb);
        this.gvb.endLoadDataWithNoMore(str);
    }

    public void Mt(int i) {
        this.nUt.setVisibility(0);
        this.nUt.setText("今日魅力 " + StringHelper.formatYuyinValue(i));
    }

    public void b(i.a aVar) {
        if (aVar == null) {
            if (this.nUu != null) {
                this.nUu.getView().setVisibility(8);
                return;
            }
            return;
        }
        View view = null;
        if (this.nUu != null) {
            this.nUu.a(aVar);
            this.nUu.getView().setVisibility(0);
            view = this.nUu.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu() && view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
        }
    }
}
