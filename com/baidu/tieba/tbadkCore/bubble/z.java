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
    private ViewGroup bXW;
    private TbImageView bXX;
    private ImageView bXY;
    private ImageView bXZ;
    private ImageView bYa;
    private ImageView bYb;
    private ImageView bYc;
    private ImageView bYd;
    private View bYe;
    private ViewGroup bYf;
    private ViewGroup bYg;
    private TbImageView bYh;
    private TextView bYi;
    private TextView bYj;
    private boolean bYk;
    private Context mContext;

    public void setShowName(boolean z) {
        this.bYk = z;
    }

    public z(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = b.ei().inflate(this.mContext, getXmlLayoutResId(), this);
        this.bXW = (ViewGroup) inflate.findViewById(com.baidu.tieba.w.bubble_layout);
        this.bXX = (TbImageView) inflate.findViewById(com.baidu.tieba.w.bubble_image);
        this.bXY = (ImageView) inflate.findViewById(com.baidu.tieba.w.bubble_iamge_bg);
        this.bXZ = (ImageView) inflate.findViewById(com.baidu.tieba.w.free_tip);
        this.bYa = (ImageView) inflate.findViewById(com.baidu.tieba.w.defualt_tip);
        this.bYb = (ImageView) inflate.findViewById(com.baidu.tieba.w.bubble_notuse_iamge);
        this.bYc = (ImageView) inflate.findViewById(com.baidu.tieba.w.bubble_round_up);
        this.bYd = (ImageView) inflate.findViewById(com.baidu.tieba.w.bubble_round_full);
        this.bYe = inflate.findViewById(com.baidu.tieba.w.bubble_center_line);
        this.bYf = (ViewGroup) inflate.findViewById(com.baidu.tieba.w.bubble_bottom_layout);
        this.bYg = (ViewGroup) inflate.findViewById(com.baidu.tieba.w.has_icon_name);
        this.bYh = (TbImageView) inflate.findViewById(com.baidu.tieba.w.icon_iamge);
        this.bYi = (TextView) inflate.findViewById(com.baidu.tieba.w.bubble_name);
        this.bYj = (TextView) inflate.findViewById(com.baidu.tieba.w.no_icon_name);
    }

    public int getXmlLayoutResId() {
        return com.baidu.tieba.x.bubbleview;
    }

    public void a(BubbleListData.BubbleData bubbleData, boolean z) {
        if (bubbleData != null) {
            if (bubbleData.getBcode() == 0) {
                agT();
                this.bYa.setVisibility(z ? 0 : 8);
                this.bXY.setVisibility(z ? 0 : 8);
                return;
            }
            this.bXW.setVisibility(0);
            this.bYb.setVisibility(8);
            if (bubbleData.isDef()) {
                this.bXY.setVisibility(0);
                this.bYa.setVisibility(0);
            } else {
                this.bXY.setVisibility(8);
                this.bYa.setVisibility(8);
            }
            if (bubbleData.isFree()) {
                this.bXZ.setVisibility(0);
            } else {
                this.bXZ.setVisibility(8);
            }
            if (!TextUtils.isEmpty(bubbleData.getB_url())) {
                this.bXX.setTag(bubbleData.getB_url());
                this.bXX.d(bubbleData.getB_url(), 10, false);
            }
            if (!this.bYk) {
                this.bYe.setVisibility(8);
                this.bYf.setVisibility(8);
                this.bYc.setVisibility(8);
                this.bYd.setVisibility(0);
                return;
            }
            this.bYe.setVisibility(0);
            this.bYf.setVisibility(0);
            this.bYc.setVisibility(0);
            this.bYd.setVisibility(8);
            if (!TextUtils.isEmpty(bubbleData.getIcon_url())) {
                this.bYg.setVisibility(0);
                this.bYj.setVisibility(8);
                this.bYi.setText(bubbleData.getBname());
                this.bYh.setTag(bubbleData.getIcon_url());
                this.bYh.d(bubbleData.getIcon_url(), 10, false);
                return;
            }
            this.bYg.setVisibility(8);
            this.bYj.setVisibility(0);
            this.bYj.setText(bubbleData.getBname());
        }
    }

    public void agT() {
        this.bXW.setVisibility(8);
        this.bYb.setVisibility(0);
        this.bXZ.setVisibility(8);
        if (!this.bYk) {
            this.bYe.setVisibility(8);
            this.bYf.setVisibility(8);
            this.bYc.setVisibility(8);
            this.bYd.setVisibility(0);
            return;
        }
        this.bYe.setVisibility(0);
        this.bYf.setVisibility(0);
        this.bYc.setVisibility(0);
        this.bYd.setVisibility(8);
        this.bYg.setVisibility(8);
        this.bYj.setVisibility(0);
        this.bYj.setText(this.mContext.getString(com.baidu.tieba.z.bubble_notuse_text));
    }

    public void f(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().h(this);
    }
}
