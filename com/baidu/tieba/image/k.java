package com.baidu.tieba.image;

import android.content.Intent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.core.view.a {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // com.baidu.tbadk.core.view.a
    public void ci(int i) {
        boolean z;
        a aVar;
        z = this.this$0.brX;
        if (z) {
            Intent intent = new Intent(TbConfig.getBroadcastActionPageChanged());
            intent.putExtra(ImageViewerConfig.INDEX, -1);
            intent.putExtra("state", i);
            this.this$0.getPageContext().getPageActivity().sendBroadcast(intent);
        } else if (i == 0) {
            aVar = this.this$0.brR;
            aVar.TR();
        }
    }
}
