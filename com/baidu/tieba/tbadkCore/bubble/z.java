package com.baidu.tieba.tbadkCore.bubble;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.bubble.BubbleListData;
/* loaded from: classes.dex */
public class z extends RelativeLayout {
    private ViewGroup bXX;
    private TbImageView bXY;
    private ImageView bXZ;
    private ImageView bYa;
    private ImageView bYb;
    private ImageView bYc;
    private ImageView bYd;
    private ImageView bYe;
    private View bYf;
    private ViewGroup bYg;
    private ViewGroup bYh;
    private TbImageView bYi;
    private TextView bYj;
    private TextView bYk;
    private boolean bYl;
    private Context mContext;

    public void setShowName(boolean z) {
        this.bYl = z;
    }

    public z(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = b.ei().inflate(this.mContext, getXmlLayoutResId(), this);
        this.bXX = (ViewGroup) inflate.findViewById(com.baidu.tieba.w.bubble_layout);
        this.bXY = (TbImageView) inflate.findViewById(com.baidu.tieba.w.bubble_image);
        this.bXZ = (ImageView) inflate.findViewById(com.baidu.tieba.w.bubble_iamge_bg);
        this.bYa = (ImageView) inflate.findViewById(com.baidu.tieba.w.free_tip);
        this.bYb = (ImageView) inflate.findViewById(com.baidu.tieba.w.defualt_tip);
        this.bYc = (ImageView) inflate.findViewById(com.baidu.tieba.w.bubble_notuse_iamge);
        this.bYd = (ImageView) inflate.findViewById(com.baidu.tieba.w.bubble_round_up);
        this.bYe = (ImageView) inflate.findViewById(com.baidu.tieba.w.bubble_round_full);
        this.bYf = inflate.findViewById(com.baidu.tieba.w.bubble_center_line);
        this.bYg = (ViewGroup) inflate.findViewById(com.baidu.tieba.w.bubble_bottom_layout);
        this.bYh = (ViewGroup) inflate.findViewById(com.baidu.tieba.w.has_icon_name);
        this.bYi = (TbImageView) inflate.findViewById(com.baidu.tieba.w.icon_iamge);
        this.bYj = (TextView) inflate.findViewById(com.baidu.tieba.w.bubble_name);
        this.bYk = (TextView) inflate.findViewById(com.baidu.tieba.w.no_icon_name);
    }

    public int getXmlLayoutResId() {
        return com.baidu.tieba.x.bubbleview;
    }

    public void a(BubbleListData.BubbleData bubbleData, boolean z) {
        if (bubbleData != null) {
            if (bubbleData.getBcode() == 0) {
                agY();
                this.bYb.setVisibility(z ? 0 : 8);
                this.bXZ.setVisibility(z ? 0 : 8);
                return;
            }
            this.bXX.setVisibility(0);
            this.bYc.setVisibility(8);
            if (bubbleData.isDef()) {
                this.bXZ.setVisibility(0);
                this.bYb.setVisibility(0);
            } else {
                this.bXZ.setVisibility(8);
                this.bYb.setVisibility(8);
            }
            if (bubbleData.isFree()) {
                this.bYa.setVisibility(0);
            } else {
                this.bYa.setVisibility(8);
            }
            if (!TextUtils.isEmpty(bubbleData.getB_url())) {
                this.bXY.setTag(bubbleData.getB_url());
                this.bXY.d(bubbleData.getB_url(), 10, false);
            }
            if (!this.bYl) {
                this.bYf.setVisibility(8);
                this.bYg.setVisibility(8);
                this.bYd.setVisibility(8);
                this.bYe.setVisibility(0);
                return;
            }
            this.bYf.setVisibility(0);
            this.bYg.setVisibility(0);
            this.bYd.setVisibility(0);
            this.bYe.setVisibility(8);
            if (!TextUtils.isEmpty(bubbleData.getIcon_url())) {
                this.bYh.setVisibility(0);
                this.bYk.setVisibility(8);
                this.bYj.setText(bubbleData.getBname());
                this.bYi.setTag(bubbleData.getIcon_url());
                this.bYi.d(bubbleData.getIcon_url(), 10, false);
                return;
            }
            this.bYh.setVisibility(8);
            this.bYk.setVisibility(0);
            this.bYk.setText(bubbleData.getBname());
        }
    }

    public void agY() {
        this.bXX.setVisibility(8);
        this.bYc.setVisibility(0);
        this.bYa.setVisibility(8);
        if (!this.bYl) {
            this.bYf.setVisibility(8);
            this.bYg.setVisibility(8);
            this.bYd.setVisibility(8);
            this.bYe.setVisibility(0);
            return;
        }
        this.bYf.setVisibility(0);
        this.bYg.setVisibility(0);
        this.bYd.setVisibility(0);
        this.bYe.setVisibility(8);
        this.bYh.setVisibility(8);
        this.bYk.setVisibility(0);
        this.bYk.setText(this.mContext.getString(com.baidu.tieba.z.bubble_notuse_text));
    }

    public void f(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().h(this);
    }
}
