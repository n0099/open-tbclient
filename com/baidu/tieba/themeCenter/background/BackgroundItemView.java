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
    private View.OnClickListener aUF;
    private i dgG;
    private TbImageView dgd;
    private TbImageView dge;
    private ImageView dgf;
    private TextView dgh;
    private TbImageView dha;
    private SkinProgressView dhb;
    private DressItemData dhc;
    private Context mContext;
    private View mRootView;

    public BackgroundItemView(Context context) {
        super(context);
        this.aUF = new j(this);
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aUF = new j(this);
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.aUF = new j(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(i.g.background_item, this);
        this.dha = (TbImageView) this.mRootView.findViewById(i.f.bg_image);
        this.dgd = (TbImageView) this.mRootView.findViewById(i.f.permission_icon);
        this.dgd.setDefaultResource(i.e.transparent_bg);
        this.dgd.setDefaultBgResource(i.e.transparent_bg);
        this.dge = (TbImageView) this.mRootView.findViewById(i.f.state_icon);
        this.dge.setDefaultResource(i.e.transparent_bg);
        this.dge.setDefaultBgResource(i.e.transparent_bg);
        this.dgf = (ImageView) this.mRootView.findViewById(i.f.choosed_icon);
        this.dgh = (TextView) this.mRootView.findViewById(i.f.text_bg_name);
        this.dhb = (SkinProgressView) this.mRootView.findViewById(i.f.view_bg_use);
        this.dhb.setOnClickListener(this.aUF);
        this.dha.setOnClickListener(this.aUF);
    }

    public void b(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.dhc = dressItemData;
            Boolean valueOf = Boolean.valueOf(dressItemData.getInUse());
            this.dha.d(dressItemData.getExampleImgUrl(), 10, false);
            this.dgh.setText(dressItemData.getTitle());
            if (valueOf.booleanValue()) {
                this.dgf.setVisibility(0);
                an.c(this.dgf, i.e.icon_choose_photo);
            } else {
                this.dgf.setVisibility(8);
            }
            this.dgd.d(dressItemData.getPermissionImgUrl(), 10, false);
            this.dge.d(dressItemData.getPropsStateImg(), 10, false);
            if (valueOf.booleanValue()) {
                this.dhb.e(0, 0.0f);
            } else {
                this.dhb.e(4, 0.0f);
            }
            setVisibility(0);
        }
    }

    public void hide() {
        setVisibility(8);
    }

    public void setController(i iVar) {
        this.dgG = iVar;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.dhb != null) {
            this.dhb.setListenerTag(bdUniqueId);
        }
    }
}
