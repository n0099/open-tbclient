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
public class e extends com.baidu.tieba.card.b<m> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a> dJT;
    private LinearLayout knC;
    private AutoBannerView knD;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dJT = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void am(int i, String str) {
                if (e.this.knD != null && str != null) {
                    if (e.this.knD.checkIndex(i)) {
                        TiebaStatic.log(new an("c13247").ag("obj_locate", i).dh("obj_param1", str));
                    }
                    e.this.knD.aXg();
                    e.this.knD.Ke(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.c.a aVar) {
                if (e.this.knD != null && aVar != null && aVar.cNy() != null && e.this.knD.checkIndex(i)) {
                    TiebaStatic.log(new an("c13246").dh("uid", TbadkCoreApplication.getCurrentAccount()).ag("obj_locate", i).dh("obj_param1", aVar.cNy()));
                }
            }
        };
        View view = getView();
        this.knC = (LinearLayout) view.findViewById(R.id.viewpager);
        this.knD = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.knD.setMarqueenTime(3000L);
        this.knD.getCoverFlowView().setCallback(this.dJT);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.knD != null) {
                this.knD.onChangeSkinType(i);
            }
            am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_center_viewpager_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(m mVar) {
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.knC != null && mVar != null && mVar.kmn != null && this.knD != null && mVar.kmn.size() != 0) {
            this.knD.eh(mVar.kmn);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        if (this.knD != null) {
            this.knD.aXg();
        }
    }
}
