package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e fQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.fQe = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        j jVar;
        o oVar;
        o oVar2;
        j jVar2;
        int i3;
        ImageFileInfo sv;
        o oVar3;
        ImageView imageView;
        ImageView imageView2;
        j jVar3;
        int i4;
        this.fQe.aue = i;
        e eVar = this.fQe;
        i2 = this.fQe.aue;
        eVar.su(i2 + 1);
        jVar = this.fQe.fQc;
        if (jVar != null) {
            oVar = this.fQe.fPM;
            if (oVar != null) {
                oVar2 = this.fQe.fPM;
                if ("-1".equals(oVar2.bnx())) {
                    jVar3 = this.fQe.fQc;
                    i4 = this.fQe.aue;
                    sv = jVar3.sv(i4 + 1);
                } else {
                    jVar2 = this.fQe.fQc;
                    i3 = this.fQe.aue;
                    sv = jVar2.sv(i3);
                }
                oVar3 = this.fQe.fPM;
                if (oVar3.isAdded(sv)) {
                    e eVar2 = this.fQe;
                    imageView2 = this.fQe.fQd;
                    eVar2.b(imageView2, true);
                    return;
                }
                e eVar3 = this.fQe;
                imageView = this.fQe.fQd;
                eVar3.b(imageView, false);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
