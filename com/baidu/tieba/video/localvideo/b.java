package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long jCf = 3600000;
    private Context context;
    private a jCm;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat jCh = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat jCg = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes5.dex */
    public interface a {
        void eq(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.jCh.setTimeZone(timeZone);
        this.jCg.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.jCm = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> es = e.es(this.context);
        e.c("/sdcard", es, false);
        e.c("/sdcard/DCIM", es, true);
        e.es(es);
        return es;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: P */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.jCm != null) {
            this.jCm.eq(list);
        }
    }
}
