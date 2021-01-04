package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class h extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View gHR;
    private TextView mAm;
    private TextView mAn;
    private ImageView mAo;
    private View mRootView;
    private com.baidu.tieba.personPolymeric.b.c muN;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_privacy_setting_rootview);
        this.gHR = view.findViewById(R.id.top_divider_line);
        this.mAo = (ImageView) view.findViewById(R.id.lock_img);
        this.mAm = (TextView) view.findViewById(R.id.one_public_tv);
        this.mAn = (TextView) view.findViewById(R.id.card_hint_txt);
        this.mAm.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            ao.setBackgroundResource(this.gHR, R.color.CAM_X0205);
            ao.setViewTextColor(this.mAn, R.color.CAM_X0109, 1);
            ao.setImageResource(this.mAo, R.drawable.pic_pop_key);
            ao.setViewTextColor(this.mAm, R.color.CAM_X0304, 1);
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
        if (this.gHR != null) {
            if (jVar.iAw) {
                this.gHR.setVisibility(8);
            } else {
                this.gHR.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.c cVar) {
        this.muN = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.muN != null && view == this.mAm) {
            this.muN.dzH();
        }
    }
}
