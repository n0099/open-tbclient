package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ b cye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.cye = bVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        j jVar;
        p pVar;
        j jVar2;
        int i3;
        p pVar2;
        ImageView imageView;
        ImageView imageView2;
        this.cye.mCurrentIndex = i;
        b bVar = this.cye;
        i2 = this.cye.mCurrentIndex;
        bVar.jl(i2 + 1);
        jVar = this.cye.cyb;
        if (jVar != null) {
            pVar = this.cye.cxV;
            if (pVar != null) {
                jVar2 = this.cye.cyb;
                i3 = this.cye.mCurrentIndex;
                ImageFileInfo jm = jVar2.jm(i3);
                pVar2 = this.cye.cxV;
                if (pVar2.isAdded(jm)) {
                    b bVar2 = this.cye;
                    imageView2 = this.cye.cyc;
                    bVar2.b(imageView2, true);
                    return;
                }
                b bVar3 = this.cye;
                imageView = this.cye.cyc;
                bVar3.b(imageView, false);
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
