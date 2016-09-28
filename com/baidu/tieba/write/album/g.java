package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e gcs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.gcs = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        j jVar;
        o oVar;
        o oVar2;
        j jVar2;
        int i3;
        ImageFileInfo tk;
        o oVar3;
        ImageView imageView;
        ImageView imageView2;
        j jVar3;
        int i4;
        this.gcs.awO = i;
        e eVar = this.gcs;
        i2 = this.gcs.awO;
        eVar.tj(i2 + 1);
        jVar = this.gcs.gcq;
        if (jVar != null) {
            oVar = this.gcs.gbZ;
            if (oVar != null) {
                oVar2 = this.gcs.gbZ;
                if ("-1".equals(oVar2.bst())) {
                    jVar3 = this.gcs.gcq;
                    i4 = this.gcs.awO;
                    tk = jVar3.tk(i4 + 1);
                } else {
                    jVar2 = this.gcs.gcq;
                    i3 = this.gcs.awO;
                    tk = jVar2.tk(i3);
                }
                oVar3 = this.gcs.gbZ;
                if (oVar3.isAdded(tk)) {
                    e eVar2 = this.gcs;
                    imageView2 = this.gcs.gcr;
                    eVar2.b(imageView2, true);
                    return;
                }
                e eVar3 = this.gcs;
                imageView = this.gcs.gcr;
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
