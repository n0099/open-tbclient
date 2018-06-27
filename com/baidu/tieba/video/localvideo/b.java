package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.d;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long hfy = 3600000;
    private Context context;
    private a hfF;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat hfA = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat hfz = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes2.dex */
    public interface a {
        void dM(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(d.e.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hfA.setTimeZone(timeZone);
        this.hfz.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.hfF = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public List<d> doInBackground(Void... voidArr) {
        List<d> cm = e.cm(this.context);
        e.c("/sdcard", cm, false);
        e.c("/sdcard/DCIM", cm, true);
        e.dO(cm);
        return cm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: q */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.hfF != null) {
            this.hfF.dM(list);
        }
    }
}
