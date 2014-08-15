package com.baidu.tieba.mention;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ba;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, Integer, com.baidu.tieba.model.al> {
    final /* synthetic */ c a;
    private String c;
    private ArrayList<BasicNameValuePair> d;
    private k e;
    private com.baidu.tbadk.core.util.ae b = null;
    private com.baidu.tieba.model.al f = null;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        if (this.f != null) {
            this.a.a(this.f, true);
        }
    }

    public i(c cVar, String str, ArrayList<BasicNameValuePair> arrayList, k kVar) {
        this.a = cVar;
        this.c = null;
        this.d = null;
        this.e = null;
        this.c = str;
        this.d = arrayList;
        this.e = kVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        a(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public com.baidu.tieba.model.al doInBackground(Object... objArr) {
        h hVar;
        String str;
        int i;
        h hVar2;
        int i2;
        h hVar3;
        hVar = this.a.j;
        String a = hVar.a();
        if (a != null && a.length() > 0) {
            i2 = this.a.h;
            if (i2 == 1) {
                this.f = new com.baidu.tieba.model.al();
                this.f.a(a);
                if (this.f.a()) {
                    publishProgress(0);
                } else {
                    this.f = null;
                    hVar3 = this.a.j;
                    hVar3.b();
                }
            }
        }
        try {
            str = this.a.o;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (ba.c(str)) {
            return null;
        }
        this.b = new com.baidu.tbadk.core.util.ae(this.c);
        this.b.a(this.d);
        String h = this.b.h();
        if (this.b.a().b().b() && h != null) {
            this.f = new com.baidu.tieba.model.al();
            this.f.a(h);
            if (this.f.a()) {
                i = this.a.n;
                if (i != 4) {
                    hVar2 = this.a.j;
                    hVar2.a(h);
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
                        bdListView4.e();
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
                    bdListView2.d();
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
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.model.al alVar) {
        int i;
        a(false);
        if (this.b != null && this.b.b() && alVar != null) {
            c cVar = this.a;
            i = this.a.n;
            cVar.a(alVar, i == 4);
        }
        this.a.k = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.f();
        }
        a(false);
        this.a.k = null;
        super.cancel(true);
    }
}
