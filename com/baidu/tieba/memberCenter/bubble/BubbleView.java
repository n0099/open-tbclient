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
    private ViewGroup lcW;
    private TbImageView lcX;
    private ImageView lcY;
    private ImageView lcZ;
    private ImageView lda;
    private ImageView ldb;
    private ImageView ldc;
    private ImageView ldd;
    private View lde;
    private ViewGroup ldf;
    private ViewGroup ldg;
    private TbImageView ldh;
    private TextView ldi;
    private TextView ldj;
    private boolean ldk;
    private Context mContext;

    public void setShowName(boolean z) {
        this.ldk = z;
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
        this.lcW = (ViewGroup) inflate.findViewById(R.id.bubble_layout);
        this.lcX = (TbImageView) inflate.findViewById(R.id.bubble_image);
        this.lcY = (ImageView) inflate.findViewById(R.id.bubble_iamge_bg);
        this.lcZ = (ImageView) inflate.findViewById(R.id.free_tip);
        this.lda = (ImageView) inflate.findViewById(R.id.defualt_tip);
        this.ldb = (ImageView) inflate.findViewById(R.id.bubble_notuse_iamge);
        this.ldc = (ImageView) inflate.findViewById(R.id.bubble_round_up);
        this.ldd = (ImageView) inflate.findViewById(R.id.bubble_round_full);
        this.lde = inflate.findViewById(R.id.bubble_center_line);
        this.ldf = (ViewGroup) inflate.findViewById(R.id.bubble_bottom_layout);
        this.ldg = (ViewGroup) inflate.findViewById(R.id.has_icon_name);
        this.ldh = (TbImageView) inflate.findViewById(R.id.icon_iamge);
        this.ldi = (TextView) inflate.findViewById(R.id.bubble_name);
        this.ldj = (TextView) inflate.findViewById(R.id.no_icon_name);
    }

    public int getXmlLayoutResId() {
        return R.layout.bubbleview;
    }

    public void setData(BubbleListData.BubbleData bubbleData, boolean z) {
        if (bubbleData != null) {
            if (bubbleData.getBcode() == 0) {
                setCurrentNotUse();
                this.lda.setVisibility(z ? 0 : 8);
                this.lcY.setVisibility(z ? 0 : 8);
                return;
            }
            this.lcW.setVisibility(0);
            this.ldb.setVisibility(8);
            if (bubbleData.isDef()) {
                this.lcY.setVisibility(0);
                this.lda.setVisibility(0);
            } else {
                this.lcY.setVisibility(8);
                this.lda.setVisibility(8);
            }
            if (bubbleData.isFree()) {
                this.lcZ.setVisibility(0);
            } else {
                this.lcZ.setVisibility(8);
            }
            if (!TextUtils.isEmpty(bubbleData.getB_url())) {
                this.lcX.setTag(bubbleData.getB_url());
                this.lcX.startLoad(bubbleData.getB_url(), 10, false);
            }
            if (!this.ldk) {
                this.lde.setVisibility(8);
                this.ldf.setVisibility(8);
                this.ldc.setVisibility(8);
                this.ldd.setVisibility(0);
                return;
            }
            this.lde.setVisibility(0);
            this.ldf.setVisibility(0);
            this.ldc.setVisibility(0);
            this.ldd.setVisibility(8);
            if (!TextUtils.isEmpty(bubbleData.getIcon_url())) {
                this.ldg.setVisibility(0);
                this.ldj.setVisibility(8);
                this.ldi.setText(bubbleData.getBname());
                this.ldh.setTag(bubbleData.getIcon_url());
                this.ldh.startLoad(bubbleData.getIcon_url(), 10, false);
                return;
            }
            this.ldg.setVisibility(8);
            this.ldj.setVisibility(0);
            this.ldj.setText(bubbleData.getBname());
        }
    }

    public void setCurrentNotUse() {
        this.lcW.setVisibility(8);
        this.ldb.setVisibility(0);
        this.lcZ.setVisibility(8);
        if (!this.ldk) {
            this.lde.setVisibility(8);
            this.ldf.setVisibility(8);
            this.ldc.setVisibility(8);
            this.ldd.setVisibility(0);
            return;
        }
        this.lde.setVisibility(0);
        this.ldf.setVisibility(0);
        this.ldc.setVisibility(0);
        this.ldd.setVisibility(8);
        this.ldg.setVisibility(8);
        this.ldj.setVisibility(0);
        this.ldj.setText(this.mContext.getString(R.string.bubble_notuse_text));
    }

    public void B(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().onModeChanged(this);
    }
}
