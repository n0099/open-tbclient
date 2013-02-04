package com.baidu.tieba.pb;

import android.os.AsyncTask;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ImagePbActivity;
import com.baidu.tieba.view.ImagePbPagerAdapter;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends AsyncTask {
    final /* synthetic */ ImagePbActivity a;
    private com.baidu.tieba.c.t b;
    private ArrayList c;
    private String d;
    private boolean f;
    private String e = null;
    private boolean g = false;

    public ab(ImagePbActivity imagePbActivity, String str, ArrayList arrayList, boolean z) {
        this.a = imagePbActivity;
        this.c = null;
        this.d = null;
        this.f = false;
        this.d = str;
        this.c = arrayList;
        this.f = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        this.b = new com.baidu.tieba.c.t(this.d);
        this.b.a(this.c);
        this.e = this.b.i();
        return this.e;
    }

    public void a() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.b = null;
        this.a.a(false);
        this.g = true;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        com.baidu.tieba.a.u uVar;
        ImagePbPagerAdapter imagePbPagerAdapter;
        ImagePbPagerAdapter imagePbPagerAdapter2;
        ImagePbActivity.MyOnPageChangeListener myOnPageChangeListener;
        boolean z;
        super.onPostExecute(str);
        if (this.g) {
            return;
        }
        if (this.b == null || !this.b.c() || this.a.F == null) {
            this.a.b(this.a.getString(R.string.neterror));
        } else if (this.b.b()) {
            if (!this.a.F.a()) {
                this.a.F.a(this.e, true);
            }
            imagePbPagerAdapter = this.a.y;
            imagePbPagerAdapter.a(this.a.F);
            imagePbPagerAdapter2 = this.a.y;
            imagePbPagerAdapter2.notifyDataSetChanged();
            myOnPageChangeListener = this.a.J;
            myOnPageChangeListener.a(this.a.I);
            z = this.a.A;
            if (z) {
                this.a.O.removeCallbacks(this.a.P);
                this.a.O.post(this.a.P);
            } else if (this.f) {
                this.a.b(1);
            } else {
                this.a.b(2);
            }
            this.a.j();
            if (this.a.I >= this.a.F.h().size() && this.a.I < this.a.F.k() && this.a.F.h().size() < this.a.F.k()) {
                this.a.a(this.a.F.l(), 0, 10, false);
            }
        } else {
            this.a.b(this.a.getString(R.string.pb_nodata));
            if (this.f) {
                uVar = this.a.G;
                if (uVar != null) {
                    this.a.a(0);
                }
            }
            this.a.finish();
        }
        this.a.b = null;
        this.a.a(false);
    }
}
