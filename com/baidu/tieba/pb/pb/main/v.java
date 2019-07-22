package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class v extends k<com.baidu.tieba.pb.data.a, w> implements View.OnClickListener {
    private com.baidu.tieba.pb.data.d hMS;

    /* JADX INFO: Access modifiers changed from: protected */
    public v(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bE */
    public w onCreateViewHolder(ViewGroup viewGroup) {
        w wVar = new w(LayoutInflater.from(this.mContext).inflate(R.layout.god_card_list_item, (ViewGroup) null));
        a(wVar);
        return wVar;
    }

    private void a(w wVar) {
        if (wVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (wVar.mSkinType != skinType) {
                com.baidu.tbadk.s.a.a(this.hMD.getPageContext(), wVar.getView());
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
        wVar.hPu.setOnClickListener(this);
        wVar.hPt.setOnClickListener(this);
        wVar.hPu.setTag(aVar);
        wVar.hPt.setTag(aVar);
        if (aVar != null) {
            aVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.hMD.getUniqueId(), this.hMS, aVar, aVar.locate, 7);
            wVar.hPs.startLoad(aVar.getPortrait(), 28, false);
            wVar.euc.setText(aVar.getUserName());
            wVar.gAo.setText(aVar.bSr());
            wVar.text.setText(aVar.getText());
            wVar.hPt.startLoad(aVar.getPicUrl(), 10, false);
            wVar.hPu.setText(aVar.bSs());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && bd.cF(this.mContext)) {
            com.baidu.tieba.pb.data.a aVar = (com.baidu.tieba.pb.data.a) view.getTag();
            String bSt = aVar.bSt();
            if (!StringUtils.isNull(bSt)) {
                bb.ajC().c(this.hMD.getPageContext(), new String[]{bSt});
            }
            com.baidu.tieba.pb.c.a.a(this.hMS, aVar, aVar.locate, 7);
        }
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hMS = dVar;
    }
}
