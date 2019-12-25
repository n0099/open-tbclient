package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class w extends m<com.baidu.tieba.pb.data.a, x> implements View.OnClickListener {
    private com.baidu.tieba.pb.data.f izv;

    /* JADX INFO: Access modifiers changed from: protected */
    public w(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public x b(ViewGroup viewGroup) {
        x xVar = new x(LayoutInflater.from(this.mContext).inflate(R.layout.god_card_list_item, (ViewGroup) null));
        a(xVar);
        return xVar;
    }

    private void a(x xVar) {
        if (xVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (xVar.mSkinType != skinType) {
                com.baidu.tbadk.q.a.a(this.iyA.getPageContext(), xVar.getView());
            }
            xVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, x xVar) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) xVar);
        a(xVar);
        xVar.iEI.setOnClickListener(this);
        xVar.iEH.setOnClickListener(this);
        xVar.iEI.setTag(aVar);
        xVar.iEH.setTag(aVar);
        if (aVar != null) {
            aVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.iyA.getUniqueId(), this.izv, aVar, aVar.locate, 7);
            xVar.iEG.startLoad(aVar.getPortrait(), 28, false);
            xVar.fmZ.setText(aVar.getUserName());
            xVar.hol.setText(aVar.chC());
            xVar.text.setText(aVar.getText());
            xVar.iEH.startLoad(aVar.getPicUrl(), 10, false);
            xVar.iEI.setText(aVar.chD());
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && bc.checkUpIsLogin(this.mContext)) {
            com.baidu.tieba.pb.data.a aVar = (com.baidu.tieba.pb.data.a) view.getTag();
            String chE = aVar.chE();
            if (!StringUtils.isNull(chE)) {
                ba.aEa().b(this.iyA.getPageContext(), new String[]{chE});
            }
            com.baidu.tieba.pb.c.a.a(this.izv, aVar, aVar.locate, 7);
        }
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.izv = fVar;
    }
}
