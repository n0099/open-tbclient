package com.baidu.tieba.view;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.ImageActivity;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bf f1864a;
    private com.baidu.tieba.util.v b = null;
    private String c;
    private String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bf bfVar, String str) {
        this.f1864a = bfVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = com.baidu.tieba.util.ap.f(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bi a(String... strArr) {
        String str;
        bi biVar;
        Exception e;
        byte[] imageData;
        Bitmap a2;
        if (this.c == null || this.d == null) {
            return null;
        }
        String str2 = String.valueOf(this.c) + "&imgtype=0";
        if (TiebaApplication.g().ai() == 1) {
            str = String.valueOf(str2) + "&qulity=" + String.valueOf(80);
        } else {
            str = String.valueOf(str2) + "&qulity=" + String.valueOf(45);
        }
        try {
            imageData = this.f1864a.b.getImageData();
            a2 = imageData != null ? com.baidu.tieba.util.e.a(imageData) : null;
            if (a2 == null && (imageData = com.baidu.tieba.util.p.d("image", this.d)) != null) {
                a2 = com.baidu.tieba.util.e.a(imageData);
            }
            if (a2 == null) {
                this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.k) + str);
                if (this.f1864a.c != null && (this.f1864a.c instanceof ImageActivity)) {
                    if (((ImageActivity) this.f1864a.c).b() != null) {
                        this.b.a("fid", ((ImageActivity) this.f1864a.c).b());
                    }
                    if (((ImageActivity) this.f1864a.c).c() != null) {
                        this.b.a("tid", ((ImageActivity) this.f1864a.c).c());
                    }
                    if (((ImageActivity) this.f1864a.c).d() != null) {
                        this.b.a("fname", ((ImageActivity) this.f1864a.c).d());
                    }
                }
                this.b.d(true);
                byte[] i = this.b.i();
                Bitmap a3 = this.b.c() ? com.baidu.tieba.util.e.a(i) : a2;
                com.baidu.tieba.util.p.a("image", this.d, i);
                a2 = a3;
                imageData = i;
            }
            biVar = new bi(this.f1864a, null);
        } catch (Exception e2) {
            biVar = null;
            e = e2;
        }
        try {
            biVar.f1865a = this.c;
            biVar.b = imageData;
            biVar.c = a2;
            return biVar;
        } catch (Exception e3) {
            e = e3;
            com.baidu.tieba.util.aq.b(getClass().getName(), "doInBackground", e.getMessage());
            return biVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bi biVar) {
        bg bgVar;
        bg bgVar2;
        this.f1864a.f1863a.setVisibility(8);
        this.f1864a.d = null;
        if (biVar != null) {
            bgVar = this.f1864a.e;
            if (bgVar != null) {
                bgVar2 = this.f1864a.e;
                bgVar2.a(biVar.f1865a, biVar.b);
            }
            Bitmap bitmap = biVar.c;
            if (bitmap == null) {
                this.f1864a.b.l();
            } else if (UtilHelper.a(biVar.b)) {
                this.f1864a.b.a(biVar.b, bitmap);
            } else {
                this.f1864a.b.setImageBitmap(bitmap);
                this.f1864a.b.setImageData(biVar.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f1864a.b.setImageBitmap(null);
        this.f1864a.f1863a.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        this.f1864a.b.setVisibility(0);
        this.f1864a.f1863a.setVisibility(8);
        this.f1864a.d = null;
        super.cancel(true);
    }
}
