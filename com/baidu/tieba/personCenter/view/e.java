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
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> bON;
    private LinearLayout imk;
    private AutoBannerView iml;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bON = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void B(int i, String str) {
                if (e.this.iml != null && str != null) {
                    if (e.this.iml.checkIndex(i)) {
                        TiebaStatic.log(new an("c13247").P("obj_locate", i).bT("obj_param1", str));
                    }
                    e.this.iml.alp();
                    e.this.iml.yd(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (e.this.iml != null && aVar != null && aVar.cbx() != null && e.this.iml.checkIndex(i)) {
                    TiebaStatic.log(new an("c13246").bT("uid", TbadkCoreApplication.getCurrentAccount()).P("obj_locate", i).bT("obj_param1", aVar.cbx()));
                }
            }
        };
        View view = getView();
        this.imk = (LinearLayout) view.findViewById(R.id.viewpager);
        this.iml = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.iml.setMarqueenTime(3000L);
        this.iml.getCoverFlowView().setCallback(this.bON);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.iml != null) {
                this.iml.onChangeSkinType(i);
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
        if (this.imk != null && mVar != null && mVar.ikZ != null && this.iml != null && mVar.ikZ.size() != 0) {
            this.iml.cC(mVar.ikZ);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.iml != null) {
            this.iml.alp();
        }
    }
}
