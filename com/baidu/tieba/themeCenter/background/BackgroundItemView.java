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
    private View.OnClickListener bdQ;
    private int bft;
    private int bfu;
    private TbImageView crP;
    private TbImageView crQ;
    private TextView crS;
    private i dLR;
    private TbImageView dLq;
    private ImageView dLr;
    private SkinProgressView dMh;
    private DressItemData dMi;
    private Context mContext;
    private View mRootView;

    public BackgroundItemView(Context context) {
        super(context);
        this.bdQ = new j(this);
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdQ = new j(this);
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.bdQ = new j(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bfu = (com.baidu.adp.lib.util.k.K(this.mContext) - com.baidu.adp.lib.util.k.d(this.mContext, n.e.ds88)) / 3;
        this.bft = (int) (this.bfu / 0.66d);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(n.h.background_item, this);
        this.crP = (TbImageView) this.mRootView.findViewById(n.g.bg_image);
        this.crQ = (TbImageView) this.mRootView.findViewById(n.g.permission_icon);
        this.crQ.setDefaultResource(n.f.transparent_bg);
        this.crQ.setDefaultBgResource(n.f.transparent_bg);
        this.dLq = (TbImageView) this.mRootView.findViewById(n.g.state_icon);
        this.dLq.setDefaultResource(n.f.transparent_bg);
        this.dLq.setDefaultBgResource(n.f.transparent_bg);
        this.dLr = (ImageView) this.mRootView.findViewById(n.g.choosed_icon);
        this.crS = (TextView) this.mRootView.findViewById(n.g.text_bg_name);
        this.dMh = (SkinProgressView) this.mRootView.findViewById(n.g.view_bg_use);
        this.dMh.setOnClickListener(this.bdQ);
        this.crP.setOnClickListener(this.bdQ);
        this.crP.setMinimumHeight(this.bft);
        this.crP.setMinimumWidth(this.bfu);
    }

    public void c(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.dMi = dressItemData;
            Boolean valueOf = Boolean.valueOf(dressItemData.getInUse());
            if (dressItemData.getPropsId() == 0) {
                as.c(this.crP, n.f.pic_bg_moren);
            } else {
                this.crP.setImageBitmap(null);
                this.crP.d(dressItemData.getExampleImgUrl(), 10, false);
            }
            this.crS.setText(dressItemData.getTitle());
            if (valueOf.booleanValue()) {
                this.dLr.setVisibility(0);
                as.c(this.dLr, n.f.icon_choose_photo);
            } else {
                this.dLr.setVisibility(8);
            }
            this.crQ.d(dressItemData.getPermissionImgUrl(), 10, false);
            this.dLq.d(dressItemData.getPropsStateImg(), 10, false);
            if (valueOf.booleanValue()) {
                this.dMh.e(0, 0.0f);
            } else {
                this.dMh.e(4, 0.0f);
            }
            setVisibility(0);
        }
    }

    public void hide() {
        setVisibility(8);
    }

    public void setController(i iVar) {
        this.dLR = iVar;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.dMh != null) {
            this.dMh.setListenerTag(bdUniqueId);
        }
    }
}
