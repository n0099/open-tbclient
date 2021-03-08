package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class h extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View gHS;
    private com.baidu.tieba.personPolymeric.b.c mBz;
    private TextView mHd;
    private TextView mHe;
    private ImageView mHf;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_privacy_setting_rootview);
        this.gHS = view.findViewById(R.id.top_divider_line);
        this.mHf = (ImageView) view.findViewById(R.id.lock_img);
        this.mHd = (TextView) view.findViewById(R.id.one_public_tv);
        this.mHe = (TextView) view.findViewById(R.id.card_hint_txt);
        this.mHd.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            ap.setBackgroundResource(this.gHS, R.color.CAM_X0205);
            ap.setViewTextColor(this.mHe, R.color.CAM_X0109, 1);
            ap.setImageResource(this.mHf, R.drawable.pic_pop_key);
            ap.setViewTextColor(this.mHd, R.color.CAM_X0304, 1);
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
        if (this.gHS != null) {
            if (jVar.iDw) {
                this.gHS.setVisibility(8);
            } else {
                this.gHS.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.c cVar) {
        this.mBz = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.mBz != null && view == this.mHd) {
            this.mBz.dyp();
        }
    }
}
