package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e dKN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.dKN = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        j jVar;
        o oVar;
        o oVar2;
        j jVar2;
        int i3;
        ImageFileInfo ni;
        o oVar3;
        ImageView imageView;
        ImageView imageView2;
        j jVar3;
        int i4;
        this.dKN.atv = i;
        e eVar = this.dKN;
        i2 = this.dKN.atv;
        eVar.nh(i2 + 1);
        jVar = this.dKN.dKL;
        if (jVar != null) {
            oVar = this.dKN.dKx;
            if (oVar != null) {
                oVar2 = this.dKN.dKx;
                if ("-1".equals(oVar2.aHC())) {
                    jVar3 = this.dKN.dKL;
                    i4 = this.dKN.atv;
                    ni = jVar3.ni(i4 + 1);
                } else {
                    jVar2 = this.dKN.dKL;
                    i3 = this.dKN.atv;
                    ni = jVar2.ni(i3);
                }
                oVar3 = this.dKN.dKx;
                if (oVar3.isAdded(ni)) {
                    e eVar2 = this.dKN;
                    imageView2 = this.dKN.dKM;
                    eVar2.b(imageView2, true);
                    return;
                }
                e eVar3 = this.dKN;
                imageView = this.dKN.dKM;
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
