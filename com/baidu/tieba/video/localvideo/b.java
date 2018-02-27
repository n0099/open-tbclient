package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.d;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long hsN = 3600000;
    private Context context;
    private a hsU;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat hsP = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat hsO = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes2.dex */
    public interface a {
        void dK(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(d.e.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hsP.setTimeZone(timeZone);
        this.hsO.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.hsU = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> co = e.co(this.context);
        e.c("/sdcard", co, false);
        e.c("/sdcard/DCIM", co, true);
        e.dM(co);
        return co;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: w */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.hsU != null) {
            this.hsU.dK(list);
        }
    }
}
