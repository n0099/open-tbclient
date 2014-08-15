package com.baidu.tieba.mainentrance;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.data.SearchPostModel;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends BdAsyncTask<Object, Integer, SearchPostModel> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ SquareSearchActivity b;
    private com.baidu.tbadk.core.util.ae c = null;
    private String d;

    public ah(SquareSearchActivity squareSearchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.b = squareSearchActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        TextView textView;
        EditText editText;
        ListView listView;
        ProgressBar progressBar;
        textView = this.b.s;
        textView.setVisibility(8);
        SquareSearchActivity squareSearchActivity = this.b;
        editText = this.b.c;
        com.baidu.adp.lib.util.j.a(squareSearchActivity, editText);
        listView = this.b.l;
        if (listView.getVisibility() != 0) {
            progressBar = this.b.p;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public SearchPostModel doInBackground(Object... objArr) {
        Exception exc;
        SearchPostModel searchPostModel;
        String str;
        try {
            this.c = new com.baidu.tbadk.core.util.ae(this.d);
            Iterator<BasicNameValuePair> it = this.a.iterator();
            while (it.hasNext()) {
                this.c.a(it.next());
            }
            String h = this.c.h();
            if (!this.c.a().b().a() || h == null) {
                return null;
            }
            SearchPostModel searchPostModel2 = new SearchPostModel();
            try {
                searchPostModel2.parserJson(h);
                Iterator<BasicNameValuePair> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    BasicNameValuePair next = it2.next();
                    if ("word".equals(next.getName())) {
                        this.b.B = next.getValue();
                    }
                }
                if (this.c.a().b().b()) {
                    str = this.b.y;
                    com.baidu.tieba.util.k.f(str);
                    return searchPostModel2;
                }
                return searchPostModel2;
            } catch (Exception e) {
                searchPostModel = searchPostModel2;
                exc = e;
                BdLog.e(exc.getMessage());
                return searchPostModel;
            }
        } catch (Exception e2) {
            exc = e2;
            searchPostModel = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(SearchPostModel searchPostModel) {
        ProgressBar progressBar;
        e eVar;
        e eVar2;
        e eVar3;
        progressBar = this.b.p;
        progressBar.setVisibility(8);
        eVar = this.b.o;
        eVar.a(0);
        eVar2 = this.b.o;
        eVar2.notifyDataSetChanged();
        if (searchPostModel == null || this.c == null || !this.c.a().b().a()) {
            this.b.showToast(this.b.getString(com.baidu.tieba.x.neterror));
        } else if (this.c.a().b().b()) {
            this.b.v = searchPostModel;
            eVar3 = this.b.o;
            eVar3.notifyDataSetChanged();
            this.b.o();
        } else {
            this.b.showToast(this.c.e());
        }
        this.b.x = null;
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
        this.b.x = null;
        super.cancel(true);
    }
}
