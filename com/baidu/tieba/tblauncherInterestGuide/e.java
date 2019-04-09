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
/* loaded from: classes4.dex */
public class e extends Dialog implements com.baidu.tieba.tblauncherInterestGuide.a {
    private TextView aGk;
    private View dcQ;
    private View iMM;
    private LinearLayout iMN;
    private View.OnClickListener iMO;
    private LinearLayout iMP;
    private Context mContext;
    private TextView mTitle;

    public e(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.dcQ = View.inflate(this.mContext, d.h.new_user_box, null);
        setContentView(this.dcQ);
        setCanceledOnTouchOutside(true);
        this.iMP = (LinearLayout) this.dcQ.findViewById(d.g.box_close_layout);
        this.mTitle = (TextView) this.dcQ.findViewById(d.g.prompt_title);
        this.aGk = (TextView) this.dcQ.findViewById(d.g.prompt_sub_title);
        this.iMM = this.dcQ.findViewById(d.g.view_layout);
        this.iMN = (LinearLayout) this.dcQ.findViewById(d.g.layout_content);
        this.iMM.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_startpage2_card_blue_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.iMO = onClickListener;
        this.iMP.setOnClickListener(onClickListener);
    }

    @Override // android.app.Dialog, com.baidu.tieba.tblauncherInterestGuide.a
    public void show() {
        if (!(this.mContext instanceof Activity) || g.q((Activity) this.mContext)) {
            super.show();
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.mTitle.setText(tag.getBname());
        this.aGk.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            View view = new a(card_list.get(i), this.iMO).getView();
            this.iMN.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds40);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(d.e.ds52) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.iMN.addView(LayoutInflater.from(this.mContext).inflate(d.h.new_user_line_item, (ViewGroup) null));
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
    public void zI(int i) {
        View findViewWithTag = this.iMN.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(true);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void zJ(int i) {
        View findViewWithTag = this.iMN.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(false);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.dcQ;
    }

    @Override // android.app.Dialog, com.baidu.tieba.tblauncherInterestGuide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            g.b(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    private class a {
        TextView fsp;
        private ImageView iMQ;
        private LinearLayout iMS;
        TextView mName;
        View mView;

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            this.mView = LayoutInflater.from(e.this.mContext).inflate(d.h.new_user_text_item, (ViewGroup) null);
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
            this.fsp = (TextView) this.mView.findViewById(d.g.tv_cdesc);
            this.iMQ = (ImageView) this.mView.findViewById(d.g.iv_like);
            this.iMS = (LinearLayout) this.mView.findViewById(d.g.ll_like);
        }

        public void setIsLike(boolean z) {
            if (!z) {
                this.iMQ.setBackgroundDrawable(e.this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_n));
            } else {
                this.iMQ.setBackgroundDrawable(e.this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_s));
            }
        }

        private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Drawable drawable;
            initUI();
            this.iMS.setOnClickListener(onClickListener);
            this.iMS.setTag(card);
            this.mName.setText(card.getFname());
            if (card.getOrder() == 1) {
                drawable = e.this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_rise);
            } else {
                drawable = card.getOrder() == 2 ? e.this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_decline) : null;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            this.fsp.setText(card.getCdesc());
            setIsLike(card.getIs_like() != 0);
        }
    }
}
