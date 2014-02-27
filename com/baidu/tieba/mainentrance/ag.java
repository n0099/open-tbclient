package com.baidu.tieba.mainentrance;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.ba;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ag extends BdAsyncTask<Object, Integer, SearchPostModel> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ SquareSearchActivity b;
    private ba c = null;
    private String d;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ SearchPostModel a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(SearchPostModel searchPostModel) {
        ProgressBar progressBar;
        h hVar;
        h hVar2;
        h hVar3;
        SearchPostModel searchPostModel2 = searchPostModel;
        progressBar = this.b.u;
        progressBar.setVisibility(8);
        hVar = this.b.t;
        hVar.a(0);
        hVar2 = this.b.t;
        hVar2.notifyDataSetChanged();
        if (searchPostModel2 == null || this.c == null || !this.c.c()) {
            this.b.showToast(this.b.getString(R.string.neterror));
        } else {
            this.b.z = searchPostModel2;
            hVar3 = this.b.t;
            hVar3.notifyDataSetChanged();
            SquareSearchActivity.g(this.b);
        }
        this.b.B = null;
    }

    public ag(SquareSearchActivity squareSearchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.b = squareSearchActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        TextView textView;
        EditText editText;
        ListView listView;
        ProgressBar progressBar;
        textView = this.b.x;
        textView.setVisibility(8);
        SquareSearchActivity squareSearchActivity = this.b;
        editText = this.b.c;
        BdUtilHelper.a(squareSearchActivity, editText);
        listView = this.b.q;
        if (listView.getVisibility() != 0) {
            progressBar = this.b.u;
            progressBar.setVisibility(0);
        }
    }

    private SearchPostModel d() {
        SearchPostModel searchPostModel;
        Exception e;
        String str;
        try {
            this.c = new ba(this.d);
            Iterator<BasicNameValuePair> it = this.a.iterator();
            while (it.hasNext()) {
                this.c.a(it.next());
            }
            String l = this.c.l();
            if (!this.c.c() || l == null) {
                return null;
            }
            searchPostModel = new SearchPostModel();
            try {
                searchPostModel.parserJson(l);
                str = this.b.C;
                DatabaseService.i(str);
                return searchPostModel;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.util.e.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
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
            this.c.j();
            this.c = null;
        }
        progressBar = this.b.u;
        progressBar.setVisibility(8);
        this.b.B = null;
        super.cancel(true);
    }
}
