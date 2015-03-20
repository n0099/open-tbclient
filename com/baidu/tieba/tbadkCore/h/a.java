package com.baidu.tieba.tbadkCore.h;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f {
    private b cpx;
    private d cpy;
    private f cpz;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cpx = null;
        this.cpy = null;
        this.cpz = null;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        anl();
        return false;
    }

    public void anl() {
        if (this.cpx != null) {
            this.cpx.cancel();
            this.cpx = null;
        }
        if (this.cpy != null) {
            this.cpy.cancel();
            this.cpy = null;
        }
        if (this.cpz != null) {
            this.cpz.cancel();
            this.cpz = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.cpx != null) {
            this.cpx.cancel();
            this.cpx = null;
        }
        this.mLoadDataMode = 0;
        this.cpx = new b(this, str, str2, str3, str4, i, i2, z);
        this.cpx.setPriority(2);
        this.cpx.execute(new String[0]);
    }

    public boolean anm() {
        return (this.cpx == null && this.cpy == null && this.cpz == null) ? false : true;
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.cpz != null) {
            this.cpz.cancel();
            this.cpz = null;
        }
        this.mLoadDataMode = i;
        this.cpz = new f(this, str, str2, str3, i, str4);
        this.cpz.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.cpz.execute(str5);
    }
}
