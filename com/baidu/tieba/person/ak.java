package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.os.AsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends AsyncTask {
    final /* synthetic */ PersonChangeActivity a;

    private ak(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ak(PersonChangeActivity personChangeActivity, ak akVar) {
        this(personChangeActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(Object... objArr) {
        return com.baidu.tieba.c.o.c(null, "tieba_head_image");
    }

    public void a() {
        PersonChangeActivity.a(this.a, (ak) null);
        PersonChangeActivity.f(this.a).setVisibility(8);
        PersonChangeActivity.g(this.a).setEnabled(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        PersonChangeActivity.a(this.a, (ak) null);
        PersonChangeActivity.g(this.a).setEnabled(true);
        PersonChangeActivity.f(this.a).setVisibility(8);
        if (bitmap != null) {
            PersonChangeActivity.a(this.a, bitmap);
            PersonChangeActivity.h(this.a).setImageBitmap(PersonChangeActivity.i(this.a));
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        PersonChangeActivity.f(this.a).setVisibility(0);
        PersonChangeActivity.g(this.a).setEnabled(false);
        PersonChangeActivity.h(this.a).setImageBitmap(null);
        PersonChangeActivity.a(this.a, (Bitmap) null);
        super.onPreExecute();
    }
}
