package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bb extends PbListView {
    TbPageContext<?> context;

    public bb(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(w.f.ds16), 0, tbPageContext.getResources().getDimensionPixelSize(w.f.ds74));
        wA();
        wC();
        wD();
        setTextSize(w.f.ds32);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void wI() {
        super.wI();
        setText(this.context.getResources().getString(w.l.list_no_more));
        getView().setVisibility(0);
    }

    public void XI() {
        super.wI();
        setText(this.context.getResources().getString(w.l.load_more));
        getView().setVisibility(0);
    }
}
