package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class h extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View gFV;
    private TextView mEL;
    private TextView mEM;
    private ImageView mEN;
    private View mRootView;
    private com.baidu.tieba.personPolymeric.b.c mzh;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_privacy_setting_rootview);
        this.gFV = view.findViewById(R.id.top_divider_line);
        this.mEN = (ImageView) view.findViewById(R.id.lock_img);
        this.mEL = (TextView) view.findViewById(R.id.one_public_tv);
        this.mEM = (TextView) view.findViewById(R.id.card_hint_txt);
        this.mEL.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            ap.setBackgroundResource(this.gFV, R.color.CAM_X0205);
            ap.setViewTextColor(this.mEM, R.color.CAM_X0109, 1);
            ap.setImageResource(this.mEN, R.drawable.pic_pop_key);
            ap.setViewTextColor(this.mEL, R.color.CAM_X0304, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_privacy_setting_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.personPolymeric.c.j jVar) {
        if (jVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        if (this.gFV != null) {
            if (jVar.iBz) {
                this.gFV.setVisibility(8);
            } else {
                this.gFV.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.c cVar) {
        this.mzh = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.mzh != null && view == this.mEL) {
            this.mzh.dxZ();
        }
    }
}
