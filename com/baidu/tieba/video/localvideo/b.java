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
    private static long mgT = BdKVCache.MILLS_1Hour;
    private Context context;
    private int maxHeight;
    private int maxWidth;
    private a mha;
    private SimpleDateFormat mgV = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat mgU = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes17.dex */
    public interface a {
        void fh(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.mgV.setTimeZone(timeZone);
        this.mgU.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.mha = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> fx = e.fx(this.context);
        e.c("/sdcard", fx, false);
        e.c("/sdcard/DCIM", fx, true);
        e.fj(fx);
        return fx;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: x */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.mha != null) {
            this.mha.fh(list);
        }
    }
}
