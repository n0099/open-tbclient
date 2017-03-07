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
public class n extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.l> {
    private TextView aap;
    private HTypeListView bsu;
    private com.baidu.tieba.personPolymeric.a.t eIH;
    private View.OnClickListener eIL;
    private View mRootView;
    private long uid;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eIL = new o(this);
        this.mRootView = getView();
        this.aap = (TextView) this.mRootView.findViewById(w.h.card_person_vedio_list_title);
        this.bsu = (HTypeListView) this.mRootView.findViewById(w.h.card_person_vedio_view_pager);
        this.eIH = new com.baidu.tieba.personPolymeric.a.t(this.mTbPageContext, this.bsu);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            aq.k(this.mRootView, w.e.cp_bg_line_d);
            aq.i((View) this.aap, w.e.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_person_vedio_list_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.l lVar) {
        if (lVar == null || com.baidu.tbadk.core.util.x.q(lVar.eHN)) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.uid = lVar.uid;
        this.aap.setText(w.l.msglist_video);
        this.bsu.setData(ck(lVar.eHN));
        this.eIH.M(this.eIL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRv() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.mContext).createNormalCfg(this.uid, "personal")));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.v> ck(List<com.baidu.adp.widget.ListView.v> list) {
        int p = com.baidu.tbadk.core.util.x.p(list);
        if (p > 0) {
            List<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>(list);
            int g = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), w.f.ds490);
            int g2 = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), w.f.ds32);
            if (p > 3) {
                arrayList = arrayList.subList(0, 3);
                com.baidu.tieba.personPolymeric.c.g gVar = new com.baidu.tieba.personPolymeric.c.g();
                gVar.width = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), w.f.ds120);
                gVar.height = com.baidu.adp.lib.util.k.g(this.mTbPageContext.getPageActivity(), w.f.ds396);
                com.baidu.tbadk.core.util.x.b(arrayList, gVar);
            }
            com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b(g2, g);
            com.baidu.tbadk.core.util.x.a((List<com.baidu.tieba.personCenter.c.b>) arrayList, 0, bVar);
            com.baidu.tbadk.core.util.x.b(arrayList, bVar);
            return arrayList;
        }
        return list;
    }
}
