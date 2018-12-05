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
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> axF;
    private AutoBannerView gsA;
    private LinearLayout gsz;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.axF = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.d.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void g(int i, String str) {
                if (d.this.gsA != null && str != null) {
                    if (d.this.gsA.checkIndex(i)) {
                        TiebaStatic.log(new am("c13247").x("obj_locate", i).aA("obj_param1", str));
                    }
                    d.this.gsA.FE();
                    d.this.gsA.oR(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (d.this.gsA != null && aVar != null && aVar.aIs() != null && d.this.gsA.checkIndex(i)) {
                    TiebaStatic.log(new am("c13246").aA("uid", TbadkCoreApplication.getCurrentAccount()).x("obj_locate", i).aA("obj_param1", aVar.aIs()));
                }
            }
        };
        this.gsz = (LinearLayout) getView().findViewById(e.g.viewpager);
        this.gsA = new AutoBannerView(this.mTbPageContext.getPageActivity());
        this.gsA.setMarqueenTime(3000L);
        this.gsA.getCoverFlowView().setCallback(this.axF);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.gsA != null) {
                this.gsA.onChangeSkinType(i);
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
        if (this.gsz != null && iVar != null && iVar.grH != null && this.gsA != null && this.gsz.getChildCount() != 1 && iVar.grH.size() != 0) {
            this.gsA.bV(iVar.grH);
            this.gsz.addView(this.gsA);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.gsA != null) {
            this.gsA.FE();
        }
    }
}
