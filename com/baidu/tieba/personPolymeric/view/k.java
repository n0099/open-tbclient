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
    private HTypeListView bat;
    private com.baidu.tieba.personPolymeric.a.p fqL;
    private View.OnClickListener fqT;
    private View mRootView;
    private TextView mTitleView;
    private long uid;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fqT = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.bao();
            }
        };
        this.mRootView = getView();
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.card_person_vedio_list_title);
        this.bat = (HTypeListView) this.mRootView.findViewById(d.g.card_person_vedio_view_pager);
        this.fqL = new com.baidu.tieba.personPolymeric.a.p(this.mTbPageContext, this.bat);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            aj.k(this.mRootView, d.C0080d.cp_bg_line_d);
            aj.i(this.mTitleView, d.C0080d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_person_vedio_list_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.n nVar) {
        if (nVar == null || v.v(nVar.fpT)) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.uid = nVar.uid;
        this.mTitleView.setText(d.j.video_title_str);
        this.bat.setData(cJ(nVar.fpT));
        this.fqL.M(this.fqT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bao() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.mContext).createNormalCfg(this.uid, "personal")));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.f> cJ(List<com.baidu.adp.widget.ListView.f> list) {
        int u = v.u(list);
        if (u > 0) {
            List<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>(list);
            int f = com.baidu.adp.lib.util.l.f(this.mTbPageContext.getPageActivity(), d.e.ds490);
            int f2 = com.baidu.adp.lib.util.l.f(this.mTbPageContext.getPageActivity(), d.e.ds32);
            if (u > 3) {
                arrayList = arrayList.subList(0, 3);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.width = com.baidu.adp.lib.util.l.f(this.mTbPageContext.getPageActivity(), d.e.ds120);
                hVar.height = com.baidu.adp.lib.util.l.f(this.mTbPageContext.getPageActivity(), d.e.ds396);
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
