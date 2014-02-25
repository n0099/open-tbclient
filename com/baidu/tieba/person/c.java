package com.baidu.tieba.person;

import android.os.Handler;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<Integer, String, String> {
    final /* synthetic */ AllPostActivity a;
    private int b;
    private int c;
    private int d;
    private String e;
    private com.baidu.tieba.util.ba f;

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
    public String a(Integer... numArr) {
        String str;
        com.baidu.adp.lib.cache.s<String> m;
        String a;
        boolean z = true;
        try {
            int intValue = numArr[0].intValue();
            if (this.e != null && !this.e.equals(TiebaApplication.A())) {
                z = false;
            }
            if (intValue == 0 && z && (m = com.baidu.tieba.c.a.a().m()) != null && (a = m.a(TiebaApplication.A())) != null) {
                c((Object[]) new String[]{a});
            }
            if (z) {
                str = String.valueOf(com.baidu.tieba.data.i.a) + "c/u/feed/mypost";
            } else {
                str = String.valueOf(com.baidu.tieba.data.i.a) + "c/u/feed/otherpost";
            }
            this.f = new com.baidu.tieba.util.ba(str);
            this.f.a("type", String.valueOf(this.b));
            this.f.a("pn", String.valueOf(this.c));
            if (!z) {
                this.f.a(PushConstants.EXTRA_USER_ID, this.e);
            }
            String m2 = this.f.m();
            if (this.f.d()) {
                if (z && this.d == 0) {
                    b(m2);
                    return m2;
                }
                return m2;
            }
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "", "MyPostAsyncTask.doInBackground error = " + e.getMessage());
            return null;
        }
    }

    private void b(String str) {
        com.baidu.adp.lib.cache.s<String> m;
        String A = TiebaApplication.A();
        if (A != null && (m = com.baidu.tieba.c.a.a().m()) != null) {
            m.a(A, str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(String... strArr) {
        ProgressBar progressBar;
        Handler handler;
        Handler handler2;
        this.a.f.e();
        this.a.f.b(strArr[0]);
        this.a.e.notifyDataSetChanged();
        if (this.e != null && !this.e.equals(TiebaApplication.A()) && !this.a.f.c()) {
            this.a.c.setVisibility(8);
            this.a.d.setVisibility(8);
            this.a.b.setVisibility(8);
            this.a.showToast(this.a.getString(R.string.his_post_not_available));
            handler = this.a.k;
            handler2 = this.a.k;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 2000L);
            return;
        }
        if (this.a.f.d().size() == 0) {
            this.a.c.setVisibility(8);
            this.a.d.setVisibility(8);
            this.a.b.setVisibility(0);
        } else {
            this.a.c.setVisibility(0);
            this.a.d.setVisibility(0);
            this.a.b.setVisibility(8);
            if (this.d == 0) {
                this.a.c.setSelection(0);
            }
        }
        progressBar = this.a.h;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        Handler handler;
        Handler handler2;
        this.a.g = null;
        this.a.i = false;
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        if (this.f != null) {
            try {
                if (str != null) {
                    if (this.d == 0) {
                        this.a.f.e();
                    }
                    this.a.f.b(str);
                    this.a.e.notifyDataSetChanged();
                    if (this.e != null && !this.e.equals(TiebaApplication.A()) && !this.a.f.c()) {
                        this.a.c.setVisibility(8);
                        this.a.d.setVisibility(8);
                        this.a.b.setVisibility(8);
                        this.a.showToast(this.a.getString(R.string.his_post_not_available));
                        handler = this.a.k;
                        handler2 = this.a.k;
                        handler.sendMessageDelayed(handler2.obtainMessage(1), 2000L);
                        return;
                    } else if (this.a.f.d().size() == 0) {
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
                this.a.showToast(this.f.j());
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "", "MyPostAsyncTask.onPostExecute error = " + e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.f != null) {
            this.f.k();
        }
        this.a.g = null;
        this.a.i = false;
        this.a.e.notifyDataSetChanged();
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
