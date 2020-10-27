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
    private CommonEmptyView boq;
    private TextView fJI;
    private PbListView gpG;
    private View.OnClickListener gpS = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private YuyinALaAudiencesActivity nLP;
    private h nLQ;
    private TextView nLR;

    public e(YuyinALaAudiencesActivity yuyinALaAudiencesActivity, String str) {
        this.nLP = yuyinALaAudiencesActivity;
        this.mLiveId = str;
        this.mRootView = this.nLP.getLayoutInflater().inflate(a.h.yuyin_online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.boq = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.nLR = (TextView) this.mRootView.findViewById(a.g.tv_value_total);
        this.nLQ = new h(yuyinALaAudiencesActivity.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.nLQ);
        this.mListView.setEmptyView(this.boq);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.nLP.finish();
                e.this.a(e.this.nLQ.getItem(i));
            }
        });
        this.fJI = (TextView) this.mRootView.findViewById(a.g.top_text);
        if (this.gpG == null) {
            this.gpG = new PbListView(this.nLP);
            this.gpG.setTextColor(this.nLP.getResources().getColor(a.d.sdk_color_858585));
            this.gpG.setSkinType(0);
            this.gpG.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.gpG.setmTextSize(14.0f);
            this.gpG.createView();
            this.gpG.setHeight(BdUtilHelper.dip2px(this.nLP, 60.0f));
        }
    }

    public void gb(List<a> list) {
        this.nLQ.setData(list);
    }

    public void dj(boolean z) {
        if (z) {
            this.boq.reset();
            this.boq.setTitle("还没有观众哦~");
            this.boq.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.boq.setTextColor(this.nLP.getResources().getColor(a.d.sdk_color_525252));
            this.boq.setVisibility(0);
            return;
        }
        this.boq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null && aVar.aIe != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.nLP.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(aVar.aIe.userUk), aVar.aIe.userName, aVar.aIe.portrait, aVar.aIe.sex, aVar.aIe.levelId, null, null, 0L, aVar.aIe.fansCount, aVar.aIe.fansCount, aVar.aIe.userStatus, "", this.mLiveId, false, "", null, aVar.aIe.userName, "")));
        }
    }

    public void ea(long j) {
        if (this.fJI != null) {
            this.fJI.setText(String.format(this.nLP.getString(a.i.yuyin_online_count), StringHelper.formatYuyinValue(j)));
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
        this.boq.setTextColor(this.nLP.getResources().getColor(a.d.sdk_color_525252));
        this.boq.setVisibility(0);
    }

    public void TK() {
        this.boq.setVisibility(8);
    }

    public void GK(String str) {
        this.mListView.setNextPage(this.gpG);
        this.gpG.endLoadDataWithNoMore(str);
    }
}
