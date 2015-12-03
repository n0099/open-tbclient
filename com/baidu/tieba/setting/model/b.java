package com.baidu.tieba.setting.model;

import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    private boolean azE;
    private boolean ddD;

    public b() {
        super(null);
        this.azE = false;
        this.ddD = false;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        this.azE = false;
        this.ddD = false;
        return false;
    }

    private PrivateInfoNetMessage axn() {
        return new PrivateInfoNetMessage();
    }

    public boolean axo() {
        if (this.azE) {
            return false;
        }
        this.azE = true;
        this.ddD = false;
        sendMessage(axn());
        return true;
    }

    public boolean isLoading() {
        return this.azE;
    }

    public void setLoading(boolean z) {
        this.azE = z;
    }

    public boolean isFinished() {
        return this.ddD;
    }

    public void gP(boolean z) {
        this.ddD = z;
    }
}
