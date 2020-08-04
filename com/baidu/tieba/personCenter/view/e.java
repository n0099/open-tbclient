package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.n;
/* loaded from: classes16.dex */
public class e extends com.baidu.tieba.card.b<n> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a> dXb;
    private LinearLayout kQv;
    private AutoBannerView kQw;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dXb = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i, String str) {
                if (e.this.kQw != null && str != null) {
                    if (e.this.kQw.checkIndex(i)) {
                        TiebaStatic.log(new ap("c13247").ah("obj_locate", i).dn("obj_param1", str));
                    }
                    e.this.kQw.bdj();
                    e.this.kQw.cY(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.c.a aVar) {
                if (e.this.kQw != null && aVar != null && aVar.aUi() != null && e.this.kQw.checkIndex(i)) {
                    TiebaStatic.log(new ap("c13246").dn("uid", TbadkCoreApplication.getCurrentAccount()).ah("obj_locate", i).dn("obj_param1", aVar.aUi()));
                }
            }
        };
        View view = getView();
        this.kQv = (LinearLayout) view.findViewById(R.id.viewpager);
        this.kQw = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.kQw.setMarqueenTime(3000L);
        this.kQw.getCoverFlowView().setCallback(this.dXb);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.kQw != null) {
                this.kQw.onChangeSkinType(i);
            }
            ao.setBackgroundColor(getView(), R.color.cp_bg_line_e);
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
        if (this.kQv != null && nVar != null && nVar.kPc != null && this.kQw != null && nVar.kPc.size() != 0) {
            this.kQw.q(nVar.kPc);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        if (this.kQw != null) {
            this.kQw.bdj();
        }
    }
}
