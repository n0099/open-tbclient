package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.m> {
    private TextView aaa;
    private HTypeListView bAp;
    private com.baidu.tieba.personPolymeric.a.t eNm;
    private View.OnClickListener eNq;
    private View mRootView;
    private long uid;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eNq = new o(this);
        this.mRootView = getView();
        this.aaa = (TextView) this.mRootView.findViewById(w.h.card_person_vedio_list_title);
        this.bAp = (HTypeListView) this.mRootView.findViewById(w.h.card_person_vedio_view_pager);
        this.eNm = new com.baidu.tieba.personPolymeric.a.t(this.mTbPageContext, this.bAp);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            aq.k(this.mRootView, w.e.cp_bg_line_d);
            aq.i(this.aaa, w.e.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_person_vedio_list_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.m mVar) {
        if (mVar == null || com.baidu.tbadk.core.util.x.r(mVar.eMF)) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.uid = mVar.uid;
        this.aaa.setText(w.l.msglist_video);
        this.bAp.setData(ce(mVar.eMF));
        this.eNm.Q(this.eNq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRu() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.mContext).createNormalCfg(this.uid, "personal")));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.v> ce(List<com.baidu.adp.widget.ListView.v> list) {
        int q = com.baidu.tbadk.core.util.x.q(list);
        if (q > 0) {
            List<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>(list);
            int g = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), w.f.ds490);
            int g2 = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), w.f.ds32);
            if (q > 3) {
                arrayList = arrayList.subList(0, 3);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.width = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), w.f.ds120);
                hVar.height = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), w.f.ds396);
                com.baidu.tbadk.core.util.x.b(arrayList, hVar);
            }
            com.baidu.tieba.person.h hVar2 = new com.baidu.tieba.person.h(g2, g);
            com.baidu.tbadk.core.util.x.a((List<com.baidu.tieba.person.h>) arrayList, 0, hVar2);
            com.baidu.tbadk.core.util.x.b(arrayList, hVar2);
            return arrayList;
        }
        return list;
    }
}
