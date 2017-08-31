package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
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
    /* renamed from: bk */
    public s onCreateViewHolder(ViewGroup viewGroup) {
        s sVar = new s(LayoutInflater.from(this.mContext).inflate(d.j.god_card_list_item, (ViewGroup) null));
        a(sVar);
        return sVar;
    }

    private void a(s sVar) {
        if (sVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (sVar.mSkinType != skinType) {
                com.baidu.tbadk.o.a.a(this.eGQ.getPageContext(), sVar.getView());
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
        sVar.eKV.setOnClickListener(this);
        sVar.eKU.setOnClickListener(this);
        sVar.eKV.setTag(aVar);
        sVar.eKU.setTag(aVar);
        if (aVar != null) {
            sVar.czX.c(aVar.getPortrait(), 28, false);
            sVar.bEL.setText(aVar.getUserName());
            sVar.drj.setText(aVar.aOJ());
            sVar.cOa.setText(aVar.getText());
            sVar.eKU.c(aVar.getPicUrl(), 10, false);
            sVar.eKV.setText(aVar.aOK());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && ax.aT(this.mContext)) {
            String aOL = ((com.baidu.tieba.pb.data.a) view.getTag()).aOL();
            if (!StringUtils.isNull(aOL)) {
                au.wd().c(this.eGQ.getPageContext(), new String[]{aOL});
            }
        }
    }
}
