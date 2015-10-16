package com.baidu.tieba.themeCenter.background;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes.dex */
public class BackgroundItemView extends LinearLayout {
    private View.OnClickListener aUx;
    private TextView deB;
    private TbImageView dex;
    private TbImageView dey;
    private ImageView dez;
    private i dfa;
    private TbImageView dfu;
    private SkinProgressView dfv;
    private DressItemData dfw;
    private Context mContext;
    private View mRootView;

    public BackgroundItemView(Context context) {
        super(context);
        this.aUx = new j(this);
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aUx = new j(this);
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.aUx = new j(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(i.g.background_item, this);
        this.dfu = (TbImageView) this.mRootView.findViewById(i.f.bg_image);
        this.dex = (TbImageView) this.mRootView.findViewById(i.f.permission_icon);
        this.dex.setDefaultResource(i.e.transparent_bg);
        this.dex.setDefaultBgResource(i.e.transparent_bg);
        this.dey = (TbImageView) this.mRootView.findViewById(i.f.state_icon);
        this.dey.setDefaultResource(i.e.transparent_bg);
        this.dey.setDefaultBgResource(i.e.transparent_bg);
        this.dez = (ImageView) this.mRootView.findViewById(i.f.choosed_icon);
        this.deB = (TextView) this.mRootView.findViewById(i.f.text_bg_name);
        this.dfv = (SkinProgressView) this.mRootView.findViewById(i.f.view_bg_use);
        this.dfv.setOnClickListener(this.aUx);
        this.dfu.setOnClickListener(this.aUx);
    }

    public void b(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.dfw = dressItemData;
            Boolean valueOf = Boolean.valueOf(dressItemData.getInUse());
            this.dfu.d(dressItemData.getExampleImgUrl(), 10, false);
            this.deB.setText(dressItemData.getTitle());
            if (valueOf.booleanValue()) {
                this.dez.setVisibility(0);
                an.c(this.dez, i.e.icon_choose_photo);
            } else {
                this.dez.setVisibility(8);
            }
            this.dex.d(dressItemData.getPermissionImgUrl(), 10, false);
            this.dey.d(dressItemData.getPropsStateImg(), 10, false);
            if (valueOf.booleanValue()) {
                this.dfv.e(0, 0.0f);
            } else {
                this.dfv.e(4, 0.0f);
            }
            setVisibility(0);
        }
    }

    public void hide() {
        setVisibility(8);
    }

    public void setController(i iVar) {
        this.dfa = iVar;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.dfv != null) {
            this.dfv.setListenerTag(bdUniqueId);
        }
    }
}
