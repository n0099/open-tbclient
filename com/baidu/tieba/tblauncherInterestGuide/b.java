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
    private TextView aGj;
    private View dcP;
    private View iML;
    private LinearLayout iMM;
    private View.OnClickListener iMN;
    private LinearLayout iMO;
    private Context mContext;
    private TextView mTitle;

    public b(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.dcP = View.inflate(this.mContext, d.h.new_user_box, null);
        setContentView(this.dcP);
        setCanceledOnTouchOutside(true);
        this.iMO = (LinearLayout) this.dcP.findViewById(d.g.box_close_layout);
        this.mTitle = (TextView) this.dcP.findViewById(d.g.prompt_title);
        this.aGj = (TextView) this.dcP.findViewById(d.g.prompt_sub_title);
        this.iML = this.dcP.findViewById(d.g.view_layout);
        this.iMM = (LinearLayout) findViewById(d.g.layout_content);
        this.iML.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.iMN = onClickListener;
        this.iMO.setOnClickListener(onClickListener);
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
        this.aGj.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View view = new a(card, this.iMN).getView();
            this.iMM.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds20);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(d.e.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.iMM.addView(LayoutInflater.from(this.mContext).inflate(d.h.new_user_line_item, (ViewGroup) null));
            }
            ((TbImageView) this.iMM.findViewWithTag(card.getAvatar())).startLoad(card.getAvatar(), 10, false);
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(d.e.ds120);
        if ((getContext().getResources().getDimensionPixelSize(d.e.ds140) * card_list.size()) + getContext().getResources().getDimensionPixelSize(d.e.ds188) + getContext().getResources().getDimensionPixelSize(d.e.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void zI(int i) {
        View findViewWithTag = this.iMM.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(true);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void zJ(int i) {
        View findViewWithTag = this.iMM.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(false);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.dcP;
    }

    /* loaded from: classes4.dex */
    private class a {
        private TextView fsp;
        private TextView gMM;
        private ImageView iMP;
        private TbImageView iMQ;
        private LinearLayout iMR;
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
            this.fsp = (TextView) this.mView.findViewById(d.g.tv_cdesc);
            this.iMP = (ImageView) this.mView.findViewById(d.g.iv_like);
            this.gMM = (TextView) this.mView.findViewById(d.g.tv_slogan);
            this.iMQ = (TbImageView) this.mView.findViewById(d.g.img);
            this.iMR = (LinearLayout) this.mView.findViewById(d.g.ll_like);
        }

        public void setIsLike(boolean z) {
            if (!z) {
                this.iMP.setBackgroundDrawable(b.this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_n));
            } else {
                this.iMP.setBackgroundDrawable(b.this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_s));
            }
        }

        private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            initUI();
            this.iMR.setOnClickListener(onClickListener);
            this.iMR.setTag(card);
            this.mName.setText(card.getFname());
            this.fsp.setText(card.getCdesc());
            this.gMM.setText(card.getSlogan());
            this.iMQ.setTag(card.getAvatar());
            setIsLike(card.getIs_like() != 0);
        }
    }
}
