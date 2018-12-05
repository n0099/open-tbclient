package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class v extends k<com.baidu.tieba.pb.data.a, w> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public v(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public w onCreateViewHolder(ViewGroup viewGroup) {
        w wVar = new w(LayoutInflater.from(this.mContext).inflate(e.h.god_card_list_item, (ViewGroup) null));
        a(wVar);
        return wVar;
    }

    private void a(w wVar) {
        if (wVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (wVar.mSkinType != skinType) {
                com.baidu.tbadk.o.a.a(this.fUU.getPageContext(), wVar.getView());
            }
            wVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, w wVar) {
        super.onFillViewHolder(i, view, viewGroup, aVar, wVar);
        a(wVar);
        wVar.fXS.setOnClickListener(this);
        wVar.fXR.setOnClickListener(this);
        wVar.fXS.setTag(aVar);
        wVar.fXR.setTag(aVar);
        if (aVar != null) {
            wVar.fXQ.startLoad(aVar.getPortrait(), 28, false);
            wVar.clh.setText(aVar.getUserName());
            wVar.eJs.setText(aVar.bgd());
            wVar.text.setText(aVar.getText());
            wVar.fXR.startLoad(aVar.getPicUrl(), 10, false);
            wVar.fXS.setText(aVar.bge());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && ba.bJ(this.mContext)) {
            String bgf = ((com.baidu.tieba.pb.data.a) view.getTag()).bgf();
            if (!StringUtils.isNull(bgf)) {
                ay.Ef().c(this.fUU.getPageContext(), new String[]{bgf});
            }
        }
    }
}
