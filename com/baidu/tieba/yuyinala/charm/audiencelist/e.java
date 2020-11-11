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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import java.util.List;
/* loaded from: classes4.dex */
public class e {
    private CommonEmptyView bpJ;
    private TextView fPy;
    private View.OnClickListener gvG = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private PbListView gvu;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private YuyinALaAudiencesActivity nRJ;
    private h nRK;
    private TextView nRL;

    public e(YuyinALaAudiencesActivity yuyinALaAudiencesActivity, String str) {
        this.nRJ = yuyinALaAudiencesActivity;
        this.mLiveId = str;
        this.mRootView = this.nRJ.getLayoutInflater().inflate(a.g.yuyin_online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bpJ = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.nRL = (TextView) this.mRootView.findViewById(a.f.tv_value_total);
        this.nRK = new h(yuyinALaAudiencesActivity.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.nRK);
        this.mListView.setEmptyView(this.bpJ);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.nRJ.finish();
                e.this.a(e.this.nRK.getItem(i));
            }
        });
        this.fPy = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gvu == null) {
            this.gvu = new PbListView(this.nRJ);
            this.gvu.setTextColor(this.nRJ.getResources().getColor(a.c.sdk_color_858585));
            this.gvu.setSkinType(0);
            this.gvu.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gvu.setmTextSize(14.0f);
            this.gvu.createView();
            this.gvu.setHeight(BdUtilHelper.dip2px(this.nRJ, 60.0f));
        }
    }

    public void gj(List<a> list) {
        this.nRK.setData(list);
    }

    public void dq(boolean z) {
        if (z) {
            this.bpJ.reset();
            this.bpJ.setTitle("还没有观众哦~");
            this.bpJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bpJ.setTextColor(this.nRJ.getResources().getColor(a.c.sdk_color_525252));
            this.bpJ.setVisibility(0);
            return;
        }
        this.bpJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null && aVar.aIV != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.nRJ.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(aVar.aIV.userUk), aVar.aIV.userName, aVar.aIV.portrait, aVar.aIV.sex, aVar.aIV.levelId, null, null, 0L, aVar.aIV.fansCount, aVar.aIV.fansCount, aVar.aIV.userStatus, "", this.mLiveId, false, "", null, aVar.aIV.userName, "")));
        }
    }

    public void ew(long j) {
        if (this.fPy != null) {
            this.fPy.setText(String.format(this.nRJ.getString(a.h.yuyin_online_count), StringHelper.formatYuyinValue(j)));
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
        this.bpJ.setTextColor(this.nRJ.getResources().getColor(a.c.sdk_color_525252));
        this.bpJ.setVisibility(0);
    }

    public void Wk() {
        this.bpJ.setVisibility(8);
    }

    public void GX(String str) {
        this.mListView.setNextPage(this.gvu);
        this.gvu.endLoadDataWithNoMore(str);
    }
}
