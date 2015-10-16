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
        boolean aak;
        a aVar;
        z = this.this$0.bPM;
        if (!z) {
            jVar = this.this$0.bPG;
            if (jVar != null && i > this.this$0.bPE.getItemNum() - 5) {
                jVar2 = this.this$0.bPG;
                jVar2.aad();
            }
        } else {
            Intent intent = new Intent(TbConfig.getBroadcastActionPageChanged());
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.this$0.getPageContext().getPageActivity().sendBroadcast(intent);
        }
        ImageViewerActivity imageViewerActivity = this.this$0;
        i2 = this.this$0.mIndex;
        imageViewerActivity.ad(i2, i);
        this.this$0.mIndex = i;
        this.this$0.aaj();
        this.this$0.aap();
        aak = this.this$0.aak();
        if (aak) {
            aVar = this.this$0.bPO;
            aVar.ZQ();
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
            j = this.this$0.bPH;
            if (nanoTime - j > 300000000 && this.this$0.bPx != null) {
                i2 = this.this$0.mIndex;
                if (i2 < this.this$0.bPx.size()) {
                    hashMap = this.this$0.bPI;
                    ArrayList arrayList = this.this$0.bPx;
                    i3 = this.this$0.mIndex;
                    hashMap.put((String) arrayList.get(i3), true);
                }
            }
        }
    }
}
