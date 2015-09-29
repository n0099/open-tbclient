package com.baidu.tieba.setting.model;

import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    private boolean ayA;
    private boolean cDn;

    public b() {
        super(null);
        this.ayA = false;
        this.cDn = false;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        this.ayA = false;
        this.cDn = false;
        return false;
    }

    private PrivateInfoNetMessage arh() {
        return new PrivateInfoNetMessage();
    }

    public boolean ari() {
        if (this.ayA) {
            return false;
        }
        this.ayA = true;
        this.cDn = false;
        sendMessage(arh());
        return true;
    }

    public boolean isLoading() {
        return this.ayA;
    }

    public void setLoading(boolean z) {
        this.ayA = z;
    }

    public boolean isFinished() {
        return this.cDn;
    }

    public void fW(boolean z) {
        this.cDn = z;
    }
}
