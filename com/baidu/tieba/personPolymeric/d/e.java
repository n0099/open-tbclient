package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.g> {
    private HTypeListView aYu;
    private View ceN;
    private com.baidu.tieba.personPolymeric.a.o fms;
    private TbPageContext mF;
    private View mRootView;
    private TextView mTitle;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mF = tbPageContext;
        this.mRootView = getView();
        this.ceN = this.mRootView.findViewById(d.h.divider_view);
        this.mTitle = (TextView) this.mRootView.findViewById(d.h.gift_title);
        this.aYu = (HTypeListView) this.mRootView.findViewById(d.h.gift_horizontal_list);
        this.fms = new com.baidu.tieba.personPolymeric.a.o(this.mF, this.aYu);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        aj.k(this.mRootView, d.e.cp_bg_line_d);
        aj.k(this.ceN, d.e.cp_bg_line_b);
        aj.i(this.mTitle, d.e.cp_cont_d);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_gift_list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(final com.baidu.tieba.personPolymeric.c.g gVar) {
        if (gVar == null || !gVar.isValid()) {
            this.mRootView.setVisibility(8);
            return;
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.b(gVar);
            }
        };
        this.fms.I(onClickListener);
        this.mRootView.setOnClickListener(onClickListener);
        this.fms.J(onClickListener);
        this.aYu.setData(cL(gVar.flD));
        if (gVar.bmn) {
            this.mTitle.setText(d.l.gift_received_by_me);
        } else if (gVar.flB) {
            this.mTitle.setText(d.l.gift_received_by_him);
        } else {
            this.mTitle.setText(d.l.gift_received_by_her);
        }
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.personPolymeric.c.g gVar) {
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.mF.showToast(d.l.gift_load_fail);
        } else if (ax.aU(this.mF.getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mF.getPageActivity(), gVar.mUid, gVar.wp, gVar.flC, gVar.mSex)));
        }
    }

    private List<com.baidu.adp.widget.ListView.f> cL(List<com.baidu.adp.widget.ListView.f> list) {
        int u = v.u(list);
        if (u > 0) {
            List<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>(list);
            int f = com.baidu.adp.lib.util.k.f(this.mTbPageContext.getPageActivity(), d.f.ds100);
            int f2 = com.baidu.adp.lib.util.k.f(this.mTbPageContext.getPageActivity(), d.f.ds32);
            if (u > 7) {
                arrayList = arrayList.subList(0, 7);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.height = f;
                hVar.width = f;
                v.b((List<com.baidu.tieba.personPolymeric.c.h>) arrayList, hVar);
            }
            com.baidu.tieba.person.h hVar2 = new com.baidu.tieba.person.h(f2, f);
            v.a((List<com.baidu.tieba.person.h>) arrayList, 0, hVar2);
            v.b((List<com.baidu.tieba.person.h>) arrayList, hVar2);
            return arrayList;
        }
        return list;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
