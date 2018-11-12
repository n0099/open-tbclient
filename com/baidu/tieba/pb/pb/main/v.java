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
                com.baidu.tbadk.o.a.a(this.fOe.getPageContext(), wVar.getView());
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
        wVar.fRc.setOnClickListener(this);
        wVar.fRb.setOnClickListener(this);
        wVar.fRc.setTag(aVar);
        wVar.fRb.setTag(aVar);
        if (aVar != null) {
            wVar.fRa.startLoad(aVar.getPortrait(), 28, false);
            wVar.chp.setText(aVar.getUserName());
            wVar.eCD.setText(aVar.bem());
            wVar.text.setText(aVar.getText());
            wVar.fRb.startLoad(aVar.getPicUrl(), 10, false);
            wVar.fRc.setText(aVar.ben());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && ba.bG(this.mContext)) {
            String beo = ((com.baidu.tieba.pb.data.a) view.getTag()).beo();
            if (!StringUtils.isNull(beo)) {
                ay.Db().c(this.fOe.getPageContext(), new String[]{beo});
            }
        }
    }
}
