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
    private LinearLayout btb;
    private CommonEmptyView btg;
    private TextView fWX;
    private int gDD;
    private PbListView gDK;
    private View.OnClickListener gDW = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private View gFg;
    private View gFh;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private int mUserType;
    private String ohD;
    private YuyinCharmRankTotalActivity ojp;
    private e ojq;
    private TextView ojr;
    private com.baidu.tieba.yuyinala.charm.charmrank.a ojs;

    /* loaded from: classes4.dex */
    public interface a {
        void ef(View view);
    }

    public c(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.ojp = yuyinCharmRankTotalActivity;
        this.gDD = i;
        this.ohD = str;
        this.mLiveId = str2;
        this.mUserType = i2;
        this.mRootView = this.ojp.getLayoutInflater().inflate(a.g.yuyin_charm_rank_total_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.btg = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.ojr = (TextView) this.mRootView.findViewById(a.f.top_text_right);
        this.gFg = this.mRootView.findViewById(a.f.toLogin_layout);
        this.gFh = this.mRootView.findViewById(a.f.toLogin_text);
        this.gFh.setOnClickListener(this.gDW);
        if (!TbadkCoreApplication.isLogin() && this.gDD == 0) {
            this.gFg.setVisibility(0);
        } else {
            this.gFg.setVisibility(8);
        }
        this.ojq = new e(yuyinCharmRankTotalActivity.getPageContext(), this.gDD, this.ohD, this.mLiveId);
        this.mListView.setAdapter((ListAdapter) this.ojq);
        this.mListView.setEmptyView(this.btg);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                c.this.a(c.this.ojq.getItem(i3));
            }
        });
        this.fWX = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gDD == 0) {
            this.fWX.setText("按今日在本房间贡献的魅力值排序");
        } else {
            this.fWX.setText("按今日在本房间收到的魅力值排序");
        }
        if (this.gDD == 0 && TbadkCoreApplication.isLogin()) {
            this.btb = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
            this.ojs = new com.baidu.tieba.yuyinala.charm.charmrank.a(this.ojp, this.ohD);
            this.btb.addView(this.ojs.getView(), new LinearLayout.LayoutParams(-1, -2));
            this.ojs.a(new a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.2
                @Override // com.baidu.tieba.yuyinala.charm.charmrank.c.a
                public void ef(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
                }
            });
        }
        if (this.gDK == null) {
            this.gDK = new PbListView(this.ojp);
            this.gDK.setTextColor(this.ojp.getResources().getColor(a.c.sdk_color_858585));
            this.gDK.setSkinType(0);
            this.gDK.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gDK.setmTextSize(14.0f);
            this.gDK.createView();
            this.gDK.setHeight(BdUtilHelper.dip2px(this.ojp, 60.0f));
        }
    }

    public void gx(List<i.b> list) {
        this.ojq.setData(list);
    }

    public void dG(boolean z) {
        if (z) {
            this.btg.reset();
            this.btg.setTitle("还没有人上榜哦~");
            this.btg.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.btg.setTextColor(this.ojp.getResources().getColor(a.c.sdk_color_525252));
            this.btg.setVisibility(0);
            return;
        }
        this.btg.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.b bVar) {
        if (bVar != null) {
            this.ojp.finish();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.ojp.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(bVar.user_uk), bVar.user_name, bVar.bd_portrait, 0, bVar.level_id, null, null, 0L, 0L, 0L, 0, "", this.mLiveId, false, "", null, bVar.user_name, "")));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void m(View.OnClickListener onClickListener) {
        this.btg.reset();
        this.btg.setTitle("网络加载失败了哦~");
        this.btg.setRefreshButton("重新加载", onClickListener);
        this.btg.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.btg.setTextColor(this.ojp.getResources().getColor(a.c.sdk_color_525252));
        this.btg.setVisibility(0);
    }

    public void Yb() {
        this.btg.setVisibility(8);
    }

    public void Hm(String str) {
        this.mListView.setNextPage(this.gDK);
        this.gDK.endLoadDataWithNoMore(str);
    }

    public void Nl(int i) {
        this.ojr.setVisibility(0);
        this.ojr.setText("今日魅力 " + StringHelper.formatYuyinValue(i));
    }

    public void b(i.a aVar) {
        if (aVar == null) {
            if (this.ojs != null) {
                this.ojs.getView().setVisibility(8);
                return;
            }
            return;
        }
        View view = null;
        if (this.ojs != null) {
            this.ojs.a(aVar);
            this.ojs.getView().setVisibility(0);
            view = this.ojs.getView();
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
