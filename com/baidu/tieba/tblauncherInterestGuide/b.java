package com.baidu.tieba.tblauncherInterestGuide;

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
import com.baidu.adp.lib.f.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b extends Dialog implements com.baidu.tieba.tblauncherInterestGuide.a {
    private TextView dtg;
    private View elg;
    private LinearLayout mContent;
    private Context mContext;
    private TextView mTitle;
    private View nuE;
    private View.OnClickListener nuF;
    private LinearLayout nuG;

    public b(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.elg = View.inflate(this.mContext, R.layout.new_user_box, null);
        setContentView(this.elg);
        setCanceledOnTouchOutside(true);
        this.nuG = (LinearLayout) this.elg.findViewById(R.id.box_close_layout);
        this.mTitle = (TextView) this.elg.findViewById(R.id.prompt_title);
        this.dtg = (TextView) this.elg.findViewById(R.id.prompt_sub_title);
        this.nuE = this.elg.findViewById(R.id.view_layout);
        this.mContent = (LinearLayout) findViewById(R.id.layout_content);
        this.nuE.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.nuF = onClickListener;
        this.nuG.setOnClickListener(onClickListener);
    }

    @Override // android.app.Dialog, com.baidu.tieba.tblauncherInterestGuide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            g.dismissDialog(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.mTitle.setText(tag.getBname());
        this.dtg.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View view = new a(card, this.nuF).getView();
            this.mContent.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(R.dimen.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.mContent.addView(LayoutInflater.from(this.mContext).inflate(R.layout.new_user_line_item, (ViewGroup) null));
            }
            ((TbImageView) this.mContent.findViewWithTag(card.getAvatar())).startLoad(card.getAvatar(), 10, false);
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(R.dimen.ds120);
        if ((getContext().getResources().getDimensionPixelSize(R.dimen.ds140) * card_list.size()) + getContext().getResources().getDimensionPixelSize(R.dimen.ds188) + getContext().getResources().getDimensionPixelSize(R.dimen.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void JH(int i) {
        View findViewWithTag = this.mContent.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(true);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void JI(int i) {
        View findViewWithTag = this.mContent.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(false);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.elg;
    }

    /* loaded from: classes2.dex */
    private class a {
        private TextView ajF;
        private TextView lav;
        private ImageView mImgView;
        private TextView mName;
        private View mView;
        private TbImageView nuH;
        private LinearLayout nuI;

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            this.mView = LayoutInflater.from(b.this.mContext).inflate(R.layout.new_user_rich_item, (ViewGroup) null);
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
            this.ajF = (TextView) this.mView.findViewById(R.id.tv_cdesc);
            this.mImgView = (ImageView) this.mView.findViewById(R.id.iv_like);
            this.lav = (TextView) this.mView.findViewById(R.id.tv_slogan);
            this.nuH = (TbImageView) this.mView.findViewById(R.id.img);
            this.nuI = (LinearLayout) this.mView.findViewById(R.id.ll_like);
        }

        public void setIsLike(boolean z) {
            if (!z) {
                this.mImgView.setBackgroundDrawable(b.this.mContext.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_n));
            } else {
                this.mImgView.setBackgroundDrawable(b.this.mContext.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
            }
        }

        private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            initUI();
            this.nuI.setOnClickListener(onClickListener);
            this.nuI.setTag(card);
            this.mName.setText(card.getFname());
            this.ajF.setText(card.getCdesc());
            this.lav.setText(card.getSlogan());
            this.nuH.setTag(card.getAvatar());
            setIsLike(card.getIs_like() != 0);
        }
    }
}
