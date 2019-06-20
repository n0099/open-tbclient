package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long jsu = 3600000;
    private Context context;
    private a jsB;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat jsw = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat jsv = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes5.dex */
    public interface a {
        void eo(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.jsw.setTimeZone(timeZone);
        this.jsv.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.jsB = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> ep = e.ep(this.context);
        e.c("/sdcard", ep, false);
        e.c("/sdcard/DCIM", ep, true);
        e.eq(ep);
        return ep;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: P */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.jsB != null) {
            this.jsB.eo(list);
        }
    }
}
