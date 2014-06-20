package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class f {
    private static final String b = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private an a = null;

    public String a(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.a = new an(b);
        this.a.a(com.baidu.tbadk.core.frameworkData.a.USER_ID, str2);
        this.a.a("forum_ids", str);
        this.a.a().a().b = true;
        this.a.a().a().a = true;
        return this.a.i();
    }

    public void a() {
        if (this.a != null) {
            this.a.g();
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
            return this.a.f();
        }
        return null;
    }
}
