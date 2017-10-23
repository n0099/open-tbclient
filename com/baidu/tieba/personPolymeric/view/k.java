package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.n> {
    private HTypeListView aZT;
    private TextView aaS;
    private com.baidu.tieba.personPolymeric.a.p fhP;
    private View.OnClickListener fhX;
    private View mRootView;
    private long uid;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fhX = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.aWZ();
            }
        };
        this.mRootView = getView();
        this.aaS = (TextView) this.mRootView.findViewById(d.h.card_person_vedio_list_title);
        this.aZT = (HTypeListView) this.mRootView.findViewById(d.h.card_person_vedio_view_pager);
        this.fhP = new com.baidu.tieba.personPolymeric.a.p(this.mTbPageContext, this.aZT);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            aj.k(this.mRootView, d.e.cp_bg_line_d);
            aj.i(this.aaS, d.e.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_person_vedio_list_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.n nVar) {
        if (nVar == null || v.u(nVar.fgX)) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.uid = nVar.uid;
        this.aaS.setText(d.l.msglist_video);
        this.aZT.setData(cH(nVar.fgX));
        this.fhP.L(this.fhX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWZ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.mContext).createNormalCfg(this.uid, "personal")));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.f> cH(List<com.baidu.adp.widget.ListView.f> list) {
        int t = v.t(list);
        if (t > 0) {
            List<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>(list);
            int f = com.baidu.adp.lib.util.l.f(this.mTbPageContext.getPageActivity(), d.f.ds490);
            int f2 = com.baidu.adp.lib.util.l.f(this.mTbPageContext.getPageActivity(), d.f.ds32);
            if (t > 3) {
                arrayList = arrayList.subList(0, 3);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.width = com.baidu.adp.lib.util.l.f(this.mTbPageContext.getPageActivity(), d.f.ds120);
                hVar.height = com.baidu.adp.lib.util.l.f(this.mTbPageContext.getPageActivity(), d.f.ds396);
                v.b((List<com.baidu.tieba.personPolymeric.c.h>) arrayList, hVar);
            }
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(f2, f);
            v.a((List<com.baidu.tieba.person.d>) arrayList, 0, dVar);
            v.b((List<com.baidu.tieba.person.d>) arrayList, dVar);
            return arrayList;
        }
        return list;
    }
}
