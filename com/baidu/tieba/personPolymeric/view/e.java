package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.g> {
    private View bjK;
    private HTypeListView cNY;
    private com.baidu.tieba.personPolymeric.a.o hTh;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitle;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.bjK = this.mRootView.findViewById(d.g.divider_view);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.gift_title);
        this.cNY = (HTypeListView) this.mRootView.findViewById(d.g.gift_horizontal_list);
        this.hTh = new com.baidu.tieba.personPolymeric.a.o(this.mPageContext, this.cNY);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
        al.l(this.bjK, d.C0277d.cp_bg_line_b);
        al.j(this.mTitle, d.C0277d.cp_cont_d);
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
        this.hTh.R(onClickListener);
        this.mRootView.setOnClickListener(onClickListener);
        this.hTh.S(onClickListener);
        this.cNY.setData(dM(gVar.hSg));
        if (gVar.mIsHost) {
            this.mTitle.setText(d.j.gift_received_by_me);
        } else if (gVar.hSe) {
            this.mTitle.setText(d.j.gift_received_by_him);
        } else {
            this.mTitle.setText(d.j.gift_received_by_her);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.personPolymeric.c.g gVar) {
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.mPageContext.showToast(d.j.gift_load_fail);
        } else if (bc.cZ(this.mPageContext.getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.mPageContext.getPageActivity(), gVar.mUid, gVar.Ej, gVar.hSf, gVar.mSex)));
        }
    }

    private List<com.baidu.adp.widget.ListView.m> dM(List<com.baidu.adp.widget.ListView.m> list) {
        int S = v.S(list);
        if (S > 0) {
            List<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>(list);
            int h = com.baidu.adp.lib.util.l.h(this.mTbPageContext.getPageActivity(), d.e.ds100);
            int h2 = com.baidu.adp.lib.util.l.h(this.mTbPageContext.getPageActivity(), d.e.ds32);
            if (S > 7) {
                arrayList = arrayList.subList(0, 7);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.height = h;
                hVar.width = h;
                v.b(arrayList, hVar);
            }
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(h2, h);
            v.a((List<com.baidu.tieba.person.d>) arrayList, 0, dVar);
            v.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
