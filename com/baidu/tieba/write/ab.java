package com.baidu.tieba.write;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.img.ImageFileInfo;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab {
    final /* synthetic */ z a;
    private FrameLayout b;
    private TbImageView c;
    private ProgressBar d;
    private com.baidu.tieba.img.e e;
    private int f;

    public ab(z zVar, int i) {
        Context context;
        Context context2;
        this.a = zVar;
        this.d = null;
        this.f = -1;
        this.f = i;
        context = zVar.a;
        this.b = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
        this.c = (TbImageView) this.b.findViewById(R.id.progress_tb_imageview);
        this.c.setClickable(true);
        this.c.setDefaultResource(0);
        this.c.setNightDefaultResource(0);
        this.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        context2 = zVar.a;
        this.e = new com.baidu.tieba.img.e(context2);
        this.c.setOnClickListener(new ac(this));
        this.d = (ProgressBar) this.b.findViewById(R.id.progress_tb_imageview_progress);
        this.d.setVisibility(8);
    }

    public final View a() {
        return this.b;
    }

    public final void a(ImageFileInfo imageFileInfo) {
        b();
        this.c.setDefaultResource(0);
        this.c.setNightDefaultResource(0);
        com.baidu.tieba.img.e eVar = this.e;
        com.baidu.adp.widget.ImageView.b a = com.baidu.tieba.img.e.a(imageFileInfo, false);
        if (a != null) {
            a.a(this.c);
            return;
        }
        a(false);
        this.e.a(imageFileInfo, new ad(this), false);
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
        aa aaVar;
        v[] vVarArr;
        aa aaVar2;
        aa aaVar3;
        v[] vVarArr2;
        aa aaVar4;
        if (z) {
            if (this.d.getVisibility() != 8) {
                aaVar3 = this.a.d;
                if (aaVar3 != null) {
                    aaVar4 = this.a.d;
                    aaVar4.c();
                }
                this.d.setVisibility(8);
                vVarArr2 = this.a.h;
                vVarArr2[this.f].setCanbeClick(true);
            }
        } else if (this.d.getVisibility() != 0) {
            aaVar = this.a.d;
            if (aaVar != null) {
                aaVar2 = this.a.d;
                aaVar2.b();
            }
            this.d.setVisibility(0);
            vVarArr = this.a.h;
            vVarArr[this.f].setCanbeClick(false);
        }
    }
}
