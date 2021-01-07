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
/* loaded from: classes9.dex */
public class BubbleItemView extends LinearLayout {
    private View.OnClickListener jgS;
    private TbImageView lit;
    private TbImageView liu;
    private Context mContext;
    private View mRootView;
    private ImageView nAO;
    private DressItemData nAq;
    private TbImageView nBD;
    private FrameLayout nCm;
    private TextView nCn;
    private a nCo;
    boolean nCp;

    public BubbleItemView(Context context) {
        super(context);
        this.jgS = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.all.BubbleItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BubbleItemView.this.nAq != null && BubbleItemView.this.nCo != null && view == BubbleItemView.this.lit) {
                    BubbleItemView.this.nCo.b(BubbleItemView.this.nAq, BubbleItemView.this.nCp);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BubbleItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jgS = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.all.BubbleItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BubbleItemView.this.nAq != null && BubbleItemView.this.nCo != null && view == BubbleItemView.this.lit) {
                    BubbleItemView.this.nCo.b(BubbleItemView.this.nAq, BubbleItemView.this.nCp);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BubbleItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.jgS = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.bubble.all.BubbleItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BubbleItemView.this.nAq != null && BubbleItemView.this.nCo != null && view == BubbleItemView.this.lit) {
                    BubbleItemView.this.nCo.b(BubbleItemView.this.nAq, BubbleItemView.this.nCp);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.bubble_item, this);
        this.nCm = (FrameLayout) this.mRootView.findViewById(R.id.ly_bubble);
        this.lit = (TbImageView) this.mRootView.findViewById(R.id.bg_image);
        this.liu = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.liu.setDefaultResource(R.drawable.transparent_bg);
        this.liu.setDefaultBgResource(R.drawable.transparent_bg);
        this.nBD = (TbImageView) this.mRootView.findViewById(R.id.state_icon);
        this.nBD.setDefaultResource(R.drawable.transparent_bg);
        this.nBD.setDefaultBgResource(R.drawable.transparent_bg);
        this.nAO = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.nCn = new TextView(this.mContext);
        this.lit.setOnClickListener(this.jgS);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nAq = dressItemData;
            boolean inUse = dressItemData.getInUse();
            if (dressItemData.isDefault()) {
                this.lit.setDefaultResource(R.drawable.icon_choose_no);
                this.lit.startLoad("", 10, false);
                this.nCn.setText(R.string.default_bubble);
                this.nCn.setGravity(17);
                this.nCn.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds28));
                this.nCn.setTextColor(getResources().getColor(R.color.CAM_X0108));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                this.nCn.setLayoutParams(layoutParams);
                this.nCn.setVisibility(0);
                this.nCm.removeView(this.nCn);
                this.nCm.addView(this.nCn);
            } else {
                this.nCm.removeView(this.nCn);
                this.lit.setDefaultResource(R.drawable.img_default_100);
                this.lit.startLoad(dressItemData.getExampleImgUrl(), 10, false);
            }
            if (inUse) {
                this.nAO.setVisibility(0);
                ao.setImageResource(this.nAO, R.drawable.icon_choose_photo);
            } else {
                this.nAO.setVisibility(8);
            }
            this.liu.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.nBD.startLoad(dressItemData.getPropsStateImg(), 10, false);
            setVisibility(0);
        }
    }

    public void hide() {
        setVisibility(4);
    }

    public void setController(a aVar) {
        this.nCo = aVar;
    }

    public void setFromBubbleGroup(boolean z) {
        this.nCp = z;
    }
}
