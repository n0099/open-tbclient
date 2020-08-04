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
    private com.baidu.tieba.personPolymeric.b.b kUu;
    private TextView kZu;
    private TextView kZv;
    private ImageView kZw;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_privacy_setting_rootview);
        this.fyb = view.findViewById(R.id.top_divider_line);
        this.kZw = (ImageView) view.findViewById(R.id.lock_img);
        this.kZu = (TextView) view.findViewById(R.id.one_public_tv);
        this.kZv = (TextView) view.findViewById(R.id.card_hint_txt);
        this.kZu.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            ao.setBackgroundResource(this.fyb, R.color.cp_bg_line_e);
            ao.setViewTextColor(this.kZv, R.color.cp_cont_d, 1);
            ao.setImageResource(this.kZw, R.drawable.pic_pop_key);
            ao.setViewTextColor(this.kZu, R.color.cp_link_tip_c, 1);
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
        this.kUu = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.kUu != null && view == this.kZu) {
            this.kUu.cXc();
        }
    }
}
