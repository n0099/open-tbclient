package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tieba.a.be;
import com.baidu.tieba.c.bp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.adp.lib.a.a {
    volatile com.baidu.tieba.d.t a;
    be b;
    final /* synthetic */ VcodeActivity c;
    private volatile boolean d;

    private r(VcodeActivity vcodeActivity) {
        this.c = vcodeActivity;
        this.a = null;
        this.b = null;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(VcodeActivity vcodeActivity, r rVar) {
        this(vcodeActivity);
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        ProgressBar progressBar;
        this.c.j = null;
        if (this.a != null) {
            this.a.g();
        }
        this.d = true;
        progressBar = this.c.h;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public Bitmap a(String... strArr) {
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        bp bpVar4;
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            this.a = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/f/anti/vcode");
            com.baidu.tieba.d.t tVar = this.a;
            bpVar = this.c.c;
            tVar.a("fid", bpVar.g());
            com.baidu.tieba.d.t tVar2 = this.a;
            bpVar2 = this.c.c;
            tVar2.a("kw", bpVar2.h());
            bpVar3 = this.c.c;
            if (bpVar3.b() == 0) {
                this.a.a("pub_type", "1");
            } else {
                this.a.a("pub_type", "2");
                com.baidu.tieba.d.t tVar3 = this.a;
                bpVar4 = this.c.c;
                tVar3.a("tid", bpVar4.e());
            }
            String i = this.a.i();
            if (!this.a.b()) {
                return null;
            }
            this.b = new be();
            this.b.a(i);
            str = this.b.b();
        }
        if (this.d) {
            return null;
        }
        this.a = new com.baidu.tieba.d.t(str);
        return com.baidu.tieba.d.e.a(this.a.h());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        bp bpVar;
        bp bpVar2;
        ImageView imageView;
        this.c.j = null;
        if (bitmap != null) {
            imageView = this.c.f;
            imageView.setImageBitmap(bitmap);
        }
        progressBar = this.c.h;
        progressBar.setVisibility(8);
        if (this.b != null) {
            bpVar = this.c.c;
            bpVar.h(this.b.a());
            bpVar2 = this.c.c;
            bpVar2.i(this.b.b());
        }
        super.a((Object) bitmap);
    }
}
