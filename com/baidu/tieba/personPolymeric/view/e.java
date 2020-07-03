package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.g> {
    private View dnC;
    private HTypeListView kEz;
    private com.baidu.tieba.personPolymeric.a.o kQr;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitle;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.dnC = this.mRootView.findViewById(R.id.divider_view);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.gift_title);
        this.kEz = (HTypeListView) this.mRootView.findViewById(R.id.gift_horizontal_list);
        this.kQr = new com.baidu.tieba.personPolymeric.a.o(this.mPageContext, this.kEz);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        an.setBackgroundColor(this.dnC, R.color.cp_bg_line_c);
        an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_d);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_gift_list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
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
        this.kQr.X(onClickListener);
        this.mRootView.setOnClickListener(onClickListener);
        this.kQr.Y(onClickListener);
        this.kEz.setData(eE(gVar.kNR));
        if (gVar.mIsHost) {
            this.mTitle.setText(R.string.gift_received_by_me);
        } else if (gVar.kNP) {
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
        } else if (be.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mPageContext.getPageActivity(), gVar.mUid, gVar.Mt, gVar.kNQ, gVar.mSex)));
        }
    }

    private List<q> eE(List<q> list) {
        int count = w.getCount(list);
        if (count > 0) {
            List<q> arrayList = new ArrayList<>(list);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.ds100);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.ds32);
            if (count > 7) {
                arrayList = arrayList.subList(0, 7);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.height = dimens;
                hVar.width = dimens;
                w.add(arrayList, hVar);
            }
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(dimens2, dimens);
            w.add(arrayList, 0, dVar);
            w.add(arrayList, dVar);
            return arrayList;
        }
        return list;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
