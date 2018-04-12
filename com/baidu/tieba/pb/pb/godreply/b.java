package com.baidu.tieba.pb.pb.godreply;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends PbListView {
    private TbPageContext<?> context;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds16), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds74));
        wN();
        wP();
        wQ();
        setTextSize(d.e.ds30);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void wS() {
        super.wS();
        setText(this.context.getResources().getString(d.k.list_no_more));
        getView().setVisibility(0);
    }

    public void amL() {
        super.wS();
        setText(this.context.getResources().getString(d.k.load_more));
        getView().setVisibility(0);
    }
}
