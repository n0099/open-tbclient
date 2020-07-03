package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class h extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View fsT;
    private com.baidu.tieba.personPolymeric.b.b kLs;
    private TextView kQw;
    private TextView kQx;
    private ImageView kQy;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_privacy_setting_rootview);
        this.fsT = view.findViewById(R.id.top_divider_line);
        this.kQy = (ImageView) view.findViewById(R.id.lock_img);
        this.kQw = (TextView) view.findViewById(R.id.one_public_tv);
        this.kQx = (TextView) view.findViewById(R.id.card_hint_txt);
        this.kQw.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            an.setBackgroundResource(this.fsT, R.color.cp_bg_line_e);
            an.setViewTextColor(this.kQx, R.color.cp_cont_d, 1);
            an.setImageResource(this.kQy, R.drawable.pic_pop_key);
            an.setViewTextColor(this.kQw, R.color.cp_link_tip_c, 1);
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
        if (this.fsT != null) {
            if (jVar.gVv) {
                this.fsT.setVisibility(8);
            } else {
                this.fsT.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.b bVar) {
        this.kLs = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.kLs != null && view == this.kQw) {
            this.kLs.cTl();
        }
    }
}
