package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class e implements ViewPager.OnPageChangeListener {
    final /* synthetic */ c cPT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.cPT = cVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        h hVar;
        m mVar;
        h hVar2;
        int i3;
        m mVar2;
        ImageView imageView;
        ImageView imageView2;
        this.cPT.apO = i;
        c cVar = this.cPT;
        i2 = this.cPT.apO;
        cVar.kf(i2 + 1);
        hVar = this.cPT.cPR;
        if (hVar != null) {
            mVar = this.cPT.cPJ;
            if (mVar != null) {
                hVar2 = this.cPT.cPR;
                i3 = this.cPT.apO;
                ImageFileInfo kg = hVar2.kg(i3);
                mVar2 = this.cPT.cPJ;
                if (mVar2.isAdded(kg)) {
                    c cVar2 = this.cPT;
                    imageView2 = this.cPT.cPS;
                    cVar2.b(imageView2, true);
                    return;
                }
                c cVar3 = this.cPT;
                imageView = this.cPT.cPS;
                cVar3.b(imageView, false);
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
