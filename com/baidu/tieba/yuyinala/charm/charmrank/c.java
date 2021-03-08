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
/* loaded from: classes10.dex */
public class c {
    private LinearLayout bye;
    private CommonEmptyView byj;
    private AlaLoadingView cfw;
    private View.OnClickListener gPH = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private int gPo;
    private PbListView gPv;
    private View gQQ;
    private View gQR;
    private TextView gfU;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private int mUserType;
    private String orf;
    private YuyinCharmRankTotalActivity osX;
    private e osY;
    private TextView osZ;
    private com.baidu.tieba.yuyinala.charm.charmrank.a ota;

    /* loaded from: classes10.dex */
    public interface a {
        void en(View view);
    }

    public c(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.osX = yuyinCharmRankTotalActivity;
        this.gPo = i;
        this.orf = str;
        this.mLiveId = str2;
        this.mUserType = i2;
        this.mRootView = this.osX.getLayoutInflater().inflate(a.g.yuyin_charm_rank_total_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.byj = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.osZ = (TextView) this.mRootView.findViewById(a.f.top_text_right);
        this.gQQ = this.mRootView.findViewById(a.f.toLogin_layout);
        this.gQR = this.mRootView.findViewById(a.f.toLogin_text);
        this.cfw = (AlaLoadingView) this.mRootView.findViewById(a.f.ala_loading_view);
        this.gQR.setOnClickListener(this.gPH);
        if (!TbadkCoreApplication.isLogin() && this.gPo == 0) {
            this.gQQ.setVisibility(0);
        } else {
            this.gQQ.setVisibility(8);
        }
        this.osY = new e(yuyinCharmRankTotalActivity.getPageContext(), this.gPo, this.orf, this.mLiveId);
        this.mListView.setAdapter((ListAdapter) this.osY);
        this.mListView.setEmptyView(this.byj);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                c.this.a(c.this.osY.getItem(i3));
            }
        });
        this.gfU = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gPo == 0) {
            this.gfU.setText(a.h.yuyin_contribute_rank_top_txt);
        } else {
            this.gfU.setText(a.h.yuyin_charm_rank_top_txt);
        }
        if (this.gPo == 0 && TbadkCoreApplication.isLogin()) {
            this.bye = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
            this.ota = new com.baidu.tieba.yuyinala.charm.charmrank.a(this.osX, this.orf);
            this.bye.addView(this.ota.getView(), new LinearLayout.LayoutParams(-1, -2));
            this.ota.a(new a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.2
                @Override // com.baidu.tieba.yuyinala.charm.charmrank.c.a
                public void en(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
                }
            });
        }
        if (this.gPv == null) {
            this.gPv = new PbListView(this.osX);
            this.gPv.setTextColor(this.osX.getResources().getColor(a.c.sdk_color_858585));
            this.gPv.setSkinType(0);
            this.gPv.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gPv.setmTextSize(14.0f);
            this.gPv.createView();
            this.gPv.setHeight(BdUtilHelper.dip2px(this.osX, 60.0f));
        }
    }

    public void gn(List<j.b> list) {
        this.osY.setData(list);
    }

    public void dQ(boolean z) {
        if (z) {
            this.byj.reset();
            this.byj.setTitle("还没有人上榜哦~");
            this.byj.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.byj.setTextColor(this.osX.getResources().getColor(a.c.sdk_color_525252));
            this.byj.setVisibility(0);
            return;
        }
        this.byj.setVisibility(8);
    }

    public void zQ(boolean z) {
        this.gfU.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j.b bVar) {
        if (bVar != null) {
            this.osX.finish();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.osX.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(bVar.user_uk), bVar.user_name, bVar.bd_portrait, 0, bVar.level_id, null, null, 0L, 0L, 0L, 0, "", this.mLiveId, false, "", null, bVar.user_name, "")));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void n(View.OnClickListener onClickListener) {
        this.byj.reset();
        this.byj.setTitle("网络加载失败了哦~");
        this.byj.setRefreshButton("重新加载", onClickListener);
        this.byj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.byj.setTextColor(this.osX.getResources().getColor(a.c.sdk_color_525252));
        this.byj.setVisibility(0);
    }

    public void Xc() {
        this.byj.setVisibility(8);
    }

    public void GJ(String str) {
        this.mListView.setNextPage(this.gPv);
        this.gPv.endLoadDataWithNoMore(str);
    }

    public void LP(int i) {
        this.osZ.setVisibility(0);
        this.osZ.setText("今日总魅力 " + StringHelper.formatYuyinValue(i));
    }

    public void b(j.a aVar) {
        if (aVar == null) {
            if (this.ota != null) {
                this.ota.getView().setVisibility(8);
                return;
            }
            return;
        }
        View view = null;
        if (this.ota != null) {
            this.ota.a(aVar);
            this.ota.getView().setVisibility(0);
            view = this.ota.getView();
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
        if (this.cfw != null) {
            this.cfw.setVisibility(z ? 0 : 8);
        }
    }

    public BdListView getListView() {
        return this.mListView;
    }
}
