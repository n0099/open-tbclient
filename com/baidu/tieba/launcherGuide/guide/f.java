package com.baidu.tieba.launcherGuide.guide;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
/* loaded from: classes.dex */
class f {
    private TextView aKt;
    private TextView aXK;
    private TextView bwr;
    private ImageView bws;
    private TbImageView bwt;
    private LinearLayout bwu;
    final /* synthetic */ e bwv;
    private View mView;

    public View getView() {
        return this.mView;
    }

    public f(e eVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Context context;
        this.bwv = eVar;
        com.baidu.adp.lib.g.b hH = com.baidu.adp.lib.g.b.hH();
        context = eVar.mContext;
        this.mView = hH.inflate(context, com.baidu.tieba.w.new_user_rich_item, null);
        this.mView.setTag(Integer.valueOf(card.getFid()));
        a(card, onClickListener);
    }

    public f(e eVar, View view) {
        this.bwv = eVar;
        this.mView = view;
        initUI();
    }

    public void initUI() {
        this.aXK = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_fname);
        this.aKt = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_cdesc);
        this.bws = (ImageView) this.mView.findViewById(com.baidu.tieba.v.iv_like);
        this.bwr = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_slogan);
        this.bwt = (TbImageView) this.mView.findViewById(com.baidu.tieba.v.img);
        this.bwu = (LinearLayout) this.mView.findViewById(com.baidu.tieba.v.ll_like);
    }

    public void dq(boolean z) {
        Context context;
        Context context2;
        if (!z) {
            ImageView imageView = this.bws;
            context2 = this.bwv.mContext;
            imageView.setBackgroundDrawable(context2.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_n));
            return;
        }
        ImageView imageView2 = this.bws;
        context = this.bwv.mContext;
        imageView2.setBackgroundDrawable(context.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_s));
    }

    private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
        initUI();
        this.bwu.setOnClickListener(onClickListener);
        this.bwu.setTag(card);
        this.aXK.setText(card.getFname());
        this.aKt.setText(card.getCdesc());
        this.bwr.setText(card.getSlogan());
        this.bwt.setTag(card.getAvatar());
        dq(card.getIs_like() != 0);
    }
}
