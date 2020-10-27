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
    private LinearLayout bol;
    private CommonEmptyView boq;
    private TextView fJI;
    private PbListView gpG;
    private View.OnClickListener gpS = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private int gpz;
    private View gra;
    private View grb;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private int mUserType;
    private String nLi;
    private YuyinCharmRankTotalActivity nMU;
    private e nMV;
    private TextView nMW;
    private com.baidu.tieba.yuyinala.charm.charmrank.a nMX;

    /* loaded from: classes4.dex */
    public interface a {
        void dI(View view);
    }

    public c(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.nMU = yuyinCharmRankTotalActivity;
        this.gpz = i;
        this.nLi = str;
        this.mLiveId = str2;
        this.mUserType = i2;
        this.mRootView = this.nMU.getLayoutInflater().inflate(a.h.yuyin_charm_rank_total_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.boq = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.nMW = (TextView) this.mRootView.findViewById(a.g.top_text_right);
        this.gra = this.mRootView.findViewById(a.g.toLogin_layout);
        this.grb = this.mRootView.findViewById(a.g.toLogin_text);
        this.grb.setOnClickListener(this.gpS);
        if (!TbadkCoreApplication.isLogin() && this.gpz == 0) {
            this.gra.setVisibility(0);
        } else {
            this.gra.setVisibility(8);
        }
        this.nMV = new e(yuyinCharmRankTotalActivity.getPageContext(), this.gpz, this.nLi, this.mLiveId);
        this.mListView.setAdapter((ListAdapter) this.nMV);
        this.mListView.setEmptyView(this.boq);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                c.this.a(c.this.nMV.getItem(i3));
            }
        });
        this.fJI = (TextView) this.mRootView.findViewById(a.g.top_text);
        if (this.gpz == 0) {
            this.fJI.setText("按今日在本房间贡献的魅力值排序");
        } else {
            this.fJI.setText("按今日在本房间收到的魅力值排序");
        }
        if (this.gpz == 0 && TbadkCoreApplication.isLogin()) {
            this.bol = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
            this.nMX = new com.baidu.tieba.yuyinala.charm.charmrank.a(this.nMU, this.nLi);
            this.bol.addView(this.nMX.getView(), new LinearLayout.LayoutParams(-1, -2));
            this.nMX.a(new a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.2
                @Override // com.baidu.tieba.yuyinala.charm.charmrank.c.a
                public void dI(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
                }
            });
        }
        if (this.gpG == null) {
            this.gpG = new PbListView(this.nMU);
            this.gpG.setTextColor(this.nMU.getResources().getColor(a.d.sdk_color_858585));
            this.gpG.setSkinType(0);
            this.gpG.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.gpG.setmTextSize(14.0f);
            this.gpG.createView();
            this.gpG.setHeight(BdUtilHelper.dip2px(this.nMU, 60.0f));
        }
    }

    public void gb(List<i.b> list) {
        this.nMV.setData(list);
    }

    public void dj(boolean z) {
        if (z) {
            this.boq.reset();
            this.boq.setTitle("还没有人上榜哦~");
            this.boq.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.boq.setTextColor(this.nMU.getResources().getColor(a.d.sdk_color_525252));
            this.boq.setVisibility(0);
            return;
        }
        this.boq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.b bVar) {
        if (bVar != null) {
            this.nMU.finish();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.nMU.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(bVar.user_uk), bVar.user_name, bVar.bd_portrait, 0, bVar.level_id, null, null, 0L, 0L, 0L, 0, "", this.mLiveId, false, "", null, bVar.user_name, "")));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void l(View.OnClickListener onClickListener) {
        this.boq.reset();
        this.boq.setTitle("网络加载失败了哦~");
        this.boq.setRefreshButton("重新加载", onClickListener);
        this.boq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.boq.setTextColor(this.nMU.getResources().getColor(a.d.sdk_color_525252));
        this.boq.setVisibility(0);
    }

    public void TK() {
        this.boq.setVisibility(8);
    }

    public void GK(String str) {
        this.mListView.setNextPage(this.gpG);
        this.gpG.endLoadDataWithNoMore(str);
    }

    public void LD(int i) {
        this.nMW.setVisibility(0);
        this.nMW.setText("今日魅力 " + StringHelper.formatYuyinValue(i));
    }

    public void b(i.a aVar) {
        if (aVar == null) {
            if (this.nMX != null) {
                this.nMX.getView().setVisibility(8);
                return;
            }
            return;
        }
        View view = null;
        if (this.nMX != null) {
            this.nMX.a(aVar);
            this.nMX.getView().setVisibility(0);
            view = this.nMX.getView();
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
