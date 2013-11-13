package com.baidu.tieba.view;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.pb.ImageActivity;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends BdAsyncTask<String, Integer, bp> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bl f2578a;
    private com.baidu.tieba.util.ap b = null;
    private String c;
    private String d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bl blVar, String str, boolean z) {
        this.f2578a = blVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = com.baidu.tieba.util.be.f(str);
        this.e = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bp a(String... strArr) {
        boolean z;
        String str;
        bp bpVar;
        Exception e;
        boolean z2;
        if (this.c == null || this.d == null) {
            return null;
        }
        if (this.c != null && this.c.startsWith("width=")) {
            this.f2578a.f = false;
        }
        z = this.f2578a.f;
        if (z) {
            str = this.c;
        } else {
            str = com.baidu.tieba.data.h.l + ((this.c + "&imgtype=0") + "&qulity=" + com.baidu.tieba.util.bf.a().d());
        }
        try {
            byte[] imageData = this.f2578a.b.getImageData();
            Bitmap a2 = imageData != null ? com.baidu.tieba.util.m.a(imageData) : null;
            if (a2 == null) {
                if (this.e && this.c.startsWith("/")) {
                    a2 = com.baidu.adp.lib.h.a.a().a(this.c);
                } else {
                    imageData = com.baidu.tieba.util.af.d("image", this.d);
                    if (imageData != null) {
                        a2 = com.baidu.tieba.util.m.a(imageData);
                    }
                }
            }
            if (a2 == null) {
                this.b = new com.baidu.tieba.util.ap(str);
                com.baidu.tieba.util.ap apVar = this.b;
                z2 = this.f2578a.f;
                apVar.f(z2);
                if (this.f2578a.c != null && (this.f2578a.c instanceof ImageActivity)) {
                    if (((ImageActivity) this.f2578a.c).a() != null) {
                        this.b.a("fid", ((ImageActivity) this.f2578a.c).a());
                    }
                    if (((ImageActivity) this.f2578a.c).b() != null) {
                        this.b.a("tid", ((ImageActivity) this.f2578a.c).b());
                    }
                    if (((ImageActivity) this.f2578a.c).c() != null) {
                        this.b.a("fname", ((ImageActivity) this.f2578a.c).c());
                    }
                }
                this.b.d(true);
                byte[] i = this.b.i();
                Bitmap a3 = this.b.c() ? com.baidu.tieba.util.m.a(i) : a2;
                com.baidu.tieba.util.af.a("image", this.d, i);
                a2 = a3;
                imageData = i;
            }
            bpVar = new bp(this.f2578a);
            try {
                bpVar.f2579a = this.c;
                bpVar.b = imageData;
                bpVar.c = a2;
                return bpVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
                return bpVar;
            }
        } catch (Exception e3) {
            bpVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bp bpVar) {
        bn bnVar;
        bn bnVar2;
        this.f2578a.f2577a.setVisibility(8);
        this.f2578a.d = null;
        if (bpVar != null) {
            bnVar = this.f2578a.e;
            if (bnVar != null) {
                bnVar2 = this.f2578a.e;
                bnVar2.a(bpVar.f2579a, bpVar.b);
            }
            Bitmap bitmap = bpVar.c;
            if (bitmap == null) {
                this.f2578a.b.l();
            } else if (UtilHelper.a(bpVar.b)) {
                this.f2578a.b.a(bpVar.b, bitmap);
            } else {
                this.f2578a.b.setImageBitmap(bitmap);
                this.f2578a.b.setImageData(bpVar.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f2578a.b.setImageBitmap(null);
        this.f2578a.f2577a.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        this.f2578a.b.setVisibility(0);
        this.f2578a.f2577a.setVisibility(8);
        this.f2578a.d = null;
        super.cancel(true);
    }
}
