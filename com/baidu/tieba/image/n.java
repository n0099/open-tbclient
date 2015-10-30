package com.baidu.tieba.image;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.view.z;
/* loaded from: classes.dex */
class n implements z.b {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.z.b
    public void zm() {
        String str;
        String str2;
        aq aqVar = new aq("c10351");
        str = this.this$0.bOS;
        aq ae = aqVar.ae("tid", str);
        str2 = this.this$0.mFrom;
        TiebaStatic.log(ae.ae("obj_type", str2));
    }
}
