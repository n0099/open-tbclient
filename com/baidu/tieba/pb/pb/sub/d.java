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
        At();
        Av();
        Aw();
        setTextSize(d.e.tbfontsize33);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void Ay() {
        super.Ay();
        setText(this.context.getResources().getString(d.j.list_no_more));
        getView().setVisibility(0);
    }

    public void aqL() {
        super.Ay();
        setText(this.context.getResources().getString(d.j.load_more));
        getView().setVisibility(0);
    }
}
