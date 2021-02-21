package com.baidu.tieba.memberCenter.bubble;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
/* loaded from: classes9.dex */
public class BubbleView extends RelativeLayout {
    private TextView llA;
    private boolean llB;
    private ViewGroup lln;
    private TbImageView llo;
    private ImageView llp;
    private ImageView llq;
    private ImageView llr;
    private ImageView lls;
    private ImageView llt;
    private ImageView llu;
    private View llv;
    private ViewGroup llw;
    private ViewGroup llx;
    private TbImageView lly;
    private TextView llz;
    private Context mContext;

    public void setShowName(boolean z) {
        this.llB = z;
    }

    public BubbleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    public BubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public BubbleView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(this.mContext).inflate(getXmlLayoutResId(), this);
        this.lln = (ViewGroup) inflate.findViewById(R.id.bubble_layout);
        this.llo = (TbImageView) inflate.findViewById(R.id.bubble_image);
        this.llp = (ImageView) inflate.findViewById(R.id.bubble_iamge_bg);
        this.llq = (ImageView) inflate.findViewById(R.id.free_tip);
        this.llr = (ImageView) inflate.findViewById(R.id.defualt_tip);
        this.lls = (ImageView) inflate.findViewById(R.id.bubble_notuse_iamge);
        this.llt = (ImageView) inflate.findViewById(R.id.bubble_round_up);
        this.llu = (ImageView) inflate.findViewById(R.id.bubble_round_full);
        this.llv = inflate.findViewById(R.id.bubble_center_line);
        this.llw = (ViewGroup) inflate.findViewById(R.id.bubble_bottom_layout);
        this.llx = (ViewGroup) inflate.findViewById(R.id.has_icon_name);
        this.lly = (TbImageView) inflate.findViewById(R.id.icon_iamge);
        this.llz = (TextView) inflate.findViewById(R.id.bubble_name);
        this.llA = (TextView) inflate.findViewById(R.id.no_icon_name);
    }

    public int getXmlLayoutResId() {
        return R.layout.bubbleview;
    }

    public void setData(BubbleListData.BubbleData bubbleData, boolean z) {
        if (bubbleData != null) {
            if (bubbleData.getBcode() == 0) {
                setCurrentNotUse();
                this.llr.setVisibility(z ? 0 : 8);
                this.llp.setVisibility(z ? 0 : 8);
                return;
            }
            this.lln.setVisibility(0);
            this.lls.setVisibility(8);
            if (bubbleData.isDef()) {
                this.llp.setVisibility(0);
                this.llr.setVisibility(0);
            } else {
                this.llp.setVisibility(8);
                this.llr.setVisibility(8);
            }
            if (bubbleData.isFree()) {
                this.llq.setVisibility(0);
            } else {
                this.llq.setVisibility(8);
            }
            if (!TextUtils.isEmpty(bubbleData.getB_url())) {
                this.llo.setTag(bubbleData.getB_url());
                this.llo.startLoad(bubbleData.getB_url(), 10, false);
            }
            if (!this.llB) {
                this.llv.setVisibility(8);
                this.llw.setVisibility(8);
                this.llt.setVisibility(8);
                this.llu.setVisibility(0);
                return;
            }
            this.llv.setVisibility(0);
            this.llw.setVisibility(0);
            this.llt.setVisibility(0);
            this.llu.setVisibility(8);
            if (!TextUtils.isEmpty(bubbleData.getIcon_url())) {
                this.llx.setVisibility(0);
                this.llA.setVisibility(8);
                this.llz.setText(bubbleData.getBname());
                this.lly.setTag(bubbleData.getIcon_url());
                this.lly.startLoad(bubbleData.getIcon_url(), 10, false);
                return;
            }
            this.llx.setVisibility(8);
            this.llA.setVisibility(0);
            this.llA.setText(bubbleData.getBname());
        }
    }

    public void setCurrentNotUse() {
        this.lln.setVisibility(8);
        this.lls.setVisibility(0);
        this.llq.setVisibility(8);
        if (!this.llB) {
            this.llv.setVisibility(8);
            this.llw.setVisibility(8);
            this.llt.setVisibility(8);
            this.llu.setVisibility(0);
            return;
        }
        this.llv.setVisibility(0);
        this.llw.setVisibility(0);
        this.llt.setVisibility(0);
        this.llu.setVisibility(8);
        this.llx.setVisibility(8);
        this.llA.setVisibility(0);
        this.llA.setText(this.mContext.getString(R.string.bubble_notuse_text));
    }

    public void D(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
    }
}
