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
/* loaded from: classes8.dex */
public class BubbleItemView extends LinearLayout {
    private View.OnClickListener jjP;
    private TbImageView loj;
    private TbImageView lok;
    private Context mContext;
    private View mRootView;
    private ImageView nIA;
    private DressItemData nIc;
    private FrameLayout nJY;
    private TextView nJZ;
    private TbImageView nJp;
    private a nKa;
    boolean nKb;

    public BubbleItemView(Context context) {
        super(context);
        this.jjP = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.all.BubbleItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BubbleItemView.this.nIc != null && BubbleItemView.this.nKa != null && view == BubbleItemView.this.loj) {
                    BubbleItemView.this.nKa.b(BubbleItemView.this.nIc, BubbleItemView.this.nKb);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BubbleItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jjP = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.all.BubbleItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BubbleItemView.this.nIc != null && BubbleItemView.this.nKa != null && view == BubbleItemView.this.loj) {
                    BubbleItemView.this.nKa.b(BubbleItemView.this.nIc, BubbleItemView.this.nKb);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BubbleItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.jjP = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.all.BubbleItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BubbleItemView.this.nIc != null && BubbleItemView.this.nKa != null && view == BubbleItemView.this.loj) {
                    BubbleItemView.this.nKa.b(BubbleItemView.this.nIc, BubbleItemView.this.nKb);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.bubble_item, this);
        this.nJY = (FrameLayout) this.mRootView.findViewById(R.id.ly_bubble);
        this.loj = (TbImageView) this.mRootView.findViewById(R.id.bg_image);
        this.lok = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.lok.setDefaultResource(R.drawable.transparent_bg);
        this.lok.setDefaultBgResource(R.drawable.transparent_bg);
        this.nJp = (TbImageView) this.mRootView.findViewById(R.id.state_icon);
        this.nJp.setDefaultResource(R.drawable.transparent_bg);
        this.nJp.setDefaultBgResource(R.drawable.transparent_bg);
        this.nIA = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.nJZ = new TextView(this.mContext);
        this.loj.setOnClickListener(this.jjP);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nIc = dressItemData;
            boolean inUse = dressItemData.getInUse();
            if (dressItemData.isDefault()) {
                this.loj.setDefaultResource(R.drawable.icon_choose_no);
                this.loj.startLoad("", 10, false);
                this.nJZ.setText(R.string.default_bubble);
                this.nJZ.setGravity(17);
                this.nJZ.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds28));
                this.nJZ.setTextColor(getResources().getColor(R.color.CAM_X0108));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                this.nJZ.setLayoutParams(layoutParams);
                this.nJZ.setVisibility(0);
                this.nJY.removeView(this.nJZ);
                this.nJY.addView(this.nJZ);
            } else {
                this.nJY.removeView(this.nJZ);
                this.loj.setDefaultResource(R.drawable.img_default_100);
                this.loj.startLoad(dressItemData.getExampleImgUrl(), 10, false);
            }
            if (inUse) {
                this.nIA.setVisibility(0);
                ap.setImageResource(this.nIA, R.drawable.icon_choose_photo);
            } else {
                this.nIA.setVisibility(8);
            }
            this.lok.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.nJp.startLoad(dressItemData.getPropsStateImg(), 10, false);
            setVisibility(0);
        }
    }

    public void hide() {
        setVisibility(4);
    }

    public void setController(a aVar) {
        this.nKa = aVar;
    }

    public void setFromBubbleGroup(boolean z) {
        this.nKb = z;
    }
}
