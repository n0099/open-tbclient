package com.baidu.tieba.pb.image;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.al;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ ImagePbActivity a;
    private al b;
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
        this.b = new al(this.d);
        this.b.a(this.c);
        this.e = this.b.i();
        return this.e;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
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
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        com.baidu.tieba.data.u uVar;
        com.baidu.tieba.data.u uVar2;
        com.baidu.tieba.data.u uVar3;
        com.baidu.tieba.data.u uVar4;
        com.baidu.tieba.data.u uVar5;
        String str2;
        ac acVar;
        com.baidu.tieba.data.u uVar6;
        ac acVar2;
        s sVar;
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
        super.onPostExecute(str);
        if (!this.g) {
            if (this.b != null && this.b.c()) {
                uVar = this.a.F;
                if (uVar != null) {
                    if (this.b.a().b().b()) {
                        uVar3 = this.a.F;
                        if (!uVar3.a()) {
                            uVar12 = this.a.F;
                            uVar12.a(this.e, true);
                        }
                        String name = getClass().getName();
                        StringBuilder sb = new StringBuilder();
                        uVar4 = this.a.F;
                        BdLog.i(name, "onPostExecute", sb.append(uVar4.g().size()).toString());
                        uVar5 = this.a.F;
                        str2 = this.a.B;
                        uVar5.c(str2);
                        acVar = this.a.y;
                        uVar6 = this.a.F;
                        acVar.a(uVar6);
                        acVar2 = this.a.y;
                        acVar2.notifyDataSetChanged();
                        sVar = this.a.J;
                        i = this.a.I;
                        sVar.onPageSelected(i);
                        z = this.a.A;
                        if (z) {
                            handler = this.a.Q;
                            runnable = this.a.R;
                            handler.removeCallbacks(runnable);
                            handler2 = this.a.Q;
                            runnable2 = this.a.R;
                            handler2.post(runnable2);
                        } else if (this.f) {
                            this.a.b(1);
                        } else {
                            this.a.b(2);
                        }
                        this.a.e();
                        i2 = this.a.I;
                        uVar7 = this.a.F;
                        if (i2 >= uVar7.g().size()) {
                            i3 = this.a.I;
                            uVar8 = this.a.F;
                            if (i3 < uVar8.j()) {
                                uVar9 = this.a.F;
                                int size = uVar9.g().size();
                                uVar10 = this.a.F;
                                if (size < uVar10.j()) {
                                    ImagePbActivity imagePbActivity = this.a;
                                    uVar11 = this.a.F;
                                    imagePbActivity.a(uVar11.k(), 0, 10, false);
                                }
                            }
                        }
                    } else {
                        this.a.showToast(this.a.getString(com.baidu.tieba.u.pb_nodata));
                        if (this.f) {
                            uVar2 = this.a.G;
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
    }
}
