package com.baidu.tieba.recommend;

import android.os.AsyncTask;
import com.baidu.tieba.LabelActivity;
import com.baidu.tieba.c.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends AsyncTask {
    final /* synthetic */ NewHomeActivity a;
    private com.baidu.tieba.c.t b = null;
    private String c;

    public r(NewHomeActivity newHomeActivity, String str) {
        this.a = newHomeActivity;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        boolean z = true;
        try {
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/tag/edit_tag");
            if (this.c == null || this.c.length() == 0) {
                return false;
            }
            this.b.a("add_tag_id_list", this.c);
            this.b.a("st_type", LabelActivity.c);
            this.b.d(true);
            this.b.i();
            if (!this.b.c() || !this.b.b()) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception e) {
            ag.b(getClass().getName(), "", "AddFanAsyncTask.doInBackground error = " + e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        this.a.x = null;
        if (this.b != null && bool.booleanValue()) {
            com.baidu.tieba.c.k.a("", 12);
        }
    }
}
