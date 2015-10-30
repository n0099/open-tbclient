package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class aj extends PbListView {
    TbPageContext<?> context;

    public aj(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(i.d.ds16), 0, 0);
        vu();
        cL(i.e.pb_foot_more_trans_selector);
        cM(i.e.pb_foot_more_trans_selector);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void vv() {
        super.vv();
        setText(this.context.getResources().getString(i.h.list_no_more));
        getView().setVisibility(0);
    }
}
