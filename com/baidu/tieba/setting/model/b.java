package com.baidu.tieba.setting.model;

import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    private boolean aCX;
    private boolean bTx;

    public b() {
        super(null);
        this.aCX = false;
        this.bTx = false;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        this.aCX = false;
        this.bTx = false;
        return false;
    }

    private PrivateInfoNetMessage aNl() {
        return new PrivateInfoNetMessage();
    }

    public boolean aNm() {
        if (this.aCX) {
            return false;
        }
        this.aCX = true;
        this.bTx = false;
        sendMessage(aNl());
        return true;
    }

    public boolean isLoading() {
        return this.aCX;
    }

    public void setLoading(boolean z) {
        this.aCX = z;
    }

    public boolean isFinished() {
        return this.bTx;
    }

    public void il(boolean z) {
        this.bTx = z;
    }
}
