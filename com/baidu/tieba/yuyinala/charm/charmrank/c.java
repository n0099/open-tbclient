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
    private int gNF;
    private PbListView gNM;
    private View.OnClickListener gNY = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private View gPh;
    private View gPi;
    private TextView ger;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private int mUserType;
    private String ooZ;
    private YuyinCharmRankTotalActivity oqR;
    private e oqS;
    private TextView oqT;
    private com.baidu.tieba.yuyinala.charm.charmrank.a oqU;

    /* loaded from: classes11.dex */
    public interface a {
        void en(View view);
    }

    public c(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.oqR = yuyinCharmRankTotalActivity;
        this.gNF = i;
        this.ooZ = str;
        this.mLiveId = str2;
        this.mUserType = i2;
        this.mRootView = this.oqR.getLayoutInflater().inflate(a.g.yuyin_charm_rank_total_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bwJ = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.oqT = (TextView) this.mRootView.findViewById(a.f.top_text_right);
        this.gPh = this.mRootView.findViewById(a.f.toLogin_layout);
        this.gPi = this.mRootView.findViewById(a.f.toLogin_text);
        this.cdW = (AlaLoadingView) this.mRootView.findViewById(a.f.ala_loading_view);
        this.gPi.setOnClickListener(this.gNY);
        if (!TbadkCoreApplication.isLogin() && this.gNF == 0) {
            this.gPh.setVisibility(0);
        } else {
            this.gPh.setVisibility(8);
        }
        this.oqS = new e(yuyinCharmRankTotalActivity.getPageContext(), this.gNF, this.ooZ, this.mLiveId);
        this.mListView.setAdapter((ListAdapter) this.oqS);
        this.mListView.setEmptyView(this.bwJ);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                c.this.a(c.this.oqS.getItem(i3));
            }
        });
        this.ger = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gNF == 0) {
            this.ger.setText(a.h.yuyin_contribute_rank_top_txt);
        } else {
            this.ger.setText(a.h.yuyin_charm_rank_top_txt);
        }
        if (this.gNF == 0 && TbadkCoreApplication.isLogin()) {
            this.bwE = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
            this.oqU = new com.baidu.tieba.yuyinala.charm.charmrank.a(this.oqR, this.ooZ);
            this.bwE.addView(this.oqU.getView(), new LinearLayout.LayoutParams(-1, -2));
            this.oqU.a(new a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.2
                @Override // com.baidu.tieba.yuyinala.charm.charmrank.c.a
                public void en(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
                }
            });
        }
        if (this.gNM == null) {
            this.gNM = new PbListView(this.oqR);
            this.gNM.setTextColor(this.oqR.getResources().getColor(a.c.sdk_color_858585));
            this.gNM.setSkinType(0);
            this.gNM.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gNM.setmTextSize(14.0f);
            this.gNM.createView();
            this.gNM.setHeight(BdUtilHelper.dip2px(this.oqR, 60.0f));
        }
    }

    public void gn(List<j.b> list) {
        this.oqS.setData(list);
    }

    public void dQ(boolean z) {
        if (z) {
            this.bwJ.reset();
            this.bwJ.setTitle("还没有人上榜哦~");
            this.bwJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bwJ.setTextColor(this.oqR.getResources().getColor(a.c.sdk_color_525252));
            this.bwJ.setVisibility(0);
            return;
        }
        this.bwJ.setVisibility(8);
    }

    public void zR(boolean z) {
        this.ger.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j.b bVar) {
        if (bVar != null) {
            this.oqR.finish();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oqR.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(bVar.user_uk), bVar.user_name, bVar.bd_portrait, 0, bVar.level_id, null, null, 0L, 0L, 0L, 0, "", this.mLiveId, false, "", null, bVar.user_name, "")));
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
        this.bwJ.setTextColor(this.oqR.getResources().getColor(a.c.sdk_color_525252));
        this.bwJ.setVisibility(0);
    }

    public void WZ() {
        this.bwJ.setVisibility(8);
    }

    public void GA(String str) {
        this.mListView.setNextPage(this.gNM);
        this.gNM.endLoadDataWithNoMore(str);
    }

    public void LL(int i) {
        this.oqT.setVisibility(0);
        this.oqT.setText("今日总魅力 " + StringHelper.formatYuyinValue(i));
    }

    public void b(j.a aVar) {
        if (aVar == null) {
            if (this.oqU != null) {
                this.oqU.getView().setVisibility(8);
                return;
            }
            return;
        }
        View view = null;
        if (this.oqU != null) {
            this.oqU.a(aVar);
            this.oqU.getView().setVisibility(0);
            view = this.oqU.getView();
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
