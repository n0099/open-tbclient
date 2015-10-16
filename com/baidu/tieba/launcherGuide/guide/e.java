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
import com.baidu.tieba.i;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends Dialog implements com.baidu.tieba.launcherGuide.guide.a {
    private TextView aPq;
    private TextView bRv;
    private View bRw;
    private LinearLayout bRx;
    private View.OnClickListener bRy;
    private LinearLayout bRz;
    private View bnn;
    private Context mContext;

    public e(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bnn = View.inflate(this.mContext, i.g.new_user_box, null);
        setContentView(this.bnn);
        setCanceledOnTouchOutside(true);
        this.bRz = (LinearLayout) this.bnn.findViewById(i.f.box_close_layout);
        this.aPq = (TextView) this.bnn.findViewById(i.f.prompt_title);
        this.bRv = (TextView) this.bnn.findViewById(i.f.prompt_sub_title);
        this.bRw = this.bnn.findViewById(i.f.view_layout);
        this.bRx = (LinearLayout) findViewById(i.f.layout_content);
        this.bRw.setBackgroundDrawable(this.mContext.getResources().getDrawable(i.e.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bRy = onClickListener;
        this.bRz.setOnClickListener(onClickListener);
    }

    @Override // android.app.Dialog, com.baidu.tieba.launcherGuide.guide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.g.j.b(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.aPq.setText(tag.getBname());
        this.bRv.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View view = new a(card, this.bRy).getView();
            this.bRx.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(i.d.ds20);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(i.d.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.bRx.addView(LayoutInflater.from(this.mContext).inflate(i.g.new_user_line_item, (ViewGroup) null));
            }
            ((TbImageView) this.bRx.findViewWithTag(card.getAvatar())).d(card.getAvatar(), 10, false);
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(i.d.ds120);
        if ((getContext().getResources().getDimensionPixelSize(i.d.ds140) * card_list.size()) + getContext().getResources().getDimensionPixelSize(i.d.ds188) + getContext().getResources().getDimensionPixelSize(i.d.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    /* loaded from: classes.dex */
    private class a {
        private TextView aWc;
        private TextView bRA;
        private ImageView bRB;
        private TbImageView bRC;
        private LinearLayout bRD;
        private TextView bsm;
        private View mView;

        public View getView() {
            return this.mView;
        }

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            this.mView = LayoutInflater.from(e.this.mContext).inflate(i.g.new_user_rich_item, (ViewGroup) null);
            this.mView.setTag(Integer.valueOf(card.getFid()));
            a(card, onClickListener);
        }

        public a(View view) {
            this.mView = view;
            initUI();
        }

        public void initUI() {
            this.bsm = (TextView) this.mView.findViewById(i.f.tv_fname);
            this.aWc = (TextView) this.mView.findViewById(i.f.tv_cdesc);
            this.bRB = (ImageView) this.mView.findViewById(i.f.iv_like);
            this.bRA = (TextView) this.mView.findViewById(i.f.tv_slogan);
            this.bRC = (TbImageView) this.mView.findViewById(i.f.img);
            this.bRD = (LinearLayout) this.mView.findViewById(i.f.ll_like);
        }

        public void dH(boolean z) {
            if (!z) {
                this.bRB.setBackgroundDrawable(e.this.mContext.getResources().getDrawable(i.e.icon_startpage2_add_ba_n));
            } else {
                this.bRB.setBackgroundDrawable(e.this.mContext.getResources().getDrawable(i.e.icon_startpage2_add_ba_s));
            }
        }

        private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            initUI();
            this.bRD.setOnClickListener(onClickListener);
            this.bRD.setTag(card);
            this.bsm.setText(card.getFname());
            this.aWc.setText(card.getCdesc());
            this.bRA.setText(card.getSlogan());
            this.bRC.setTag(card.getAvatar());
            dH(card.getIs_like() != 0);
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void hU(int i) {
        View findViewWithTag = this.bRx.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).dH(true);
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void hV(int i) {
        View findViewWithTag = this.bRx.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).dH(false);
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public View getRootView() {
        return this.bnn;
    }
}
