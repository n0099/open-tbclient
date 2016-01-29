package com.baidu.tieba.image;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
class s implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        boolean z;
        j jVar;
        j jVar2;
        int i2;
        int i3;
        int i4;
        boolean aiB;
        a aVar;
        int i5;
        z = this.this$0.coZ;
        if (!z) {
            jVar = this.this$0.coT;
            if (jVar != null && i > this.this$0.coR.getItemNum() - 5) {
                jVar2 = this.this$0.coT;
                jVar2.aiq();
            }
        } else {
            Intent intent = new Intent(TbConfig.getBroadcastActionPageChanged());
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.this$0.getPageContext().getPageActivity().sendBroadcast(intent);
        }
        ImageViewerActivity imageViewerActivity = this.this$0;
        i2 = this.this$0.mIndex;
        imageViewerActivity.at(i2, i);
        this.this$0.mIndex = i;
        this.this$0.aiA();
        this.this$0.aiG();
        i3 = this.this$0.cpg;
        i4 = this.this$0.mIndex;
        if (i3 < i4) {
            ImageViewerActivity imageViewerActivity2 = this.this$0;
            i5 = this.this$0.mIndex;
            imageViewerActivity2.cpg = i5;
        }
        aiB = this.this$0.aiB();
        if (aiB) {
            aVar = this.this$0.cpb;
            aVar.aif();
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
            j = this.this$0.coU;
            if (nanoTime - j > 300000000 && this.this$0.coJ != null) {
                i2 = this.this$0.mIndex;
                if (i2 < this.this$0.coJ.size()) {
                    hashMap = this.this$0.coV;
                    ArrayList arrayList = this.this$0.coJ;
                    i3 = this.this$0.mIndex;
                    hashMap.put((String) arrayList.get(i3), true);
                }
            }
        }
    }
}
