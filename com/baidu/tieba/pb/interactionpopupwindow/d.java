package com.baidu.tieba.pb.interactionpopupwindow;

import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends a<e, CustomDialogData> {
    public d(TbPageContext tbPageContext, CustomDialogData customDialogData) {
        super(tbPageContext, new e(tbPageContext), customDialogData);
        if (this.jFG instanceof e) {
            ((e) this.jFG).a(this);
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean GT() {
        return true;
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public boolean GU() {
        return true;
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.f
    public int getDialogMargin() {
        return l.getDimens(this.mContext, R.dimen.ds90);
    }
}
