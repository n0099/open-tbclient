package com.baidu.tieba.model;

import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.data.InterestFrsData;
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.base.d {
    private static final String a = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/gettaglist";
    private boolean b;
    private InterestFrsData c;
    private ap d;

    public boolean a() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public InterestFrsData b() {
        return this.c;
    }

    public void a(InterestFrsData interestFrsData) {
        this.c = interestFrsData;
    }

    public void a(int i, int i2, int i3, aq aqVar) {
        this.d = new ap(i, i2, i3, aqVar);
        this.d.execute(new Void[0]);
    }

    public void c() {
        if (this.d != null) {
            this.d.cancel();
        }
    }

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.d
    public boolean cancelLoadData() {
        return false;
    }
}
