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
    private static long lEC = BdKVCache.MILLS_1Hour;
    private Context context;
    private a lEJ;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat lEE = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat lED = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes10.dex */
    public interface a {
        void eM(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.lEE.setTimeZone(timeZone);
        this.lED.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.lEJ = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> fu = e.fu(this.context);
        e.c("/sdcard", fu, false);
        e.c("/sdcard/DCIM", fu, true);
        e.eO(fu);
        return fu;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: r */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.lEJ != null) {
            this.lEJ.eM(list);
        }
    }
}
