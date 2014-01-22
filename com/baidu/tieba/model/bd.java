package com.baidu.tieba.model;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends BdAsyncTask<String, com.baidu.tieba.data.ah, Boolean> {
    final /* synthetic */ ba a;

    private bd(ba baVar) {
        this.a = baVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        ArrayList arrayList;
        Context context;
        Context context2;
        com.baidu.tieba.util.bx a = com.baidu.tieba.util.bx.a();
        arrayList = this.a.b;
        Iterator it = arrayList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            com.baidu.tieba.data.ah ahVar = (com.baidu.tieba.data.ah) it.next();
            if (ahVar != null && ahVar.d != null) {
                try {
                    context = this.a.c;
                    com.baidu.tieba.motu_gallery.b.a(context, ahVar.d, a.e(), a.e());
                    context2 = this.a.c;
                    Bitmap a2 = com.baidu.tieba.motu_gallery.b.a(context2, ahVar.d, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
                    if (a2 != null) {
                        ahVar.e = a2;
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
        this.a.a = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        bc bcVar;
        bc bcVar2;
        this.a.a = null;
        bcVar = this.a.d;
        if (bcVar != null) {
            bcVar2 = this.a.d;
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
        bcVar = this.a.d;
        if (bcVar != null) {
            bcVar2 = this.a.d;
            bcVar2.a(ahVarArr[0]);
        }
    }
}
