package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class g implements com.baidu.live.liveroom.d.d {
    private String aDE;
    private String aZG;
    private boolean bja;
    private boolean bnH;
    private String mLiveId;
    private YuyinALaAudiencesActivity nTe;
    com.baidu.live.h.b nTv = null;

    public g(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.nTe = yuyinALaAudiencesActivity;
    }

    public void createView() {
        com.baidu.live.noble.data.d dVar = new com.baidu.live.noble.data.d();
        dVar.mTbPageContext = this.nTe.getPageContext();
        dVar.mLiveId = this.mLiveId;
        dVar.bme = this.aDE;
        dVar.mIsHost = this.bja;
        dVar.bnH = this.bnH;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501013, com.baidu.live.h.b.class, dVar);
        if (runTask != null && runTask.getData() != null) {
            this.nTv = (com.baidu.live.h.b) runTask.getData();
        }
    }

    public g UU(String str) {
        this.mLiveId = str;
        return this;
    }

    public g yW(boolean z) {
        this.bnH = z;
        return this;
    }

    public g yX(boolean z) {
        this.bja = z;
        return this;
    }

    public g UV(String str) {
        this.aDE = str;
        return this;
    }

    public g UW(String str) {
        this.aZG = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.nTv == null) {
            return null;
        }
        return this.nTv.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.nTv == null) {
            return null;
        }
        return this.nTv.getTitle();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KI() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KJ() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
        if (this.nTv != null) {
            this.nTv.bS(false);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.nTv != null) {
            this.nTv.bS(true);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.nTv != null) {
            this.nTv.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }

    public void loadData() {
        if (this.nTv != null) {
            this.nTv.Kd();
        }
    }
}
