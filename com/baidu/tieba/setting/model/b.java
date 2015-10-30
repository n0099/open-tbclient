package com.baidu.tieba.setting.model;

import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    private boolean ayL;
    private boolean cDy;

    public b() {
        super(null);
        this.ayL = false;
        this.cDy = false;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        this.ayL = false;
        this.cDy = false;
        return false;
    }

    private PrivateInfoNetMessage arj() {
        return new PrivateInfoNetMessage();
    }

    public boolean ark() {
        if (this.ayL) {
            return false;
        }
        this.ayL = true;
        this.cDy = false;
        sendMessage(arj());
        return true;
    }

    public boolean isLoading() {
        return this.ayL;
    }

    public void setLoading(boolean z) {
        this.ayL = z;
    }

    public boolean isFinished() {
        return this.cDy;
    }

    public void fW(boolean z) {
        this.cDy = z;
    }
}
