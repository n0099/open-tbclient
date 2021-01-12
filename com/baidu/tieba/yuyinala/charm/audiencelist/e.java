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
    private AlaLoadingView bZQ;
    private CommonEmptyView btf;
    private PbListView gKS;
    private View.OnClickListener gLe = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private TextView gbW;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private YuyinALaAudiencesActivity ofr;
    private h ofs;

    public e(YuyinALaAudiencesActivity yuyinALaAudiencesActivity, String str) {
        this.ofr = yuyinALaAudiencesActivity;
        this.mLiveId = str;
        this.mRootView = this.ofr.getLayoutInflater().inflate(a.g.yuyin_online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.btf = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.bZQ = (AlaLoadingView) this.mRootView.findViewById(a.f.loading_view);
        this.ofs = new h(yuyinALaAudiencesActivity.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.ofs);
        this.mListView.setEmptyView(this.btf);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.ofr.finish();
                e.this.a(e.this.ofs.getItem(i));
            }
        });
        this.gbW = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gKS == null) {
            this.gKS = new PbListView(this.ofr);
            this.gKS.setTextColor(this.ofr.getResources().getColor(a.c.sdk_color_858585));
            this.gKS.setSkinType(0);
            this.gKS.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gKS.setmTextSize(14.0f);
            this.gKS.createView();
            this.gKS.setHeight(BdUtilHelper.dip2px(this.ofr, 60.0f));
        }
    }

    public void gp(List<a> list) {
        this.ofs.setData(list);
    }

    public void dI(boolean z) {
        if (z) {
            this.btf.reset();
            this.btf.setTitle("还没有观众哦~");
            this.btf.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.btf.setTextColor(this.ofr.getResources().getColor(a.c.sdk_color_525252));
            this.btf.setVisibility(0);
            return;
        }
        this.btf.setVisibility(8);
    }

    public void dJ(boolean z) {
        if (z) {
            if (this.bZQ != null) {
                this.bZQ.setVisibility(0);
            }
        } else if (this.bZQ != null) {
            this.bZQ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null && aVar.aFH != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.ofr.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(aVar.aFH.userUk), aVar.aFH.userName, aVar.aFH.portrait, aVar.aFH.sex, aVar.aFH.levelId, null, null, 0L, aVar.aFH.fansCount, aVar.aFH.fansCount, aVar.aFH.userStatus, "", this.mLiveId, false, "", null, aVar.aFH.userName, "")));
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
        this.btf.setTextColor(this.ofr.getResources().getColor(a.c.sdk_color_525252));
        this.btf.setVisibility(0);
    }

    public void Vq() {
        this.btf.setVisibility(8);
    }

    public void Ga(String str) {
        this.mListView.setNextPage(this.gKS);
        this.gKS.endLoadDataWithNoMore(str);
    }

    public BdListView getListView() {
        return this.mListView;
    }
}
