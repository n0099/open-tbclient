package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class aw extends PbListView {
    TbPageContext<?> context;

    public aw(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(r.e.ds16), 0, 0);
        wu();
        ww();
        wx();
        setTextSize(r.e.ds32);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void wC() {
        super.wC();
        setText(this.context.getResources().getString(r.j.list_no_more));
        getView().setVisibility(0);
    }
}
