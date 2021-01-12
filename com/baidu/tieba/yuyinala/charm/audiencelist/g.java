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
    private YuyinALaAudiencesActivity ofh;
    com.baidu.live.k.c ofz = null;

    public g(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.ofh = yuyinALaAudiencesActivity;
    }

    public void createView() {
        com.baidu.live.noble.data.e eVar = new com.baidu.live.noble.data.e();
        eVar.mTbPageContext = this.ofh.getPageContext();
        eVar.mLiveId = this.mLiveId;
        eVar.bre = this.aBO;
        eVar.mIsHost = this.bkm;
        eVar.bsO = this.bsO;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501013, com.baidu.live.k.c.class, eVar);
        if (runTask != null && runTask.getData() != null) {
            this.ofz = (com.baidu.live.k.c) runTask.getData();
        }
    }

    public g UA(String str) {
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

    public g UB(String str) {
        this.aBO = str;
        return this;
    }

    public g UC(String str) {
        this.bab = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.ofz == null) {
            return null;
        }
        return this.ofz.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.ofz == null) {
            return null;
        }
        return this.ofz.getTitle();
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
        if (this.ofz != null) {
            this.ofz.bW(false);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.ofz != null) {
            this.ofz.bW(true);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.ofz != null) {
            this.ofz.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }

    public void mD(boolean z) {
        if (this.ofz != null) {
            this.ofz.bX(z);
        }
    }
}
