package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes11.dex */
public class g implements com.baidu.live.liveroom.d.d {
    private String aGB;
    private String beR;
    private boolean boZ;
    private boolean bxC;
    private String mLiveId;
    private YuyinALaAudiencesActivity ojM;
    com.baidu.live.k.c oke = null;

    public g(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.ojM = yuyinALaAudiencesActivity;
    }

    public void createView() {
        com.baidu.live.noble.data.e eVar = new com.baidu.live.noble.data.e();
        eVar.mTbPageContext = this.ojM.getPageContext();
        eVar.mLiveId = this.mLiveId;
        eVar.bvS = this.aGB;
        eVar.mIsHost = this.boZ;
        eVar.bxC = this.bxC;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501013, com.baidu.live.k.c.class, eVar);
        if (runTask != null && runTask.getData() != null) {
            this.oke = (com.baidu.live.k.c) runTask.getData();
        }
    }

    public g VI(String str) {
        this.mLiveId = str;
        return this;
    }

    public g zy(boolean z) {
        this.bxC = z;
        return this;
    }

    public g zz(boolean z) {
        this.boZ = z;
        return this;
    }

    public g VJ(String str) {
        this.aGB = str;
        return this;
    }

    public g VK(String str) {
        this.beR = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.oke == null) {
            return null;
        }
        return this.oke.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.oke == null) {
            return null;
        }
        return this.oke.getTitle();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Mh() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Mi() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
        if (this.oke != null) {
            this.oke.ca(false);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.oke != null) {
            this.oke.ca(true);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.oke != null) {
            this.oke.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }

    public void mH(boolean z) {
        if (this.oke != null) {
            this.oke.cb(z);
        }
    }
}
