package com.baidu.tieba.mainentrance;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.BarSuggestModel;
import com.baidu.tieba.util.ba;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class af extends BdAsyncTask<Object, Integer, BarSuggestModel> {
    BasicNameValuePair a;
    final /* synthetic */ SquareSearchActivity b;
    private ba c = null;
    private String d;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ BarSuggestModel a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(BarSuggestModel barSuggestModel) {
        ProgressBar progressBar;
        BarSuggestModel barSuggestModel2 = barSuggestModel;
        progressBar = this.b.u;
        progressBar.setVisibility(8);
        if (barSuggestModel2 != null) {
            this.b.y = barSuggestModel2;
            SquareSearchActivity.g(this.b);
        }
        this.b.A = null;
    }

    public af(SquareSearchActivity squareSearchActivity, String str, BasicNameValuePair basicNameValuePair) {
        this.b = squareSearchActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = basicNameValuePair;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        ProgressBar progressBar;
        TextView textView;
        FrameLayout frameLayout;
        progressBar = this.b.u;
        progressBar.setVisibility(0);
        textView = this.b.x;
        textView.setVisibility(8);
        frameLayout = this.b.n;
        frameLayout.setVisibility(8);
    }

    private BarSuggestModel d() {
        try {
            this.c = new ba(this.d);
            this.c.a(this.a);
            String l = this.c.l();
            if (l == null) {
                return null;
            }
            return BarSuggestModel.parserJson(l);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.j();
            this.c = null;
        }
        progressBar = this.b.u;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
