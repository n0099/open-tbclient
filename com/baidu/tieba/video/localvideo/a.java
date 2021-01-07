package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes8.dex */
public class a extends BdAsyncTask<Void, Void, List<b>> {
    private static long nJO = BdKVCache.MILLS_1Hour;
    private Context context;
    private int maxHeight;
    private int maxWidth;
    private InterfaceC0903a nJP;
    private SimpleDateFormat nJR = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat nJQ = new SimpleDateFormat("HH:mm:ss");

    /* renamed from: com.baidu.tieba.video.localvideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0903a {
        void gb(List<b> list);
    }

    public a(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.nJR.setTimeZone(timeZone);
        this.nJQ.setTimeZone(timeZone);
    }

    public void a(InterfaceC0903a interfaceC0903a) {
        this.nJP = interfaceC0903a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<b> doInBackground(Void... voidArr) {
        List<b> ha = c.ha(this.context);
        c.e("/sdcard", ha, false);
        c.e("/sdcard/DCIM", ha, true);
        c.gc(ha);
        return ha;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: B */
    public void onPostExecute(List<b> list) {
        super.onPostExecute(list);
        if (this.nJP != null) {
            this.nJP.gb(list);
        }
    }
}
