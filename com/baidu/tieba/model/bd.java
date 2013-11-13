package com.baidu.tieba.model;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends BdAsyncTask<String, com.baidu.tieba.data.ah, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ba f1907a;

    private bd(ba baVar) {
        this.f1907a = baVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        ArrayList arrayList;
        Context context;
        Context context2;
        com.baidu.tieba.util.bf a2 = com.baidu.tieba.util.bf.a();
        arrayList = this.f1907a.b;
        Iterator it = arrayList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            com.baidu.tieba.data.ah ahVar = (com.baidu.tieba.data.ah) it.next();
            if (ahVar != null && ahVar.d != null) {
                try {
                    context = this.f1907a.c;
                    com.baidu.tieba.motu_gallery.b.a(context, ahVar.d, a2.e(), a2.e());
                    context2 = this.f1907a.c;
                    Bitmap a3 = com.baidu.tieba.motu_gallery.b.a(context2, ahVar.d, 150, 150);
                    if (a3 != null) {
                        ahVar.e = a3;
                    }
                } catch (Exception e) {
                    z = false;
                }
            }
            c((Object[]) new com.baidu.tieba.data.ah[]{ahVar});
        }
        return Boolean.valueOf(z);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.f1907a.f1906a = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        bc bcVar;
        bc bcVar2;
        this.f1907a.f1906a = null;
        bcVar = this.f1907a.d;
        if (bcVar != null) {
            bcVar2 = this.f1907a.d;
            bcVar2.a(bool.booleanValue(), "载入失败");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(com.baidu.tieba.data.ah... ahVarArr) {
        bc bcVar;
        bc bcVar2;
        bcVar = this.f1907a.d;
        if (bcVar != null) {
            bcVar2 = this.f1907a.d;
            bcVar2.a(ahVarArr[0]);
        }
    }
}
