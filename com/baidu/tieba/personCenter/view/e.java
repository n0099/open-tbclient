package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.m;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.a<m> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a> cWm;
    private LinearLayout jiB;
    private AutoBannerView jiC;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cWm = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void Q(int i, String str) {
                if (e.this.jiC != null && str != null) {
                    if (e.this.jiC.checkIndex(i)) {
                        TiebaStatic.log(new an("c13247").X("obj_locate", i).cy("obj_param1", str));
                    }
                    e.this.jiC.aIA();
                    e.this.jiC.GG(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.c.a aVar) {
                if (e.this.jiC != null && aVar != null && aVar.cvh() != null && e.this.jiC.checkIndex(i)) {
                    TiebaStatic.log(new an("c13246").cy("uid", TbadkCoreApplication.getCurrentAccount()).X("obj_locate", i).cy("obj_param1", aVar.cvh()));
                }
            }
        };
        View view = getView();
        this.jiB = (LinearLayout) view.findViewById(R.id.viewpager);
        this.jiC = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.jiC.setMarqueenTime(3000L);
        this.jiC.getCoverFlowView().setCallback(this.cWm);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.jiC != null) {
                this.jiC.onChangeSkinType(i);
            }
            am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
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
        if (this.jiB != null && mVar != null && mVar.jhp != null && this.jiC != null && mVar.jhp.size() != 0) {
            this.jiC.dO(mVar.jhp);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.jiC != null) {
            this.jiC.aIA();
        }
    }
}
