package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class v extends k<com.baidu.tieba.pb.data.a, w> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public v(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public w onCreateViewHolder(ViewGroup viewGroup) {
        w wVar = new w(LayoutInflater.from(this.mContext).inflate(d.h.god_card_list_item, (ViewGroup) null));
        a(wVar);
        return wVar;
    }

    private void a(w wVar) {
        if (wVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (wVar.mSkinType != skinType) {
                com.baidu.tbadk.o.a.a(this.fxt.getPageContext(), wVar.getView());
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
        wVar.fAz.setOnClickListener(this);
        wVar.fAy.setOnClickListener(this);
        wVar.fAz.setTag(aVar);
        wVar.fAy.setTag(aVar);
        if (aVar != null) {
            wVar.fAx.startLoad(aVar.getPortrait(), 28, false);
            wVar.bSR.setText(aVar.getUserName());
            wVar.emd.setText(aVar.aZg());
            wVar.text.setText(aVar.getText());
            wVar.fAy.startLoad(aVar.getPicUrl(), 10, false);
            wVar.fAz.setText(aVar.aZh());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && ba.aV(this.mContext)) {
            String aZi = ((com.baidu.tieba.pb.data.a) view.getTag()).aZi();
            if (!StringUtils.isNull(aZi)) {
                com.baidu.tbadk.core.util.ay.zK().c(this.fxt.getPageContext(), new String[]{aZi});
            }
        }
    }
}
