package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.e;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long hoE = 3600000;
    private Context context;
    private a hoL;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat hoG = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat hoF = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes2.dex */
    public interface a {
        void dJ(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(e.C0141e.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hoG.setTimeZone(timeZone);
        this.hoF.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.hoL = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public List<d> doInBackground(Void... voidArr) {
        List<d> cT = e.cT(this.context);
        e.b("/sdcard", cT, false);
        e.b("/sdcard/DCIM", cT, true);
        e.dL(cT);
        return cT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: p */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.hoL != null) {
            this.hoL.dJ(list);
        }
    }
}
