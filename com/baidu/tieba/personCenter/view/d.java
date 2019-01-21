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
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> ayj;
    private LinearLayout gwv;
    private AutoBannerView gww;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ayj = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.d.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void i(int i, String str) {
                if (d.this.gww != null && str != null) {
                    if (d.this.gww.checkIndex(i)) {
                        TiebaStatic.log(new am("c13247").y("obj_locate", i).aB("obj_param1", str));
                    }
                    d.this.gww.FS();
                    d.this.gww.pk(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (d.this.gww != null && aVar != null && aVar.aJF() != null && d.this.gww.checkIndex(i)) {
                    TiebaStatic.log(new am("c13246").aB("uid", TbadkCoreApplication.getCurrentAccount()).y("obj_locate", i).aB("obj_param1", aVar.aJF()));
                }
            }
        };
        this.gwv = (LinearLayout) getView().findViewById(e.g.viewpager);
        this.gww = new AutoBannerView(this.mTbPageContext.getPageActivity());
        this.gww.setMarqueenTime(3000L);
        this.gww.getCoverFlowView().setCallback(this.ayj);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.gww != null) {
                this.gww.onChangeSkinType(i);
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
        if (this.gwv != null && iVar != null && iVar.gvD != null && this.gww != null && this.gwv.getChildCount() != 1 && iVar.gvD.size() != 0) {
            this.gww.bX(iVar.gvD);
            this.gwv.addView(this.gww);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.gww != null) {
            this.gww.FS();
        }
    }
}
