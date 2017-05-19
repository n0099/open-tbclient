package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.g> {
    private TbImageView dvu;
    private View eEA;
    private View mRootView;

    public j(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.dvu = (TbImageView) this.mRootView.findViewById(w.h.center_image);
        this.eEA = this.mRootView.findViewById(w.h.more_view_container);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aq.c(this.dvu, w.g.icon_mine_more);
            aq.j(this.mRootView, w.g.btn_look_more_selector);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_more_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.g gVar) {
        if (gVar == null) {
            this.mRootView.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.eEA.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams.width > 0) {
                layoutParams.width = gVar.width;
            }
            if (layoutParams.height > 0) {
                layoutParams.height = gVar.height;
            }
        }
        this.eEA.setLayoutParams(layoutParams);
        this.mRootView.setVisibility(0);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
