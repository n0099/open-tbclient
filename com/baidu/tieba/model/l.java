package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<Boolean, Integer, Boolean> {
    final /* synthetic */ k a;
    private com.baidu.tbadk.core.util.an b = null;
    private String c;
    private int d;
    private com.baidu.tieba.data.as e;

    public l(k kVar, String str, int i) {
        this.a = kVar;
        this.c = null;
        this.d = 0;
        this.e = null;
        this.c = str;
        this.d = i;
        this.e = new com.baidu.tieba.data.as();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Boolean... boolArr) {
        this.b = new com.baidu.tbadk.core.util.an(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/rmstore");
        this.b.a(com.baidu.tbadk.core.frameworkData.a.USER_ID, TbadkApplication.getCurrentAccount());
        this.b.a("tid", this.c);
        this.e.a(this.b.i());
        return this.b.a().b().b() && this.e.a() == 0;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
        }
        this.a.d = null;
        if (this.a.a != null) {
            this.a.a.callback(2, false, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int i;
        String str = null;
        this.a.d = null;
        if (bool.booleanValue()) {
            int i2 = this.d;
            arrayList = this.a.e;
            if (i2 < arrayList.size()) {
                arrayList2 = this.a.e;
                arrayList2.remove(this.d);
                k kVar = this.a;
                i = kVar.g;
                kVar.g = i - 1;
            }
        } else if (this.b.a().b().b()) {
            str = this.e.b();
        } else {
            str = this.b.f();
        }
        if (this.a.a != null) {
            this.a.a.callback(2, bool, str);
        }
    }
}
