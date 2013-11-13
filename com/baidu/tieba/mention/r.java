package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.model.bj;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.bg;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<Object, Integer, bj> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1869a;
    private String c;
    private ArrayList<BasicNameValuePair> d;
    private f e;
    private ap b = null;
    private bj f = null;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(Integer... numArr) {
        super.b((Object[]) numArr);
        if (this.f != null) {
            this.f1869a.a(this.f, true);
        }
    }

    public r(j jVar, String str, ArrayList<BasicNameValuePair> arrayList, f fVar) {
        this.f1869a = jVar;
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
        a(true);
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
        p pVar3;
        pVar = this.f1869a.j;
        String a2 = pVar.a();
        if (a2 != null && a2.length() > 0) {
            this.f = new bj();
            this.f.a(a2);
            if (!this.f.a()) {
                bg.e("MentionAsyncTask", "doInBackground", "cache data format err");
                this.f = null;
                pVar3 = this.f1869a.j;
                pVar3.b();
            } else {
                bg.e("MentionAsyncTask", "doInBackground", "cache data.size: " + String.valueOf(a2.length()));
                c((Object[]) new Integer[]{0});
            }
        }
        try {
            str = this.f1869a.o;
        } catch (Exception e) {
            bg.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        if (be.c(str)) {
            return null;
        }
        this.b = new ap(this.c);
        this.b.a(this.d);
        ap apVar = this.b;
        activity = this.f1869a.c;
        apVar.a(activity);
        String j = this.b.j();
        if (this.b.c() && j != null) {
            this.f = new bj();
            this.f.a(j);
            if (this.f.a()) {
                i = this.f1869a.n;
                if (i != 4) {
                    pVar2 = this.f1869a.j;
                    pVar2.a(j);
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
            i2 = this.f1869a.n;
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    bdListView3 = this.f1869a.e;
                    if (bdListView3 != null) {
                        bdListView4 = this.f1869a.e;
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
        i = this.f1869a.n;
        switch (i) {
            case 1:
            case 2:
            case 3:
                bdListView = this.f1869a.e;
                if (bdListView != null) {
                    bdListView2 = this.f1869a.e;
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
                fragment = this.f1869a.b;
                android.support.v4.app.n i2 = fragment.i();
                if (i2 != null && (i2 instanceof BaseFragmentActivity)) {
                    UtilHelper.a((Context) ((BaseFragmentActivity) i2), this.b.g());
                }
            } else {
                j jVar = this.f1869a;
                i = this.f1869a.n;
                jVar.a(bjVar, i == 4);
            }
        }
        this.f1869a.k = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        a(false);
        this.f1869a.k = null;
        super.cancel(true);
    }
}
