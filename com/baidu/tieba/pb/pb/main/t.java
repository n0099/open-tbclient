package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class t extends m<com.baidu.tieba.pb.data.a, u> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public t(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public u onCreateViewHolder(ViewGroup viewGroup) {
        u uVar = new u(LayoutInflater.from(this.mContext).inflate(d.h.god_card_list_item, (ViewGroup) null));
        a(uVar);
        return uVar;
    }

    private void a(u uVar) {
        if (uVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (uVar.mSkinType != skinType) {
                com.baidu.tbadk.o.a.a(this.eMh.getPageContext(), uVar.getView());
            }
            uVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, u uVar) {
        super.onFillViewHolder(i, view, viewGroup, aVar, uVar);
        a(uVar);
        uVar.eNM.setOnClickListener(this);
        uVar.eNL.setOnClickListener(this);
        uVar.eNM.setTag(aVar);
        uVar.eNL.setTag(aVar);
        if (aVar != null) {
            uVar.cJl.startLoad(aVar.getPortrait(), 28, false);
            uVar.bOl.setText(aVar.getUserName());
            uVar.dvW.setText(aVar.aPB());
            uVar.text.setText(aVar.getText());
            uVar.eNL.startLoad(aVar.getPicUrl(), 10, false);
            uVar.eNM.setText(aVar.aPC());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && ax.aT(this.mContext)) {
            String aPD = ((com.baidu.tieba.pb.data.a) view.getTag()).aPD();
            if (!StringUtils.isNull(aPD)) {
                av.vI().c(this.eMh.getPageContext(), new String[]{aPD});
            }
        }
    }
}
