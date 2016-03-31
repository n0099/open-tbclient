package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e eGV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.eGV = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        j jVar;
        o oVar;
        o oVar2;
        j jVar2;
        int i3;
        ImageFileInfo qo;
        o oVar3;
        ImageView imageView;
        ImageView imageView2;
        j jVar3;
        int i4;
        this.eGV.awy = i;
        e eVar = this.eGV;
        i2 = this.eGV.awy;
        eVar.qn(i2 + 1);
        jVar = this.eGV.eGT;
        if (jVar != null) {
            oVar = this.eGV.eGD;
            if (oVar != null) {
                oVar2 = this.eGV.eGD;
                if ("-1".equals(oVar2.aZj())) {
                    jVar3 = this.eGV.eGT;
                    i4 = this.eGV.awy;
                    qo = jVar3.qo(i4 + 1);
                } else {
                    jVar2 = this.eGV.eGT;
                    i3 = this.eGV.awy;
                    qo = jVar2.qo(i3);
                }
                oVar3 = this.eGV.eGD;
                if (oVar3.isAdded(qo)) {
                    e eVar2 = this.eGV;
                    imageView2 = this.eGV.eGU;
                    eVar2.b(imageView2, true);
                    return;
                }
                e eVar3 = this.eGV;
                imageView = this.eGV.eGU;
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
