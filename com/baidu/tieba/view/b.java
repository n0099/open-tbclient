package com.baidu.tieba.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.BubbleListData;
/* loaded from: classes.dex */
public class b extends RelativeLayout {
    private ViewGroup bQk;
    private TbImageView bQl;
    private ImageView bQm;
    private ImageView bQn;
    private ImageView bQo;
    private ImageView bQp;
    private ImageView bQq;
    private ImageView bQr;
    private View bQs;
    private ViewGroup bQt;
    private ViewGroup bQu;
    private TbImageView bQv;
    private TextView bQw;
    private TextView bQx;
    private boolean bQy;
    private Context mContext;

    public void setShowName(boolean z) {
        this.bQy = z;
    }

    public b(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, getXmlLayoutResId(), this);
        this.bQk = (ViewGroup) inflate.findViewById(com.baidu.tieba.v.bubble_layout);
        this.bQl = (TbImageView) inflate.findViewById(com.baidu.tieba.v.bubble_image);
        this.bQm = (ImageView) inflate.findViewById(com.baidu.tieba.v.bubble_iamge_bg);
        this.bQn = (ImageView) inflate.findViewById(com.baidu.tieba.v.free_tip);
        this.bQo = (ImageView) inflate.findViewById(com.baidu.tieba.v.defualt_tip);
        this.bQp = (ImageView) inflate.findViewById(com.baidu.tieba.v.bubble_notuse_iamge);
        this.bQq = (ImageView) inflate.findViewById(com.baidu.tieba.v.bubble_round_up);
        this.bQr = (ImageView) inflate.findViewById(com.baidu.tieba.v.bubble_round_full);
        this.bQs = inflate.findViewById(com.baidu.tieba.v.bubble_center_line);
        this.bQt = (ViewGroup) inflate.findViewById(com.baidu.tieba.v.bubble_bottom_layout);
        this.bQu = (ViewGroup) inflate.findViewById(com.baidu.tieba.v.has_icon_name);
        this.bQv = (TbImageView) inflate.findViewById(com.baidu.tieba.v.icon_iamge);
        this.bQw = (TextView) inflate.findViewById(com.baidu.tieba.v.bubble_name);
        this.bQx = (TextView) inflate.findViewById(com.baidu.tieba.v.no_icon_name);
    }

    public int getXmlLayoutResId() {
        return com.baidu.tieba.w.bubbleview;
    }

    public void a(BubbleListData.BubbleData bubbleData, boolean z) {
        if (bubbleData != null) {
            if (bubbleData.getBcode() == 0) {
                aeM();
                this.bQo.setVisibility(z ? 0 : 8);
                this.bQm.setVisibility(z ? 0 : 8);
                return;
            }
            this.bQk.setVisibility(0);
            this.bQp.setVisibility(8);
            if (bubbleData.isDef()) {
                this.bQm.setVisibility(0);
                this.bQo.setVisibility(0);
            } else {
                this.bQm.setVisibility(8);
                this.bQo.setVisibility(8);
            }
            if (bubbleData.isFree()) {
                this.bQn.setVisibility(0);
            } else {
                this.bQn.setVisibility(8);
            }
            if (!TextUtils.isEmpty(bubbleData.getB_url())) {
                this.bQl.setTag(bubbleData.getB_url());
                this.bQl.c(bubbleData.getB_url(), 10, false);
            }
            if (!this.bQy) {
                this.bQs.setVisibility(8);
                this.bQt.setVisibility(8);
                this.bQq.setVisibility(8);
                this.bQr.setVisibility(0);
                return;
            }
            this.bQs.setVisibility(0);
            this.bQt.setVisibility(0);
            this.bQq.setVisibility(0);
            this.bQr.setVisibility(8);
            if (!TextUtils.isEmpty(bubbleData.getIcon_url())) {
                this.bQu.setVisibility(0);
                this.bQx.setVisibility(8);
                this.bQw.setText(bubbleData.getBname());
                this.bQv.setTag(bubbleData.getIcon_url());
                this.bQv.c(bubbleData.getIcon_url(), 10, false);
                return;
            }
            this.bQu.setVisibility(8);
            this.bQx.setVisibility(0);
            this.bQx.setText(bubbleData.getBname());
        }
    }

    public void aeM() {
        this.bQk.setVisibility(8);
        this.bQp.setVisibility(0);
        this.bQn.setVisibility(8);
        if (!this.bQy) {
            this.bQs.setVisibility(8);
            this.bQt.setVisibility(8);
            this.bQq.setVisibility(8);
            this.bQr.setVisibility(0);
            return;
        }
        this.bQs.setVisibility(0);
        this.bQt.setVisibility(0);
        this.bQq.setVisibility(0);
        this.bQr.setVisibility(8);
        this.bQu.setVisibility(8);
        this.bQx.setVisibility(0);
        this.bQx.setText(this.mContext.getString(com.baidu.tieba.y.bubble_notuse_text));
    }

    public void nz() {
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).getLayoutMode().L(skinType == 1);
            ((BaseActivity) this.mContext).getLayoutMode().h(this);
        }
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).getLayoutMode().L(skinType == 1);
            ((BaseFragmentActivity) this.mContext).getLayoutMode().h(this);
        }
    }
}
