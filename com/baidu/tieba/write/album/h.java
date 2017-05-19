package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ViewPager.OnPageChangeListener {
    final /* synthetic */ f fMr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.fMr = fVar;
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
        this.fMr.aBS = i;
        kVar = this.fMr.fMn;
        if (kVar != null) {
            pVar = this.fMr.fLQ;
            if (pVar != null) {
                kVar2 = this.fMr.fMn;
                i2 = this.fMr.aBS;
                ImageFileInfo sN = kVar2.sN(i2);
                pVar2 = this.fMr.fLQ;
                if (pVar2.isAdded(sN)) {
                    f fVar = this.fMr;
                    imageView2 = this.fMr.fMo;
                    fVar.c(imageView2, true);
                    return;
                }
                f fVar2 = this.fMr;
                imageView = this.fMr.fMo;
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
