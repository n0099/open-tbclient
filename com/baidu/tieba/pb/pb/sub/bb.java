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
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(r.f.ds16), 0, tbPageContext.getResources().getDimensionPixelSize(r.f.ds74));
        wd();
        wf();
        wg();
        setTextSize(r.f.ds32);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void wl() {
        super.wl();
        setText(this.context.getResources().getString(r.l.list_no_more));
        getView().setVisibility(0);
    }

    public void WK() {
        super.wl();
        setText(this.context.getResources().getString(r.l.load_more));
        getView().setVisibility(0);
    }
}
