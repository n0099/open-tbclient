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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AllPostActivity f2349a;
    private int b;
    private int c;
    private int d;
    private String e;
    private com.baidu.tieba.util.am f;

    public c(AllPostActivity allPostActivity, int i, int i2, int i3, String str) {
        this.f2349a = allPostActivity;
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
        String a2;
        try {
            int intValue = numArr[0].intValue();
            boolean z = this.e == null || this.e.equals(TiebaApplication.B());
            if (intValue == 0 && z && (m = com.baidu.tieba.b.a.a().m()) != null && (a2 = m.a(TiebaApplication.B())) != null) {
                c((Object[]) new String[]{a2});
            }
            if (z) {
                str = com.baidu.tieba.data.h.f1248a + "c/u/feed/mypost";
            } else {
                str = com.baidu.tieba.data.h.f1248a + "c/u/feed/otherpost";
            }
            this.f = new com.baidu.tieba.util.am(str);
            this.f.a("type", String.valueOf(this.b));
            this.f.a("pn", String.valueOf(this.c));
            if (!z) {
                this.f.a(PushConstants.EXTRA_USER_ID, this.e);
            }
            String l = this.f.l();
            if (this.f.c()) {
                if (z && this.d == 0) {
                    b(l);
                    return l;
                }
                return l;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "", "MyPostAsyncTask.doInBackground error = " + e.getMessage());
            return null;
        }
    }

    private void b(String str) {
        com.baidu.adp.lib.cache.s<String> m;
        String B = TiebaApplication.B();
        if (B != null && (m = com.baidu.tieba.b.a.a().m()) != null) {
            m.a(B, str, 604800000L);
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
        this.f2349a.f.e();
        this.f2349a.f.b(strArr[0]);
        this.f2349a.e.notifyDataSetChanged();
        if (this.e != null && !this.e.equals(TiebaApplication.B()) && !this.f2349a.f.c()) {
            this.f2349a.c.setVisibility(8);
            this.f2349a.d.setVisibility(8);
            this.f2349a.b.setVisibility(8);
            this.f2349a.showToast(this.f2349a.getString(R.string.his_post_not_available));
            handler = this.f2349a.k;
            handler2 = this.f2349a.k;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 2000L);
            return;
        }
        if (this.f2349a.f.d().size() == 0) {
            this.f2349a.c.setVisibility(8);
            this.f2349a.d.setVisibility(8);
            this.f2349a.b.setVisibility(0);
        } else {
            this.f2349a.c.setVisibility(0);
            this.f2349a.d.setVisibility(0);
            this.f2349a.b.setVisibility(8);
            if (this.d == 0) {
                this.f2349a.c.setSelection(0);
            }
        }
        progressBar = this.f2349a.h;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        Handler handler;
        Handler handler2;
        this.f2349a.g = null;
        this.f2349a.i = false;
        progressBar = this.f2349a.h;
        progressBar.setVisibility(8);
        if (this.f != null) {
            try {
                if (str != null) {
                    if (this.d == 0) {
                        this.f2349a.f.e();
                    }
                    this.f2349a.f.b(str);
                    this.f2349a.e.notifyDataSetChanged();
                    if (this.e != null && !this.e.equals(TiebaApplication.B()) && !this.f2349a.f.c()) {
                        this.f2349a.c.setVisibility(8);
                        this.f2349a.d.setVisibility(8);
                        this.f2349a.b.setVisibility(8);
                        this.f2349a.showToast(this.f2349a.getString(R.string.his_post_not_available));
                        handler = this.f2349a.k;
                        handler2 = this.f2349a.k;
                        handler.sendMessageDelayed(handler2.obtainMessage(1), 2000L);
                        return;
                    } else if (this.f2349a.f.d().size() == 0) {
                        this.f2349a.c.setVisibility(8);
                        this.f2349a.d.setVisibility(8);
                        this.f2349a.b.setVisibility(0);
                        return;
                    } else {
                        this.f2349a.c.setVisibility(0);
                        this.f2349a.d.setVisibility(0);
                        this.f2349a.b.setVisibility(8);
                        if (this.d == 0) {
                            this.f2349a.c.setSelection(0);
                            return;
                        }
                        return;
                    }
                }
                this.f2349a.showToast(this.f.i());
            } catch (Exception e) {
                com.baidu.tieba.util.bd.b(getClass().getName(), "", "MyPostAsyncTask.onPostExecute error = " + e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.f != null) {
            this.f.j();
        }
        this.f2349a.g = null;
        this.f2349a.i = false;
        this.f2349a.e.notifyDataSetChanged();
        progressBar = this.f2349a.h;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
