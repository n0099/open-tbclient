package com.baidu.tieba.person;

import android.os.Handler;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends BdAsyncTask<Integer, String, String> {
    final /* synthetic */ AllPostActivity a;
    private int b = 0;
    private int c;
    private int d;
    private String e;
    private com.baidu.tieba.util.ba f;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        ProgressBar progressBar;
        Handler handler;
        Handler handler2;
        String str2 = str;
        this.a.g = null;
        this.a.i = false;
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        if (this.f != null) {
            try {
                if (str2 == null) {
                    this.a.showToast(this.f.i());
                    return;
                }
                if (this.d == 0) {
                    this.a.f.e();
                }
                this.a.f.b(str2);
                this.a.e.notifyDataSetChanged();
                if (this.e != null && !this.e.equals(TiebaApplication.v()) && !this.a.f.c()) {
                    this.a.c.setVisibility(8);
                    this.a.d.setVisibility(8);
                    this.a.b.setVisibility(8);
                    this.a.showToast(this.a.getString(R.string.his_post_not_available));
                    handler = this.a.k;
                    handler2 = this.a.k;
                    handler.sendMessageDelayed(handler2.obtainMessage(1), 2000L);
                } else if (this.a.f.d().size() == 0) {
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
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "", "MyPostAsyncTask.onPostExecute error = " + e.getMessage());
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(String... strArr) {
        ProgressBar progressBar;
        Handler handler;
        Handler handler2;
        this.a.f.e();
        this.a.f.b(strArr[0]);
        this.a.e.notifyDataSetChanged();
        if (this.e == null || this.e.equals(TiebaApplication.v()) || this.a.f.c()) {
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
            return;
        }
        this.a.c.setVisibility(8);
        this.a.d.setVisibility(8);
        this.a.b.setVisibility(8);
        this.a.showToast(this.a.getString(R.string.his_post_not_available));
        handler = this.a.k;
        handler2 = this.a.k;
        handler.sendMessageDelayed(handler2.obtainMessage(1), 2000L);
    }

    public c(AllPostActivity allPostActivity, int i, int i2, int i3, String str) {
        this.a = allPostActivity;
        this.e = null;
        this.c = i2;
        this.d = i3;
        this.e = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Integer... numArr) {
        String str;
        String v;
        com.baidu.adp.lib.cache.s<String> m;
        com.baidu.adp.lib.cache.s<String> m2;
        String a;
        boolean z = true;
        try {
            int intValue = numArr[0].intValue();
            if (this.e != null && !this.e.equals(TiebaApplication.v())) {
                z = false;
            }
            if (intValue == 0 && z && (m2 = com.baidu.tieba.c.a.a().m()) != null && (a = m2.a(TiebaApplication.v())) != null) {
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
            String l = this.f.l();
            if (this.f.c()) {
                if (!z || this.d != 0 || (v = TiebaApplication.v()) == null || (m = com.baidu.tieba.c.a.a().m()) == null) {
                    return l;
                }
                m.a(v, l, 604800000L);
                return l;
            }
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "", "MyPostAsyncTask.doInBackground error = " + e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        if (this.f != null) {
            this.f.j();
        }
        this.a.g = null;
        this.a.i = false;
        this.a.e.notifyDataSetChanged();
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
