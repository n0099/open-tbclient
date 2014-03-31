package com.baidu.tieba.signall;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public final class c extends com.baidu.adp.a.e {
    private static final String d = String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/forum/getforumlist";
    private a a;
    private HttpMessage c;
    private e b = null;
    private com.baidu.adp.framework.c.b e = new d(this, 1003001);

    public c() {
        this.a = null;
        com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
        this.a = new a();
        com.baidu.tbadk.c.b bVar = new com.baidu.tbadk.c.b(1003001, d);
        bVar.d(true);
        bVar.a(GetForumResponsed.class);
        a.a(bVar);
        a.a(this.e);
    }

    public final void a(e eVar) {
        this.b = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.e
    public final boolean LoadData() {
        if (this.c != null) {
            return false;
        }
        this.c = new HttpMessage(1003001);
        AccountData N = TbadkApplication.N();
        String str = null;
        if (N != null) {
            str = N.getID();
        }
        this.c.a("user_id", str);
        this.c.b(1003001);
        com.baidu.adp.framework.c.a().a(this.c);
        return true;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        if (this.c != null) {
            com.baidu.adp.framework.c.a().b(1003001);
            this.c = null;
        }
        com.baidu.adp.framework.c.a().b(this.e);
        com.baidu.adp.framework.c.a().e(1003001);
        return true;
    }
}
