package com.baidu.tieba.launcherGuide.guide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
/* loaded from: classes.dex */
class s {
    TextView aKD;
    TextView aYa;
    private ImageView bwI;
    private LinearLayout bwK;
    final /* synthetic */ r bxs;
    View mView;

    public View getView() {
        return this.mView;
    }

    public s(r rVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Context context;
        this.bxs = rVar;
        com.baidu.adp.lib.g.b hH = com.baidu.adp.lib.g.b.hH();
        context = rVar.mContext;
        this.mView = hH.inflate(context, com.baidu.tieba.w.new_user_text_item, null);
        this.mView.setTag(Integer.valueOf(card.getFid()));
        a(card, onClickListener);
    }

    public s(r rVar, View view) {
        this.bxs = rVar;
        this.mView = view;
        initUI();
    }

    public void initUI() {
        this.aYa = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_fname);
        this.aKD = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_cdesc);
        this.bwI = (ImageView) this.mView.findViewById(com.baidu.tieba.v.iv_like);
        this.bwK = (LinearLayout) this.mView.findViewById(com.baidu.tieba.v.ll_like);
    }

    public void dn(boolean z) {
        Context context;
        Context context2;
        if (!z) {
            ImageView imageView = this.bwI;
            context2 = this.bxs.mContext;
            imageView.setBackgroundDrawable(context2.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_n));
            return;
        }
        ImageView imageView2 = this.bwI;
        context = this.bxs.mContext;
        imageView2.setBackgroundDrawable(context.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_s));
    }

    private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Drawable drawable;
        Context context;
        Context context2;
        initUI();
        this.bwK.setOnClickListener(onClickListener);
        this.bwK.setTag(card);
        this.aYa.setText(card.getFname());
        if (card.getOrder() == 1) {
            context2 = this.bxs.mContext;
            drawable = context2.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_rise);
        } else if (card.getOrder() == 2) {
            context = this.bxs.mContext;
            drawable = context.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_decline);
        } else {
            drawable = null;
        }
        this.aYa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.aKD.setText(card.getCdesc());
        dn(card.getIs_like() != 0);
    }
}
