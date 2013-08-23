package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.model.ax;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.aq;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1338a;
    private com.baidu.tieba.util.v b = null;
    private String c;
    private ArrayList d;
    private f e;

    public p(i iVar, String str, ArrayList arrayList, f fVar) {
        this.f1338a = iVar;
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
    public ax a(Object... objArr) {
        ax axVar;
        Exception e;
        com.baidu.tieba.g gVar;
        int i;
        n nVar;
        try {
            this.b = new com.baidu.tieba.util.v(this.c);
            this.b.a(this.d);
            com.baidu.tieba.util.v vVar = this.b;
            gVar = this.f1338a.b;
            vVar.a(gVar);
            String j = this.b.j();
            if (!this.b.c() || j == null) {
                return null;
            }
            axVar = new ax();
            try {
                axVar.a(j);
                if (axVar.a()) {
                    i = this.f1338a.m;
                    if (i != 4) {
                        nVar = this.f1338a.i;
                        nVar.a(j);
                        return axVar;
                    }
                    return axVar;
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                aq.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return axVar;
            }
        } catch (Exception e3) {
            axVar = null;
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
            i2 = this.f1338a.m;
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    bdListView3 = this.f1338a.d;
                    if (bdListView3 != null) {
                        bdListView4 = this.f1338a.d;
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
        i = this.f1338a.m;
        switch (i) {
            case 1:
            case 2:
            case 3:
                bdListView = this.f1338a.d;
                if (bdListView != null) {
                    bdListView2 = this.f1338a.d;
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
    public void a(ax axVar) {
        com.baidu.tieba.g gVar;
        int i;
        a(false);
        if (this.b != null) {
            if (!this.b.d() || axVar == null) {
                gVar = this.f1338a.b;
                Activity parent = gVar.getParent();
                if (parent != null && (parent instanceof MentionActivity)) {
                    UtilHelper.a((Context) ((MentionActivity) parent), this.b.g());
                }
            } else {
                i iVar = this.f1338a;
                i = this.f1338a.m;
                iVar.a(axVar, i == 4);
            }
        }
        this.f1338a.j = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        a(false);
        this.f1338a.j = null;
        super.cancel(true);
    }
}
