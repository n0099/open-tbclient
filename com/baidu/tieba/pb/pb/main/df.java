package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class df extends cz<com.baidu.tieba.pb.data.a, dg> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public df(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public dg onCreateViewHolder(ViewGroup viewGroup) {
        dg dgVar = new dg(LayoutInflater.from(this.mContext).inflate(w.j.god_card_list_item, (ViewGroup) null));
        a(dgVar);
        return dgVar;
    }

    private void a(dg dgVar) {
        if (dgVar != null) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (dgVar.mSkinType != skinType) {
                com.baidu.tbadk.i.a.a(this.eka.getPageContext(), dgVar.getView());
            }
            dgVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cz, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, dg dgVar) {
        super.onFillViewHolder(i, view, viewGroup, aVar, dgVar);
        a(dgVar);
        dgVar.emU.setOnClickListener(this);
        dgVar.emT.setOnClickListener(this);
        dgVar.emU.setTag(aVar);
        dgVar.emT.setTag(aVar);
        if (aVar != null) {
            dgVar.bXk.c(aVar.getPortrait(), 28, false);
            dgVar.bsn.setText(aVar.getUserName());
            dgVar.cQy.setText(aVar.aJd());
            dgVar.cli.setText(aVar.getText());
            dgVar.emT.c(aVar.getPicUrl(), 10, false);
            dgVar.emU.setText(aVar.aJe());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && com.baidu.tbadk.core.util.bg.aI(this.mContext)) {
            String aJf = ((com.baidu.tieba.pb.data.a) view.getTag()).aJf();
            if (!StringUtils.isNull(aJf)) {
                com.baidu.tbadk.core.util.bb.vQ().c(this.eka.getPageContext(), new String[]{aJf});
            }
        }
    }
}
