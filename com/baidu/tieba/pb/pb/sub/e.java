package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends PbListView {
    TbPageContext<?> context;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds16), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds74));
        akB();
        akD();
        akE();
        setTextSize(R.dimen.tbfontsize33);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void akG() {
        super.akG();
        setText(this.context.getResources().getString(R.string.sub_pb_list_no_more));
        getView().setVisibility(0);
    }

    public void biz() {
        super.akG();
        setText(this.context.getResources().getString(R.string.load_more));
        getView().setVisibility(0);
    }
}
