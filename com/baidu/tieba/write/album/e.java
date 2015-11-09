package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class e implements ViewPager.OnPageChangeListener {
    final /* synthetic */ c dlH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.dlH = cVar;
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
        this.dlH.aru = i;
        c cVar = this.dlH;
        i2 = this.dlH.aru;
        cVar.lV(i2 + 1);
        hVar = this.dlH.dlF;
        if (hVar != null) {
            mVar = this.dlH.dlv;
            if (mVar != null) {
                hVar2 = this.dlH.dlF;
                i3 = this.dlH.aru;
                ImageFileInfo lW = hVar2.lW(i3);
                mVar2 = this.dlH.dlv;
                if (mVar2.isAdded(lW)) {
                    c cVar2 = this.dlH;
                    imageView2 = this.dlH.dlG;
                    cVar2.b(imageView2, true);
                    return;
                }
                c cVar3 = this.dlH;
                imageView = this.dlH.dlG;
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
