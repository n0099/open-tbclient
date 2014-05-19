package com.baidu.tieba.model;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.d {
    private w a = null;
    private y b = null;
    private aa c = null;

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.d
    public boolean cancelLoadData() {
        a();
        return false;
    }

    public void a() {
        if (this.a != null) {
            this.a.cancel();
            this.a = null;
        }
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
        }
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.a != null) {
            this.a.cancel();
            this.a = null;
        }
        this.mLoadDataMode = 0;
        this.a = new w(this, str, str2, str3, str4, i, i2, z);
        this.a.setPriority(2);
        this.a.execute(new String[0]);
    }

    public boolean b() {
        return (this.a == null && this.b == null && this.c == null) ? false : true;
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
        this.mLoadDataMode = i;
        this.c = new aa(this, str, str2, str3, i, str4);
        this.c.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + "c/c/bawu/goodlist";
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + "c/c/bawu/commitgood";
        } else {
            str5 = String.valueOf(str6) + "c/c/bawu/committop";
        }
        this.c.execute(str5);
    }
}
