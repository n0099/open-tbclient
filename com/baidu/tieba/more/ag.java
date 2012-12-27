package com.baidu.tieba.more;

import android.os.AsyncTask;
import com.baidu.tieba.R;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends AsyncTask {
    final /* synthetic */ MoreActivity a;

    private ag(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(MoreActivity moreActivity, ag agVar) {
        this(moreActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        com.baidu.tieba.c.k.w();
        try {
            File[] listFiles = new File(com.baidu.tieba.c.o.a + "/tieba/image/").listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (!file.delete()) {
                        com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", "list[i].delete error");
                    }
                }
            }
            File[] listFiles2 = new File(com.baidu.tieba.c.o.a + "/tieba/hotspot/").listFiles();
            if (listFiles2 != null) {
                for (File file2 : listFiles2) {
                    if (!file2.delete()) {
                        com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", "list[i].delete error");
                    }
                }
            }
            File[] fileArr = null;
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        this.a.w = null;
        this.a.c();
        this.a.b(this.a.getString(R.string.image_cash_del_suc));
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.a.a(this.a.getString(R.string.deleting));
    }
}
