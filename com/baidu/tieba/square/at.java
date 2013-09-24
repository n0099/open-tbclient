package com.baidu.tieba.square;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.ay> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<BasicNameValuePair> f1831a;
    final /* synthetic */ SquareSearchActivity b;
    private com.baidu.tieba.util.z c = null;
    private String d;

    public at(SquareSearchActivity squareSearchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.b = squareSearchActivity;
        this.d = null;
        this.f1831a = null;
        this.d = str;
        this.f1831a = arrayList;
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
    public com.baidu.tieba.data.ay a(Object... objArr) {
        com.baidu.tieba.data.ay ayVar;
        Exception e;
        String str;
        try {
            this.c = new com.baidu.tieba.util.z(this.d);
            Iterator<BasicNameValuePair> it = this.f1831a.iterator();
            while (it.hasNext()) {
                this.c.a(it.next());
            }
            String j = this.c.j();
            if (!this.c.c() || j == null) {
                return null;
            }
            ayVar = new com.baidu.tieba.data.ay();
            try {
                ayVar.a(j);
                str = this.b.E;
                DatabaseService.m(str);
                return ayVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.av.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return ayVar;
            }
        } catch (Exception e3) {
            ayVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.ay ayVar) {
        ProgressBar progressBar;
        com.baidu.tieba.home.ao aoVar;
        com.baidu.tieba.home.ao aoVar2;
        com.baidu.tieba.home.ao aoVar3;
        progressBar = this.b.w;
        progressBar.setVisibility(8);
        aoVar = this.b.v;
        aoVar.a(0);
        aoVar2 = this.b.v;
        aoVar2.notifyDataSetChanged();
        if (ayVar != null && this.c != null && this.c.c()) {
            this.b.B = ayVar;
            aoVar3 = this.b.v;
            aoVar3.notifyDataSetChanged();
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
