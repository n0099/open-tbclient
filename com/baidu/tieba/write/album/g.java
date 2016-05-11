package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e eXP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.eXP = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        j jVar;
        o oVar;
        o oVar2;
        j jVar2;
        int i3;
        ImageFileInfo qL;
        o oVar3;
        ImageView imageView;
        ImageView imageView2;
        j jVar3;
        int i4;
        this.eXP.asz = i;
        e eVar = this.eXP;
        i2 = this.eXP.asz;
        eVar.qK(i2 + 1);
        jVar = this.eXP.eXN;
        if (jVar != null) {
            oVar = this.eXP.eXx;
            if (oVar != null) {
                oVar2 = this.eXP.eXx;
                if ("-1".equals(oVar2.bby())) {
                    jVar3 = this.eXP.eXN;
                    i4 = this.eXP.asz;
                    qL = jVar3.qL(i4 + 1);
                } else {
                    jVar2 = this.eXP.eXN;
                    i3 = this.eXP.asz;
                    qL = jVar2.qL(i3);
                }
                oVar3 = this.eXP.eXx;
                if (oVar3.isAdded(qL)) {
                    e eVar2 = this.eXP;
                    imageView2 = this.eXP.eXO;
                    eVar2.b(imageView2, true);
                    return;
                }
                e eVar3 = this.eXP;
                imageView = this.eXP.eXO;
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
