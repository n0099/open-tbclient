package com.baidu.tieba.pb.interactionpopupwindow;

import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends a<e, CustomDialogData> {
    public d(TbPageContext tbPageContext, CustomDialogData customDialogData) {
        super(tbPageContext, new e(tbPageContext), customDialogData);
        if (this.fpI instanceof e) {
            ((e) this.fpI).a(this);
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean XZ() {
        return true;
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean Ya() {
        return true;
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public int wZ() {
        return l.e(this.mContext, d.e.ds90);
    }
}
