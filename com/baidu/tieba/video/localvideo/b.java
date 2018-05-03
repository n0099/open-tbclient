package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.d;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long gOO = 3600000;
    private Context context;
    private a gOV;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat gOQ = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat gOP = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes2.dex */
    public interface a {
        void dB(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(d.e.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.gOQ.setTimeZone(timeZone);
        this.gOP.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.gOV = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public List<d> doInBackground(Void... voidArr) {
        List<d> cd = e.cd(this.context);
        e.c("/sdcard", cd, false);
        e.c("/sdcard/DCIM", cd, true);
        e.dD(cd);
        return cd;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.gOV != null) {
            this.gOV.dB(list);
        }
    }
}
