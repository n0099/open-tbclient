package com.baidu.tieba.themeCenter.bubble.all;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes9.dex */
public class BubbleItemView extends LinearLayout {
    private View.OnClickListener jig;
    private TbImageView lme;
    private TbImageView lmf;
    private Context mContext;
    private View mRootView;
    private DressItemData nFW;
    private ImageView nGu;
    private FrameLayout nHS;
    private TextView nHT;
    private a nHU;
    boolean nHV;
    private TbImageView nHj;

    public BubbleItemView(Context context) {
        super(context);
        this.jig = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.all.BubbleItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BubbleItemView.this.nFW != null && BubbleItemView.this.nHU != null && view == BubbleItemView.this.lme) {
                    BubbleItemView.this.nHU.b(BubbleItemView.this.nFW, BubbleItemView.this.nHV);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BubbleItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jig = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.all.BubbleItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BubbleItemView.this.nFW != null && BubbleItemView.this.nHU != null && view == BubbleItemView.this.lme) {
                    BubbleItemView.this.nHU.b(BubbleItemView.this.nFW, BubbleItemView.this.nHV);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BubbleItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.jig = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.all.BubbleItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BubbleItemView.this.nFW != null && BubbleItemView.this.nHU != null && view == BubbleItemView.this.lme) {
                    BubbleItemView.this.nHU.b(BubbleItemView.this.nFW, BubbleItemView.this.nHV);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.bubble_item, this);
        this.nHS = (FrameLayout) this.mRootView.findViewById(R.id.ly_bubble);
        this.lme = (TbImageView) this.mRootView.findViewById(R.id.bg_image);
        this.lmf = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.lmf.setDefaultResource(R.drawable.transparent_bg);
        this.lmf.setDefaultBgResource(R.drawable.transparent_bg);
        this.nHj = (TbImageView) this.mRootView.findViewById(R.id.state_icon);
        this.nHj.setDefaultResource(R.drawable.transparent_bg);
        this.nHj.setDefaultBgResource(R.drawable.transparent_bg);
        this.nGu = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.nHT = new TextView(this.mContext);
        this.lme.setOnClickListener(this.jig);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nFW = dressItemData;
            boolean inUse = dressItemData.getInUse();
            if (dressItemData.isDefault()) {
                this.lme.setDefaultResource(R.drawable.icon_choose_no);
                this.lme.startLoad("", 10, false);
                this.nHT.setText(R.string.default_bubble);
                this.nHT.setGravity(17);
                this.nHT.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds28));
                this.nHT.setTextColor(getResources().getColor(R.color.CAM_X0108));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                this.nHT.setLayoutParams(layoutParams);
                this.nHT.setVisibility(0);
                this.nHS.removeView(this.nHT);
                this.nHS.addView(this.nHT);
            } else {
                this.nHS.removeView(this.nHT);
                this.lme.setDefaultResource(R.drawable.img_default_100);
                this.lme.startLoad(dressItemData.getExampleImgUrl(), 10, false);
            }
            if (inUse) {
                this.nGu.setVisibility(0);
                ap.setImageResource(this.nGu, R.drawable.icon_choose_photo);
            } else {
                this.nGu.setVisibility(8);
            }
            this.lmf.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.nHj.startLoad(dressItemData.getPropsStateImg(), 10, false);
            setVisibility(0);
        }
    }

    public void hide() {
        setVisibility(4);
    }

    public void setController(a aVar) {
        this.nHU = aVar;
    }

    public void setFromBubbleGroup(boolean z) {
        this.nHV = z;
    }
}
