package com.baidu.tieba.view;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends AsyncTask {
    final /* synthetic */ ImagePbPagerAdapter a;
    private com.baidu.tieba.c.t b = null;
    private int c;
    private int d;
    private String e;
    private String f;
    private com.baidu.tieba.pb.ag g;
    private String h;

    public w(ImagePbPagerAdapter imagePbPagerAdapter, com.baidu.tieba.pb.ag agVar, int i, int i2, String str, String str2) {
        this.a = imagePbPagerAdapter;
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
        this.g = agVar;
        this.h = agVar.e().d();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        if (this.g != null) {
            this.g.a(true);
            this.g.notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        String str;
        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/f/pb/piccomment");
        com.baidu.tieba.c.t tVar = this.b;
        str = this.a.e;
        tVar.a("kw", str);
        this.b.a("pic_id", this.f);
        this.b.a("tid", this.e);
        this.b.a("pn", String.valueOf(this.c));
        this.b.a("rn", String.valueOf(this.d));
        this.b.a("alt", "json");
        this.b.d(true);
        return this.b.i();
    }

    public void a() {
        if (this.b != null) {
            this.b.g();
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
    @Override // android.os.AsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPostExecute(String str) {
        Context context;
        Context context2;
        HashMap hashMap;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        HashMap hashMap2;
        com.baidu.tieba.a.w wVar = null;
        super.onPostExecute(str);
        try {
            if (this.g != null) {
                this.g.a(false);
            }
            if (this.b != null) {
                if (!this.b.b() || this.g == null) {
                    context = this.a.b;
                    context2 = this.a.b;
                    ((com.baidu.tieba.e) context).b(context2.getString(R.string.image_pb_comment_fail));
                    return;
                }
                if (this.g != null) {
                    this.g.a((com.baidu.tieba.a.w) null);
                    this.g.notifyDataSetChanged();
                }
                hashMap = this.a.h;
                if (hashMap.get(this.g.e().d()) != null) {
                    hashMap2 = this.a.h;
                    wVar = (com.baidu.tieba.a.w) hashMap2.get(this.g.e().d());
                    wVar.a(str);
                }
                if (this.g != null) {
                    this.g.a(wVar);
                    this.g.notifyDataSetChanged();
                    this.g = null;
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList2 = this.a.s;
                    if (((View) arrayList2.get(i)).getTag() instanceof com.baidu.tieba.pb.ag) {
                        arrayList3 = this.a.s;
                        com.baidu.tieba.pb.ag agVar = (com.baidu.tieba.pb.ag) ((View) arrayList3.get(i)).getTag();
                        if (agVar.e() != null && this.h.equals(agVar.e().d())) {
                            agVar.notifyDataSetChanged();
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
    }
}
