package com.baidu.tieba.square;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.BarSuggestModel;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br extends BdAsyncTask<Object, Integer, BarSuggestModel> {

    /* renamed from: a  reason: collision with root package name */
    BasicNameValuePair f2412a;
    final /* synthetic */ SquareSearchActivity b;
    private com.baidu.tieba.util.ap c = null;
    private String d;

    public br(SquareSearchActivity squareSearchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.b = squareSearchActivity;
        this.d = null;
        this.f2412a = null;
        this.d = str;
        this.f2412a = basicNameValuePair;
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
            this.c = new com.baidu.tieba.util.ap(this.d);
            this.c.a(this.f2412a);
            String j = this.c.j();
            if (j == null) {
                return null;
            }
            return BarSuggestModel.parserJson(j);
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
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
            this.c.h();
            this.c = null;
        }
        progressBar = this.b.t;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
