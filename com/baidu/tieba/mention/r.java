package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.model.bi;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.be;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<Object, Integer, bi> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1872a;
    private ag b = null;
    private String c;
    private ArrayList<BasicNameValuePair> d;
    private f e;

    public r(j jVar, String str, ArrayList<BasicNameValuePair> arrayList, f fVar) {
        this.f1872a = jVar;
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
    public bi a(Object... objArr) {
        bi biVar;
        Exception e;
        Activity activity;
        int i;
        p pVar;
        try {
            this.b = new ag(this.c);
            this.b.a(this.d);
            ag agVar = this.b;
            activity = this.f1872a.c;
            agVar.a(activity);
            String j = this.b.j();
            if (!this.b.c() || j == null) {
                return null;
            }
            biVar = new bi();
            try {
                biVar.a(j);
                if (biVar.a()) {
                    i = this.f1872a.n;
                    if (i != 4) {
                        pVar = this.f1872a.j;
                        pVar.a(j);
                        return biVar;
                    }
                    return biVar;
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                be.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return biVar;
            }
        } catch (Exception e3) {
            biVar = null;
            e = e3;
        }
    }

    private void a(boolean z) {
        int i;
        BdListView bdListView;
        BdListView bdListView2;
        int i2;
        BdListView bdListView3;
        BdListView bdListView4;
        if (z) {
            i2 = this.f1872a.n;
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    bdListView3 = this.f1872a.e;
                    if (bdListView3 != null) {
                        bdListView4 = this.f1872a.e;
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
        i = this.f1872a.n;
        switch (i) {
            case 1:
            case 2:
            case 3:
                bdListView = this.f1872a.e;
                if (bdListView != null) {
                    bdListView2 = this.f1872a.e;
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
    public void a(bi biVar) {
        Fragment fragment;
        int i;
        a(false);
        if (this.b != null) {
            if (!this.b.d() || biVar == null) {
                fragment = this.f1872a.b;
                android.support.v4.app.n i2 = fragment.i();
                if (i2 != null && (i2 instanceof MentionActivity)) {
                    UtilHelper.a((Context) ((MentionActivity) i2), this.b.g());
                }
            } else {
                j jVar = this.f1872a;
                i = this.f1872a.n;
                jVar.a(biVar, i == 4);
            }
        }
        this.f1872a.k = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        a(false);
        this.f1872a.k = null;
        super.cancel(true);
    }
}
