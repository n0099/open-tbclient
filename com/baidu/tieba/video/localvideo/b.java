package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes8.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long kyF = BdKVCache.MILLS_1Hour;
    private Context context;
    private a kyM;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat kyH = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat kyG = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes8.dex */
    public interface a {
        void ev(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.kyH.setTimeZone(timeZone);
        this.kyG.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.kyM = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> fA = e.fA(this.context);
        e.b("/sdcard", fA, false);
        e.b("/sdcard/DCIM", fA, true);
        e.ex(fA);
        return fA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: o */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.kyM != null) {
            this.kyM.ev(list);
        }
    }
}
