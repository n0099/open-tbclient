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
    private LinearLayout bpE;
    private CommonEmptyView bpJ;
    private TextView fPy;
    private View.OnClickListener gvG = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private int gvn;
    private PbListView gvu;
    private View gwO;
    private View gwP;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private int mUserType;
    private String nRc;
    private YuyinCharmRankTotalActivity nSO;
    private e nSP;
    private TextView nSQ;
    private com.baidu.tieba.yuyinala.charm.charmrank.a nSR;

    /* loaded from: classes4.dex */
    public interface a {
        void dN(View view);
    }

    public c(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.nSO = yuyinCharmRankTotalActivity;
        this.gvn = i;
        this.nRc = str;
        this.mLiveId = str2;
        this.mUserType = i2;
        this.mRootView = this.nSO.getLayoutInflater().inflate(a.g.yuyin_charm_rank_total_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bpJ = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.nSQ = (TextView) this.mRootView.findViewById(a.f.top_text_right);
        this.gwO = this.mRootView.findViewById(a.f.toLogin_layout);
        this.gwP = this.mRootView.findViewById(a.f.toLogin_text);
        this.gwP.setOnClickListener(this.gvG);
        if (!TbadkCoreApplication.isLogin() && this.gvn == 0) {
            this.gwO.setVisibility(0);
        } else {
            this.gwO.setVisibility(8);
        }
        this.nSP = new e(yuyinCharmRankTotalActivity.getPageContext(), this.gvn, this.nRc, this.mLiveId);
        this.mListView.setAdapter((ListAdapter) this.nSP);
        this.mListView.setEmptyView(this.bpJ);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                c.this.a(c.this.nSP.getItem(i3));
            }
        });
        this.fPy = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gvn == 0) {
            this.fPy.setText("按今日在本房间贡献的魅力值排序");
        } else {
            this.fPy.setText("按今日在本房间收到的魅力值排序");
        }
        if (this.gvn == 0 && TbadkCoreApplication.isLogin()) {
            this.bpE = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
            this.nSR = new com.baidu.tieba.yuyinala.charm.charmrank.a(this.nSO, this.nRc);
            this.bpE.addView(this.nSR.getView(), new LinearLayout.LayoutParams(-1, -2));
            this.nSR.a(new a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.2
                @Override // com.baidu.tieba.yuyinala.charm.charmrank.c.a
                public void dN(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
                }
            });
        }
        if (this.gvu == null) {
            this.gvu = new PbListView(this.nSO);
            this.gvu.setTextColor(this.nSO.getResources().getColor(a.c.sdk_color_858585));
            this.gvu.setSkinType(0);
            this.gvu.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gvu.setmTextSize(14.0f);
            this.gvu.createView();
            this.gvu.setHeight(BdUtilHelper.dip2px(this.nSO, 60.0f));
        }
    }

    public void gj(List<i.b> list) {
        this.nSP.setData(list);
    }

    public void dq(boolean z) {
        if (z) {
            this.bpJ.reset();
            this.bpJ.setTitle("还没有人上榜哦~");
            this.bpJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bpJ.setTextColor(this.nSO.getResources().getColor(a.c.sdk_color_525252));
            this.bpJ.setVisibility(0);
            return;
        }
        this.bpJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.b bVar) {
        if (bVar != null) {
            this.nSO.finish();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.nSO.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(bVar.user_uk), bVar.user_name, bVar.bd_portrait, 0, bVar.level_id, null, null, 0L, 0L, 0L, 0, "", this.mLiveId, false, "", null, bVar.user_name, "")));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void m(View.OnClickListener onClickListener) {
        this.bpJ.reset();
        this.bpJ.setTitle("网络加载失败了哦~");
        this.bpJ.setRefreshButton("重新加载", onClickListener);
        this.bpJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bpJ.setTextColor(this.nSO.getResources().getColor(a.c.sdk_color_525252));
        this.bpJ.setVisibility(0);
    }

    public void Wk() {
        this.bpJ.setVisibility(8);
    }

    public void GX(String str) {
        this.mListView.setNextPage(this.gvu);
        this.gvu.endLoadDataWithNoMore(str);
    }

    public void LQ(int i) {
        this.nSQ.setVisibility(0);
        this.nSQ.setText("今日魅力 " + StringHelper.formatYuyinValue(i));
    }

    public void b(i.a aVar) {
        if (aVar == null) {
            if (this.nSR != null) {
                this.nSR.getView().setVisibility(8);
                return;
            }
            return;
        }
        View view = null;
        if (this.nSR != null) {
            this.nSR.a(aVar);
            this.nSR.getView().setVisibility(0);
            view = this.nSR.getView();
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
