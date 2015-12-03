package com.baidu.tieba.launcherGuide.guide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends Dialog implements com.baidu.tieba.launcherGuide.guide.a {
    private TextView aUB;
    private View bwP;
    private TextView cic;
    private View cie;
    private LinearLayout cif;
    private View.OnClickListener cig;
    private LinearLayout cih;
    private Context mContext;

    public e(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bwP = View.inflate(this.mContext, n.g.new_user_box, null);
        setContentView(this.bwP);
        setCanceledOnTouchOutside(true);
        this.cih = (LinearLayout) this.bwP.findViewById(n.f.box_close_layout);
        this.aUB = (TextView) this.bwP.findViewById(n.f.prompt_title);
        this.cic = (TextView) this.bwP.findViewById(n.f.prompt_sub_title);
        this.cie = this.bwP.findViewById(n.f.view_layout);
        this.cif = (LinearLayout) findViewById(n.f.layout_content);
        this.cie.setBackgroundDrawable(this.mContext.getResources().getDrawable(n.e.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.cig = onClickListener;
        this.cih.setOnClickListener(onClickListener);
    }

    @Override // android.app.Dialog, com.baidu.tieba.launcherGuide.guide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.h.j.b(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.aUB.setText(tag.getBname());
        this.cic.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View view = new a(card, this.cig).getView();
            this.cif.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(n.d.ds20);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(n.d.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.cif.addView(LayoutInflater.from(this.mContext).inflate(n.g.new_user_line_item, (ViewGroup) null));
            }
            ((TbImageView) this.cif.findViewWithTag(card.getAvatar())).d(card.getAvatar(), 10, false);
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(n.d.ds120);
        if ((getContext().getResources().getDimensionPixelSize(n.d.ds140) * card_list.size()) + getContext().getResources().getDimensionPixelSize(n.d.ds188) + getContext().getResources().getDimensionPixelSize(n.d.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    /* loaded from: classes.dex */
    private class a {
        private TextView bHW;
        private TextView bbA;
        private TextView cii;
        private ImageView cij;
        private TbImageView cik;
        private LinearLayout cil;
        private View mView;

        public View getView() {
            return this.mView;
        }

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            this.mView = LayoutInflater.from(e.this.mContext).inflate(n.g.new_user_rich_item, (ViewGroup) null);
            this.mView.setTag(Integer.valueOf(card.getFid()));
            a(card, onClickListener);
        }

        public a(View view) {
            this.mView = view;
            initUI();
        }

        public void initUI() {
            this.bHW = (TextView) this.mView.findViewById(n.f.tv_fname);
            this.bbA = (TextView) this.mView.findViewById(n.f.tv_cdesc);
            this.cij = (ImageView) this.mView.findViewById(n.f.iv_like);
            this.cii = (TextView) this.mView.findViewById(n.f.tv_slogan);
            this.cik = (TbImageView) this.mView.findViewById(n.f.img);
            this.cil = (LinearLayout) this.mView.findViewById(n.f.ll_like);
        }

        public void ei(boolean z) {
            if (!z) {
                this.cij.setBackgroundDrawable(e.this.mContext.getResources().getDrawable(n.e.icon_startpage2_add_ba_n));
            } else {
                this.cij.setBackgroundDrawable(e.this.mContext.getResources().getDrawable(n.e.icon_startpage2_add_ba_s));
            }
        }

        private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            initUI();
            this.cil.setOnClickListener(onClickListener);
            this.cil.setTag(card);
            this.bHW.setText(card.getFname());
            this.bbA.setText(card.getCdesc());
            this.cii.setText(card.getSlogan());
            this.cik.setTag(card.getAvatar());
            ei(card.getIs_like() != 0);
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void jc(int i) {
        View findViewWithTag = this.cif.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).ei(true);
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void jd(int i) {
        View findViewWithTag = this.cif.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).ei(false);
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public View getRootView() {
        return this.bwP;
    }
}
