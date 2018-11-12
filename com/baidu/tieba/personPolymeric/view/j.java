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
    private HTypeListView byG;
    private View.OnClickListener gsD;
    private com.baidu.tieba.personPolymeric.a.o gsw;
    private View mRootView;
    private TextView mTitleView;
    private long uid;

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gsD = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.boI();
            }
        };
        this.currentPageType = 4;
        this.mRootView = getView();
        this.mTitleView = (TextView) this.mRootView.findViewById(e.g.card_person_vedio_list_title);
        this.byG = (HTypeListView) this.mRootView.findViewById(e.g.card_person_vedio_view_pager);
        this.gsw = new com.baidu.tieba.personPolymeric.a.o(this.mTbPageContext, this.byG);
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
        if (mVar == null || v.I(mVar.grB)) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.uid = mVar.uid;
        this.mTitleView.setText(e.j.video_title_str);
        this.byG.setData(ds(mVar.grB));
        this.gsw.S(this.gsD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boI() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoListActivityConfig(this.mContext).createNormalCfg(this.uid, "personal")));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.h> ds(List<com.baidu.adp.widget.ListView.h> list) {
        int H = v.H(list);
        if (H > 0) {
            List<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>(list);
            int h = com.baidu.adp.lib.util.l.h(this.mTbPageContext.getPageActivity(), e.C0200e.ds490);
            int h2 = com.baidu.adp.lib.util.l.h(this.mTbPageContext.getPageActivity(), e.C0200e.ds32);
            if (H > 3) {
                arrayList = arrayList.subList(0, 3);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.width = com.baidu.adp.lib.util.l.h(this.mTbPageContext.getPageActivity(), e.C0200e.ds120);
                hVar.height = com.baidu.adp.lib.util.l.h(this.mTbPageContext.getPageActivity(), e.C0200e.ds396);
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
