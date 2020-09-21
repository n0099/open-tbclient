package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ae extends o<com.baidu.tieba.pb.data.j, af> {
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;

    public ae(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(bVar, bdUniqueId);
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ch */
    public af c(ViewGroup viewGroup) {
        return new af(LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_more, viewGroup, false), this.mPageId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, af afVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (com.baidu.tieba.pb.data.j) afVar);
        afVar.ao(jVar.showText, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104));
        afVar.setOnClickListener(this.mOnClickListener);
        afVar.onChangeSkinType();
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
