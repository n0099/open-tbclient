package com.baidu.tieba.image;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
class t implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        boolean z;
        j jVar;
        j jVar2;
        int i2;
        boolean aeh;
        a aVar;
        z = this.this$0.cgu;
        if (!z) {
            jVar = this.this$0.cgo;
            if (jVar != null && i > this.this$0.cgm.getItemNum() - 5) {
                jVar2 = this.this$0.cgo;
                jVar2.aea();
            }
        } else {
            Intent intent = new Intent(TbConfig.getBroadcastActionPageChanged());
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.this$0.getPageContext().getPageActivity().sendBroadcast(intent);
        }
        ImageViewerActivity imageViewerActivity = this.this$0;
        i2 = this.this$0.mIndex;
        imageViewerActivity.ah(i2, i);
        this.this$0.mIndex = i;
        this.this$0.aeg();
        this.this$0.aem();
        aeh = this.this$0.aeh();
        if (aeh) {
            aVar = this.this$0.cgw;
            aVar.adN();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        long j;
        int i2;
        HashMap hashMap;
        int i3;
        if (i == 1) {
            long nanoTime = System.nanoTime();
            j = this.this$0.cgp;
            if (nanoTime - j > 300000000 && this.this$0.cgf != null) {
                i2 = this.this$0.mIndex;
                if (i2 < this.this$0.cgf.size()) {
                    hashMap = this.this$0.cgq;
                    ArrayList arrayList = this.this$0.cgf;
                    i3 = this.this$0.mIndex;
                    hashMap.put((String) arrayList.get(i3), true);
                }
            }
        }
    }
}
