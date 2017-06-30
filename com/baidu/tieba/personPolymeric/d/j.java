package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.h> {
    private TbImageView dJg;
    private View eXy;
    private View mRootView;

    public j(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.dJg = (TbImageView) this.mRootView.findViewById(w.h.center_image);
        this.eXy = this.mRootView.findViewById(w.h.more_view_container);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            as.c(this.dJg, w.g.icon_mine_more);
            as.j(this.mRootView, w.g.btn_look_more_selector);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_more_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.h hVar) {
        if (hVar == null) {
            this.mRootView.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.eXy.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams.width > 0) {
                layoutParams.width = hVar.width;
            }
            if (layoutParams.height > 0) {
                layoutParams.height = hVar.height;
            }
        }
        this.eXy.setLayoutParams(layoutParams);
        this.mRootView.setVisibility(0);
        d(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
