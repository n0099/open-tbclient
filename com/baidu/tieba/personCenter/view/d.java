package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.i;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.a<i> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> bGb;
    private LinearLayout hML;
    private AutoBannerView hMM;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bGb = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.d.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void y(int i, String str) {
                if (d.this.hMM != null && str != null) {
                    if (d.this.hMM.checkIndex(i)) {
                        TiebaStatic.log(new am("c13247").T("obj_locate", i).bJ("obj_param1", str));
                    }
                    d.this.hMM.afm();
                    d.this.hMM.wj(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (d.this.hMM != null && aVar != null && aVar.bQv() != null && d.this.hMM.checkIndex(i)) {
                    TiebaStatic.log(new am("c13246").bJ("uid", TbadkCoreApplication.getCurrentAccount()).T("obj_locate", i).bJ("obj_param1", aVar.bQv()));
                }
            }
        };
        this.hML = (LinearLayout) getView().findViewById(d.g.viewpager);
        this.hMM = new AutoBannerView(this.mTbPageContext.getPageActivity());
        this.hMM.setMarqueenTime(3000L);
        this.hMM.getCoverFlowView().setCallback(this.bGb);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.hMM != null) {
                this.hMM.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.person_center_viewpager_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(i iVar) {
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.hML != null && iVar != null && iVar.hLU != null && this.hMM != null && this.hML.getChildCount() != 1 && iVar.hLU.size() != 0) {
            this.hMM.cx(iVar.hLU);
            this.hML.addView(this.hMM);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.hMM != null) {
            this.hMM.afm();
        }
    }
}
