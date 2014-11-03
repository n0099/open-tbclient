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
    private TbImageView bQA;
    private ImageView bQB;
    private ImageView bQC;
    private ImageView bQD;
    private ImageView bQE;
    private ImageView bQF;
    private ImageView bQG;
    private View bQH;
    private ViewGroup bQI;
    private ViewGroup bQJ;
    private TbImageView bQK;
    private TextView bQL;
    private TextView bQM;
    private boolean bQN;
    private ViewGroup bQz;
    private Context mContext;

    public void setShowName(boolean z) {
        this.bQN = z;
    }

    public b(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, getXmlLayoutResId(), this);
        this.bQz = (ViewGroup) inflate.findViewById(com.baidu.tieba.v.bubble_layout);
        this.bQA = (TbImageView) inflate.findViewById(com.baidu.tieba.v.bubble_image);
        this.bQB = (ImageView) inflate.findViewById(com.baidu.tieba.v.bubble_iamge_bg);
        this.bQC = (ImageView) inflate.findViewById(com.baidu.tieba.v.free_tip);
        this.bQD = (ImageView) inflate.findViewById(com.baidu.tieba.v.defualt_tip);
        this.bQE = (ImageView) inflate.findViewById(com.baidu.tieba.v.bubble_notuse_iamge);
        this.bQF = (ImageView) inflate.findViewById(com.baidu.tieba.v.bubble_round_up);
        this.bQG = (ImageView) inflate.findViewById(com.baidu.tieba.v.bubble_round_full);
        this.bQH = inflate.findViewById(com.baidu.tieba.v.bubble_center_line);
        this.bQI = (ViewGroup) inflate.findViewById(com.baidu.tieba.v.bubble_bottom_layout);
        this.bQJ = (ViewGroup) inflate.findViewById(com.baidu.tieba.v.has_icon_name);
        this.bQK = (TbImageView) inflate.findViewById(com.baidu.tieba.v.icon_iamge);
        this.bQL = (TextView) inflate.findViewById(com.baidu.tieba.v.bubble_name);
        this.bQM = (TextView) inflate.findViewById(com.baidu.tieba.v.no_icon_name);
    }

    public int getXmlLayoutResId() {
        return com.baidu.tieba.w.bubbleview;
    }

    public void a(BubbleListData.BubbleData bubbleData, boolean z) {
        if (bubbleData != null) {
            if (bubbleData.getBcode() == 0) {
                aeP();
                this.bQD.setVisibility(z ? 0 : 8);
                this.bQB.setVisibility(z ? 0 : 8);
                return;
            }
            this.bQz.setVisibility(0);
            this.bQE.setVisibility(8);
            if (bubbleData.isDef()) {
                this.bQB.setVisibility(0);
                this.bQD.setVisibility(0);
            } else {
                this.bQB.setVisibility(8);
                this.bQD.setVisibility(8);
            }
            if (bubbleData.isFree()) {
                this.bQC.setVisibility(0);
            } else {
                this.bQC.setVisibility(8);
            }
            if (!TextUtils.isEmpty(bubbleData.getB_url())) {
                this.bQA.setTag(bubbleData.getB_url());
                this.bQA.c(bubbleData.getB_url(), 10, false);
            }
            if (!this.bQN) {
                this.bQH.setVisibility(8);
                this.bQI.setVisibility(8);
                this.bQF.setVisibility(8);
                this.bQG.setVisibility(0);
                return;
            }
            this.bQH.setVisibility(0);
            this.bQI.setVisibility(0);
            this.bQF.setVisibility(0);
            this.bQG.setVisibility(8);
            if (!TextUtils.isEmpty(bubbleData.getIcon_url())) {
                this.bQJ.setVisibility(0);
                this.bQM.setVisibility(8);
                this.bQL.setText(bubbleData.getBname());
                this.bQK.setTag(bubbleData.getIcon_url());
                this.bQK.c(bubbleData.getIcon_url(), 10, false);
                return;
            }
            this.bQJ.setVisibility(8);
            this.bQM.setVisibility(0);
            this.bQM.setText(bubbleData.getBname());
        }
    }

    public void aeP() {
        this.bQz.setVisibility(8);
        this.bQE.setVisibility(0);
        this.bQC.setVisibility(8);
        if (!this.bQN) {
            this.bQH.setVisibility(8);
            this.bQI.setVisibility(8);
            this.bQF.setVisibility(8);
            this.bQG.setVisibility(0);
            return;
        }
        this.bQH.setVisibility(0);
        this.bQI.setVisibility(0);
        this.bQF.setVisibility(0);
        this.bQG.setVisibility(8);
        this.bQJ.setVisibility(8);
        this.bQM.setVisibility(0);
        this.bQM.setText(this.mContext.getString(com.baidu.tieba.y.bubble_notuse_text));
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
