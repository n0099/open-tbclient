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
import com.baidu.tieba.f;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends Dialog implements com.baidu.tieba.tblauncherInterestGuide.a {
    private View bzd;
    private TextView eIU;
    private View gTT;
    private LinearLayout gTU;
    private View.OnClickListener gTV;
    private LinearLayout gTW;
    private Context mContext;
    private TextView mTitle;

    public b(Context context, int i) {
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
        this.gTU = (LinearLayout) findViewById(f.g.layout_content);
        this.gTT.setBackgroundDrawable(this.mContext.getResources().getDrawable(f.C0146f.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gTV = onClickListener;
        this.gTW.setOnClickListener(onClickListener);
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
        this.eIU.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View view = new a(card, this.gTV).getView();
            this.gTU.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(f.e.ds20);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(f.e.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.gTU.addView(LayoutInflater.from(this.mContext).inflate(f.h.new_user_line_item, (ViewGroup) null));
            }
            ((TbImageView) this.gTU.findViewWithTag(card.getAvatar())).startLoad(card.getAvatar(), 10, false);
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(f.e.ds120);
        if ((getContext().getResources().getDimensionPixelSize(f.e.ds140) * card_list.size()) + getContext().getResources().getDimensionPixelSize(f.e.ds188) + getContext().getResources().getDimensionPixelSize(f.e.ds100) > dimensionPixelSize2) {
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

    /* loaded from: classes3.dex */
    private class a {
        private TextView eDe;
        private TextView eVV;
        private ImageView gTX;
        private TbImageView gTY;
        private LinearLayout gTZ;
        private TextView mName;
        private View mView;

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            this.mView = LayoutInflater.from(b.this.mContext).inflate(f.h.new_user_rich_item, (ViewGroup) null);
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
            this.eVV = (TextView) this.mView.findViewById(f.g.tv_slogan);
            this.gTY = (TbImageView) this.mView.findViewById(f.g.img);
            this.gTZ = (LinearLayout) this.mView.findViewById(f.g.ll_like);
        }

        public void setIsLike(boolean z) {
            if (!z) {
                this.gTX.setBackgroundDrawable(b.this.mContext.getResources().getDrawable(f.C0146f.icon_startpage2_add_ba_n));
            } else {
                this.gTX.setBackgroundDrawable(b.this.mContext.getResources().getDrawable(f.C0146f.icon_startpage2_add_ba_s));
            }
        }

        private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            initUI();
            this.gTZ.setOnClickListener(onClickListener);
            this.gTZ.setTag(card);
            this.mName.setText(card.getFname());
            this.eDe.setText(card.getCdesc());
            this.eVV.setText(card.getSlogan());
            this.gTY.setTag(card.getAvatar());
            setIsLike(card.getIs_like() != 0);
        }
    }
}
