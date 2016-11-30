package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.f> {
    private TbPageContext GO;
    private TextView aOH;
    private View bPN;
    private HTypeListView eKj;
    private com.baidu.tieba.personPolymeric.a.t eRM;
    private View mRootView;

    public h(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.GO = tbPageContext;
        this.mRootView = getView();
        this.bPN = this.mRootView.findViewById(r.g.divider_view);
        this.aOH = (TextView) this.mRootView.findViewById(r.g.gift_title);
        this.eKj = (HTypeListView) this.mRootView.findViewById(r.g.gift_horizontal_list);
        this.eRM = new com.baidu.tieba.personPolymeric.a.t(this.GO, this.eKj);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        at.l(this.mRootView, r.d.cp_bg_line_d);
        at.l(this.bPN, r.d.cp_bg_line_b);
        at.j((View) this.aOH, r.d.cp_cont_d);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_gift_list;
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
        this.eRM.O(iVar);
        this.mRootView.setOnClickListener(iVar);
        this.eRM.L(iVar);
        this.eKj.setData(cI(fVar.eQJ));
        if (fVar.czI) {
            this.aOH.setText(r.j.gift_received_by_me);
        } else if (fVar.eQI) {
            this.aOH.setText(r.j.gift_received_by_him);
        } else {
            this.aOH.setText(r.j.gift_received_by_her);
        }
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.personPolymeric.c.f fVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.GO.showToast(r.j.gift_load_fail);
        } else if (bk.ak(this.GO.getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.GO.getPageActivity(), fVar.mUid, fVar.pX, fVar.mSex)));
        }
    }

    private List<com.baidu.adp.widget.ListView.v> cI(List<com.baidu.adp.widget.ListView.v> list) {
        int s = com.baidu.tbadk.core.util.x.s(list);
        if (s > 0) {
            List<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>(list);
            int e = com.baidu.adp.lib.util.k.e(this.mTbPageContext.getPageActivity(), r.e.ds120);
            int e2 = com.baidu.adp.lib.util.k.e(this.mTbPageContext.getPageActivity(), r.e.ds32);
            if (s > 7) {
                arrayList = arrayList.subList(0, 7);
                com.baidu.tieba.personPolymeric.c.g gVar = new com.baidu.tieba.personPolymeric.c.g();
                gVar.height = e;
                gVar.width = e;
                com.baidu.tbadk.core.util.x.b(arrayList, gVar);
            }
            com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b(e2, e);
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
