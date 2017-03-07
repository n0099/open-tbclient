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
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.f> {
    private TextView aSO;
    private TbPageContext ajF;
    private HTypeListView bsu;
    private View buO;
    private com.baidu.tieba.personPolymeric.a.t eIH;
    private View mRootView;

    public h(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ajF = tbPageContext;
        this.mRootView = getView();
        this.buO = this.mRootView.findViewById(w.h.divider_view);
        this.aSO = (TextView) this.mRootView.findViewById(w.h.gift_title);
        this.bsu = (HTypeListView) this.mRootView.findViewById(w.h.gift_horizontal_list);
        this.eIH = new com.baidu.tieba.personPolymeric.a.t(this.ajF, this.bsu);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        aq.k(this.mRootView, w.e.cp_bg_line_d);
        aq.k(this.buO, w.e.cp_bg_line_b);
        aq.i((View) this.aSO, w.e.cp_cont_d);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_gift_list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.f fVar) {
        if (fVar == null || !fVar.isValid()) {
            this.mRootView.setVisibility(8);
            return;
        }
        i iVar = new i(this, fVar);
        this.eIH.L(iVar);
        this.mRootView.setOnClickListener(iVar);
        this.eIH.M(iVar);
        this.bsu.setData(ck(fVar.eHE));
        if (fVar.bch) {
            this.aSO.setText(w.l.gift_received_by_me);
        } else if (fVar.eHD) {
            this.aSO.setText(w.l.gift_received_by_him);
        } else {
            this.aSO.setText(w.l.gift_received_by_her);
        }
        onChangeSkinType(this.ajF, TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.personPolymeric.c.f fVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.ajF.showToast(w.l.gift_load_fail);
        } else if (bg.aI(this.ajF.getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.ajF.getPageActivity(), fVar.mUid, fVar.xn, fVar.mSex)));
        }
    }

    private List<com.baidu.adp.widget.ListView.v> ck(List<com.baidu.adp.widget.ListView.v> list) {
        int p = com.baidu.tbadk.core.util.x.p(list);
        if (p > 0) {
            List<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>(list);
            int g = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), w.f.ds120);
            int g2 = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), w.f.ds32);
            if (p > 7) {
                arrayList = arrayList.subList(0, 7);
                com.baidu.tieba.personPolymeric.c.g gVar = new com.baidu.tieba.personPolymeric.c.g();
                gVar.height = g;
                gVar.width = g;
                com.baidu.tbadk.core.util.x.b(arrayList, gVar);
            }
            com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b(g2, g);
            com.baidu.tbadk.core.util.x.a((List<com.baidu.tieba.personCenter.c.b>) arrayList, 0, bVar);
            com.baidu.tbadk.core.util.x.b(arrayList, bVar);
            return arrayList;
        }
        return list;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
