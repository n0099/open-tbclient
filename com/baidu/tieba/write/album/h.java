package com.baidu.tieba.write.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ViewPager.OnPageChangeListener {
    final /* synthetic */ f geI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.geI = fVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        k kVar;
        p pVar;
        k kVar2;
        int i2;
        p pVar2;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        ImageView imageView2;
        this.geI.aCI = i;
        kVar = this.geI.geE;
        if (kVar != null) {
            pVar = this.geI.gei;
            if (pVar != null) {
                kVar2 = this.geI.geE;
                i2 = this.geI.aCI;
                ImageFileInfo tD = kVar2.tD(i2);
                pVar2 = this.geI.gei;
                if (pVar2.isAdded(tD)) {
                    f fVar = this.geI;
                    imageView2 = this.geI.geF;
                    fVar.c(imageView2, true);
                } else {
                    f fVar2 = this.geI;
                    imageView = this.geI.geF;
                    fVar2.c(imageView, false);
                }
                if (tD.isGif()) {
                    textView2 = this.geI.geH;
                    textView2.setVisibility(8);
                    return;
                }
                textView = this.geI.geH;
                textView.setVisibility(0);
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
