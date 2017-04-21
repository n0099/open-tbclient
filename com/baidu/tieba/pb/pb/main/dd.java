package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class dd extends cx<com.baidu.tieba.pb.data.a, de> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public dd(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aZ */
    public de onCreateViewHolder(ViewGroup viewGroup) {
        de deVar = new de(LayoutInflater.from(this.mContext).inflate(w.j.god_card_list_item, (ViewGroup) null));
        a(deVar);
        return deVar;
    }

    private void a(de deVar) {
        if (deVar != null) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (deVar.mSkinType != skinType) {
                com.baidu.tbadk.m.a.a(this.ekw.getPageContext(), deVar.getView());
            }
            deVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cx, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, de deVar) {
        super.onFillViewHolder(i, view, viewGroup, aVar, deVar);
        a(deVar);
        deVar.enu.setOnClickListener(this);
        deVar.ent.setOnClickListener(this);
        deVar.enu.setTag(aVar);
        deVar.ent.setTag(aVar);
        if (aVar != null) {
            deVar.bZq.c(aVar.getPortrait(), 28, false);
            deVar.bux.setText(aVar.getUserName());
            deVar.cRm.setText(aVar.aKl());
            deVar.clZ.setText(aVar.getText());
            deVar.ent.c(aVar.getPicUrl(), 10, false);
            deVar.enu.setText(aVar.aKm());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && com.baidu.tbadk.core.util.bg.aK(this.mContext)) {
            String aKn = ((com.baidu.tieba.pb.data.a) view.getTag()).aKn();
            if (!StringUtils.isNull(aKn)) {
                com.baidu.tbadk.core.util.bb.wn().c(this.ekw.getPageContext(), new String[]{aKn});
            }
        }
    }
}
