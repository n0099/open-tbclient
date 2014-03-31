package com.baidu.tieba.write;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x {
    final /* synthetic */ v a;
    private FrameLayout b;
    private TbImageView c;
    private ProgressBar d;
    private com.baidu.tbadk.img.e e;
    private int f;

    public x(v vVar, int i) {
        Context context;
        Context context2;
        this.a = vVar;
        this.d = null;
        this.f = -1;
        this.f = i;
        context = vVar.a;
        this.b = (FrameLayout) LayoutInflater.from(context).inflate(com.baidu.tieba.a.i.progress_tb_imageview, (ViewGroup) null);
        this.c = (TbImageView) this.b.findViewById(com.baidu.tieba.a.h.progress_tb_imageview);
        this.c.setClickable(true);
        this.c.setDefaultResource(0);
        this.c.setNightDefaultResource(0);
        this.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        context2 = vVar.a;
        this.e = new com.baidu.tbadk.img.e(context2);
        this.c.setOnClickListener(new y(this));
        this.d = (ProgressBar) this.b.findViewById(com.baidu.tieba.a.h.progress_tb_imageview_progress);
        this.d.setVisibility(8);
    }

    public final View a() {
        return this.b;
    }

    public final void a(ImageFileInfo imageFileInfo) {
        b();
        this.c.setDefaultResource(0);
        this.c.setNightDefaultResource(0);
        com.baidu.tbadk.img.e eVar = this.e;
        com.baidu.adp.widget.ImageView.b a = com.baidu.tbadk.img.e.a(imageFileInfo, false);
        if (a != null) {
            a.a(this.c);
            return;
        }
        a(false);
        this.e.a(imageFileInfo, new z(this), false);
    }

    public final void b() {
        if (this.e != null) {
            this.e.b();
        }
        if (this.c != null) {
            this.c.setImageBitmap(null);
        }
    }

    public final boolean c() {
        return this.d.getVisibility() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        w wVar;
        com.baidu.tbadk.coreExtra.view.j[] jVarArr;
        w wVar2;
        w wVar3;
        com.baidu.tbadk.coreExtra.view.j[] jVarArr2;
        w wVar4;
        if (z) {
            if (this.d.getVisibility() != 8) {
                wVar3 = this.a.d;
                if (wVar3 != null) {
                    wVar4 = this.a.d;
                    wVar4.c();
                }
                this.d.setVisibility(8);
                jVarArr2 = this.a.h;
                jVarArr2[this.f].setCanbeClick(true);
            }
        } else if (this.d.getVisibility() != 0) {
            wVar = this.a.d;
            if (wVar != null) {
                wVar2 = this.a.d;
                wVar2.b();
            }
            this.d.setVisibility(0);
            jVarArr = this.a.h;
            jVarArr[this.f].setCanbeClick(false);
        }
    }
}
