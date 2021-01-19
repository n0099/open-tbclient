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
/* loaded from: classes8.dex */
public class BackgroundItemView extends LinearLayout {
    private int eNX;
    private int eNY;
    private View.OnClickListener jcl;
    private TextView jjc;
    private TbImageView ldN;
    private TbImageView ldO;
    private Context mContext;
    private View mRootView;
    private DressItemData nvM;
    private d nwH;
    private TbImageView nwZ;
    private ImageView nwk;
    private SkinProgressView nxa;

    public BackgroundItemView(Context context) {
        super(context);
        this.jcl = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.BackgroundItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BackgroundItemView.this.nvM != null && BackgroundItemView.this.nwH != null) {
                    if (view == BackgroundItemView.this.nxa) {
                        TiebaStatic.log(new aq("c10280").an("obj_id", BackgroundItemView.this.nvM.getPropsId()));
                        BackgroundItemView.this.nwH.a(BackgroundItemView.this.nvM, false);
                    } else if (view == BackgroundItemView.this.ldN) {
                        TiebaStatic.log(new aq("c10279").an("obj_id", BackgroundItemView.this.nvM.getPropsId()));
                        BackgroundItemView.this.nwH.e(BackgroundItemView.this.nvM);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jcl = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.BackgroundItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BackgroundItemView.this.nvM != null && BackgroundItemView.this.nwH != null) {
                    if (view == BackgroundItemView.this.nxa) {
                        TiebaStatic.log(new aq("c10280").an("obj_id", BackgroundItemView.this.nvM.getPropsId()));
                        BackgroundItemView.this.nwH.a(BackgroundItemView.this.nvM, false);
                    } else if (view == BackgroundItemView.this.ldN) {
                        TiebaStatic.log(new aq("c10279").an("obj_id", BackgroundItemView.this.nvM.getPropsId()));
                        BackgroundItemView.this.nwH.e(BackgroundItemView.this.nvM);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.jcl = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.BackgroundItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BackgroundItemView.this.nvM != null && BackgroundItemView.this.nwH != null) {
                    if (view == BackgroundItemView.this.nxa) {
                        TiebaStatic.log(new aq("c10280").an("obj_id", BackgroundItemView.this.nvM.getPropsId()));
                        BackgroundItemView.this.nwH.a(BackgroundItemView.this.nvM, false);
                    } else if (view == BackgroundItemView.this.ldN) {
                        TiebaStatic.log(new aq("c10279").an("obj_id", BackgroundItemView.this.nvM.getPropsId()));
                        BackgroundItemView.this.nwH.e(BackgroundItemView.this.nvM);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.eNX = (l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds88)) / 3;
        this.eNY = (int) (this.eNX / 0.66d);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.background_item, this);
        this.ldN = (TbImageView) this.mRootView.findViewById(R.id.bg_image);
        this.ldO = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.ldO.setDefaultResource(R.drawable.transparent_bg);
        this.ldO.setDefaultBgResource(R.drawable.transparent_bg);
        this.nwZ = (TbImageView) this.mRootView.findViewById(R.id.state_icon);
        this.nwZ.setDefaultResource(R.drawable.transparent_bg);
        this.nwZ.setDefaultBgResource(R.drawable.transparent_bg);
        this.nwk = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.jjc = (TextView) this.mRootView.findViewById(R.id.text_bg_name);
        this.nxa = (SkinProgressView) this.mRootView.findViewById(R.id.view_bg_use);
        this.nxa.setOnClickListener(this.jcl);
        this.ldN.setOnClickListener(this.jcl);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ldN.getLayoutParams();
        layoutParams.height = this.eNY;
        layoutParams.width = this.eNX;
        this.ldN.setLayoutParams(layoutParams);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nvM = dressItemData;
            Boolean valueOf = Boolean.valueOf(dressItemData.getInUse());
            if (dressItemData.getPropsId() == 0) {
                ao.setImageResource(this.ldN, R.drawable.pic_bg_moren);
            } else {
                this.ldN.setImageBitmap(null);
                this.ldN.startLoad(dressItemData.getExampleImgUrl(), 10, false);
            }
            this.jjc.setText(dressItemData.getTitle());
            if (valueOf.booleanValue()) {
                this.nwk.setVisibility(0);
                ao.setImageResource(this.nwk, R.drawable.icon_choose_photo);
            } else {
                this.nwk.setVisibility(8);
            }
            this.ldO.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.nwZ.startLoad(dressItemData.getPropsStateImg(), 10, false);
            if (valueOf.booleanValue()) {
                this.nxa.n(0, 0.0f);
            } else {
                this.nxa.n(4, 0.0f);
            }
            setVisibility(0);
        }
    }

    public void hide() {
        setVisibility(8);
    }

    public void setController(d dVar) {
        this.nwH = dVar;
    }
}
