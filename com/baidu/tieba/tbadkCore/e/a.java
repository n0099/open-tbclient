package com.baidu.tieba.tbadkCore.e;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f {
    private b bYC;
    private d bYD;
    private f bYE;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bYC = null;
        this.bYD = null;
        this.bYE = null;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        ahI();
        return false;
    }

    public void ahI() {
        if (this.bYC != null) {
            this.bYC.cancel();
            this.bYC = null;
        }
        if (this.bYD != null) {
            this.bYD.cancel();
            this.bYD = null;
        }
        if (this.bYE != null) {
            this.bYE.cancel();
            this.bYE = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.bYC != null) {
            this.bYC.cancel();
            this.bYC = null;
        }
        this.mLoadDataMode = 0;
        this.bYC = new b(this, str, str2, str3, str4, i, i2, z);
        this.bYC.setPriority(2);
        this.bYC.execute(new String[0]);
    }

    public boolean ahJ() {
        return (this.bYC == null && this.bYD == null && this.bYE == null) ? false : true;
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.bYE != null) {
            this.bYE.cancel();
            this.bYE = null;
        }
        this.mLoadDataMode = i;
        this.bYE = new f(this, str, str2, str3, i, str4);
        this.bYE.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.bYE.execute(str5);
    }
}
