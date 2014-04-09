package com.baidu.tieba.mainentrance;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.data.SearchPostModel;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ac extends BdAsyncTask<Object, Integer, SearchPostModel> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ SquareSearchActivity b;
    private ak c = null;
    private String d;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ SearchPostModel a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(SearchPostModel searchPostModel) {
        ProgressBar progressBar;
        c cVar;
        c cVar2;
        c cVar3;
        SearchPostModel searchPostModel2 = searchPostModel;
        progressBar = this.b.q;
        progressBar.setVisibility(8);
        cVar = this.b.p;
        cVar.a(0);
        cVar2 = this.b.p;
        cVar2.notifyDataSetChanged();
        if (searchPostModel2 == null || this.c == null || !this.c.a().b().b()) {
            this.b.showToast(this.b.getString(com.baidu.tieba.a.k.neterror));
        } else {
            this.b.v = searchPostModel2;
            cVar3 = this.b.p;
            cVar3.notifyDataSetChanged();
            SquareSearchActivity.h(this.b);
        }
        this.b.x = null;
    }

    public ac(SquareSearchActivity squareSearchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.b = squareSearchActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        TextView textView;
        EditText editText;
        ListView listView;
        ProgressBar progressBar;
        textView = this.b.t;
        textView.setVisibility(8);
        SquareSearchActivity squareSearchActivity = this.b;
        editText = this.b.c;
        com.baidu.adp.lib.util.i.a(squareSearchActivity, editText);
        listView = this.b.m;
        if (listView.getVisibility() != 0) {
            progressBar = this.b.q;
            progressBar.setVisibility(0);
        }
    }

    private SearchPostModel a() {
        SearchPostModel searchPostModel;
        Exception e;
        String str;
        try {
            this.c = new ak(this.d);
            Iterator<BasicNameValuePair> it = this.a.iterator();
            while (it.hasNext()) {
                this.c.a(it.next());
            }
            String i = this.c.i();
            if (!this.c.a().b().b() || i == null) {
                return null;
            }
            searchPostModel = new SearchPostModel();
            try {
                searchPostModel.parserJson(i);
                str = this.b.y;
                com.baidu.tieba.util.k.g(str);
                return searchPostModel;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.util.f.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return searchPostModel;
            }
        } catch (Exception e3) {
            searchPostModel = null;
            e = e3;
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
        this.b.x = null;
        super.cancel(true);
    }
}
