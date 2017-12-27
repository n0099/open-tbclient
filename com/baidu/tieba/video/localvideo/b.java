package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.d;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long hBN = 3600000;
    private Context context;
    private a hBU;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat hBP = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat hBO = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes2.dex */
    public interface a {
        void dV(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(d.e.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hBP.setTimeZone(timeZone);
        this.hBO.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.hBU = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> cs = e.cs(this.context);
        e.c("/sdcard", cs, false);
        e.c("/sdcard/DCIM", cs, true);
        e.dX(cs);
        return cs;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: w */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.hBU != null) {
            this.hBU.dV(list);
        }
    }
}
