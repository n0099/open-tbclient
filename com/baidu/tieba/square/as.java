package com.baidu.tieba.square;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.BarSuggestModel;
import com.baidu.tieba.util.be;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends BdAsyncTask<Object, Integer, BarSuggestModel> {

    /* renamed from: a  reason: collision with root package name */
    BasicNameValuePair f2351a;
    final /* synthetic */ SquareSearchActivity b;
    private com.baidu.tieba.util.ag c = null;
    private String d;

    public as(SquareSearchActivity squareSearchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.b = squareSearchActivity;
        this.d = null;
        this.f2351a = null;
        this.d = str;
        this.f2351a = basicNameValuePair;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        TextView textView;
        FrameLayout frameLayout;
        progressBar = this.b.w;
        progressBar.setVisibility(0);
        textView = this.b.z;
        textView.setVisibility(8);
        frameLayout = this.b.p;
        frameLayout.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public BarSuggestModel a(Object... objArr) {
        try {
            this.c = new com.baidu.tieba.util.ag(this.d);
            this.c.a(this.f2351a);
            String j = this.c.j();
            if (j == null) {
                return null;
            }
            return BarSuggestModel.parserJson(j);
        } catch (Exception e) {
            be.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(BarSuggestModel barSuggestModel) {
        ProgressBar progressBar;
        progressBar = this.b.w;
        progressBar.setVisibility(8);
        if (barSuggestModel != null) {
            this.b.A = barSuggestModel;
            this.b.q();
        } else if (this.c != null) {
        }
        this.b.C = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.h();
            this.c = null;
        }
        progressBar = this.b.w;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
