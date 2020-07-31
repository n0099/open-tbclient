package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class j extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.m> {
    private HTypeListView kNB;
    private com.baidu.tieba.personPolymeric.a.o kZn;
    private View.OnClickListener kZv;
    private View mRootView;
    private TextView mTitleView;
    private long uid;

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.kZv = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.cYi();
            }
        };
        this.currentPageType = 4;
        this.mRootView = getView();
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.card_person_vedio_list_title);
        this.kNB = (HTypeListView) this.mRootView.findViewById(R.id.card_person_vedio_view_pager);
        this.kZn = new com.baidu.tieba.personPolymeric.a.o(this.mTbPageContext, this.kNB);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            ao.setViewTextColor(this.mTitleView, R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_person_vedio_list_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.personPolymeric.c.m mVar) {
        if (mVar == null || x.isEmpty(mVar.kWU)) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.uid = mVar.uid;
        this.mTitleView.setText(R.string.video_title_str);
        this.kNB.setData(eK(mVar.kWU));
        this.kZn.Z(this.kZv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYi() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.mContext).createNormalCfg(this.uid, "personal")));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<q> eK(List<q> list) {
        int count = x.getCount(list);
        if (count > 0) {
            List<q> arrayList = new ArrayList<>(list);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.ds490);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.ds32);
            if (count > 3) {
                arrayList = arrayList.subList(0, 3);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.width = com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.ds120);
                hVar.height = com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.ds396);
                x.add(arrayList, hVar);
            }
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(dimens2, dimens);
            x.add(arrayList, 0, dVar);
            x.add(arrayList, dVar);
            return arrayList;
        }
        return list;
    }
}
