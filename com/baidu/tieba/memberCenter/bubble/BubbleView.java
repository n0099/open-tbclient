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
    private ViewGroup lkZ;
    private TbImageView lla;
    private ImageView llb;
    private ImageView llc;
    private ImageView lld;
    private ImageView lle;
    private ImageView llf;
    private ImageView llg;
    private View llh;
    private ViewGroup lli;
    private ViewGroup llj;
    private TbImageView llk;
    private TextView lll;
    private TextView llm;
    private boolean lln;
    private Context mContext;

    public void setShowName(boolean z) {
        this.lln = z;
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
        this.lkZ = (ViewGroup) inflate.findViewById(R.id.bubble_layout);
        this.lla = (TbImageView) inflate.findViewById(R.id.bubble_image);
        this.llb = (ImageView) inflate.findViewById(R.id.bubble_iamge_bg);
        this.llc = (ImageView) inflate.findViewById(R.id.free_tip);
        this.lld = (ImageView) inflate.findViewById(R.id.defualt_tip);
        this.lle = (ImageView) inflate.findViewById(R.id.bubble_notuse_iamge);
        this.llf = (ImageView) inflate.findViewById(R.id.bubble_round_up);
        this.llg = (ImageView) inflate.findViewById(R.id.bubble_round_full);
        this.llh = inflate.findViewById(R.id.bubble_center_line);
        this.lli = (ViewGroup) inflate.findViewById(R.id.bubble_bottom_layout);
        this.llj = (ViewGroup) inflate.findViewById(R.id.has_icon_name);
        this.llk = (TbImageView) inflate.findViewById(R.id.icon_iamge);
        this.lll = (TextView) inflate.findViewById(R.id.bubble_name);
        this.llm = (TextView) inflate.findViewById(R.id.no_icon_name);
    }

    public int getXmlLayoutResId() {
        return R.layout.bubbleview;
    }

    public void setData(BubbleListData.BubbleData bubbleData, boolean z) {
        if (bubbleData != null) {
            if (bubbleData.getBcode() == 0) {
                setCurrentNotUse();
                this.lld.setVisibility(z ? 0 : 8);
                this.llb.setVisibility(z ? 0 : 8);
                return;
            }
            this.lkZ.setVisibility(0);
            this.lle.setVisibility(8);
            if (bubbleData.isDef()) {
                this.llb.setVisibility(0);
                this.lld.setVisibility(0);
            } else {
                this.llb.setVisibility(8);
                this.lld.setVisibility(8);
            }
            if (bubbleData.isFree()) {
                this.llc.setVisibility(0);
            } else {
                this.llc.setVisibility(8);
            }
            if (!TextUtils.isEmpty(bubbleData.getB_url())) {
                this.lla.setTag(bubbleData.getB_url());
                this.lla.startLoad(bubbleData.getB_url(), 10, false);
            }
            if (!this.lln) {
                this.llh.setVisibility(8);
                this.lli.setVisibility(8);
                this.llf.setVisibility(8);
                this.llg.setVisibility(0);
                return;
            }
            this.llh.setVisibility(0);
            this.lli.setVisibility(0);
            this.llf.setVisibility(0);
            this.llg.setVisibility(8);
            if (!TextUtils.isEmpty(bubbleData.getIcon_url())) {
                this.llj.setVisibility(0);
                this.llm.setVisibility(8);
                this.lll.setText(bubbleData.getBname());
                this.llk.setTag(bubbleData.getIcon_url());
                this.llk.startLoad(bubbleData.getIcon_url(), 10, false);
                return;
            }
            this.llj.setVisibility(8);
            this.llm.setVisibility(0);
            this.llm.setText(bubbleData.getBname());
        }
    }

    public void setCurrentNotUse() {
        this.lkZ.setVisibility(8);
        this.lle.setVisibility(0);
        this.llc.setVisibility(8);
        if (!this.lln) {
            this.llh.setVisibility(8);
            this.lli.setVisibility(8);
            this.llf.setVisibility(8);
            this.llg.setVisibility(0);
            return;
        }
        this.llh.setVisibility(0);
        this.lli.setVisibility(0);
        this.llf.setVisibility(0);
        this.llg.setVisibility(8);
        this.llj.setVisibility(8);
        this.llm.setVisibility(0);
        this.llm.setText(this.mContext.getString(R.string.bubble_notuse_text));
    }

    public void D(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
    }
}
