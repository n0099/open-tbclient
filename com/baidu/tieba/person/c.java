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
    final /* synthetic */ AllPostActivity f1689a;
    private int b;
    private int c;
    private int d;
    private String e;
    private com.baidu.tieba.util.z f;

    public c(AllPostActivity allPostActivity, int i, int i2, int i3, String str) {
        this.f1689a = allPostActivity;
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
        com.baidu.adp.lib.cache.q<String> h;
        String a2;
        boolean z = true;
        try {
            int intValue = numArr[0].intValue();
            if (this.e != null && !this.e.equals(TiebaApplication.C())) {
                z = false;
            }
            if (intValue == 0 && z && (h = com.baidu.tieba.b.a.a().h()) != null && (a2 = h.a(TiebaApplication.C())) != null) {
                c((Object[]) new String[]{a2});
            }
            if (z) {
                str = String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/u/feed/mypost";
            } else {
                str = String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/u/feed/otherpost";
            }
            this.f = new com.baidu.tieba.util.z(str);
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
            com.baidu.tieba.util.av.b(getClass().getName(), "", "MyPostAsyncTask.doInBackground error = " + e.getMessage());
            return null;
        }
    }

    private void b(String str) {
        com.baidu.adp.lib.cache.q<String> h;
        String C = TiebaApplication.C();
        if (C != null && (h = com.baidu.tieba.b.a.a().h()) != null) {
            h.a(C, str, 604800000L);
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
        this.f1689a.f.e();
        this.f1689a.f.b(strArr[0]);
        this.f1689a.e.notifyDataSetChanged();
        if (this.e != null && !this.e.equals(TiebaApplication.C()) && !this.f1689a.f.c()) {
            this.f1689a.c.setVisibility(8);
            this.f1689a.d.setVisibility(8);
            this.f1689a.b.setVisibility(8);
            this.f1689a.a(this.f1689a.getString(R.string.his_post_not_available));
            handler = this.f1689a.m;
            handler2 = this.f1689a.m;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 2000L);
            return;
        }
        if (this.f1689a.f.d().size() == 0) {
            this.f1689a.c.setVisibility(8);
            this.f1689a.d.setVisibility(8);
            this.f1689a.b.setVisibility(0);
        } else {
            this.f1689a.c.setVisibility(0);
            this.f1689a.d.setVisibility(0);
            this.f1689a.b.setVisibility(8);
            if (this.d == 0) {
                this.f1689a.c.setSelection(0);
            }
        }
        progressBar = this.f1689a.j;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        Handler handler;
        Handler handler2;
        this.f1689a.g = null;
        this.f1689a.k = false;
        progressBar = this.f1689a.j;
        progressBar.setVisibility(8);
        if (this.f != null) {
            try {
                if (str != null) {
                    if (this.d == 0) {
                        this.f1689a.f.e();
                    }
                    this.f1689a.f.b(str);
                    this.f1689a.e.notifyDataSetChanged();
                    if (this.e != null && !this.e.equals(TiebaApplication.C()) && !this.f1689a.f.c()) {
                        this.f1689a.c.setVisibility(8);
                        this.f1689a.d.setVisibility(8);
                        this.f1689a.b.setVisibility(8);
                        this.f1689a.a(this.f1689a.getString(R.string.his_post_not_available));
                        handler = this.f1689a.m;
                        handler2 = this.f1689a.m;
                        handler.sendMessageDelayed(handler2.obtainMessage(1), 2000L);
                        return;
                    } else if (this.f1689a.f.d().size() == 0) {
                        this.f1689a.c.setVisibility(8);
                        this.f1689a.d.setVisibility(8);
                        this.f1689a.b.setVisibility(0);
                        return;
                    } else {
                        this.f1689a.c.setVisibility(0);
                        this.f1689a.d.setVisibility(0);
                        this.f1689a.b.setVisibility(8);
                        if (this.d == 0) {
                            this.f1689a.c.setSelection(0);
                            return;
                        }
                        return;
                    }
                }
                this.f1689a.a(this.f.g());
            } catch (Exception e) {
                com.baidu.tieba.util.av.b(getClass().getName(), "", "MyPostAsyncTask.onPostExecute error = " + e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.f != null) {
            this.f.h();
        }
        this.f1689a.g = null;
        this.f1689a.k = false;
        this.f1689a.e.notifyDataSetChanged();
        progressBar = this.f1689a.j;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
