package com.baidu.tieba.tbadkCore.e;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f {
    private b cav;
    private d caw;
    private f cax;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cav = null;
        this.caw = null;
        this.cax = null;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        aim();
        return false;
    }

    public void aim() {
        if (this.cav != null) {
            this.cav.cancel();
            this.cav = null;
        }
        if (this.caw != null) {
            this.caw.cancel();
            this.caw = null;
        }
        if (this.cax != null) {
            this.cax.cancel();
            this.cax = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.cav != null) {
            this.cav.cancel();
            this.cav = null;
        }
        this.mLoadDataMode = 0;
        this.cav = new b(this, str, str2, str3, str4, i, i2, z);
        this.cav.setPriority(2);
        this.cav.execute(new String[0]);
    }

    public boolean ain() {
        return (this.cav == null && this.caw == null && this.cax == null) ? false : true;
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.cax != null) {
            this.cax.cancel();
            this.cax = null;
        }
        this.mLoadDataMode = i;
        this.cax = new f(this, str, str2, str3, i, str4);
        this.cax.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.cax.execute(str5);
    }
}
