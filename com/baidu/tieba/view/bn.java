package com.baidu.tieba.view;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.pb.ImageActivity;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends BdAsyncTask<String, Integer, bo> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bk f2527a;
    private com.baidu.tieba.util.ag b = null;
    private String c;
    private String d;
    private boolean e;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bk bkVar, String str, boolean z, boolean z2) {
        this.f2527a = bkVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = com.baidu.tieba.util.bc.f(str);
        this.e = z;
        this.f = z2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bo a(String... strArr) {
        bo boVar;
        Exception e;
        byte[] imageData;
        Bitmap a2;
        Bitmap bitmap;
        byte[] bArr;
        String str;
        if (this.c == null || this.d == null) {
            return null;
        }
        try {
            imageData = this.f2527a.b.getImageData();
            a2 = imageData != null ? com.baidu.tieba.util.e.a(imageData) : null;
        } catch (Exception e2) {
            boVar = null;
            e = e2;
        }
        try {
            if (a2 == null) {
                if (this.f && this.c.startsWith("/")) {
                    bitmap = com.baidu.adp.lib.h.a.a().a(this.c);
                    bArr = imageData;
                    boVar = new bo(this.f2527a);
                    boVar.f2528a = this.c;
                    boVar.b = bArr;
                    boVar.c = bitmap;
                    return boVar;
                }
                imageData = com.baidu.tieba.util.w.d("image", this.d);
                if (imageData != null) {
                    a2 = com.baidu.tieba.util.e.a(imageData);
                }
                if (a2 == null) {
                    if (!this.e) {
                        str = (com.baidu.tieba.data.h.k + this.c + "&imgtype=0") + "&qulity=" + com.baidu.tieba.util.bd.a().d();
                    } else {
                        str = this.c;
                    }
                    this.b = new com.baidu.tieba.util.ag(str);
                    if (this.f2527a.c != null && (this.f2527a.c instanceof ImageActivity) && !this.e) {
                        if (((ImageActivity) this.f2527a.c).b() != null) {
                            this.b.a("fid", ((ImageActivity) this.f2527a.c).b());
                        }
                        if (((ImageActivity) this.f2527a.c).c() != null) {
                            this.b.a("tid", ((ImageActivity) this.f2527a.c).c());
                        }
                        if (((ImageActivity) this.f2527a.c).d() != null) {
                            this.b.a("fname", ((ImageActivity) this.f2527a.c).d());
                        }
                    }
                    this.b.f(this.e);
                    this.b.d(!this.e);
                    imageData = this.b.i();
                    if (this.b.c()) {
                        a2 = com.baidu.tieba.util.e.a(imageData);
                    }
                    com.baidu.tieba.util.w.a("image", this.d, imageData);
                }
            }
            boVar.f2528a = this.c;
            boVar.b = bArr;
            boVar.c = bitmap;
            return boVar;
        } catch (Exception e3) {
            e = e3;
            com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.getMessage());
            return boVar;
        }
        bitmap = a2;
        bArr = imageData;
        boVar = new bo(this.f2527a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bo boVar) {
        bm bmVar;
        bm bmVar2;
        this.f2527a.f2526a.setVisibility(8);
        this.f2527a.d = null;
        if (boVar != null) {
            bmVar = this.f2527a.e;
            if (bmVar != null) {
                bmVar2 = this.f2527a.e;
                bmVar2.a(boVar.f2528a, boVar.b);
            }
            Bitmap bitmap = boVar.c;
            if (bitmap == null) {
                this.f2527a.b.l();
            } else if (UtilHelper.a(boVar.b)) {
                this.f2527a.b.a(boVar.b, bitmap);
            } else {
                this.f2527a.b.setImageBitmap(bitmap);
                this.f2527a.b.setImageData(boVar.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f2527a.b.setImageBitmap(null);
        this.f2527a.f2526a.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        this.f2527a.b.setVisibility(0);
        this.f2527a.f2526a.setVisibility(8);
        this.f2527a.d = null;
        super.cancel(true);
    }
}
