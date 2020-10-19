package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class h extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View fZd;
    private com.baidu.tieba.personPolymeric.b.c lIF;
    private TextView lOc;
    private TextView lOd;
    private ImageView lOe;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_privacy_setting_rootview);
        this.fZd = view.findViewById(R.id.top_divider_line);
        this.lOe = (ImageView) view.findViewById(R.id.lock_img);
        this.lOc = (TextView) view.findViewById(R.id.one_public_tv);
        this.lOd = (TextView) view.findViewById(R.id.card_hint_txt);
        this.lOc.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.fZd, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.lOd, R.color.cp_cont_d, 1);
            ap.setImageResource(this.lOe, R.drawable.pic_pop_key);
            ap.setViewTextColor(this.lOc, R.color.cp_link_tip_c, 1);
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
        if (this.fZd != null) {
            if (jVar.hJT) {
                this.fZd.setVisibility(8);
            } else {
                this.fZd.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.c cVar) {
        this.lIF = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.lIF != null && view == this.lOc) {
            this.lIF.dpq();
        }
    }
}
