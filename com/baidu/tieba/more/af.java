package com.baidu.tieba.more;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
class af extends BdAsyncTask<Object, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoreActivity f1973a;

    private af(MoreActivity moreActivity) {
        this.f1973a = moreActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ af(MoreActivity moreActivity, ad adVar) {
        this(moreActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        return com.baidu.tieba.util.af.c(null, "tieba_head_image");
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
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
        ah ahVar;
        ah ahVar2;
        super.a((af) bitmap);
        if (bitmap != null) {
            com.baidu.adp.widget.ImageView.e eVar = new com.baidu.adp.widget.ImageView.e(bitmap, false, null);
            ahVar = this.f1973a.f1960a;
            if (ahVar != null) {
                ahVar2 = this.f1973a.f1960a;
                ahVar2.a(eVar);
            }
        }
    }
}
