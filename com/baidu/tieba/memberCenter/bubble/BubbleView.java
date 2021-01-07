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
    private ViewGroup lhC;
    private TbImageView lhD;
    private ImageView lhE;
    private ImageView lhF;
    private ImageView lhG;
    private ImageView lhH;
    private ImageView lhI;
    private ImageView lhJ;
    private View lhK;
    private ViewGroup lhL;
    private ViewGroup lhM;
    private TbImageView lhN;
    private TextView lhO;
    private TextView lhP;
    private boolean lhQ;
    private Context mContext;

    public void setShowName(boolean z) {
        this.lhQ = z;
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
        this.lhC = (ViewGroup) inflate.findViewById(R.id.bubble_layout);
        this.lhD = (TbImageView) inflate.findViewById(R.id.bubble_image);
        this.lhE = (ImageView) inflate.findViewById(R.id.bubble_iamge_bg);
        this.lhF = (ImageView) inflate.findViewById(R.id.free_tip);
        this.lhG = (ImageView) inflate.findViewById(R.id.defualt_tip);
        this.lhH = (ImageView) inflate.findViewById(R.id.bubble_notuse_iamge);
        this.lhI = (ImageView) inflate.findViewById(R.id.bubble_round_up);
        this.lhJ = (ImageView) inflate.findViewById(R.id.bubble_round_full);
        this.lhK = inflate.findViewById(R.id.bubble_center_line);
        this.lhL = (ViewGroup) inflate.findViewById(R.id.bubble_bottom_layout);
        this.lhM = (ViewGroup) inflate.findViewById(R.id.has_icon_name);
        this.lhN = (TbImageView) inflate.findViewById(R.id.icon_iamge);
        this.lhO = (TextView) inflate.findViewById(R.id.bubble_name);
        this.lhP = (TextView) inflate.findViewById(R.id.no_icon_name);
    }

    public int getXmlLayoutResId() {
        return R.layout.bubbleview;
    }

    public void setData(BubbleListData.BubbleData bubbleData, boolean z) {
        if (bubbleData != null) {
            if (bubbleData.getBcode() == 0) {
                setCurrentNotUse();
                this.lhG.setVisibility(z ? 0 : 8);
                this.lhE.setVisibility(z ? 0 : 8);
                return;
            }
            this.lhC.setVisibility(0);
            this.lhH.setVisibility(8);
            if (bubbleData.isDef()) {
                this.lhE.setVisibility(0);
                this.lhG.setVisibility(0);
            } else {
                this.lhE.setVisibility(8);
                this.lhG.setVisibility(8);
            }
            if (bubbleData.isFree()) {
                this.lhF.setVisibility(0);
            } else {
                this.lhF.setVisibility(8);
            }
            if (!TextUtils.isEmpty(bubbleData.getB_url())) {
                this.lhD.setTag(bubbleData.getB_url());
                this.lhD.startLoad(bubbleData.getB_url(), 10, false);
            }
            if (!this.lhQ) {
                this.lhK.setVisibility(8);
                this.lhL.setVisibility(8);
                this.lhI.setVisibility(8);
                this.lhJ.setVisibility(0);
                return;
            }
            this.lhK.setVisibility(0);
            this.lhL.setVisibility(0);
            this.lhI.setVisibility(0);
            this.lhJ.setVisibility(8);
            if (!TextUtils.isEmpty(bubbleData.getIcon_url())) {
                this.lhM.setVisibility(0);
                this.lhP.setVisibility(8);
                this.lhO.setText(bubbleData.getBname());
                this.lhN.setTag(bubbleData.getIcon_url());
                this.lhN.startLoad(bubbleData.getIcon_url(), 10, false);
                return;
            }
            this.lhM.setVisibility(8);
            this.lhP.setVisibility(0);
            this.lhP.setText(bubbleData.getBname());
        }
    }

    public void setCurrentNotUse() {
        this.lhC.setVisibility(8);
        this.lhH.setVisibility(0);
        this.lhF.setVisibility(8);
        if (!this.lhQ) {
            this.lhK.setVisibility(8);
            this.lhL.setVisibility(8);
            this.lhI.setVisibility(8);
            this.lhJ.setVisibility(0);
            return;
        }
        this.lhK.setVisibility(0);
        this.lhL.setVisibility(0);
        this.lhI.setVisibility(0);
        this.lhJ.setVisibility(8);
        this.lhM.setVisibility(8);
        this.lhP.setVisibility(0);
        this.lhP.setText(this.mContext.getString(R.string.bubble_notuse_text));
    }

    public void B(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
    }
}
