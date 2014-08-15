package com.baidu.tieba.mainentrance;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.model.BarSuggestModel;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<Object, Integer, BarSuggestModel> {
    BasicNameValuePair a;
    final /* synthetic */ SquareSearchActivity b;
    private com.baidu.tbadk.core.util.ae c = null;
    private String d;

    public ag(SquareSearchActivity squareSearchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.b = squareSearchActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = basicNameValuePair;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        TextView textView;
        FrameLayout frameLayout;
        progressBar = this.b.p;
        progressBar.setVisibility(0);
        textView = this.b.s;
        textView.setVisibility(8);
        frameLayout = this.b.i;
        frameLayout.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public BarSuggestModel doInBackground(Object... objArr) {
        BarSuggestModel barSuggestModel = null;
        try {
            this.c = new com.baidu.tbadk.core.util.ae(this.d);
            this.c.a(this.a);
            String h = this.c.h();
            if (h == null) {
                return null;
            }
            barSuggestModel = BarSuggestModel.parserJson(h);
            this.b.A = this.a.getValue();
            return barSuggestModel;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return barSuggestModel;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(BarSuggestModel barSuggestModel) {
        ProgressBar progressBar;
        progressBar = this.b.p;
        progressBar.setVisibility(8);
        if (barSuggestModel != null) {
            this.b.u = barSuggestModel;
            this.b.o();
        }
        this.b.w = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.f();
            this.c = null;
        }
        progressBar = this.b.p;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
