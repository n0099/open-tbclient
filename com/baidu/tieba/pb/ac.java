package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.pb.ImagePbActivity;
import com.baidu.tieba.view.ImagePbPagerAdapter;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1443a;
    private com.baidu.tieba.util.u b;
    private ArrayList c;
    private String d;
    private boolean f;
    private String e = null;
    private boolean g = false;

    public ac(ImagePbActivity imagePbActivity, String str, ArrayList arrayList, boolean z) {
        this.f1443a = imagePbActivity;
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
        this.b = new com.baidu.tieba.util.u(this.d);
        this.b.a(this.c);
        this.e = this.b.k();
        return this.e;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.i();
        }
        this.f1443a.f1435a = null;
        this.f1443a.a(false);
        this.g = true;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0056: INVOKE  (r3v3 int A[REMOVE]) = 
      (wrap: java.util.LinkedList : 0x0052: INVOKE  (r3v2 java.util.LinkedList A[REMOVE]) = 
      (wrap: com.baidu.tieba.data.aa : 0x004e: IGET  (r3v1 com.baidu.tieba.data.aa A[REMOVE]) = 
      (wrap: com.baidu.tieba.pb.ImagePbActivity : 0x004c: IGET  (r3v0 com.baidu.tieba.pb.ImagePbActivity A[REMOVE]) = (r6v0 'this' com.baidu.tieba.pb.ac A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.pb.ac.a com.baidu.tieba.pb.ImagePbActivity)
     com.baidu.tieba.pb.ImagePbActivity.H com.baidu.tieba.data.aa)
     type: VIRTUAL call: com.baidu.tieba.data.aa.h():java.util.LinkedList)
     type: VIRTUAL call: java.util.LinkedList.size():int)] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.tieba.data.aa aaVar;
        String str2;
        ImagePbPagerAdapter imagePbPagerAdapter;
        ImagePbPagerAdapter imagePbPagerAdapter2;
        ImagePbActivity.MyOnPageChangeListener myOnPageChangeListener;
        boolean z;
        super.a((Object) str);
        if (!this.g) {
            if (this.b != null && this.b.e() && this.f1443a.H != null) {
                if (this.b.d()) {
                    if (!this.f1443a.H.a()) {
                        this.f1443a.H.a(this.e, true);
                    }
                    com.baidu.tieba.util.aj.a(getClass().getName(), "onPostExecute", new StringBuilder().append(this.f1443a.H.h().size()).toString());
                    com.baidu.tieba.data.aa aaVar2 = this.f1443a.H;
                    str2 = this.f1443a.D;
                    aaVar2.c(str2);
                    imagePbPagerAdapter = this.f1443a.A;
                    imagePbPagerAdapter.a(this.f1443a.H);
                    imagePbPagerAdapter2 = this.f1443a.A;
                    imagePbPagerAdapter2.notifyDataSetChanged();
                    myOnPageChangeListener = this.f1443a.L;
                    myOnPageChangeListener.a_(this.f1443a.K);
                    z = this.f1443a.C;
                    if (z) {
                        this.f1443a.Q.removeCallbacks(this.f1443a.R);
                        this.f1443a.Q.post(this.f1443a.R);
                    } else if (this.f) {
                        this.f1443a.b(1);
                    } else {
                        this.f1443a.b(2);
                    }
                    this.f1443a.k();
                    if (this.f1443a.K >= this.f1443a.H.h().size() && this.f1443a.K < this.f1443a.H.k() && this.f1443a.H.h().size() < this.f1443a.H.k()) {
                        this.f1443a.a(this.f1443a.H.l(), 0, 10, false);
                    }
                } else {
                    this.f1443a.a(this.f1443a.getString(R.string.pb_nodata));
                    if (this.f) {
                        aaVar = this.f1443a.I;
                        if (aaVar != null) {
                            this.f1443a.b_(0);
                        }
                    }
                    this.f1443a.finish();
                }
            } else {
                this.f1443a.a(this.f1443a.getString(R.string.neterror));
            }
            this.f1443a.f1435a = null;
            this.f1443a.a(false);
        }
    }
}
