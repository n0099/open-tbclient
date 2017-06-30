package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ej extends du<com.baidu.tieba.pb.data.a, ek> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public ej(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ba */
    public ek onCreateViewHolder(ViewGroup viewGroup) {
        ek ekVar = new ek(LayoutInflater.from(this.mContext).inflate(w.j.god_card_list_item, (ViewGroup) null));
        a(ekVar);
        return ekVar;
    }

    private void a(ek ekVar) {
        if (ekVar != null) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (ekVar.mSkinType != skinType) {
                com.baidu.tbadk.m.a.a(this.euf.getPageContext(), ekVar.getView());
            }
            ekVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.du, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, ek ekVar) {
        super.onFillViewHolder(i, view, viewGroup, aVar, ekVar);
        a(ekVar);
        ekVar.eyl.setOnClickListener(this);
        ekVar.eyk.setOnClickListener(this);
        ekVar.eyl.setTag(aVar);
        ekVar.eyk.setTag(aVar);
        if (aVar != null) {
            ekVar.clB.c(aVar.getPortrait(), 28, false);
            ekVar.bBa.setText(aVar.getUserName());
            ekVar.cYI.setText(aVar.aMh());
            ekVar.cxj.setText(aVar.getText());
            ekVar.eyk.c(aVar.getPicUrl(), 10, false);
            ekVar.eyl.setText(aVar.aMi());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && com.baidu.tbadk.core.util.bl.aN(this.mContext)) {
            String aMj = ((com.baidu.tieba.pb.data.a) view.getTag()).aMj();
            if (!StringUtils.isNull(aMj)) {
                com.baidu.tbadk.core.util.be.vP().c(this.euf.getPageContext(), new String[]{aMj});
            }
        }
    }
}
