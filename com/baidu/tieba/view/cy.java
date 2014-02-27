package com.baidu.tieba.view;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.pb.ImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cy extends BdAsyncTask<String, Integer, cz> {
    final /* synthetic */ cw a;
    private com.baidu.tieba.util.ba b = null;
    private String c;
    private String d;
    private boolean e;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ cz a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(cz czVar) {
        cx cxVar;
        cx unused;
        cz czVar2 = czVar;
        this.a.a.setVisibility(8);
        this.a.d = null;
        if (czVar2 != null) {
            cxVar = this.a.e;
            if (cxVar != null) {
                unused = this.a.e;
                String str = czVar2.a;
                byte[] bArr = czVar2.b;
            }
            Bitmap bitmap = czVar2.c;
            if (bitmap == null) {
                this.a.b.k();
            } else if (BdUtilHelper.a(czVar2.b)) {
                this.a.b.a(czVar2.b, bitmap);
            } else {
                this.a.b.setImageBitmap(bitmap);
                this.a.b.setImageData(czVar2.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cw cwVar, String str, boolean z) {
        this.a = cwVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = com.baidu.tieba.util.bs.f(str);
        this.e = z;
    }

    private cz d() {
        boolean z;
        String str;
        cz czVar;
        Exception e;
        boolean z2;
        if (this.c == null || this.d == null) {
            return null;
        }
        if (this.c != null && this.c.startsWith("width=")) {
            this.a.f = false;
        }
        z = this.a.f;
        if (z) {
            str = this.c;
        } else {
            str = String.valueOf(com.baidu.tieba.data.i.k) + (String.valueOf(String.valueOf(this.c) + "&imgtype=0") + "&qulity=" + com.baidu.tieba.util.bv.a().d());
        }
        try {
            byte[] imageData = this.a.b.getImageData();
            Bitmap a = imageData != null ? com.baidu.tieba.util.n.a(imageData) : null;
            if (a == null) {
                if (this.e && this.c.startsWith("/")) {
                    com.baidu.adp.lib.util.a.a();
                    a = com.baidu.adp.lib.util.a.a(this.c);
                    if (a != null && imageData == null) {
                        com.baidu.adp.lib.util.a.a();
                        imageData = com.baidu.adp.lib.util.a.a(a, 100);
                    }
                } else {
                    imageData = com.baidu.tieba.util.af.d("image", this.d);
                    if (imageData != null) {
                        a = com.baidu.tieba.util.n.a(imageData);
                    }
                }
            }
            if (a == null) {
                this.b = new com.baidu.tieba.util.ba(str);
                com.baidu.tieba.util.ba baVar = this.b;
                z2 = this.a.f;
                baVar.f(z2);
                if (this.a.c != null && (this.a.c instanceof ImageActivity)) {
                    if (((ImageActivity) this.a.c).a() != null) {
                        this.b.a("fid", ((ImageActivity) this.a.c).a());
                    }
                    if (((ImageActivity) this.a.c).b() != null) {
                        this.b.a("tid", ((ImageActivity) this.a.c).b());
                    }
                    if (((ImageActivity) this.a.c).c() != null) {
                        this.b.a("fname", ((ImageActivity) this.a.c).c());
                    }
                }
                this.b.d(true);
                byte[] k = this.b.k();
                Bitmap a2 = this.b.c() ? com.baidu.tieba.util.n.a(k) : a;
                com.baidu.tieba.util.af.a("image", this.d, k);
                a = a2;
                imageData = k;
            }
            czVar = new cz(this.a, (byte) 0);
            try {
                czVar.a = this.c;
                czVar.b = imageData;
                czVar.c = a;
                return czVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
                return czVar;
            }
        } catch (Exception e3) {
            czVar = null;
            e = e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        this.a.b.setImageBitmap(null);
        this.a.a.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.b != null) {
            this.b.j();
        }
        this.a.b.setVisibility(0);
        this.a.a.setVisibility(8);
        this.a.d = null;
        super.cancel(true);
    }
}
