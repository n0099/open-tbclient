package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class g implements com.baidu.live.liveroom.d.d {
    private String aEz;
    private String aZZ;
    private boolean bjr;
    private boolean bnZ;
    private String mLiveId;
    private YuyinALaAudiencesActivity nLH;
    com.baidu.live.h.b nLY = null;

    public g(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.nLH = yuyinALaAudiencesActivity;
    }

    public void createView() {
        com.baidu.live.noble.data.d dVar = new com.baidu.live.noble.data.d();
        dVar.mTbPageContext = this.nLH.getPageContext();
        dVar.mLiveId = this.mLiveId;
        dVar.bmv = this.aEz;
        dVar.mIsHost = this.bjr;
        dVar.bnZ = this.bnZ;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501013, com.baidu.live.h.b.class, dVar);
        if (runTask != null && runTask.getData() != null) {
            this.nLY = (com.baidu.live.h.b) runTask.getData();
        }
    }

    public g US(String str) {
        this.mLiveId = str;
        return this;
    }

    public g yG(boolean z) {
        this.bnZ = z;
        return this;
    }

    public g yH(boolean z) {
        this.bjr = z;
        return this;
    }

    public g UT(String str) {
        this.aEz = str;
        return this;
    }

    public g UU(String str) {
        this.aZZ = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.nLY == null) {
            return null;
        }
        return this.nLY.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.nLY == null) {
            return null;
        }
        return this.nLY.getTitle();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KR() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KS() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
        if (this.nLY != null) {
            this.nLY.bP(false);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.nLY != null) {
            this.nLY.bP(true);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.nLY != null) {
            this.nLY.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }

    public void loadData() {
        if (this.nLY != null) {
            this.nLY.Km();
        }
    }
}
