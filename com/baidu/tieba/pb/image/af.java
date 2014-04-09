package com.baidu.tieba.pb.image;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class af extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ ac a;
    private ak b = null;
    private int c;
    private int d;
    private String e;
    private String f;
    private x g;
    private String h;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        String str;
        this.b = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/pb/piccomment");
        ak akVar = this.b;
        str = this.a.e;
        akVar.a("kw", str);
        this.b.a("pic_id", this.f);
        this.b.a("tid", this.e);
        this.b.a("pn", String.valueOf(this.c));
        this.b.a("rn", String.valueOf(this.d));
        this.b.a("alt", "json");
        this.b.a().a().a = true;
        return this.b.i();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect condition in loop: B:22:0x0082 */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void a(String str) {
        Context context;
        Context context2;
        HashMap hashMap;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        HashMap hashMap2;
        com.baidu.tieba.data.v vVar = null;
        String str2 = str;
        super.a((af) str2);
        try {
            if (this.g != null) {
                this.g.a(false);
            }
            if (this.b != null) {
                if (!this.b.a().b().b() || this.g == null) {
                    context = this.a.b;
                    context2 = this.a.b;
                    ((com.baidu.tbadk.a) context).showToast(context2.getString(com.baidu.tieba.a.k.image_pb_comment_fail));
                    return;
                }
                if (this.g != null) {
                    this.g.a((com.baidu.tieba.data.v) null);
                    this.g.notifyDataSetChanged();
                }
                hashMap = this.a.h;
                if (hashMap.get(this.g.e().d()) != null) {
                    hashMap2 = this.a.h;
                    vVar = (com.baidu.tieba.data.v) hashMap2.get(this.g.e().d());
                    vVar.a(str2);
                }
                if (this.g != null) {
                    this.g.a(vVar);
                    this.g.notifyDataSetChanged();
                    this.g = null;
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList2 = this.a.s;
                    if (((View) arrayList2.get(i)).getTag() instanceof x) {
                        arrayList3 = this.a.s;
                        x xVar = (x) ((View) arrayList3.get(i)).getTag();
                        if (xVar.e() != null && this.h.equals(xVar.e().d())) {
                            xVar.notifyDataSetChanged();
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
    }

    public af(ac acVar, x xVar, int i, int i2, String str, String str2) {
        this.a = acVar;
        this.c = 0;
        this.d = 10;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.c = i;
        this.d = i2;
        this.e = str;
        this.f = str2;
        this.g = xVar;
        this.h = xVar.e().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        if (this.g != null) {
            this.g.a(true);
            this.g.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.b != null) {
            this.b.g();
        }
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void d() {
        super.d();
        if (this.g != null) {
            this.g.a(false);
            this.g.notifyDataSetChanged();
        }
    }
}
