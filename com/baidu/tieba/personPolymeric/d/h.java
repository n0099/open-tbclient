package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.f> {
    private TbPageContext GM;
    private TextView aYh;
    private View bMX;
    private HTypeListView eBH;
    private com.baidu.tieba.personPolymeric.a.t eJl;
    private View mRootView;

    public h(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.GM = tbPageContext;
        this.mRootView = getView();
        this.bMX = this.mRootView.findViewById(t.g.divider_view);
        this.aYh = (TextView) this.mRootView.findViewById(t.g.gift_title);
        this.eBH = (HTypeListView) this.mRootView.findViewById(t.g.gift_horizontal_list);
        this.eJl = new com.baidu.tieba.personPolymeric.a.t(this.GM, this.eBH);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        av.l(this.mRootView, t.d.cp_bg_line_d);
        av.l(this.bMX, t.d.cp_bg_line_b);
        av.j((View) this.aYh, t.d.cp_cont_d);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_gift_list;
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
        this.eJl.N(iVar);
        this.mRootView.setOnClickListener(iVar);
        this.eJl.K(iVar);
        this.eBH.setData(cF(fVar.eIh));
        if (fVar.cue) {
            this.aYh.setText(t.j.gift_received_by_me);
        } else if (fVar.eIg) {
            this.aYh.setText(t.j.gift_received_by_him);
        } else {
            this.aYh.setText(t.j.gift_received_by_her);
        }
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.personPolymeric.c.f fVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.GM.showToast(t.j.gift_load_fail);
        } else if (bn.al(this.GM.getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.GM.getPageActivity(), fVar.mUid, fVar.pW, fVar.mSex)));
        }
    }

    private List<com.baidu.adp.widget.ListView.v> cF(List<com.baidu.adp.widget.ListView.v> list) {
        int s = com.baidu.tbadk.core.util.y.s(list);
        if (s > 0) {
            List<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>(list);
            int e = com.baidu.adp.lib.util.k.e(this.mTbPageContext.getPageActivity(), t.e.ds120);
            int e2 = com.baidu.adp.lib.util.k.e(this.mTbPageContext.getPageActivity(), t.e.ds32);
            if (s > 7) {
                arrayList = arrayList.subList(0, 7);
                com.baidu.tieba.personPolymeric.c.g gVar = new com.baidu.tieba.personPolymeric.c.g();
                gVar.height = e;
                gVar.width = e;
                com.baidu.tbadk.core.util.y.b(arrayList, gVar);
            }
            com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b(e2, e);
            com.baidu.tbadk.core.util.y.a((List<com.baidu.tieba.personCenter.c.b>) arrayList, 0, bVar);
            com.baidu.tbadk.core.util.y.b(arrayList, bVar);
            return arrayList;
        }
        return list;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
