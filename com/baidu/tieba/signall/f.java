package com.baidu.tieba.signall;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public final class f {
    private static final String b = String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/forum/msign";
    private ak a = null;

    public final String a(String str) {
        AccountData N = TbadkApplication.N();
        String str2 = null;
        if (N != null) {
            str2 = N.getID();
        }
        this.a = new ak(b);
        this.a.a("user_id", str2);
        this.a.a("forum_ids", str);
        this.a.a().a().b = true;
        this.a.a().a().a = true;
        return this.a.i();
    }

    public final void a() {
        if (this.a != null) {
            this.a.g();
        }
    }

    public final boolean b() {
        if (this.a != null) {
            return this.a.a().b().b();
        }
        return false;
    }

    public final String c() {
        if (this.a != null) {
            return this.a.f();
        }
        return null;
    }
}
