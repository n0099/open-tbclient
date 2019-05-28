package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class j extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.m> {
    private HTypeListView cWn;
    private com.baidu.tieba.personPolymeric.a.o ilJ;
    private View.OnClickListener ilQ;
    private View mRootView;
    private TextView mTitleView;
    private long uid;

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ilQ = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.cat();
            }
        };
        this.currentPageType = 4;
        this.mRootView = getView();
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.card_person_vedio_list_title);
        this.cWn = (HTypeListView) this.mRootView.findViewById(R.id.card_person_vedio_view_pager);
        this.ilJ = new com.baidu.tieba.personPolymeric.a.o(this.mTbPageContext, this.cWn);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.l(this.mRootView, R.color.cp_bg_line_d);
            al.j(this.mTitleView, R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_person_vedio_list_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.m mVar) {
        if (mVar == null || v.aa(mVar.ikO)) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.uid = mVar.uid;
        this.mTitleView.setText(R.string.video_title_str);
        this.cWn.setData(dT(mVar.ikO));
        this.ilJ.V(this.ilQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cat() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoListActivityConfig(this.mContext).createNormalCfg(this.uid, "personal")));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.m> dT(List<com.baidu.adp.widget.ListView.m> list) {
        int Z = v.Z(list);
        if (Z > 0) {
            List<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>(list);
            int g = com.baidu.adp.lib.util.l.g(this.mTbPageContext.getPageActivity(), R.dimen.ds490);
            int g2 = com.baidu.adp.lib.util.l.g(this.mTbPageContext.getPageActivity(), R.dimen.ds32);
            if (Z > 3) {
                arrayList = arrayList.subList(0, 3);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.width = com.baidu.adp.lib.util.l.g(this.mTbPageContext.getPageActivity(), R.dimen.ds120);
                hVar.height = com.baidu.adp.lib.util.l.g(this.mTbPageContext.getPageActivity(), R.dimen.ds396);
                v.b(arrayList, hVar);
            }
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(g2, g);
            v.a((List<com.baidu.tieba.person.d>) arrayList, 0, dVar);
            v.b(arrayList, dVar);
            return arrayList;
        }
        return list;
    }
}
