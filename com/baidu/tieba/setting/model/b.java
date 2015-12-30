package com.baidu.tieba.setting.model;

import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    private boolean aBk;
    private boolean bFR;

    public b() {
        super(null);
        this.aBk = false;
        this.bFR = false;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        this.aBk = false;
        this.bFR = false;
        return false;
    }

    private PrivateInfoNetMessage azu() {
        return new PrivateInfoNetMessage();
    }

    public boolean azv() {
        if (this.aBk) {
            return false;
        }
        this.aBk = true;
        this.bFR = false;
        sendMessage(azu());
        return true;
    }

    public boolean isLoading() {
        return this.aBk;
    }

    public void setLoading(boolean z) {
        this.aBk = z;
    }

    public boolean isFinished() {
        return this.bFR;
    }

    public void gX(boolean z) {
        this.bFR = z;
    }
}
