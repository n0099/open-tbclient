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
        wR();
        wT();
        wU();
        setTextSize(d.f.ds30);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void wW() {
        super.wW();
        setText(this.context.getResources().getString(d.l.list_no_more));
        getView().setVisibility(0);
    }

    public void aeV() {
        super.wW();
        setText(this.context.getResources().getString(d.l.load_more));
        getView().setVisibility(0);
    }
}
