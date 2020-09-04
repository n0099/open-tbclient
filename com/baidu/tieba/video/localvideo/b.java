package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes17.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long myX = BdKVCache.MILLS_1Hour;
    private Context context;
    private int maxHeight;
    private int maxWidth;
    private a mze;
    private SimpleDateFormat myZ = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat myY = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes17.dex */
    public interface a {
        void fp(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.myZ.setTimeZone(timeZone);
        this.myY.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.mze = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> fK = e.fK(this.context);
        e.d("/sdcard", fK, false);
        e.d("/sdcard/DCIM", fK, true);
        e.fr(fK);
        return fK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: y */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.mze != null) {
            this.mze.fp(list);
        }
    }
}
