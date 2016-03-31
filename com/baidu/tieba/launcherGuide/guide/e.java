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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends Dialog implements com.baidu.tieba.launcherGuide.guide.a {
    private TextView aSh;
    private View bJp;
    private TextView cDn;
    private View cDo;
    private LinearLayout cDp;
    private View.OnClickListener cDq;
    private LinearLayout cDr;
    private Context mContext;

    public e(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bJp = View.inflate(this.mContext, t.h.new_user_box, null);
        setContentView(this.bJp);
        setCanceledOnTouchOutside(true);
        this.cDr = (LinearLayout) this.bJp.findViewById(t.g.box_close_layout);
        this.aSh = (TextView) this.bJp.findViewById(t.g.prompt_title);
        this.cDn = (TextView) this.bJp.findViewById(t.g.prompt_sub_title);
        this.cDo = this.bJp.findViewById(t.g.view_layout);
        this.cDp = (LinearLayout) findViewById(t.g.layout_content);
        this.cDo.setBackgroundDrawable(this.mContext.getResources().getDrawable(t.f.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.cDq = onClickListener;
        this.cDr.setOnClickListener(onClickListener);
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
        this.aSh.setText(tag.getBname());
        this.cDn.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View view = new a(card, this.cDq).getView();
            this.cDp.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(t.e.ds20);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(t.e.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.cDp.addView(LayoutInflater.from(this.mContext).inflate(t.h.new_user_line_item, (ViewGroup) null));
            }
            ((TbImageView) this.cDp.findViewWithTag(card.getAvatar())).c(card.getAvatar(), 10, false);
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(t.e.ds120);
        if ((getContext().getResources().getDimensionPixelSize(t.e.ds140) * card_list.size()) + getContext().getResources().getDimensionPixelSize(t.e.ds188) + getContext().getResources().getDimensionPixelSize(t.e.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    /* loaded from: classes.dex */
    private class a {
        private TextView bZJ;
        private TextView bmR;
        private TextView cDs;
        private ImageView cDt;
        private TbImageView cDu;
        private LinearLayout cDv;
        private View mView;

        public View getView() {
            return this.mView;
        }

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            this.mView = LayoutInflater.from(e.this.mContext).inflate(t.h.new_user_rich_item, (ViewGroup) null);
            this.mView.setTag(Integer.valueOf(card.getFid()));
            a(card, onClickListener);
        }

        public a(View view) {
            this.mView = view;
            pU();
        }

        public void pU() {
            this.bZJ = (TextView) this.mView.findViewById(t.g.tv_fname);
            this.bmR = (TextView) this.mView.findViewById(t.g.tv_cdesc);
            this.cDt = (ImageView) this.mView.findViewById(t.g.iv_like);
            this.cDs = (TextView) this.mView.findViewById(t.g.tv_slogan);
            this.cDu = (TbImageView) this.mView.findViewById(t.g.img);
            this.cDv = (LinearLayout) this.mView.findViewById(t.g.ll_like);
        }

        public void eS(boolean z) {
            if (!z) {
                this.cDt.setBackgroundDrawable(e.this.mContext.getResources().getDrawable(t.f.icon_startpage2_add_ba_n));
            } else {
                this.cDt.setBackgroundDrawable(e.this.mContext.getResources().getDrawable(t.f.icon_startpage2_add_ba_s));
            }
        }

        private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            pU();
            this.cDv.setOnClickListener(onClickListener);
            this.cDv.setTag(card);
            this.bZJ.setText(card.getFname());
            this.bmR.setText(card.getCdesc());
            this.cDs.setText(card.getSlogan());
            this.cDu.setTag(card.getAvatar());
            eS(card.getIs_like() != 0);
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void kF(int i) {
        View findViewWithTag = this.cDp.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).eS(true);
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void kG(int i) {
        View findViewWithTag = this.cDp.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).eS(false);
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public View getRootView() {
        return this.bJp;
    }
}
