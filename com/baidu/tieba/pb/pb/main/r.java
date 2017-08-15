package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class r extends l<com.baidu.tieba.pb.data.a, s> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public r(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bm */
    public s onCreateViewHolder(ViewGroup viewGroup) {
        s sVar = new s(LayoutInflater.from(this.mContext).inflate(d.j.god_card_list_item, (ViewGroup) null));
        a(sVar);
        return sVar;
    }

    private void a(s sVar) {
        if (sVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (sVar.mSkinType != skinType) {
                com.baidu.tbadk.o.a.a(this.eIu.getPageContext(), sVar.getView());
            }
            sVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, s sVar) {
        super.onFillViewHolder(i, view, viewGroup, aVar, sVar);
        a(sVar);
        sVar.eMC.setOnClickListener(this);
        sVar.eMB.setOnClickListener(this);
        sVar.eMC.setTag(aVar);
        sVar.eMB.setTag(aVar);
        if (aVar != null) {
            sVar.ctu.c(aVar.getPortrait(), 28, false);
            sVar.bHa.setText(aVar.getUserName());
            sVar.dkF.setText(aVar.aPC());
            sVar.cHL.setText(aVar.getText());
            sVar.eMB.c(aVar.getPicUrl(), 10, false);
            sVar.eMC.setText(aVar.aPD());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && aw.aO(this.mContext)) {
            String aPE = ((com.baidu.tieba.pb.data.a) view.getTag()).aPE();
            if (!StringUtils.isNull(aPE)) {
                com.baidu.tbadk.core.util.at.wf().c(this.eIu.getPageContext(), new String[]{aPE});
            }
        }
    }
}
