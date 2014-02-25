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
public class aj extends BdAsyncTask<Object, Integer, SearchPostModel> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ SquareSearchActivity b;
    private ba c = null;
    private String d;

    public aj(SquareSearchActivity squareSearchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.b = squareSearchActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public SearchPostModel a(Object... objArr) {
        SearchPostModel searchPostModel;
        Exception e;
        String str;
        try {
            this.c = new ba(this.d);
            Iterator<BasicNameValuePair> it = this.a.iterator();
            while (it.hasNext()) {
                this.c.a(it.next());
            }
            String m = this.c.m();
            if (!this.c.d() || m == null) {
                return null;
            }
            searchPostModel = new SearchPostModel();
            try {
                searchPostModel.parserJson(m);
                str = this.b.C;
                DatabaseService.k(str);
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(SearchPostModel searchPostModel) {
        ProgressBar progressBar;
        k kVar;
        k kVar2;
        k kVar3;
        progressBar = this.b.u;
        progressBar.setVisibility(8);
        kVar = this.b.t;
        kVar.a(0);
        kVar2 = this.b.t;
        kVar2.notifyDataSetChanged();
        if (searchPostModel != null && this.c != null && this.c.d()) {
            this.b.z = searchPostModel;
            kVar3 = this.b.t;
            kVar3.notifyDataSetChanged();
            this.b.i();
        } else {
            this.b.showToast(this.b.getString(R.string.neterror));
        }
        this.b.B = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.k();
            this.c = null;
        }
        progressBar = this.b.u;
        progressBar.setVisibility(8);
        this.b.B = null;
        super.cancel(true);
    }
}
