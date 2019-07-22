package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.data.m;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.a<m> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> bOH;
    private LinearLayout ilg;
    private AutoBannerView ilh;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bOH = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void B(int i, String str) {
                if (e.this.ilh != null && str != null) {
                    if (e.this.ilh.checkIndex(i)) {
                        TiebaStatic.log(new an("c13247").P("obj_locate", i).bT("obj_param1", str));
                    }
                    e.this.ilh.aln();
                    e.this.ilh.yc(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (e.this.ilh != null && aVar != null && aVar.cbf() != null && e.this.ilh.checkIndex(i)) {
                    TiebaStatic.log(new an("c13246").bT("uid", TbadkCoreApplication.getCurrentAccount()).P("obj_locate", i).bT("obj_param1", aVar.cbf()));
                }
            }
        };
        View view = getView();
        this.ilg = (LinearLayout) view.findViewById(R.id.viewpager);
        this.ilh = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.ilh.setMarqueenTime(3000L);
        this.ilh.getCoverFlowView().setCallback(this.bOH);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.ilh != null) {
                this.ilh.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.person_center_viewpager_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(m mVar) {
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.ilg != null && mVar != null && mVar.ijX != null && this.ilh != null && mVar.ijX.size() != 0) {
            this.ilh.cD(mVar.ijX);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.ilh != null) {
            this.ilh.aln();
        }
    }
}
