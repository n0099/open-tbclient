package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e fCS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.fCS = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        j jVar;
        o oVar;
        o oVar2;
        j jVar2;
        int i3;
        ImageFileInfo sb;
        o oVar3;
        ImageView imageView;
        ImageView imageView2;
        j jVar3;
        int i4;
        this.fCS.atp = i;
        e eVar = this.fCS;
        i2 = this.fCS.atp;
        eVar.sa(i2 + 1);
        jVar = this.fCS.fCQ;
        if (jVar != null) {
            oVar = this.fCS.fCA;
            if (oVar != null) {
                oVar2 = this.fCS.fCA;
                if ("-1".equals(oVar2.bkb())) {
                    jVar3 = this.fCS.fCQ;
                    i4 = this.fCS.atp;
                    sb = jVar3.sb(i4 + 1);
                } else {
                    jVar2 = this.fCS.fCQ;
                    i3 = this.fCS.atp;
                    sb = jVar2.sb(i3);
                }
                oVar3 = this.fCS.fCA;
                if (oVar3.isAdded(sb)) {
                    e eVar2 = this.fCS;
                    imageView2 = this.fCS.fCR;
                    eVar2.b(imageView2, true);
                    return;
                }
                e eVar3 = this.fCS;
                imageView = this.fCS.fCR;
                eVar3.b(imageView, false);
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
