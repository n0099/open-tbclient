package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.n;
/* loaded from: classes22.dex */
public class e extends com.baidu.tieba.card.b<n> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a> eDC;
    private LinearLayout lQW;
    private AutoBannerView lQX;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eDC = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i, String str) {
                if (e.this.lQX != null && str != null) {
                    if (e.this.lQX.checkIndex(i)) {
                        TiebaStatic.log(new aq("c13247").aj("obj_locate", i).dR("obj_param1", str));
                    }
                    e.this.lQX.brm();
                    e.this.lQX.dl(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.c.a aVar) {
                if (e.this.lQX != null && aVar != null && aVar.bhX() != null && e.this.lQX.checkIndex(i)) {
                    TiebaStatic.log(new aq("c13246").dR("uid", TbadkCoreApplication.getCurrentAccount()).aj("obj_locate", i).dR("obj_param1", aVar.bhX()));
                }
            }
        };
        View view = getView();
        this.lQW = (LinearLayout) view.findViewById(R.id.viewpager);
        this.lQX = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.lQX.setMarqueenTime(IMConnection.RETRY_DELAY_TIMES);
        this.lQX.getCoverFlowView().setCallback(this.eDC);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.lQX != null) {
                this.lQX.onChangeSkinType(i);
            }
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
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
        if (this.lQW != null && nVar != null && nVar.lPF != null && this.lQX != null && nVar.lPF.size() != 0) {
            this.lQX.r(nVar.lPF);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        if (this.lQX != null) {
            this.lQX.brm();
        }
    }
}
