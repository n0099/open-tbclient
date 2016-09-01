package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e gaj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.gaj = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        j jVar;
        o oVar;
        o oVar2;
        j jVar2;
        int i3;
        ImageFileInfo sW;
        o oVar3;
        ImageView imageView;
        ImageView imageView2;
        j jVar3;
        int i4;
        this.gaj.axl = i;
        e eVar = this.gaj;
        i2 = this.gaj.axl;
        eVar.sV(i2 + 1);
        jVar = this.gaj.gah;
        if (jVar != null) {
            oVar = this.gaj.fZQ;
            if (oVar != null) {
                oVar2 = this.gaj.fZQ;
                if ("-1".equals(oVar2.brN())) {
                    jVar3 = this.gaj.gah;
                    i4 = this.gaj.axl;
                    sW = jVar3.sW(i4 + 1);
                } else {
                    jVar2 = this.gaj.gah;
                    i3 = this.gaj.axl;
                    sW = jVar2.sW(i3);
                }
                oVar3 = this.gaj.fZQ;
                if (oVar3.isAdded(sW)) {
                    e eVar2 = this.gaj;
                    imageView2 = this.gaj.gai;
                    eVar2.b(imageView2, true);
                    return;
                }
                e eVar3 = this.gaj;
                imageView = this.gaj.gai;
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
