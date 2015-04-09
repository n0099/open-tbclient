package com.baidu.tieba.launcherGuide.a;

import com.baidu.adp.base.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
/* loaded from: classes.dex */
public class a extends f<BaseFragmentActivity> {
    private static final String bxy = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/gettaglist";
    private InterestFrsData bxA;
    private b bxB;
    private boolean bxz;

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
    }

    public boolean Wt() {
        return this.bxz;
    }

    public void dp(boolean z) {
        this.bxz = z;
    }

    public InterestFrsData Wu() {
        return this.bxA;
    }

    public void e(InterestFrsData interestFrsData) {
        this.bxA = interestFrsData;
    }

    public void a(int i, int i2, int i3, c cVar) {
        this.bxB = new b(i, i2, i3, cVar);
        this.bxB.execute(new Void[0]);
    }

    public void Wv() {
        if (this.bxB != null) {
            this.bxB.cancel();
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
