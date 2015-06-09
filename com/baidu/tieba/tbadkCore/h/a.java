package com.baidu.tieba.tbadkCore.h;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f {
    private b ctP;
    private d ctQ;
    private f ctR;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.ctP = null;
        this.ctQ = null;
        this.ctR = null;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        aps();
        return false;
    }

    public void aps() {
        if (this.ctP != null) {
            this.ctP.cancel();
            this.ctP = null;
        }
        if (this.ctQ != null) {
            this.ctQ.cancel();
            this.ctQ = null;
        }
        if (this.ctR != null) {
            this.ctR.cancel();
            this.ctR = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.ctP != null) {
            this.ctP.cancel();
            this.ctP = null;
        }
        this.mLoadDataMode = 0;
        this.ctP = new b(this, str, str2, str3, str4, i, i2, z);
        this.ctP.setPriority(2);
        this.ctP.execute(new String[0]);
    }

    public boolean apt() {
        return (this.ctP == null && this.ctQ == null && this.ctR == null) ? false : true;
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.ctR != null) {
            this.ctR.cancel();
            this.ctR = null;
        }
        this.mLoadDataMode = i;
        this.ctR = new f(this, str, str2, str3, i, str4);
        this.ctR.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.ctR.execute(str5);
    }
}
