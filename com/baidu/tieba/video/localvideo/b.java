package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.d;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long gHr = 3600000;
    private Context context;
    private a gHy;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat gHt = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat gHs = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes2.dex */
    public interface a {
        void dD(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(d.e.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.gHt.setTimeZone(timeZone);
        this.gHs.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.gHy = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> bZ = e.bZ(this.context);
        e.d("/sdcard", bZ, false);
        e.d("/sdcard/DCIM", bZ, true);
        e.dF(bZ);
        return bZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.gHy != null) {
            this.gHy.dD(list);
        }
    }
}
