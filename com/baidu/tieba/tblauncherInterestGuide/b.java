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
/* loaded from: classes3.dex */
public class b extends Dialog implements com.baidu.tieba.tblauncherInterestGuide.a {
    private TextView eoS;
    private View gBQ;
    private LinearLayout gBR;
    private View.OnClickListener gBS;
    private LinearLayout gBT;
    private Context mContext;
    private TextView mTitle;
    private View root;

    public b(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.root = View.inflate(this.mContext, d.i.new_user_box, null);
        setContentView(this.root);
        setCanceledOnTouchOutside(true);
        this.gBT = (LinearLayout) this.root.findViewById(d.g.box_close_layout);
        this.mTitle = (TextView) this.root.findViewById(d.g.prompt_title);
        this.eoS = (TextView) this.root.findViewById(d.g.prompt_sub_title);
        this.gBQ = this.root.findViewById(d.g.view_layout);
        this.gBR = (LinearLayout) findViewById(d.g.layout_content);
        this.gBQ.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gBS = onClickListener;
        this.gBT.setOnClickListener(onClickListener);
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
        this.eoS.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View view2 = new a(card, this.gBS).getView();
            this.gBR.addView(view2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds20);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(d.e.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            view2.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.gBR.addView(LayoutInflater.from(this.mContext).inflate(d.i.new_user_line_item, (ViewGroup) null));
            }
            ((TbImageView) this.gBR.findViewWithTag(card.getAvatar())).startLoad(card.getAvatar(), 10, false);
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(d.e.ds120);
        if ((getContext().getResources().getDimensionPixelSize(d.e.ds140) * card_list.size()) + getContext().getResources().getDimensionPixelSize(d.e.ds188) + getContext().getResources().getDimensionPixelSize(d.e.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void tJ(int i) {
        View findViewWithTag = this.gBR.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(true);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void tK(int i) {
        View findViewWithTag = this.gBR.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(false);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.root;
    }

    /* loaded from: classes3.dex */
    private class a {
        private TextView eBP;
        private TextView ejf;
        private ImageView gBU;
        private TbImageView gBV;
        private LinearLayout gBW;
        private TextView mName;
        private View mView;

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            this.mView = LayoutInflater.from(b.this.mContext).inflate(d.i.new_user_rich_item, (ViewGroup) null);
            this.mView.setTag(Integer.valueOf(card.getFid()));
            a(card, onClickListener);
        }

        public a(View view2) {
            this.mView = view2;
            initUI();
        }

        public View getView() {
            return this.mView;
        }

        public void initUI() {
            this.mName = (TextView) this.mView.findViewById(d.g.tv_fname);
            this.ejf = (TextView) this.mView.findViewById(d.g.tv_cdesc);
            this.gBU = (ImageView) this.mView.findViewById(d.g.iv_like);
            this.eBP = (TextView) this.mView.findViewById(d.g.tv_slogan);
            this.gBV = (TbImageView) this.mView.findViewById(d.g.img);
            this.gBW = (LinearLayout) this.mView.findViewById(d.g.ll_like);
        }

        public void setIsLike(boolean z) {
            if (!z) {
                this.gBU.setBackgroundDrawable(b.this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_n));
            } else {
                this.gBU.setBackgroundDrawable(b.this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_s));
            }
        }

        private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            initUI();
            this.gBW.setOnClickListener(onClickListener);
            this.gBW.setTag(card);
            this.mName.setText(card.getFname());
            this.ejf.setText(card.getCdesc());
            this.eBP.setText(card.getSlogan());
            this.gBV.setTag(card.getAvatar());
            setIsLike(card.getIs_like() != 0);
        }
    }
}
