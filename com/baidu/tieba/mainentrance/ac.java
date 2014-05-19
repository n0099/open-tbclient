package com.baidu.tieba.mainentrance;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.data.SearchPostModel;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BdAsyncTask<Object, Integer, SearchPostModel> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ SquareSearchActivity b;
    private al c = null;
    private String d;

    public ac(SquareSearchActivity squareSearchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
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
        textView = this.b.t;
        textView.setVisibility(8);
        SquareSearchActivity squareSearchActivity = this.b;
        editText = this.b.c;
        com.baidu.adp.lib.util.h.a(squareSearchActivity, editText);
        listView = this.b.m;
        if (listView.getVisibility() != 0) {
            progressBar = this.b.q;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public SearchPostModel doInBackground(Object... objArr) {
        SearchPostModel searchPostModel;
        Exception e;
        String str;
        try {
            this.c = new al(this.d);
            Iterator<BasicNameValuePair> it = this.a.iterator();
            while (it.hasNext()) {
                this.c.a(it.next());
            }
            String i = this.c.i();
            if (!this.c.a().b().a() || i == null) {
                return null;
            }
            searchPostModel = new SearchPostModel();
            try {
                searchPostModel.parserJson(i);
                if (this.c.a().b().b()) {
                    str = this.b.y;
                    com.baidu.tieba.util.k.g(str);
                    return searchPostModel;
                }
                return searchPostModel;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return searchPostModel;
            }
        } catch (Exception e3) {
            searchPostModel = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(SearchPostModel searchPostModel) {
        ProgressBar progressBar;
        c cVar;
        c cVar2;
        c cVar3;
        progressBar = this.b.q;
        progressBar.setVisibility(8);
        cVar = this.b.p;
        cVar.a(0);
        cVar2 = this.b.p;
        cVar2.notifyDataSetChanged();
        if (searchPostModel == null || this.c == null || !this.c.a().b().a()) {
            this.b.showToast(this.b.getString(com.baidu.tieba.u.neterror));
        } else if (this.c.a().b().b()) {
            this.b.v = searchPostModel;
            cVar3 = this.b.p;
            cVar3.notifyDataSetChanged();
            this.b.l();
        } else {
            this.b.showToast(this.c.f());
        }
        this.b.x = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
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
