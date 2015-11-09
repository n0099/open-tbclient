package com.baidu.tieba.image;

import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.image.j;
import java.util.ArrayList;
/* loaded from: classes.dex */
class u implements j.b {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // com.baidu.tieba.image.j.b
    public void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, com.baidu.tbadk.core.data.b bVar) {
        int i3;
        if (z2 && this.this$0.bPZ.getCurrentItem() <= 4) {
            int itemNum = this.this$0.bPZ.getItemNum();
            this.this$0.bPZ.setTempSize(itemNum + 100);
            this.this$0.bPZ.setCurrentItem(itemNum + 90, false);
            this.this$0.bPZ.setTempSize(0);
        }
        this.this$0.bPZ.setUrlData(arrayList);
        this.this$0.bPZ.setHasNext(z);
        this.this$0.bPZ.setNextTitle(str);
        if (i >= 0 && i < this.this$0.bPZ.getItemNum()) {
            this.this$0.bPZ.setCurrentItem(i, false);
        }
        if (i2 != 0) {
            this.this$0.wB = i2;
        }
        if (arrayList.size() >= 400 && this.this$0.bPZ.getCurrentItem() > 200) {
            for (int i4 = 0; i4 < 200; i4++) {
                arrayList.remove(0);
            }
            this.this$0.bPZ.setUrlData(arrayList);
            ImageViewerActivity imageViewerActivity = this.this$0;
            i3 = imageViewerActivity.bPR;
            imageViewerActivity.bPR = i3 + 200;
            this.this$0.bPZ.setCurrentItem(this.this$0.bPZ.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
        }
        this.this$0.aaA();
        a(arrayList, bVar);
    }

    private void a(ArrayList<String> arrayList, com.baidu.tbadk.core.data.b bVar) {
        a aVar;
        a aVar2;
        if (bVar == null || arrayList == null) {
            this.this$0.bPZ.setAddSize(0);
            return;
        }
        aVar = this.this$0.bQj;
        aVar.d(bVar, arrayList.size());
        aVar2 = this.this$0.bQj;
        if (aVar2.aad()) {
            this.this$0.bPZ.setAddSize(1);
        } else {
            this.this$0.bPZ.setAddSize(0);
        }
    }

    @Override // com.baidu.tieba.image.j.b
    public void F(int i, String str) {
        this.this$0.showToast(str);
        if (i == 40) {
            this.this$0.wB = this.this$0.bPS.size();
            this.this$0.aaA();
        }
    }
}
