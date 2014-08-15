package com.baidu.tieba.pb.image;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ ImagePbActivity a;
    private com.baidu.tbadk.core.util.ae b;
    private ArrayList<BasicNameValuePair> c;
    private String d;
    private boolean f;
    private String e = null;
    private boolean g = false;

    public r(ImagePbActivity imagePbActivity, String str, ArrayList<BasicNameValuePair> arrayList, boolean z) {
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
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        this.b = new com.baidu.tbadk.core.util.ae(this.d);
        this.b.a(this.c);
        this.e = this.b.h();
        return this.e;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.f();
        }
        this.a.b = null;
        this.a.a(false);
        this.g = true;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        com.baidu.tieba.data.w wVar;
        com.baidu.tieba.data.w wVar2;
        com.baidu.tieba.data.w wVar3;
        com.baidu.tieba.data.w wVar4;
        String str2;
        ac acVar;
        com.baidu.tieba.data.w wVar5;
        ac acVar2;
        s sVar;
        int i;
        boolean z;
        int i2;
        com.baidu.tieba.data.w wVar6;
        int i3;
        com.baidu.tieba.data.w wVar7;
        com.baidu.tieba.data.w wVar8;
        com.baidu.tieba.data.w wVar9;
        com.baidu.tieba.data.w wVar10;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        com.baidu.tieba.data.w wVar11;
        super.onPostExecute(str);
        if (!this.g) {
            if (this.b != null && this.b.b()) {
                wVar = this.a.E;
                if (wVar != null) {
                    if (this.b.a().b().b()) {
                        wVar3 = this.a.E;
                        if (!wVar3.a()) {
                            wVar11 = this.a.E;
                            wVar11.a(this.e, true);
                        }
                        wVar4 = this.a.E;
                        str2 = this.a.A;
                        wVar4.c(str2);
                        acVar = this.a.x;
                        wVar5 = this.a.E;
                        acVar.a(wVar5);
                        acVar2 = this.a.x;
                        acVar2.notifyDataSetChanged();
                        sVar = this.a.I;
                        i = this.a.H;
                        sVar.onPageSelected(i);
                        z = this.a.z;
                        if (z) {
                            handler = this.a.P;
                            runnable = this.a.Q;
                            handler.removeCallbacks(runnable);
                            handler2 = this.a.P;
                            runnable2 = this.a.Q;
                            handler2.post(runnable2);
                        } else if (this.f) {
                            this.a.b(1);
                        } else {
                            this.a.b(2);
                        }
                        this.a.e();
                        i2 = this.a.H;
                        wVar6 = this.a.E;
                        if (i2 >= wVar6.g().size()) {
                            i3 = this.a.H;
                            wVar7 = this.a.E;
                            if (i3 < wVar7.j()) {
                                wVar8 = this.a.E;
                                int size = wVar8.g().size();
                                wVar9 = this.a.E;
                                if (size < wVar9.j()) {
                                    ImagePbActivity imagePbActivity = this.a;
                                    wVar10 = this.a.E;
                                    imagePbActivity.a(wVar10.k(), 0, 10, false);
                                }
                            }
                        }
                    } else {
                        this.a.showToast(this.a.getString(com.baidu.tieba.x.pb_nodata));
                        if (this.f) {
                            wVar2 = this.a.F;
                            if (wVar2 != null) {
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
