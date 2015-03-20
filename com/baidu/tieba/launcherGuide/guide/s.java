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
    TextView aKt;
    TextView aXK;
    private ImageView bws;
    private LinearLayout bwu;
    final /* synthetic */ r bxc;
    View mView;

    public View getView() {
        return this.mView;
    }

    public s(r rVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Context context;
        this.bxc = rVar;
        com.baidu.adp.lib.g.b hH = com.baidu.adp.lib.g.b.hH();
        context = rVar.mContext;
        this.mView = hH.inflate(context, com.baidu.tieba.w.new_user_text_item, null);
        this.mView.setTag(Integer.valueOf(card.getFid()));
        a(card, onClickListener);
    }

    public s(r rVar, View view) {
        this.bxc = rVar;
        this.mView = view;
        initUI();
    }

    public void initUI() {
        this.aXK = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_fname);
        this.aKt = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_cdesc);
        this.bws = (ImageView) this.mView.findViewById(com.baidu.tieba.v.iv_like);
        this.bwu = (LinearLayout) this.mView.findViewById(com.baidu.tieba.v.ll_like);
    }

    public void dq(boolean z) {
        Context context;
        Context context2;
        if (!z) {
            ImageView imageView = this.bws;
            context2 = this.bxc.mContext;
            imageView.setBackgroundDrawable(context2.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_n));
            return;
        }
        ImageView imageView2 = this.bws;
        context = this.bxc.mContext;
        imageView2.setBackgroundDrawable(context.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_s));
    }

    private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Drawable drawable;
        Context context;
        Context context2;
        initUI();
        this.bwu.setOnClickListener(onClickListener);
        this.bwu.setTag(card);
        this.aXK.setText(card.getFname());
        if (card.getOrder() == 1) {
            context2 = this.bxc.mContext;
            drawable = context2.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_rise);
        } else if (card.getOrder() == 2) {
            context = this.bxc.mContext;
            drawable = context.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_decline);
        } else {
            drawable = null;
        }
        this.aXK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.aKt.setText(card.getCdesc());
        dq(card.getIs_like() != 0);
    }
}
