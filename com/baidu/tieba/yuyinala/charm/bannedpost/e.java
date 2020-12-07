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
    private d oiP;
    private YuyinBannedPostListActivity oiQ;
    private c oiR;

    public e(YuyinBannedPostListActivity yuyinBannedPostListActivity, String str, String str2, String str3, int i) {
        this.oiQ = yuyinBannedPostListActivity;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
    }

    public void createView() {
        this.oiP = new d(this.oiQ, this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
        loadData();
    }

    public void loadData() {
        if (this.oiR == null) {
            this.oiR = new c(this.oiQ.getPageContext().getContext());
            this.oiR.a(new c.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.e.1
                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.c.a
                public void a(a aVar) {
                    if (e.this.oiP != null) {
                        if (aVar == null || aVar.aIZ == null || aVar.aIZ.size() == 0) {
                            e.this.oiP.dG(true);
                            return;
                        }
                        e.this.oiP.Yb();
                        e.this.oiP.gx(aVar.aIZ);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.c.a
                public void t(int i, String str) {
                    if (e.this.oiP != null) {
                        e.this.oiP.dG(false);
                        e.this.oiP.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.e.1.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (BdNetTypeUtil.isNetWorkAvailable()) {
                                    e.this.loadData();
                                } else {
                                    e.this.oiQ.getPageContext().showToast(e.this.oiQ.getResources().getString(a.h.sdk_no_network_guide));
                                }
                            }
                        });
                    }
                }
            });
        }
        this.oiR.K(this.mLiveId, this.mGroupId, this.mRoomId, this.mType + "");
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.oiP == null) {
            return null;
        }
        return this.oiP.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mType == 1 ? "本场禁言" : "永久禁言";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String MK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short ML() {
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
        if (this.oiR != null) {
            this.oiR.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
