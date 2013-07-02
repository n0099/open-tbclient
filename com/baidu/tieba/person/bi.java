package com.baidu.tieba.person;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi extends BdAsyncTask {
    final /* synthetic */ PersonLbsActivity a;
    private int b;
    private int c;
    private com.baidu.tieba.util.r d = null;

    public bi(PersonLbsActivity personLbsActivity, int i, int i2) {
        this.a = personLbsActivity;
        this.b = 0;
        this.c = 0;
        this.b = i < 1 ? 1 : i;
        this.c = i2;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.a.o = null;
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        bj bjVar;
        com.baidu.tieba.model.bl blVar;
        int i;
        com.baidu.tieba.model.bl blVar2;
        com.baidu.tieba.model.bl blVar3;
        com.baidu.tieba.model.bl blVar4;
        bj bjVar2;
        bj bjVar3;
        com.baidu.tieba.model.bl blVar5;
        com.baidu.tieba.model.bl blVar6;
        com.baidu.tieba.model.bl blVar7;
        int i2;
        com.baidu.tieba.model.bl blVar8;
        TextView textView;
        ProgressBar progressBar;
        super.b();
        if (this.c == 0) {
            textView = this.a.d;
            textView.setVisibility(8);
            progressBar = this.a.g;
            progressBar.setVisibility(0);
            return;
        }
        if (this.c == 2) {
            bjVar3 = this.a.n;
            bjVar3.a(true);
            blVar5 = this.a.p;
            if (blVar5 != null) {
                blVar6 = this.a.p;
                int size = blVar6.a().size();
                if (size > 200) {
                    for (int i3 = 0; i3 < 20 && i3 < size; i3++) {
                        blVar8 = this.a.p;
                        blVar8.a().remove(0);
                    }
                    blVar7 = this.a.p;
                    blVar7.b().f(1);
                    PersonLbsActivity personLbsActivity = this.a;
                    i2 = personLbsActivity.r;
                    personLbsActivity.r = i2 + 1;
                }
            }
        } else {
            bjVar = this.a.n;
            bjVar.b(true);
            blVar = this.a.p;
            if (blVar != null) {
                blVar2 = this.a.p;
                int size2 = blVar2.a().size();
                if (size2 > 200) {
                    for (int i4 = 0; i4 < 20 && i4 < size2; i4++) {
                        blVar4 = this.a.p;
                        blVar4.a().remove((size2 - i4) - 1);
                    }
                }
                blVar3 = this.a.p;
                blVar3.b().e(1);
            }
            PersonLbsActivity personLbsActivity2 = this.a;
            i = personLbsActivity2.s;
            personLbsActivity2.s = i - 1;
        }
        bjVar2 = this.a.n;
        bjVar2.notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.bl blVar) {
        bj bjVar;
        com.baidu.tieba.model.bl blVar2;
        bj bjVar2;
        com.baidu.tieba.model.bl blVar3;
        TextView textView;
        com.baidu.tieba.model.bl blVar4;
        com.baidu.tieba.model.bl blVar5;
        com.baidu.tieba.model.bl blVar6;
        com.baidu.tieba.model.bl blVar7;
        bj bjVar3;
        com.baidu.tieba.model.bl blVar8;
        bj bjVar4;
        com.baidu.tieba.model.bl blVar9;
        com.baidu.tieba.model.bl blVar10;
        super.a((Object) blVar);
        this.a.o = null;
        f();
        if (blVar == null) {
            if (this.d != null) {
                this.a.a(this.d.g());
                return;
            }
            return;
        }
        if (this.c != 0) {
            blVar5 = this.a.p;
            if (blVar5 != null) {
                if (this.c == 1) {
                    ArrayList a = blVar.a();
                    blVar9 = this.a.p;
                    blVar9.a().addAll(0, a);
                    blVar10 = this.a.p;
                    blVar10.b().f(blVar.b().g());
                    this.a.r = this.b;
                } else {
                    ArrayList a2 = blVar.a();
                    blVar6 = this.a.p;
                    blVar6.a().addAll(a2);
                    blVar7 = this.a.p;
                    blVar7.b().e(blVar.b().f());
                    this.a.s = this.b;
                }
                bjVar3 = this.a.n;
                blVar8 = this.a.p;
                bjVar3.a(blVar8);
                bjVar4 = this.a.n;
                bjVar4.notifyDataSetChanged();
                return;
            }
        }
        this.a.p = blVar;
        bjVar = this.a.n;
        blVar2 = this.a.p;
        bjVar.a(blVar2);
        bjVar2 = this.a.n;
        bjVar2.notifyDataSetInvalidated();
        PersonLbsActivity personLbsActivity = this.a;
        PersonLbsActivity personLbsActivity2 = this.a;
        int i = this.b;
        personLbsActivity2.s = i;
        personLbsActivity.r = i;
        blVar3 = this.a.p;
        if (blVar3 != null) {
            blVar4 = this.a.p;
            if (blVar4.a().size() != 0) {
                return;
            }
        }
        textView = this.a.d;
        textView.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.model.bl a(String... strArr) {
        String str;
        this.d = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/u/feed/ssf");
        com.baidu.tieba.util.r rVar = this.d;
        str = this.a.l;
        rVar.a("uid", str);
        this.d.a("rn", String.valueOf(20));
        this.d.a("pn", String.valueOf(this.b));
        String j = this.d.j();
        if (this.d.c()) {
            com.baidu.tieba.model.bl blVar = new com.baidu.tieba.model.bl();
            blVar.parserJson(j);
            int size = blVar.a().size();
            for (int i = 0; i < size; i++) {
                ((com.baidu.tieba.data.al) blVar.a().get(i)).e().b(this.a);
                ((com.baidu.tieba.data.al) blVar.a().get(i)).e().a((ArrayList) null);
            }
            return blVar;
        }
        return null;
    }

    private void f() {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        ProgressBar progressBar;
        if (this.c == 0) {
            progressBar = this.a.g;
            progressBar.setVisibility(8);
            return;
        }
        if (this.c == 2) {
            bjVar3 = this.a.n;
            bjVar3.a(false);
        } else {
            bjVar = this.a.n;
            bjVar.b(false);
        }
        bjVar2 = this.a.n;
        bjVar2.notifyDataSetChanged();
    }

    public int e() {
        return this.c;
    }
}
