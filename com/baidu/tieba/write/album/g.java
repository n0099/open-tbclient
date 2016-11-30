package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e gjX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.gjX = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        j jVar;
        o oVar;
        o oVar2;
        j jVar2;
        int i3;
        ImageFileInfo tG;
        o oVar3;
        ImageView imageView;
        ImageView imageView2;
        j jVar3;
        int i4;
        this.gjX.axF = i;
        e eVar = this.gjX;
        i2 = this.gjX.axF;
        eVar.tF(i2 + 1);
        jVar = this.gjX.gjV;
        if (jVar != null) {
            oVar = this.gjX.gjE;
            if (oVar != null) {
                oVar2 = this.gjX.gjE;
                if ("-1".equals(oVar2.buO())) {
                    jVar3 = this.gjX.gjV;
                    i4 = this.gjX.axF;
                    tG = jVar3.tG(i4 + 1);
                } else {
                    jVar2 = this.gjX.gjV;
                    i3 = this.gjX.axF;
                    tG = jVar2.tG(i3);
                }
                oVar3 = this.gjX.gjE;
                if (oVar3.isAdded(tG)) {
                    e eVar2 = this.gjX;
                    imageView2 = this.gjX.gjW;
                    eVar2.b(imageView2, true);
                    return;
                }
                e eVar3 = this.gjX;
                imageView = this.gjX.gjW;
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
