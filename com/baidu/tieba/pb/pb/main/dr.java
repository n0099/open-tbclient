package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class dr extends dh<com.baidu.tieba.pb.data.a, ds> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public dr(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aW */
    public ds onCreateViewHolder(ViewGroup viewGroup) {
        ds dsVar = new ds(LayoutInflater.from(this.mContext).inflate(w.j.god_card_list_item, (ViewGroup) null));
        a(dsVar);
        return dsVar;
    }

    private void a(ds dsVar) {
        if (dsVar != null) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (dsVar.mSkinType != skinType) {
                com.baidu.tbadk.m.a.a(this.efF.getPageContext(), dsVar.getView());
            }
            dsVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dh, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, ds dsVar) {
        super.onFillViewHolder(i, view, viewGroup, aVar, dsVar);
        a(dsVar);
        dsVar.ejq.setOnClickListener(this);
        dsVar.ejp.setOnClickListener(this);
        dsVar.ejq.setTag(aVar);
        dsVar.ejp.setTag(aVar);
        if (aVar != null) {
            dsVar.bXq.c(aVar.getPortrait(), 28, false);
            dsVar.but.setText(aVar.getUserName());
            dsVar.cLo.setText(aVar.aHs());
            dsVar.ciW.setText(aVar.getText());
            dsVar.ejp.c(aVar.getPicUrl(), 10, false);
            dsVar.ejq.setText(aVar.aHt());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && com.baidu.tbadk.core.util.bg.aN(this.mContext)) {
            String aHu = ((com.baidu.tieba.pb.data.a) view.getTag()).aHu();
            if (!StringUtils.isNull(aHu)) {
                com.baidu.tbadk.core.util.bb.vB().c(this.efF.getPageContext(), new String[]{aHu});
            }
        }
    }
}
