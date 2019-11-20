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
    private com.baidu.tieba.pb.data.d hNw;

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
                com.baidu.tbadk.s.a.a(this.hNh.getPageContext(), wVar.getView());
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
        wVar.hQa.setOnClickListener(this);
        wVar.hPZ.setOnClickListener(this);
        wVar.hQa.setTag(aVar);
        wVar.hPZ.setTag(aVar);
        if (aVar != null) {
            aVar.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.hNh.getUniqueId(), this.hNw, aVar, aVar.locate, 7);
            wVar.hPY.startLoad(aVar.getPortrait(), 28, false);
            wVar.evA.setText(aVar.getUserName());
            wVar.gAf.setText(aVar.bQr());
            wVar.Yu.setText(aVar.getText());
            wVar.hPZ.startLoad(aVar.getPicUrl(), 10, false);
            wVar.hQa.setText(aVar.bQs());
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.baidu.tieba.pb.data.a) && bc.checkUpIsLogin(this.mContext)) {
            com.baidu.tieba.pb.data.a aVar = (com.baidu.tieba.pb.data.a) view.getTag();
            String bQt = aVar.bQt();
            if (!StringUtils.isNull(bQt)) {
                ba.amO().b(this.hNh.getPageContext(), new String[]{bQt});
            }
            com.baidu.tieba.pb.c.a.a(this.hNw, aVar, aVar.locate, 7);
        }
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hNw = dVar;
    }
}
