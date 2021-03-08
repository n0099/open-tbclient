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
/* loaded from: classes8.dex */
public class BackgroundItemView extends LinearLayout {
    private int eRK;
    private int eRL;
    private View.OnClickListener jjP;
    private TextView jqG;
    private TbImageView loj;
    private TbImageView lok;
    private Context mContext;
    private View mRootView;
    private ImageView nIA;
    private d nIX;
    private DressItemData nIc;
    private TbImageView nJp;
    private SkinProgressView nJq;

    public BackgroundItemView(Context context) {
        super(context);
        this.jjP = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.BackgroundItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BackgroundItemView.this.nIc != null && BackgroundItemView.this.nIX != null) {
                    if (view == BackgroundItemView.this.nJq) {
                        TiebaStatic.log(new ar("c10280").aq("obj_id", BackgroundItemView.this.nIc.getPropsId()));
                        BackgroundItemView.this.nIX.a(BackgroundItemView.this.nIc, false);
                    } else if (view == BackgroundItemView.this.loj) {
                        TiebaStatic.log(new ar("c10279").aq("obj_id", BackgroundItemView.this.nIc.getPropsId()));
                        BackgroundItemView.this.nIX.e(BackgroundItemView.this.nIc);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jjP = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.BackgroundItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BackgroundItemView.this.nIc != null && BackgroundItemView.this.nIX != null) {
                    if (view == BackgroundItemView.this.nJq) {
                        TiebaStatic.log(new ar("c10280").aq("obj_id", BackgroundItemView.this.nIc.getPropsId()));
                        BackgroundItemView.this.nIX.a(BackgroundItemView.this.nIc, false);
                    } else if (view == BackgroundItemView.this.loj) {
                        TiebaStatic.log(new ar("c10279").aq("obj_id", BackgroundItemView.this.nIc.getPropsId()));
                        BackgroundItemView.this.nIX.e(BackgroundItemView.this.nIc);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.jjP = new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.background.BackgroundItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && BackgroundItemView.this.nIc != null && BackgroundItemView.this.nIX != null) {
                    if (view == BackgroundItemView.this.nJq) {
                        TiebaStatic.log(new ar("c10280").aq("obj_id", BackgroundItemView.this.nIc.getPropsId()));
                        BackgroundItemView.this.nIX.a(BackgroundItemView.this.nIc, false);
                    } else if (view == BackgroundItemView.this.loj) {
                        TiebaStatic.log(new ar("c10279").aq("obj_id", BackgroundItemView.this.nIc.getPropsId()));
                        BackgroundItemView.this.nIX.e(BackgroundItemView.this.nIc);
                    }
                }
            }
        };
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.eRK = (l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds88)) / 3;
        this.eRL = (int) (this.eRK / 0.66d);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.background_item, this);
        this.loj = (TbImageView) this.mRootView.findViewById(R.id.bg_image);
        this.lok = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.lok.setDefaultResource(R.drawable.transparent_bg);
        this.lok.setDefaultBgResource(R.drawable.transparent_bg);
        this.nJp = (TbImageView) this.mRootView.findViewById(R.id.state_icon);
        this.nJp.setDefaultResource(R.drawable.transparent_bg);
        this.nJp.setDefaultBgResource(R.drawable.transparent_bg);
        this.nIA = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.jqG = (TextView) this.mRootView.findViewById(R.id.text_bg_name);
        this.nJq = (SkinProgressView) this.mRootView.findViewById(R.id.view_bg_use);
        this.nJq.setOnClickListener(this.jjP);
        this.loj.setOnClickListener(this.jjP);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.loj.getLayoutParams();
        layoutParams.height = this.eRL;
        layoutParams.width = this.eRK;
        this.loj.setLayoutParams(layoutParams);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nIc = dressItemData;
            Boolean valueOf = Boolean.valueOf(dressItemData.getInUse());
            if (dressItemData.getPropsId() == 0) {
                ap.setImageResource(this.loj, R.drawable.pic_bg_moren);
            } else {
                this.loj.setImageBitmap(null);
                this.loj.startLoad(dressItemData.getExampleImgUrl(), 10, false);
            }
            this.jqG.setText(dressItemData.getTitle());
            if (valueOf.booleanValue()) {
                this.nIA.setVisibility(0);
                ap.setImageResource(this.nIA, R.drawable.icon_choose_photo);
            } else {
                this.nIA.setVisibility(8);
            }
            this.lok.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.nJp.startLoad(dressItemData.getPropsStateImg(), 10, false);
            if (valueOf.booleanValue()) {
                this.nJq.m(0, 0.0f);
            } else {
                this.nJq.m(4, 0.0f);
            }
            setVisibility(0);
        }
    }

    public void hide() {
        setVisibility(8);
    }

    public void setController(d dVar) {
        this.nIX = dVar;
    }
}
