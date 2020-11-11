package com.baidu.tieba.yuyinala.charm.bannedpost;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.charm.bannedpost.c;
/* loaded from: classes4.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private String mGroupId;
    private String mLiveId;
    private String mRoomId;
    private int mType;
    private d nSo;
    private YuyinBannedPostListActivity nSp;
    private c nSq;

    public e(YuyinBannedPostListActivity yuyinBannedPostListActivity, String str, String str2, String str3, int i) {
        this.nSp = yuyinBannedPostListActivity;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
    }

    public void createView() {
        this.nSo = new d(this.nSp, this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
        loadData();
    }

    public void loadData() {
        if (this.nSq == null) {
            this.nSq = new c(this.nSp.getPageContext().getContext());
            this.nSq.a(new c.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.e.1
                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.c.a
                public void a(a aVar) {
                    if (e.this.nSo != null) {
                        if (aVar == null || aVar.aIb == null || aVar.aIb.size() == 0) {
                            e.this.nSo.dq(true);
                            return;
                        }
                        e.this.nSo.Wk();
                        e.this.nSo.gj(aVar.aIb);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.c.a
                public void t(int i, String str) {
                    if (e.this.nSo != null) {
                        e.this.nSo.dq(false);
                        e.this.nSo.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.e.1.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (BdNetTypeUtil.isNetWorkAvailable()) {
                                    e.this.loadData();
                                } else {
                                    e.this.nSp.getPageContext().showToast(e.this.nSp.getResources().getString(a.h.sdk_no_network_guide));
                                }
                            }
                        });
                    }
                }
            });
        }
        this.nSq.K(this.mLiveId, this.mGroupId, this.mRoomId, this.mType + "");
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.nSo == null) {
            return null;
        }
        return this.nSo.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mType == 1 ? "本场禁言" : "永久禁言";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Lr() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ls() {
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
        if (this.nSq != null) {
            this.nSq.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
