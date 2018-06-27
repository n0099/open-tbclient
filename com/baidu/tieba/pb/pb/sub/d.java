package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends PbListView {
    TbPageContext<?> context;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds16), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds74));
        AD();
        AF();
        AG();
        setTextSize(d.e.tbfontsize33);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void AI() {
        super.AI();
        setText(this.context.getResources().getString(d.k.list_no_more));
        getView().setVisibility(0);
    }

    public void aql() {
        super.AI();
        setText(this.context.getResources().getString(d.k.load_more));
        getView().setVisibility(0);
    }
}
