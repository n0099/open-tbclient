package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes11.dex */
public class g implements com.baidu.live.liveroom.d.d {
    private String aDB;
    private String bdi;
    private boolean bnF;
    private boolean bws;
    private String mLiveId;
    private YuyinALaAudiencesActivity opB;
    com.baidu.live.j.c opT = null;

    public g(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.opB = yuyinALaAudiencesActivity;
    }

    public void createView() {
        com.baidu.live.noble.data.e eVar = new com.baidu.live.noble.data.e();
        eVar.mTbPageContext = this.opB.getPageContext();
        eVar.mLiveId = this.mLiveId;
        eVar.buH = this.aDB;
        eVar.mIsHost = this.bnF;
        eVar.bws = this.bws;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501013, com.baidu.live.j.c.class, eVar);
        if (runTask != null && runTask.getData() != null) {
            this.opT = (com.baidu.live.j.c) runTask.getData();
        }
    }

    public g VL(String str) {
        this.mLiveId = str;
        return this;
    }

    public g zP(boolean z) {
        this.bws = z;
        return this;
    }

    public g zQ(boolean z) {
        this.bnF = z;
        return this;
    }

    public g VM(String str) {
        this.aDB = str;
        return this;
    }

    public g VN(String str) {
        this.bdi = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.opT == null) {
            return null;
        }
        return this.opT.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.opT == null) {
            return null;
        }
        return this.opT.getTitle();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JL() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
        if (this.opT != null) {
            this.opT.cb(false);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.opT != null) {
            this.opT.cb(true);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.opT != null) {
            this.opT.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }

    public void mH(boolean z) {
        if (this.opT != null) {
            this.opT.cc(z);
        }
    }
}
