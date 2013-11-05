package com.baidu.tieba.square;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends BdAsyncTask<Object, Integer, SearchPostModel> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<BasicNameValuePair> f2352a;
    final /* synthetic */ SquareSearchActivity b;
    private com.baidu.tieba.util.ag c = null;
    private String d;

    public at(SquareSearchActivity squareSearchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.b = squareSearchActivity;
        this.d = null;
        this.f2352a = null;
        this.d = str;
        this.f2352a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        TextView textView;
        EditText editText;
        ListView listView;
        ProgressBar progressBar;
        textView = this.b.z;
        textView.setVisibility(8);
        SquareSearchActivity squareSearchActivity = this.b;
        editText = this.b.c;
        UtilHelper.a(squareSearchActivity, editText);
        listView = this.b.s;
        if (listView.getVisibility() != 0) {
            progressBar = this.b.w;
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
            this.c = new com.baidu.tieba.util.ag(this.d);
            Iterator<BasicNameValuePair> it = this.f2352a.iterator();
            while (it.hasNext()) {
                this.c.a(it.next());
            }
            String j = this.c.j();
            if (!this.c.c() || j == null) {
                return null;
            }
            searchPostModel = new SearchPostModel();
            try {
                searchPostModel.parserJson(j);
                str = this.b.E;
                DatabaseService.m(str);
                return searchPostModel;
            } catch (Exception e2) {
                e = e2;
                be.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
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
        com.baidu.tieba.home.au auVar;
        com.baidu.tieba.home.au auVar2;
        com.baidu.tieba.home.au auVar3;
        progressBar = this.b.w;
        progressBar.setVisibility(8);
        auVar = this.b.v;
        auVar.a(0);
        auVar2 = this.b.v;
        auVar2.notifyDataSetChanged();
        if (searchPostModel != null && this.c != null && this.c.c()) {
            this.b.B = searchPostModel;
            auVar3 = this.b.v;
            auVar3.notifyDataSetChanged();
            this.b.q();
        } else {
            this.b.a(this.b.getString(R.string.neterror));
        }
        this.b.D = null;
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
        this.b.D = null;
        super.cancel(true);
    }
}
