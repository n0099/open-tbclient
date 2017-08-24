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
                com.baidu.tbadk.o.a.a(this.eIw.getPageContext(), sVar.getView());
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
        sVar.eME.setOnClickListener(this);
        sVar.eMD.setOnClickListener(this);
        sVar.eME.setTag(aVar);
        sVar.eMD.setTag(aVar);
        if (aVar != null) {
            sVar.ctu.c(aVar.getPortrait(), 28, false);
            sVar.bHb.setText(aVar.getUserName());
            sVar.dkF.setText(aVar.aPx());
            sVar.cHL.setText(aVar.getText());
            sVar.eMD.c(aVar.getPicUrl(), 10, false);
            sVar.eME.setText(aVar.aPy());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && aw.aO(this.mContext)) {
            String aPz = ((com.baidu.tieba.pb.data.a) view.getTag()).aPz();
            if (!StringUtils.isNull(aPz)) {
                com.baidu.tbadk.core.util.at.wg().c(this.eIw.getPageContext(), new String[]{aPz});
            }
        }
    }
}
