package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes10.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long kBv = BdKVCache.MILLS_1Hour;
    private Context context;
    private a kBC;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat kBx = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat kBw = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes10.dex */
    public interface a {
        void eq(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.kBx.setTimeZone(timeZone);
        this.kBw.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.kBC = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> fz = e.fz(this.context);
        e.b("/sdcard", fz, false);
        e.b("/sdcard/DCIM", fz, true);
        e.es(fz);
        return fz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: o */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.kBC != null) {
            this.kBC.eq(list);
        }
    }
}
