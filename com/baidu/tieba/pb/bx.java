package com.baidu.tieba.pb;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx extends AsyncTask {
    final /* synthetic */ PbActivity a;
    private com.baidu.tieba.c.t b = null;
    private com.baidu.tieba.a.ae c;
    private boolean d;
    private com.baidu.tieba.a.av e;

    public bx(PbActivity pbActivity, com.baidu.tieba.a.ae aeVar, boolean z) {
        this.a = pbActivity;
        this.c = null;
        this.d = true;
        this.e = null;
        this.c = aeVar;
        this.d = z;
        this.e = new com.baidu.tieba.a.av();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.r;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Boolean... boolArr) {
        if (this.d) {
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/post/addstore");
            com.baidu.tieba.b.j jVar = new com.baidu.tieba.b.j();
            jVar.a(this.c);
            this.b.a("data", jVar.a(0, 1));
        } else {
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/post/rmstore");
            this.b.a(PushConstants.EXTRA_USER_ID, this.c.h());
            this.b.a("tid", this.c.c());
        }
        this.e.a(this.b.i());
        boolean z = this.e.a() == 0;
        if (this.b.b() && z) {
            return true;
        }
        return false;
    }

    public void a() {
        ProgressBar progressBar;
        super.cancel(true);
        this.b.g();
        progressBar = this.a.r;
        progressBar.setVisibility(8);
        this.a.aA = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        ProgressBar progressBar;
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        com.baidu.tieba.b.r rVar3;
        Button button;
        cd cdVar;
        Button button2;
        progressBar = this.a.r;
        progressBar.setVisibility(8);
        this.a.aA = null;
        if (bool.booleanValue()) {
            rVar = this.a.o;
            rVar.i(this.d);
            rVar2 = this.a.o;
            rVar2.a(this.c.g());
            rVar3 = this.a.o;
            if (rVar3.n()) {
                button2 = this.a.Z;
                button2.setText(R.string.remove_mark);
                this.a.b(this.a.getString(R.string.add_mark));
            } else {
                button = this.a.Z;
                button.setText(R.string.mark);
                this.a.b(this.a.getString(R.string.remove_mark));
            }
            cdVar = this.a.m;
            cdVar.notifyDataSetChanged();
        } else if (this.b.b()) {
            this.a.b(this.e.b());
        } else {
            this.a.b(this.b.f());
        }
    }
}
