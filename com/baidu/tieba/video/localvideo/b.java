package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.d;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long gRV = 3600000;
    private Context context;
    private a gSc;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat gRX = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat gRW = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes2.dex */
    public interface a {
        void dQ(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(d.e.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.gRX.setTimeZone(timeZone);
        this.gRW.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.gSc = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> ci = e.ci(this.context);
        e.d("/sdcard", ci, false);
        e.d("/sdcard/DCIM", ci, true);
        e.dS(ci);
        return ci;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.gSc != null) {
            this.gSc.dQ(list);
        }
    }
}
