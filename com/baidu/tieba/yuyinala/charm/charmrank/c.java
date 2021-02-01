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
import com.baidu.live.data.j;
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
import com.baidu.live.view.AlaLoadingView;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private LinearLayout bwE;
    private CommonEmptyView bwJ;
    private AlaLoadingView cdW;
    private View.OnClickListener gNK = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private int gNr;
    private PbListView gNy;
    private View gOT;
    private View gOU;
    private TextView gel;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private int mUserType;
    private String ooz;
    private YuyinCharmRankTotalActivity oqr;
    private e oqs;
    private TextView oqt;
    private com.baidu.tieba.yuyinala.charm.charmrank.a oqu;

    /* loaded from: classes11.dex */
    public interface a {
        void en(View view);
    }

    public c(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.oqr = yuyinCharmRankTotalActivity;
        this.gNr = i;
        this.ooz = str;
        this.mLiveId = str2;
        this.mUserType = i2;
        this.mRootView = this.oqr.getLayoutInflater().inflate(a.g.yuyin_charm_rank_total_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bwJ = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.oqt = (TextView) this.mRootView.findViewById(a.f.top_text_right);
        this.gOT = this.mRootView.findViewById(a.f.toLogin_layout);
        this.gOU = this.mRootView.findViewById(a.f.toLogin_text);
        this.cdW = (AlaLoadingView) this.mRootView.findViewById(a.f.ala_loading_view);
        this.gOU.setOnClickListener(this.gNK);
        if (!TbadkCoreApplication.isLogin() && this.gNr == 0) {
            this.gOT.setVisibility(0);
        } else {
            this.gOT.setVisibility(8);
        }
        this.oqs = new e(yuyinCharmRankTotalActivity.getPageContext(), this.gNr, this.ooz, this.mLiveId);
        this.mListView.setAdapter((ListAdapter) this.oqs);
        this.mListView.setEmptyView(this.bwJ);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                c.this.a(c.this.oqs.getItem(i3));
            }
        });
        this.gel = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gNr == 0) {
            this.gel.setText(a.h.yuyin_contribute_rank_top_txt);
        } else {
            this.gel.setText(a.h.yuyin_charm_rank_top_txt);
        }
        if (this.gNr == 0 && TbadkCoreApplication.isLogin()) {
            this.bwE = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
            this.oqu = new com.baidu.tieba.yuyinala.charm.charmrank.a(this.oqr, this.ooz);
            this.bwE.addView(this.oqu.getView(), new LinearLayout.LayoutParams(-1, -2));
            this.oqu.a(new a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.2
                @Override // com.baidu.tieba.yuyinala.charm.charmrank.c.a
                public void en(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
                }
            });
        }
        if (this.gNy == null) {
            this.gNy = new PbListView(this.oqr);
            this.gNy.setTextColor(this.oqr.getResources().getColor(a.c.sdk_color_858585));
            this.gNy.setSkinType(0);
            this.gNy.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gNy.setmTextSize(14.0f);
            this.gNy.createView();
            this.gNy.setHeight(BdUtilHelper.dip2px(this.oqr, 60.0f));
        }
    }

    public void gn(List<j.b> list) {
        this.oqs.setData(list);
    }

    public void dQ(boolean z) {
        if (z) {
            this.bwJ.reset();
            this.bwJ.setTitle("还没有人上榜哦~");
            this.bwJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bwJ.setTextColor(this.oqr.getResources().getColor(a.c.sdk_color_525252));
            this.bwJ.setVisibility(0);
            return;
        }
        this.bwJ.setVisibility(8);
    }

    public void zR(boolean z) {
        this.gel.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j.b bVar) {
        if (bVar != null) {
            this.oqr.finish();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oqr.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(bVar.user_uk), bVar.user_name, bVar.bd_portrait, 0, bVar.level_id, null, null, 0L, 0L, 0L, 0, "", this.mLiveId, false, "", null, bVar.user_name, "")));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void n(View.OnClickListener onClickListener) {
        this.bwJ.reset();
        this.bwJ.setTitle("网络加载失败了哦~");
        this.bwJ.setRefreshButton("重新加载", onClickListener);
        this.bwJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bwJ.setTextColor(this.oqr.getResources().getColor(a.c.sdk_color_525252));
        this.bwJ.setVisibility(0);
    }

    public void WZ() {
        this.bwJ.setVisibility(8);
    }

    public void Gz(String str) {
        this.mListView.setNextPage(this.gNy);
        this.gNy.endLoadDataWithNoMore(str);
    }

    public void LK(int i) {
        this.oqt.setVisibility(0);
        this.oqt.setText("今日总魅力 " + StringHelper.formatYuyinValue(i));
    }

    public void b(j.a aVar) {
        if (aVar == null) {
            if (this.oqu != null) {
                this.oqu.getView().setVisibility(8);
                return;
            }
            return;
        }
        View view = null;
        if (this.oqu != null) {
            this.oqu.a(aVar);
            this.oqu.getView().setVisibility(0);
            view = this.oqu.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu() && view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
        }
    }

    public void ir(boolean z) {
        if (this.cdW != null) {
            this.cdW.setVisibility(z ? 0 : 8);
        }
    }

    public BdListView getListView() {
        return this.mListView;
    }
}
