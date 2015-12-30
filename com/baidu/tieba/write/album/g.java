package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e dSm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.dSm = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        j jVar;
        o oVar;
        o oVar2;
        j jVar2;
        int i3;
        ImageFileInfo oa;
        o oVar3;
        ImageView imageView;
        ImageView imageView2;
        j jVar3;
        int i4;
        this.dSm.auZ = i;
        e eVar = this.dSm;
        i2 = this.dSm.auZ;
        eVar.nZ(i2 + 1);
        jVar = this.dSm.dSk;
        if (jVar != null) {
            oVar = this.dSm.dRW;
            if (oVar != null) {
                oVar2 = this.dSm.dRW;
                if ("-1".equals(oVar2.aJX())) {
                    jVar3 = this.dSm.dSk;
                    i4 = this.dSm.auZ;
                    oa = jVar3.oa(i4 + 1);
                } else {
                    jVar2 = this.dSm.dSk;
                    i3 = this.dSm.auZ;
                    oa = jVar2.oa(i3);
                }
                oVar3 = this.dSm.dRW;
                if (oVar3.isAdded(oa)) {
                    e eVar2 = this.dSm;
                    imageView2 = this.dSm.dSl;
                    eVar2.b(imageView2, true);
                    return;
                }
                e eVar3 = this.dSm;
                imageView = this.dSm.dSl;
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
