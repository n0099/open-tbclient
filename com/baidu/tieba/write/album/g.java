package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e emX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.emX = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        j jVar;
        o oVar;
        o oVar2;
        j jVar2;
        int i3;
        ImageFileInfo pv;
        o oVar3;
        ImageView imageView;
        ImageView imageView2;
        j jVar3;
        int i4;
        this.emX.avR = i;
        e eVar = this.emX;
        i2 = this.emX.avR;
        eVar.pu(i2 + 1);
        jVar = this.emX.emV;
        if (jVar != null) {
            oVar = this.emX.emG;
            if (oVar != null) {
                oVar2 = this.emX.emG;
                if ("-1".equals(oVar2.aSJ())) {
                    jVar3 = this.emX.emV;
                    i4 = this.emX.avR;
                    pv = jVar3.pv(i4 + 1);
                } else {
                    jVar2 = this.emX.emV;
                    i3 = this.emX.avR;
                    pv = jVar2.pv(i3);
                }
                oVar3 = this.emX.emG;
                if (oVar3.isAdded(pv)) {
                    e eVar2 = this.emX;
                    imageView2 = this.emX.emW;
                    eVar2.b(imageView2, true);
                    return;
                }
                e eVar3 = this.emX;
                imageView = this.emX.emW;
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
