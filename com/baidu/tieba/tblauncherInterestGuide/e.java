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
import com.baidu.adp.lib.f.g;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class e extends Dialog implements com.baidu.tieba.tblauncherInterestGuide.a {
    private TextView dxT;
    private View epV;
    private LinearLayout mContent;
    private Context mContext;
    private TextView mTitle;
    private View nzk;
    private View.OnClickListener nzl;
    private LinearLayout nzm;

    public e(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.epV = View.inflate(this.mContext, R.layout.new_user_box, null);
        setContentView(this.epV);
        setCanceledOnTouchOutside(true);
        this.nzm = (LinearLayout) this.epV.findViewById(R.id.box_close_layout);
        this.mTitle = (TextView) this.epV.findViewById(R.id.prompt_title);
        this.dxT = (TextView) this.epV.findViewById(R.id.prompt_sub_title);
        this.nzk = this.epV.findViewById(R.id.view_layout);
        this.mContent = (LinearLayout) this.epV.findViewById(R.id.layout_content);
        this.nzk.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_blue_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.nzl = onClickListener;
        this.nzm.setOnClickListener(onClickListener);
    }

    @Override // android.app.Dialog, com.baidu.tieba.tblauncherInterestGuide.a
    public void show() {
        if (!(this.mContext instanceof Activity) || g.isActivityCanShowDialogOrPopupWindow((Activity) this.mContext)) {
            super.show();
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.mTitle.setText(tag.getBname());
        this.dxT.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            View view = new a(card_list.get(i), this.nzl).getView();
            this.mContent.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds40);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(R.dimen.ds52) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.mContent.addView(LayoutInflater.from(this.mContext).inflate(R.layout.new_user_line_item, (ViewGroup) null));
            }
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(R.dimen.ds120);
        if ((getContext().getResources().getDimensionPixelSize(R.dimen.ds112) * card_list.size()) + getContext().getResources().getDimensionPixelSize(R.dimen.ds188) + getContext().getResources().getDimensionPixelSize(R.dimen.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Lo(int i) {
        View findViewWithTag = this.mContent.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(true);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Lp(int i) {
        View findViewWithTag = this.mContent.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(false);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.epV;
    }

    @Override // android.app.Dialog, com.baidu.tieba.tblauncherInterestGuide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            g.dismissDialog(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    private class a {
        TextView akw;
        private ImageView mImgView;
        TextView mName;
        View mView;
        private LinearLayout nzo;

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            this.mView = LayoutInflater.from(e.this.mContext).inflate(R.layout.new_user_text_item, (ViewGroup) null);
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
            this.mName = (TextView) this.mView.findViewById(R.id.tv_fname);
            this.akw = (TextView) this.mView.findViewById(R.id.tv_cdesc);
            this.mImgView = (ImageView) this.mView.findViewById(R.id.iv_like);
            this.nzo = (LinearLayout) this.mView.findViewById(R.id.ll_like);
        }

        public void setIsLike(boolean z) {
            if (!z) {
                this.mImgView.setBackgroundDrawable(e.this.mContext.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_n));
            } else {
                this.mImgView.setBackgroundDrawable(e.this.mContext.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
            }
        }

        private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Drawable drawable;
            initUI();
            this.nzo.setOnClickListener(onClickListener);
            this.nzo.setTag(card);
            this.mName.setText(card.getFname());
            if (card.getOrder() == 1) {
                drawable = e.this.mContext.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_rise);
            } else {
                drawable = card.getOrder() == 2 ? e.this.mContext.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_decline) : null;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            this.akw.setText(card.getCdesc());
            setIsLike(card.getIs_like() != 0);
        }
    }
}
