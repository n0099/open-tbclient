package com.baidu.tieba.launcherGuide.guide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o extends Dialog implements com.baidu.tieba.launcherGuide.guide.a {
    private TextView aSh;
    private View bJp;
    private TextView cDn;
    private View cDo;
    private LinearLayout cDp;
    private View.OnClickListener cDq;
    private LinearLayout cDr;
    private Context mContext;

    public o(Context context, int i) {
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
        this.cDp = (LinearLayout) this.bJp.findViewById(t.g.layout_content);
        this.cDo.setBackgroundDrawable(this.mContext.getResources().getDrawable(t.f.bg_startpage2_card_blue_up));
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.cDq = onClickListener;
        this.cDr.setOnClickListener(onClickListener);
    }

    @Override // android.app.Dialog, com.baidu.tieba.launcherGuide.guide.a
    public void show() {
        if (!(this.mContext instanceof Activity) || com.baidu.adp.lib.h.j.f((Activity) this.mContext)) {
            super.show();
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.aSh.setText(tag.getBname());
        this.cDn.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            View view = new a(card_list.get(i), this.cDq).getView();
            this.cDp.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(t.e.ds40);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(t.e.ds52) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.cDp.addView(LayoutInflater.from(this.mContext).inflate(t.h.new_user_line_item, (ViewGroup) null));
            }
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(t.e.ds120);
        if ((getContext().getResources().getDimensionPixelSize(t.e.ds112) * card_list.size()) + getContext().getResources().getDimensionPixelSize(t.e.ds188) + getContext().getResources().getDimensionPixelSize(t.e.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView bZJ;
        TextView bmR;
        private ImageView cDt;
        private LinearLayout cDv;
        View mView;

        public View getView() {
            return this.mView;
        }

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            this.mView = LayoutInflater.from(o.this.mContext).inflate(t.h.new_user_text_item, (ViewGroup) null);
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
            this.cDv = (LinearLayout) this.mView.findViewById(t.g.ll_like);
        }

        public void eS(boolean z) {
            if (!z) {
                this.cDt.setBackgroundDrawable(o.this.mContext.getResources().getDrawable(t.f.icon_startpage2_add_ba_n));
            } else {
                this.cDt.setBackgroundDrawable(o.this.mContext.getResources().getDrawable(t.f.icon_startpage2_add_ba_s));
            }
        }

        private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Drawable drawable;
            pU();
            this.cDv.setOnClickListener(onClickListener);
            this.cDv.setTag(card);
            this.bZJ.setText(card.getFname());
            if (card.getOrder() == 1) {
                drawable = o.this.mContext.getResources().getDrawable(t.f.icon_startpage2_add_ba_rise);
            } else {
                drawable = card.getOrder() == 2 ? o.this.mContext.getResources().getDrawable(t.f.icon_startpage2_add_ba_decline) : null;
            }
            this.bZJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            this.bmR.setText(card.getCdesc());
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

    @Override // android.app.Dialog, com.baidu.tieba.launcherGuide.guide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.h.j.b(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }
}
