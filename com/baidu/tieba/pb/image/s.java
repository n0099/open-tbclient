package com.baidu.tieba.pb.image;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ ImagePbActivity a;
    private ak b;
    private ArrayList<BasicNameValuePair> c;
    private String d;
    private boolean f;
    private String e = null;
    private boolean g = false;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(Object... objArr) {
        this.b = new ak(this.d);
        this.b.a(this.c);
        this.e = this.b.i();
        return this.e;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        com.baidu.tieba.data.u uVar;
        com.baidu.tieba.data.u uVar2;
        com.baidu.tieba.data.u uVar3;
        com.baidu.tieba.data.u uVar4;
        com.baidu.tieba.data.u uVar5;
        String str2;
        ad adVar;
        com.baidu.tieba.data.u uVar6;
        ad adVar2;
        t tVar;
        int i;
        boolean z;
        int i2;
        com.baidu.tieba.data.u uVar7;
        int i3;
        com.baidu.tieba.data.u uVar8;
        com.baidu.tieba.data.u uVar9;
        com.baidu.tieba.data.u uVar10;
        com.baidu.tieba.data.u uVar11;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        com.baidu.tieba.data.u uVar12;
        super.a((s) str);
        if (this.g) {
            return;
        }
        if (this.b != null && this.b.c()) {
            uVar = this.a.G;
            if (uVar != null) {
                if (this.b.a().b().b()) {
                    uVar3 = this.a.G;
                    if (!uVar3.a()) {
                        uVar12 = this.a.G;
                        uVar12.a(this.e, true);
                    }
                    String name = getClass().getName();
                    StringBuilder sb = new StringBuilder();
                    uVar4 = this.a.G;
                    com.baidu.adp.lib.util.f.a(name, "onPostExecute", sb.append(uVar4.h().size()).toString());
                    uVar5 = this.a.G;
                    str2 = this.a.C;
                    uVar5.c(str2);
                    adVar = this.a.z;
                    uVar6 = this.a.G;
                    adVar.a(uVar6);
                    adVar2 = this.a.z;
                    adVar2.notifyDataSetChanged();
                    tVar = this.a.K;
                    i = this.a.J;
                    tVar.onPageSelected(i);
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
                    ImagePbActivity.n(this.a);
                    i2 = this.a.J;
                    uVar7 = this.a.G;
                    if (i2 >= uVar7.h().size()) {
                        i3 = this.a.J;
                        uVar8 = this.a.G;
                        if (i3 < uVar8.k()) {
                            uVar9 = this.a.G;
                            int size = uVar9.h().size();
                            uVar10 = this.a.G;
                            if (size < uVar10.k()) {
                                ImagePbActivity imagePbActivity = this.a;
                                uVar11 = this.a.G;
                                imagePbActivity.a(uVar11.l(), 0, 10, false);
                            }
                        }
                    }
                } else {
                    this.a.showToast(this.a.getString(com.baidu.tieba.a.k.pb_nodata));
                    if (this.f) {
                        uVar2 = this.a.H;
                        if (uVar2 != null) {
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

    public s(ImagePbActivity imagePbActivity, String str, ArrayList<BasicNameValuePair> arrayList, boolean z) {
        this.a = imagePbActivity;
        this.c = null;
        this.d = null;
        this.f = false;
        this.d = str;
        this.c = arrayList;
        this.f = z;
        setSelfExecute(true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.b = null;
        this.a.a(false);
        this.g = true;
        super.cancel(true);
    }
}
