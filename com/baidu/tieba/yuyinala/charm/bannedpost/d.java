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
    private CommonEmptyView byj;
    private PbListView gPv;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mRoomId;
    private View mRootView;
    private int mType;
    private YuyinBannedPostListActivity oss;
    private b ost;

    public d(YuyinBannedPostListActivity yuyinBannedPostListActivity, String str, String str2, String str3, int i) {
        this.oss = yuyinBannedPostListActivity;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
        this.mRootView = this.oss.getLayoutInflater().inflate(a.g.yuyin_banned_post_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.byj = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.ost = new b(yuyinBannedPostListActivity.getPageContext(), this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
        this.ost.a(new b.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.d.1
            @Override // com.baidu.tieba.yuyinala.charm.bannedpost.b.a
            public void bRL() {
                d.this.dQ(true);
            }
        });
        this.mListView.setAdapter((ListAdapter) this.ost);
        this.mListView.setEmptyView(this.byj);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.d.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                d.this.a(d.this.ost.getItem(i2));
            }
        });
        if (this.gPv == null) {
            this.gPv = new PbListView(this.oss);
            this.gPv.setTextColor(this.oss.getResources().getColor(a.c.sdk_color_858585));
            this.gPv.setSkinType(0);
            this.gPv.setmTextSize(14.0f);
            this.gPv.createView();
            this.gPv.setHeight(BdUtilHelper.dip2px(this.oss, 60.0f));
        }
    }

    public void gn(List<a.C0920a> list) {
        this.ost.setData(list);
    }

    public void dQ(boolean z) {
        if (z) {
            this.byj.reset();
            if (this.mType == 1) {
                this.byj.setTitle("还没有人被本场次禁言哦~");
            } else if (this.mType == 2) {
                this.byj.setTitle("还没有人被永久禁言哦~");
            }
            this.byj.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.byj.setTextColor(this.oss.getResources().getColor(a.c.sdk_color_525252));
            this.byj.setVisibility(0);
            return;
        }
        this.byj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0920a c0920a) {
        if (c0920a != null) {
            this.oss.finish();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oss.getPageContext().getContext(), ExtraParamsManager.getDecryptUserId(c0920a.uk), c0920a.user_name, c0920a.bd_portrait, 0, 0, "", null, 0L, 0L, 0L, 0, this.mGroupId, this.mLiveId, false, "", null, c0920a.user_name, "")));
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
        this.byj.setTextColor(this.oss.getResources().getColor(a.c.sdk_color_525252));
        this.byj.setVisibility(0);
    }

    public void Xc() {
        this.byj.setVisibility(8);
    }
}
