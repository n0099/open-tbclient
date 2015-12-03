package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class am extends PbListView {
    TbPageContext<?> context;

    public am(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(n.d.ds16), 0, 0);
        we();
        cT(n.e.pb_foot_more_trans_selector);
        cU(n.e.pb_foot_more_trans_selector);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void wf() {
        super.wf();
        setText(this.context.getResources().getString(n.i.list_no_more));
        getView().setVisibility(0);
    }
}
