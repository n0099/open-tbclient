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
import com.baidu.tieba.d;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends Dialog implements com.baidu.tieba.tblauncherInterestGuide.a {
    private TextView eFf;
    private View gST;
    private LinearLayout gSU;
    private View.OnClickListener gSV;
    private LinearLayout gSW;
    private Context mContext;
    private TextView mTitle;
    private View root;

    public e(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.root = View.inflate(this.mContext, d.i.new_user_box, null);
        setContentView(this.root);
        setCanceledOnTouchOutside(true);
        this.gSW = (LinearLayout) this.root.findViewById(d.g.box_close_layout);
        this.mTitle = (TextView) this.root.findViewById(d.g.prompt_title);
        this.eFf = (TextView) this.root.findViewById(d.g.prompt_sub_title);
        this.gST = this.root.findViewById(d.g.view_layout);
        this.gSU = (LinearLayout) this.root.findViewById(d.g.layout_content);
        this.gST.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_startpage2_card_blue_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gSV = onClickListener;
        this.gSW.setOnClickListener(onClickListener);
    }

    @Override // android.app.Dialog, com.baidu.tieba.tblauncherInterestGuide.a
    public void show() {
        if (!(this.mContext instanceof Activity) || g.n((Activity) this.mContext)) {
            super.show();
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.mTitle.setText(tag.getBname());
        this.eFf.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            View view = new a(card_list.get(i), this.gSV).getView();
            this.gSU.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds40);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(d.e.ds52) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.gSU.addView(LayoutInflater.from(this.mContext).inflate(d.i.new_user_line_item, (ViewGroup) null));
            }
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(d.e.ds120);
        if ((getContext().getResources().getDimensionPixelSize(d.e.ds112) * card_list.size()) + getContext().getResources().getDimensionPixelSize(d.e.ds188) + getContext().getResources().getDimensionPixelSize(d.e.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void uc(int i) {
        View findViewWithTag = this.gSU.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(true);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void ud(int i) {
        View findViewWithTag = this.gSU.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(false);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.root;
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
        TextView ezr;
        private ImageView gSX;
        private LinearLayout gSZ;
        TextView mName;
        View mView;

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            this.mView = LayoutInflater.from(e.this.mContext).inflate(d.i.new_user_text_item, (ViewGroup) null);
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
            this.mName = (TextView) this.mView.findViewById(d.g.tv_fname);
            this.ezr = (TextView) this.mView.findViewById(d.g.tv_cdesc);
            this.gSX = (ImageView) this.mView.findViewById(d.g.iv_like);
            this.gSZ = (LinearLayout) this.mView.findViewById(d.g.ll_like);
        }

        public void setIsLike(boolean z) {
            if (!z) {
                this.gSX.setBackgroundDrawable(e.this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_n));
            } else {
                this.gSX.setBackgroundDrawable(e.this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_s));
            }
        }

        private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Drawable drawable;
            initUI();
            this.gSZ.setOnClickListener(onClickListener);
            this.gSZ.setTag(card);
            this.mName.setText(card.getFname());
            if (card.getOrder() == 1) {
                drawable = e.this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_rise);
            } else {
                drawable = card.getOrder() == 2 ? e.this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_decline) : null;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            this.ezr.setText(card.getCdesc());
            setIsLike(card.getIs_like() != 0);
        }
    }
}
