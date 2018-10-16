package com.baidu.tieba.pb.interactionpopupwindow;

import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class d extends a<e, CustomDialogData> {
    public d(TbPageContext tbPageContext, CustomDialogData customDialogData) {
        super(tbPageContext, new e(tbPageContext), customDialogData);
        if (this.fIQ instanceof e) {
            ((e) this.fIQ).a(this);
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean ael() {
        return true;
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean aem() {
        return true;
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public int At() {
        return l.h(this.mContext, e.C0175e.ds90);
    }
}
