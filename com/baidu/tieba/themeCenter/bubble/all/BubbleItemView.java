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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes8.dex */
public class BubbleItemView extends LinearLayout {
    private View.OnClickListener jcl;
    private TbImageView ldN;
    private TbImageView ldO;
    private Context mContext;
    private View mRootView;
    private DressItemData nvM;
    private TbImageView nwZ;
    private ImageView nwk;
    private FrameLayout nxI;
    private TextView nxJ;
    private a nxK;
    boolean nxL;

    public BubbleItemView(Context context) {
        super(context);
        this.jcl = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.all.BubbleItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BubbleItemView.this.nvM != null && BubbleItemView.this.nxK != null && view == BubbleItemView.this.ldN) {
                    BubbleItemView.this.nxK.b(BubbleItemView.this.nvM, BubbleItemView.this.nxL);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BubbleItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jcl = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.all.BubbleItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BubbleItemView.this.nvM != null && BubbleItemView.this.nxK != null && view == BubbleItemView.this.ldN) {
                    BubbleItemView.this.nxK.b(BubbleItemView.this.nvM, BubbleItemView.this.nxL);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BubbleItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.jcl = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.all.BubbleItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BubbleItemView.this.nvM != null && BubbleItemView.this.nxK != null && view == BubbleItemView.this.ldN) {
                    BubbleItemView.this.nxK.b(BubbleItemView.this.nvM, BubbleItemView.this.nxL);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.bubble_item, this);
        this.nxI = (FrameLayout) this.mRootView.findViewById(R.id.ly_bubble);
        this.ldN = (TbImageView) this.mRootView.findViewById(R.id.bg_image);
        this.ldO = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.ldO.setDefaultResource(R.drawable.transparent_bg);
        this.ldO.setDefaultBgResource(R.drawable.transparent_bg);
        this.nwZ = (TbImageView) this.mRootView.findViewById(R.id.state_icon);
        this.nwZ.setDefaultResource(R.drawable.transparent_bg);
        this.nwZ.setDefaultBgResource(R.drawable.transparent_bg);
        this.nwk = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.nxJ = new TextView(this.mContext);
        this.ldN.setOnClickListener(this.jcl);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nvM = dressItemData;
            boolean inUse = dressItemData.getInUse();
            if (dressItemData.isDefault()) {
                this.ldN.setDefaultResource(R.drawable.icon_choose_no);
                this.ldN.startLoad("", 10, false);
                this.nxJ.setText(R.string.default_bubble);
                this.nxJ.setGravity(17);
                this.nxJ.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds28));
                this.nxJ.setTextColor(getResources().getColor(R.color.CAM_X0108));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                this.nxJ.setLayoutParams(layoutParams);
                this.nxJ.setVisibility(0);
                this.nxI.removeView(this.nxJ);
                this.nxI.addView(this.nxJ);
            } else {
                this.nxI.removeView(this.nxJ);
                this.ldN.setDefaultResource(R.drawable.img_default_100);
                this.ldN.startLoad(dressItemData.getExampleImgUrl(), 10, false);
            }
            if (inUse) {
                this.nwk.setVisibility(0);
                ao.setImageResource(this.nwk, R.drawable.icon_choose_photo);
            } else {
                this.nwk.setVisibility(8);
            }
            this.ldO.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.nwZ.startLoad(dressItemData.getPropsStateImg(), 10, false);
            setVisibility(0);
        }
    }

    public void hide() {
        setVisibility(4);
    }

    public void setController(a aVar) {
        this.nxK = aVar;
    }

    public void setFromBubbleGroup(boolean z) {
        this.nxL = z;
    }
}
