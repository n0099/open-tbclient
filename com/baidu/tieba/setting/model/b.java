package com.baidu.tieba.setting.model;

import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    private boolean ays;
    private boolean coi;

    public b() {
        super(null);
        this.ays = false;
        this.coi = false;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        this.ays = false;
        this.coi = false;
        return false;
    }

    private PrivateInfoNetMessage akI() {
        return new PrivateInfoNetMessage();
    }

    public boolean akJ() {
        if (this.ays) {
            return false;
        }
        this.ays = true;
        this.coi = false;
        sendMessage(akI());
        return true;
    }

    public boolean isLoading() {
        return this.ays;
    }

    public void setLoading(boolean z) {
        this.ays = z;
    }

    public boolean isFinished() {
        return this.coi;
    }

    public void fa(boolean z) {
        this.coi = z;
    }
}
