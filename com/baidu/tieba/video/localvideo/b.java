package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.d;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long gwF = 3600000;
    private Context context;
    private a gwM;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat gwH = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat gwG = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes2.dex */
    public interface a {
        void dA(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(d.f.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.gwH.setTimeZone(timeZone);
        this.gwG.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.gwM = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> bZ = e.bZ(this.context);
        e.d("/sdcard", bZ, false);
        e.d("/sdcard/DCIM", bZ, true);
        e.dC(bZ);
        return bZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(List<d> list) {
        super.onPostExecute((b) list);
        if (this.gwM != null) {
            this.gwM.dA(list);
        }
    }
}
