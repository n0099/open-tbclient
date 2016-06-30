package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class av extends PbListView {
    TbPageContext<?> context;

    public av(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(u.e.ds16), 0, 0);
        va();
        vc();
        vd();
        setTextSize(u.e.ds32);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void vi() {
        super.vi();
        setText(this.context.getResources().getString(u.j.list_no_more));
        getView().setVisibility(0);
    }
}
