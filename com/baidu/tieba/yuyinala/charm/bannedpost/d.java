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
    private CommonEmptyView bnY;
    private PbListView gvb;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mRoomId;
    private View mRootView;
    private int mType;
    private YuyinBannedPostListActivity nTO;
    private b nTP;

    public d(YuyinBannedPostListActivity yuyinBannedPostListActivity, String str, String str2, String str3, int i) {
        this.nTO = yuyinBannedPostListActivity;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
        this.mRootView = this.nTO.getLayoutInflater().inflate(a.g.yuyin_banned_post_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bnY = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.nTP = new b(yuyinBannedPostListActivity.getPageContext(), this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
        this.nTP.a(new b.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.d.1
            @Override // com.baidu.tieba.yuyinala.charm.bannedpost.b.a
            public void bOx() {
                d.this.ds(true);
            }
        });
        this.mListView.setAdapter((ListAdapter) this.nTP);
        this.mListView.setEmptyView(this.bnY);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.d.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                d.this.a(d.this.nTP.getItem(i2));
            }
        });
        if (this.gvb == null) {
            this.gvb = new PbListView(this.nTO);
            this.gvb.setTextColor(this.nTO.getResources().getColor(a.c.sdk_color_858585));
            this.gvb.setSkinType(0);
            this.gvb.setmTextSize(14.0f);
            this.gvb.createView();
            this.gvb.setHeight(BdUtilHelper.dip2px(this.nTO, 60.0f));
        }
    }

    public void gj(List<a.C0897a> list) {
        this.nTP.setData(list);
    }

    public void ds(boolean z) {
        if (z) {
            this.bnY.reset();
            if (this.mType == 1) {
                this.bnY.setTitle("还没有人被本场次禁言哦~");
            } else if (this.mType == 2) {
                this.bnY.setTitle("还没有人被永久禁言哦~");
            }
            this.bnY.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bnY.setTextColor(this.nTO.getResources().getColor(a.c.sdk_color_525252));
            this.bnY.setVisibility(0);
            return;
        }
        this.bnY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0897a c0897a) {
        if (c0897a != null) {
            this.nTO.finish();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.nTO.getPageContext().getContext(), ExtraParamsManager.getDecryptUserId(c0897a.uk), c0897a.user_name, c0897a.bd_portrait, 0, 0, "", null, 0L, 0L, 0L, 0, this.mGroupId, this.mLiveId, false, "", null, c0897a.user_name, "")));
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
        this.bnY.setTextColor(this.nTO.getResources().getColor(a.c.sdk_color_525252));
        this.bnY.setVisibility(0);
    }

    public void VB() {
        this.bnY.setVisibility(8);
    }
}
