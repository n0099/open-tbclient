package com.baidu.tieba.mainentrance;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.model.BarSuggestModel;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab extends BdAsyncTask<Object, Integer, BarSuggestModel> {
    BasicNameValuePair a;
    final /* synthetic */ SquareSearchActivity b;
    private ak c = null;
    private String d;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ BarSuggestModel a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(BarSuggestModel barSuggestModel) {
        ProgressBar progressBar;
        BarSuggestModel barSuggestModel2 = barSuggestModel;
        progressBar = this.b.q;
        progressBar.setVisibility(8);
        if (barSuggestModel2 != null) {
            this.b.u = barSuggestModel2;
            SquareSearchActivity.h(this.b);
        }
        this.b.w = null;
    }

    public ab(SquareSearchActivity squareSearchActivity, String str, BasicNameValuePair basicNameValuePair) {
        this.b = squareSearchActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = basicNameValuePair;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        ProgressBar progressBar;
        TextView textView;
        FrameLayout frameLayout;
        progressBar = this.b.q;
        progressBar.setVisibility(0);
        textView = this.b.t;
        textView.setVisibility(8);
        frameLayout = this.b.j;
        frameLayout.setVisibility(8);
    }

    private BarSuggestModel a() {
        try {
            this.c = new ak(this.d);
            this.c.a(this.a);
            String i = this.c.i();
            if (i == null) {
                return null;
            }
            return BarSuggestModel.parserJson(i);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.g();
            this.c = null;
        }
        progressBar = this.b.q;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
