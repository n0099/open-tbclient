package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long jBg = BdKVCache.MILLS_1Hour;
    private Context context;
    private a jBn;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat jBi = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat jBh = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes5.dex */
    public interface a {
        void eD(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.jBi.setTimeZone(timeZone);
        this.jBh.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.jBn = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> eh = e.eh(this.context);
        e.c("/sdcard", eh, false);
        e.c("/sdcard/DCIM", eh, true);
        e.eF(eh);
        return eh;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: p */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.jBn != null) {
            this.jBn.eD(list);
        }
    }
}
