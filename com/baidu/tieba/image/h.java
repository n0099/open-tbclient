package com.baidu.tieba.image;

import android.content.Intent;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
/* loaded from: classes.dex */
class h implements BaseViewPager.a {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager.a
    public void cA(int i) {
        boolean z;
        a aVar;
        z = this.this$0.bMd;
        if (z) {
            Intent intent = new Intent(TbConfig.getBroadcastActionPageChanged());
            intent.putExtra(ImageViewerConfig.INDEX, -1);
            intent.putExtra(SocialConstants.PARAM_STATE, i);
            this.this$0.getPageContext().getPageActivity().sendBroadcast(intent);
        } else if (i == 0) {
            aVar = this.this$0.bLX;
            aVar.YZ();
        }
    }
}
