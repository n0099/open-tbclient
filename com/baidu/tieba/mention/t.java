package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.model.ay;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.bs;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t extends BdAsyncTask<Object, Integer, ay> {
    final /* synthetic */ l a;
    private String c;
    private ArrayList<BasicNameValuePair> d;
    private h e;
    private ba b = null;
    private ay f = null;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ ay a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(ay ayVar) {
        Fragment fragment;
        int i;
        ay ayVar2 = ayVar;
        a(false);
        if (this.b != null) {
            if (!this.b.d() || ayVar2 == null) {
                fragment = this.a.b;
                FragmentActivity activity = fragment.getActivity();
                if (activity != null && (activity instanceof com.baidu.tieba.k)) {
                    BdUtilHelper.a((Context) ((com.baidu.tieba.k) activity), this.b.i());
                }
            } else {
                l lVar = this.a;
                i = this.a.n;
                lVar.a(ayVar2, i == 4);
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

    public t(l lVar, String str, ArrayList<BasicNameValuePair> arrayList, h hVar) {
        this.a = lVar;
        this.c = null;
        this.d = null;
        this.e = null;
        this.c = str;
        this.d = arrayList;
        this.e = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        a(true);
    }

    private ay d() {
        s sVar;
        String str;
        Activity activity;
        int i;
        s sVar2;
        int i2;
        s sVar3;
        sVar = this.a.j;
        String a = sVar.a();
        if (a != null && a.length() > 0) {
            i2 = this.a.h;
            if (i2 == 1) {
                this.f = new ay();
                this.f.a(a);
                if (!this.f.a()) {
                    com.baidu.adp.lib.util.e.e("MentionAsyncTask", "doInBackground", "cache data format err");
                    this.f = null;
                    sVar3 = this.a.j;
                    sVar3.b();
                } else {
                    com.baidu.adp.lib.util.e.e("MentionAsyncTask", "doInBackground", "cache data.size: " + String.valueOf(a.length()));
                    c((Object[]) new Integer[]{0});
                }
            }
        }
        try {
            str = this.a.o;
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        if (bs.c(str)) {
            return null;
        }
        this.b = new ba(this.c);
        this.b.a(this.d);
        ba baVar = this.b;
        activity = this.a.c;
        baVar.a(activity);
        String l = this.b.l();
        if (this.b.c() && l != null) {
            this.f = new ay();
            this.f.a(l);
            if (this.f.a()) {
                i = this.a.n;
                if (i != 4) {
                    sVar2 = this.a.j;
                    sVar2.a(l);
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

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.b != null) {
            this.b.j();
        }
        a(false);
        this.a.k = null;
        super.cancel(true);
    }
}
