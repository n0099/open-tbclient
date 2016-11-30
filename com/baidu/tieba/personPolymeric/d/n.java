package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.l> {
    private TextView Wu;
    private HTypeListView eKj;
    private com.baidu.tieba.personPolymeric.a.t eRM;
    private View.OnClickListener eRQ;
    private View mRootView;
    private long uid;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eRQ = new o(this);
        this.mRootView = getView();
        this.Wu = (TextView) this.mRootView.findViewById(r.g.card_person_vedio_list_title);
        this.eKj = (HTypeListView) this.mRootView.findViewById(r.g.card_person_vedio_view_pager);
        this.eRM = new com.baidu.tieba.personPolymeric.a.t(this.mTbPageContext, this.eKj);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            at.l(this.mRootView, r.d.cp_bg_line_d);
            at.j((View) this.Wu, r.d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_person_vedio_list_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.l lVar) {
        if (lVar == null || com.baidu.tbadk.core.util.x.t(lVar.eQR)) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.uid = lVar.uid;
        this.Wu.setText(r.j.person_polymeric_vedio_title);
        this.eKj.setData(cI(lVar.eQR));
        this.eRM.L(this.eRQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWk() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.mContext).createNormalCfg(this.uid, "personal")));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.v> cI(List<com.baidu.adp.widget.ListView.v> list) {
        int s = com.baidu.tbadk.core.util.x.s(list);
        if (s > 0) {
            List<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>(list);
            int e = com.baidu.adp.lib.util.k.e(this.mTbPageContext.getPageActivity(), r.e.ds490);
            int e2 = com.baidu.adp.lib.util.k.e(this.mTbPageContext.getPageActivity(), r.e.ds32);
            if (s > 3) {
                arrayList = arrayList.subList(0, 3);
                com.baidu.tieba.personPolymeric.c.g gVar = new com.baidu.tieba.personPolymeric.c.g();
                gVar.width = com.baidu.adp.lib.util.k.e(this.mTbPageContext.getPageActivity(), r.e.ds120);
                gVar.height = com.baidu.adp.lib.util.k.e(this.mTbPageContext.getPageActivity(), r.e.ds396);
                com.baidu.tbadk.core.util.x.b(arrayList, gVar);
            }
            com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b(e2, e);
            com.baidu.tbadk.core.util.x.a((List<com.baidu.tieba.personCenter.c.b>) arrayList, 0, bVar);
            com.baidu.tbadk.core.util.x.b(arrayList, bVar);
            return arrayList;
        }
        return list;
    }
}
