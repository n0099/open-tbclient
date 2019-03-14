package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class v extends k<com.baidu.tieba.pb.data.a, w> implements View.OnClickListener {
    private com.baidu.tieba.pb.data.d hpl;

    /* JADX INFO: Access modifiers changed from: protected */
    public v(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: by */
    public w onCreateViewHolder(ViewGroup viewGroup) {
        w wVar = new w(LayoutInflater.from(this.mContext).inflate(d.h.god_card_list_item, (ViewGroup) null));
        a(wVar);
        return wVar;
    }

    private void a(w wVar) {
        if (wVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (wVar.mSkinType != skinType) {
                com.baidu.tbadk.r.a.a(this.hoW.getPageContext(), wVar.getView());
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
        wVar.hrL.setOnClickListener(this);
        wVar.hrK.setOnClickListener(this);
        wVar.hrL.setTag(aVar);
        wVar.hrK.setTag(aVar);
        if (aVar != null) {
            aVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.hoW.getUniqueId(), this.hpl, aVar, aVar.locate, 7);
            wVar.hrJ.startLoad(aVar.getPortrait(), 28, false);
            wVar.dAX.setText(aVar.getUserName());
            wVar.gcX.setText(aVar.bHT());
            wVar.text.setText(aVar.getText());
            wVar.hrK.startLoad(aVar.getPicUrl(), 10, false);
            wVar.hrL.setText(aVar.bHU());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && bc.cZ(this.mContext)) {
            com.baidu.tieba.pb.data.a aVar = (com.baidu.tieba.pb.data.a) view.getTag();
            String bHV = aVar.bHV();
            if (!StringUtils.isNull(bHV)) {
                ba.adD().c(this.hoW.getPageContext(), new String[]{bHV});
            }
            com.baidu.tieba.pb.c.a.a(this.hpl, aVar, aVar.locate, 7);
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.hpl = dVar;
    }
}
