package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class e extends PbListView {
    TbPageContext<?> context;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(e.C0200e.ds16), 0, tbPageContext.getResources().getDimensionPixelSize(e.C0200e.ds74));
        DU();
        DW();
        DX();
        setTextSize(e.C0200e.tbfontsize33);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void DZ() {
        super.DZ();
        setText(this.context.getResources().getString(e.j.sub_pb_list_no_more));
        getView().setVisibility(0);
    }

    public void avu() {
        super.DZ();
        setText(this.context.getResources().getString(e.j.load_more));
        getView().setVisibility(0);
    }
}
