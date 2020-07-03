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
    private static long lZz = BdKVCache.MILLS_1Hour;
    private Context context;
    private a lZG;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat lZB = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat lZA = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes10.dex */
    public interface a {
        void fb(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.lZB.setTimeZone(timeZone);
        this.lZA.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.lZG = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> fu = e.fu(this.context);
        e.c("/sdcard", fu, false);
        e.c("/sdcard/DCIM", fu, true);
        e.fd(fu);
        return fu;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: v */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.lZG != null) {
            this.lZG.fb(list);
        }
    }
}
