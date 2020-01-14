package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.data.m;
/* loaded from: classes7.dex */
public class e extends com.baidu.tieba.card.a<m> {
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a> cSj;
    private LinearLayout jhF;
    private AutoBannerView jhG;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cSj = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.personCenter.data.a>() { // from class: com.baidu.tieba.personCenter.view.e.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void O(int i, String str) {
                if (e.this.jhG != null && str != null) {
                    if (e.this.jhG.checkIndex(i)) {
                        TiebaStatic.log(new an("c13247").Z("obj_locate", i).cp("obj_param1", str));
                    }
                    e.this.jhG.aGj();
                    e.this.jhG.Gs(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.personCenter.data.a aVar) {
                if (e.this.jhG != null && aVar != null && aVar.ctM() != null && e.this.jhG.checkIndex(i)) {
                    TiebaStatic.log(new an("c13246").cp("uid", TbadkCoreApplication.getCurrentAccount()).Z("obj_locate", i).cp("obj_param1", aVar.ctM()));
                }
            }
        };
        View view = getView();
        this.jhF = (LinearLayout) view.findViewById(R.id.viewpager);
        this.jhG = (AutoBannerView) view.findViewById(R.id.person_center_auto_banner_view);
        this.jhG.setMarqueenTime(3000L);
        this.jhG.getCoverFlowView().setCallback(this.cSj);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            if (this.jhG != null) {
                this.jhG.onChangeSkinType(i);
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
        if (this.jhF != null && mVar != null && mVar.jgu != null && this.jhG != null && mVar.jgu.size() != 0) {
            this.jhG.dS(mVar.jgu);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        if (this.jhG != null) {
            this.jhG.aGj();
        }
    }
}
