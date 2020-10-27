package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class h extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View gji;
    private com.baidu.tieba.personPolymeric.b.c lVb;
    private View mRootView;
    private TextView maB;
    private TextView maC;
    private ImageView maD;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_privacy_setting_rootview);
        this.gji = view.findViewById(R.id.top_divider_line);
        this.maD = (ImageView) view.findViewById(R.id.lock_img);
        this.maB = (TextView) view.findViewById(R.id.one_public_tv);
        this.maC = (TextView) view.findViewById(R.id.card_hint_txt);
        this.maB.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.gji, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.maC, R.color.cp_cont_d, 1);
            ap.setImageResource(this.maD, R.drawable.pic_pop_key);
            ap.setViewTextColor(this.maB, R.color.cp_link_tip_c, 1);
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
        if (this.gji != null) {
            if (jVar.hWq) {
                this.gji.setVisibility(8);
            } else {
                this.gji.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.c cVar) {
        this.lVb = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.lVb != null && view == this.maB) {
            this.lVb.dsx();
        }
    }
}
