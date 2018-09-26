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
    private View bES;
    private TextView eQk;
    private View hbG;
    private LinearLayout hbH;
    private View.OnClickListener hbI;
    private LinearLayout hbJ;
    private Context mContext;
    private TextView mTitle;

    public b(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bES = View.inflate(this.mContext, e.h.new_user_box, null);
        setContentView(this.bES);
        setCanceledOnTouchOutside(true);
        this.hbJ = (LinearLayout) this.bES.findViewById(e.g.box_close_layout);
        this.mTitle = (TextView) this.bES.findViewById(e.g.prompt_title);
        this.eQk = (TextView) this.bES.findViewById(e.g.prompt_sub_title);
        this.hbG = this.bES.findViewById(e.g.view_layout);
        this.hbH = (LinearLayout) findViewById(e.g.layout_content);
        this.hbG.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hbI = onClickListener;
        this.hbJ.setOnClickListener(onClickListener);
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
        this.eQk.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View view = new a(card, this.hbI).getView();
            this.hbH.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds20);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.hbH.addView(LayoutInflater.from(this.mContext).inflate(e.h.new_user_line_item, (ViewGroup) null));
            }
            ((TbImageView) this.hbH.findViewWithTag(card.getAvatar())).startLoad(card.getAvatar(), 10, false);
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(e.C0141e.ds120);
        if ((getContext().getResources().getDimensionPixelSize(e.C0141e.ds140) * card_list.size()) + getContext().getResources().getDimensionPixelSize(e.C0141e.ds188) + getContext().getResources().getDimensionPixelSize(e.C0141e.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void uA(int i) {
        View findViewWithTag = this.hbH.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(true);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void uB(int i) {
        View findViewWithTag = this.hbH.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(false);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.bES;
    }

    /* loaded from: classes3.dex */
    private class a {
        private TextView dLk;
        private TextView fdq;
        private ImageView hbK;
        private TbImageView hbL;
        private LinearLayout hbM;
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
            this.dLk = (TextView) this.mView.findViewById(e.g.tv_cdesc);
            this.hbK = (ImageView) this.mView.findViewById(e.g.iv_like);
            this.fdq = (TextView) this.mView.findViewById(e.g.tv_slogan);
            this.hbL = (TbImageView) this.mView.findViewById(e.g.img);
            this.hbM = (LinearLayout) this.mView.findViewById(e.g.ll_like);
        }

        public void setIsLike(boolean z) {
            if (!z) {
                this.hbK.setBackgroundDrawable(b.this.mContext.getResources().getDrawable(e.f.icon_startpage2_add_ba_n));
            } else {
                this.hbK.setBackgroundDrawable(b.this.mContext.getResources().getDrawable(e.f.icon_startpage2_add_ba_s));
            }
        }

        private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            initUI();
            this.hbM.setOnClickListener(onClickListener);
            this.hbM.setTag(card);
            this.mName.setText(card.getFname());
            this.dLk.setText(card.getCdesc());
            this.fdq.setText(card.getSlogan());
            this.hbL.setTag(card.getAvatar());
            setIsLike(card.getIs_like() != 0);
        }
    }
}
