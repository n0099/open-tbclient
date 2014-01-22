package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.pb.ImagePbActivity;
import com.baidu.tieba.view.ImagePbPagerAdapter;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ ImagePbActivity a;
    private com.baidu.tieba.util.ax b;
    private ArrayList<BasicNameValuePair> c;
    private String d;
    private boolean f;
    private String e = null;
    private boolean g = false;

    public ab(ImagePbActivity imagePbActivity, String str, ArrayList<BasicNameValuePair> arrayList, boolean z) {
        this.a = imagePbActivity;
        this.c = null;
        this.d = null;
        this.f = false;
        this.d = str;
        this.c = arrayList;
        this.f = z;
        setSelfExecute(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public String a(Object... objArr) {
        this.b = new com.baidu.tieba.util.ax(this.d);
        this.b.a(this.c);
        this.e = this.b.m();
        return this.e;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.k();
        }
        this.a.b = null;
        this.a.a(false);
        this.g = true;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.tieba.data.ac acVar;
        String str2;
        ImagePbPagerAdapter imagePbPagerAdapter;
        ImagePbPagerAdapter imagePbPagerAdapter2;
        ImagePbActivity.MyOnPageChangeListener myOnPageChangeListener;
        boolean z;
        super.a((ab) str);
        if (!this.g) {
            if (this.b != null && this.b.e() && this.a.G != null) {
                if (this.b.d()) {
                    if (!this.a.G.a()) {
                        this.a.G.a(this.e, true);
                    }
                    com.baidu.adp.lib.g.e.a(getClass().getName(), "onPostExecute", "" + this.a.G.h().size());
                    com.baidu.tieba.data.ac acVar2 = this.a.G;
                    str2 = this.a.C;
                    acVar2.c(str2);
                    imagePbPagerAdapter = this.a.z;
                    imagePbPagerAdapter.a(this.a.G);
                    imagePbPagerAdapter2 = this.a.z;
                    imagePbPagerAdapter2.notifyDataSetChanged();
                    myOnPageChangeListener = this.a.K;
                    myOnPageChangeListener.a_(this.a.J);
                    z = this.a.B;
                    if (z) {
                        this.a.R.removeCallbacks(this.a.S);
                        this.a.R.post(this.a.S);
                    } else if (this.f) {
                        this.a.b(1);
                    } else {
                        this.a.b(2);
                    }
                    this.a.d();
                    if (this.a.J >= this.a.G.h().size() && this.a.J < this.a.G.k() && this.a.G.h().size() < this.a.G.k()) {
                        this.a.a(this.a.G.l(), 0, 10, false);
                    }
                } else {
                    this.a.showToast(this.a.getString(R.string.pb_nodata));
                    if (this.f) {
                        acVar = this.a.H;
                        if (acVar != null) {
                            this.a.a(0);
                        }
                    }
                    this.a.finish();
                }
            }
            this.a.b = null;
            this.a.a(false);
        }
    }
}
