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
public class ac {
    final /* synthetic */ aa a;
    private FrameLayout b;
    private TbImageView c;
    private ProgressBar d;
    private com.baidu.tieba.img.e e;
    private int f;

    public ac(aa aaVar, int i) {
        Context context;
        Context context2;
        this.a = aaVar;
        this.d = null;
        this.f = -1;
        this.f = i;
        context = aaVar.a;
        this.b = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.progress_tb_imageview, (ViewGroup) null);
        this.c = (TbImageView) this.b.findViewById(R.id.progress_tb_imageview);
        this.c.setClickable(true);
        this.c.setDefaultResource(0);
        this.c.setNightDefaultResource(0);
        this.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        context2 = aaVar.a;
        this.e = new com.baidu.tieba.img.e(context2);
        this.c.setOnClickListener(new ad(this));
        this.d = (ProgressBar) this.b.findViewById(R.id.progress_tb_imageview_progress);
        this.d.setVisibility(8);
    }

    public View a() {
        return this.b;
    }

    public void a(ImageFileInfo imageFileInfo) {
        this.c.setDefaultResource(0);
        this.c.setNightDefaultResource(0);
        this.c.setTag(imageFileInfo.toCachedKey(false));
        if (this.e.a(imageFileInfo, false) != null) {
            this.c.invalidate();
            return;
        }
        a(false);
        this.e.a(imageFileInfo, new ae(this), false);
    }

    public boolean b() {
        return this.d.getVisibility() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        ab abVar;
        v[] vVarArr;
        ab abVar2;
        ab abVar3;
        v[] vVarArr2;
        ab abVar4;
        if (z) {
            if (this.d.getVisibility() != 8) {
                abVar3 = this.a.d;
                if (abVar3 != null) {
                    abVar4 = this.a.d;
                    abVar4.c();
                }
                this.d.setVisibility(8);
                vVarArr2 = this.a.h;
                vVarArr2[this.f].setCanbeClick(true);
            }
        } else if (this.d.getVisibility() != 0) {
            abVar = this.a.d;
            if (abVar != null) {
                abVar2 = this.a.d;
                abVar2.b();
            }
            this.d.setVisibility(0);
            vVarArr = this.a.h;
            vVarArr[this.f].setCanbeClick(false);
        }
    }

    public void c() {
        a(true);
        this.e.b();
    }
}
