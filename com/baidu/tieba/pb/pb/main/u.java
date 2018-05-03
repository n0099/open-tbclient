package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
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
    /* renamed from: bn */
    public v onCreateViewHolder(ViewGroup viewGroup) {
        v vVar = new v(LayoutInflater.from(this.mContext).inflate(d.i.god_card_list_item, (ViewGroup) null));
        a(vVar);
        return vVar;
    }

    private void a(v vVar) {
        if (vVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (vVar.mSkinType != skinType) {
                com.baidu.tbadk.n.a.a(this.fgJ.getPageContext(), vVar.getView());
            }
            vVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, v vVar) {
        super.onFillViewHolder(i, view2, viewGroup, aVar, vVar);
        a(vVar);
        vVar.fjK.setOnClickListener(this);
        vVar.fjJ.setOnClickListener(this);
        vVar.fjK.setTag(aVar);
        vVar.fjJ.setTag(aVar);
        if (aVar != null) {
            vVar.fjI.startLoad(aVar.getPortrait(), 28, false);
            vVar.bGo.setText(aVar.getUserName());
            vVar.dRZ.setText(aVar.aVl());
            vVar.text.setText(aVar.getText());
            vVar.fjJ.startLoad(aVar.getPicUrl(), 10, false);
            vVar.fjK.setText(aVar.aVm());
        }
        return view2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if ((view2.getTag() instanceof com.baidu.tieba.pb.data.a) && az.aK(this.mContext)) {
            String aVn = ((com.baidu.tieba.pb.data.a) view2.getTag()).aVn();
            if (!StringUtils.isNull(aVn)) {
                com.baidu.tbadk.core.util.ax.wg().c(this.fgJ.getPageContext(), new String[]{aVn});
            }
        }
    }
}
