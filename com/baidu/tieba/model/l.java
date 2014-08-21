package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<Boolean, String, j> {
    final /* synthetic */ j b;
    private int e;
    private com.baidu.tieba.data.ax f;
    private com.baidu.tbadk.core.util.ae c = null;
    private String d = null;
    Boolean a = false;

    public l(j jVar, int i) {
        this.b = jVar;
        this.e = 0;
        this.f = null;
        this.e = i;
        this.f = new com.baidu.tieba.data.ax();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public j doInBackground(Boolean... boolArr) {
        boolean z;
        ArrayList arrayList;
        ArrayList arrayList2;
        this.a = boolArr[0];
        j jVar = new j();
        if (this.a.booleanValue()) {
            com.baidu.adp.lib.cache.t<String> b = com.baidu.tbadk.core.a.a.a().b("tb.my_bookmarks");
            if (b != null) {
                publishProgress(b.a(TbadkApplication.getCurrentAccount()));
            }
            arrayList = this.b.e;
            if (arrayList == null) {
                this.b.e = new ArrayList();
            } else {
                arrayList2 = this.b.e;
                arrayList2.clear();
            }
            this.b.f = 0;
        }
        this.c = new com.baidu.tbadk.core.util.ae(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/post/threadstore");
        this.c.a(com.baidu.tbadk.core.frameworkData.a.USER_ID, TbadkApplication.getCurrentAccount());
        z = this.b.h;
        if (z) {
            this.c.a("offset", String.valueOf(0));
        } else {
            this.c.a("offset", String.valueOf(this.e));
        }
        this.c.a("rn", String.valueOf(20));
        this.d = this.c.h();
        this.f.a(this.d);
        if (this.c.a().b().b()) {
            jVar.a(this.d);
            if (this.e == 0 && this.a.booleanValue()) {
                a(this.d);
            }
        }
        return jVar;
    }

    private void a(String str) {
        com.baidu.adp.lib.cache.t<String> b;
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && (b = com.baidu.tbadk.core.a.a.a().b("tb.my_bookmarks")) != null) {
            b.a(currentAccount, str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(String... strArr) {
        ArrayList<MarkData> b;
        super.onProgressUpdate(strArr);
        String str = strArr[0];
        ArrayList<MarkData> arrayList = new ArrayList<>();
        if (str != null) {
            b = this.b.b(str);
            if (this.a.booleanValue()) {
                this.b.a(b);
            } else {
                this.b.b(b);
            }
        } else {
            this.b.a(arrayList);
        }
        this.b.a.callback(0, null, true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.f();
        }
        this.b.b = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(j jVar) {
        if (jVar == null) {
            jVar = new j();
        }
        this.b.b = null;
        this.b.f = jVar.g();
        ArrayList<MarkData> f = jVar.f();
        if (this.a.booleanValue()) {
            this.b.a(f);
        } else {
            this.b.b(f);
        }
        Iterator<MarkData> it = f.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getNewCounts() > 0) {
                int i2 = i + 1;
                this.b.a(i2);
                i = i2;
            }
        }
        if (this.b.a != null) {
            if (this.c.a().b().b()) {
                this.b.a.callback(0, this.f.b(), false);
            } else {
                this.b.a.callback(3, this.c.e());
            }
        }
        this.b.h = false;
    }
}
