package com.baidu.tieba.tblauncherInterestGuide;

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
import com.baidu.adp.lib.g.g;
import com.baidu.tieba.f;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends Dialog implements com.baidu.tieba.tblauncherInterestGuide.a {
    private View bzd;
    private TextView eIU;
    private View gTT;
    private LinearLayout gTU;
    private View.OnClickListener gTV;
    private LinearLayout gTW;
    private Context mContext;
    private TextView mTitle;

    public e(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bzd = View.inflate(this.mContext, f.h.new_user_box, null);
        setContentView(this.bzd);
        setCanceledOnTouchOutside(true);
        this.gTW = (LinearLayout) this.bzd.findViewById(f.g.box_close_layout);
        this.mTitle = (TextView) this.bzd.findViewById(f.g.prompt_title);
        this.eIU = (TextView) this.bzd.findViewById(f.g.prompt_sub_title);
        this.gTT = this.bzd.findViewById(f.g.view_layout);
        this.gTU = (LinearLayout) this.bzd.findViewById(f.g.layout_content);
        this.gTT.setBackgroundDrawable(this.mContext.getResources().getDrawable(f.C0146f.bg_startpage2_card_blue_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gTV = onClickListener;
        this.gTW.setOnClickListener(onClickListener);
    }

    @Override // android.app.Dialog, com.baidu.tieba.tblauncherInterestGuide.a
    public void show() {
        if (!(this.mContext instanceof Activity) || g.m((Activity) this.mContext)) {
            super.show();
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.mTitle.setText(tag.getBname());
        this.eIU.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            View view = new a(card_list.get(i), this.gTV).getView();
            this.gTU.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(f.e.ds40);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(f.e.ds52) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.gTU.addView(LayoutInflater.from(this.mContext).inflate(f.h.new_user_line_item, (ViewGroup) null));
            }
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(f.e.ds120);
        if ((getContext().getResources().getDimensionPixelSize(f.e.ds112) * card_list.size()) + getContext().getResources().getDimensionPixelSize(f.e.ds188) + getContext().getResources().getDimensionPixelSize(f.e.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void ua(int i) {
        View findViewWithTag = this.gTU.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(true);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void ub(int i) {
        View findViewWithTag = this.gTU.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(false);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.bzd;
    }

    @Override // android.app.Dialog, com.baidu.tieba.tblauncherInterestGuide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            g.b(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView eDe;
        private ImageView gTX;
        private LinearLayout gTZ;
        TextView mName;
        View mView;

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            this.mView = LayoutInflater.from(e.this.mContext).inflate(f.h.new_user_text_item, (ViewGroup) null);
            this.mView.setTag(Integer.valueOf(card.getFid()));
            a(card, onClickListener);
        }

        public a(View view) {
            this.mView = view;
            initUI();
        }

        public View getView() {
            return this.mView;
        }

        public void initUI() {
            this.mName = (TextView) this.mView.findViewById(f.g.tv_fname);
            this.eDe = (TextView) this.mView.findViewById(f.g.tv_cdesc);
            this.gTX = (ImageView) this.mView.findViewById(f.g.iv_like);
            this.gTZ = (LinearLayout) this.mView.findViewById(f.g.ll_like);
        }

        public void setIsLike(boolean z) {
            if (!z) {
                this.gTX.setBackgroundDrawable(e.this.mContext.getResources().getDrawable(f.C0146f.icon_startpage2_add_ba_n));
            } else {
                this.gTX.setBackgroundDrawable(e.this.mContext.getResources().getDrawable(f.C0146f.icon_startpage2_add_ba_s));
            }
        }

        private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Drawable drawable;
            initUI();
            this.gTZ.setOnClickListener(onClickListener);
            this.gTZ.setTag(card);
            this.mName.setText(card.getFname());
            if (card.getOrder() == 1) {
                drawable = e.this.mContext.getResources().getDrawable(f.C0146f.icon_startpage2_add_ba_rise);
            } else {
                drawable = card.getOrder() == 2 ? e.this.mContext.getResources().getDrawable(f.C0146f.icon_startpage2_add_ba_decline) : null;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            this.eDe.setText(card.getCdesc());
            setIsLike(card.getIs_like() != 0);
        }
    }
}
