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
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b extends Dialog implements com.baidu.tieba.tblauncherInterestGuide.a {
    private View bFk;
    private TextView bcf;
    private LinearLayout joA;
    private View.OnClickListener joB;
    private LinearLayout joC;
    private View joz;
    private Context mContext;
    private TextView mTitle;

    public b(Context context, int i) {
        super(context, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.bFk = View.inflate(this.mContext, R.layout.new_user_box, null);
        setContentView(this.bFk);
        setCanceledOnTouchOutside(true);
        this.joC = (LinearLayout) this.bFk.findViewById(R.id.box_close_layout);
        this.mTitle = (TextView) this.bFk.findViewById(R.id.prompt_title);
        this.bcf = (TextView) this.bFk.findViewById(R.id.prompt_sub_title);
        this.joz = this.bFk.findViewById(R.id.view_layout);
        this.joA = (LinearLayout) findViewById(R.id.layout_content);
        this.joz.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.joB = onClickListener;
        this.joC.setOnClickListener(onClickListener);
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
        this.bcf.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View view = new a(card, this.joB).getView();
            this.joA.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(R.dimen.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.joA.addView(LayoutInflater.from(this.mContext).inflate(R.layout.new_user_line_item, (ViewGroup) null));
            }
            ((TbImageView) this.joA.findViewWithTag(card.getAvatar())).startLoad(card.getAvatar(), 10, false);
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(R.dimen.ds120);
        if ((getContext().getResources().getDimensionPixelSize(R.dimen.ds140) * card_list.size()) + getContext().getResources().getDimensionPixelSize(R.dimen.ds188) + getContext().getResources().getDimensionPixelSize(R.dimen.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Ai(int i) {
        View findViewWithTag = this.joA.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(true);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void Aj(int i) {
        View findViewWithTag = this.joA.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(false);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public View getRootView() {
        return this.bFk;
    }

    /* loaded from: classes4.dex */
    private class a {
        private TextView aan;
        private TextView hlf;
        private TbImageView joD;
        private LinearLayout joE;
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
            this.aan = (TextView) this.mView.findViewById(R.id.tv_cdesc);
            this.mImgView = (ImageView) this.mView.findViewById(R.id.iv_like);
            this.hlf = (TextView) this.mView.findViewById(R.id.tv_slogan);
            this.joD = (TbImageView) this.mView.findViewById(R.id.img);
            this.joE = (LinearLayout) this.mView.findViewById(R.id.ll_like);
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
            this.joE.setOnClickListener(onClickListener);
            this.joE.setTag(card);
            this.mName.setText(card.getFname());
            this.aan.setText(card.getCdesc());
            this.hlf.setText(card.getSlogan());
            this.joD.setTag(card.getAvatar());
            setIsLike(card.getIs_like() != 0);
        }
    }
}
