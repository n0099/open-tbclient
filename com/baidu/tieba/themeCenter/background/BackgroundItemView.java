package com.baidu.tieba.themeCenter.background;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes9.dex */
public class BackgroundItemView extends LinearLayout {
    private int eSI;
    private int eSJ;
    private View.OnClickListener jgS;
    private TextView jnJ;
    private TbImageView lit;
    private TbImageView liu;
    private Context mContext;
    private View mRootView;
    private ImageView nAO;
    private DressItemData nAq;
    private TbImageView nBD;
    private SkinProgressView nBE;
    private d nBl;

    public BackgroundItemView(Context context) {
        super(context);
        this.jgS = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.BackgroundItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BackgroundItemView.this.nAq != null && BackgroundItemView.this.nBl != null) {
                    if (view == BackgroundItemView.this.nBE) {
                        TiebaStatic.log(new aq("c10280").an("obj_id", BackgroundItemView.this.nAq.getPropsId()));
                        BackgroundItemView.this.nBl.a(BackgroundItemView.this.nAq, false);
                    } else if (view == BackgroundItemView.this.lit) {
                        TiebaStatic.log(new aq("c10279").an("obj_id", BackgroundItemView.this.nAq.getPropsId()));
                        BackgroundItemView.this.nBl.e(BackgroundItemView.this.nAq);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jgS = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.BackgroundItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BackgroundItemView.this.nAq != null && BackgroundItemView.this.nBl != null) {
                    if (view == BackgroundItemView.this.nBE) {
                        TiebaStatic.log(new aq("c10280").an("obj_id", BackgroundItemView.this.nAq.getPropsId()));
                        BackgroundItemView.this.nBl.a(BackgroundItemView.this.nAq, false);
                    } else if (view == BackgroundItemView.this.lit) {
                        TiebaStatic.log(new aq("c10279").an("obj_id", BackgroundItemView.this.nAq.getPropsId()));
                        BackgroundItemView.this.nBl.e(BackgroundItemView.this.nAq);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.jgS = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.BackgroundItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BackgroundItemView.this.nAq != null && BackgroundItemView.this.nBl != null) {
                    if (view == BackgroundItemView.this.nBE) {
                        TiebaStatic.log(new aq("c10280").an("obj_id", BackgroundItemView.this.nAq.getPropsId()));
                        BackgroundItemView.this.nBl.a(BackgroundItemView.this.nAq, false);
                    } else if (view == BackgroundItemView.this.lit) {
                        TiebaStatic.log(new aq("c10279").an("obj_id", BackgroundItemView.this.nAq.getPropsId()));
                        BackgroundItemView.this.nBl.e(BackgroundItemView.this.nAq);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.eSI = (l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds88)) / 3;
        this.eSJ = (int) (this.eSI / 0.66d);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.background_item, this);
        this.lit = (TbImageView) this.mRootView.findViewById(R.id.bg_image);
        this.liu = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.liu.setDefaultResource(R.drawable.transparent_bg);
        this.liu.setDefaultBgResource(R.drawable.transparent_bg);
        this.nBD = (TbImageView) this.mRootView.findViewById(R.id.state_icon);
        this.nBD.setDefaultResource(R.drawable.transparent_bg);
        this.nBD.setDefaultBgResource(R.drawable.transparent_bg);
        this.nAO = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.jnJ = (TextView) this.mRootView.findViewById(R.id.text_bg_name);
        this.nBE = (SkinProgressView) this.mRootView.findViewById(R.id.view_bg_use);
        this.nBE.setOnClickListener(this.jgS);
        this.lit.setOnClickListener(this.jgS);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lit.getLayoutParams();
        layoutParams.height = this.eSJ;
        layoutParams.width = this.eSI;
        this.lit.setLayoutParams(layoutParams);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nAq = dressItemData;
            Boolean valueOf = Boolean.valueOf(dressItemData.getInUse());
            if (dressItemData.getPropsId() == 0) {
                ao.setImageResource(this.lit, R.drawable.pic_bg_moren);
            } else {
                this.lit.setImageBitmap(null);
                this.lit.startLoad(dressItemData.getExampleImgUrl(), 10, false);
            }
            this.jnJ.setText(dressItemData.getTitle());
            if (valueOf.booleanValue()) {
                this.nAO.setVisibility(0);
                ao.setImageResource(this.nAO, R.drawable.icon_choose_photo);
            } else {
                this.nAO.setVisibility(8);
            }
            this.liu.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.nBD.startLoad(dressItemData.getPropsStateImg(), 10, false);
            if (valueOf.booleanValue()) {
                this.nBE.n(0, 0.0f);
            } else {
                this.nBE.n(4, 0.0f);
            }
            setVisibility(0);
        }
    }

    public void hide() {
        setVisibility(8);
    }

    public void setController(d dVar) {
        this.nBl = dVar;
    }
}
