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
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends Dialog implements com.baidu.tieba.tblauncherInterestGuide.a {
    private View bOg;
    private View hkI;
    private LinearLayout hkJ;
    private View.OnClickListener hkK;
    private LinearLayout hkL;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public b(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bOg = View.inflate(this.mContext, e.h.new_user_box, null);
        setContentView(this.bOg);
        setCanceledOnTouchOutside(true);
        this.hkL = (LinearLayout) this.bOg.findViewById(e.g.box_close_layout);
        this.mTitle = (TextView) this.bOg.findViewById(e.g.prompt_title);
        this.mSubTitle = (TextView) this.bOg.findViewById(e.g.prompt_sub_title);
        this.hkI = this.bOg.findViewById(e.g.view_layout);
        this.hkJ = (LinearLayout) findViewById(e.g.layout_content);
        this.hkI.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hkK = onClickListener;
        this.hkL.setOnClickListener(onClickListener);
    }

    @Override // android.app.Dialog, com.baidu.tieba.tblauncherInterestGuide.a
    public void hide() {
        if (this.mContext instanceof Activity) {
            g.b(this, (Activity) this.mContext);
        } else {
            super.dismiss();
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void a(InterestFrsData.Tag tag) {
        this.mTitle.setText(tag.getBname());
        this.mSubTitle.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View view = new a(card, this.hkK).getView();
            this.hkJ.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds20);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.hkJ.addView(LayoutInflater.from(this.mContext).inflate(e.h.new_user_line_item, (ViewGroup) null));
            }
            ((TbImageView) this.hkJ.findViewWithTag(card.getAvatar())).startLoad(card.getAvatar(), 10, false);
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(e.C0200e.ds120);
        if ((getContext().getResources().getDimensionPixelSize(e.C0200e.ds140) * card_list.size()) + getContext().getResources().getDimensionPixelSize(e.C0200e.ds188) + getContext().getResources().getDimensionPixelSize(e.C0200e.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void vq(int i) {
        View findViewWithTag = this.hkJ.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(true);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void vr(int i) {
        View findViewWithTag = this.hkJ.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(false);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.bOg;
    }

    /* loaded from: classes3.dex */
    private class a {
        private TextView dUn;
        private TextView fmr;
        private ImageView hkM;
        private TbImageView hkN;
        private LinearLayout hkO;
        private TextView mName;
        private View mView;

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            this.mView = LayoutInflater.from(b.this.mContext).inflate(e.h.new_user_rich_item, (ViewGroup) null);
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
            this.mName = (TextView) this.mView.findViewById(e.g.tv_fname);
            this.dUn = (TextView) this.mView.findViewById(e.g.tv_cdesc);
            this.hkM = (ImageView) this.mView.findViewById(e.g.iv_like);
            this.fmr = (TextView) this.mView.findViewById(e.g.tv_slogan);
            this.hkN = (TbImageView) this.mView.findViewById(e.g.img);
            this.hkO = (LinearLayout) this.mView.findViewById(e.g.ll_like);
        }

        public void setIsLike(boolean z) {
            if (!z) {
                this.hkM.setBackgroundDrawable(b.this.mContext.getResources().getDrawable(e.f.icon_startpage2_add_ba_n));
            } else {
                this.hkM.setBackgroundDrawable(b.this.mContext.getResources().getDrawable(e.f.icon_startpage2_add_ba_s));
            }
        }

        private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            initUI();
            this.hkO.setOnClickListener(onClickListener);
            this.hkO.setTag(card);
            this.mName.setText(card.getFname());
            this.dUn.setText(card.getCdesc());
            this.fmr.setText(card.getSlogan());
            this.hkN.setTag(card.getAvatar());
            setIsLike(card.getIs_like() != 0);
        }
    }
}
