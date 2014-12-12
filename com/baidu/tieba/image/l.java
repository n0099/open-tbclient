package com.baidu.tieba.image;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
class l implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        boolean z;
        a aVar;
        MultiImageView multiImageView;
        a aVar2;
        int i2;
        z = this.this$0.bqz;
        if (!z) {
            aVar = this.this$0.bqt;
            if (aVar != null) {
                multiImageView = this.this$0.bqr;
                if (i > multiImageView.getItemNum() - 5) {
                    aVar2 = this.this$0.bqt;
                    aVar2.Tu();
                }
            }
        } else {
            Intent intent = new Intent(TbConfig.getBroadcastActionPageChanged());
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.this$0.getPageContext().getPageActivity().sendBroadcast(intent);
        }
        ImageViewerActivity imageViewerActivity = this.this$0;
        i2 = this.this$0.mIndex;
        imageViewerActivity.N(i2, i);
        this.this$0.mIndex = i;
        this.this$0.TB();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        long j;
        ArrayList arrayList;
        int i2;
        ArrayList arrayList2;
        HashMap hashMap;
        ArrayList arrayList3;
        int i3;
        if (i == 1) {
            long nanoTime = System.nanoTime();
            j = this.this$0.bqu;
            if (nanoTime - j > 300000000) {
                arrayList = this.this$0.bqk;
                if (arrayList != null) {
                    i2 = this.this$0.mIndex;
                    arrayList2 = this.this$0.bqk;
                    if (i2 < arrayList2.size()) {
                        hashMap = this.this$0.bqv;
                        arrayList3 = this.this$0.bqk;
                        i3 = this.this$0.mIndex;
                        hashMap.put((String) arrayList3.get(i3), true);
                    }
                }
            }
        }
    }
}
