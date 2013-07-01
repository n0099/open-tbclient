package com.baidu.tieba.person;

import android.os.Handler;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AllPostActivity f1356a;
    private int b;
    private int c;
    private int d;
    private String e;
    private com.baidu.tieba.util.r f;

    public c(AllPostActivity allPostActivity, int i, int i2, int i3, String str) {
        this.f1356a = allPostActivity;
        this.e = null;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        try {
            boolean z = this.e == null || this.e.equals(TiebaApplication.E());
            if (z) {
                str = String.valueOf(com.baidu.tieba.data.g.f787a) + "c/u/feed/mypost";
            } else {
                str = String.valueOf(com.baidu.tieba.data.g.f787a) + "c/u/feed/otherpost";
            }
            this.f = new com.baidu.tieba.util.r(str);
            this.f.a("type", String.valueOf(this.b));
            this.f.a("pn", String.valueOf(this.c));
            if (!z) {
                this.f.a(PushConstants.EXTRA_USER_ID, this.e);
            }
            String j = this.f.j();
            if (this.f.c()) {
                return j;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "", "MyPostAsyncTask.doInBackground error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        Handler handler;
        Handler handler2;
        this.f1356a.g = null;
        this.f1356a.k = false;
        progressBar = this.f1356a.j;
        progressBar.setVisibility(8);
        if (this.f != null) {
            try {
                if (str != null) {
                    if (this.d == 0) {
                        this.f1356a.f.d();
                    }
                    this.f1356a.f.b(str);
                    this.f1356a.e.notifyDataSetChanged();
                    if (this.e != null && !this.e.equals(TiebaApplication.E()) && !this.f1356a.f.b()) {
                        this.f1356a.c.setVisibility(8);
                        this.f1356a.d.setVisibility(8);
                        this.f1356a.b.setVisibility(8);
                        this.f1356a.a(this.f1356a.getString(R.string.his_post_not_available));
                        handler = this.f1356a.m;
                        handler2 = this.f1356a.m;
                        handler.sendMessageDelayed(handler2.obtainMessage(1), 2000L);
                        return;
                    } else if (this.f1356a.f.c().size() == 0) {
                        this.f1356a.c.setVisibility(8);
                        this.f1356a.d.setVisibility(8);
                        this.f1356a.b.setVisibility(0);
                        return;
                    } else {
                        this.f1356a.c.setVisibility(0);
                        this.f1356a.d.setVisibility(0);
                        this.f1356a.b.setVisibility(8);
                        if (this.d == 0) {
                            this.f1356a.c.setSelection(0);
                            return;
                        }
                        return;
                    }
                }
                this.f1356a.a(this.f.g());
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "", "MyPostAsyncTask.onPostExecute error = " + e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.f != null) {
            this.f.h();
        }
        this.f1356a.g = null;
        this.f1356a.k = false;
        this.f1356a.e.notifyDataSetChanged();
        progressBar = this.f1356a.j;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
