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
    private static long mYu = BdKVCache.MILLS_1Hour;
    private Context context;
    private a mYB;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat mYw = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat mYv = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes23.dex */
    public interface a {
        void fB(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.mYw.setTimeZone(timeZone);
        this.mYv.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.mYB = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> fX = e.fX(this.context);
        e.d("/sdcard", fX, false);
        e.d("/sdcard/DCIM", fX, true);
        e.fD(fX);
        return fX;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: A */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.mYB != null) {
            this.mYB.fB(list);
        }
    }
}
