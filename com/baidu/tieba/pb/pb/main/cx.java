package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class cx extends cr<com.baidu.tieba.pb.data.c, cy> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public cx(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bh */
    public cy a(ViewGroup viewGroup) {
        cy cyVar = new cy(LayoutInflater.from(this.mContext).inflate(u.h.god_card_list_item, (ViewGroup) null));
        a(cyVar);
        return cyVar;
    }

    private void a(cy cyVar) {
        if (cyVar != null) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (cyVar.mSkinType != skinType) {
                com.baidu.tbadk.j.a.a(this.dOg.getPageContext(), cyVar.getView());
            }
            cyVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cr, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.c cVar, cy cyVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tieba.pb.data.c) cyVar);
        a(cyVar);
        cyVar.dQC.setOnClickListener(this);
        cyVar.dQB.setOnClickListener(this);
        cyVar.dQC.setTag(cVar);
        cyVar.dQB.setTag(cVar);
        if (cVar != null) {
            cyVar.bNJ.c(cVar.getPortrait(), 28, false);
            cyVar.aOX.setText(cVar.getUserName());
            cyVar.cGC.setText(cVar.aDB());
            cyVar.cfp.setText(cVar.getText());
            cyVar.dQB.c(cVar.getPicUrl(), 10, false);
            cyVar.dQC.setText(cVar.aDC());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.c) && com.baidu.tbadk.core.util.bn.ab(this.mContext)) {
            String aDD = ((com.baidu.tieba.pb.data.c) view.getTag()).aDD();
            if (!StringUtils.isNull(aDD)) {
                com.baidu.tbadk.core.util.bi.us().c(this.dOg.getPageContext(), new String[]{aDD});
            }
        }
    }
}
