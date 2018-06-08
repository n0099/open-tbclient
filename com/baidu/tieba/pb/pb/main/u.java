package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class u extends k<com.baidu.tieba.pb.data.a, v> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public u(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bo */
    public v onCreateViewHolder(ViewGroup viewGroup) {
        v vVar = new v(LayoutInflater.from(this.mContext).inflate(d.i.god_card_list_item, (ViewGroup) null));
        a(vVar);
        return vVar;
    }

    private void a(v vVar) {
        if (vVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (vVar.mSkinType != skinType) {
                com.baidu.tbadk.n.a.a(this.ftp.getPageContext(), vVar.getView());
            }
            vVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, v vVar) {
        super.onFillViewHolder(i, view, viewGroup, aVar, vVar);
        a(vVar);
        vVar.fwm.setOnClickListener(this);
        vVar.fwl.setOnClickListener(this);
        vVar.fwm.setTag(aVar);
        vVar.fwl.setTag(aVar);
        if (aVar != null) {
            vVar.fwk.startLoad(aVar.getPortrait(), 28, false);
            vVar.bPN.setText(aVar.getUserName());
            vVar.eet.setText(aVar.bah());
            vVar.text.setText(aVar.getText());
            vVar.fwl.startLoad(aVar.getPicUrl(), 10, false);
            vVar.fwm.setText(aVar.bai());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && ba.aU(this.mContext)) {
            String baj = ((com.baidu.tieba.pb.data.a) view.getTag()).baj();
            if (!StringUtils.isNull(baj)) {
                ay.zG().c(this.ftp.getPageContext(), new String[]{baj});
            }
        }
    }
}
