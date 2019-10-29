package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class v extends k<com.baidu.tieba.pb.data.a, w> implements View.OnClickListener {
    private com.baidu.tieba.pb.data.d hOn;

    /* JADX INFO: Access modifiers changed from: protected */
    public v(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public w b(ViewGroup viewGroup) {
        w wVar = new w(LayoutInflater.from(this.mContext).inflate(R.layout.god_card_list_item, (ViewGroup) null));
        a(wVar);
        return wVar;
    }

    private void a(w wVar) {
        if (wVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (wVar.mSkinType != skinType) {
                com.baidu.tbadk.s.a.a(this.hNY.getPageContext(), wVar.getView());
            }
            wVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, w wVar) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) wVar);
        a(wVar);
        wVar.hQR.setOnClickListener(this);
        wVar.hQQ.setOnClickListener(this);
        wVar.hQR.setTag(aVar);
        wVar.hQQ.setTag(aVar);
        if (aVar != null) {
            aVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.hNY.getUniqueId(), this.hOn, aVar, aVar.locate, 7);
            wVar.hQP.startLoad(aVar.getPortrait(), 28, false);
            wVar.ewr.setText(aVar.getUserName());
            wVar.gAW.setText(aVar.bQt());
            wVar.YM.setText(aVar.getText());
            wVar.hQQ.startLoad(aVar.getPicUrl(), 10, false);
            wVar.hQR.setText(aVar.bQu());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && bc.checkUpIsLogin(this.mContext)) {
            com.baidu.tieba.pb.data.a aVar = (com.baidu.tieba.pb.data.a) view.getTag();
            String bQv = aVar.bQv();
            if (!StringUtils.isNull(bQv)) {
                ba.amQ().b(this.hNY.getPageContext(), new String[]{bQv});
            }
            com.baidu.tieba.pb.c.a.a(this.hOn, aVar, aVar.locate, 7);
        }
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hOn = dVar;
    }
}
