package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class cy extends cs<com.baidu.tieba.pb.data.c, cz> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public cy(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bi */
    public cz a(ViewGroup viewGroup) {
        cz czVar = new cz(LayoutInflater.from(this.mContext).inflate(r.h.god_card_list_item, (ViewGroup) null));
        a(czVar);
        return czVar;
    }

    private void a(cz czVar) {
        if (czVar != null) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (czVar.mSkinType != skinType) {
                com.baidu.tbadk.i.a.a(this.eow.getPageContext(), czVar.getView());
            }
            czVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.c cVar, cz czVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tieba.pb.data.c) czVar);
        a(czVar);
        czVar.eqU.setOnClickListener(this);
        czVar.eqT.setOnClickListener(this);
        czVar.eqU.setTag(cVar);
        czVar.eqT.setTag(cVar);
        if (cVar != null) {
            czVar.caE.c(cVar.getPortrait(), 28, false);
            czVar.aVU.setText(cVar.getUserName());
            czVar.cWq.setText(cVar.aMf());
            czVar.cta.setText(cVar.getText());
            czVar.eqT.c(cVar.getPicUrl(), 10, false);
            czVar.eqU.setText(cVar.aMg());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.c) && com.baidu.tbadk.core.util.bm.ak(this.mContext)) {
            String aMh = ((com.baidu.tieba.pb.data.c) view.getTag()).aMh();
            if (!StringUtils.isNull(aMh)) {
                com.baidu.tbadk.core.util.bh.vL().c(this.eow.getPageContext(), new String[]{aMh});
            }
        }
    }
}
