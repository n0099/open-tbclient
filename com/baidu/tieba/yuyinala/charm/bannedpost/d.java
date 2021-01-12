package com.baidu.tieba.yuyinala.charm.bannedpost;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.yuyinala.charm.bannedpost.a;
import com.baidu.tieba.yuyinala.charm.bannedpost.b;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    private CommonEmptyView btf;
    private PbListView gKS;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mRoomId;
    private View mRootView;
    private int mType;
    private YuyinBannedPostListActivity ofS;
    private b ofT;

    public d(YuyinBannedPostListActivity yuyinBannedPostListActivity, String str, String str2, String str3, int i) {
        this.ofS = yuyinBannedPostListActivity;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
        this.mRootView = this.ofS.getLayoutInflater().inflate(a.g.yuyin_banned_post_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.btf = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.ofT = new b(yuyinBannedPostListActivity.getPageContext(), this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
        this.ofT.a(new b.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.d.1
            @Override // com.baidu.tieba.yuyinala.charm.bannedpost.b.a
            public void bQU() {
                d.this.dI(true);
            }
        });
        this.mListView.setAdapter((ListAdapter) this.ofT);
        this.mListView.setEmptyView(this.btf);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.d.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                d.this.a(d.this.ofT.getItem(i2));
            }
        });
        if (this.gKS == null) {
            this.gKS = new PbListView(this.ofS);
            this.gKS.setTextColor(this.ofS.getResources().getColor(a.c.sdk_color_858585));
            this.gKS.setSkinType(0);
            this.gKS.setmTextSize(14.0f);
            this.gKS.createView();
            this.gKS.setHeight(BdUtilHelper.dip2px(this.ofS, 60.0f));
        }
    }

    public void gp(List<a.C0909a> list) {
        this.ofT.setData(list);
    }

    public void dI(boolean z) {
        if (z) {
            this.btf.reset();
            if (this.mType == 1) {
                this.btf.setTitle("还没有人被本场次禁言哦~");
            } else if (this.mType == 2) {
                this.btf.setTitle("还没有人被永久禁言哦~");
            }
            this.btf.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.btf.setTextColor(this.ofS.getResources().getColor(a.c.sdk_color_525252));
            this.btf.setVisibility(0);
            return;
        }
        this.btf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0909a c0909a) {
        if (c0909a != null) {
            this.ofS.finish();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.ofS.getPageContext().getContext(), ExtraParamsManager.getDecryptUserId(c0909a.uk), c0909a.user_name, c0909a.bd_portrait, 0, 0, "", null, 0L, 0L, 0L, 0, this.mGroupId, this.mLiveId, false, "", null, c0909a.user_name, "")));
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
        this.btf.setTextColor(this.ofS.getResources().getColor(a.c.sdk_color_525252));
        this.btf.setVisibility(0);
    }

    public void Vq() {
        this.btf.setVisibility(8);
    }
}
