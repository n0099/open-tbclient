package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.data.InterestFrsData;
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.base.e {
    private static final String bpp = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/gettaglist";
    private boolean bpq;
    private InterestFrsData bpr;
    private ap bps;

    public ao(Context context) {
        super(context);
    }

    public boolean TO() {
        return this.bpq;
    }

    public void dH(boolean z) {
        this.bpq = z;
    }

    public InterestFrsData TP() {
        return this.bpr;
    }

    public void e(InterestFrsData interestFrsData) {
        this.bpr = interestFrsData;
    }

    public void a(int i, int i2, int i3, aq aqVar) {
        this.bps = new ap(i, i2, i3, aqVar);
        this.bps.execute(new Void[0]);
    }

    public void TQ() {
        if (this.bps != null) {
            this.bps.cancel();
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
