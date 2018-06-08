package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.d;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long hbt = 3600000;
    private Context context;
    private a hbA;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat hbv = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat hbu = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes2.dex */
    public interface a {
        void dJ(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(d.e.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hbv.setTimeZone(timeZone);
        this.hbu.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.hbA = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public List<d> doInBackground(Void... voidArr) {
        List<d> co = e.co(this.context);
        e.c("/sdcard", co, false);
        e.c("/sdcard/DCIM", co, true);
        e.dL(co);
        return co;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: q */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.hbA != null) {
            this.hbA.dJ(list);
        }
    }
}
