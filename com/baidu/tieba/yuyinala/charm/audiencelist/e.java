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
    private CommonEmptyView btg;
    private TextView fWZ;
    private PbListView gDM;
    private View.OnClickListener gDY = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private YuyinALaAudiencesActivity oim;
    private h oin;
    private TextView oio;

    public e(YuyinALaAudiencesActivity yuyinALaAudiencesActivity, String str) {
        this.oim = yuyinALaAudiencesActivity;
        this.mLiveId = str;
        this.mRootView = this.oim.getLayoutInflater().inflate(a.g.yuyin_online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.btg = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.oio = (TextView) this.mRootView.findViewById(a.f.tv_value_total);
        this.oin = new h(yuyinALaAudiencesActivity.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.oin);
        this.mListView.setEmptyView(this.btg);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.e.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.oim.finish();
                e.this.a(e.this.oin.getItem(i));
            }
        });
        this.fWZ = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gDM == null) {
            this.gDM = new PbListView(this.oim);
            this.gDM.setTextColor(this.oim.getResources().getColor(a.c.sdk_color_858585));
            this.gDM.setSkinType(0);
            this.gDM.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gDM.setmTextSize(14.0f);
            this.gDM.createView();
            this.gDM.setHeight(BdUtilHelper.dip2px(this.oim, 60.0f));
        }
    }

    public void gx(List<a> list) {
        this.oin.setData(list);
    }

    public void dG(boolean z) {
        if (z) {
            this.btg.reset();
            this.btg.setTitle("还没有观众哦~");
            this.btg.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.btg.setTextColor(this.oim.getResources().getColor(a.c.sdk_color_525252));
            this.btg.setVisibility(0);
            return;
        }
        this.btg.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null && aVar.aJV != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oim.getPageContext().getPageActivity(), ExtraParamsManager.getDecryptUserId(aVar.aJV.userUk), aVar.aJV.userName, aVar.aJV.portrait, aVar.aJV.sex, aVar.aJV.levelId, null, null, 0L, aVar.aJV.fansCount, aVar.aJV.fansCount, aVar.aJV.userStatus, "", this.mLiveId, false, "", null, aVar.aJV.userName, "")));
        }
    }

    public void eZ(long j) {
        if (this.fWZ != null) {
            this.fWZ.setText(String.format(this.oim.getString(a.h.yuyin_online_count), StringHelper.formatYuyinValue(j)));
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
        this.btg.setTextColor(this.oim.getResources().getColor(a.c.sdk_color_525252));
        this.btg.setVisibility(0);
    }

    public void Yb() {
        this.btg.setVisibility(8);
    }

    public void Hm(String str) {
        this.mListView.setNextPage(this.gDM);
        this.gDM.endLoadDataWithNoMore(str);
    }
}
