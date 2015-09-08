package com.baidu.tieba.setting.model;

import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    private boolean aAa;
    private boolean cwF;

    public b() {
        super(null);
        this.aAa = false;
        this.cwF = false;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        this.aAa = false;
        this.cwF = false;
        return false;
    }

    private PrivateInfoNetMessage aoP() {
        return new PrivateInfoNetMessage();
    }

    public boolean aoQ() {
        if (this.aAa) {
            return false;
        }
        this.aAa = true;
        this.cwF = false;
        sendMessage(aoP());
        return true;
    }

    public boolean isLoading() {
        return this.aAa;
    }

    public void setLoading(boolean z) {
        this.aAa = z;
    }

    public boolean isFinished() {
        return this.cwF;
    }

    public void fL(boolean z) {
        this.cwF = z;
    }
}
