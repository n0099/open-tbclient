package com.baidu.tieba.video.localvideo;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.d;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class b extends BdAsyncTask<Void, Void, List<d>> {
    private static long gUJ = 3600000;
    private Context context;
    private a gUQ;
    private int maxHeight;
    private int maxWidth;
    private SimpleDateFormat gUL = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat gUK = new SimpleDateFormat("HH:mm:ss");

    /* loaded from: classes2.dex */
    public interface a {
        void dP(List<d> list);
    }

    public b(Context context) {
        this.context = context;
        this.maxHeight = context.getResources().getDimensionPixelSize(d.e.ds220);
        this.maxWidth = this.maxHeight;
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.gUL.setTimeZone(timeZone);
        this.gUK.setTimeZone(timeZone);
    }

    public void b(a aVar) {
        this.gUQ = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public List<d> doInBackground(Void... voidArr) {
        List<d> ch = e.ch(this.context);
        e.d("/sdcard", ch, false);
        e.d("/sdcard/DCIM", ch, true);
        e.dR(ch);
        return ch;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public void onPostExecute(List<d> list) {
        super.onPostExecute(list);
        if (this.gUQ != null) {
            this.gUQ.dP(list);
        }
    }
}
