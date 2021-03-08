package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes10.dex */
public class g implements com.baidu.live.liveroom.d.d {
    private String aFb;
    private String beK;
    private boolean bpf;
    private boolean bxS;
    private String mLiveId;
    private YuyinALaAudiencesActivity orH;
    com.baidu.live.j.c orZ = null;

    public g(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.orH = yuyinALaAudiencesActivity;
    }

    public void createView() {
        com.baidu.live.noble.data.e eVar = new com.baidu.live.noble.data.e();
        eVar.mTbPageContext = this.orH.getPageContext();
        eVar.mLiveId = this.mLiveId;
        eVar.bwh = this.aFb;
        eVar.mIsHost = this.bpf;
        eVar.bxS = this.bxS;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501013, com.baidu.live.j.c.class, eVar);
        if (runTask != null && runTask.getData() != null) {
            this.orZ = (com.baidu.live.j.c) runTask.getData();
        }
    }

    public g VS(String str) {
        this.mLiveId = str;
        return this;
    }

    public g zO(boolean z) {
        this.bxS = z;
        return this;
    }

    public g zP(boolean z) {
        this.bpf = z;
        return this;
    }

    public g VT(String str) {
        this.aFb = str;
        return this;
    }

    public g VU(String str) {
        this.beK = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.orZ == null) {
            return null;
        }
        return this.orZ.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.orZ == null) {
            return null;
        }
        return this.orZ.getTitle();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JN() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JO() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
        if (this.orZ != null) {
            this.orZ.cb(false);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.orZ != null) {
            this.orZ.cb(true);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.orZ != null) {
            this.orZ.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }

    public void mH(boolean z) {
        if (this.orZ != null) {
            this.orZ.cc(z);
        }
    }
}
