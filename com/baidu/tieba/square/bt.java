package com.baidu.tieba.square;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.BarSuggestModel;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt extends BdAsyncTask<Object, Integer, BarSuggestModel> {
    BasicNameValuePair a;
    final /* synthetic */ SquareSearchActivity b;
    private com.baidu.tieba.util.at c = null;
    private String d;

    public bt(SquareSearchActivity squareSearchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
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
        progressBar = this.b.u;
        progressBar.setVisibility(0);
        textView = this.b.x;
        textView.setVisibility(8);
        frameLayout = this.b.n;
        frameLayout.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public BarSuggestModel a(Object... objArr) {
        try {
            this.c = new com.baidu.tieba.util.at(this.d);
            this.c.a(this.a);
            String l = this.c.l();
            if (l == null) {
                return null;
            }
            return BarSuggestModel.parserJson(l);
        } catch (Exception e) {
            com.baidu.tieba.util.bo.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(BarSuggestModel barSuggestModel) {
        ProgressBar progressBar;
        progressBar = this.b.u;
        progressBar.setVisibility(8);
        if (barSuggestModel != null) {
            this.b.y = barSuggestModel;
            this.b.i();
        } else if (this.c != null) {
        }
        this.b.A = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
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
