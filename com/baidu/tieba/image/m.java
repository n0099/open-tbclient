package com.baidu.tieba.image;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.view.u;
/* loaded from: classes.dex */
class m implements u.b {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.u.b
    public void Bt() {
        String str;
        String str2;
        au auVar = new au("c10351");
        str = this.this$0.coe;
        au aa = auVar.aa("tid", str);
        str2 = this.this$0.aer;
        TiebaStatic.log(aa.aa("obj_type", str2));
    }
}
