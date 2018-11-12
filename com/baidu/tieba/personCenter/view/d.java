package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import com.baidu.tieba.personCenter.data.i;
/* loaded from: classes5.dex */
public class d extends com.baidu.tieba.card.a<i> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> auf;
    private LinearLayout glJ;
    private AutoBannerView glK;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.auf = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.d.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void g(int i, String str) {
                if (d.this.glK != null && str != null) {
                    if (d.this.glK.checkIndex(i)) {
                        TiebaStatic.log(new am("c13247").x("obj_locate", i).ax("obj_param1", str));
                    }
                    d.this.glK.EA();
                    d.this.glK.os(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (d.this.glK != null && aVar != null && aVar.aGG() != null && d.this.glK.checkIndex(i)) {
                    TiebaStatic.log(new am("c13246").ax("uid", TbadkCoreApplication.getCurrentAccount()).x("obj_locate", i).ax("obj_param1", aVar.aGG()));
                }
            }
        };
        this.glJ = (LinearLayout) getView().findViewById(e.g.viewpager);
        this.glK = new AutoBannerView(this.mTbPageContext.getPageActivity());
        this.glK.setMarqueenTime(3000L);
        this.glK.getCoverFlowView().setCallback(this.auf);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.glK != null) {
                this.glK.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.person_center_viewpager_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(i iVar) {
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.glJ != null && iVar != null && iVar.gkR != null && this.glK != null && this.glJ.getChildCount() != 1 && iVar.gkR.size() != 0) {
            this.glK.bT(iVar.gkR);
            this.glJ.addView(this.glK);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.glK != null) {
            this.glK.EA();
        }
    }
}
