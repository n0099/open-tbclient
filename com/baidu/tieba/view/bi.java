package com.baidu.tieba.view;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.ImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg f1835a;
    private com.baidu.tieba.util.u b = null;
    private String c;
    private String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bg bgVar, String str) {
        this.f1835a = bgVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = com.baidu.tieba.util.ai.f(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bj a(String... strArr) {
        String str;
        bj bjVar;
        Exception e;
        byte[] imageData;
        Bitmap a2;
        if (this.c == null || this.d == null) {
            return null;
        }
        String str2 = String.valueOf(this.c) + "&imgtype=0";
        if (TiebaApplication.f().ap() == 1) {
            str = String.valueOf(str2) + "&qulity=" + String.valueOf(80);
        } else {
            str = String.valueOf(str2) + "&qulity=" + String.valueOf(45);
        }
        try {
            imageData = this.f1835a.b.getImageData();
            a2 = imageData != null ? com.baidu.tieba.util.e.a(imageData) : null;
            if (a2 == null && (imageData = com.baidu.tieba.util.p.d("image", this.d)) != null) {
                a2 = com.baidu.tieba.util.e.a(imageData);
            }
            if (a2 == null) {
                this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.k) + str);
                if (this.f1835a.c != null && (this.f1835a.c instanceof ImageActivity)) {
                    if (((ImageActivity) this.f1835a.c).b() != null) {
                        this.b.a("fid", ((ImageActivity) this.f1835a.c).b());
                    }
                    if (((ImageActivity) this.f1835a.c).c() != null) {
                        this.b.a("tid", ((ImageActivity) this.f1835a.c).c());
                    }
                    if (((ImageActivity) this.f1835a.c).d() != null) {
                        this.b.a("fname", ((ImageActivity) this.f1835a.c).d());
                    }
                }
                this.b.d(true);
                byte[] j = this.b.j();
                Bitmap a3 = this.b.d() ? com.baidu.tieba.util.e.a(j) : a2;
                com.baidu.tieba.util.p.a("image", this.d, j);
                a2 = a3;
                imageData = j;
            }
            bjVar = new bj(this.f1835a, null);
        } catch (Exception e2) {
            bjVar = null;
            e = e2;
        }
        try {
            bjVar.f1836a = this.c;
            bjVar.b = imageData;
            bjVar.c = a2;
            return bjVar;
        } catch (Exception e3) {
            e = e3;
            com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
            return bjVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bj bjVar) {
        bh bhVar;
        bh bhVar2;
        this.f1835a.f1834a.setVisibility(8);
        this.f1835a.d = null;
        if (bjVar != null) {
            bhVar = this.f1835a.e;
            if (bhVar != null) {
                bhVar2 = this.f1835a.e;
                bhVar2.a(bjVar.f1836a, bjVar.b);
            }
            Bitmap bitmap = bjVar.c;
            if (bitmap == null) {
                this.f1835a.b.l();
            } else if (com.baidu.tieba.util.am.a(bjVar.b)) {
                this.f1835a.b.a(bjVar.b, bitmap);
            } else {
                this.f1835a.b.setImageBitmap(bitmap);
                this.f1835a.b.setImageData(bjVar.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f1835a.b.setImageBitmap(null);
        this.f1835a.f1834a.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.i();
        }
        this.f1835a.b.setVisibility(0);
        this.f1835a.f1834a.setVisibility(8);
        this.f1835a.d = null;
        super.cancel(true);
    }
}
