package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.n;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.b<n> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a> eZB;
    private int mSkinType;
    private LinearLayout mqD;
    private AutoBannerView mqE;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eZB = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i, String str) {
                if (e.this.mqE != null && str != null) {
                    if (e.this.mqE.checkIndex(i)) {
                        TiebaStatic.log(new aq("c13247").an("obj_locate", i).dX("obj_param1", str));
                    }
                    e.this.mqE.byV();
                    e.this.mqE.dj(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.c.a aVar) {
                if (e.this.mqE != null && aVar != null && aVar.bpl() != null && e.this.mqE.checkIndex(i)) {
                    TiebaStatic.log(new aq("c13246").dX("uid", TbadkCoreApplication.getCurrentAccount()).an("obj_locate", i).dX("obj_param1", aVar.bpl()));
                }
            }
        };
        View view = getView();
        this.mqD = (LinearLayout) view.findViewById(R.id.viewpager);
        this.mqE = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.mqE.setMarqueenTime(IMConnection.RETRY_DELAY_TIMES);
        this.mqE.getCoverFlowView().setCallback(this.eZB);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.mqE != null) {
                this.mqE.onChangeSkinType(i);
            }
            ao.setBackgroundColor(getView(), R.color.CAM_X0205);
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
        if (this.mqD != null && nVar != null && nVar.mpl != null && this.mqE != null && nVar.mpl.size() != 0) {
            this.mqE.r(nVar.mpl);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        if (this.mqE != null) {
            this.mqE.byV();
        }
    }
}
