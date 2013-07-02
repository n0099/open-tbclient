package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.pb.ImagePbActivity;
import com.baidu.tieba.view.ImagePbPagerAdapter;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BdAsyncTask {
    final /* synthetic */ ImagePbActivity a;
    private com.baidu.tieba.util.r b;
    private ArrayList c;
    private String d;
    private boolean f;
    private String e = null;
    private boolean g = false;

    public ac(ImagePbActivity imagePbActivity, String str, ArrayList arrayList, boolean z) {
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
        this.b = new com.baidu.tieba.util.r(this.d);
        this.b.a(this.c);
        this.e = this.b.j();
        return this.e;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        this.a.a = null;
        this.a.a(false);
        this.g = true;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0056: INVOKE  (r3v3 int A[REMOVE]) = 
      (wrap: java.util.LinkedList : 0x0052: INVOKE  (r3v2 java.util.LinkedList A[REMOVE]) = 
      (wrap: com.baidu.tieba.data.w : 0x004e: IGET  (r3v1 com.baidu.tieba.data.w A[REMOVE]) = 
      (wrap: com.baidu.tieba.pb.ImagePbActivity : 0x004c: IGET  (r3v0 com.baidu.tieba.pb.ImagePbActivity A[REMOVE]) = (r6v0 'this' com.baidu.tieba.pb.ac A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.pb.ac.a com.baidu.tieba.pb.ImagePbActivity)
     com.baidu.tieba.pb.ImagePbActivity.H com.baidu.tieba.data.w)
     type: VIRTUAL call: com.baidu.tieba.data.w.h():java.util.LinkedList)
     type: VIRTUAL call: java.util.LinkedList.size():int)] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.tieba.data.w wVar;
        String str2;
        ImagePbPagerAdapter imagePbPagerAdapter;
        ImagePbPagerAdapter imagePbPagerAdapter2;
        ImagePbActivity.MyOnPageChangeListener myOnPageChangeListener;
        boolean z;
        super.a((Object) str);
        if (!this.g) {
            if (this.b != null && this.b.d() && this.a.H != null) {
                if (this.b.c()) {
                    if (!this.a.H.a()) {
                        this.a.H.a(this.e, true);
                    }
                    com.baidu.tieba.util.z.a(getClass().getName(), "onPostExecute", new StringBuilder().append(this.a.H.h().size()).toString());
                    com.baidu.tieba.data.w wVar2 = this.a.H;
                    str2 = this.a.D;
                    wVar2.c(str2);
                    imagePbPagerAdapter = this.a.A;
                    imagePbPagerAdapter.a(this.a.H);
                    imagePbPagerAdapter2 = this.a.A;
                    imagePbPagerAdapter2.notifyDataSetChanged();
                    myOnPageChangeListener = this.a.L;
                    myOnPageChangeListener.a_(this.a.K);
                    z = this.a.C;
                    if (z) {
                        this.a.Q.removeCallbacks(this.a.R);
                        this.a.Q.post(this.a.R);
                    } else if (this.f) {
                        this.a.b(1);
                    } else {
                        this.a.b(2);
                    }
                    this.a.m();
                    if (this.a.K >= this.a.H.h().size() && this.a.K < this.a.H.k() && this.a.H.h().size() < this.a.H.k()) {
                        this.a.a(this.a.H.l(), 0, 10, false);
                    }
                } else {
                    this.a.a(this.a.getString(R.string.pb_nodata));
                    if (this.f) {
                        wVar = this.a.I;
                        if (wVar != null) {
                            this.a.b_(0);
                        }
                    }
                    this.a.finish();
                }
            } else {
                this.a.a(this.a.getString(R.string.neterror));
            }
            this.a.a = null;
            this.a.a(false);
        }
    }
}
