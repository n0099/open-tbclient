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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2060a;
    private com.baidu.tieba.util.ap b;
    private ArrayList<BasicNameValuePair> c;
    private String d;
    private boolean f;
    private String e = null;
    private boolean g = false;

    public ab(ImagePbActivity imagePbActivity, String str, ArrayList<BasicNameValuePair> arrayList, boolean z) {
        this.f2060a = imagePbActivity;
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
        this.b = new com.baidu.tieba.util.ap(this.d);
        this.b.a(this.c);
        this.e = this.b.j();
        return this.e;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        this.f2060a.b = null;
        this.f2060a.a(false);
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
            if (this.b != null && this.b.d() && this.f2060a.G != null) {
                if (this.b.c()) {
                    if (!this.f2060a.G.a()) {
                        this.f2060a.G.a(this.e, true);
                    }
                    com.baidu.tieba.util.bg.a(getClass().getName(), "onPostExecute", "" + this.f2060a.G.h().size());
                    com.baidu.tieba.data.ac acVar2 = this.f2060a.G;
                    str2 = this.f2060a.C;
                    acVar2.c(str2);
                    imagePbPagerAdapter = this.f2060a.z;
                    imagePbPagerAdapter.a(this.f2060a.G);
                    imagePbPagerAdapter2 = this.f2060a.z;
                    imagePbPagerAdapter2.notifyDataSetChanged();
                    myOnPageChangeListener = this.f2060a.K;
                    myOnPageChangeListener.onPageSelected(this.f2060a.J);
                    z = this.f2060a.B;
                    if (z) {
                        this.f2060a.Q.removeCallbacks(this.f2060a.R);
                        this.f2060a.Q.post(this.f2060a.R);
                    } else if (this.f) {
                        this.f2060a.b(1);
                    } else {
                        this.f2060a.b(2);
                    }
                    this.f2060a.d();
                    if (this.f2060a.J >= this.f2060a.G.h().size() && this.f2060a.J < this.f2060a.G.k() && this.f2060a.G.h().size() < this.f2060a.G.k()) {
                        this.f2060a.a(this.f2060a.G.l(), 0, 10, false);
                    }
                } else {
                    this.f2060a.showToast(this.f2060a.getString(R.string.pb_nodata));
                    if (this.f) {
                        acVar = this.f2060a.H;
                        if (acVar != null) {
                            this.f2060a.a(0);
                        }
                    }
                    this.f2060a.finish();
                }
            }
            this.f2060a.b = null;
            this.f2060a.a(false);
        }
    }
}
