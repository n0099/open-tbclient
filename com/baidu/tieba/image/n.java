package com.baidu.tieba.image;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.view.z;
/* loaded from: classes.dex */
class n implements z.b {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.z.b
    public void Ad() {
        String str;
        String str2;
        av avVar = new av("c10351");
        str = this.this$0.cjE;
        av aa = avVar.aa("tid", str);
        str2 = this.this$0.mFrom;
        TiebaStatic.log(aa.aa("obj_type", str2));
    }
}
