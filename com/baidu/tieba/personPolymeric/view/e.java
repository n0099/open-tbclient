package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.g> {
    private View bqE;
    private HTypeListView cXR;
    private com.baidu.tieba.personPolymeric.a.o itf;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitle;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.bqE = this.mRootView.findViewById(R.id.divider_view);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.gift_title);
        this.cXR = (HTypeListView) this.mRootView.findViewById(R.id.gift_horizontal_list);
        this.itf = new com.baidu.tieba.personPolymeric.a.o(this.mPageContext, this.cXR);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.l(this.mRootView, R.color.cp_bg_line_d);
        am.l(this.bqE, R.color.cp_bg_line_b);
        am.j(this.mTitle, R.color.cp_cont_d);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_gift_list;
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
        this.itf.W(onClickListener);
        this.mRootView.setOnClickListener(onClickListener);
        this.itf.X(onClickListener);
        this.cXR.setData(dU(gVar.isf));
        if (gVar.mIsHost) {
            this.mTitle.setText(R.string.gift_received_by_me);
        } else if (gVar.isd) {
            this.mTitle.setText(R.string.gift_received_by_him);
        } else {
            this.mTitle.setText(R.string.gift_received_by_her);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.personPolymeric.c.g gVar) {
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.mPageContext.showToast(R.string.gift_load_fail);
        } else if (bd.cF(this.mPageContext.getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.mPageContext.getPageActivity(), gVar.mUid, gVar.BX, gVar.ise, gVar.mSex)));
        }
    }

    private List<com.baidu.adp.widget.ListView.m> dU(List<com.baidu.adp.widget.ListView.m> list) {
        int Z = v.Z(list);
        if (Z > 0) {
            List<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>(list);
            int g = com.baidu.adp.lib.util.l.g(this.mTbPageContext.getPageActivity(), R.dimen.ds100);
            int g2 = com.baidu.adp.lib.util.l.g(this.mTbPageContext.getPageActivity(), R.dimen.ds32);
            if (Z > 7) {
                arrayList = arrayList.subList(0, 7);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.height = g;
                hVar.width = g;
                v.b(arrayList, hVar);
            }
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(g2, g);
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
