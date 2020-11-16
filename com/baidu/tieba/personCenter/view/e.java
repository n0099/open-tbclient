package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.n;
/* loaded from: classes21.dex */
public class e extends com.baidu.tieba.card.b<n> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a> eIr;
    private LinearLayout lXk;
    private AutoBannerView lXl;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eIr = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.c.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i, String str) {
                if (e.this.lXl != null && str != null) {
                    if (e.this.lXl.checkIndex(i)) {
                        TiebaStatic.log(new ar("c13247").ak("obj_locate", i).dR("obj_param1", str));
                    }
                    e.this.lXl.btc();
                    e.this.lXl.dn(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.c.a aVar) {
                if (e.this.lXl != null && aVar != null && aVar.bjz() != null && e.this.lXl.checkIndex(i)) {
                    TiebaStatic.log(new ar("c13246").dR("uid", TbadkCoreApplication.getCurrentAccount()).ak("obj_locate", i).dR("obj_param1", aVar.bjz()));
                }
            }
        };
        View view = getView();
        this.lXk = (LinearLayout) view.findViewById(R.id.viewpager);
        this.lXl = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.lXl.setMarqueenTime(IMConnection.RETRY_DELAY_TIMES);
        this.lXl.getCoverFlowView().setCallback(this.eIr);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.lXl != null) {
                this.lXl.onChangeSkinType(i);
            }
            ap.setBackgroundColor(getView(), R.color.CAM_X0205);
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
        if (this.lXk != null && nVar != null && nVar.lVT != null && this.lXl != null && nVar.lVT.size() != 0) {
            this.lXl.r(nVar.lVT);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        if (this.lXl != null) {
            this.lXl.btc();
        }
    }
}
