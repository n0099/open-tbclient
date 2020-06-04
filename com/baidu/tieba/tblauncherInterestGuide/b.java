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
/* loaded from: classes9.dex */
public class b extends Dialog implements com.baidu.tieba.tblauncherInterestGuide.a {
    private View dex;
    private View ltl;
    private LinearLayout ltm;
    private View.OnClickListener ltn;
    private LinearLayout lto;
    private Context mContext;
    private TextView mSubTitle;
    private TextView mTitle;

    public b(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.dex = View.inflate(this.mContext, R.layout.new_user_box, null);
        setContentView(this.dex);
        setCanceledOnTouchOutside(true);
        this.lto = (LinearLayout) this.dex.findViewById(R.id.box_close_layout);
        this.mTitle = (TextView) this.dex.findViewById(R.id.prompt_title);
        this.mSubTitle = (TextView) this.dex.findViewById(R.id.prompt_sub_title);
        this.ltl = this.dex.findViewById(R.id.view_layout);
        this.ltm = (LinearLayout) findViewById(R.id.layout_content);
        this.ltl.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ltn = onClickListener;
        this.lto.setOnClickListener(onClickListener);
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
        this.mSubTitle.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View view = new a(card, this.ltn).getView();
            this.ltm.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(R.dimen.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.ltm.addView(LayoutInflater.from(this.mContext).inflate(R.layout.new_user_line_item, (ViewGroup) null));
            }
            ((TbImageView) this.ltm.findViewWithTag(card.getAvatar())).startLoad(card.getAvatar(), 10, false);
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(R.dimen.ds120);
        if ((getContext().getResources().getDimensionPixelSize(R.dimen.ds140) * card_list.size()) + getContext().getResources().getDimensionPixelSize(R.dimen.ds188) + getContext().getResources().getDimensionPixelSize(R.dimen.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Eo(int i) {
        View findViewWithTag = this.ltm.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(true);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Ep(int i) {
        View findViewWithTag = this.ltm.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(false);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.dex;
    }

    /* loaded from: classes9.dex */
    private class a {
        private TextView aJn;
        private TextView jgu;
        private TbImageView ltp;
        private LinearLayout ltq;
        private ImageView mImgView;
        private TextView mName;
        private View mView;

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
            this.aJn = (TextView) this.mView.findViewById(R.id.tv_cdesc);
            this.mImgView = (ImageView) this.mView.findViewById(R.id.iv_like);
            this.jgu = (TextView) this.mView.findViewById(R.id.tv_slogan);
            this.ltp = (TbImageView) this.mView.findViewById(R.id.img);
            this.ltq = (LinearLayout) this.mView.findViewById(R.id.ll_like);
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
            this.ltq.setOnClickListener(onClickListener);
            this.ltq.setTag(card);
            this.mName.setText(card.getFname());
            this.aJn.setText(card.getCdesc());
            this.jgu.setText(card.getSlogan());
            this.ltp.setTag(card.getAvatar());
            setIsLike(card.getIs_like() != 0);
        }
    }
}
