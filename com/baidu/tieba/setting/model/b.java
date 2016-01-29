package com.baidu.tieba.setting.model;

import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    private boolean aBZ;
    private boolean bJb;

    public b() {
        super(null);
        this.aBZ = false;
        this.bJb = false;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        this.aBZ = false;
        this.bJb = false;
        return false;
    }

    private PrivateInfoNetMessage aGB() {
        return new PrivateInfoNetMessage();
    }

    public boolean aGC() {
        if (this.aBZ) {
            return false;
        }
        this.aBZ = true;
        this.bJb = false;
        sendMessage(aGB());
        return true;
    }

    public boolean isLoading() {
        return this.aBZ;
    }

    public void setLoading(boolean z) {
        this.aBZ = z;
    }

    public boolean isFinished() {
        return this.bJb;
    }

    public void hx(boolean z) {
        this.bJb = z;
    }
}
