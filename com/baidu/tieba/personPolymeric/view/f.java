package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.h> {
    private TbImageView alA;
    private View gci;
    private View mRootView;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.alA = (TbImageView) this.mRootView.findViewById(f.g.center_image);
        this.gci = this.mRootView.findViewById(f.g.more_view_container);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.c(this.alA, f.C0146f.icon_mine_more);
            am.i(this.mRootView, f.C0146f.btn_look_more_selector);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_more_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.h hVar) {
        if (hVar == null) {
            this.mRootView.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.gci.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams.width > 0) {
                layoutParams.width = hVar.width;
            }
            if (layoutParams.height > 0) {
                layoutParams.height = hVar.height;
            }
        }
        this.gci.setLayoutParams(layoutParams);
        this.mRootView.setVisibility(0);
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
