package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ b djz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.djz = bVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        g gVar;
        l lVar;
        g gVar2;
        int i3;
        l lVar2;
        ImageView imageView;
        ImageView imageView2;
        this.djz.apY = i;
        b bVar = this.djz;
        i2 = this.djz.apY;
        bVar.lF(i2 + 1);
        gVar = this.djz.djx;
        if (gVar != null) {
            lVar = this.djz.djp;
            if (lVar != null) {
                gVar2 = this.djz.djx;
                i3 = this.djz.apY;
                ImageFileInfo lG = gVar2.lG(i3);
                lVar2 = this.djz.djp;
                if (lVar2.isAdded(lG)) {
                    b bVar2 = this.djz;
                    imageView2 = this.djz.djy;
                    bVar2.b(imageView2, true);
                    return;
                }
                b bVar3 = this.djz;
                imageView = this.djz.djy;
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
