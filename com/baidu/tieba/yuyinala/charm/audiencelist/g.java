package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes10.dex */
public class g implements com.baidu.live.liveroom.d.d {
    private String aBO;
    private String bab;
    private boolean bkm;
    private boolean bsO;
    private String mLiveId;
    com.baidu.live.k.c ofA = null;
    private YuyinALaAudiencesActivity ofi;

    public g(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.ofi = yuyinALaAudiencesActivity;
    }

    public void createView() {
        com.baidu.live.noble.data.e eVar = new com.baidu.live.noble.data.e();
        eVar.mTbPageContext = this.ofi.getPageContext();
        eVar.mLiveId = this.mLiveId;
        eVar.bre = this.aBO;
        eVar.mIsHost = this.bkm;
        eVar.bsO = this.bsO;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501013, com.baidu.live.k.c.class, eVar);
        if (runTask != null && runTask.getData() != null) {
            this.ofA = (com.baidu.live.k.c) runTask.getData();
        }
    }

    public g UB(String str) {
        this.mLiveId = str;
        return this;
    }

    public g zu(boolean z) {
        this.bsO = z;
        return this;
    }

    public g zv(boolean z) {
        this.bkm = z;
        return this;
    }

    public g UC(String str) {
        this.aBO = str;
        return this;
    }

    public g UD(String str) {
        this.bab = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.ofA == null) {
            return null;
        }
        return this.ofA.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.ofA == null) {
            return null;
        }
        return this.ofA.getTitle();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Im() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short In() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
        if (this.ofA != null) {
            this.ofA.bW(false);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.ofA != null) {
            this.ofA.bW(true);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.ofA != null) {
            this.ofA.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }

    public void mD(boolean z) {
        if (this.ofA != null) {
            this.ofA.bX(z);
        }
    }
}
