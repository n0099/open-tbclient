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
    private CommonEmptyView bnY;
    private TextView fPh;
    private PbListView gvb;
    private View.OnClickListener gvn = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private YuyinALaAudiencesActivity nTm;
    private h nTn;
    private TextView nTo;

    public e(YuyinALaAudiencesActivity yuyinALaAudiencesActivity, String str) {
        this.nTm = yuyinALaAudiencesActivity;
        this.mLiveId = str;
        this.mRootView = this.nTm.getLayoutInflater().inflate(a.g.yuyin_online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bnY = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.nTo = (TextView) this.mRootView.findViewById(a.f.tv_value_total);
        this.nTn = new h(yuyinALaAudiencesActivity.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.nTn);
        this.mListView.setEmptyView(this.bnY);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.nTm.finish();
                e.this.a(e.this.nTn.getItem(i));
            }
        });
        this.fPh = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gvb == null) {
            this.gvb = new PbListView(this.nTm);
            this.gvb.setTextColor(this.nTm.getResources().getColor(a.c.sdk_color_858585));
            this.gvb.setSkinType(0);
            this.gvb.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gvb.setmTextSize(14.0f);
            this.gvb.createView();
            this.gvb.setHeight(BdUtilHelper.dip2px(this.nTm, 60.0f));
        }
    }

    public void gj(List<a> list) {
        this.nTn.setData(list);
    }

    public void ds(boolean z) {
        if (z) {
            this.bnY.reset();
            this.bnY.setTitle("还没有观众哦~");
            this.bnY.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bnY.setTextColor(this.nTm.getResources().getColor(a.c.sdk_color_525252));
            this.bnY.setVisibility(0);
            return;
        }
        this.bnY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null && aVar.aHk != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.nTm.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(aVar.aHk.userUk), aVar.aHk.userName, aVar.aHk.portrait, aVar.aHk.sex, aVar.aHk.levelId, null, null, 0L, aVar.aHk.fansCount, aVar.aHk.fansCount, aVar.aHk.userStatus, "", this.mLiveId, false, "", null, aVar.aHk.userName, "")));
        }
    }

    public void ew(long j) {
        if (this.fPh != null) {
            this.fPh.setText(String.format(this.nTm.getString(a.h.yuyin_online_count), StringHelper.formatYuyinValue(j)));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void m(View.OnClickListener onClickListener) {
        this.bnY.reset();
        this.bnY.setTitle("网络加载失败了哦~");
        this.bnY.setRefreshButton("重新加载", onClickListener);
        this.bnY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bnY.setTextColor(this.nTm.getResources().getColor(a.c.sdk_color_525252));
        this.bnY.setVisibility(0);
    }

    public void VB() {
        this.bnY.setVisibility(8);
    }

    public void Gy(String str) {
        this.mListView.setNextPage(this.gvb);
        this.gvb.endLoadDataWithNoMore(str);
    }
}
