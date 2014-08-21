package com.baidu.tieba.write;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t {
    final /* synthetic */ r a;
    private FrameLayout b;
    private TbImageView c;
    private ProgressBar d;
    private com.baidu.tbadk.img.e e;
    private int f;

    public t(r rVar, int i) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        this.a = rVar;
        this.d = null;
        this.f = -1;
        this.f = i;
        com.baidu.adp.lib.e.b a = com.baidu.adp.lib.e.b.a();
        baseActivity = rVar.a;
        this.b = (FrameLayout) a.a(baseActivity, com.baidu.tieba.v.progress_tb_imageview, null);
        this.c = (TbImageView) this.b.findViewById(com.baidu.tieba.u.progress_tb_imageview);
        this.c.setClickable(true);
        this.c.setDefaultResource(0);
        this.c.setNightDefaultResource(0);
        this.c.setDefaultBgResource(0);
        this.c.setNightDefaultBgResource(0);
        this.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        baseActivity2 = rVar.a;
        this.e = new com.baidu.tbadk.img.e(baseActivity2);
        this.c.setOnClickListener(new u(this));
        this.d = (ProgressBar) this.b.findViewById(com.baidu.tieba.u.progress_tb_imageview_progress);
        this.d.setVisibility(8);
    }

    public View a() {
        return this.b;
    }

    public void a(ImageFileInfo imageFileInfo) {
        b();
        this.c.setDefaultResource(0);
        this.c.setNightDefaultResource(0);
        this.c.setDefaultBgResource(0);
        this.c.setNightDefaultBgResource(0);
        com.baidu.adp.widget.a.a a = this.e.a(imageFileInfo, false);
        if (a != null) {
            a.a(this.c);
            return;
        }
        a(false);
        this.e.a(imageFileInfo, new v(this), false);
    }

    public void b() {
        if (this.e != null) {
            this.e.b();
        }
        if (this.c != null) {
            this.c.setImageDrawable(null);
        }
    }

    public boolean c() {
        return this.d.getVisibility() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        s sVar;
        com.baidu.tbadk.coreExtra.view.k[] kVarArr;
        s sVar2;
        s sVar3;
        com.baidu.tbadk.coreExtra.view.k[] kVarArr2;
        s sVar4;
        if (z) {
            if (this.d.getVisibility() != 8) {
                sVar3 = this.a.d;
                if (sVar3 != null) {
                    sVar4 = this.a.d;
                    sVar4.c();
                }
                this.d.setVisibility(8);
                kVarArr2 = this.a.h;
                kVarArr2[this.f].setCanbeClick(true);
            }
        } else if (this.d.getVisibility() != 0) {
            sVar = this.a.d;
            if (sVar != null) {
                sVar2 = this.a.d;
                sVar2.b();
            }
            this.d.setVisibility(0);
            kVarArr = this.a.h;
            kVarArr[this.f].setCanbeClick(false);
        }
    }
}
