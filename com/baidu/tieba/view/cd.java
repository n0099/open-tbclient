package com.baidu.tieba.view;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.pb.ImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd extends BdAsyncTask<String, Integer, ce> {
    final /* synthetic */ ca a;
    private com.baidu.tieba.util.at b = null;
    private String c;
    private String d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(ca caVar, String str, boolean z) {
        this.a = caVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = com.baidu.tieba.util.bm.f(str);
        this.e = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ce a(String... strArr) {
        boolean z;
        String str;
        ce ceVar;
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
            str = com.baidu.tieba.data.h.m + ((this.c + "&imgtype=0") + "&qulity=" + com.baidu.tieba.util.bn.a().d());
        }
        try {
            byte[] imageData = this.a.b.getImageData();
            Bitmap a = imageData != null ? com.baidu.tieba.util.m.a(imageData) : null;
            if (a == null) {
                if (this.e && this.c.startsWith("/")) {
                    a = com.baidu.adp.lib.h.a.a().a(this.c);
                    if (a != null && imageData == null) {
                        imageData = com.baidu.adp.lib.h.a.a().a(a, 100);
                    }
                } else {
                    imageData = com.baidu.tieba.util.aa.d("image", this.d);
                    if (imageData != null) {
                        a = com.baidu.tieba.util.m.a(imageData);
                    }
                }
            }
            if (a == null) {
                this.b = new com.baidu.tieba.util.at(str);
                com.baidu.tieba.util.at atVar = this.b;
                z2 = this.a.f;
                atVar.f(z2);
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
                Bitmap a2 = this.b.c() ? com.baidu.tieba.util.m.a(k) : a;
                com.baidu.tieba.util.aa.a("image", this.d, k);
                a = a2;
                imageData = k;
            }
            ceVar = new ce(this.a);
            try {
                ceVar.a = this.c;
                ceVar.b = imageData;
                ceVar.c = a;
                return ceVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.bo.b(getClass().getName(), "doInBackground", e.getMessage());
                return ceVar;
            }
        } catch (Exception e3) {
            ceVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ce ceVar) {
        cc ccVar;
        cc ccVar2;
        this.a.a.setVisibility(8);
        this.a.d = null;
        if (ceVar != null) {
            ccVar = this.a.e;
            if (ccVar != null) {
                ccVar2 = this.a.e;
                ccVar2.a(ceVar.a, ceVar.b);
            }
            Bitmap bitmap = ceVar.c;
            if (bitmap == null) {
                this.a.b.l();
            } else if (com.baidu.adp.lib.h.g.a(ceVar.b)) {
                this.a.b.a(ceVar.b, bitmap);
            } else {
                this.a.b.setImageBitmap(bitmap);
                this.a.b.setImageData(ceVar.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.a.b.setImageBitmap(null);
        this.a.a.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.j();
        }
        this.a.b.setVisibility(0);
        this.a.a.setVisibility(8);
        this.a.d = null;
        super.cancel(true);
    }
}
