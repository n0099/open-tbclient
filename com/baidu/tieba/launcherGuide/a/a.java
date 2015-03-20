package com.baidu.tieba.launcherGuide.a;

import com.baidu.adp.base.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
/* loaded from: classes.dex */
public class a extends f<BaseFragmentActivity> {
    private static final String bxi = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/gettaglist";
    private boolean bxj;
    private InterestFrsData bxk;
    private b bxl;

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
    }

    public boolean Wg() {
        return this.bxj;
    }

    public void dr(boolean z) {
        this.bxj = z;
    }

    public InterestFrsData Wh() {
        return this.bxk;
    }

    public void e(InterestFrsData interestFrsData) {
        this.bxk = interestFrsData;
    }

    public void a(int i, int i2, int i3, c cVar) {
        this.bxl = new b(i, i2, i3, cVar);
        this.bxl.execute(new Void[0]);
    }

    public void Wi() {
        if (this.bxl != null) {
            this.bxl.cancel();
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
