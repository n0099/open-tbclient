package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes23.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long nGb = BdKVCache.MILLS_1Hour;
    private Context context;
    private int maxHeight;
    private int maxWidth;
    private a nGi;
    private SimpleDateFormat nGd = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat nGc = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes23.dex */
    public interface a {
        void gg(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.nGd.setTimeZone(timeZone);
        this.nGc.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.nGi = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> gI = e.gI(this.context);
        e.d("/sdcard", gI, false);
        e.d("/sdcard/DCIM", gI, true);
        e.gi(gI);
        return gI;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: B */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.nGi != null) {
            this.nGi.gg(list);
        }
    }
}
