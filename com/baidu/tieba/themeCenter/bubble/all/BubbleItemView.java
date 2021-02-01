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
    private View.OnClickListener jhR;
    private TbImageView llQ;
    private TbImageView llR;
    private Context mContext;
    private View mRootView;
    private ImageView nFU;
    private DressItemData nFw;
    private TbImageView nGJ;
    private FrameLayout nHs;
    private TextView nHt;
    private a nHu;
    boolean nHv;

    public BubbleItemView(Context context) {
        super(context);
        this.jhR = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.all.BubbleItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BubbleItemView.this.nFw != null && BubbleItemView.this.nHu != null && view == BubbleItemView.this.llQ) {
                    BubbleItemView.this.nHu.b(BubbleItemView.this.nFw, BubbleItemView.this.nHv);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BubbleItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jhR = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.all.BubbleItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BubbleItemView.this.nFw != null && BubbleItemView.this.nHu != null && view == BubbleItemView.this.llQ) {
                    BubbleItemView.this.nHu.b(BubbleItemView.this.nFw, BubbleItemView.this.nHv);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BubbleItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.jhR = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.all.BubbleItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BubbleItemView.this.nFw != null && BubbleItemView.this.nHu != null && view == BubbleItemView.this.llQ) {
                    BubbleItemView.this.nHu.b(BubbleItemView.this.nFw, BubbleItemView.this.nHv);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.bubble_item, this);
        this.nHs = (FrameLayout) this.mRootView.findViewById(R.id.ly_bubble);
        this.llQ = (TbImageView) this.mRootView.findViewById(R.id.bg_image);
        this.llR = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.llR.setDefaultResource(R.drawable.transparent_bg);
        this.llR.setDefaultBgResource(R.drawable.transparent_bg);
        this.nGJ = (TbImageView) this.mRootView.findViewById(R.id.state_icon);
        this.nGJ.setDefaultResource(R.drawable.transparent_bg);
        this.nGJ.setDefaultBgResource(R.drawable.transparent_bg);
        this.nFU = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.nHt = new TextView(this.mContext);
        this.llQ.setOnClickListener(this.jhR);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nFw = dressItemData;
            boolean inUse = dressItemData.getInUse();
            if (dressItemData.isDefault()) {
                this.llQ.setDefaultResource(R.drawable.icon_choose_no);
                this.llQ.startLoad("", 10, false);
                this.nHt.setText(R.string.default_bubble);
                this.nHt.setGravity(17);
                this.nHt.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds28));
                this.nHt.setTextColor(getResources().getColor(R.color.CAM_X0108));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                this.nHt.setLayoutParams(layoutParams);
                this.nHt.setVisibility(0);
                this.nHs.removeView(this.nHt);
                this.nHs.addView(this.nHt);
            } else {
                this.nHs.removeView(this.nHt);
                this.llQ.setDefaultResource(R.drawable.img_default_100);
                this.llQ.startLoad(dressItemData.getExampleImgUrl(), 10, false);
            }
            if (inUse) {
                this.nFU.setVisibility(0);
                ap.setImageResource(this.nFU, R.drawable.icon_choose_photo);
            } else {
                this.nFU.setVisibility(8);
            }
            this.llR.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.nGJ.startLoad(dressItemData.getPropsStateImg(), 10, false);
            setVisibility(0);
        }
    }

    public void hide() {
        setVisibility(4);
    }

    public void setController(a aVar) {
        this.nHu = aVar;
    }

    public void setFromBubbleGroup(boolean z) {
        this.nHv = z;
    }
}
