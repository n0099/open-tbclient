package com.baidu.tieba.themeCenter.background;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes.dex */
public class BackgroundItemView extends LinearLayout {
    private View.OnClickListener aUm;
    private TbImageView ddX;
    private TbImageView ddY;
    private ImageView ddZ;
    private i deA;
    private TbImageView deU;
    private SkinProgressView deV;
    private DressItemData deW;
    private TextView deb;
    private Context mContext;
    private View mRootView;

    public BackgroundItemView(Context context) {
        super(context);
        this.aUm = new j(this);
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aUm = new j(this);
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.aUm = new j(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(i.g.background_item, this);
        this.deU = (TbImageView) this.mRootView.findViewById(i.f.bg_image);
        this.ddX = (TbImageView) this.mRootView.findViewById(i.f.permission_icon);
        this.ddX.setDefaultResource(i.e.transparent_bg);
        this.ddX.setDefaultBgResource(i.e.transparent_bg);
        this.ddY = (TbImageView) this.mRootView.findViewById(i.f.state_icon);
        this.ddY.setDefaultResource(i.e.transparent_bg);
        this.ddY.setDefaultBgResource(i.e.transparent_bg);
        this.ddZ = (ImageView) this.mRootView.findViewById(i.f.choosed_icon);
        this.deb = (TextView) this.mRootView.findViewById(i.f.text_bg_name);
        this.deV = (SkinProgressView) this.mRootView.findViewById(i.f.view_bg_use);
        this.deV.setOnClickListener(this.aUm);
        this.deU.setOnClickListener(this.aUm);
    }

    public void b(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.deW = dressItemData;
            Boolean valueOf = Boolean.valueOf(dressItemData.getInUse());
            this.deU.d(dressItemData.getExampleImgUrl(), 10, false);
            this.deb.setText(dressItemData.getTitle());
            if (valueOf.booleanValue()) {
                this.ddZ.setVisibility(0);
                am.c(this.ddZ, i.e.icon_choose_photo);
            } else {
                this.ddZ.setVisibility(8);
            }
            this.ddX.d(dressItemData.getPermissionImgUrl(), 10, false);
            this.ddY.d(dressItemData.getPropsStateImg(), 10, false);
            if (valueOf.booleanValue()) {
                this.deV.e(0, 0.0f);
            } else {
                this.deV.e(4, 0.0f);
            }
            setVisibility(0);
        }
    }

    public void hide() {
        setVisibility(8);
    }

    public void setController(i iVar) {
        this.deA = iVar;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.deV != null) {
            this.deV.setListenerTag(bdUniqueId);
        }
    }
}
