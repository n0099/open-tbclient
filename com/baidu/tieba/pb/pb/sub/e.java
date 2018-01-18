package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e extends PbListView {
    TbPageContext<?> context;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds16), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds74));
        DG();
        DI();
        DJ();
        setTextSize(d.e.tbfontsize33);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void DL() {
        super.DL();
        setText(this.context.getResources().getString(d.j.list_no_more));
        getView().setVisibility(0);
    }

    public void arA() {
        super.DL();
        setText(this.context.getResources().getString(d.j.load_more));
        getView().setVisibility(0);
    }
}
