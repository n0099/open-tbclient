package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class an extends PbListView {
    TbPageContext<?> context;

    public an(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(t.e.ds16), 0, 0);
        wW();
        de(t.f.pb_foot_more_trans_selector);
        df(t.f.pb_foot_more_trans_selector);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void xc() {
        super.xc();
        setText(this.context.getResources().getString(t.j.list_no_more));
        getView().setVisibility(0);
    }
}
