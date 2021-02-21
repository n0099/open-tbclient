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
    private static long nPu = BdKVCache.MILLS_1Hour;
    private Context context;
    private int maxHeight;
    private int maxWidth;
    private InterfaceC0891a nPv;
    private SimpleDateFormat nPx = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat nPw = new SimpleDateFormat("HH:mm:ss");

    /* renamed from: com.baidu.tieba.video.localvideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0891a {
        void fZ(List<b> list);
    }

    public a(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.nPx.setTimeZone(timeZone);
        this.nPw.setTimeZone(timeZone);
    }

    public void a(InterfaceC0891a interfaceC0891a) {
        this.nPv = interfaceC0891a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<b> doInBackground(Void... voidArr) {
        List<b> hb = c.hb(this.context);
        c.f("/sdcard", hb, false);
        c.f("/sdcard/DCIM", hb, true);
        c.ga(hb);
        return hb;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: B */
    public void onPostExecute(List<b> list) {
        super.onPostExecute(list);
        if (this.nPv != null) {
            this.nPv.fZ(list);
        }
    }
}
