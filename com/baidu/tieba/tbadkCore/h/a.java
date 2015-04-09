package com.baidu.tieba.tbadkCore.h;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f {
    private b cpN;
    private d cpO;
    private f cpP;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cpN = null;
        this.cpO = null;
        this.cpP = null;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        anA();
        return false;
    }

    public void anA() {
        if (this.cpN != null) {
            this.cpN.cancel();
            this.cpN = null;
        }
        if (this.cpO != null) {
            this.cpO.cancel();
            this.cpO = null;
        }
        if (this.cpP != null) {
            this.cpP.cancel();
            this.cpP = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.cpN != null) {
            this.cpN.cancel();
            this.cpN = null;
        }
        this.mLoadDataMode = 0;
        this.cpN = new b(this, str, str2, str3, str4, i, i2, z);
        this.cpN.setPriority(2);
        this.cpN.execute(new String[0]);
    }

    public boolean anB() {
        return (this.cpN == null && this.cpO == null && this.cpP == null) ? false : true;
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.cpP != null) {
            this.cpP.cancel();
            this.cpP = null;
        }
        this.mLoadDataMode = i;
        this.cpP = new f(this, str, str2, str3, i, str4);
        this.cpP.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.cpP.execute(str5);
    }
}
