package com.baidu.tieba.pb.pb.godreply;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends PbListView {
    private TbPageContext<?> context;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds16), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds74));
        akN();
        akP();
        akQ();
        setTextSize(R.dimen.ds30);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void akS() {
        super.akS();
        setText(this.context.getResources().getString(R.string.list_no_more));
        getView().setVisibility(0);
    }

    public void bjk() {
        super.akS();
        setText(this.context.getResources().getString(R.string.load_more));
        getView().setVisibility(0);
    }
}
