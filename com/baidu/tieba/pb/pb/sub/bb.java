package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bb extends PbListView {
    TbPageContext<?> context;

    public bb(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(r.e.ds16), 0, tbPageContext.getResources().getDimensionPixelSize(r.e.ds74));
        wy();
        wA();
        wB();
        setTextSize(r.e.ds32);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void wG() {
        super.wG();
        setText(this.context.getResources().getString(r.j.list_no_more));
        getView().setVisibility(0);
    }

    public void abd() {
        super.wG();
        setText(this.context.getResources().getString(r.j.load_more));
        getView().setVisibility(0);
    }
}
