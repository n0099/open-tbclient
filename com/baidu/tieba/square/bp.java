package com.baidu.tieba.square;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.BarSuggestModel;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends BdAsyncTask<Object, Integer, BarSuggestModel> {
    BasicNameValuePair a;
    final /* synthetic */ SquareSearchActivity b;
    private com.baidu.tieba.util.an c = null;
    private String d;

    public bp(SquareSearchActivity squareSearchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.b = squareSearchActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = basicNameValuePair;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        TextView textView;
        FrameLayout frameLayout;
        progressBar = this.b.t;
        progressBar.setVisibility(0);
        textView = this.b.w;
        textView.setVisibility(8);
        frameLayout = this.b.m;
        frameLayout.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public BarSuggestModel a(Object... objArr) {
        try {
            this.c = new com.baidu.tieba.util.an(this.d);
            this.c.a(this.a);
            String l = this.c.l();
            if (l == null) {
                return null;
            }
            return BarSuggestModel.parserJson(l);
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(BarSuggestModel barSuggestModel) {
        ProgressBar progressBar;
        progressBar = this.b.t;
        progressBar.setVisibility(8);
        if (barSuggestModel != null) {
            this.b.x = barSuggestModel;
            this.b.i();
        } else if (this.c != null) {
        }
        this.b.z = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.j();
            this.c = null;
        }
        progressBar = this.b.t;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
