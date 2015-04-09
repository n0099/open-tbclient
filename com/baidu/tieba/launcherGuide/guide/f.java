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
    private TextView aKD;
    private TextView aYa;
    private TextView bwH;
    private ImageView bwI;
    private TbImageView bwJ;
    private LinearLayout bwK;
    final /* synthetic */ e bwL;
    private View mView;

    public View getView() {
        return this.mView;
    }

    public f(e eVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Context context;
        this.bwL = eVar;
        com.baidu.adp.lib.g.b hH = com.baidu.adp.lib.g.b.hH();
        context = eVar.mContext;
        this.mView = hH.inflate(context, com.baidu.tieba.w.new_user_rich_item, null);
        this.mView.setTag(Integer.valueOf(card.getFid()));
        a(card, onClickListener);
    }

    public f(e eVar, View view) {
        this.bwL = eVar;
        this.mView = view;
        initUI();
    }

    public void initUI() {
        this.aYa = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_fname);
        this.aKD = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_cdesc);
        this.bwI = (ImageView) this.mView.findViewById(com.baidu.tieba.v.iv_like);
        this.bwH = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_slogan);
        this.bwJ = (TbImageView) this.mView.findViewById(com.baidu.tieba.v.img);
        this.bwK = (LinearLayout) this.mView.findViewById(com.baidu.tieba.v.ll_like);
    }

    public void dn(boolean z) {
        Context context;
        Context context2;
        if (!z) {
            ImageView imageView = this.bwI;
            context2 = this.bwL.mContext;
            imageView.setBackgroundDrawable(context2.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_n));
            return;
        }
        ImageView imageView2 = this.bwI;
        context = this.bwL.mContext;
        imageView2.setBackgroundDrawable(context.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_s));
    }

    private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
        initUI();
        this.bwK.setOnClickListener(onClickListener);
        this.bwK.setTag(card);
        this.aYa.setText(card.getFname());
        this.aKD.setText(card.getCdesc());
        this.bwH.setText(card.getSlogan());
        this.bwJ.setTag(card.getAvatar());
        dn(card.getIs_like() != 0);
    }
}
