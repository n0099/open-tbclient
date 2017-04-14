package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e fMZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.fMZ = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        j jVar;
        o oVar;
        o oVar2;
        j jVar2;
        int i3;
        ImageFileInfo sN;
        o oVar3;
        ImageView imageView;
        ImageView imageView2;
        j jVar3;
        int i4;
        this.fMZ.aBR = i;
        e eVar = this.fMZ;
        i2 = this.fMZ.aBR;
        eVar.sM(i2 + 1);
        jVar = this.fMZ.fMX;
        if (jVar != null) {
            oVar = this.fMZ.fMH;
            if (oVar != null) {
                oVar2 = this.fMZ.fMH;
                if ("-1".equals(oVar2.bnD())) {
                    jVar3 = this.fMZ.fMX;
                    i4 = this.fMZ.aBR;
                    sN = jVar3.sN(i4 + 1);
                } else {
                    jVar2 = this.fMZ.fMX;
                    i3 = this.fMZ.aBR;
                    sN = jVar2.sN(i3);
                }
                oVar3 = this.fMZ.fMH;
                if (oVar3.isAdded(sN)) {
                    e eVar2 = this.fMZ;
                    imageView2 = this.fMZ.fMY;
                    eVar2.c(imageView2, true);
                    return;
                }
                e eVar3 = this.fMZ;
                imageView = this.fMZ.fMY;
                eVar3.c(imageView, false);
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
