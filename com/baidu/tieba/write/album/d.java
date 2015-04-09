package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ b ctO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.ctO = bVar;
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
        this.ctO.mCurrentIndex = i;
        b bVar = this.ctO;
        i2 = this.ctO.mCurrentIndex;
        bVar.iP(i2 + 1);
        hVar = this.ctO.ctL;
        if (hVar != null) {
            nVar = this.ctO.ctF;
            if (nVar != null) {
                hVar2 = this.ctO.ctL;
                i3 = this.ctO.mCurrentIndex;
                ImageFileInfo iQ = hVar2.iQ(i3);
                nVar2 = this.ctO.ctF;
                if (nVar2.isAdded(iQ)) {
                    b bVar2 = this.ctO;
                    imageView2 = this.ctO.ctM;
                    bVar2.b(imageView2, true);
                    return;
                }
                b bVar3 = this.ctO;
                imageView = this.ctO.ctM;
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
