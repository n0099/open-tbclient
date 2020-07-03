package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.n;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.b<n> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a> dQJ;
    private LinearLayout kHt;
    private AutoBannerView kHu;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dQJ = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i, String str) {
                if (e.this.kHu != null && str != null) {
                    if (e.this.kHu.checkIndex(i)) {
                        TiebaStatic.log(new ao("c13247").ag("obj_locate", i).dk("obj_param1", str));
                    }
                    e.this.kHu.aZm();
                    e.this.kHu.cZ(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.c.a aVar) {
                if (e.this.kHu != null && aVar != null && aVar.aQm() != null && e.this.kHu.checkIndex(i)) {
                    TiebaStatic.log(new ao("c13246").dk("uid", TbadkCoreApplication.getCurrentAccount()).ag("obj_locate", i).dk("obj_param1", aVar.aQm()));
                }
            }
        };
        View view = getView();
        this.kHt = (LinearLayout) view.findViewById(R.id.viewpager);
        this.kHu = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.kHu.setMarqueenTime(3000L);
        this.kHu.getCoverFlowView().setCallback(this.dQJ);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.kHu != null) {
                this.kHu.onChangeSkinType(i);
            }
            an.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_center_viewpager_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(n nVar) {
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.kHt != null && nVar != null && nVar.kFZ != null && this.kHu != null && nVar.kFZ.size() != 0) {
            this.kHu.q(nVar.kFZ);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        if (this.kHu != null) {
            this.kHu.aZm();
        }
    }
}
