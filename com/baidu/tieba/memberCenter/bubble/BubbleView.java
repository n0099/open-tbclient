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
/* loaded from: classes8.dex */
public class BubbleView extends RelativeLayout {
    private ViewGroup lnA;
    private TbImageView lnB;
    private TextView lnC;
    private TextView lnD;
    private boolean lnE;
    private ViewGroup lnq;
    private TbImageView lnr;
    private ImageView lns;
    private ImageView lnt;
    private ImageView lnu;
    private ImageView lnv;
    private ImageView lnw;
    private ImageView lnx;
    private View lny;
    private ViewGroup lnz;
    private Context mContext;

    public void setShowName(boolean z) {
        this.lnE = z;
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
        this.lnq = (ViewGroup) inflate.findViewById(R.id.bubble_layout);
        this.lnr = (TbImageView) inflate.findViewById(R.id.bubble_image);
        this.lns = (ImageView) inflate.findViewById(R.id.bubble_iamge_bg);
        this.lnt = (ImageView) inflate.findViewById(R.id.free_tip);
        this.lnu = (ImageView) inflate.findViewById(R.id.defualt_tip);
        this.lnv = (ImageView) inflate.findViewById(R.id.bubble_notuse_iamge);
        this.lnw = (ImageView) inflate.findViewById(R.id.bubble_round_up);
        this.lnx = (ImageView) inflate.findViewById(R.id.bubble_round_full);
        this.lny = inflate.findViewById(R.id.bubble_center_line);
        this.lnz = (ViewGroup) inflate.findViewById(R.id.bubble_bottom_layout);
        this.lnA = (ViewGroup) inflate.findViewById(R.id.has_icon_name);
        this.lnB = (TbImageView) inflate.findViewById(R.id.icon_iamge);
        this.lnC = (TextView) inflate.findViewById(R.id.bubble_name);
        this.lnD = (TextView) inflate.findViewById(R.id.no_icon_name);
    }

    public int getXmlLayoutResId() {
        return R.layout.bubbleview;
    }

    public void setData(BubbleListData.BubbleData bubbleData, boolean z) {
        if (bubbleData != null) {
            if (bubbleData.getBcode() == 0) {
                setCurrentNotUse();
                this.lnu.setVisibility(z ? 0 : 8);
                this.lns.setVisibility(z ? 0 : 8);
                return;
            }
            this.lnq.setVisibility(0);
            this.lnv.setVisibility(8);
            if (bubbleData.isDef()) {
                this.lns.setVisibility(0);
                this.lnu.setVisibility(0);
            } else {
                this.lns.setVisibility(8);
                this.lnu.setVisibility(8);
            }
            if (bubbleData.isFree()) {
                this.lnt.setVisibility(0);
            } else {
                this.lnt.setVisibility(8);
            }
            if (!TextUtils.isEmpty(bubbleData.getB_url())) {
                this.lnr.setTag(bubbleData.getB_url());
                this.lnr.startLoad(bubbleData.getB_url(), 10, false);
            }
            if (!this.lnE) {
                this.lny.setVisibility(8);
                this.lnz.setVisibility(8);
                this.lnw.setVisibility(8);
                this.lnx.setVisibility(0);
                return;
            }
            this.lny.setVisibility(0);
            this.lnz.setVisibility(0);
            this.lnw.setVisibility(0);
            this.lnx.setVisibility(8);
            if (!TextUtils.isEmpty(bubbleData.getIcon_url())) {
                this.lnA.setVisibility(0);
                this.lnD.setVisibility(8);
                this.lnC.setText(bubbleData.getBname());
                this.lnB.setTag(bubbleData.getIcon_url());
                this.lnB.startLoad(bubbleData.getIcon_url(), 10, false);
                return;
            }
            this.lnA.setVisibility(8);
            this.lnD.setVisibility(0);
            this.lnD.setText(bubbleData.getBname());
        }
    }

    public void setCurrentNotUse() {
        this.lnq.setVisibility(8);
        this.lnv.setVisibility(0);
        this.lnt.setVisibility(8);
        if (!this.lnE) {
            this.lny.setVisibility(8);
            this.lnz.setVisibility(8);
            this.lnw.setVisibility(8);
            this.lnx.setVisibility(0);
            return;
        }
        this.lny.setVisibility(0);
        this.lnz.setVisibility(0);
        this.lnw.setVisibility(0);
        this.lnx.setVisibility(8);
        this.lnA.setVisibility(8);
        this.lnD.setVisibility(0);
        this.lnD.setText(this.mContext.getString(R.string.bubble_notuse_text));
    }

    public void D(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
    }
}
