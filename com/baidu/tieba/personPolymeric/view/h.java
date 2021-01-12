package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class h extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View gDl;
    private View mRootView;
    private com.baidu.tieba.personPolymeric.b.c mqh;
    private TextView mvH;
    private TextView mvI;
    private ImageView mvJ;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_privacy_setting_rootview);
        this.gDl = view.findViewById(R.id.top_divider_line);
        this.mvJ = (ImageView) view.findViewById(R.id.lock_img);
        this.mvH = (TextView) view.findViewById(R.id.one_public_tv);
        this.mvI = (TextView) view.findViewById(R.id.card_hint_txt);
        this.mvH.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            ao.setBackgroundResource(this.gDl, R.color.CAM_X0205);
            ao.setViewTextColor(this.mvI, R.color.CAM_X0109, 1);
            ao.setImageResource(this.mvJ, R.drawable.pic_pop_key);
            ao.setViewTextColor(this.mvH, R.color.CAM_X0304, 1);
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
        if (this.gDl != null) {
            if (jVar.ivP) {
                this.gDl.setVisibility(8);
            } else {
                this.gDl.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.c cVar) {
        this.mqh = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.mqh != null && view == this.mvH) {
            this.mqh.dvQ();
        }
    }
}
