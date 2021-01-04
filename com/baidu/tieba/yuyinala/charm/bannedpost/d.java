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
    private CommonEmptyView bxT;
    private PbListView gPy;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mRoomId;
    private View mRootView;
    private int mType;
    private YuyinBannedPostListActivity oky;
    private b okz;

    public d(YuyinBannedPostListActivity yuyinBannedPostListActivity, String str, String str2, String str3, int i) {
        this.oky = yuyinBannedPostListActivity;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
        this.mRootView = this.oky.getLayoutInflater().inflate(a.g.yuyin_banned_post_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bxT = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.okz = new b(yuyinBannedPostListActivity.getPageContext(), this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
        this.okz.a(new b.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.d.1
            @Override // com.baidu.tieba.yuyinala.charm.bannedpost.b.a
            public void bUL() {
                d.this.dM(true);
            }
        });
        this.mListView.setAdapter((ListAdapter) this.okz);
        this.mListView.setEmptyView(this.bxT);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.d.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                d.this.a(d.this.okz.getItem(i2));
            }
        });
        if (this.gPy == null) {
            this.gPy = new PbListView(this.oky);
            this.gPy.setTextColor(this.oky.getResources().getColor(a.c.sdk_color_858585));
            this.gPy.setSkinType(0);
            this.gPy.setmTextSize(14.0f);
            this.gPy.createView();
            this.gPy.setHeight(BdUtilHelper.dip2px(this.oky, 60.0f));
        }
    }

    public void gp(List<a.C0888a> list) {
        this.okz.setData(list);
    }

    public void dM(boolean z) {
        if (z) {
            this.bxT.reset();
            if (this.mType == 1) {
                this.bxT.setTitle("还没有人被本场次禁言哦~");
            } else if (this.mType == 2) {
                this.bxT.setTitle("还没有人被永久禁言哦~");
            }
            this.bxT.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bxT.setTextColor(this.oky.getResources().getColor(a.c.sdk_color_525252));
            this.bxT.setVisibility(0);
            return;
        }
        this.bxT.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0888a c0888a) {
        if (c0888a != null) {
            this.oky.finish();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oky.getPageContext().getContext(), ExtraParamsManager.getDecryptUserId(c0888a.uk), c0888a.user_name, c0888a.bd_portrait, 0, 0, "", null, 0L, 0L, 0L, 0, this.mGroupId, this.mLiveId, false, "", null, c0888a.user_name, "")));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void n(View.OnClickListener onClickListener) {
        this.bxT.reset();
        this.bxT.setTitle("网络加载失败了哦~");
        this.bxT.setRefreshButton("重新加载", onClickListener);
        this.bxT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bxT.setTextColor(this.oky.getResources().getColor(a.c.sdk_color_525252));
        this.bxT.setVisibility(0);
    }

    public void Zi() {
        this.bxT.setVisibility(8);
    }
}
