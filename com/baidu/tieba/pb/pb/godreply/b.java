package com.baidu.tieba.pb.pb.godreply;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class b extends PbListView {
    private TbPageContext<?> context;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(f.e.ds16), 0, tbPageContext.getResources().getDimensionPixelSize(f.e.ds74));
        Ar();
        At();
        Au();
        setTextSize(f.e.ds30);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void Aw() {
        super.Aw();
        setText(this.context.getResources().getString(f.j.list_no_more));
        getView().setVisibility(0);
    }

    public void aqL() {
        super.Aw();
        setText(this.context.getResources().getString(f.j.load_more));
        getView().setVisibility(0);
    }
}
