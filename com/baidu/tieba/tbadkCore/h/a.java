package com.baidu.tieba.tbadkCore.h;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f {
    private b ctO;
    private d ctP;
    private f ctQ;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.ctO = null;
        this.ctP = null;
        this.ctQ = null;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        apr();
        return false;
    }

    public void apr() {
        if (this.ctO != null) {
            this.ctO.cancel();
            this.ctO = null;
        }
        if (this.ctP != null) {
            this.ctP.cancel();
            this.ctP = null;
        }
        if (this.ctQ != null) {
            this.ctQ.cancel();
            this.ctQ = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.ctO != null) {
            this.ctO.cancel();
            this.ctO = null;
        }
        this.mLoadDataMode = 0;
        this.ctO = new b(this, str, str2, str3, str4, i, i2, z);
        this.ctO.setPriority(2);
        this.ctO.execute(new String[0]);
    }

    public boolean aps() {
        return (this.ctO == null && this.ctP == null && this.ctQ == null) ? false : true;
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.ctQ != null) {
            this.ctQ.cancel();
            this.ctQ = null;
        }
        this.mLoadDataMode = i;
        this.ctQ = new f(this, str, str2, str3, i, str4);
        this.ctQ.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.ctQ.execute(str5);
    }
}
