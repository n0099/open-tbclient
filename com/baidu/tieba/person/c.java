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
    final /* synthetic */ AllPostActivity a;
    private int b;
    private int c;
    private int d;
    private String e;
    private com.baidu.tieba.util.r f;

    public c(AllPostActivity allPostActivity, int i, int i2, int i3, String str) {
        this.a = allPostActivity;
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
                str = String.valueOf(com.baidu.tieba.data.g.a) + "c/u/feed/mypost";
            } else {
                str = String.valueOf(com.baidu.tieba.data.g.a) + "c/u/feed/otherpost";
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
        this.a.g = null;
        this.a.k = false;
        progressBar = this.a.j;
        progressBar.setVisibility(8);
        if (this.f != null) {
            try {
                if (str != null) {
                    if (this.d == 0) {
                        this.a.f.d();
                    }
                    this.a.f.b(str);
                    this.a.e.notifyDataSetChanged();
                    if (this.e != null && !this.e.equals(TiebaApplication.E()) && !this.a.f.b()) {
                        this.a.c.setVisibility(8);
                        this.a.d.setVisibility(8);
                        this.a.b.setVisibility(8);
                        this.a.a(this.a.getString(R.string.his_post_not_available));
                        handler = this.a.m;
                        handler2 = this.a.m;
                        handler.sendMessageDelayed(handler2.obtainMessage(1), 2000L);
                        return;
                    } else if (this.a.f.c().size() == 0) {
                        this.a.c.setVisibility(8);
                        this.a.d.setVisibility(8);
                        this.a.b.setVisibility(0);
                        return;
                    } else {
                        this.a.c.setVisibility(0);
                        this.a.d.setVisibility(0);
                        this.a.b.setVisibility(8);
                        if (this.d == 0) {
                            this.a.c.setSelection(0);
                            return;
                        }
                        return;
                    }
                }
                this.a.a(this.f.g());
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
        this.a.g = null;
        this.a.k = false;
        this.a.e.notifyDataSetChanged();
        progressBar = this.a.j;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
