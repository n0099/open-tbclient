package com.baidu.tieba.mention;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.model.al;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u extends BdAsyncTask<Object, Integer, al> {
    final /* synthetic */ m a;
    private String c;
    private ArrayList<BasicNameValuePair> d;
    private g e;
    private ak b = null;
    private al f = null;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ al a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(al alVar) {
        Fragment fragment;
        int i;
        al alVar2 = alVar;
        a(false);
        if (this.b != null) {
            if (!this.b.c() || alVar2 == null) {
                fragment = this.a.b;
                FragmentActivity activity = fragment.getActivity();
                if (activity != null && (activity instanceof com.baidu.tbadk.core.e)) {
                    com.baidu.adp.lib.util.i.a((Context) ((com.baidu.tbadk.core.e) activity), this.b.f());
                }
            } else {
                m mVar = this.a;
                i = this.a.n;
                mVar.a(alVar2, i == 4);
            }
        }
        this.a.k = null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(Integer... numArr) {
        super.b((Object[]) numArr);
        if (this.f != null) {
            this.a.a(this.f, true);
        }
    }

    public u(m mVar, String str, ArrayList<BasicNameValuePair> arrayList, g gVar) {
        this.a = mVar;
        this.c = null;
        this.d = null;
        this.e = null;
        this.c = str;
        this.d = arrayList;
        this.e = gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        a(true);
    }

    private al a() {
        t tVar;
        String str;
        int i;
        t tVar2;
        int i2;
        t tVar3;
        tVar = this.a.j;
        String a = tVar.a();
        if (a != null && a.length() > 0) {
            i2 = this.a.h;
            if (i2 == 1) {
                this.f = new al();
                this.f.a(a);
                if (!this.f.a()) {
                    com.baidu.adp.lib.util.f.e("MentionAsyncTask", "doInBackground", "cache data format err");
                    this.f = null;
                    tVar3 = this.a.j;
                    tVar3.b();
                } else {
                    com.baidu.adp.lib.util.f.e("MentionAsyncTask", "doInBackground", "cache data.size: " + String.valueOf(a.length()));
                    c((Object[]) new Integer[]{0});
                }
            }
        }
        try {
            str = this.a.o;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        if (bc.c(str)) {
            return null;
        }
        this.b = new ak(this.c);
        this.b.a(this.d);
        String i3 = this.b.i();
        if (this.b.a().b().b() && i3 != null) {
            this.f = new al();
            this.f.a(i3);
            if (this.f.a()) {
                i = this.a.n;
                if (i != 4) {
                    tVar2 = this.a.j;
                    tVar2.a(i3);
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
                        bdListView4.c();
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
                    bdListView2.b();
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

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.b != null) {
            this.b.g();
        }
        a(false);
        this.a.k = null;
        super.cancel(true);
    }
}
