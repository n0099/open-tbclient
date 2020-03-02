package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View eqB;
    private com.baidu.tieba.personPolymeric.b.b jmt;
    private TextView jrx;
    private TextView jry;
    private ImageView jrz;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_privacy_setting_rootview);
        this.eqB = view.findViewById(R.id.top_divider_line);
        this.jrz = (ImageView) view.findViewById(R.id.lock_img);
        this.jrx = (TextView) view.findViewById(R.id.one_public_tv);
        this.jry = (TextView) view.findViewById(R.id.card_hint_txt);
        this.jrx.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setBackgroundResource(this.eqB, R.color.cp_bg_line_e);
            am.setViewTextColor(this.jry, R.color.cp_cont_d, 1);
            am.setImageResource(this.jrz, R.drawable.pic_pop_key);
            am.setViewTextColor(this.jrx, R.color.cp_link_tip_c, 1);
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
        if (this.eqB != null) {
            if (jVar.fNR) {
                this.eqB.setVisibility(8);
            } else {
                this.eqB.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.b bVar) {
        this.jmt = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.jmt != null && view == this.jrx) {
            this.jmt.cwC();
        }
    }
}
