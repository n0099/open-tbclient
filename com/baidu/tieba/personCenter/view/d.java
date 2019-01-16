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
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> ayi;
    private LinearLayout gwu;
    private AutoBannerView gwv;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ayi = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.d.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void i(int i, String str) {
                if (d.this.gwv != null && str != null) {
                    if (d.this.gwv.checkIndex(i)) {
                        TiebaStatic.log(new am("c13247").y("obj_locate", i).aB("obj_param1", str));
                    }
                    d.this.gwv.FS();
                    d.this.gwv.pk(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (d.this.gwv != null && aVar != null && aVar.aJF() != null && d.this.gwv.checkIndex(i)) {
                    TiebaStatic.log(new am("c13246").aB("uid", TbadkCoreApplication.getCurrentAccount()).y("obj_locate", i).aB("obj_param1", aVar.aJF()));
                }
            }
        };
        this.gwu = (LinearLayout) getView().findViewById(e.g.viewpager);
        this.gwv = new AutoBannerView(this.mTbPageContext.getPageActivity());
        this.gwv.setMarqueenTime(3000L);
        this.gwv.getCoverFlowView().setCallback(this.ayi);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.gwv != null) {
                this.gwv.onChangeSkinType(i);
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
        if (this.gwu != null && iVar != null && iVar.gvC != null && this.gwv != null && this.gwu.getChildCount() != 1 && iVar.gvC.size() != 0) {
            this.gwv.bX(iVar.gvC);
            this.gwu.addView(this.gwv);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.gwv != null) {
            this.gwv.FS();
        }
    }
}
