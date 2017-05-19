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
    private TbPageContext ajr;
    private View bIo;
    private HTypeListView buC;
    private com.baidu.tieba.personPolymeric.a.t eEx;
    private View mRootView;
    private TextView mTitle;

    public h(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ajr = tbPageContext;
        this.mRootView = getView();
        this.bIo = this.mRootView.findViewById(w.h.divider_view);
        this.mTitle = (TextView) this.mRootView.findViewById(w.h.gift_title);
        this.buC = (HTypeListView) this.mRootView.findViewById(w.h.gift_horizontal_list);
        this.eEx = new com.baidu.tieba.personPolymeric.a.t(this.ajr, this.buC);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        aq.k(this.mRootView, w.e.cp_bg_line_d);
        aq.k(this.bIo, w.e.cp_bg_line_b);
        aq.i(this.mTitle, w.e.cp_cont_d);
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
        this.eEx.N(iVar);
        this.mRootView.setOnClickListener(iVar);
        this.eEx.O(iVar);
        this.buC.setData(cb(fVar.eDk));
        if (fVar.bdp) {
            this.mTitle.setText(w.l.gift_received_by_me);
        } else if (fVar.eDj) {
            this.mTitle.setText(w.l.gift_received_by_him);
        } else {
            this.mTitle.setText(w.l.gift_received_by_her);
        }
        onChangeSkinType(this.ajr, TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.personPolymeric.c.f fVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.ajr.showToast(w.l.gift_load_fail);
        } else if (bg.aN(this.ajr.getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.ajr.getPageActivity(), fVar.mUid, fVar.wU, fVar.mSex)));
        }
    }

    private List<com.baidu.adp.widget.ListView.v> cb(List<com.baidu.adp.widget.ListView.v> list) {
        int q = com.baidu.tbadk.core.util.x.q(list);
        if (q > 0) {
            List<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>(list);
            int g = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), w.f.ds120);
            int g2 = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), w.f.ds32);
            if (q > 7) {
                arrayList = arrayList.subList(0, 7);
                com.baidu.tieba.personPolymeric.c.g gVar = new com.baidu.tieba.personPolymeric.c.g();
                gVar.height = g;
                gVar.width = g;
                com.baidu.tbadk.core.util.x.b(arrayList, gVar);
            }
            com.baidu.tieba.personCenter.b.b bVar = new com.baidu.tieba.personCenter.b.b(g2, g);
            com.baidu.tbadk.core.util.x.a((List<com.baidu.tieba.personCenter.b.b>) arrayList, 0, bVar);
            com.baidu.tbadk.core.util.x.b(arrayList, bVar);
            return arrayList;
        }
        return list;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
