package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ea extends dn<com.baidu.tieba.pb.data.a, eb> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public ea(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aY */
    public eb onCreateViewHolder(ViewGroup viewGroup) {
        eb ebVar = new eb(LayoutInflater.from(this.mContext).inflate(w.j.god_card_list_item, (ViewGroup) null));
        a(ebVar);
        return ebVar;
    }

    private void a(eb ebVar) {
        if (ebVar != null) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (ebVar.mSkinType != skinType) {
                com.baidu.tbadk.m.a.a(this.elf.getPageContext(), ebVar.getView());
            }
            ebVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dn, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, eb ebVar) {
        super.onFillViewHolder(i, view, viewGroup, aVar, ebVar);
        a(ebVar);
        ebVar.epc.setOnClickListener(this);
        ebVar.epb.setOnClickListener(this);
        ebVar.epc.setTag(aVar);
        ebVar.epb.setTag(aVar);
        if (aVar != null) {
            ebVar.cdp.c(aVar.getPortrait(), 28, false);
            ebVar.bAh.setText(aVar.getUserName());
            ebVar.cQM.setText(aVar.aIn());
            ebVar.cpu.setText(aVar.getText());
            ebVar.epb.c(aVar.getPicUrl(), 10, false);
            ebVar.epc.setText(aVar.aIo());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && com.baidu.tbadk.core.util.bh.aN(this.mContext)) {
            String aIp = ((com.baidu.tieba.pb.data.a) view.getTag()).aIp();
            if (!StringUtils.isNull(aIp)) {
                com.baidu.tbadk.core.util.bb.vy().c(this.elf.getPageContext(), new String[]{aIp});
            }
        }
    }
}
