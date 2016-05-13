package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e eXO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.eXO = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        j jVar;
        o oVar;
        o oVar2;
        j jVar2;
        int i3;
        ImageFileInfo qK;
        o oVar3;
        ImageView imageView;
        ImageView imageView2;
        j jVar3;
        int i4;
        this.eXO.asz = i;
        e eVar = this.eXO;
        i2 = this.eXO.asz;
        eVar.qJ(i2 + 1);
        jVar = this.eXO.eXM;
        if (jVar != null) {
            oVar = this.eXO.eXw;
            if (oVar != null) {
                oVar2 = this.eXO.eXw;
                if ("-1".equals(oVar2.bbF())) {
                    jVar3 = this.eXO.eXM;
                    i4 = this.eXO.asz;
                    qK = jVar3.qK(i4 + 1);
                } else {
                    jVar2 = this.eXO.eXM;
                    i3 = this.eXO.asz;
                    qK = jVar2.qK(i3);
                }
                oVar3 = this.eXO.eXw;
                if (oVar3.isAdded(qK)) {
                    e eVar2 = this.eXO;
                    imageView2 = this.eXO.eXN;
                    eVar2.b(imageView2, true);
                    return;
                }
                e eVar3 = this.eXO;
                imageView = this.eXO.eXN;
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
