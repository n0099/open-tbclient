package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class da extends ct<com.baidu.tieba.pb.data.c, db> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public da(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public db a(ViewGroup viewGroup) {
        db dbVar = new db(LayoutInflater.from(this.mContext).inflate(r.h.god_card_list_item, (ViewGroup) null));
        a(dbVar);
        return dbVar;
    }

    private void a(db dbVar) {
        if (dbVar != null) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (dbVar.mSkinType != skinType) {
                com.baidu.tbadk.i.a.a(this.eug.getPageContext(), dbVar.getView());
            }
            dbVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.ct, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.c cVar, db dbVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tieba.pb.data.c) dbVar);
        a(dbVar);
        dbVar.ewL.setOnClickListener(this);
        dbVar.ewK.setOnClickListener(this);
        dbVar.ewL.setTag(cVar);
        dbVar.ewK.setTag(cVar);
        if (cVar != null) {
            dbVar.ceb.c(cVar.getPortrait(), 28, false);
            dbVar.aYg.setText(cVar.getUserName());
            dbVar.dcb.setText(cVar.aNY());
            dbVar.cyf.setText(cVar.getText());
            dbVar.ewK.c(cVar.getPicUrl(), 10, false);
            dbVar.ewL.setText(cVar.aNZ());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.c) && com.baidu.tbadk.core.util.bk.ak(this.mContext)) {
            String aOa = ((com.baidu.tieba.pb.data.c) view.getTag()).aOa();
            if (!StringUtils.isNull(aOa)) {
                com.baidu.tbadk.core.util.bf.vP().c(this.eug.getPageContext(), new String[]{aOa});
            }
        }
    }
}
