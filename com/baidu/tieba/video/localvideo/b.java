package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.f;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long hgO = 3600000;
    private Context context;
    private a hgV;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat hgQ = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat hgP = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes2.dex */
    public interface a {
        void dI(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(f.e.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hgQ.setTimeZone(timeZone);
        this.hgP.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.hgV = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public List<d> doInBackground(Void... voidArr) {
        List<d> cm = e.cm(this.context);
        e.b("/sdcard", cm, false);
        e.b("/sdcard/DCIM", cm, true);
        e.dK(cm);
        return cm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: p */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.hgV != null) {
            this.hgV.dI(list);
        }
    }
}
