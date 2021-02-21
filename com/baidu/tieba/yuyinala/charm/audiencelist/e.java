package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.view.AlaLoadingView;
import java.util.List;
/* loaded from: classes11.dex */
public class e {
    private CommonEmptyView bwJ;
    private AlaLoadingView cdW;
    private PbListView gNM;
    private View.OnClickListener gNY = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private TextView ger;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private YuyinALaAudiencesActivity opL;
    private h opM;

    public e(YuyinALaAudiencesActivity yuyinALaAudiencesActivity, String str) {
        this.opL = yuyinALaAudiencesActivity;
        this.mLiveId = str;
        this.mRootView = this.opL.getLayoutInflater().inflate(a.g.yuyin_online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bwJ = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.cdW = (AlaLoadingView) this.mRootView.findViewById(a.f.loading_view);
        this.opM = new h(yuyinALaAudiencesActivity.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.opM);
        this.mListView.setEmptyView(this.bwJ);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.opL.finish();
                e.this.a(e.this.opM.getItem(i));
            }
        });
        this.ger = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gNM == null) {
            this.gNM = new PbListView(this.opL);
            this.gNM.setTextColor(this.opL.getResources().getColor(a.c.sdk_color_858585));
            this.gNM.setSkinType(0);
            this.gNM.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gNM.setmTextSize(14.0f);
            this.gNM.createView();
            this.gNM.setHeight(BdUtilHelper.dip2px(this.opL, 60.0f));
        }
    }

    public void gn(List<a> list) {
        this.opM.setData(list);
    }

    public void dQ(boolean z) {
        if (z) {
            this.bwJ.reset();
            this.bwJ.setTitle("还没有观众哦~");
            this.bwJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bwJ.setTextColor(this.opL.getResources().getColor(a.c.sdk_color_525252));
            this.bwJ.setVisibility(0);
            return;
        }
        this.bwJ.setVisibility(8);
    }

    public void dR(boolean z) {
        if (z) {
            if (this.cdW != null) {
                this.cdW.setVisibility(0);
            }
        } else if (this.cdW != null) {
            this.cdW.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null && aVar.aId != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.opL.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(aVar.aId.userUk), aVar.aId.userName, aVar.aId.portrait, aVar.aId.sex, aVar.aId.levelId, null, null, 0L, aVar.aId.fansCount, aVar.aId.fansCount, aVar.aId.userStatus, "", this.mLiveId, false, "", null, aVar.aId.userName, "")));
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
        this.bwJ.setTextColor(this.opL.getResources().getColor(a.c.sdk_color_525252));
        this.bwJ.setVisibility(0);
    }

    public void WZ() {
        this.bwJ.setVisibility(8);
    }

    public void GA(String str) {
        this.mListView.setNextPage(this.gNM);
        this.gNM.endLoadDataWithNoMore(str);
    }

    public BdListView getListView() {
        return this.mListView;
    }
}
