package com.baidu.tieba.themeCenter.bubble.all;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes.dex */
public class BubbleItemView extends LinearLayout {
    private View.OnClickListener bdQ;
    private TbImageView crP;
    private TbImageView crQ;
    private TbImageView dLq;
    private ImageView dLr;
    private FrameLayout dMT;
    private TextView dMU;
    private a dMV;
    private DressItemData dMi;
    private Context mContext;
    private View mRootView;

    public BubbleItemView(Context context) {
        super(context);
        this.bdQ = new b(this);
        this.mContext = context;
        initView();
    }

    public BubbleItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdQ = new b(this);
        this.mContext = context;
        initView();
    }

    public BubbleItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.bdQ = new b(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(n.h.bubble_item, this);
        this.dMT = (FrameLayout) this.mRootView.findViewById(n.g.ly_bubble);
        this.crP = (TbImageView) this.mRootView.findViewById(n.g.bg_image);
        this.crQ = (TbImageView) this.mRootView.findViewById(n.g.permission_icon);
        this.crQ.setDefaultResource(n.f.transparent_bg);
        this.crQ.setDefaultBgResource(n.f.transparent_bg);
        this.dLq = (TbImageView) this.mRootView.findViewById(n.g.state_icon);
        this.dLq.setDefaultResource(n.f.transparent_bg);
        this.dLq.setDefaultBgResource(n.f.transparent_bg);
        this.dLr = (ImageView) this.mRootView.findViewById(n.g.choosed_icon);
        this.dMU = new TextView(this.mContext);
        this.crP.setOnClickListener(this.bdQ);
    }

    public void c(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.dMi = dressItemData;
            Boolean valueOf = Boolean.valueOf(dressItemData.getInUse());
            if (dressItemData.isDefault()) {
                this.crP.setDefaultResource(n.f.icon_choose_no);
                this.crP.d("", 10, false);
                this.dMU.setText(n.j.default_bubble);
                this.dMU.setGravity(17);
                this.dMU.setTextSize(0, k.d(this.mContext, n.e.ds28));
                this.dMU.setTextColor(getResources().getColor(n.d.cp_cont_c));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                this.dMU.setLayoutParams(layoutParams);
                this.dMU.setVisibility(0);
                this.dMT.removeView(this.dMU);
                this.dMT.addView(this.dMU);
            } else {
                this.dMT.removeView(this.dMU);
                this.crP.setDefaultResource(n.f.img_default_100);
                this.crP.d(dressItemData.getExampleImgUrl(), 10, false);
            }
            if (valueOf.booleanValue()) {
                this.dLr.setVisibility(0);
                as.c(this.dLr, n.f.icon_choose_photo);
            } else {
                this.dLr.setVisibility(8);
            }
            this.crQ.d(dressItemData.getPermissionImgUrl(), 10, false);
            this.dLq.d(dressItemData.getPropsStateImg(), 10, false);
            setVisibility(0);
        }
    }

    public void hide() {
        setVisibility(4);
    }

    public void setController(a aVar) {
        this.dMV = aVar;
    }
}
