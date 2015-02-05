package com.baidu.tieba.image;

import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class m implements c {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // com.baidu.tieba.image.c
    public void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2) {
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        MultiImageView multiImageView3;
        MultiImageView multiImageView4;
        MultiImageView multiImageView5;
        int i3;
        MultiImageView multiImageView6;
        MultiImageView multiImageView7;
        MultiImageView multiImageView8;
        MultiImageView multiImageView9;
        MultiImageView multiImageView10;
        MultiImageView multiImageView11;
        MultiImageView multiImageView12;
        MultiImageView multiImageView13;
        MultiImageView multiImageView14;
        if (z2) {
            multiImageView10 = this.this$0.brO;
            if (multiImageView10.getCurrentItem() <= 4) {
                multiImageView11 = this.this$0.brO;
                int itemNum = multiImageView11.getItemNum();
                multiImageView12 = this.this$0.brO;
                multiImageView12.setTempSize(itemNum + 100);
                multiImageView13 = this.this$0.brO;
                multiImageView13.setCurrentItem(itemNum + 90, false);
                multiImageView14 = this.this$0.brO;
                multiImageView14.setTempSize(0);
            }
        }
        multiImageView = this.this$0.brO;
        multiImageView.setUrlData(arrayList);
        multiImageView2 = this.this$0.brO;
        multiImageView2.setHasNext(z);
        multiImageView3 = this.this$0.brO;
        multiImageView3.setNextTitle(str);
        if (i >= 0) {
            multiImageView8 = this.this$0.brO;
            if (i < multiImageView8.getItemNum()) {
                multiImageView9 = this.this$0.brO;
                multiImageView9.setCurrentItem(i, false);
            }
        }
        if (i2 != 0) {
            this.this$0.mCount = i2;
        }
        if (arrayList.size() >= 400) {
            multiImageView4 = this.this$0.brO;
            if (multiImageView4.getCurrentItem() > 200) {
                for (int i4 = 0; i4 < 200; i4++) {
                    arrayList.remove(0);
                }
                multiImageView5 = this.this$0.brO;
                multiImageView5.setUrlData(arrayList);
                ImageViewerActivity imageViewerActivity = this.this$0;
                i3 = imageViewerActivity.brG;
                imageViewerActivity.brG = i3 + 200;
                multiImageView6 = this.this$0.brO;
                multiImageView7 = this.this$0.brO;
                multiImageView6.setCurrentItem(multiImageView7.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
            }
        }
        this.this$0.TS();
    }

    @Override // com.baidu.tieba.image.c
    public void x(int i, String str) {
        ArrayList arrayList;
        this.this$0.showToast(str);
        if (i == 40) {
            ImageViewerActivity imageViewerActivity = this.this$0;
            arrayList = this.this$0.brH;
            imageViewerActivity.mCount = arrayList.size();
            this.this$0.TS();
        }
    }
}
