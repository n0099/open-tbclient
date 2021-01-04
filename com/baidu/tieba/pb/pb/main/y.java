package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class y extends l<com.baidu.tieba.pb.data.j, PbLoadMoreItemViewHolder> {
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;

    public y(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(bVar, bdUniqueId);
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cx */
    public PbLoadMoreItemViewHolder e(ViewGroup viewGroup) {
        return new PbLoadMoreItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_more, viewGroup, false), this.mPageId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, PbLoadMoreItemViewHolder pbLoadMoreItemViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (com.baidu.tieba.pb.data.j) pbLoadMoreItemViewHolder);
        pbLoadMoreItemViewHolder.at(jVar.showText, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104));
        pbLoadMoreItemViewHolder.setOnClickListener(this.mOnClickListener);
        pbLoadMoreItemViewHolder.onChangeSkinType();
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
