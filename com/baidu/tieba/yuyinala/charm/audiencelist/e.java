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
    private CommonEmptyView bxT;
    private AlaLoadingView ceG;
    private View.OnClickListener gPK = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private PbListView gPy;
    private TextView ggF;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private YuyinALaAudiencesActivity ojX;
    private h ojY;

    public e(YuyinALaAudiencesActivity yuyinALaAudiencesActivity, String str) {
        this.ojX = yuyinALaAudiencesActivity;
        this.mLiveId = str;
        this.mRootView = this.ojX.getLayoutInflater().inflate(a.g.yuyin_online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bxT = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.ceG = (AlaLoadingView) this.mRootView.findViewById(a.f.loading_view);
        this.ojY = new h(yuyinALaAudiencesActivity.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.ojY);
        this.mListView.setEmptyView(this.bxT);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.ojX.finish();
                e.this.a(e.this.ojY.getItem(i));
            }
        });
        this.ggF = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gPy == null) {
            this.gPy = new PbListView(this.ojX);
            this.gPy.setTextColor(this.ojX.getResources().getColor(a.c.sdk_color_858585));
            this.gPy.setSkinType(0);
            this.gPy.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gPy.setmTextSize(14.0f);
            this.gPy.createView();
            this.gPy.setHeight(BdUtilHelper.dip2px(this.ojX, 60.0f));
        }
    }

    public void gp(List<a> list) {
        this.ojY.setData(list);
    }

    public void dM(boolean z) {
        if (z) {
            this.bxT.reset();
            this.bxT.setTitle("还没有观众哦~");
            this.bxT.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bxT.setTextColor(this.ojX.getResources().getColor(a.c.sdk_color_525252));
            this.bxT.setVisibility(0);
            return;
        }
        this.bxT.setVisibility(8);
    }

    public void dN(boolean z) {
        if (z) {
            if (this.ceG != null) {
                this.ceG.setVisibility(0);
            }
        } else if (this.ceG != null) {
            this.ceG.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null && aVar.aKu != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.ojX.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(aVar.aKu.userUk), aVar.aKu.userName, aVar.aKu.portrait, aVar.aKu.sex, aVar.aKu.levelId, null, null, 0L, aVar.aKu.fansCount, aVar.aKu.fansCount, aVar.aKu.userStatus, "", this.mLiveId, false, "", null, aVar.aKu.userName, "")));
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
        this.bxT.setTextColor(this.ojX.getResources().getColor(a.c.sdk_color_525252));
        this.bxT.setVisibility(0);
    }

    public void Zi() {
        this.bxT.setVisibility(8);
    }

    public void Hm(String str) {
        this.mListView.setNextPage(this.gPy);
        this.gPy.endLoadDataWithNoMore(str);
    }

    public BdListView getListView() {
        return this.mListView;
    }
}
