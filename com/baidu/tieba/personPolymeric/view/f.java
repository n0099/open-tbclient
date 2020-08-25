package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.h> {
    private TbImageView eov;
    private View lpH;
    private View mRootView;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.eov = (TbImageView) this.mRootView.findViewById(R.id.center_image);
        this.lpH = this.mRootView.findViewById(R.id.more_view_container);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setImageResource(this.eov, R.drawable.icon_mine_more);
            ap.setBackgroundResource(this.mRootView, R.drawable.btn_look_more_selector);
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
        ViewGroup.LayoutParams layoutParams = this.lpH.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams.width > 0) {
                layoutParams.width = hVar.width;
            }
            if (layoutParams.height > 0) {
                layoutParams.height = hVar.height;
            }
        }
        this.lpH.setLayoutParams(layoutParams);
        this.mRootView.setVisibility(0);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
