package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e fPv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.fPv = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        j jVar;
        o oVar;
        o oVar2;
        j jVar2;
        int i3;
        ImageFileInfo sT;
        o oVar3;
        ImageView imageView;
        ImageView imageView2;
        j jVar3;
        int i4;
        this.fPv.aBT = i;
        e eVar = this.fPv;
        i2 = this.fPv.aBT;
        eVar.sS(i2 + 1);
        jVar = this.fPv.fPt;
        if (jVar != null) {
            oVar = this.fPv.fPd;
            if (oVar != null) {
                oVar2 = this.fPv.fPd;
                if ("-1".equals(oVar2.boE())) {
                    jVar3 = this.fPv.fPt;
                    i4 = this.fPv.aBT;
                    sT = jVar3.sT(i4 + 1);
                } else {
                    jVar2 = this.fPv.fPt;
                    i3 = this.fPv.aBT;
                    sT = jVar2.sT(i3);
                }
                oVar3 = this.fPv.fPd;
                if (oVar3.isAdded(sT)) {
                    e eVar2 = this.fPv;
                    imageView2 = this.fPv.fPu;
                    eVar2.c(imageView2, true);
                    return;
                }
                e eVar3 = this.fPv;
                imageView = this.fPv.fPu;
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
