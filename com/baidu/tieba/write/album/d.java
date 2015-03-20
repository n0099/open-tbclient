package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ b cty;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.cty = bVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        h hVar;
        n nVar;
        h hVar2;
        int i3;
        n nVar2;
        ImageView imageView;
        ImageView imageView2;
        this.cty.mCurrentIndex = i;
        b bVar = this.cty;
        i2 = this.cty.mCurrentIndex;
        bVar.iM(i2 + 1);
        hVar = this.cty.ctv;
        if (hVar != null) {
            nVar = this.cty.ctp;
            if (nVar != null) {
                hVar2 = this.cty.ctv;
                i3 = this.cty.mCurrentIndex;
                ImageFileInfo iN = hVar2.iN(i3);
                nVar2 = this.cty.ctp;
                if (nVar2.isAdded(iN)) {
                    b bVar2 = this.cty;
                    imageView2 = this.cty.ctw;
                    bVar2.b(imageView2, true);
                    return;
                }
                b bVar3 = this.cty;
                imageView = this.cty.ctw;
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
