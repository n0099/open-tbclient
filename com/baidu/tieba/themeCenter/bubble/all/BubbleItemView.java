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
    private View.OnClickListener aZT;
    private TbImageView cnM;
    private TbImageView cnN;
    private TbImageView dDM;
    private ImageView dDN;
    private DressItemData dEF;
    private FrameLayout dFr;
    private TextView dFs;
    private a dFt;
    private Context mContext;
    private View mRootView;

    public BubbleItemView(Context context) {
        super(context);
        this.aZT = new b(this);
        this.mContext = context;
        initView();
    }

    public BubbleItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZT = new b(this);
        this.mContext = context;
        initView();
    }

    public BubbleItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.aZT = new b(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(n.g.bubble_item, this);
        this.dFr = (FrameLayout) this.mRootView.findViewById(n.f.ly_bubble);
        this.cnM = (TbImageView) this.mRootView.findViewById(n.f.bg_image);
        this.cnN = (TbImageView) this.mRootView.findViewById(n.f.permission_icon);
        this.cnN.setDefaultResource(n.e.transparent_bg);
        this.cnN.setDefaultBgResource(n.e.transparent_bg);
        this.dDM = (TbImageView) this.mRootView.findViewById(n.f.state_icon);
        this.dDM.setDefaultResource(n.e.transparent_bg);
        this.dDM.setDefaultBgResource(n.e.transparent_bg);
        this.dDN = (ImageView) this.mRootView.findViewById(n.f.choosed_icon);
        this.dFs = new TextView(this.mContext);
        this.cnM.setOnClickListener(this.aZT);
    }

    public void c(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.dEF = dressItemData;
            Boolean valueOf = Boolean.valueOf(dressItemData.getInUse());
            if (dressItemData.isDefault()) {
                this.cnM.setDefaultResource(n.e.icon_choose_no);
                this.cnM.d("", 10, false);
                this.dFs.setText(n.i.default_bubble);
                this.dFs.setGravity(17);
                this.dFs.setTextSize(0, k.d(this.mContext, n.d.ds28));
                this.dFs.setTextColor(getResources().getColor(n.c.cp_cont_c));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                this.dFs.setLayoutParams(layoutParams);
                this.dFs.setVisibility(0);
                this.dFr.removeView(this.dFs);
                this.dFr.addView(this.dFs);
            } else {
                this.dFr.removeView(this.dFs);
                this.cnM.setDefaultResource(n.e.img_default_100);
                this.cnM.d(dressItemData.getExampleImgUrl(), 10, false);
            }
            if (valueOf.booleanValue()) {
                this.dDN.setVisibility(0);
                as.c(this.dDN, n.e.icon_choose_photo);
            } else {
                this.dDN.setVisibility(8);
            }
            this.cnN.d(dressItemData.getPermissionImgUrl(), 10, false);
            this.dDM.d(dressItemData.getPropsStateImg(), 10, false);
            setVisibility(0);
        }
    }

    public void hide() {
        setVisibility(4);
    }

    public void setController(a aVar) {
        this.dFt = aVar;
    }
}
