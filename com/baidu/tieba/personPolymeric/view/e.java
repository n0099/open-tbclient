package com.baidu.tieba.personPolymeric.view;

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
    private HTypeListView bat;
    private View cmp;
    private com.baidu.tieba.personPolymeric.a.p fqL;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitle;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.cmp = this.mRootView.findViewById(d.g.divider_view);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.gift_title);
        this.bat = (HTypeListView) this.mRootView.findViewById(d.g.gift_horizontal_list);
        this.fqL = new com.baidu.tieba.personPolymeric.a.p(this.mPageContext, this.bat);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        aj.k(this.mRootView, d.C0080d.cp_bg_line_d);
        aj.k(this.cmp, d.C0080d.cp_bg_line_b);
        aj.i(this.mTitle, d.C0080d.cp_cont_d);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_gift_list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(final com.baidu.tieba.personPolymeric.c.g gVar) {
        if (gVar == null || !gVar.isValid()) {
            this.mRootView.setVisibility(8);
            return;
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.b(gVar);
            }
        };
        this.fqL.L(onClickListener);
        this.mRootView.setOnClickListener(onClickListener);
        this.fqL.M(onClickListener);
        this.bat.setData(cJ(gVar.fpK));
        if (gVar.mIsHost) {
            this.mTitle.setText(d.j.gift_received_by_me);
        } else if (gVar.fpI) {
            this.mTitle.setText(d.j.gift_received_by_him);
        } else {
            this.mTitle.setText(d.j.gift_received_by_her);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.personPolymeric.c.g gVar) {
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.mPageContext.showToast(d.j.gift_load_fail);
        } else if (ax.aT(this.mPageContext.getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mPageContext.getPageActivity(), gVar.mUid, gVar.ws, gVar.fpJ, gVar.mSex)));
        }
    }

    private List<com.baidu.adp.widget.ListView.f> cJ(List<com.baidu.adp.widget.ListView.f> list) {
        int u = v.u(list);
        if (u > 0) {
            List<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>(list);
            int f = com.baidu.adp.lib.util.l.f(this.mTbPageContext.getPageActivity(), d.e.ds100);
            int f2 = com.baidu.adp.lib.util.l.f(this.mTbPageContext.getPageActivity(), d.e.ds32);
            if (u > 7) {
                arrayList = arrayList.subList(0, 7);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.height = f;
                hVar.width = f;
                v.b((List<com.baidu.tieba.personPolymeric.c.h>) arrayList, hVar);
            }
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(f2, f);
            v.a((List<com.baidu.tieba.person.d>) arrayList, 0, dVar);
            v.b((List<com.baidu.tieba.person.d>) arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
