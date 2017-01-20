package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.l> {
    private TextView Ve;
    private HTypeListView blB;
    private com.baidu.tieba.personPolymeric.a.t eFf;
    private View.OnClickListener eFj;
    private View mRootView;
    private long uid;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eFj = new o(this);
        this.mRootView = getView();
        this.Ve = (TextView) this.mRootView.findViewById(r.h.card_person_vedio_list_title);
        this.blB = (HTypeListView) this.mRootView.findViewById(r.h.card_person_vedio_view_pager);
        this.eFf = new com.baidu.tieba.personPolymeric.a.t(this.mTbPageContext, this.blB);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.k(this.mRootView, r.e.cp_bg_line_d);
            ap.i((View) this.Ve, r.e.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_person_vedio_list_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.l lVar) {
        if (lVar == null || com.baidu.tbadk.core.util.w.s(lVar.eEl)) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.uid = lVar.uid;
        this.Ve.setText(r.l.msglist_video);
        this.blB.setData(cD(lVar.eEl));
        this.eFf.O(this.eFj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRS() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.mContext).createNormalCfg(this.uid, "personal")));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.v> cD(List<com.baidu.adp.widget.ListView.v> list) {
        int r = com.baidu.tbadk.core.util.w.r(list);
        if (r > 0) {
            List<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>(list);
            int e = com.baidu.adp.lib.util.k.e(this.mTbPageContext.getPageActivity(), r.f.ds490);
            int e2 = com.baidu.adp.lib.util.k.e(this.mTbPageContext.getPageActivity(), r.f.ds32);
            if (r > 3) {
                arrayList = arrayList.subList(0, 3);
                com.baidu.tieba.personPolymeric.c.g gVar = new com.baidu.tieba.personPolymeric.c.g();
                gVar.width = com.baidu.adp.lib.util.k.e(this.mTbPageContext.getPageActivity(), r.f.ds120);
                gVar.height = com.baidu.adp.lib.util.k.e(this.mTbPageContext.getPageActivity(), r.f.ds396);
                com.baidu.tbadk.core.util.w.b(arrayList, gVar);
            }
            com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b(e2, e);
            com.baidu.tbadk.core.util.w.a((List<com.baidu.tieba.personCenter.c.b>) arrayList, 0, bVar);
            com.baidu.tbadk.core.util.w.b(arrayList, bVar);
            return arrayList;
        }
        return list;
    }
}
