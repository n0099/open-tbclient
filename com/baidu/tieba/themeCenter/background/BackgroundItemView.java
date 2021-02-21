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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes9.dex */
public class BackgroundItemView extends LinearLayout {
    private int eQj;
    private int eQk;
    private View.OnClickListener jig;
    private TextView joX;
    private TbImageView lme;
    private TbImageView lmf;
    private Context mContext;
    private View mRootView;
    private DressItemData nFW;
    private d nGR;
    private ImageView nGu;
    private TbImageView nHj;
    private SkinProgressView nHk;

    public BackgroundItemView(Context context) {
        super(context);
        this.jig = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.BackgroundItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BackgroundItemView.this.nFW != null && BackgroundItemView.this.nGR != null) {
                    if (view == BackgroundItemView.this.nHk) {
                        TiebaStatic.log(new ar("c10280").ap("obj_id", BackgroundItemView.this.nFW.getPropsId()));
                        BackgroundItemView.this.nGR.a(BackgroundItemView.this.nFW, false);
                    } else if (view == BackgroundItemView.this.lme) {
                        TiebaStatic.log(new ar("c10279").ap("obj_id", BackgroundItemView.this.nFW.getPropsId()));
                        BackgroundItemView.this.nGR.e(BackgroundItemView.this.nFW);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jig = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.BackgroundItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BackgroundItemView.this.nFW != null && BackgroundItemView.this.nGR != null) {
                    if (view == BackgroundItemView.this.nHk) {
                        TiebaStatic.log(new ar("c10280").ap("obj_id", BackgroundItemView.this.nFW.getPropsId()));
                        BackgroundItemView.this.nGR.a(BackgroundItemView.this.nFW, false);
                    } else if (view == BackgroundItemView.this.lme) {
                        TiebaStatic.log(new ar("c10279").ap("obj_id", BackgroundItemView.this.nFW.getPropsId()));
                        BackgroundItemView.this.nGR.e(BackgroundItemView.this.nFW);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.jig = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.BackgroundItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BackgroundItemView.this.nFW != null && BackgroundItemView.this.nGR != null) {
                    if (view == BackgroundItemView.this.nHk) {
                        TiebaStatic.log(new ar("c10280").ap("obj_id", BackgroundItemView.this.nFW.getPropsId()));
                        BackgroundItemView.this.nGR.a(BackgroundItemView.this.nFW, false);
                    } else if (view == BackgroundItemView.this.lme) {
                        TiebaStatic.log(new ar("c10279").ap("obj_id", BackgroundItemView.this.nFW.getPropsId()));
                        BackgroundItemView.this.nGR.e(BackgroundItemView.this.nFW);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.eQj = (l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds88)) / 3;
        this.eQk = (int) (this.eQj / 0.66d);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.background_item, this);
        this.lme = (TbImageView) this.mRootView.findViewById(R.id.bg_image);
        this.lmf = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.lmf.setDefaultResource(R.drawable.transparent_bg);
        this.lmf.setDefaultBgResource(R.drawable.transparent_bg);
        this.nHj = (TbImageView) this.mRootView.findViewById(R.id.state_icon);
        this.nHj.setDefaultResource(R.drawable.transparent_bg);
        this.nHj.setDefaultBgResource(R.drawable.transparent_bg);
        this.nGu = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.joX = (TextView) this.mRootView.findViewById(R.id.text_bg_name);
        this.nHk = (SkinProgressView) this.mRootView.findViewById(R.id.view_bg_use);
        this.nHk.setOnClickListener(this.jig);
        this.lme.setOnClickListener(this.jig);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lme.getLayoutParams();
        layoutParams.height = this.eQk;
        layoutParams.width = this.eQj;
        this.lme.setLayoutParams(layoutParams);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nFW = dressItemData;
            Boolean valueOf = Boolean.valueOf(dressItemData.getInUse());
            if (dressItemData.getPropsId() == 0) {
                ap.setImageResource(this.lme, R.drawable.pic_bg_moren);
            } else {
                this.lme.setImageBitmap(null);
                this.lme.startLoad(dressItemData.getExampleImgUrl(), 10, false);
            }
            this.joX.setText(dressItemData.getTitle());
            if (valueOf.booleanValue()) {
                this.nGu.setVisibility(0);
                ap.setImageResource(this.nGu, R.drawable.icon_choose_photo);
            } else {
                this.nGu.setVisibility(8);
            }
            this.lmf.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.nHj.startLoad(dressItemData.getPropsStateImg(), 10, false);
            if (valueOf.booleanValue()) {
                this.nHk.m(0, 0.0f);
            } else {
                this.nHk.m(4, 0.0f);
            }
            setVisibility(0);
        }
    }

    public void hide() {
        setVisibility(8);
    }

    public void setController(d dVar) {
        this.nGR = dVar;
    }
}
