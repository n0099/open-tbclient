package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.model.bj;
import com.baidu.tieba.util.an;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.util.be;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<Object, Integer, bj> {
    final /* synthetic */ j a;
    private String c;
    private ArrayList<BasicNameValuePair> d;
    private f e;
    private an b = null;
    private bj f = null;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(Integer... numArr) {
        super.b((Object[]) numArr);
        if (this.f != null) {
            this.a.a(this.f, true);
        }
    }

    public r(j jVar, String str, ArrayList<BasicNameValuePair> arrayList, f fVar) {
        this.a = jVar;
        this.c = null;
        this.d = null;
        this.e = null;
        this.c = str;
        this.d = arrayList;
        this.e = fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public bj a(Object... objArr) {
        p pVar;
        String str;
        Activity activity;
        int i;
        p pVar2;
        int i2;
        p pVar3;
        pVar = this.a.j;
        String a = pVar.a();
        if (a != null && a.length() > 0) {
            i2 = this.a.h;
            if (i2 == 1) {
                this.f = new bj();
                this.f.a(a);
                if (!this.f.a()) {
                    be.e("MentionAsyncTask", "doInBackground", "cache data format err");
                    this.f = null;
                    pVar3 = this.a.j;
                    pVar3.b();
                } else {
                    be.e("MentionAsyncTask", "doInBackground", "cache data.size: " + String.valueOf(a.length()));
                    c((Object[]) new Integer[]{0});
                }
            }
        }
        try {
            str = this.a.o;
        } catch (Exception e) {
            be.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        if (bc.c(str)) {
            return null;
        }
        this.b = new an(this.c);
        this.b.a(this.d);
        an anVar = this.b;
        activity = this.a.c;
        anVar.a(activity);
        String l = this.b.l();
        if (this.b.c() && l != null) {
            this.f = new bj();
            this.f.a(l);
            if (this.f.a()) {
                i = this.a.n;
                if (i != 4) {
                    pVar2 = this.a.j;
                    pVar2.a(l);
                }
            } else {
                this.f = null;
            }
        }
        return this.f;
    }

    private void a(boolean z) {
        int i;
        BdListView bdListView;
        BdListView bdListView2;
        int i2;
        BdListView bdListView3;
        BdListView bdListView4;
        if (z) {
            i2 = this.a.n;
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    bdListView3 = this.a.e;
                    if (bdListView3 != null) {
                        bdListView4 = this.a.e;
                        bdListView4.b();
                        return;
                    }
                    return;
                case 4:
                    this.e.c(true);
                    this.e.notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        }
        i = this.a.n;
        switch (i) {
            case 1:
            case 2:
            case 3:
                bdListView = this.a.e;
                if (bdListView != null) {
                    bdListView2 = this.a.e;
                    bdListView2.a();
                    return;
                }
                return;
            case 4:
                this.e.c(false);
                this.e.notifyDataSetChanged();
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bj bjVar) {
        Fragment fragment;
        int i;
        a(false);
        if (this.b != null) {
            if (!this.b.d() || bjVar == null) {
                fragment = this.a.b;
                android.support.v4.app.n i2 = fragment.i();
                if (i2 != null && (i2 instanceof BaseFragmentActivity)) {
                    com.baidu.adp.lib.h.g.a((Context) ((BaseFragmentActivity) i2), this.b.i());
                }
            } else {
                j jVar = this.a;
                i = this.a.n;
                jVar.a(bjVar, i == 4);
            }
        }
        this.a.k = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.j();
        }
        a(false);
        this.a.k = null;
        super.cancel(true);
    }
}
