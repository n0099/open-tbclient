package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.g> {
    private TbPageContext ajh;
    private HTypeListView bAp;
    private View bOc;
    private com.baidu.tieba.personPolymeric.a.t eNm;
    private View mRootView;
    private TextView mTitle;

    public h(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ajh = tbPageContext;
        this.mRootView = getView();
        this.bOc = this.mRootView.findViewById(w.h.divider_view);
        this.mTitle = (TextView) this.mRootView.findViewById(w.h.gift_title);
        this.bAp = (HTypeListView) this.mRootView.findViewById(w.h.gift_horizontal_list);
        this.eNm = new com.baidu.tieba.personPolymeric.a.t(this.ajh, this.bAp);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        aq.k(this.mRootView, w.e.cp_bg_line_d);
        aq.k(this.bOc, w.e.cp_bg_line_b);
        aq.i(this.mTitle, w.e.cp_cont_d);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_gift_list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.g gVar) {
        if (gVar == null || !gVar.isValid()) {
            this.mRootView.setVisibility(8);
            return;
        }
        i iVar = new i(this, gVar);
        this.eNm.P(iVar);
        this.mRootView.setOnClickListener(iVar);
        this.eNm.Q(iVar);
        this.bAp.setData(ce(gVar.eMx));
        if (gVar.beq) {
            this.mTitle.setText(w.l.gift_received_by_me);
        } else if (gVar.eMw) {
            this.mTitle.setText(w.l.gift_received_by_him);
        } else {
            this.mTitle.setText(w.l.gift_received_by_her);
        }
        d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.personPolymeric.c.g gVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.ajh.showToast(w.l.gift_load_fail);
        } else if (bh.aN(this.ajh.getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.ajh.getPageActivity(), gVar.mUid, gVar.wU, gVar.mSex)));
        }
    }

    private List<com.baidu.adp.widget.ListView.v> ce(List<com.baidu.adp.widget.ListView.v> list) {
        int q = com.baidu.tbadk.core.util.x.q(list);
        if (q > 0) {
            List<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>(list);
            int g = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), w.f.ds120);
            int g2 = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), w.f.ds32);
            if (q > 7) {
                arrayList = arrayList.subList(0, 7);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.height = g;
                hVar.width = g;
                com.baidu.tbadk.core.util.x.b(arrayList, hVar);
            }
            com.baidu.tieba.person.h hVar2 = new com.baidu.tieba.person.h(g2, g);
            com.baidu.tbadk.core.util.x.a((List<com.baidu.tieba.person.h>) arrayList, 0, hVar2);
            com.baidu.tbadk.core.util.x.b(arrayList, hVar2);
            return arrayList;
        }
        return list;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
