package com.baidu.tieba.yuyinala.charm.bannedpost;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.charm.bannedpost.c;
/* loaded from: classes11.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private String mGroupId;
    private String mLiveId;
    private String mRoomId;
    private int mType;
    private d oqp;
    private YuyinBannedPostListActivity oqq;
    private c oqr;

    public e(YuyinBannedPostListActivity yuyinBannedPostListActivity, String str, String str2, String str3, int i) {
        this.oqq = yuyinBannedPostListActivity;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
    }

    public void createView() {
        this.oqp = new d(this.oqq, this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
        loadData();
    }

    public void loadData() {
        if (this.oqr == null) {
            this.oqr = new c(this.oqq.getPageContext().getContext());
            this.oqr.a(new c.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.e.1
                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.c.a
                public void a(a aVar) {
                    if (e.this.oqp != null) {
                        if (aVar == null || aVar.aGx == null || aVar.aGx.size() == 0) {
                            e.this.oqp.dQ(true);
                            return;
                        }
                        e.this.oqp.WZ();
                        e.this.oqp.gn(aVar.aGx);
                    }
                }

                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.c.a
                public void A(int i, String str) {
                    if (e.this.oqp != null) {
                        e.this.oqp.dQ(false);
                        e.this.oqp.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.e.1.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (BdNetTypeUtil.isNetWorkAvailable()) {
                                    e.this.loadData();
                                } else {
                                    e.this.oqq.getPageContext().showToast(e.this.oqq.getResources().getString(a.h.sdk_no_network_guide));
                                }
                            }
                        });
                    }
                }
            });
        }
        this.oqr.H(this.mLiveId, this.mGroupId, this.mRoomId, this.mType + "");
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.oqp == null) {
            return null;
        }
        return this.oqp.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mType == 1 ? "本场禁言" : "永久禁言";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JL() {
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
        if (this.oqr != null) {
            this.oqr.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
