package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ViewPager.OnPageChangeListener {
    final /* synthetic */ f fTY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.fTY = fVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        k kVar;
        p pVar;
        k kVar2;
        int i2;
        p pVar2;
        ImageView imageView;
        ImageView imageView2;
        this.fTY.aBF = i;
        kVar = this.fTY.fTU;
        if (kVar != null) {
            pVar = this.fTY.fTx;
            if (pVar != null) {
                kVar2 = this.fTY.fTU;
                i2 = this.fTY.aBF;
                ImageFileInfo ti = kVar2.ti(i2);
                pVar2 = this.fTY.fTx;
                if (pVar2.isAdded(ti)) {
                    f fVar = this.fTY;
                    imageView2 = this.fTY.fTV;
                    fVar.c(imageView2, true);
                    return;
                }
                f fVar2 = this.fTY;
                imageView = this.fTY.fTV;
                fVar2.c(imageView, false);
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
