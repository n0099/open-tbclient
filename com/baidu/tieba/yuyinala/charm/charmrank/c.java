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
/* loaded from: classes11.dex */
public class c {
    private LinearLayout bxO;
    private CommonEmptyView bxT;
    private AlaLoadingView ceG;
    private View.OnClickListener gPK = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private int gPr;
    private PbListView gPy;
    private View gQT;
    private View gQU;
    private TextView ggF;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private int mUserType;
    private String ojl;
    private YuyinCharmRankTotalActivity olc;
    private e old;
    private TextView ole;
    private com.baidu.tieba.yuyinala.charm.charmrank.a olf;

    /* loaded from: classes11.dex */
    public interface a {
        void ep(View view);
    }

    public c(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.olc = yuyinCharmRankTotalActivity;
        this.gPr = i;
        this.ojl = str;
        this.mLiveId = str2;
        this.mUserType = i2;
        this.mRootView = this.olc.getLayoutInflater().inflate(a.g.yuyin_charm_rank_total_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bxT = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.ole = (TextView) this.mRootView.findViewById(a.f.top_text_right);
        this.gQT = this.mRootView.findViewById(a.f.toLogin_layout);
        this.gQU = this.mRootView.findViewById(a.f.toLogin_text);
        this.ceG = (AlaLoadingView) this.mRootView.findViewById(a.f.ala_loading_view);
        this.gQU.setOnClickListener(this.gPK);
        if (!TbadkCoreApplication.isLogin() && this.gPr == 0) {
            this.gQT.setVisibility(0);
        } else {
            this.gQT.setVisibility(8);
        }
        this.old = new e(yuyinCharmRankTotalActivity.getPageContext(), this.gPr, this.ojl, this.mLiveId);
        this.mListView.setAdapter((ListAdapter) this.old);
        this.mListView.setEmptyView(this.bxT);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                c.this.a(c.this.old.getItem(i3));
            }
        });
        this.ggF = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gPr == 0) {
            this.ggF.setText(a.h.yuyin_contribute_rank_top_txt);
        } else {
            this.ggF.setText(a.h.yuyin_charm_rank_top_txt);
        }
        if (this.gPr == 0 && TbadkCoreApplication.isLogin()) {
            this.bxO = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
            this.olf = new com.baidu.tieba.yuyinala.charm.charmrank.a(this.olc, this.ojl);
            this.bxO.addView(this.olf.getView(), new LinearLayout.LayoutParams(-1, -2));
            this.olf.a(new a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.2
                @Override // com.baidu.tieba.yuyinala.charm.charmrank.c.a
                public void ep(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
                }
            });
        }
        if (this.gPy == null) {
            this.gPy = new PbListView(this.olc);
            this.gPy.setTextColor(this.olc.getResources().getColor(a.c.sdk_color_858585));
            this.gPy.setSkinType(0);
            this.gPy.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gPy.setmTextSize(14.0f);
            this.gPy.createView();
            this.gPy.setHeight(BdUtilHelper.dip2px(this.olc, 60.0f));
        }
    }

    public void gp(List<j.b> list) {
        this.old.setData(list);
    }

    public void dM(boolean z) {
        if (z) {
            this.bxT.reset();
            this.bxT.setTitle("还没有人上榜哦~");
            this.bxT.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bxT.setTextColor(this.olc.getResources().getColor(a.c.sdk_color_525252));
            this.bxT.setVisibility(0);
            return;
        }
        this.bxT.setVisibility(8);
    }

    public void zA(boolean z) {
        this.ggF.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j.b bVar) {
        if (bVar != null) {
            this.olc.finish();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.olc.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(bVar.user_uk), bVar.user_name, bVar.bd_portrait, 0, bVar.level_id, null, null, 0L, 0L, 0L, 0, "", this.mLiveId, false, "", null, bVar.user_name, "")));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void n(View.OnClickListener onClickListener) {
        this.bxT.reset();
        this.bxT.setTitle("网络加载失败了哦~");
        this.bxT.setRefreshButton("重新加载", onClickListener);
        this.bxT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bxT.setTextColor(this.olc.getResources().getColor(a.c.sdk_color_525252));
        this.bxT.setVisibility(0);
    }

    public void Zj() {
        this.bxT.setVisibility(8);
    }

    public void Hl(String str) {
        this.mListView.setNextPage(this.gPy);
        this.gPy.endLoadDataWithNoMore(str);
    }

    public void b(j.a aVar) {
        if (aVar == null) {
            if (this.olf != null) {
                this.olf.getView().setVisibility(8);
                return;
            }
            return;
        }
        View view = null;
        if (this.olf != null) {
            this.olf.a(aVar);
            this.olf.getView().setVisibility(0);
            view = this.olf.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu() && view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
        }
    }

    public void it(boolean z) {
        if (this.ceG != null) {
            this.ceG.setVisibility(z ? 0 : 8);
        }
    }

    public BdListView getListView() {
        return this.mListView;
    }
}
