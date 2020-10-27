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
    private CommonEmptyView boq;
    private PbListView gpG;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mRoomId;
    private View mRootView;
    private int mType;
    private YuyinBannedPostListActivity nMr;
    private b nMs;

    public d(YuyinBannedPostListActivity yuyinBannedPostListActivity, String str, String str2, String str3, int i) {
        this.nMr = yuyinBannedPostListActivity;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
        this.mRootView = this.nMr.getLayoutInflater().inflate(a.h.yuyin_banned_post_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.boq = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.nMs = new b(yuyinBannedPostListActivity.getPageContext(), this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
        this.nMs.a(new b.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.d.1
            @Override // com.baidu.tieba.yuyinala.charm.bannedpost.b.a
            public void bME() {
                d.this.dj(true);
            }
        });
        this.mListView.setAdapter((ListAdapter) this.nMs);
        this.mListView.setEmptyView(this.boq);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.d.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                d.this.a(d.this.nMs.getItem(i2));
            }
        });
        if (this.gpG == null) {
            this.gpG = new PbListView(this.nMr);
            this.gpG.setTextColor(this.nMr.getResources().getColor(a.d.sdk_color_858585));
            this.gpG.setSkinType(0);
            this.gpG.setmTextSize(14.0f);
            this.gpG.createView();
            this.gpG.setHeight(BdUtilHelper.dip2px(this.nMr, 60.0f));
        }
    }

    public void gb(List<a.C0879a> list) {
        this.nMs.setData(list);
    }

    public void dj(boolean z) {
        if (z) {
            this.boq.reset();
            if (this.mType == 1) {
                this.boq.setTitle("还没有人被本场次禁言哦~");
            } else if (this.mType == 2) {
                this.boq.setTitle("还没有人被永久禁言哦~");
            }
            this.boq.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.boq.setTextColor(this.nMr.getResources().getColor(a.d.sdk_color_525252));
            this.boq.setVisibility(0);
            return;
        }
        this.boq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0879a c0879a) {
        if (c0879a != null) {
            this.nMr.finish();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.nMr.getPageContext().getContext(), ExtraParamsManager.getDecryptUserId(c0879a.uk), c0879a.user_name, c0879a.bd_portrait, 0, 0, "", null, 0L, 0L, 0L, 0, this.mGroupId, this.mLiveId, false, "", null, c0879a.user_name, "")));
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
        this.boq.setTextColor(this.nMr.getResources().getColor(a.d.sdk_color_525252));
        this.boq.setVisibility(0);
    }

    public void TK() {
        this.boq.setVisibility(8);
    }
}
