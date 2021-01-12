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
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.view.AlaLoadingView;
import java.util.List;
/* loaded from: classes10.dex */
public class c {
    private AlaLoadingView bZQ;
    private LinearLayout bta;
    private CommonEmptyView btf;
    private int gKL;
    private PbListView gKS;
    private View.OnClickListener gLe = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private View gMn;
    private View gMo;
    private TextView gbW;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private int mUserType;
    private String oeF;
    private com.baidu.tieba.yuyinala.charm.charmrank.a ogA;
    private YuyinCharmRankTotalActivity ogx;
    private e ogy;
    private TextView ogz;

    /* loaded from: classes10.dex */
    public interface a {
        void ep(View view);
    }

    public c(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.ogx = yuyinCharmRankTotalActivity;
        this.gKL = i;
        this.oeF = str;
        this.mLiveId = str2;
        this.mUserType = i2;
        this.mRootView = this.ogx.getLayoutInflater().inflate(a.g.yuyin_charm_rank_total_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.btf = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.ogz = (TextView) this.mRootView.findViewById(a.f.top_text_right);
        this.gMn = this.mRootView.findViewById(a.f.toLogin_layout);
        this.gMo = this.mRootView.findViewById(a.f.toLogin_text);
        this.bZQ = (AlaLoadingView) this.mRootView.findViewById(a.f.ala_loading_view);
        this.gMo.setOnClickListener(this.gLe);
        if (!TbadkCoreApplication.isLogin() && this.gKL == 0) {
            this.gMn.setVisibility(0);
        } else {
            this.gMn.setVisibility(8);
        }
        this.ogy = new e(yuyinCharmRankTotalActivity.getPageContext(), this.gKL, this.oeF, this.mLiveId);
        this.mListView.setAdapter((ListAdapter) this.ogy);
        this.mListView.setEmptyView(this.btf);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                c.this.a(c.this.ogy.getItem(i3));
            }
        });
        this.gbW = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gKL == 0) {
            this.gbW.setText(a.h.yuyin_contribute_rank_top_txt);
        } else {
            this.gbW.setText(a.h.yuyin_charm_rank_top_txt);
        }
        if (this.gKL == 0 && TbadkCoreApplication.isLogin()) {
            this.bta = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
            this.ogA = new com.baidu.tieba.yuyinala.charm.charmrank.a(this.ogx, this.oeF);
            this.bta.addView(this.ogA.getView(), new LinearLayout.LayoutParams(-1, -2));
            this.ogA.a(new a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.2
                @Override // com.baidu.tieba.yuyinala.charm.charmrank.c.a
                public void ep(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
                }
            });
        }
        if (this.gKS == null) {
            this.gKS = new PbListView(this.ogx);
            this.gKS.setTextColor(this.ogx.getResources().getColor(a.c.sdk_color_858585));
            this.gKS.setSkinType(0);
            this.gKS.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gKS.setmTextSize(14.0f);
            this.gKS.createView();
            this.gKS.setHeight(BdUtilHelper.dip2px(this.ogx, 60.0f));
        }
    }

    public void gp(List<j.b> list) {
        this.ogy.setData(list);
    }

    public void dI(boolean z) {
        if (z) {
            this.btf.reset();
            this.btf.setTitle("还没有人上榜哦~");
            this.btf.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.btf.setTextColor(this.ogx.getResources().getColor(a.c.sdk_color_525252));
            this.btf.setVisibility(0);
            return;
        }
        this.btf.setVisibility(8);
    }

    public void zw(boolean z) {
        this.gbW.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j.b bVar) {
        if (bVar != null) {
            this.ogx.finish();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.ogx.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(bVar.user_uk), bVar.user_name, bVar.bd_portrait, 0, bVar.level_id, null, null, 0L, 0L, 0L, 0, "", this.mLiveId, false, "", null, bVar.user_name, "")));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void n(View.OnClickListener onClickListener) {
        this.btf.reset();
        this.btf.setTitle("网络加载失败了哦~");
        this.btf.setRefreshButton("重新加载", onClickListener);
        this.btf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.btf.setTextColor(this.ogx.getResources().getColor(a.c.sdk_color_525252));
        this.btf.setVisibility(0);
    }

    public void Vq() {
        this.btf.setVisibility(8);
    }

    public void Ga(String str) {
        this.mListView.setNextPage(this.gKS);
        this.gKS.endLoadDataWithNoMore(str);
    }

    public void b(j.a aVar) {
        if (aVar == null) {
            if (this.ogA != null) {
                this.ogA.getView().setVisibility(8);
                return;
            }
            return;
        }
        View view = null;
        if (this.ogA != null) {
            this.ogA.a(aVar);
            this.ogA.getView().setVisibility(0);
            view = this.ogA.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu() && view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
        }
    }

    public void ip(boolean z) {
        if (this.bZQ != null) {
            this.bZQ.setVisibility(z ? 0 : 8);
        }
    }

    public BdListView getListView() {
        return this.mListView;
    }
}
