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
    private TextView eoP;
    private View gBN;
    private LinearLayout gBO;
    private View.OnClickListener gBP;
    private LinearLayout gBQ;
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
        this.gBQ = (LinearLayout) this.root.findViewById(d.g.box_close_layout);
        this.mTitle = (TextView) this.root.findViewById(d.g.prompt_title);
        this.eoP = (TextView) this.root.findViewById(d.g.prompt_sub_title);
        this.gBN = this.root.findViewById(d.g.view_layout);
        this.gBO = (LinearLayout) findViewById(d.g.layout_content);
        this.gBN.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gBP = onClickListener;
        this.gBQ.setOnClickListener(onClickListener);
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
        this.eoP.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View view2 = new a(card, this.gBP).getView();
            this.gBO.addView(view2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds20);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(d.e.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            view2.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.gBO.addView(LayoutInflater.from(this.mContext).inflate(d.i.new_user_line_item, (ViewGroup) null));
            }
            ((TbImageView) this.gBO.findViewWithTag(card.getAvatar())).startLoad(card.getAvatar(), 10, false);
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
        View findViewWithTag = this.gBO.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(true);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void tK(int i) {
        View findViewWithTag = this.gBO.findViewWithTag(Integer.valueOf(i));
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
        private TextView eBM;
        private TextView ejc;
        private ImageView gBR;
        private TbImageView gBS;
        private LinearLayout gBT;
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
            this.ejc = (TextView) this.mView.findViewById(d.g.tv_cdesc);
            this.gBR = (ImageView) this.mView.findViewById(d.g.iv_like);
            this.eBM = (TextView) this.mView.findViewById(d.g.tv_slogan);
            this.gBS = (TbImageView) this.mView.findViewById(d.g.img);
            this.gBT = (LinearLayout) this.mView.findViewById(d.g.ll_like);
        }

        public void setIsLike(boolean z) {
            if (!z) {
                this.gBR.setBackgroundDrawable(b.this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_n));
            } else {
                this.gBR.setBackgroundDrawable(b.this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_s));
            }
        }

        private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            initUI();
            this.gBT.setOnClickListener(onClickListener);
            this.gBT.setTag(card);
            this.mName.setText(card.getFname());
            this.ejc.setText(card.getCdesc());
            this.eBM.setText(card.getSlogan());
            this.gBS.setTag(card.getAvatar());
            setIsLike(card.getIs_like() != 0);
        }
    }
}
