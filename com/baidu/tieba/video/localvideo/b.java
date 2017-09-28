package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.d;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long gwU = 3600000;
    private Context context;
    private a gxb;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat gwW = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat gwV = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes2.dex */
    public interface a {
        void dA(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(d.f.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.gwW.setTimeZone(timeZone);
        this.gwV.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.gxb = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public List<d> doInBackground(Void... voidArr) {
        List<d> ca = e.ca(this.context);
        e.d("/sdcard", ca, false);
        e.d("/sdcard/DCIM", ca, true);
        e.dC(ca);
        return ca;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(List<d> list) {
        super.onPostExecute((b) list);
        if (this.gxb != null) {
            this.gxb.dA(list);
        }
    }
}
