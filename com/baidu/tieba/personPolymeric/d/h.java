package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.f> {
    private TbPageContext FY;
    private TextView aNb;
    private HTypeListView blB;
    private View bnS;
    private com.baidu.tieba.personPolymeric.a.t eFf;
    private View mRootView;

    public h(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.FY = tbPageContext;
        this.mRootView = getView();
        this.bnS = this.mRootView.findViewById(r.h.divider_view);
        this.aNb = (TextView) this.mRootView.findViewById(r.h.gift_title);
        this.blB = (HTypeListView) this.mRootView.findViewById(r.h.gift_horizontal_list);
        this.eFf = new com.baidu.tieba.personPolymeric.a.t(this.FY, this.blB);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.k(this.mRootView, r.e.cp_bg_line_d);
        ap.k(this.bnS, r.e.cp_bg_line_b);
        ap.i((View) this.aNb, r.e.cp_cont_d);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_gift_list;
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
        this.eFf.N(iVar);
        this.mRootView.setOnClickListener(iVar);
        this.eFf.O(iVar);
        this.blB.setData(cD(fVar.eEc));
        if (fVar.aVU) {
            this.aNb.setText(r.l.gift_received_by_me);
        } else if (fVar.eEb) {
            this.aNb.setText(r.l.gift_received_by_him);
        } else {
            this.aNb.setText(r.l.gift_received_by_her);
        }
        onChangeSkinType(this.FY, TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.personPolymeric.c.f fVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.FY.showToast(r.l.gift_load_fail);
        } else if (bf.ak(this.FY.getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.FY.getPageActivity(), fVar.mUid, fVar.pR, fVar.mSex)));
        }
    }

    private List<com.baidu.adp.widget.ListView.v> cD(List<com.baidu.adp.widget.ListView.v> list) {
        int r = com.baidu.tbadk.core.util.w.r(list);
        if (r > 0) {
            List<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>(list);
            int e = com.baidu.adp.lib.util.k.e(this.mTbPageContext.getPageActivity(), r.f.ds120);
            int e2 = com.baidu.adp.lib.util.k.e(this.mTbPageContext.getPageActivity(), r.f.ds32);
            if (r > 7) {
                arrayList = arrayList.subList(0, 7);
                com.baidu.tieba.personPolymeric.c.g gVar = new com.baidu.tieba.personPolymeric.c.g();
                gVar.height = e;
                gVar.width = e;
                com.baidu.tbadk.core.util.w.b(arrayList, gVar);
            }
            com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b(e2, e);
            com.baidu.tbadk.core.util.w.a((List<com.baidu.tieba.personCenter.c.b>) arrayList, 0, bVar);
            com.baidu.tbadk.core.util.w.b(arrayList, bVar);
            return arrayList;
        }
        return list;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
