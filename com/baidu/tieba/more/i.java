package com.baidu.tieba.more;

import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.a.a {
    final /* synthetic */ AccountActivity a;
    private com.baidu.tieba.a.a b;
    private int c = 0;

    public i(AccountActivity accountActivity, com.baidu.tieba.a.a aVar) {
        this.a = accountActivity;
        this.b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        this.a.a(this.a.getString(R.string.deleting), new j(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public com.baidu.tieba.a.a a(Object... objArr) {
        ArrayList arrayList;
        ArrayList arrayList2;
        try {
            Thread.sleep(1000L);
            com.baidu.tieba.d.k.o(this.b.a());
            if (this.b.a().equals(TiebaApplication.B())) {
                TiebaApplication.b((com.baidu.tieba.a.a) null);
                arrayList = this.a.c;
                if (arrayList.size() >= 2) {
                    this.c = 1;
                    arrayList2 = this.a.c;
                    com.baidu.tieba.a.a aVar = (com.baidu.tieba.a.a) arrayList2.get(1);
                    aVar.a(1);
                    com.baidu.tieba.d.k.a(aVar);
                    return aVar;
                }
                com.baidu.tieba.account.a.a().a(this.b.d());
                this.c = 2;
            } else {
                this.c = 0;
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.a aVar) {
        ArrayList arrayList;
        n nVar;
        if (this.b != null) {
            new k(this.a, this.b.d()).start();
        }
        this.a.h();
        switch (this.c) {
            case 0:
                this.a.a(this.a.getString(R.string.success));
                arrayList = this.a.c;
                arrayList.remove(this.b);
                this.b = null;
                nVar = this.a.d;
                nVar.notifyDataSetChanged();
                break;
            case 1:
                TiebaApplication.b(aVar);
                com.baidu.tieba.account.a.a().b();
                MainTabActivity.b(this.a, "goto_home");
                break;
            case 2:
                MainTabActivity.b(this.a, "goto_person");
                break;
        }
        this.a.l = null;
    }
}
