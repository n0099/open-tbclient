package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes7.dex */
public class a extends BdAsyncTask<Void, Void, List<b>> {
    private static long nRz = BdKVCache.MILLS_1Hour;
    private Context context;
    private int maxHeight;
    private int maxWidth;
    private InterfaceC0897a nRA;
    private SimpleDateFormat nRC = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat nRB = new SimpleDateFormat("HH:mm:ss");

    /* renamed from: com.baidu.tieba.video.localvideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0897a {
        void fZ(List<b> list);
    }

    public a(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.nRC.setTimeZone(timeZone);
        this.nRB.setTimeZone(timeZone);
    }

    public void a(InterfaceC0897a interfaceC0897a) {
        this.nRA = interfaceC0897a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<b> doInBackground(Void... voidArr) {
        List<b> ha = c.ha(this.context);
        c.f("/sdcard", ha, false);
        c.f("/sdcard/DCIM", ha, true);
        c.ga(ha);
        return ha;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: B */
    public void onPostExecute(List<b> list) {
        super.onPostExecute(list);
        if (this.nRA != null) {
            this.nRA.fZ(list);
        }
    }
}
