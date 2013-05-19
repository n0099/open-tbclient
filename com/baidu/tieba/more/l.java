package com.baidu.tieba.more;

import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends com.baidu.adp.lib.a.a {
    final /* synthetic */ AccountActivity a;
    private com.baidu.tieba.a.a b;

    public l(AccountActivity accountActivity, com.baidu.tieba.a.a aVar) {
        this.a = accountActivity;
        this.b = null;
        this.b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        this.a.a(this.a.getString(R.string.account_logining), new m(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        try {
            Thread.sleep(1000L);
            this.b.a(1);
            com.baidu.tieba.d.k.a(this.b);
            TiebaApplication.b(this.b);
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Boolean bool) {
        this.a.h();
        MainTabActivity.b(this.a, "goto_home");
        com.baidu.tieba.account.a.a().b();
        this.a.k = null;
    }
}
