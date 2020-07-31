package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class h extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View fyb;
    private com.baidu.tieba.personPolymeric.b.b kUs;
    private TextView kZs;
    private TextView kZt;
    private ImageView kZu;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_privacy_setting_rootview);
        this.fyb = view.findViewById(R.id.top_divider_line);
        this.kZu = (ImageView) view.findViewById(R.id.lock_img);
        this.kZs = (TextView) view.findViewById(R.id.one_public_tv);
        this.kZt = (TextView) view.findViewById(R.id.card_hint_txt);
        this.kZs.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            ao.setBackgroundResource(this.fyb, R.color.cp_bg_line_e);
            ao.setViewTextColor(this.kZt, R.color.cp_cont_d, 1);
            ao.setImageResource(this.kZu, R.drawable.pic_pop_key);
            ao.setViewTextColor(this.kZs, R.color.cp_link_tip_c, 1);
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
        if (this.fyb != null) {
            if (jVar.haZ) {
                this.fyb.setVisibility(8);
            } else {
                this.fyb.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.b bVar) {
        this.kUs = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.kUs != null && view == this.kZs) {
            this.kUs.cXc();
        }
    }
}
