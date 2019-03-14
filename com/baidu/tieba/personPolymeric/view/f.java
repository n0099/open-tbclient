package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.h> {
    private TbImageView bNU;
    private View hTk;
    private View mRootView;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.bNU = (TbImageView) this.mRootView.findViewById(d.g.center_image);
        this.hTk = this.mRootView.findViewById(d.g.more_view_container);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.c(this.bNU, d.f.icon_mine_more);
            al.k(this.mRootView, d.f.btn_look_more_selector);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_more_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.h hVar) {
        if (hVar == null) {
            this.mRootView.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.hTk.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams.width > 0) {
                layoutParams.width = hVar.width;
            }
            if (layoutParams.height > 0) {
                layoutParams.height = hVar.height;
            }
        }
        this.hTk.setLayoutParams(layoutParams);
        this.mRootView.setVisibility(0);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
