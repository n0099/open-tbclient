package com.baidu.tieba.square;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq extends BdAsyncTask<Object, Integer, SearchPostModel> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<BasicNameValuePair> f2396a;
    final /* synthetic */ SquareSearchActivity b;
    private com.baidu.tieba.util.ap c = null;
    private String d;

    public bq(SquareSearchActivity squareSearchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.b = squareSearchActivity;
        this.d = null;
        this.f2396a = null;
        this.d = str;
        this.f2396a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        TextView textView;
        EditText editText;
        ListView listView;
        ProgressBar progressBar;
        textView = this.b.w;
        textView.setVisibility(8);
        SquareSearchActivity squareSearchActivity = this.b;
        editText = this.b.c;
        UtilHelper.a(squareSearchActivity, editText);
        listView = this.b.p;
        if (listView.getVisibility() != 0) {
            progressBar = this.b.t;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public SearchPostModel a(Object... objArr) {
        SearchPostModel searchPostModel;
        Exception e;
        String str;
        try {
            this.c = new com.baidu.tieba.util.ap(this.d);
            Iterator<BasicNameValuePair> it = this.f2396a.iterator();
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
                str = this.b.B;
                DatabaseService.n(str);
                return searchPostModel;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.bg.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
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
    public void a(SearchPostModel searchPostModel) {
        ProgressBar progressBar;
        com.baidu.tieba.home.bd bdVar;
        com.baidu.tieba.home.bd bdVar2;
        com.baidu.tieba.home.bd bdVar3;
        progressBar = this.b.t;
        progressBar.setVisibility(8);
        bdVar = this.b.s;
        bdVar.a(0);
        bdVar2 = this.b.s;
        bdVar2.notifyDataSetChanged();
        if (searchPostModel != null && this.c != null && this.c.c()) {
            this.b.y = searchPostModel;
            bdVar3 = this.b.s;
            bdVar3.notifyDataSetChanged();
            this.b.i();
        } else {
            this.b.showToast(this.b.getString(R.string.neterror));
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
        progressBar = this.b.t;
        progressBar.setVisibility(8);
        this.b.A = null;
        super.cancel(true);
    }
}
