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
    private View.OnClickListener jhR;
    private TextView joJ;
    private TbImageView llQ;
    private TbImageView llR;
    private Context mContext;
    private View mRootView;
    private ImageView nFU;
    private DressItemData nFw;
    private TbImageView nGJ;
    private SkinProgressView nGK;
    private d nGr;

    public BackgroundItemView(Context context) {
        super(context);
        this.jhR = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.BackgroundItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BackgroundItemView.this.nFw != null && BackgroundItemView.this.nGr != null) {
                    if (view == BackgroundItemView.this.nGK) {
                        TiebaStatic.log(new ar("c10280").ap("obj_id", BackgroundItemView.this.nFw.getPropsId()));
                        BackgroundItemView.this.nGr.a(BackgroundItemView.this.nFw, false);
                    } else if (view == BackgroundItemView.this.llQ) {
                        TiebaStatic.log(new ar("c10279").ap("obj_id", BackgroundItemView.this.nFw.getPropsId()));
                        BackgroundItemView.this.nGr.e(BackgroundItemView.this.nFw);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jhR = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.BackgroundItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BackgroundItemView.this.nFw != null && BackgroundItemView.this.nGr != null) {
                    if (view == BackgroundItemView.this.nGK) {
                        TiebaStatic.log(new ar("c10280").ap("obj_id", BackgroundItemView.this.nFw.getPropsId()));
                        BackgroundItemView.this.nGr.a(BackgroundItemView.this.nFw, false);
                    } else if (view == BackgroundItemView.this.llQ) {
                        TiebaStatic.log(new ar("c10279").ap("obj_id", BackgroundItemView.this.nFw.getPropsId()));
                        BackgroundItemView.this.nGr.e(BackgroundItemView.this.nFw);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.jhR = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.BackgroundItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BackgroundItemView.this.nFw != null && BackgroundItemView.this.nGr != null) {
                    if (view == BackgroundItemView.this.nGK) {
                        TiebaStatic.log(new ar("c10280").ap("obj_id", BackgroundItemView.this.nFw.getPropsId()));
                        BackgroundItemView.this.nGr.a(BackgroundItemView.this.nFw, false);
                    } else if (view == BackgroundItemView.this.llQ) {
                        TiebaStatic.log(new ar("c10279").ap("obj_id", BackgroundItemView.this.nFw.getPropsId()));
                        BackgroundItemView.this.nGr.e(BackgroundItemView.this.nFw);
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
        this.llQ = (TbImageView) this.mRootView.findViewById(R.id.bg_image);
        this.llR = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.llR.setDefaultResource(R.drawable.transparent_bg);
        this.llR.setDefaultBgResource(R.drawable.transparent_bg);
        this.nGJ = (TbImageView) this.mRootView.findViewById(R.id.state_icon);
        this.nGJ.setDefaultResource(R.drawable.transparent_bg);
        this.nGJ.setDefaultBgResource(R.drawable.transparent_bg);
        this.nFU = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.joJ = (TextView) this.mRootView.findViewById(R.id.text_bg_name);
        this.nGK = (SkinProgressView) this.mRootView.findViewById(R.id.view_bg_use);
        this.nGK.setOnClickListener(this.jhR);
        this.llQ.setOnClickListener(this.jhR);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.llQ.getLayoutParams();
        layoutParams.height = this.eQk;
        layoutParams.width = this.eQj;
        this.llQ.setLayoutParams(layoutParams);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nFw = dressItemData;
            Boolean valueOf = Boolean.valueOf(dressItemData.getInUse());
            if (dressItemData.getPropsId() == 0) {
                ap.setImageResource(this.llQ, R.drawable.pic_bg_moren);
            } else {
                this.llQ.setImageBitmap(null);
                this.llQ.startLoad(dressItemData.getExampleImgUrl(), 10, false);
            }
            this.joJ.setText(dressItemData.getTitle());
            if (valueOf.booleanValue()) {
                this.nFU.setVisibility(0);
                ap.setImageResource(this.nFU, R.drawable.icon_choose_photo);
            } else {
                this.nFU.setVisibility(8);
            }
            this.llR.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.nGJ.startLoad(dressItemData.getPropsStateImg(), 10, false);
            if (valueOf.booleanValue()) {
                this.nGK.m(0, 0.0f);
            } else {
                this.nGK.m(4, 0.0f);
            }
            setVisibility(0);
        }
    }

    public void hide() {
        setVisibility(8);
    }

    public void setController(d dVar) {
        this.nGr = dVar;
    }
}
