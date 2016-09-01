package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class aw extends PbListView {
    TbPageContext<?> context;

    public aw(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(t.e.ds16), 0, 0);
        we();
        wg();
        wh();
        setTextSize(t.e.ds32);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void wm() {
        super.wm();
        setText(this.context.getResources().getString(t.j.list_no_more));
        getView().setVisibility(0);
    }
}
