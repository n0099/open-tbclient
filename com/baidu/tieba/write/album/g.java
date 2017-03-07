package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e fLq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.fLq = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        j jVar;
        o oVar;
        o oVar2;
        j jVar2;
        int i3;
        ImageFileInfo sP;
        o oVar3;
        ImageView imageView;
        ImageView imageView2;
        j jVar3;
        int i4;
        this.fLq.aBB = i;
        e eVar = this.fLq;
        i2 = this.fLq.aBB;
        eVar.sO(i2 + 1);
        jVar = this.fLq.fLo;
        if (jVar != null) {
            oVar = this.fLq.fKY;
            if (oVar != null) {
                oVar2 = this.fLq.fKY;
                if ("-1".equals(oVar2.bmT())) {
                    jVar3 = this.fLq.fLo;
                    i4 = this.fLq.aBB;
                    sP = jVar3.sP(i4 + 1);
                } else {
                    jVar2 = this.fLq.fLo;
                    i3 = this.fLq.aBB;
                    sP = jVar2.sP(i3);
                }
                oVar3 = this.fLq.fKY;
                if (oVar3.isAdded(sP)) {
                    e eVar2 = this.fLq;
                    imageView2 = this.fLq.fLp;
                    eVar2.b(imageView2, true);
                    return;
                }
                e eVar3 = this.fLq;
                imageView = this.fLq.fLp;
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
