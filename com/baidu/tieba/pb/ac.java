package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.pb.ImagePbActivity;
import com.baidu.tieba.view.ImagePbPagerAdapter;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BdAsyncTask<Object, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2040a;
    private com.baidu.tieba.util.ag b;
    private ArrayList<BasicNameValuePair> c;
    private String d;
    private boolean f;
    private String e = null;
    private boolean g = false;

    public ac(ImagePbActivity imagePbActivity, String str, ArrayList<BasicNameValuePair> arrayList, boolean z) {
        this.f2040a = imagePbActivity;
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
        this.b = new com.baidu.tieba.util.ag(this.d);
        this.b.a(this.c);
        this.e = this.b.j();
        return this.e;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        this.f2040a.f2031a = null;
        this.f2040a.a(false);
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
        super.a((ac) str);
        if (!this.g) {
            if (this.b != null && this.b.d() && this.f2040a.H != null) {
                if (this.b.c()) {
                    if (!this.f2040a.H.a()) {
                        this.f2040a.H.a(this.e, true);
                    }
                    com.baidu.tieba.util.be.a(getClass().getName(), "onPostExecute", "" + this.f2040a.H.h().size());
                    com.baidu.tieba.data.ac acVar2 = this.f2040a.H;
                    str2 = this.f2040a.D;
                    acVar2.c(str2);
                    imagePbPagerAdapter = this.f2040a.A;
                    imagePbPagerAdapter.a(this.f2040a.H);
                    imagePbPagerAdapter2 = this.f2040a.A;
                    imagePbPagerAdapter2.notifyDataSetChanged();
                    myOnPageChangeListener = this.f2040a.L;
                    myOnPageChangeListener.onPageSelected(this.f2040a.K);
                    z = this.f2040a.C;
                    if (z) {
                        this.f2040a.Q.removeCallbacks(this.f2040a.R);
                        this.f2040a.Q.post(this.f2040a.R);
                    } else if (this.f) {
                        this.f2040a.d(1);
                    } else {
                        this.f2040a.d(2);
                    }
                    this.f2040a.e();
                    if (this.f2040a.K >= this.f2040a.H.h().size() && this.f2040a.K < this.f2040a.H.k() && this.f2040a.H.h().size() < this.f2040a.H.k()) {
                        this.f2040a.a(this.f2040a.H.l(), 0, 10, false);
                    }
                } else {
                    this.f2040a.a(this.f2040a.getString(R.string.pb_nodata));
                    if (this.f) {
                        acVar = this.f2040a.I;
                        if (acVar != null) {
                            this.f2040a.a_(0);
                        }
                    }
                    this.f2040a.finish();
                }
            }
            this.f2040a.f2031a = null;
            this.f2040a.a(false);
        }
    }
}
