package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ be f1382a;
    private com.baidu.tieba.a.h b = null;
    private int c;

    public bf(be beVar, int i) {
        this.f1382a = beVar;
        this.c = 0;
        this.c = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.bd a(Object... objArr) {
        com.baidu.tieba.data.bd bdVar;
        com.baidu.tieba.data.bd bdVar2;
        com.baidu.tieba.data.bd bdVar3;
        String str;
        String str2;
        String str3;
        Context context;
        Context context2;
        this.b = new com.baidu.tieba.a.h();
        try {
            bdVar = this.f1382a.e;
            int f = bdVar.f();
            if (f == 0) {
                f++;
            } else if (this.c == 0) {
                f++;
            } else if (this.c == 2) {
                bdVar2 = this.f1382a.e;
                int size = bdVar2.b().size();
                bdVar3 = this.f1382a.e;
                if (size % bdVar3.e() == 0) {
                    f++;
                }
            }
            com.baidu.tieba.a.h hVar = this.b;
            str = this.f1382a.f1381a;
            str2 = this.f1382a.c;
            int i = this.c;
            str3 = this.f1382a.b;
            String a2 = hVar.a(str, str2, i, str3, f);
            if (!this.b.a()) {
                return null;
            }
            com.baidu.tieba.data.bd bdVar4 = new com.baidu.tieba.data.bd();
            context = this.f1382a.d;
            bdVar4.a(a2, context);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= bdVar4.b().size()) {
                    return bdVar4;
                }
                context2 = this.f1382a.d;
                ((com.baidu.tieba.data.as) bdVar4.b().get(i3)).a(context2);
                i2 = i3 + 1;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "doInBackground", e.toString());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.f1382a.f = null;
        if (this.b != null) {
            this.b.d();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.bd bdVar) {
        com.baidu.tieba.data.bd bdVar2;
        com.baidu.tieba.data.bd bdVar3;
        bg bgVar;
        bg bgVar2;
        com.baidu.tieba.data.bd bdVar4;
        bg bgVar3;
        bg bgVar4;
        this.f1382a.f = null;
        if (bdVar == null) {
            bgVar3 = this.f1382a.g;
            if (bgVar3 != null) {
                bgVar4 = this.f1382a.g;
                bgVar4.a(false, this.b.c(), this.b.b(), null);
                return;
            }
            return;
        }
        if (bdVar.a() != null) {
            this.f1382a.b = bdVar.a().d();
        }
        if (bdVar.l() != null) {
            this.f1382a.f1381a = bdVar.l().a();
        }
        if (this.c == 1) {
            this.f1382a.e = bdVar;
        } else if (this.c == 2) {
            bdVar3 = this.f1382a.e;
            bdVar3.a(bdVar, true);
        } else {
            bdVar2 = this.f1382a.e;
            bdVar2.a(bdVar, false);
        }
        bgVar = this.f1382a.g;
        if (bgVar != null) {
            bgVar2 = this.f1382a.g;
            int c = this.b.c();
            String b = this.b.b();
            bdVar4 = this.f1382a.e;
            bgVar2.a(true, c, b, bdVar4);
        }
        this.b = null;
    }
}
