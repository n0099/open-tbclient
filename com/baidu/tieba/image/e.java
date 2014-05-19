package com.baidu.tieba.image;

import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class e implements c {
    final /* synthetic */ ImageViewerActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ImageViewerActivity imageViewerActivity) {
        this.a = imageViewerActivity;
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
            multiImageView10 = this.a.m;
            if (multiImageView10.getCurrentItem() <= 3) {
                multiImageView11 = this.a.m;
                int itemNum = multiImageView11.getItemNum();
                multiImageView12 = this.a.m;
                multiImageView12.setTempSize(itemNum + 100);
                multiImageView13 = this.a.m;
                multiImageView13.a(itemNum + 90, false);
                multiImageView14 = this.a.m;
                multiImageView14.setTempSize(0);
            }
        }
        multiImageView = this.a.m;
        multiImageView.setUrlData(arrayList);
        multiImageView2 = this.a.m;
        multiImageView2.setHasNext(z);
        multiImageView3 = this.a.m;
        multiImageView3.setNextTitle(str);
        if (i >= 0) {
            multiImageView8 = this.a.m;
            if (i < multiImageView8.getItemNum()) {
                multiImageView9 = this.a.m;
                multiImageView9.a(i, false);
            }
        }
        if (i2 != 0) {
            this.a.e = i2;
        }
        if (arrayList.size() >= 400) {
            multiImageView4 = this.a.m;
            if (multiImageView4.getCurrentItem() > 200) {
                for (int i4 = 0; i4 < 200; i4++) {
                    arrayList.remove(0);
                }
                multiImageView5 = this.a.m;
                multiImageView5.setUrlData(arrayList);
                ImageViewerActivity imageViewerActivity = this.a;
                i3 = imageViewerActivity.b;
                imageViewerActivity.b = i3 + Constants.MEDIA_INFO;
                multiImageView6 = this.a.m;
                multiImageView7 = this.a.m;
                multiImageView6.a(multiImageView7.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
            }
        }
        this.a.f();
    }

    @Override // com.baidu.tieba.image.c
    public void a(int i, String str) {
        ArrayList arrayList;
        this.a.showToast(str);
        if (i == 40) {
            ImageViewerActivity imageViewerActivity = this.a;
            arrayList = this.a.c;
            imageViewerActivity.e = arrayList.size();
            this.a.f();
        }
    }
}
