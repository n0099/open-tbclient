package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e fGW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.fGW = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        j jVar;
        o oVar;
        o oVar2;
        j jVar2;
        int i3;
        ImageFileInfo sQ;
        o oVar3;
        ImageView imageView;
        ImageView imageView2;
        j jVar3;
        int i4;
        this.fGW.awg = i;
        e eVar = this.fGW;
        i2 = this.fGW.awg;
        eVar.sP(i2 + 1);
        jVar = this.fGW.fGU;
        if (jVar != null) {
            oVar = this.fGW.fGE;
            if (oVar != null) {
                oVar2 = this.fGW.fGE;
                if ("-1".equals(oVar2.bng())) {
                    jVar3 = this.fGW.fGU;
                    i4 = this.fGW.awg;
                    sQ = jVar3.sQ(i4 + 1);
                } else {
                    jVar2 = this.fGW.fGU;
                    i3 = this.fGW.awg;
                    sQ = jVar2.sQ(i3);
                }
                oVar3 = this.fGW.fGE;
                if (oVar3.isAdded(sQ)) {
                    e eVar2 = this.fGW;
                    imageView2 = this.fGW.fGV;
                    eVar2.b(imageView2, true);
                    return;
                }
                e eVar3 = this.fGW;
                imageView = this.fGW.fGV;
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
