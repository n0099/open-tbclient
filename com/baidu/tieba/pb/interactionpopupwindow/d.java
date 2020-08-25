package com.baidu.tieba.pb.interactionpopupwindow;

import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class d extends a<e, CustomDialogData> {
    public d(TbPageContext tbPageContext, CustomDialogData customDialogData) {
        super(tbPageContext, new e(tbPageContext), customDialogData);
        if (this.kyw instanceof e) {
            ((e) this.kyw).a(this);
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean Of() {
        return true;
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean Og() {
        return true;
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public int getDialogMargin() {
        return l.getDimens(this.mContext, R.dimen.ds90);
    }
}
