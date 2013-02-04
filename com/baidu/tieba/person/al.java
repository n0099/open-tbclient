package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends AsyncTask {
    final /* synthetic */ PersonChangeActivity a;
    private com.baidu.tieba.c.t b = null;
    private com.baidu.tieba.b.o c;

    public al(PersonChangeActivity personChangeActivity, com.baidu.tieba.b.o oVar) {
        this.a = personChangeActivity;
        this.c = null;
        this.c = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        if (this.c != null) {
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/profile/modify");
            this.b.a("sex", String.valueOf(this.c.b()));
            this.b.a("intro", this.c.a());
            this.b.j();
            if (this.b.b()) {
                com.baidu.tieba.c.k.d();
            }
        }
        return null;
    }

    public void a() {
        this.a.s = null;
        if (this.b != null) {
            this.b.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        this.a.s = null;
        this.a.c();
        if (this.b != null) {
            if (this.b.b()) {
                this.a.b(this.a.getString(R.string.success));
                Intent intent = new Intent();
                intent.putExtra("data", this.c);
                this.a.setResult(-1, intent);
                this.a.finish();
            } else {
                this.a.b(this.b.f());
            }
        }
        super.onPostExecute(str);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.a;
        String string = this.a.getString(R.string.saving);
        onCancelListener = this.a.u;
        personChangeActivity.a(string, onCancelListener);
        super.onPreExecute();
    }
}
