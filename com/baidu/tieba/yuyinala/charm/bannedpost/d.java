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
/* loaded from: classes4.dex */
public class d {
    private CommonEmptyView bpJ;
    private PbListView gvu;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mRoomId;
    private View mRootView;
    private int mType;
    private YuyinBannedPostListActivity nSl;
    private b nSm;

    public d(YuyinBannedPostListActivity yuyinBannedPostListActivity, String str, String str2, String str3, int i) {
        this.nSl = yuyinBannedPostListActivity;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
        this.mRootView = this.nSl.getLayoutInflater().inflate(a.g.yuyin_banned_post_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bpJ = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.nSm = new b(yuyinBannedPostListActivity.getPageContext(), this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
        this.nSm.a(new b.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.d.1
            @Override // com.baidu.tieba.yuyinala.charm.bannedpost.b.a
            public void bPe() {
                d.this.dq(true);
            }
        });
        this.mListView.setAdapter((ListAdapter) this.nSm);
        this.mListView.setEmptyView(this.bpJ);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.d.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                d.this.a(d.this.nSm.getItem(i2));
            }
        });
        if (this.gvu == null) {
            this.gvu = new PbListView(this.nSl);
            this.gvu.setTextColor(this.nSl.getResources().getColor(a.c.sdk_color_858585));
            this.gvu.setSkinType(0);
            this.gvu.setmTextSize(14.0f);
            this.gvu.createView();
            this.gvu.setHeight(BdUtilHelper.dip2px(this.nSl, 60.0f));
        }
    }

    public void gj(List<a.C0894a> list) {
        this.nSm.setData(list);
    }

    public void dq(boolean z) {
        if (z) {
            this.bpJ.reset();
            if (this.mType == 1) {
                this.bpJ.setTitle("还没有人被本场次禁言哦~");
            } else if (this.mType == 2) {
                this.bpJ.setTitle("还没有人被永久禁言哦~");
            }
            this.bpJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bpJ.setTextColor(this.nSl.getResources().getColor(a.c.sdk_color_525252));
            this.bpJ.setVisibility(0);
            return;
        }
        this.bpJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0894a c0894a) {
        if (c0894a != null) {
            this.nSl.finish();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.nSl.getPageContext().getContext(), ExtraParamsManager.getDecryptUserId(c0894a.uk), c0894a.user_name, c0894a.bd_portrait, 0, 0, "", null, 0L, 0L, 0L, 0, this.mGroupId, this.mLiveId, false, "", null, c0894a.user_name, "")));
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
        this.bpJ.setTextColor(this.nSl.getResources().getColor(a.c.sdk_color_525252));
        this.bpJ.setVisibility(0);
    }

    public void Wk() {
        this.bpJ.setVisibility(8);
    }
}
