package com.baidu.tieba.person;

import android.os.AsyncTask;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends AsyncTask {
    final /* synthetic */ AllPostActivity a;
    private int b;
    private int c;
    private int d;
    private com.baidu.tieba.c.t e;

    public b(AllPostActivity allPostActivity, int i, int i2, int i3) {
        this.a = allPostActivity;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        try {
            this.e = new com.baidu.tieba.c.t(strArr[0]);
            this.e.a("type", String.valueOf(this.b));
            this.e.a("pn", String.valueOf(this.c));
            String i = this.e.i();
            if (this.e.b()) {
                return i;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "", "MyPostAsyncTask.doInBackground error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        this.a.i = null;
        this.a.k = false;
        progressBar = this.a.j;
        progressBar.setVisibility(8);
        if (this.e != null) {
            try {
                if (str != null) {
                    if (this.d == 0) {
                        this.a.h.b();
                    }
                    this.a.h.a(str);
                    this.a.g.notifyDataSetChanged();
                    if (this.a.h.a().size() == 0) {
                        this.a.e.setVisibility(8);
                        this.a.f.setVisibility(8);
                        this.a.d.setVisibility(0);
                        return;
                    }
                    this.a.e.setVisibility(0);
                    this.a.f.setVisibility(0);
                    this.a.d.setVisibility(8);
                    if (this.d == 0) {
                        this.a.e.setSelection(0);
                        return;
                    }
                    return;
                }
                this.a.b(this.e.f());
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b(getClass().getName(), "", "MyPostAsyncTask.onPostExecute error = " + e.getMessage());
            }
        }
    }

    public void a() {
        ProgressBar progressBar;
        if (this.e != null) {
            this.e.g();
        }
        this.a.i = null;
        this.a.k = false;
        this.a.g.notifyDataSetChanged();
        progressBar = this.a.j;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
