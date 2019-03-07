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
    private LinearLayout hMK;
    private AutoBannerView hML;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bGb = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.d.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void y(int i, String str) {
                if (d.this.hML != null && str != null) {
                    if (d.this.hML.checkIndex(i)) {
                        TiebaStatic.log(new am("c13247").T("obj_locate", i).bJ("obj_param1", str));
                    }
                    d.this.hML.afm();
                    d.this.hML.wi(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (d.this.hML != null && aVar != null && aVar.bQu() != null && d.this.hML.checkIndex(i)) {
                    TiebaStatic.log(new am("c13246").bJ("uid", TbadkCoreApplication.getCurrentAccount()).T("obj_locate", i).bJ("obj_param1", aVar.bQu()));
                }
            }
        };
        this.hMK = (LinearLayout) getView().findViewById(d.g.viewpager);
        this.hML = new AutoBannerView(this.mTbPageContext.getPageActivity());
        this.hML.setMarqueenTime(3000L);
        this.hML.getCoverFlowView().setCallback(this.bGb);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.hML != null) {
                this.hML.onChangeSkinType(i);
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
        if (this.hMK != null && iVar != null && iVar.hLT != null && this.hML != null && this.hMK.getChildCount() != 1 && iVar.hLT.size() != 0) {
            this.hML.cx(iVar.hLT);
            this.hMK.addView(this.hML);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.hML != null) {
            this.hML.afm();
        }
    }
}
