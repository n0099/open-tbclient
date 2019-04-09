package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class j extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.m> {
    private HTypeListView cOb;
    private com.baidu.tieba.personPolymeric.a.o hSU;
    private View.OnClickListener hTb;
    private View mRootView;
    private TextView mTitleView;
    private long uid;

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hTb = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.bSp();
            }
        };
        this.currentPageType = 4;
        this.mRootView = getView();
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.card_person_vedio_list_title);
        this.cOb = (HTypeListView) this.mRootView.findViewById(d.g.card_person_vedio_view_pager);
        this.hSU = new com.baidu.tieba.personPolymeric.a.o(this.mTbPageContext, this.cOb);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.l(this.mRootView, d.C0277d.cp_bg_line_d);
            al.j(this.mTitleView, d.C0277d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_person_vedio_list_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.m mVar) {
        if (mVar == null || v.T(mVar.hRZ)) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.uid = mVar.uid;
        this.mTitleView.setText(d.j.video_title_str);
        this.cOb.setData(dJ(mVar.hRZ));
        this.hSU.S(this.hTb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSp() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoListActivityConfig(this.mContext).createNormalCfg(this.uid, "personal")));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.m> dJ(List<com.baidu.adp.widget.ListView.m> list) {
        int S = v.S(list);
        if (S > 0) {
            List<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>(list);
            int h = com.baidu.adp.lib.util.l.h(this.mTbPageContext.getPageActivity(), d.e.ds490);
            int h2 = com.baidu.adp.lib.util.l.h(this.mTbPageContext.getPageActivity(), d.e.ds32);
            if (S > 3) {
                arrayList = arrayList.subList(0, 3);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.width = com.baidu.adp.lib.util.l.h(this.mTbPageContext.getPageActivity(), d.e.ds120);
                hVar.height = com.baidu.adp.lib.util.l.h(this.mTbPageContext.getPageActivity(), d.e.ds396);
                v.b(arrayList, hVar);
            }
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(h2, h);
            v.a((List<com.baidu.tieba.person.d>) arrayList, 0, dVar);
            v.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }
}
