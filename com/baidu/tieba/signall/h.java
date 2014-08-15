package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class h {
    private static final String b = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private com.baidu.tbadk.core.util.ae a = null;

    public String a(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.a = new com.baidu.tbadk.core.util.ae(b);
        this.a.a(com.baidu.tbadk.core.frameworkData.a.USER_ID, str2);
        this.a.a("forum_ids", str);
        this.a.a().a().b = true;
        this.a.a().a().a = true;
        return this.a.h();
    }

    public void a() {
        if (this.a != null) {
            this.a.f();
        }
    }

    public boolean b() {
        if (this.a != null) {
            return this.a.a().b().b();
        }
        return false;
    }

    public String c() {
        if (this.a != null) {
            return this.a.e();
        }
        return null;
    }
}
