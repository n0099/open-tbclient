package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ b cyd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.cyd = bVar;
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
        this.cyd.mCurrentIndex = i;
        b bVar = this.cyd;
        i2 = this.cyd.mCurrentIndex;
        bVar.jl(i2 + 1);
        jVar = this.cyd.cya;
        if (jVar != null) {
            pVar = this.cyd.cxU;
            if (pVar != null) {
                jVar2 = this.cyd.cya;
                i3 = this.cyd.mCurrentIndex;
                ImageFileInfo jm = jVar2.jm(i3);
                pVar2 = this.cyd.cxU;
                if (pVar2.isAdded(jm)) {
                    b bVar2 = this.cyd;
                    imageView2 = this.cyd.cyb;
                    bVar2.b(imageView2, true);
                    return;
                }
                b bVar3 = this.cyd;
                imageView = this.cyd.cyb;
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
