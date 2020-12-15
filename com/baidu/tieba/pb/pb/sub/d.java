package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class d extends PbListView {
    TbPageContext<?> context;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds16), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds74));
        setLineVisible();
        setLineNoMargin();
        setLightLine();
        setTextSize(R.dimen.tbfontsize33);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void endLoadData() {
        super.endLoadData();
        setText(this.context.getResources().getString(R.string.sub_pb_list_no_more));
        getView().setVisibility(0);
    }

    public void cze() {
        super.endLoadData();
        setText(this.context.getResources().getString(R.string.load_more));
        getView().setVisibility(0);
    }
}
