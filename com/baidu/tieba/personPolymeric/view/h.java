package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View erk;
    private com.baidu.tieba.personPolymeric.b.b joe;
    private TextView jti;
    private TextView jtj;
    private ImageView jtk;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_privacy_setting_rootview);
        this.erk = view.findViewById(R.id.top_divider_line);
        this.jtk = (ImageView) view.findViewById(R.id.lock_img);
        this.jti = (TextView) view.findViewById(R.id.one_public_tv);
        this.jtj = (TextView) view.findViewById(R.id.card_hint_txt);
        this.jti.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setBackgroundResource(this.erk, R.color.cp_bg_line_e);
            am.setViewTextColor(this.jtj, R.color.cp_cont_d, 1);
            am.setImageResource(this.jtk, R.drawable.pic_pop_key);
            am.setViewTextColor(this.jti, R.color.cp_link_tip_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_privacy_setting_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.j jVar) {
        if (jVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        if (this.erk != null) {
            if (jVar.fOM) {
                this.erk.setVisibility(8);
            } else {
                this.erk.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.b bVar) {
        this.joe = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.joe != null && view == this.jti) {
            this.joe.cwW();
        }
    }
}
