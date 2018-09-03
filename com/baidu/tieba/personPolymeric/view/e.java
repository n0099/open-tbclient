package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.g> {
    private HTypeListView bob;
    private View cUL;
    private com.baidu.tieba.personPolymeric.a.o gcf;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitle;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.cUL = this.mRootView.findViewById(f.g.divider_view);
        this.mTitle = (TextView) this.mRootView.findViewById(f.g.gift_title);
        this.bob = (HTypeListView) this.mRootView.findViewById(f.g.gift_horizontal_list);
        this.gcf = new com.baidu.tieba.personPolymeric.a.o(this.mPageContext, this.bob);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        am.j(this.mRootView, f.d.cp_bg_line_d);
        am.j(this.cUL, f.d.cp_bg_line_b);
        am.h(this.mTitle, f.d.cp_cont_d);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_gift_list;
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
        this.gcf.Q(onClickListener);
        this.mRootView.setOnClickListener(onClickListener);
        this.gcf.R(onClickListener);
        this.bob.setData(df(gVar.gbd));
        if (gVar.mIsHost) {
            this.mTitle.setText(f.j.gift_received_by_me);
        } else if (gVar.gbb) {
            this.mTitle.setText(f.j.gift_received_by_him);
        } else {
            this.mTitle.setText(f.j.gift_received_by_her);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.personPolymeric.c.g gVar) {
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.mPageContext.showToast(f.j.gift_load_fail);
        } else if (bb.aU(this.mPageContext.getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.mPageContext.getPageActivity(), gVar.mUid, gVar.Bd, gVar.gbc, gVar.mSex)));
        }
    }

    private List<com.baidu.adp.widget.ListView.h> df(List<com.baidu.adp.widget.ListView.h> list) {
        int y = w.y(list);
        if (y > 0) {
            List<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>(list);
            int f = com.baidu.adp.lib.util.l.f(this.mTbPageContext.getPageActivity(), f.e.ds100);
            int f2 = com.baidu.adp.lib.util.l.f(this.mTbPageContext.getPageActivity(), f.e.ds32);
            if (y > 7) {
                arrayList = arrayList.subList(0, 7);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.height = f;
                hVar.width = f;
                w.b(arrayList, hVar);
            }
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(f2, f);
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
