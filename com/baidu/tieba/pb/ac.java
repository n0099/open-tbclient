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
    final /* synthetic */ ImagePbActivity f1523a;
    private com.baidu.tieba.util.z b;
    private ArrayList<BasicNameValuePair> c;
    private String d;
    private boolean f;
    private String e = null;
    private boolean g = false;

    public ac(ImagePbActivity imagePbActivity, String str, ArrayList<BasicNameValuePair> arrayList, boolean z) {
        this.f1523a = imagePbActivity;
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
        this.b = new com.baidu.tieba.util.z(this.d);
        this.b.a(this.c);
        this.e = this.b.j();
        return this.e;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        this.f1523a.f1514a = null;
        this.f1523a.a(false);
        this.g = true;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0056: INVOKE  (r3v3 int A[REMOVE]) = 
      (wrap: java.util.LinkedList<com.baidu.tieba.data.ab> : 0x0052: INVOKE  (r3v2 java.util.LinkedList<com.baidu.tieba.data.ab> A[REMOVE]) = 
      (wrap: com.baidu.tieba.data.ac : 0x004e: IGET  (r3v1 com.baidu.tieba.data.ac A[REMOVE]) = 
      (wrap: com.baidu.tieba.pb.ImagePbActivity : 0x004c: IGET  (r3v0 com.baidu.tieba.pb.ImagePbActivity A[REMOVE]) = (r6v0 'this' com.baidu.tieba.pb.ac A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.pb.ac.a com.baidu.tieba.pb.ImagePbActivity)
     com.baidu.tieba.pb.ImagePbActivity.H com.baidu.tieba.data.ac)
     type: VIRTUAL call: com.baidu.tieba.data.ac.h():java.util.LinkedList)
     type: VIRTUAL call: java.util.LinkedList.size():int)] */
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
            if (this.b != null && this.b.d() && this.f1523a.H != null) {
                if (this.b.c()) {
                    if (!this.f1523a.H.a()) {
                        this.f1523a.H.a(this.e, true);
                    }
                    com.baidu.tieba.util.av.a(getClass().getName(), "onPostExecute", new StringBuilder().append(this.f1523a.H.h().size()).toString());
                    com.baidu.tieba.data.ac acVar2 = this.f1523a.H;
                    str2 = this.f1523a.D;
                    acVar2.c(str2);
                    imagePbPagerAdapter = this.f1523a.A;
                    imagePbPagerAdapter.a(this.f1523a.H);
                    imagePbPagerAdapter2 = this.f1523a.A;
                    imagePbPagerAdapter2.notifyDataSetChanged();
                    myOnPageChangeListener = this.f1523a.L;
                    myOnPageChangeListener.a_(this.f1523a.K);
                    z = this.f1523a.C;
                    if (z) {
                        this.f1523a.Q.removeCallbacks(this.f1523a.R);
                        this.f1523a.Q.post(this.f1523a.R);
                    } else if (this.f) {
                        this.f1523a.b(1);
                    } else {
                        this.f1523a.b(2);
                    }
                    this.f1523a.e();
                    if (this.f1523a.K >= this.f1523a.H.h().size() && this.f1523a.K < this.f1523a.H.k() && this.f1523a.H.h().size() < this.f1523a.H.k()) {
                        this.f1523a.a(this.f1523a.H.l(), 0, 10, false);
                    }
                } else {
                    this.f1523a.a(this.f1523a.getString(R.string.pb_nodata));
                    if (this.f) {
                        acVar = this.f1523a.I;
                        if (acVar != null) {
                            this.f1523a.b_(0);
                        }
                    }
                    this.f1523a.finish();
                }
            }
            this.f1523a.f1514a = null;
            this.f1523a.a(false);
        }
    }
}
