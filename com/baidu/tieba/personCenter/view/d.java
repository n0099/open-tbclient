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
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> bGf;
    private LinearLayout hMr;
    private AutoBannerView hMs;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bGf = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.d.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void y(int i, String str) {
                if (d.this.hMs != null && str != null) {
                    if (d.this.hMs.checkIndex(i)) {
                        TiebaStatic.log(new am("c13247").T("obj_locate", i).bJ("obj_param1", str));
                    }
                    d.this.hMs.afj();
                    d.this.hMs.wg(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (d.this.hMs != null && aVar != null && aVar.bQt() != null && d.this.hMs.checkIndex(i)) {
                    TiebaStatic.log(new am("c13246").bJ("uid", TbadkCoreApplication.getCurrentAccount()).T("obj_locate", i).bJ("obj_param1", aVar.bQt()));
                }
            }
        };
        this.hMr = (LinearLayout) getView().findViewById(d.g.viewpager);
        this.hMs = new AutoBannerView(this.mTbPageContext.getPageActivity());
        this.hMs.setMarqueenTime(3000L);
        this.hMs.getCoverFlowView().setCallback(this.bGf);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.hMs != null) {
                this.hMs.onChangeSkinType(i);
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
        if (this.hMr != null && iVar != null && iVar.hLA != null && this.hMs != null && this.hMr.getChildCount() != 1 && iVar.hLA.size() != 0) {
            this.hMs.cu(iVar.hLA);
            this.hMr.addView(this.hMs);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.hMs != null) {
            this.hMs.afj();
        }
    }
}
