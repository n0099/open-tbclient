package com.baidu.tieba.view;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.pb.ImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br extends BdAsyncTask<String, Integer, bs> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bo f2678a;
    private com.baidu.tieba.util.am b = null;
    private String c;
    private String d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bo boVar, String str, boolean z) {
        this.f2678a = boVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = com.baidu.tieba.util.bb.f(str);
        this.e = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bs a(String... strArr) {
        boolean z;
        String str;
        bs bsVar;
        Exception e;
        boolean z2;
        if (this.c == null || this.d == null) {
            return null;
        }
        if (this.c != null && this.c.startsWith("width=")) {
            this.f2678a.f = false;
        }
        z = this.f2678a.f;
        if (z) {
            str = this.c;
        } else {
            str = com.baidu.tieba.data.h.l + ((this.c + "&imgtype=0") + "&qulity=" + com.baidu.tieba.util.bc.a().d());
        }
        try {
            byte[] imageData = this.f2678a.b.getImageData();
            Bitmap a2 = imageData != null ? com.baidu.tieba.util.m.a(imageData) : null;
            if (a2 == null) {
                if (this.e && this.c.startsWith("/")) {
                    a2 = com.baidu.adp.lib.h.a.a().a(this.c);
                    if (a2 != null && imageData == null) {
                        imageData = com.baidu.adp.lib.h.a.a().a(a2, 100);
                    }
                } else {
                    imageData = com.baidu.tieba.util.x.d("image", this.d);
                    if (imageData != null) {
                        a2 = com.baidu.tieba.util.m.a(imageData);
                    }
                }
            }
            if (a2 == null) {
                this.b = new com.baidu.tieba.util.am(str);
                com.baidu.tieba.util.am amVar = this.b;
                z2 = this.f2678a.f;
                amVar.f(z2);
                if (this.f2678a.c != null && (this.f2678a.c instanceof ImageActivity)) {
                    if (((ImageActivity) this.f2678a.c).a() != null) {
                        this.b.a("fid", ((ImageActivity) this.f2678a.c).a());
                    }
                    if (((ImageActivity) this.f2678a.c).b() != null) {
                        this.b.a("tid", ((ImageActivity) this.f2678a.c).b());
                    }
                    if (((ImageActivity) this.f2678a.c).c() != null) {
                        this.b.a("fname", ((ImageActivity) this.f2678a.c).c());
                    }
                }
                this.b.d(true);
                byte[] k = this.b.k();
                Bitmap a3 = this.b.c() ? com.baidu.tieba.util.m.a(k) : a2;
                com.baidu.tieba.util.x.a("image", this.d, k);
                a2 = a3;
                imageData = k;
            }
            bsVar = new bs(this.f2678a);
            try {
                bsVar.f2679a = this.c;
                bsVar.b = imageData;
                bsVar.c = a2;
                return bsVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.bd.b(getClass().getName(), "doInBackground", e.getMessage());
                return bsVar;
            }
        } catch (Exception e3) {
            bsVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bs bsVar) {
        bq bqVar;
        bq bqVar2;
        this.f2678a.f2677a.setVisibility(8);
        this.f2678a.d = null;
        if (bsVar != null) {
            bqVar = this.f2678a.e;
            if (bqVar != null) {
                bqVar2 = this.f2678a.e;
                bqVar2.a(bsVar.f2679a, bsVar.b);
            }
            Bitmap bitmap = bsVar.c;
            if (bitmap == null) {
                this.f2678a.b.l();
            } else if (com.baidu.adp.lib.h.g.a(bsVar.b)) {
                this.f2678a.b.a(bsVar.b, bitmap);
            } else {
                this.f2678a.b.setImageBitmap(bitmap);
                this.f2678a.b.setImageData(bsVar.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f2678a.b.setImageBitmap(null);
        this.f2678a.f2677a.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.j();
        }
        this.f2678a.b.setVisibility(0);
        this.f2678a.f2677a.setVisibility(8);
        this.f2678a.d = null;
        super.cancel(true);
    }
}
