package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class g implements com.baidu.live.liveroom.d.d {
    private String aGk;
    private String bdg;
    private boolean bns;
    private boolean bsP;
    private String mLiveId;
    private YuyinALaAudiencesActivity oie;
    com.baidu.live.j.c oiv = null;

    public g(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.oie = yuyinALaAudiencesActivity;
    }

    public void createView() {
        com.baidu.live.noble.data.d dVar = new com.baidu.live.noble.data.d();
        dVar.mTbPageContext = this.oie.getPageContext();
        dVar.mLiveId = this.mLiveId;
        dVar.brl = this.aGk;
        dVar.mIsHost = this.bns;
        dVar.bsP = this.bsP;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501013, com.baidu.live.j.c.class, dVar);
        if (runTask != null && runTask.getData() != null) {
            this.oiv = (com.baidu.live.j.c) runTask.getData();
        }
    }

    public g Wj(String str) {
        this.mLiveId = str;
        return this;
    }

    public g zA(boolean z) {
        this.bsP = z;
        return this;
    }

    public g zB(boolean z) {
        this.bns = z;
        return this;
    }

    public g Wk(String str) {
        this.aGk = str;
        return this;
    }

    public g Wl(String str) {
        this.bdg = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.oiv == null) {
            return null;
        }
        return this.oiv.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.oiv == null) {
            return null;
        }
        return this.oiv.getTitle();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String MK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short ML() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
        if (this.oiv != null) {
            this.oiv.cb(false);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.oiv != null) {
            this.oiv.cb(true);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.oiv != null) {
            this.oiv.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }

    public void loadData() {
        if (this.oiv != null) {
            this.oiv.Mf();
        }
    }
}
