package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class cw extends cs<com.baidu.tieba.pb.data.a, cx> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public cw(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public cx a(ViewGroup viewGroup) {
        cx cxVar = new cx(LayoutInflater.from(this.mContext).inflate(r.h.god_card_list_item, (ViewGroup) null));
        a(cxVar);
        return cxVar;
    }

    private void a(cx cxVar) {
        if (cxVar != null) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (cxVar.mSkinType != skinType) {
                com.baidu.tbadk.i.a.a(this.dYB.getPageContext(), cxVar.getView());
            }
            cxVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, cx cxVar) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) cxVar);
        a(cxVar);
        cxVar.ebg.setOnClickListener(this);
        cxVar.ebf.setOnClickListener(this);
        cxVar.ebg.setTag(aVar);
        cxVar.ebf.setTag(aVar);
        if (aVar != null) {
            cxVar.bJK.c(aVar.getPortrait(), 28, false);
            cxVar.bbH.setText(aVar.getUserName());
            cxVar.cGZ.setText(aVar.aHY());
            cxVar.cdq.setText(aVar.getText());
            cxVar.ebf.c(aVar.getPicUrl(), 10, false);
            cxVar.ebg.setText(aVar.aHZ());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && com.baidu.tbadk.core.util.bh.ai(this.mContext)) {
            String aIa = ((com.baidu.tieba.pb.data.a) view.getTag()).aIa();
            if (!StringUtils.isNull(aIa)) {
                com.baidu.tbadk.core.util.bc.vz().c(this.dYB.getPageContext(), new String[]{aIa});
            }
        }
    }
}
