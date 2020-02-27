package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View eqA;
    private com.baidu.tieba.personPolymeric.b.b jmr;
    private TextView jrv;
    private TextView jrw;
    private ImageView jrx;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_privacy_setting_rootview);
        this.eqA = view.findViewById(R.id.top_divider_line);
        this.jrx = (ImageView) view.findViewById(R.id.lock_img);
        this.jrv = (TextView) view.findViewById(R.id.one_public_tv);
        this.jrw = (TextView) view.findViewById(R.id.card_hint_txt);
        this.jrv.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setBackgroundResource(this.eqA, R.color.cp_bg_line_e);
            am.setViewTextColor(this.jrw, R.color.cp_cont_d, 1);
            am.setImageResource(this.jrx, R.drawable.pic_pop_key);
            am.setViewTextColor(this.jrv, R.color.cp_link_tip_c, 1);
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
        if (this.eqA != null) {
            if (jVar.fNP) {
                this.eqA.setVisibility(8);
            } else {
                this.eqA.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.b bVar) {
        this.jmr = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.jmr != null && view == this.jrv) {
            this.jmr.cwA();
        }
    }
}
