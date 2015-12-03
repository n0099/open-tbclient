package com.baidu.tieba.themeCenter.background;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes.dex */
public class BackgroundItemView extends LinearLayout {
    private View.OnClickListener aZT;
    private int bbu;
    private int bbv;
    private TbImageView cnM;
    private TbImageView cnN;
    private TextView cnP;
    private TbImageView dDM;
    private ImageView dDN;
    private SkinProgressView dEE;
    private DressItemData dEF;
    private i dEn;
    private Context mContext;
    private View mRootView;

    public BackgroundItemView(Context context) {
        super(context);
        this.aZT = new j(this);
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZT = new j(this);
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.aZT = new j(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bbv = (com.baidu.adp.lib.util.k.K(this.mContext) - com.baidu.adp.lib.util.k.d(this.mContext, n.d.ds88)) / 3;
        this.bbu = (int) (this.bbv / 0.66d);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(n.g.background_item, this);
        this.cnM = (TbImageView) this.mRootView.findViewById(n.f.bg_image);
        this.cnN = (TbImageView) this.mRootView.findViewById(n.f.permission_icon);
        this.cnN.setDefaultResource(n.e.transparent_bg);
        this.cnN.setDefaultBgResource(n.e.transparent_bg);
        this.dDM = (TbImageView) this.mRootView.findViewById(n.f.state_icon);
        this.dDM.setDefaultResource(n.e.transparent_bg);
        this.dDM.setDefaultBgResource(n.e.transparent_bg);
        this.dDN = (ImageView) this.mRootView.findViewById(n.f.choosed_icon);
        this.cnP = (TextView) this.mRootView.findViewById(n.f.text_bg_name);
        this.dEE = (SkinProgressView) this.mRootView.findViewById(n.f.view_bg_use);
        this.dEE.setOnClickListener(this.aZT);
        this.cnM.setOnClickListener(this.aZT);
        this.cnM.setMinimumHeight(this.bbu);
        this.cnM.setMinimumWidth(this.bbv);
    }

    public void c(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.dEF = dressItemData;
            Boolean valueOf = Boolean.valueOf(dressItemData.getInUse());
            if (dressItemData.getPropsId() == 0) {
                as.c(this.cnM, n.e.pic_bg_moren);
            } else {
                this.cnM.setImageBitmap(null);
                this.cnM.d(dressItemData.getExampleImgUrl(), 10, false);
            }
            this.cnP.setText(dressItemData.getTitle());
            if (valueOf.booleanValue()) {
                this.dDN.setVisibility(0);
                as.c(this.dDN, n.e.icon_choose_photo);
            } else {
                this.dDN.setVisibility(8);
            }
            this.cnN.d(dressItemData.getPermissionImgUrl(), 10, false);
            this.dDM.d(dressItemData.getPropsStateImg(), 10, false);
            if (valueOf.booleanValue()) {
                this.dEE.e(0, 0.0f);
            } else {
                this.dEE.e(4, 0.0f);
            }
            setVisibility(0);
        }
    }

    public void hide() {
        setVisibility(8);
    }

    public void setController(i iVar) {
        this.dEn = iVar;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.dEE != null) {
            this.dEE.setListenerTag(bdUniqueId);
        }
    }
}
