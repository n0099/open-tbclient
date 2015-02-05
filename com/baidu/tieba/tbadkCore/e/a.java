package com.baidu.tieba.tbadkCore.e;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f {
    private b cau;
    private d cav;
    private f caw;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cau = null;
        this.cav = null;
        this.caw = null;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        aih();
        return false;
    }

    public void aih() {
        if (this.cau != null) {
            this.cau.cancel();
            this.cau = null;
        }
        if (this.cav != null) {
            this.cav.cancel();
            this.cav = null;
        }
        if (this.caw != null) {
            this.caw.cancel();
            this.caw = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.cau != null) {
            this.cau.cancel();
            this.cau = null;
        }
        this.mLoadDataMode = 0;
        this.cau = new b(this, str, str2, str3, str4, i, i2, z);
        this.cau.setPriority(2);
        this.cau.execute(new String[0]);
    }

    public boolean aii() {
        return (this.cau == null && this.cav == null && this.caw == null) ? false : true;
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.caw != null) {
            this.caw.cancel();
            this.caw = null;
        }
        this.mLoadDataMode = i;
        this.caw = new f(this, str, str2, str3, i, str4);
        this.caw.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.caw.execute(str5);
    }
}
