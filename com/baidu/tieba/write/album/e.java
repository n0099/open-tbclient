package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class e implements ViewPager.OnPageChangeListener {
    final /* synthetic */ c cYE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.cYE = cVar;
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
        this.cYE.ary = i;
        c cVar = this.cYE;
        i2 = this.cYE.ary;
        cVar.kQ(i2 + 1);
        hVar = this.cYE.cYC;
        if (hVar != null) {
            mVar = this.cYE.cYt;
            if (mVar != null) {
                hVar2 = this.cYE.cYC;
                i3 = this.cYE.ary;
                ImageFileInfo kR = hVar2.kR(i3);
                mVar2 = this.cYE.cYt;
                if (mVar2.isAdded(kR)) {
                    c cVar2 = this.cYE;
                    imageView2 = this.cYE.cYD;
                    cVar2.b(imageView2, true);
                    return;
                }
                c cVar3 = this.cYE;
                imageView = this.cYE.cYD;
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
