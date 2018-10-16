package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class j extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.m> {
    private HTypeListView bxV;
    private com.baidu.tieba.personPolymeric.a.o gqW;
    private View.OnClickListener grd;
    private View mRootView;
    private TextView mTitleView;
    private long uid;

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.grd = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.bpn();
            }
        };
        this.currentPageType = 4;
        this.mRootView = getView();
        this.mTitleView = (TextView) this.mRootView.findViewById(e.g.card_person_vedio_list_title);
        this.bxV = (HTypeListView) this.mRootView.findViewById(e.g.card_person_vedio_view_pager);
        this.gqW = new com.baidu.tieba.personPolymeric.a.o(this.mTbPageContext, this.bxV);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.j(this.mRootView, e.d.cp_bg_line_d);
            al.h(this.mTitleView, e.d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_person_vedio_list_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.m mVar) {
        if (mVar == null || v.J(mVar.gqb)) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.uid = mVar.uid;
        this.mTitleView.setText(e.j.video_title_str);
        this.bxV.setData(du(mVar.gqb));
        this.gqW.Q(this.grd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpn() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoListActivityConfig(this.mContext).createNormalCfg(this.uid, "personal")));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.h> du(List<com.baidu.adp.widget.ListView.h> list) {
        int I = v.I(list);
        if (I > 0) {
            List<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>(list);
            int h = com.baidu.adp.lib.util.l.h(this.mTbPageContext.getPageActivity(), e.C0175e.ds490);
            int h2 = com.baidu.adp.lib.util.l.h(this.mTbPageContext.getPageActivity(), e.C0175e.ds32);
            if (I > 3) {
                arrayList = arrayList.subList(0, 3);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.width = com.baidu.adp.lib.util.l.h(this.mTbPageContext.getPageActivity(), e.C0175e.ds120);
                hVar.height = com.baidu.adp.lib.util.l.h(this.mTbPageContext.getPageActivity(), e.C0175e.ds396);
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
