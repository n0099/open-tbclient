package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.m> {
    private HTypeListView aYJ;
    private TextView abX;
    private com.baidu.tieba.personPolymeric.a.o flj;
    private View.OnClickListener fln;
    private View mRootView;
    private long uid;

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fln = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.aYI();
            }
        };
        this.mRootView = getView();
        this.abX = (TextView) this.mRootView.findViewById(d.h.card_person_vedio_list_title);
        this.aYJ = (HTypeListView) this.mRootView.findViewById(d.h.card_person_vedio_view_pager);
        this.flj = new com.baidu.tieba.personPolymeric.a.o(this.mTbPageContext, this.aYJ);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ai.k(this.mRootView, d.e.cp_bg_line_d);
            ai.i(this.abX, d.e.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_person_vedio_list_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.m mVar) {
        if (mVar == null || u.v(mVar.fkC)) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.uid = mVar.uid;
        this.abX.setText(d.l.msglist_video);
        this.aYJ.setData(cK(mVar.fkC));
        this.flj.P(this.fln);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYI() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.mContext).createNormalCfg(this.uid, "personal")));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.f> cK(List<com.baidu.adp.widget.ListView.f> list) {
        int u = u.u(list);
        if (u > 0) {
            List<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>(list);
            int g = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), d.f.ds490);
            int g2 = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), d.f.ds32);
            if (u > 3) {
                arrayList = arrayList.subList(0, 3);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.width = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), d.f.ds120);
                hVar.height = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), d.f.ds396);
                u.b((List<com.baidu.tieba.personPolymeric.c.h>) arrayList, hVar);
            }
            com.baidu.tieba.person.h hVar2 = new com.baidu.tieba.person.h(g2, g);
            u.a((List<com.baidu.tieba.person.h>) arrayList, 0, hVar2);
            u.b((List<com.baidu.tieba.person.h>) arrayList, hVar2);
            return arrayList;
        }
        return list;
    }
}
