package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbPagerAdapter f2508a;
    private com.baidu.tieba.util.ag b = null;
    private int c;
    private int d;
    private String e;
    private String f;
    private com.baidu.tieba.pb.ah g;
    private String h;

    public al(ImagePbPagerAdapter imagePbPagerAdapter, com.baidu.tieba.pb.ah ahVar, int i, int i2, String str, String str2) {
        this.f2508a = imagePbPagerAdapter;
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
        this.g = ahVar;
        this.h = ahVar.e().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        if (this.g != null) {
            this.g.a(true);
            this.g.notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        this.b = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/f/pb/piccomment");
        com.baidu.tieba.util.ag agVar = this.b;
        str = this.f2508a.e;
        agVar.a("kw", str);
        this.b.a("pic_id", this.f);
        this.b.a("tid", this.e);
        this.b.a("pn", String.valueOf(this.c));
        this.b.a("rn", String.valueOf(this.d));
        this.b.a("alt", "json");
        this.b.e(true);
        return this.b.j();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        if (this.g != null) {
            this.g.a(false);
            this.g.notifyDataSetChanged();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect condition in loop: B:22:0x0078 */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str) {
        Context context;
        Context context2;
        HashMap hashMap;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        HashMap hashMap2;
        com.baidu.tieba.data.ad adVar = null;
        super.a((al) str);
        try {
            if (this.g != null) {
                this.g.a(false);
            }
            if (this.b != null) {
                if (!this.b.c() || this.g == null) {
                    context = this.f2508a.b;
                    context2 = this.f2508a.b;
                    ((com.baidu.tieba.j) context).a(context2.getString(R.string.image_pb_comment_fail));
                    return;
                }
                if (this.g != null) {
                    this.g.a((com.baidu.tieba.data.ad) null);
                    this.g.notifyDataSetChanged();
                }
                hashMap = this.f2508a.h;
                if (hashMap.get(this.g.e().d()) != null) {
                    hashMap2 = this.f2508a.h;
                    adVar = (com.baidu.tieba.data.ad) hashMap2.get(this.g.e().d());
                    adVar.a(str);
                }
                if (this.g != null) {
                    this.g.a(adVar);
                    this.g.notifyDataSetChanged();
                    this.g = null;
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList2 = this.f2508a.s;
                    if (((View) arrayList2.get(i)).getTag() instanceof com.baidu.tieba.pb.ah) {
                        arrayList3 = this.f2508a.s;
                        com.baidu.tieba.pb.ah ahVar = (com.baidu.tieba.pb.ah) ((View) arrayList3.get(i)).getTag();
                        if (ahVar.e() != null && this.h.equals(ahVar.e().d())) {
                            ahVar.notifyDataSetChanged();
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
    }
}
