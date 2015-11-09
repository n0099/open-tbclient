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
import com.baidu.tieba.i;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o extends Dialog implements com.baidu.tieba.launcherGuide.guide.a {
    private TextView aPy;
    private TextView bRQ;
    private View bRR;
    private LinearLayout bRS;
    private View.OnClickListener bRT;
    private LinearLayout bRU;
    private View bnR;
    private Context mContext;

    public o(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bnR = View.inflate(this.mContext, i.g.new_user_box, null);
        setContentView(this.bnR);
        setCanceledOnTouchOutside(true);
        this.bRU = (LinearLayout) this.bnR.findViewById(i.f.box_close_layout);
        this.aPy = (TextView) this.bnR.findViewById(i.f.prompt_title);
        this.bRQ = (TextView) this.bnR.findViewById(i.f.prompt_sub_title);
        this.bRR = this.bnR.findViewById(i.f.view_layout);
        this.bRS = (LinearLayout) this.bnR.findViewById(i.f.layout_content);
        this.bRR.setBackgroundDrawable(this.mContext.getResources().getDrawable(i.e.bg_startpage2_card_blue_up));
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bRT = onClickListener;
        this.bRU.setOnClickListener(onClickListener);
    }

    @Override // android.app.Dialog, com.baidu.tieba.launcherGuide.guide.a
    public void show() {
        if (!(this.mContext instanceof Activity) || com.baidu.adp.lib.g.j.k((Activity) this.mContext)) {
            super.show();
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.aPy.setText(tag.getBname());
        this.bRQ.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            View view = new a(card_list.get(i), this.bRT).getView();
            this.bRS.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(i.d.ds40);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(i.d.ds52) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.bRS.addView(LayoutInflater.from(this.mContext).inflate(i.g.new_user_line_item, (ViewGroup) null));
            }
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(i.d.ds120);
        if ((getContext().getResources().getDimensionPixelSize(i.d.ds112) * card_list.size()) + getContext().getResources().getDimensionPixelSize(i.d.ds188) + getContext().getResources().getDimensionPixelSize(i.d.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aWk;
        private ImageView bRW;
        private LinearLayout bRY;
        TextView bsQ;
        View mView;

        public View getView() {
            return this.mView;
        }

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            this.mView = LayoutInflater.from(o.this.mContext).inflate(i.g.new_user_text_item, (ViewGroup) null);
            this.mView.setTag(Integer.valueOf(card.getFid()));
            a(card, onClickListener);
        }

        public a(View view) {
            this.mView = view;
            initUI();
        }

        public void initUI() {
            this.bsQ = (TextView) this.mView.findViewById(i.f.tv_fname);
            this.aWk = (TextView) this.mView.findViewById(i.f.tv_cdesc);
            this.bRW = (ImageView) this.mView.findViewById(i.f.iv_like);
            this.bRY = (LinearLayout) this.mView.findViewById(i.f.ll_like);
        }

        public void dJ(boolean z) {
            if (!z) {
                this.bRW.setBackgroundDrawable(o.this.mContext.getResources().getDrawable(i.e.icon_startpage2_add_ba_n));
            } else {
                this.bRW.setBackgroundDrawable(o.this.mContext.getResources().getDrawable(i.e.icon_startpage2_add_ba_s));
            }
        }

        private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Drawable drawable;
            initUI();
            this.bRY.setOnClickListener(onClickListener);
            this.bRY.setTag(card);
            this.bsQ.setText(card.getFname());
            if (card.getOrder() == 1) {
                drawable = o.this.mContext.getResources().getDrawable(i.e.icon_startpage2_add_ba_rise);
            } else {
                drawable = card.getOrder() == 2 ? o.this.mContext.getResources().getDrawable(i.e.icon_startpage2_add_ba_decline) : null;
            }
            this.bsQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            this.aWk.setText(card.getCdesc());
            dJ(card.getIs_like() != 0);
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void ii(int i) {
        View findViewWithTag = this.bRS.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).dJ(true);
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public void ij(int i) {
        View findViewWithTag = this.bRS.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).dJ(false);
        }
    }

    @Override // com.baidu.tieba.launcherGuide.guide.a
    public View getRootView() {
        return this.bnR;
    }

    @Override // android.app.Dialog, com.baidu.tieba.launcherGuide.guide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            com.baidu.adp.lib.g.j.b(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }
}
