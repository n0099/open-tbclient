package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long jzJ = 3600000;
    private Context context;
    private a jzQ;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat jzL = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat jzK = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes5.dex */
    public interface a {
        void eq(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(R.dimen.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.jzL.setTimeZone(timeZone);
        this.jzK.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.jzQ = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> er = e.er(this.context);
        e.c("/sdcard", er, false);
        e.c("/sdcard/DCIM", er, true);
        e.es(er);
        return er;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: P */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.jzQ != null) {
            this.jzQ.eq(list);
        }
    }
}
