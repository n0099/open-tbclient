package com.baidu.tieba.image;

import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.image.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
class j implements a.b {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // com.baidu.tieba.image.a.b
    public void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2) {
        int i3;
        if (z2 && this.this$0.bLV.getCurrentItem() <= 4) {
            int itemNum = this.this$0.bLV.getItemNum();
            this.this$0.bLV.setTempSize(itemNum + 100);
            this.this$0.bLV.setCurrentItem(itemNum + 90, false);
            this.this$0.bLV.setTempSize(0);
        }
        this.this$0.bLV.setUrlData(arrayList);
        this.this$0.bLV.setHasNext(z);
        this.this$0.bLV.setNextTitle(str);
        if (i >= 0 && i < this.this$0.bLV.getItemNum()) {
            this.this$0.bLV.setCurrentItem(i, false);
        }
        if (i2 != 0) {
            this.this$0.wA = i2;
        }
        if (arrayList.size() >= 400 && this.this$0.bLV.getCurrentItem() > 200) {
            for (int i4 = 0; i4 < 200; i4++) {
                arrayList.remove(0);
            }
            this.this$0.bLV.setUrlData(arrayList);
            ImageViewerActivity imageViewerActivity = this.this$0;
            i3 = imageViewerActivity.bLN;
            imageViewerActivity.bLN = i3 + 200;
            this.this$0.bLV.setCurrentItem(this.this$0.bLV.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
        }
        this.this$0.Ze();
    }

    @Override // com.baidu.tieba.image.a.b
    public void D(int i, String str) {
        this.this$0.showToast(str);
        if (i == 40) {
            this.this$0.wA = this.this$0.bLO.size();
            this.this$0.Ze();
        }
    }
}
