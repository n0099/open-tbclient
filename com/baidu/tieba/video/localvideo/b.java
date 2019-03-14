package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.d;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long iZG = 3600000;
    private Context context;
    private a iZN;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat iZI = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat iZH = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes5.dex */
    public interface a {
        void eh(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(d.e.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.iZI.setTimeZone(timeZone);
        this.iZH.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.iZN = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> ez = e.ez(this.context);
        e.c("/sdcard", ez, false);
        e.c("/sdcard/DCIM", ez, true);
        e.ej(ez);
        return ez;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: I */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.iZN != null) {
            this.iZN.eh(list);
        }
    }
}
