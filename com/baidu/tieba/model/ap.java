package com.baidu.tieba.model;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ao f1334a;
    private String b;

    public ap(ao aoVar, String str) {
        this.f1334a = aoVar;
        this.b = null;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        if (this.b != null && !this.b.equals("tieba_resized_image")) {
            com.baidu.tieba.util.p.e("photos/" + this.b, "tieba_resized_image");
        }
        return com.baidu.tieba.util.e.a(com.baidu.tieba.util.e.b(com.baidu.tieba.util.p.c(null, "tieba_resized_image_display")), 5.0f);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        this.f1334a.f1333a = null;
        eVar = this.f1334a.mLoadDataCallBack;
        if (eVar != null) {
            eVar2 = this.f1334a.mLoadDataCallBack;
            eVar2.a(null);
        }
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) bitmap);
        this.f1334a.f1333a = null;
        com.baidu.tieba.util.aj.a(getClass().getName(), "onPostExecute", "is Null?" + String.valueOf(bitmap == null));
        eVar = this.f1334a.mLoadDataCallBack;
        if (eVar != null) {
            eVar2 = this.f1334a.mLoadDataCallBack;
            eVar2.a(bitmap);
        }
    }
}
