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
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a> evd;
    private LinearLayout lEA;
    private AutoBannerView lEB;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.evd = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i, String str) {
                if (e.this.lEB != null && str != null) {
                    if (e.this.lEB.checkIndex(i)) {
                        TiebaStatic.log(new aq("c13247").aj("obj_locate", i).dK("obj_param1", str));
                    }
                    e.this.lEB.bpt();
                    e.this.lEB.dl(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.c.a aVar) {
                if (e.this.lEB != null && aVar != null && aVar.bge() != null && e.this.lEB.checkIndex(i)) {
                    TiebaStatic.log(new aq("c13246").dK("uid", TbadkCoreApplication.getCurrentAccount()).aj("obj_locate", i).dK("obj_param1", aVar.bge()));
                }
            }
        };
        View view = getView();
        this.lEA = (LinearLayout) view.findViewById(R.id.viewpager);
        this.lEB = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.lEB.setMarqueenTime(IMConnection.RETRY_DELAY_TIMES);
        this.lEB.getCoverFlowView().setCallback(this.evd);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.lEB != null) {
                this.lEB.onChangeSkinType(i);
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
        if (this.lEA != null && nVar != null && nVar.lDi != null && this.lEB != null && nVar.lDi.size() != 0) {
            this.lEB.r(nVar.lDi);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        if (this.lEB != null) {
            this.lEB.bpt();
        }
    }
}
