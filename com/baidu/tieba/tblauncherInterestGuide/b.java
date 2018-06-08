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
    private TextView eBp;
    private View gOs;
    private LinearLayout gOt;
    private View.OnClickListener gOu;
    private LinearLayout gOv;
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
        this.gOv = (LinearLayout) this.root.findViewById(d.g.box_close_layout);
        this.mTitle = (TextView) this.root.findViewById(d.g.prompt_title);
        this.eBp = (TextView) this.root.findViewById(d.g.prompt_sub_title);
        this.gOs = this.root.findViewById(d.g.view_layout);
        this.gOt = (LinearLayout) findViewById(d.g.layout_content);
        this.gOs.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gOu = onClickListener;
        this.gOv.setOnClickListener(onClickListener);
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
        this.eBp.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View view = new a(card, this.gOu).getView();
            this.gOt.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds20);
            layoutParams.setMargins(0, i == 0 ? this.mContext.getResources().getDimensionPixelSize(d.e.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.gOt.addView(LayoutInflater.from(this.mContext).inflate(d.i.new_user_line_item, (ViewGroup) null));
            }
            ((TbImageView) this.gOt.findViewWithTag(card.getAvatar())).startLoad(card.getAvatar(), 10, false);
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(d.e.ds120);
        if ((getContext().getResources().getDimensionPixelSize(d.e.ds140) * card_list.size()) + getContext().getResources().getDimensionPixelSize(d.e.ds188) + getContext().getResources().getDimensionPixelSize(d.e.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void tU(int i) {
        View findViewWithTag = this.gOt.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new a(findViewWithTag).setIsLike(true);
        }
    }

    @Override // com.baidu.tieba.tblauncherInterestGuide.a
    public void tV(int i) {
        View findViewWithTag = this.gOt.findViewWithTag(Integer.valueOf(i));
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
        private TextView eOo;
        private TextView evA;
        private ImageView gOw;
        private TbImageView gOx;
        private LinearLayout gOy;
        private TextView mName;
        private View mView;

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            this.mView = LayoutInflater.from(b.this.mContext).inflate(d.i.new_user_rich_item, (ViewGroup) null);
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
            this.evA = (TextView) this.mView.findViewById(d.g.tv_cdesc);
            this.gOw = (ImageView) this.mView.findViewById(d.g.iv_like);
            this.eOo = (TextView) this.mView.findViewById(d.g.tv_slogan);
            this.gOx = (TbImageView) this.mView.findViewById(d.g.img);
            this.gOy = (LinearLayout) this.mView.findViewById(d.g.ll_like);
        }

        public void setIsLike(boolean z) {
            if (!z) {
                this.gOw.setBackgroundDrawable(b.this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_n));
            } else {
                this.gOw.setBackgroundDrawable(b.this.mContext.getResources().getDrawable(d.f.icon_startpage2_add_ba_s));
            }
        }

        private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            initUI();
            this.gOy.setOnClickListener(onClickListener);
            this.gOy.setTag(card);
            this.mName.setText(card.getFname());
            this.evA.setText(card.getCdesc());
            this.eOo.setText(card.getSlogan());
            this.gOx.setTag(card.getAvatar());
            setIsLike(card.getIs_like() != 0);
        }
    }
}
