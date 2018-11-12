package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.e;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long hxD = 3600000;
    private Context context;
    private a hxK;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat hxF = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat hxE = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes5.dex */
    public interface a {
        void dV(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(e.C0200e.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hxF.setTimeZone(timeZone);
        this.hxE.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.hxK = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public List<d> doInBackground(Void... voidArr) {
        List<d> da = e.da(this.context);
        e.c("/sdcard", da, false);
        e.c("/sdcard/DCIM", da, true);
        e.dX(da);
        return da;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: y */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.hxK != null) {
            this.hxK.dV(list);
        }
    }
}
