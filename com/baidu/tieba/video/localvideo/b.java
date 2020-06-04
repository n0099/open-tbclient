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
    private static long lFL = BdKVCache.MILLS_1Hour;
    private Context context;
    private a lFS;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat lFN = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat lFM = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes10.dex */
    public interface a {
        void eO(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.lFN.setTimeZone(timeZone);
        this.lFM.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.lFS = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> fu = e.fu(this.context);
        e.c("/sdcard", fu, false);
        e.c("/sdcard/DCIM", fu, true);
        e.eQ(fu);
        return fu;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: r */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.lFS != null) {
            this.lFS.eO(list);
        }
    }
}
