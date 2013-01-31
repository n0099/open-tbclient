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
        this.a.c = null;
        this.a.a(false);
        this.g = true;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        com.baidu.tieba.a.v vVar;
        ImagePbPagerAdapter imagePbPagerAdapter;
        ImagePbPagerAdapter imagePbPagerAdapter2;
        ImagePbActivity.MyOnPageChangeListener myOnPageChangeListener;
        boolean z;
        super.onPostExecute(str);
        if (!this.g) {
            if (this.b != null && this.b.c() && this.a.H != null) {
                if (this.b.b()) {
                    if (!this.a.H.a()) {
                        this.a.H.a(this.e, true);
                    }
                    imagePbPagerAdapter = this.a.A;
                    imagePbPagerAdapter.a(this.a.H);
                    imagePbPagerAdapter2 = this.a.A;
                    imagePbPagerAdapter2.notifyDataSetChanged();
                    myOnPageChangeListener = this.a.L;
                    myOnPageChangeListener.a(this.a.K);
                    z = this.a.C;
                    if (z) {
                        this.a.Q.removeCallbacks(this.a.R);
                        this.a.Q.post(this.a.R);
                    } else if (this.f) {
                        this.a.c(1);
                    } else {
                        this.a.c(2);
                    }
                    this.a.l();
                    if (this.a.K >= this.a.H.h().size() && this.a.K < this.a.H.k() && this.a.H.h().size() < this.a.H.k()) {
                        this.a.a(this.a.H.l(), 0, 10, false);
                    }
                } else {
                    this.a.b(this.a.getString(R.string.pb_nodata));
                    if (this.f) {
                        vVar = this.a.I;
                        if (vVar != null) {
                            this.a.a(0);
                        }
                    }
                    this.a.finish();
                }
            } else {
                this.a.b(this.a.getString(R.string.neterror));
            }
            this.a.c = null;
            this.a.a(false);
        }
    }
}
