package com.baidu.tieba.yuyinala.charm.bannedpost;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.charm.bannedpost.c;
/* loaded from: classes10.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private String mGroupId;
    private String mLiveId;
    private String mRoomId;
    private int mType;
    private d ofV;
    private YuyinBannedPostListActivity ofW;
    private c ofX;

    public e(YuyinBannedPostListActivity yuyinBannedPostListActivity, String str, String str2, String str3, int i) {
        this.ofW = yuyinBannedPostListActivity;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
    }

    public void createView() {
        this.ofV = new d(this.ofW, this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
        loadData();
    }

    public void loadData() {
        if (this.ofX == null) {
            this.ofX = new c(this.ofW.getPageContext().getContext());
            this.ofX.a(new c.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.e.1
                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.c.a
                public void a(a aVar) {
                    if (e.this.ofV != null) {
                        if (aVar == null || aVar.aEK == null || aVar.aEK.size() == 0) {
                            e.this.ofV.dI(true);
                            return;
                        }
                        e.this.ofV.Vq();
                        e.this.ofV.gp(aVar.aEK);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.c.a
                public void w(int i, String str) {
                    if (e.this.ofV != null) {
                        e.this.ofV.dI(false);
                        e.this.ofV.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.e.1.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (BdNetTypeUtil.isNetWorkAvailable()) {
                                    e.this.loadData();
                                } else {
                                    e.this.ofW.getPageContext().showToast(e.this.ofW.getResources().getString(a.h.sdk_no_network_guide));
                                }
                            }
                        });
                    }
                }
            });
        }
        this.ofX.J(this.mLiveId, this.mGroupId, this.mRoomId, this.mType + "");
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.ofV == null) {
            return null;
        }
        return this.ofV.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mType == 1 ? "本场禁言" : "永久禁言";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Im() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short In() {
        return (short) 0;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.ofX != null) {
            this.ofX.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
