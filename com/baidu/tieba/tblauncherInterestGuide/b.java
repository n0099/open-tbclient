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
import com.baidu.tieba.d;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b extends Dialog implements com.baidu.tieba.tblauncherInterestGuide.a {
    private TextView aGg;
    private View dcL;
    private View iMX;
    private LinearLayout iMY;
    private View.OnClickListener iMZ;
    private LinearLayout iNa;
    private Context mContext;
    private TextView mTitle;

    public b(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.dcL = View.inflate(this.mContext, d.h.new_user_box, null);
        setContentView(this.dcL);
        setCanceledOnTouchOutside(true);
        this.iNa = (LinearLayout) this.dcL.findViewById(d.g.box_close_layout);
        this.mTitle = (TextView) this.dcL.findViewById(d.g.prompt_title);
        this.aGg = (TextView) this.dcL.findViewById(d.g.prompt_sub_title);
        this.iMX = this.dcL.findViewById(d.g.view_layout);
        this.iMY = (LinearLayout) findViewById(d.g.layout_content);
        this.iMX.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.iMZ = onClickListener;
        this.iNa.setOnClickListener(onClickListener);
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
        this.aGg.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View view = new a(card, this.iMZ).getView();
            this.iMY.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds20);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(d.e.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.iMY.addView(LayoutInflater.from(this.mContext).inflate(d.h.new_user_line_item, (ViewGroup) null));
            }
            ((TbImageView) this.iMY.findViewWithTag(card.getAvatar())).startLoad(card.getAvatar(), 10, false);
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(d.e.ds120);
        if ((getContext().getResources().getDimensionPixelSize(d.e.ds140) * card_list.size()) + getContext().getResources().getDimensionPixelSize(d.e.ds188) + getContext().getResources().getDimensionPixelSize(d.e.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void zM(int i) {
        View findViewWithTag = this.iMY.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(true);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void zN(int i) {
        View findViewWithTag = this.iMY.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(false);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.dcL;
    }

    /* loaded from: classes4.dex */
    private class a {
        private TextView fsD;
        private TextView gMZ;
        private ImageView iNb;
        private TbImageView iNc;
        private LinearLayout iNd;
        private TextView mName;
        private View mView;

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            this.mView = LayoutInflater.from(b.this.mContext).inflate(d.h.new_user_rich_item, (ViewGroup) null);
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
            this.fsD = (TextView) this.mView.findViewById(d.g.tv_cdesc);
            this.iNb = (ImageView) this.mView.findViewById(d.g.iv_like);
            this.gMZ = (TextView) this.mView.findViewById(d.g.tv_slogan);
            this.iNc = (TbImageView) this.mView.findViewById(d.g.img);
            this.iNd = (LinearLayout) this.mView.findViewById(d.g.ll_like);
        }

        public void setIsLike(boolean z) {
            if (!z) {
                this.iNb.setBackgroundDrawable(b.this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_n));
            } else {
                this.iNb.setBackgroundDrawable(b.this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_s));
            }
        }

        private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            initUI();
            this.iNd.setOnClickListener(onClickListener);
            this.iNd.setTag(card);
            this.mName.setText(card.getFname());
            this.fsD.setText(card.getCdesc());
            this.gMZ.setText(card.getSlogan());
            this.iNc.setTag(card.getAvatar());
            setIsLike(card.getIs_like() != 0);
        }
    }
}
