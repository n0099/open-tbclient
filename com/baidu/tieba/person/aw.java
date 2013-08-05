package com.baidu.tieba.person;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f1582a;

    private aw(PersonChangeActivity personChangeActivity) {
        this.f1582a = personChangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aw(PersonChangeActivity personChangeActivity, aw awVar) {
        this(personChangeActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        PersonChangeActivity.f(this.f1582a).setVisibility(0);
        PersonChangeActivity.g(this.f1582a).setEnabled(false);
        PersonChangeActivity.h(this.f1582a).setImageBitmap(null);
        PersonChangeActivity.a(this.f1582a, (com.baidu.adp.widget.a.b) null);
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        return com.baidu.tieba.util.p.c(null, "tieba_head_image");
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        PersonChangeActivity.a(this.f1582a, (aw) null);
        PersonChangeActivity.f(this.f1582a).setVisibility(8);
        PersonChangeActivity.g(this.f1582a).setEnabled(true);
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
        super.a((Object) bitmap);
        PersonChangeActivity.a(this.f1582a, (aw) null);
        PersonChangeActivity.g(this.f1582a).setEnabled(true);
        PersonChangeActivity.f(this.f1582a).setVisibility(8);
        if (bitmap != null) {
            PersonChangeActivity.a(this.f1582a, new com.baidu.adp.widget.a.b(bitmap, false, null));
            PersonChangeActivity.i(this.f1582a).b(PersonChangeActivity.h(this.f1582a));
        }
    }
}
