package com.baidu.tieba.mention;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tieba.model.ak;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<Object, Integer, ak> {
    final /* synthetic */ l a;
    private String c;
    private ArrayList<BasicNameValuePair> d;
    private c e;
    private aq b = null;
    private ak f = null;

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

    public r(l lVar, String str, ArrayList<BasicNameValuePair> arrayList, c cVar) {
        this.a = lVar;
        this.c = null;
        this.d = null;
        this.e = null;
        this.c = str;
        this.d = arrayList;
        this.e = cVar;
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
    public ak doInBackground(Object... objArr) {
        q qVar;
        String str;
        int i;
        q qVar2;
        int i2;
        q qVar3;
        qVar = this.a.j;
        String a = qVar.a();
        if (a != null && a.length() > 0) {
            i2 = this.a.h;
            if (i2 == 1) {
                this.f = new ak();
                this.f.a(a);
                if (this.f.a()) {
                    publishProgress(0);
                } else {
                    this.f = null;
                    qVar3 = this.a.j;
                    qVar3.b();
                }
            }
        }
        try {
            str = this.a.o;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (bm.c(str)) {
            return null;
        }
        this.b = new aq(this.c);
        this.b.a(this.d);
        String i3 = this.b.i();
        if (this.b.a().b().b() && i3 != null) {
            this.f = new ak();
            this.f.a(i3);
            if (this.f.a()) {
                i = this.a.n;
                if (i != 4) {
                    qVar2 = this.a.j;
                    qVar2.a(i3);
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
    public void onPostExecute(ak akVar) {
        int i;
        a(false);
        if (this.b != null && this.b.c() && akVar != null) {
            l lVar = this.a;
            i = this.a.n;
            lVar.a(akVar, i == 4);
        }
        this.a.k = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.g();
        }
        a(false);
        this.a.k = null;
        super.cancel(true);
    }
}
