package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.g> {
    private HTypeListView bTP;
    private View drs;
    private com.baidu.tieba.personPolymeric.a.o gqS;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitle;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.drs = this.mRootView.findViewById(d.g.divider_view);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.gift_title);
        this.bTP = (HTypeListView) this.mRootView.findViewById(d.g.gift_horizontal_list);
        this.gqS = new com.baidu.tieba.personPolymeric.a.o(this.mPageContext, this.bTP);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        aj.t(this.mRootView, d.C0140d.cp_bg_line_d);
        aj.t(this.drs, d.C0140d.cp_bg_line_b);
        aj.r(this.mTitle, d.C0140d.cp_cont_d);
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
        this.gqS.N(onClickListener);
        this.mRootView.setOnClickListener(onClickListener);
        this.gqS.O(onClickListener);
        this.bTP.setData(df(gVar.gpQ));
        if (gVar.mIsHost) {
            this.mTitle.setText(d.j.gift_received_by_me);
        } else if (gVar.gpO) {
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
        } else if (ay.ba(this.mPageContext.getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.mPageContext.getPageActivity(), gVar.mUid, gVar.akD, gVar.gpP, gVar.mSex)));
        }
    }

    private List<com.baidu.adp.widget.ListView.i> df(List<com.baidu.adp.widget.ListView.i> list) {
        int D = v.D(list);
        if (D > 0) {
            List<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>(list);
            int t = com.baidu.adp.lib.util.l.t(this.mTbPageContext.getPageActivity(), d.e.ds100);
            int t2 = com.baidu.adp.lib.util.l.t(this.mTbPageContext.getPageActivity(), d.e.ds32);
            if (D > 7) {
                arrayList = arrayList.subList(0, 7);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.height = t;
                hVar.width = t;
                v.b((List<com.baidu.tieba.personPolymeric.c.h>) arrayList, hVar);
            }
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(t2, t);
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
