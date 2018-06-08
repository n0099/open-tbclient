package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class j extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.m> {
    private HTypeListView blU;
    private com.baidu.tieba.personPolymeric.a.o fXN;
    private View.OnClickListener fXV;
    private View mRootView;
    private TextView mTitleView;
    private long uid;

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fXV = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.bkF();
            }
        };
        this.currentPageType = 4;
        this.mRootView = getView();
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.card_person_vedio_list_title);
        this.blU = (HTypeListView) this.mRootView.findViewById(d.g.card_person_vedio_view_pager);
        this.fXN = new com.baidu.tieba.personPolymeric.a.o(this.mTbPageContext, this.blU);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.j(this.mRootView, d.C0141d.cp_bg_line_d);
            al.h(this.mTitleView, d.C0141d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_person_vedio_list_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.m mVar) {
        if (mVar == null || w.z(mVar.fWS)) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.uid = mVar.uid;
        this.mTitleView.setText(d.k.video_title_str);
        this.blU.setData(df(mVar.fWS));
        this.fXN.P(this.fXV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkF() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoListActivityConfig(this.mContext).createNormalCfg(this.uid, "personal")));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.h> df(List<com.baidu.adp.widget.ListView.h> list) {
        int y = w.y(list);
        if (y > 0) {
            List<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>(list);
            int e = com.baidu.adp.lib.util.l.e(this.mTbPageContext.getPageActivity(), d.e.ds490);
            int e2 = com.baidu.adp.lib.util.l.e(this.mTbPageContext.getPageActivity(), d.e.ds32);
            if (y > 3) {
                arrayList = arrayList.subList(0, 3);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.width = com.baidu.adp.lib.util.l.e(this.mTbPageContext.getPageActivity(), d.e.ds120);
                hVar.height = com.baidu.adp.lib.util.l.e(this.mTbPageContext.getPageActivity(), d.e.ds396);
                w.b(arrayList, hVar);
            }
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(e2, e);
            w.a((List<com.baidu.tieba.person.d>) arrayList, 0, dVar);
            w.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }
}
