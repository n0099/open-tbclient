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
    /* renamed from: aX */
    public de onCreateViewHolder(ViewGroup viewGroup) {
        de deVar = new de(LayoutInflater.from(this.mContext).inflate(w.j.god_card_list_item, (ViewGroup) null));
        a(deVar);
        return deVar;
    }

    private void a(de deVar) {
        if (deVar != null) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (deVar.mSkinType != skinType) {
                com.baidu.tbadk.m.a.a(this.eig.getPageContext(), deVar.getView());
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
        deVar.elc.setOnClickListener(this);
        deVar.elb.setOnClickListener(this);
        deVar.elc.setTag(aVar);
        deVar.elb.setTag(aVar);
        if (aVar != null) {
            deVar.bWZ.c(aVar.getPortrait(), 28, false);
            deVar.bsf.setText(aVar.getUserName());
            deVar.cOV.setText(aVar.aJk());
            deVar.cjI.setText(aVar.getText());
            deVar.elb.c(aVar.getPicUrl(), 10, false);
            deVar.elc.setText(aVar.aJl());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && com.baidu.tbadk.core.util.bg.aK(this.mContext)) {
            String aJm = ((com.baidu.tieba.pb.data.a) view.getTag()).aJm();
            if (!StringUtils.isNull(aJm)) {
                com.baidu.tbadk.core.util.bb.wn().c(this.eig.getPageContext(), new String[]{aJm});
            }
        }
    }
}
