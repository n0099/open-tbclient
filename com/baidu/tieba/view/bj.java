package com.baidu.tieba.view;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.pb.ImageActivity;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj extends BdAsyncTask<String, Integer, bk> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bh f1992a;
    private com.baidu.tieba.util.z b = null;
    private String c;
    private String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bh bhVar, String str) {
        this.f1992a = bhVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = com.baidu.tieba.util.at.f(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bk a(String... strArr) {
        bk bkVar;
        Exception e;
        Bitmap bitmap;
        byte[] bArr;
        if (this.c == null || this.d == null) {
            return null;
        }
        String str = String.valueOf(String.valueOf(this.c) + "&imgtype=0") + "&qulity=" + com.baidu.tieba.util.au.a().d();
        try {
            byte[] imageData = this.f1992a.b.getImageData();
            Bitmap a2 = imageData != null ? com.baidu.tieba.util.e.a(imageData) : null;
            if (a2 == null && (imageData = com.baidu.tieba.util.p.d("image", this.d)) != null) {
                a2 = com.baidu.tieba.util.e.a(imageData);
            }
            if (a2 == null) {
                this.b = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.k) + str);
                if (this.f1992a.c != null && (this.f1992a.c instanceof ImageActivity)) {
                    if (((ImageActivity) this.f1992a.c).b() != null) {
                        this.b.a("fid", ((ImageActivity) this.f1992a.c).b());
                    }
                    if (((ImageActivity) this.f1992a.c).c() != null) {
                        this.b.a("tid", ((ImageActivity) this.f1992a.c).c());
                    }
                    if (((ImageActivity) this.f1992a.c).d() != null) {
                        this.b.a("fname", ((ImageActivity) this.f1992a.c).d());
                    }
                }
                this.b.d(true);
                imageData = this.b.i();
                if (this.b.c()) {
                    a2 = com.baidu.tieba.util.e.a(imageData);
                }
                com.baidu.tieba.util.p.a("image", this.d, imageData);
            }
            bitmap = a2;
            bArr = imageData;
            bkVar = new bk(this.f1992a, null);
        } catch (Exception e2) {
            bkVar = null;
            e = e2;
        }
        try {
            bkVar.f1993a = this.c;
            bkVar.b = bArr;
            bkVar.c = bitmap;
            return bkVar;
        } catch (Exception e3) {
            e = e3;
            com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", e.getMessage());
            return bkVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bk bkVar) {
        bi biVar;
        bi biVar2;
        this.f1992a.f1991a.setVisibility(8);
        this.f1992a.d = null;
        if (bkVar != null) {
            biVar = this.f1992a.e;
            if (biVar != null) {
                biVar2 = this.f1992a.e;
                biVar2.a(bkVar.f1993a, bkVar.b);
            }
            Bitmap bitmap = bkVar.c;
            if (bitmap == null) {
                this.f1992a.b.l();
            } else if (UtilHelper.a(bkVar.b)) {
                this.f1992a.b.a(bkVar.b, bitmap);
            } else {
                this.f1992a.b.setImageBitmap(bitmap);
                this.f1992a.b.setImageData(bkVar.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f1992a.b.setImageBitmap(null);
        this.f1992a.f1991a.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        this.f1992a.b.setVisibility(0);
        this.f1992a.f1991a.setVisibility(8);
        this.f1992a.d = null;
        super.cancel(true);
    }
}
