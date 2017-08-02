package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends PbListView {
    TbPageContext<?> context;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(d.f.ds16), 0, tbPageContext.getResources().getDimensionPixelSize(d.f.ds74));
        wJ();
        wL();
        wM();
        setTextSize(d.f.ds32);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void wO() {
        super.wO();
        setText(this.context.getResources().getString(d.l.list_no_more));
        getView().setVisibility(0);
    }

    public void adv() {
        super.wO();
        setText(this.context.getResources().getString(d.l.load_more));
        getView().setVisibility(0);
    }
}
