package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class g implements com.baidu.live.liveroom.d.d {
    private String aFp;
    private String bbs;
    private boolean bkL;
    private boolean bps;
    private String mLiveId;
    private YuyinALaAudiencesActivity nRB;
    com.baidu.live.h.b nRS = null;

    public g(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.nRB = yuyinALaAudiencesActivity;
    }

    public void createView() {
        com.baidu.live.noble.data.d dVar = new com.baidu.live.noble.data.d();
        dVar.mTbPageContext = this.nRB.getPageContext();
        dVar.mLiveId = this.mLiveId;
        dVar.bnP = this.aFp;
        dVar.mIsHost = this.bkL;
        dVar.bps = this.bps;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501013, com.baidu.live.h.b.class, dVar);
        if (runTask != null && runTask.getData() != null) {
            this.nRS = (com.baidu.live.h.b) runTask.getData();
        }
    }

    public g Vj(String str) {
        this.mLiveId = str;
        return this;
    }

    public g yP(boolean z) {
        this.bps = z;
        return this;
    }

    public g yQ(boolean z) {
        this.bkL = z;
        return this;
    }

    public g Vk(String str) {
        this.aFp = str;
        return this;
    }

    public g Vl(String str) {
        this.bbs = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.nRS == null) {
            return null;
        }
        return this.nRS.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.nRS == null) {
            return null;
        }
        return this.nRS.getTitle();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Lr() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ls() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
        if (this.nRS != null) {
            this.nRS.bQ(false);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.nRS != null) {
            this.nRS.bQ(true);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.nRS != null) {
            this.nRS.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }

    public void loadData() {
        if (this.nRS != null) {
            this.nRS.KM();
        }
    }
}
