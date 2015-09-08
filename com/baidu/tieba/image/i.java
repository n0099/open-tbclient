package com.baidu.tieba.image;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
class i implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        boolean z;
        a aVar;
        a aVar2;
        int i2;
        z = this.this$0.bMd;
        if (!z) {
            aVar = this.this$0.bLX;
            if (aVar != null && i > this.this$0.bLV.getItemNum() - 5) {
                aVar2 = this.this$0.bLX;
                aVar2.YY();
            }
        } else {
            Intent intent = new Intent(TbConfig.getBroadcastActionPageChanged());
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.this$0.getPageContext().getPageActivity().sendBroadcast(intent);
        }
        ImageViewerActivity imageViewerActivity = this.this$0;
        i2 = this.this$0.mIndex;
        imageViewerActivity.ac(i2, i);
        this.this$0.mIndex = i;
        this.this$0.Ze();
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
            j = this.this$0.bLY;
            if (nanoTime - j > 300000000 && this.this$0.bLO != null) {
                i2 = this.this$0.mIndex;
                if (i2 < this.this$0.bLO.size()) {
                    hashMap = this.this$0.bLZ;
                    ArrayList arrayList = this.this$0.bLO;
                    i3 = this.this$0.mIndex;
                    hashMap.put((String) arrayList.get(i3), true);
                }
            }
        }
    }
}
