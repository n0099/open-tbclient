package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.g> {
    private TbImageView bEA;
    private View eRP;
    private View mRootView;

    public j(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.bEA = (TbImageView) this.mRootView.findViewById(r.g.center_image);
        this.eRP = this.mRootView.findViewById(r.g.more_view_container);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            at.c(this.bEA, r.f.icon_mine_more);
            at.k(this.mRootView, r.f.btn_look_more_selector);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_more_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.g gVar) {
        if (gVar == null) {
            this.mRootView.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.eRP.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams.width > 0) {
                layoutParams.width = gVar.width;
            }
            if (layoutParams.height > 0) {
                layoutParams.height = gVar.height;
            }
        }
        this.eRP.setLayoutParams(layoutParams);
        this.mRootView.setVisibility(0);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
