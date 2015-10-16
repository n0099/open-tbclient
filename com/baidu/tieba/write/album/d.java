package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ b djZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.djZ = bVar;
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
        this.djZ.apZ = i;
        b bVar = this.djZ;
        i2 = this.djZ.apZ;
        bVar.lH(i2 + 1);
        gVar = this.djZ.djX;
        if (gVar != null) {
            lVar = this.djZ.djP;
            if (lVar != null) {
                gVar2 = this.djZ.djX;
                i3 = this.djZ.apZ;
                ImageFileInfo lI = gVar2.lI(i3);
                lVar2 = this.djZ.djP;
                if (lVar2.isAdded(lI)) {
                    b bVar2 = this.djZ;
                    imageView2 = this.djZ.djY;
                    bVar2.b(imageView2, true);
                    return;
                }
                b bVar3 = this.djZ;
                imageView = this.djZ.djY;
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
