package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.data.InterestFrsData;
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.base.e {
    private static final String bpD = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/gettaglist";
    private boolean bpE;
    private InterestFrsData bpF;
    private ap bpG;

    public ao(Context context) {
        super(context);
    }

    public boolean TR() {
        return this.bpE;
    }

    public void dH(boolean z) {
        this.bpE = z;
    }

    public InterestFrsData TS() {
        return this.bpF;
    }

    public void e(InterestFrsData interestFrsData) {
        this.bpF = interestFrsData;
    }

    public void a(int i, int i2, int i3, aq aqVar) {
        this.bpG = new ap(i, i2, i3, aqVar);
        this.bpG.execute(new Void[0]);
    }

    public void TT() {
        if (this.bpG != null) {
            this.bpG.cancel();
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
