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
    private ViewGroup bWf;
    private TbImageView bWg;
    private ImageView bWh;
    private ImageView bWi;
    private ImageView bWj;
    private ImageView bWk;
    private ImageView bWl;
    private ImageView bWm;
    private View bWn;
    private ViewGroup bWo;
    private ViewGroup bWp;
    private TbImageView bWq;
    private TextView bWr;
    private TextView bWs;
    private boolean bWt;
    private Context mContext;

    public void setShowName(boolean z) {
        this.bWt = z;
    }

    public z(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = b.ek().inflate(this.mContext, getXmlLayoutResId(), this);
        this.bWf = (ViewGroup) inflate.findViewById(com.baidu.tieba.w.bubble_layout);
        this.bWg = (TbImageView) inflate.findViewById(com.baidu.tieba.w.bubble_image);
        this.bWh = (ImageView) inflate.findViewById(com.baidu.tieba.w.bubble_iamge_bg);
        this.bWi = (ImageView) inflate.findViewById(com.baidu.tieba.w.free_tip);
        this.bWj = (ImageView) inflate.findViewById(com.baidu.tieba.w.defualt_tip);
        this.bWk = (ImageView) inflate.findViewById(com.baidu.tieba.w.bubble_notuse_iamge);
        this.bWl = (ImageView) inflate.findViewById(com.baidu.tieba.w.bubble_round_up);
        this.bWm = (ImageView) inflate.findViewById(com.baidu.tieba.w.bubble_round_full);
        this.bWn = inflate.findViewById(com.baidu.tieba.w.bubble_center_line);
        this.bWo = (ViewGroup) inflate.findViewById(com.baidu.tieba.w.bubble_bottom_layout);
        this.bWp = (ViewGroup) inflate.findViewById(com.baidu.tieba.w.has_icon_name);
        this.bWq = (TbImageView) inflate.findViewById(com.baidu.tieba.w.icon_iamge);
        this.bWr = (TextView) inflate.findViewById(com.baidu.tieba.w.bubble_name);
        this.bWs = (TextView) inflate.findViewById(com.baidu.tieba.w.no_icon_name);
    }

    public int getXmlLayoutResId() {
        return com.baidu.tieba.x.bubbleview;
    }

    public void a(BubbleListData.BubbleData bubbleData, boolean z) {
        if (bubbleData != null) {
            if (bubbleData.getBcode() == 0) {
                agt();
                this.bWj.setVisibility(z ? 0 : 8);
                this.bWh.setVisibility(z ? 0 : 8);
                return;
            }
            this.bWf.setVisibility(0);
            this.bWk.setVisibility(8);
            if (bubbleData.isDef()) {
                this.bWh.setVisibility(0);
                this.bWj.setVisibility(0);
            } else {
                this.bWh.setVisibility(8);
                this.bWj.setVisibility(8);
            }
            if (bubbleData.isFree()) {
                this.bWi.setVisibility(0);
            } else {
                this.bWi.setVisibility(8);
            }
            if (!TextUtils.isEmpty(bubbleData.getB_url())) {
                this.bWg.setTag(bubbleData.getB_url());
                this.bWg.d(bubbleData.getB_url(), 10, false);
            }
            if (!this.bWt) {
                this.bWn.setVisibility(8);
                this.bWo.setVisibility(8);
                this.bWl.setVisibility(8);
                this.bWm.setVisibility(0);
                return;
            }
            this.bWn.setVisibility(0);
            this.bWo.setVisibility(0);
            this.bWl.setVisibility(0);
            this.bWm.setVisibility(8);
            if (!TextUtils.isEmpty(bubbleData.getIcon_url())) {
                this.bWp.setVisibility(0);
                this.bWs.setVisibility(8);
                this.bWr.setText(bubbleData.getBname());
                this.bWq.setTag(bubbleData.getIcon_url());
                this.bWq.d(bubbleData.getIcon_url(), 10, false);
                return;
            }
            this.bWp.setVisibility(8);
            this.bWs.setVisibility(0);
            this.bWs.setText(bubbleData.getBname());
        }
    }

    public void agt() {
        this.bWf.setVisibility(8);
        this.bWk.setVisibility(0);
        this.bWi.setVisibility(8);
        if (!this.bWt) {
            this.bWn.setVisibility(8);
            this.bWo.setVisibility(8);
            this.bWl.setVisibility(8);
            this.bWm.setVisibility(0);
            return;
        }
        this.bWn.setVisibility(0);
        this.bWo.setVisibility(0);
        this.bWl.setVisibility(0);
        this.bWm.setVisibility(8);
        this.bWp.setVisibility(8);
        this.bWs.setVisibility(0);
        this.bWs.setText(this.mContext.getString(com.baidu.tieba.z.bubble_notuse_text));
    }

    public void e(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().h(this);
    }
}
