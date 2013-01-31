package com.baidu.tieba.more;

import android.os.AsyncTask;
import com.baidu.tieba.R;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends AsyncTask {
    final /* synthetic */ MoreActivity a;

    private af(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ af(MoreActivity moreActivity, af afVar) {
        this(moreActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        this.a.L = null;
        this.a.d();
        this.a.b(this.a.getString(R.string.image_cash_del_suc));
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.a.a(this.a.getString(R.string.deleting));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        com.baidu.tieba.c.k.y();
        try {
            File[] listFiles = new File(com.baidu.tieba.c.o.a + "/tieba/image/").listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (!file.delete()) {
                        com.baidu.tieba.c.af.b(getClass().getName(), "doInBackground", "list[i].delete error");
                    }
                }
            }
            File[] listFiles2 = new File(com.baidu.tieba.c.o.a + "/tieba/hotspot/").listFiles();
            if (listFiles2 != null) {
                for (File file2 : listFiles2) {
                    if (!file2.delete()) {
                        com.baidu.tieba.c.af.b(getClass().getName(), "doInBackground", "list[i].delete error");
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }
}
