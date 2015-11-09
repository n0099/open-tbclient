package com.baidu.tieba.setting.model;

import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    private boolean axA;
    private boolean cEU;

    public b() {
        super(null);
        this.axA = false;
        this.cEU = false;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        this.axA = false;
        this.cEU = false;
        return false;
    }

    private PrivateInfoNetMessage arP() {
        return new PrivateInfoNetMessage();
    }

    public boolean arQ() {
        if (this.axA) {
            return false;
        }
        this.axA = true;
        this.cEU = false;
        sendMessage(arP());
        return true;
    }

    public boolean isLoading() {
        return this.axA;
    }

    public void setLoading(boolean z) {
        this.axA = z;
    }

    public boolean isFinished() {
        return this.cEU;
    }

    public void fZ(boolean z) {
        this.cEU = z;
    }
}
