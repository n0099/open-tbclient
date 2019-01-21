package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.e;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long hJi = 3600000;
    private Context context;
    private a hJp;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat hJk = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat hJj = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes5.dex */
    public interface a {
        void eb(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(e.C0210e.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hJk.setTimeZone(timeZone);
        this.hJj.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.hJp = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public List<d> doInBackground(Void... voidArr) {
        List<d> de = e.de(this.context);
        e.c("/sdcard", de, false);
        e.c("/sdcard/DCIM", de, true);
        e.ed(de);
        return de;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: y */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.hJp != null) {
            this.hJp.eb(list);
        }
    }
}
