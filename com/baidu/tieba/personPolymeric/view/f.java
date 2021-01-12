package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.h> {
    private TbImageView fcv;
    private View mRootView;
    private View mvF;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.fcv = (TbImageView) this.mRootView.findViewById(R.id.center_image);
        this.mvF = this.mRootView.findViewById(R.id.more_view_container);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setImageResource(this.fcv, R.drawable.icon_mine_more);
            ao.setBackgroundResource(this.mRootView, R.drawable.btn_look_more_selector);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_more_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.personPolymeric.c.h hVar) {
        if (hVar == null) {
            this.mRootView.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.mvF.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams.width > 0) {
                layoutParams.width = hVar.width;
            }
            if (layoutParams.height > 0) {
                layoutParams.height = hVar.height;
            }
        }
        this.mvF.setLayoutParams(layoutParams);
        this.mRootView.setVisibility(0);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
