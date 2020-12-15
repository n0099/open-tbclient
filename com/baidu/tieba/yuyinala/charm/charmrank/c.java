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
    private TextView fWZ;
    private int gDF;
    private PbListView gDM;
    private View.OnClickListener gDY = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private View gFi;
    private View gFj;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private int mUserType;
    private String ohF;
    private YuyinCharmRankTotalActivity ojr;
    private e ojs;
    private TextView ojt;
    private com.baidu.tieba.yuyinala.charm.charmrank.a oju;

    /* loaded from: classes4.dex */
    public interface a {
        void ef(View view);
    }

    public c(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.ojr = yuyinCharmRankTotalActivity;
        this.gDF = i;
        this.ohF = str;
        this.mLiveId = str2;
        this.mUserType = i2;
        this.mRootView = this.ojr.getLayoutInflater().inflate(a.g.yuyin_charm_rank_total_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.btg = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.ojt = (TextView) this.mRootView.findViewById(a.f.top_text_right);
        this.gFi = this.mRootView.findViewById(a.f.toLogin_layout);
        this.gFj = this.mRootView.findViewById(a.f.toLogin_text);
        this.gFj.setOnClickListener(this.gDY);
        if (!TbadkCoreApplication.isLogin() && this.gDF == 0) {
            this.gFi.setVisibility(0);
        } else {
            this.gFi.setVisibility(8);
        }
        this.ojs = new e(yuyinCharmRankTotalActivity.getPageContext(), this.gDF, this.ohF, this.mLiveId);
        this.mListView.setAdapter((ListAdapter) this.ojs);
        this.mListView.setEmptyView(this.btg);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                c.this.a(c.this.ojs.getItem(i3));
            }
        });
        this.fWZ = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gDF == 0) {
            this.fWZ.setText("按今日在本房间贡献的魅力值排序");
        } else {
            this.fWZ.setText("按今日在本房间收到的魅力值排序");
        }
        if (this.gDF == 0 && TbadkCoreApplication.isLogin()) {
            this.btb = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
            this.oju = new com.baidu.tieba.yuyinala.charm.charmrank.a(this.ojr, this.ohF);
            this.btb.addView(this.oju.getView(), new LinearLayout.LayoutParams(-1, -2));
            this.oju.a(new a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.c.2
                @Override // com.baidu.tieba.yuyinala.charm.charmrank.c.a
                public void ef(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinSupportRoomMessage(new SupportRoom()));
                }
            });
        }
        if (this.gDM == null) {
            this.gDM = new PbListView(this.ojr);
            this.gDM.setTextColor(this.ojr.getResources().getColor(a.c.sdk_color_858585));
            this.gDM.setSkinType(0);
            this.gDM.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gDM.setmTextSize(14.0f);
            this.gDM.createView();
            this.gDM.setHeight(BdUtilHelper.dip2px(this.ojr, 60.0f));
        }
    }

    public void gx(List<i.b> list) {
        this.ojs.setData(list);
    }

    public void dG(boolean z) {
        if (z) {
            this.btg.reset();
            this.btg.setTitle("还没有人上榜哦~");
            this.btg.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.btg.setTextColor(this.ojr.getResources().getColor(a.c.sdk_color_525252));
            this.btg.setVisibility(0);
            return;
        }
        this.btg.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.b bVar) {
        if (bVar != null) {
            this.ojr.finish();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.ojr.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(bVar.user_uk), bVar.user_name, bVar.bd_portrait, 0, bVar.level_id, null, null, 0L, 0L, 0L, 0, "", this.mLiveId, false, "", null, bVar.user_name, "")));
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
        this.btg.setTextColor(this.ojr.getResources().getColor(a.c.sdk_color_525252));
        this.btg.setVisibility(0);
    }

    public void Yb() {
        this.btg.setVisibility(8);
    }

    public void Hm(String str) {
        this.mListView.setNextPage(this.gDM);
        this.gDM.endLoadDataWithNoMore(str);
    }

    public void Nl(int i) {
        this.ojt.setVisibility(0);
        this.ojt.setText("今日魅力 " + StringHelper.formatYuyinValue(i));
    }

    public void b(i.a aVar) {
        if (aVar == null) {
            if (this.oju != null) {
                this.oju.getView().setVisibility(8);
                return;
            }
            return;
        }
        View view = null;
        if (this.oju != null) {
            this.oju.a(aVar);
            this.oju.getView().setVisibility(0);
            view = this.oju.getView();
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
