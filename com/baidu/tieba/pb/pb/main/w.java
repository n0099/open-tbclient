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
/* loaded from: classes7.dex */
public class w extends m<com.baidu.tieba.pb.data.a, x> implements View.OnClickListener {
    private com.baidu.tieba.pb.data.f iCZ;

    /* JADX INFO: Access modifiers changed from: protected */
    public w(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public x b(ViewGroup viewGroup) {
        x xVar = new x(LayoutInflater.from(this.mContext).inflate(R.layout.god_card_list_item, (ViewGroup) null));
        a(xVar);
        return xVar;
    }

    private void a(x xVar) {
        if (xVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (xVar.mSkinType != skinType) {
                com.baidu.tbadk.q.a.a(this.iCe.getPageContext(), xVar.getView());
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
        xVar.iIm.setOnClickListener(this);
        xVar.iIl.setOnClickListener(this);
        xVar.iIm.setTag(aVar);
        xVar.iIl.setTag(aVar);
        if (aVar != null) {
            aVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.iCe.getUniqueId(), this.iCZ, aVar, aVar.locate, 7);
            xVar.iIk.startLoad(aVar.getPortrait(), 28, false);
            xVar.fqi.setText(aVar.getUserName());
            xVar.hrO.setText(aVar.ciK());
            xVar.text.setText(aVar.getText());
            xVar.iIl.startLoad(aVar.getPicUrl(), 10, false);
            xVar.iIm.setText(aVar.ciL());
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && bc.checkUpIsLogin(this.mContext)) {
            com.baidu.tieba.pb.data.a aVar = (com.baidu.tieba.pb.data.a) view.getTag();
            String ciM = aVar.ciM();
            if (!StringUtils.isNull(ciM)) {
                ba.aEt().b(this.iCe.getPageContext(), new String[]{ciM});
            }
            com.baidu.tieba.pb.c.a.a(this.iCZ, aVar, aVar.locate, 7);
        }
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.iCZ = fVar;
    }
}
