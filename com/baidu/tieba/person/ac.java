package com.baidu.tieba.person;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends AsyncTask {
    final /* synthetic */ EditMarkActivity a;
    private com.baidu.tieba.c.t b = null;
    private String c;
    private int d;
    private com.baidu.tieba.a.av e;

    public ac(EditMarkActivity editMarkActivity, String str, int i) {
        this.a = editMarkActivity;
        this.c = null;
        this.d = 0;
        this.e = null;
        this.c = str;
        this.d = i;
        this.e = new com.baidu.tieba.a.av();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.n;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Boolean... boolArr) {
        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/post/rmstore");
        this.b.a(PushConstants.EXTRA_USER_ID, TiebaApplication.y());
        this.b.a("tid", this.c);
        this.e.a(this.b.i());
        return this.b.b() && this.e.a() == 0;
    }

    public void a() {
        ProgressBar progressBar;
        super.cancel(true);
        this.b.g();
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        this.a.m = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        ProgressBar progressBar;
        com.baidu.tieba.b.j jVar;
        com.baidu.tieba.home.ab abVar;
        com.baidu.tieba.home.ab abVar2;
        com.baidu.tieba.home.ab abVar3;
        com.baidu.tieba.home.ab abVar4;
        Button button;
        Button button2;
        com.baidu.tieba.home.ab abVar5;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        this.a.m = null;
        if (bool.booleanValue()) {
            jVar = this.a.d;
            ArrayList b = jVar.b();
            if (b != null) {
                if (this.d < b.size()) {
                    b.remove(this.d);
                    abVar = this.a.c;
                    abVar.a(b);
                    abVar2 = this.a.c;
                    abVar2.c(true);
                    abVar3 = this.a.c;
                    abVar3.b();
                    if (b.size() == 0) {
                        button = this.a.g;
                        button.setText(R.string.edit);
                        button2 = this.a.g;
                        button2.setVisibility(4);
                        abVar5 = this.a.c;
                        abVar5.d(false);
                    }
                    abVar4 = this.a.c;
                    abVar4.notifyDataSetChanged();
                } else {
                    return;
                }
            }
            this.a.b(this.a.getString(R.string.success));
        } else if (this.b.b()) {
            this.a.b(this.e.b());
        } else {
            this.a.b(this.b.f());
        }
    }
}
