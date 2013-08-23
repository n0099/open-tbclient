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
    final /* synthetic */ AllPostActivity f1641a;
    private int b;
    private int c;
    private int d;
    private String e;
    private com.baidu.tieba.util.v f;

    public c(AllPostActivity allPostActivity, int i, int i2, int i3, String str) {
        this.f1641a = allPostActivity;
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
        com.baidu.adp.lib.cache.q h;
        String str2;
        boolean z = true;
        try {
            int intValue = numArr[0].intValue();
            if (this.e != null && !this.e.equals(TiebaApplication.E())) {
                z = false;
            }
            if (intValue == 0 && z && (h = com.baidu.tieba.b.a.a().h()) != null && (str2 = (String) h.a(TiebaApplication.E())) != null) {
                c((Object[]) new String[]{str2});
            }
            if (z) {
                str = String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/u/feed/mypost";
            } else {
                str = String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/u/feed/otherpost";
            }
            this.f = new com.baidu.tieba.util.v(str);
            this.f.a("type", String.valueOf(this.b));
            this.f.a("pn", String.valueOf(this.c));
            if (!z) {
                this.f.a(PushConstants.EXTRA_USER_ID, this.e);
            }
            String j = this.f.j();
            if (this.f.c()) {
                if (z && this.d == 0) {
                    b(j);
                    return j;
                }
                return j;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "", "MyPostAsyncTask.doInBackground error = " + e.getMessage());
            return null;
        }
    }

    private void b(String str) {
        com.baidu.adp.lib.cache.q h;
        String E = TiebaApplication.E();
        if (E != null && (h = com.baidu.tieba.b.a.a().h()) != null) {
            h.a(E, str, 604800000L);
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
        this.f1641a.f.e();
        this.f1641a.f.b(strArr[0]);
        this.f1641a.e.notifyDataSetChanged();
        if (this.e != null && !this.e.equals(TiebaApplication.E()) && !this.f1641a.f.c()) {
            this.f1641a.c.setVisibility(8);
            this.f1641a.d.setVisibility(8);
            this.f1641a.b.setVisibility(8);
            this.f1641a.a(this.f1641a.getString(R.string.his_post_not_available));
            handler = this.f1641a.m;
            handler2 = this.f1641a.m;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 2000L);
            return;
        }
        if (this.f1641a.f.d().size() == 0) {
            this.f1641a.c.setVisibility(8);
            this.f1641a.d.setVisibility(8);
            this.f1641a.b.setVisibility(0);
        } else {
            this.f1641a.c.setVisibility(0);
            this.f1641a.d.setVisibility(0);
            this.f1641a.b.setVisibility(8);
            if (this.d == 0) {
                this.f1641a.c.setSelection(0);
            }
        }
        progressBar = this.f1641a.j;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        Handler handler;
        Handler handler2;
        this.f1641a.g = null;
        this.f1641a.k = false;
        progressBar = this.f1641a.j;
        progressBar.setVisibility(8);
        if (this.f != null) {
            try {
                if (str != null) {
                    if (this.d == 0) {
                        this.f1641a.f.e();
                    }
                    this.f1641a.f.b(str);
                    this.f1641a.e.notifyDataSetChanged();
                    if (this.e != null && !this.e.equals(TiebaApplication.E()) && !this.f1641a.f.c()) {
                        this.f1641a.c.setVisibility(8);
                        this.f1641a.d.setVisibility(8);
                        this.f1641a.b.setVisibility(8);
                        this.f1641a.a(this.f1641a.getString(R.string.his_post_not_available));
                        handler = this.f1641a.m;
                        handler2 = this.f1641a.m;
                        handler.sendMessageDelayed(handler2.obtainMessage(1), 2000L);
                        return;
                    } else if (this.f1641a.f.d().size() == 0) {
                        this.f1641a.c.setVisibility(8);
                        this.f1641a.d.setVisibility(8);
                        this.f1641a.b.setVisibility(0);
                        return;
                    } else {
                        this.f1641a.c.setVisibility(0);
                        this.f1641a.d.setVisibility(0);
                        this.f1641a.b.setVisibility(8);
                        if (this.d == 0) {
                            this.f1641a.c.setSelection(0);
                            return;
                        }
                        return;
                    }
                }
                this.f1641a.a(this.f.g());
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b(getClass().getName(), "", "MyPostAsyncTask.onPostExecute error = " + e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.f != null) {
            this.f.h();
        }
        this.f1641a.g = null;
        this.f1641a.k = false;
        this.f1641a.e.notifyDataSetChanged();
        progressBar = this.f1641a.j;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
