package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.e;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long hvT = 3600000;
    private Context context;
    private a hwa;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat hvV = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat hvU = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes5.dex */
    public interface a {
        void dX(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(e.C0175e.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hvV.setTimeZone(timeZone);
        this.hvU.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.hwa = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public List<d> doInBackground(Void... voidArr) {
        List<d> df = e.df(this.context);
        e.b("/sdcard", df, false);
        e.b("/sdcard/DCIM", df, true);
        e.dZ(df);
        return df;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: z */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.hwa != null) {
            this.hwa.dX(list);
        }
    }
}
