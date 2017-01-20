package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class de extends da<com.baidu.tieba.pb.data.a, df> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public de(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public df onCreateViewHolder(ViewGroup viewGroup) {
        df dfVar = new df(LayoutInflater.from(this.mContext).inflate(r.j.god_card_list_item, (ViewGroup) null));
        a(dfVar);
        return dfVar;
    }

    private void a(df dfVar) {
        if (dfVar != null) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (dfVar.mSkinType != skinType) {
                com.baidu.tbadk.i.a.a(this.ehi.getPageContext(), dfVar.getView());
            }
            dfVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.da, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, df dfVar) {
        super.onFillViewHolder(i, view, viewGroup, aVar, dfVar);
        a(dfVar);
        dfVar.ejY.setOnClickListener(this);
        dfVar.ejX.setOnClickListener(this);
        dfVar.ejY.setTag(aVar);
        dfVar.ejX.setTag(aVar);
        if (aVar != null) {
            dfVar.bQc.c(aVar.getPortrait(), 28, false);
            dfVar.blu.setText(aVar.getUserName());
            dfVar.cOh.setText(aVar.aJM());
            dfVar.cjL.setText(aVar.getText());
            dfVar.ejX.c(aVar.getPicUrl(), 10, false);
            dfVar.ejY.setText(aVar.aJN());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && com.baidu.tbadk.core.util.bf.ak(this.mContext)) {
            String aJO = ((com.baidu.tieba.pb.data.a) view.getTag()).aJO();
            if (!StringUtils.isNull(aJO)) {
                com.baidu.tbadk.core.util.ba.vt().c(this.ehi.getPageContext(), new String[]{aJO});
            }
        }
    }
}
