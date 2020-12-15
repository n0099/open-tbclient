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
    private d oiR;
    private YuyinBannedPostListActivity oiS;
    private c oiT;

    public e(YuyinBannedPostListActivity yuyinBannedPostListActivity, String str, String str2, String str3, int i) {
        this.oiS = yuyinBannedPostListActivity;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
    }

    public void createView() {
        this.oiR = new d(this.oiS, this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
        loadData();
    }

    public void loadData() {
        if (this.oiT == null) {
            this.oiT = new c(this.oiS.getPageContext().getContext());
            this.oiT.a(new c.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.e.1
                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.c.a
                public void a(a aVar) {
                    if (e.this.oiR != null) {
                        if (aVar == null || aVar.aIZ == null || aVar.aIZ.size() == 0) {
                            e.this.oiR.dG(true);
                            return;
                        }
                        e.this.oiR.Yb();
                        e.this.oiR.gx(aVar.aIZ);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.c.a
                public void t(int i, String str) {
                    if (e.this.oiR != null) {
                        e.this.oiR.dG(false);
                        e.this.oiR.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.e.1.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (BdNetTypeUtil.isNetWorkAvailable()) {
                                    e.this.loadData();
                                } else {
                                    e.this.oiS.getPageContext().showToast(e.this.oiS.getResources().getString(a.h.sdk_no_network_guide));
                                }
                            }
                        });
                    }
                }
            });
        }
        this.oiT.K(this.mLiveId, this.mGroupId, this.mRoomId, this.mType + "");
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.oiR == null) {
            return null;
        }
        return this.oiR.getRootView();
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
        if (this.oiT != null) {
            this.oiT.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
