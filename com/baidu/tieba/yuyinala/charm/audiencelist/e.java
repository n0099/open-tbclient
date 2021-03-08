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
/* loaded from: classes10.dex */
public class e {
    private CommonEmptyView byj;
    private AlaLoadingView cfw;
    private View.OnClickListener gPH = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private PbListView gPv;
    private TextView gfU;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private YuyinALaAudiencesActivity orR;
    private h orS;

    public e(YuyinALaAudiencesActivity yuyinALaAudiencesActivity, String str) {
        this.orR = yuyinALaAudiencesActivity;
        this.mLiveId = str;
        this.mRootView = this.orR.getLayoutInflater().inflate(a.g.yuyin_online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.byj = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.cfw = (AlaLoadingView) this.mRootView.findViewById(a.f.loading_view);
        this.orS = new h(yuyinALaAudiencesActivity.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.orS);
        this.mListView.setEmptyView(this.byj);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.orR.finish();
                e.this.a(e.this.orS.getItem(i));
            }
        });
        this.gfU = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gPv == null) {
            this.gPv = new PbListView(this.orR);
            this.gPv.setTextColor(this.orR.getResources().getColor(a.c.sdk_color_858585));
            this.gPv.setSkinType(0);
            this.gPv.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gPv.setmTextSize(14.0f);
            this.gPv.createView();
            this.gPv.setHeight(BdUtilHelper.dip2px(this.orR, 60.0f));
        }
    }

    public void gn(List<a> list) {
        this.orS.setData(list);
    }

    public void dQ(boolean z) {
        if (z) {
            this.byj.reset();
            this.byj.setTitle("还没有观众哦~");
            this.byj.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.byj.setTextColor(this.orR.getResources().getColor(a.c.sdk_color_525252));
            this.byj.setVisibility(0);
            return;
        }
        this.byj.setVisibility(8);
    }

    public void dR(boolean z) {
        if (z) {
            if (this.cfw != null) {
                this.cfw.setVisibility(0);
            }
        } else if (this.cfw != null) {
            this.cfw.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null && aVar.aJD != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.orR.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(aVar.aJD.userUk), aVar.aJD.userName, aVar.aJD.portrait, aVar.aJD.sex, aVar.aJD.levelId, null, null, 0L, aVar.aJD.fansCount, aVar.aJD.fansCount, aVar.aJD.userStatus, "", this.mLiveId, false, "", null, aVar.aJD.userName, "")));
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
        this.byj.setTextColor(this.orR.getResources().getColor(a.c.sdk_color_525252));
        this.byj.setVisibility(0);
    }

    public void Xc() {
        this.byj.setVisibility(8);
    }

    public void GJ(String str) {
        this.mListView.setNextPage(this.gPv);
        this.gPv.endLoadDataWithNoMore(str);
    }

    public BdListView getListView() {
        return this.mListView;
    }
}
