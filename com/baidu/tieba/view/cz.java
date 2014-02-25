package com.baidu.tieba.view;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.pb.ImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz extends BdAsyncTask<String, Integer, da> {
    final /* synthetic */ cx a;
    private com.baidu.tieba.util.ba b = null;
    private String c;
    private String d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cx cxVar, String str, boolean z) {
        this.a = cxVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = com.baidu.tieba.util.bs.f(str);
        this.e = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public da a(String... strArr) {
        boolean z;
        String str;
        da daVar;
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
                    a = com.baidu.adp.lib.util.b.a().a(this.c);
                    if (a != null && imageData == null) {
                        imageData = com.baidu.adp.lib.util.b.a().a(a, 100);
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
                byte[] l = this.b.l();
                Bitmap a2 = this.b.d() ? com.baidu.tieba.util.n.a(l) : a;
                com.baidu.tieba.util.af.a("image", this.d, l);
                a = a2;
                imageData = l;
            }
            daVar = new da(this.a, null);
            try {
                daVar.a = this.c;
                daVar.b = imageData;
                daVar.c = a;
                return daVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
                return daVar;
            }
        } catch (Exception e3) {
            daVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(da daVar) {
        cy cyVar;
        cy cyVar2;
        this.a.a.setVisibility(8);
        this.a.d = null;
        if (daVar != null) {
            cyVar = this.a.e;
            if (cyVar != null) {
                cyVar2 = this.a.e;
                cyVar2.a(daVar.a, daVar.b);
            }
            Bitmap bitmap = daVar.c;
            if (bitmap == null) {
                this.a.b.l();
            } else if (BdUtilHelper.a(daVar.b)) {
                this.a.b.a(daVar.b, bitmap);
            } else {
                this.a.b.setImageBitmap(bitmap);
                this.a.b.setImageData(daVar.b);
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
            this.b.k();
        }
        this.a.b.setVisibility(0);
        this.a.a.setVisibility(8);
        this.a.d = null;
        super.cancel(true);
    }
}
