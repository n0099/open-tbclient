package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class j extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.m> {
    private HTypeListView jeT;
    private View.OnClickListener jqD;
    private com.baidu.tieba.personPolymeric.a.o jqv;
    private View mRootView;
    private TextView mTitleView;
    private long uid;

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.jqD = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.cwm();
            }
        };
        this.currentPageType = 4;
        this.mRootView = getView();
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.card_person_vedio_list_title);
        this.jeT = (HTypeListView) this.mRootView.findViewById(R.id.card_person_vedio_view_pager);
        this.jqv = new com.baidu.tieba.personPolymeric.a.o(this.mTbPageContext, this.jeT);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_person_vedio_list_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.m mVar) {
        if (mVar == null || v.isEmpty(mVar.jod)) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.uid = mVar.uid;
        this.mTitleView.setText(R.string.video_title_str);
        this.jeT.setData(dZ(mVar.jod));
        this.jqv.X(this.jqD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwm() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.mContext).createNormalCfg(this.uid, "personal")));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.m> dZ(List<com.baidu.adp.widget.ListView.m> list) {
        int count = v.getCount(list);
        if (count > 0) {
            List<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>(list);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.ds490);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.ds32);
            if (count > 3) {
                arrayList = arrayList.subList(0, 3);
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.width = com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.ds120);
                hVar.height = com.baidu.adp.lib.util.l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.ds396);
                v.add(arrayList, hVar);
            }
            com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d(dimens2, dimens);
            v.add(arrayList, 0, dVar);
            v.add(arrayList, dVar);
            return arrayList;
        }
        return list;
    }
}
