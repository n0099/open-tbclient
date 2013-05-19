package com.baidu.tieba.person;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends com.baidu.adp.lib.a.a {
    final /* synthetic */ PersonChangeActivity a;

    private av(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ av(PersonChangeActivity personChangeActivity, av avVar) {
        this(personChangeActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        PersonChangeActivity.f(this.a).setVisibility(0);
        PersonChangeActivity.g(this.a).setEnabled(false);
        PersonChangeActivity.h(this.a).setImageBitmap(null);
        PersonChangeActivity.a(this.a, (Bitmap) null);
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        return com.baidu.tieba.d.o.c(null, "tieba_head_image");
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        PersonChangeActivity.a(this.a, (av) null);
        PersonChangeActivity.f(this.a).setVisibility(8);
        PersonChangeActivity.g(this.a).setEnabled(true);
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void c() {
        super.c();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Bitmap bitmap) {
        super.a((Object) bitmap);
        PersonChangeActivity.a(this.a, (av) null);
        PersonChangeActivity.g(this.a).setEnabled(true);
        PersonChangeActivity.f(this.a).setVisibility(8);
        if (bitmap != null) {
            PersonChangeActivity.a(this.a, bitmap);
            PersonChangeActivity.h(this.a).setImageBitmap(PersonChangeActivity.i(this.a));
        }
    }
}
