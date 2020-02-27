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
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a> cWl;
    private AutoBannerView jiA;
    private LinearLayout jiz;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cWl = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void Q(int i, String str) {
                if (e.this.jiA != null && str != null) {
                    if (e.this.jiA.checkIndex(i)) {
                        TiebaStatic.log(new an("c13247").X("obj_locate", i).cy("obj_param1", str));
                    }
                    e.this.jiA.aIy();
                    e.this.jiA.GG(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.c.a aVar) {
                if (e.this.jiA != null && aVar != null && aVar.cvf() != null && e.this.jiA.checkIndex(i)) {
                    TiebaStatic.log(new an("c13246").cy("uid", TbadkCoreApplication.getCurrentAccount()).X("obj_locate", i).cy("obj_param1", aVar.cvf()));
                }
            }
        };
        View view = getView();
        this.jiz = (LinearLayout) view.findViewById(R.id.viewpager);
        this.jiA = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.jiA.setMarqueenTime(3000L);
        this.jiA.getCoverFlowView().setCallback(this.cWl);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.jiA != null) {
                this.jiA.onChangeSkinType(i);
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
        if (this.jiz != null && mVar != null && mVar.jhn != null && this.jiA != null && mVar.jhn.size() != 0) {
            this.jiA.dO(mVar.jhn);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.jiA != null) {
            this.jiA.aIy();
        }
    }
}
