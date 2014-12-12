package com.baidu.tieba.model;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.data.InterestFrsData;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.f<BaseFragmentActivity> {
    private static final String btk = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/gettaglist";
    private boolean btl;
    private InterestFrsData btm;
    private p bto;

    public o(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
    }

    public boolean Uo() {
        return this.btl;
    }

    public void dt(boolean z) {
        this.btl = z;
    }

    public InterestFrsData Up() {
        return this.btm;
    }

    public void e(InterestFrsData interestFrsData) {
        this.btm = interestFrsData;
    }

    public void a(int i, int i2, int i3, q qVar) {
        this.bto = new p(i, i2, i3, qVar);
        this.bto.execute(new Void[0]);
    }

    public void Uq() {
        if (this.bto != null) {
            this.bto.cancel();
        }
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }
}
