package com.baidu.tieba.image;

import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.image.j;
import java.util.ArrayList;
/* loaded from: classes.dex */
class t implements j.b {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // com.baidu.tieba.image.j.b
    public void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, com.baidu.tbadk.core.data.c cVar) {
        int i3;
        this.this$0.hideProgressBar();
        if (z2 && this.this$0.coR.getCurrentItem() <= 4) {
            int itemNum = this.this$0.coR.getItemNum();
            this.this$0.coR.setTempSize(itemNum + 100);
            this.this$0.coR.setCurrentItem(itemNum + 90, false);
            this.this$0.coR.setTempSize(0);
        }
        this.this$0.coR.setUrlData(arrayList);
        this.this$0.coR.setAssistUrls(this.this$0.coM);
        this.this$0.coR.setHasNext(z);
        this.this$0.coR.setNextTitle(str);
        if (i >= 0 && i < this.this$0.coR.getItemNum()) {
            this.this$0.coR.setCurrentItem(i, false);
        }
        if (i2 != 0) {
            this.this$0.wS = i2;
        }
        if (arrayList.size() >= 400 && this.this$0.coR.getCurrentItem() > 200) {
            for (int i4 = 0; i4 < 200; i4++) {
                arrayList.remove(0);
            }
            this.this$0.coR.setUrlData(arrayList);
            ImageViewerActivity imageViewerActivity = this.this$0;
            i3 = imageViewerActivity.coH;
            imageViewerActivity.coH = i3 + 200;
            this.this$0.coR.setCurrentItem(this.this$0.coR.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
        }
        this.this$0.aiA();
        a(arrayList, cVar);
    }

    private void a(ArrayList<String> arrayList, com.baidu.tbadk.core.data.c cVar) {
        a aVar;
        a aVar2;
        if (cVar == null || arrayList == null) {
            this.this$0.coR.setAddSize(0);
            return;
        }
        aVar = this.this$0.cpb;
        aVar.e(cVar, arrayList.size());
        aVar2 = this.this$0.cpb;
        if (aVar2.aib()) {
            this.this$0.coR.setAddSize(1);
        } else {
            this.this$0.coR.setAddSize(0);
        }
    }

    @Override // com.baidu.tieba.image.j.b
    public void I(int i, String str) {
        this.this$0.hideProgressBar();
        this.this$0.showToast(str);
        if (i == 40) {
            this.this$0.wS = this.this$0.coJ.size();
            this.this$0.aiA();
        }
    }
}
