package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ao extends PbListView {
    TbPageContext<?> context;

    public ao(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(t.e.ds16), 0, 0);
        xp();
        dh(t.f.pb_foot_more_trans_selector);
        di(t.f.pb_foot_more_trans_selector);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void xv() {
        super.xv();
        setText(this.context.getResources().getString(t.j.list_no_more));
        getView().setVisibility(0);
    }
}
