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
/* loaded from: classes11.dex */
public class d {
    private CommonEmptyView bwJ;
    private PbListView gNM;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mRoomId;
    private View mRootView;
    private int mType;
    private YuyinBannedPostListActivity oqm;
    private b oqn;

    public d(YuyinBannedPostListActivity yuyinBannedPostListActivity, String str, String str2, String str3, int i) {
        this.oqm = yuyinBannedPostListActivity;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
        this.mRootView = this.oqm.getLayoutInflater().inflate(a.g.yuyin_banned_post_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bwJ = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.oqn = new b(yuyinBannedPostListActivity.getPageContext(), this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
        this.oqn.a(new b.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.d.1
            @Override // com.baidu.tieba.yuyinala.charm.bannedpost.b.a
            public void bRF() {
                d.this.dQ(true);
            }
        });
        this.mListView.setAdapter((ListAdapter) this.oqn);
        this.mListView.setEmptyView(this.bwJ);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.d.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                d.this.a(d.this.oqn.getItem(i2));
            }
        });
        if (this.gNM == null) {
            this.gNM = new PbListView(this.oqm);
            this.gNM.setTextColor(this.oqm.getResources().getColor(a.c.sdk_color_858585));
            this.gNM.setSkinType(0);
            this.gNM.setmTextSize(14.0f);
            this.gNM.createView();
            this.gNM.setHeight(BdUtilHelper.dip2px(this.oqm, 60.0f));
        }
    }

    public void gn(List<a.C0914a> list) {
        this.oqn.setData(list);
    }

    public void dQ(boolean z) {
        if (z) {
            this.bwJ.reset();
            if (this.mType == 1) {
                this.bwJ.setTitle("还没有人被本场次禁言哦~");
            } else if (this.mType == 2) {
                this.bwJ.setTitle("还没有人被永久禁言哦~");
            }
            this.bwJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bwJ.setTextColor(this.oqm.getResources().getColor(a.c.sdk_color_525252));
            this.bwJ.setVisibility(0);
            return;
        }
        this.bwJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0914a c0914a) {
        if (c0914a != null) {
            this.oqm.finish();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oqm.getPageContext().getContext(), ExtraParamsManager.getDecryptUserId(c0914a.uk), c0914a.user_name, c0914a.bd_portrait, 0, 0, "", null, 0L, 0L, 0L, 0, this.mGroupId, this.mLiveId, false, "", null, c0914a.user_name, "")));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void n(View.OnClickListener onClickListener) {
        this.bwJ.reset();
        this.bwJ.setTitle("网络加载失败了哦~");
        this.bwJ.setRefreshButton("重新加载", onClickListener);
        this.bwJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bwJ.setTextColor(this.oqm.getResources().getColor(a.c.sdk_color_525252));
        this.bwJ.setVisibility(0);
    }

    public void WZ() {
        this.bwJ.setVisibility(8);
    }
}
