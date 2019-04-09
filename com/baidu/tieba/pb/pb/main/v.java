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
    private com.baidu.tieba.pb.data.d hoZ;

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
                com.baidu.tbadk.r.a.a(this.hoK.getPageContext(), wVar.getView());
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
        wVar.hrz.setOnClickListener(this);
        wVar.hry.setOnClickListener(this);
        wVar.hrz.setTag(aVar);
        wVar.hry.setTag(aVar);
        if (aVar != null) {
            aVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.hoK.getUniqueId(), this.hoZ, aVar, aVar.locate, 7);
            wVar.hrx.startLoad(aVar.getPortrait(), 28, false);
            wVar.eeB.setText(aVar.getUserName());
            wVar.gcL.setText(aVar.bHQ());
            wVar.text.setText(aVar.getText());
            wVar.hry.startLoad(aVar.getPicUrl(), 10, false);
            wVar.hrz.setText(aVar.bHR());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && bc.cZ(this.mContext)) {
            com.baidu.tieba.pb.data.a aVar = (com.baidu.tieba.pb.data.a) view.getTag();
            String bHS = aVar.bHS();
            if (!StringUtils.isNull(bHS)) {
                ba.adA().c(this.hoK.getPageContext(), new String[]{bHS});
            }
            com.baidu.tieba.pb.c.a.a(this.hoZ, aVar, aVar.locate, 7);
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.hoZ = dVar;
    }
}
