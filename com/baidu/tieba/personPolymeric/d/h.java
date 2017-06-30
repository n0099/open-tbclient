package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.g> {
    private TbPageContext ajP;
    private HTypeListView bBi;
    private View bUX;
    private com.baidu.tieba.personPolymeric.a.t eXv;
    private View mRootView;
    private TextView mTitle;

    public h(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ajP = tbPageContext;
        this.mRootView = getView();
        this.bUX = this.mRootView.findViewById(w.h.divider_view);
        this.mTitle = (TextView) this.mRootView.findViewById(w.h.gift_title);
        this.bBi = (HTypeListView) this.mRootView.findViewById(w.h.gift_horizontal_list);
        this.eXv = new com.baidu.tieba.personPolymeric.a.t(this.ajP, this.bBi);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        as.k(this.mRootView, w.e.cp_bg_line_d);
        as.k(this.bUX, w.e.cp_bg_line_b);
        as.i(this.mTitle, w.e.cp_cont_d);
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
        this.eXv.Q(iVar);
        this.mRootView.setOnClickListener(iVar);
        this.eXv.R(iVar);
        this.bBi.setData(ct(gVar.eWG));
        if (gVar.bhl) {
            this.mTitle.setText(w.l.gift_received_by_me);
        } else if (gVar.eWF) {
            this.mTitle.setText(w.l.gift_received_by_him);
        } else {
            this.mTitle.setText(w.l.gift_received_by_her);
        }
        d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.personPolymeric.c.g gVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.ajP.showToast(w.l.gift_load_fail);
        } else if (bl.aN(this.ajP.getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.ajP.getPageActivity(), gVar.mUid, gVar.wU, gVar.mSex)));
        }
    }

    private List<com.baidu.adp.widget.ListView.v> ct(List<com.baidu.adp.widget.ListView.v> list) {
        int s = com.baidu.tbadk.core.util.z.s(list);
        if (s > 0) {
            List<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>(list);
            int g = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), w.f.ds120);
            int g2 = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), w.f.ds32);
            if (s > 7) {
                arrayList = arrayList.subList(0, 7);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.height = g;
                hVar.width = g;
                com.baidu.tbadk.core.util.z.b((List<com.baidu.tieba.personPolymeric.c.h>) arrayList, hVar);
            }
            com.baidu.tieba.person.h hVar2 = new com.baidu.tieba.person.h(g2, g);
            com.baidu.tbadk.core.util.z.a((List<com.baidu.tieba.person.h>) arrayList, 0, hVar2);
            com.baidu.tbadk.core.util.z.b((List<com.baidu.tieba.person.h>) arrayList, hVar2);
            return arrayList;
        }
        return list;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
