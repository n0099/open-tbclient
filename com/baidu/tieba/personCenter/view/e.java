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
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a> cWA;
    private LinearLayout jkm;
    private AutoBannerView jkn;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cWA = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void Q(int i, String str) {
                if (e.this.jkn != null && str != null) {
                    if (e.this.jkn.checkIndex(i)) {
                        TiebaStatic.log(new an("c13247").X("obj_locate", i).cx("obj_param1", str));
                    }
                    e.this.jkn.aIF();
                    e.this.jkn.GH(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.c.a aVar) {
                if (e.this.jkn != null && aVar != null && aVar.cvB() != null && e.this.jkn.checkIndex(i)) {
                    TiebaStatic.log(new an("c13246").cx("uid", TbadkCoreApplication.getCurrentAccount()).X("obj_locate", i).cx("obj_param1", aVar.cvB()));
                }
            }
        };
        View view = getView();
        this.jkm = (LinearLayout) view.findViewById(R.id.viewpager);
        this.jkn = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.jkn.setMarqueenTime(3000L);
        this.jkn.getCoverFlowView().setCallback(this.cWA);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.jkn != null) {
                this.jkn.onChangeSkinType(i);
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
        if (this.jkm != null && mVar != null && mVar.jjb != null && this.jkn != null && mVar.jjb.size() != 0) {
            this.jkn.dO(mVar.jjb);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.jkn != null) {
            this.jkn.aIF();
        }
    }
}
