package com.baidu.tieba.pb;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ ImagePbActivity a;
    private com.baidu.tieba.util.ba b;
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
        this.b = new com.baidu.tieba.util.ba(this.d);
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
        com.baidu.tieba.data.ab abVar;
        com.baidu.tieba.data.ab abVar2;
        com.baidu.tieba.data.ab abVar3;
        com.baidu.tieba.data.ab abVar4;
        com.baidu.tieba.data.ab abVar5;
        String str2;
        com.baidu.tieba.view.bj bjVar;
        com.baidu.tieba.data.ab abVar6;
        com.baidu.tieba.view.bj bjVar2;
        ac acVar;
        int i;
        boolean z;
        int i2;
        com.baidu.tieba.data.ab abVar7;
        int i3;
        com.baidu.tieba.data.ab abVar8;
        com.baidu.tieba.data.ab abVar9;
        com.baidu.tieba.data.ab abVar10;
        com.baidu.tieba.data.ab abVar11;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        com.baidu.tieba.data.ab abVar12;
        super.a((ab) str);
        if (!this.g) {
            if (this.b != null && this.b.e()) {
                abVar = this.a.G;
                if (abVar != null) {
                    if (this.b.d()) {
                        abVar3 = this.a.G;
                        if (!abVar3.a()) {
                            abVar12 = this.a.G;
                            abVar12.a(this.e, true);
                        }
                        String name = getClass().getName();
                        StringBuilder sb = new StringBuilder();
                        abVar4 = this.a.G;
                        com.baidu.adp.lib.util.f.a(name, "onPostExecute", sb.append(abVar4.h().size()).toString());
                        abVar5 = this.a.G;
                        str2 = this.a.C;
                        abVar5.c(str2);
                        bjVar = this.a.z;
                        abVar6 = this.a.G;
                        bjVar.a(abVar6);
                        bjVar2 = this.a.z;
                        bjVar2.notifyDataSetChanged();
                        acVar = this.a.K;
                        i = this.a.J;
                        acVar.onPageSelected(i);
                        z = this.a.B;
                        if (z) {
                            handler = this.a.R;
                            runnable = this.a.S;
                            handler.removeCallbacks(runnable);
                            handler2 = this.a.R;
                            runnable2 = this.a.S;
                            handler2.post(runnable2);
                        } else if (this.f) {
                            this.a.b(1);
                        } else {
                            this.a.b(2);
                        }
                        this.a.d();
                        i2 = this.a.J;
                        abVar7 = this.a.G;
                        if (i2 >= abVar7.h().size()) {
                            i3 = this.a.J;
                            abVar8 = this.a.G;
                            if (i3 < abVar8.k()) {
                                abVar9 = this.a.G;
                                int size = abVar9.h().size();
                                abVar10 = this.a.G;
                                if (size < abVar10.k()) {
                                    ImagePbActivity imagePbActivity = this.a;
                                    abVar11 = this.a.G;
                                    imagePbActivity.a(abVar11.l(), 0, 10, false);
                                }
                            }
                        }
                    } else {
                        this.a.showToast(this.a.getString(R.string.pb_nodata));
                        if (this.f) {
                            abVar2 = this.a.H;
                            if (abVar2 != null) {
                                this.a.a(0);
                            }
                        }
                        this.a.finish();
                    }
                }
            }
            this.a.b = null;
            this.a.a(false);
        }
    }
}
