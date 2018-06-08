package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.g> {
    private HTypeListView blU;
    private View cUb;
    private com.baidu.tieba.personPolymeric.a.o fXN;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitle;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.cUb = this.mRootView.findViewById(d.g.divider_view);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.gift_title);
        this.blU = (HTypeListView) this.mRootView.findViewById(d.g.gift_horizontal_list);
        this.fXN = new com.baidu.tieba.personPolymeric.a.o(this.mPageContext, this.blU);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.j(this.mRootView, d.C0141d.cp_bg_line_d);
        al.j(this.cUb, d.C0141d.cp_bg_line_b);
        al.h(this.mTitle, d.C0141d.cp_cont_d);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_gift_list;
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
        this.fXN.O(onClickListener);
        this.mRootView.setOnClickListener(onClickListener);
        this.fXN.P(onClickListener);
        this.blU.setData(df(gVar.fWM));
        if (gVar.mIsHost) {
            this.mTitle.setText(d.k.gift_received_by_me);
        } else if (gVar.fWK) {
            this.mTitle.setText(d.k.gift_received_by_him);
        } else {
            this.mTitle.setText(d.k.gift_received_by_her);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.personPolymeric.c.g gVar) {
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.mPageContext.showToast(d.k.gift_load_fail);
        } else if (ba.aU(this.mPageContext.getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.mPageContext.getPageActivity(), gVar.mUid, gVar.Bf, gVar.fWL, gVar.mSex)));
        }
    }

    private List<com.baidu.adp.widget.ListView.h> df(List<com.baidu.adp.widget.ListView.h> list) {
        int y = w.y(list);
        if (y > 0) {
            List<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>(list);
            int e = com.baidu.adp.lib.util.l.e(this.mTbPageContext.getPageActivity(), d.e.ds100);
            int e2 = com.baidu.adp.lib.util.l.e(this.mTbPageContext.getPageActivity(), d.e.ds32);
            if (y > 7) {
                arrayList = arrayList.subList(0, 7);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.height = e;
                hVar.width = e;
                w.b(arrayList, hVar);
            }
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(e2, e);
            w.a((List<com.baidu.tieba.person.d>) arrayList, 0, dVar);
            w.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
