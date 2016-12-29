package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e fys;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.fys = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        j jVar;
        o oVar;
        o oVar2;
        j jVar2;
        int i3;
        ImageFileInfo sf;
        o oVar3;
        ImageView imageView;
        ImageView imageView2;
        j jVar3;
        int i4;
        this.fys.axc = i;
        e eVar = this.fys;
        i2 = this.fys.axc;
        eVar.se(i2 + 1);
        jVar = this.fys.fyq;
        if (jVar != null) {
            oVar = this.fys.fxZ;
            if (oVar != null) {
                oVar2 = this.fys.fxZ;
                if ("-1".equals(oVar2.blI())) {
                    jVar3 = this.fys.fyq;
                    i4 = this.fys.axc;
                    sf = jVar3.sf(i4 + 1);
                } else {
                    jVar2 = this.fys.fyq;
                    i3 = this.fys.axc;
                    sf = jVar2.sf(i3);
                }
                oVar3 = this.fys.fxZ;
                if (oVar3.isAdded(sf)) {
                    e eVar2 = this.fys;
                    imageView2 = this.fys.fyr;
                    eVar2.b(imageView2, true);
                    return;
                }
                e eVar3 = this.fys;
                imageView = this.fys.fyr;
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
