package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.model.az;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.av;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Object, Integer, az> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1374a;
    private com.baidu.tieba.util.z b = null;
    private String c;
    private ArrayList<BasicNameValuePair> d;
    private f e;

    public q(i iVar, String str, ArrayList<BasicNameValuePair> arrayList, f fVar) {
        this.f1374a = iVar;
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
    public az a(Object... objArr) {
        az azVar;
        Exception e;
        Activity activity;
        int i;
        o oVar;
        try {
            this.b = new com.baidu.tieba.util.z(this.c);
            this.b.a(this.d);
            com.baidu.tieba.util.z zVar = this.b;
            activity = this.f1374a.c;
            zVar.a(activity);
            String j = this.b.j();
            if (!this.b.c() || j == null) {
                return null;
            }
            azVar = new az();
            try {
                azVar.a(j);
                if (azVar.a()) {
                    i = this.f1374a.n;
                    if (i != 4) {
                        oVar = this.f1374a.j;
                        oVar.a(j);
                        return azVar;
                    }
                    return azVar;
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                av.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return azVar;
            }
        } catch (Exception e3) {
            azVar = null;
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
            i2 = this.f1374a.n;
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    bdListView3 = this.f1374a.e;
                    if (bdListView3 != null) {
                        bdListView4 = this.f1374a.e;
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
        i = this.f1374a.n;
        switch (i) {
            case 1:
            case 2:
            case 3:
                bdListView = this.f1374a.e;
                if (bdListView != null) {
                    bdListView2 = this.f1374a.e;
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
    public void a(az azVar) {
        Fragment fragment;
        int i;
        a(false);
        if (this.b != null) {
            if (!this.b.d() || azVar == null) {
                fragment = this.f1374a.b;
                android.support.v4.app.n h = fragment.h();
                if (h != null && (h instanceof MentionActivity)) {
                    UtilHelper.a((Context) ((MentionActivity) h), this.b.g());
                }
            } else {
                i iVar = this.f1374a;
                i = this.f1374a.n;
                iVar.a(azVar, i == 4);
            }
        }
        this.f1374a.k = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        a(false);
        this.f1374a.k = null;
        super.cancel(true);
    }
}
