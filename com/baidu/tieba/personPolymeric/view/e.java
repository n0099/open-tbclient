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
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.g> {
    private HTypeListView byG;
    private com.baidu.tieba.personPolymeric.a.o gsw;
    private View mDividerView;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitle;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.mDividerView = this.mRootView.findViewById(e.g.divider_view);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.gift_title);
        this.byG = (HTypeListView) this.mRootView.findViewById(e.g.gift_horizontal_list);
        this.gsw = new com.baidu.tieba.personPolymeric.a.o(this.mPageContext, this.byG);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.j(this.mRootView, e.d.cp_bg_line_d);
        al.j(this.mDividerView, e.d.cp_bg_line_b);
        al.h(this.mTitle, e.d.cp_cont_d);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_gift_list;
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
        this.gsw.R(onClickListener);
        this.mRootView.setOnClickListener(onClickListener);
        this.gsw.S(onClickListener);
        this.byG.setData(ds(gVar.grv));
        if (gVar.mIsHost) {
            this.mTitle.setText(e.j.gift_received_by_me);
        } else if (gVar.grt) {
            this.mTitle.setText(e.j.gift_received_by_him);
        } else {
            this.mTitle.setText(e.j.gift_received_by_her);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.personPolymeric.c.g gVar) {
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.mPageContext.showToast(e.j.gift_load_fail);
        } else if (ba.bG(this.mPageContext.getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.mPageContext.getPageActivity(), gVar.mUid, gVar.Ek, gVar.gru, gVar.mSex)));
        }
    }

    private List<com.baidu.adp.widget.ListView.h> ds(List<com.baidu.adp.widget.ListView.h> list) {
        int H = v.H(list);
        if (H > 0) {
            List<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>(list);
            int h = com.baidu.adp.lib.util.l.h(this.mTbPageContext.getPageActivity(), e.C0200e.ds100);
            int h2 = com.baidu.adp.lib.util.l.h(this.mTbPageContext.getPageActivity(), e.C0200e.ds32);
            if (H > 7) {
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
