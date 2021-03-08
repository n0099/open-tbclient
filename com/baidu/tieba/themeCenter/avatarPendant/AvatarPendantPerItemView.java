package com.baidu.tieba.themeCenter.avatarPendant;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.avatarPendant.c;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes8.dex */
public class AvatarPendantPerItemView extends LinearLayout {
    private TextView jqG;
    private TbImageView lok;
    private Context mContext;
    private View mRootView;
    private ImageView nIA;
    private c.a nIB;
    private DressItemData nIc;
    private HeadPendantView nIz;

    public AvatarPendantPerItemView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public AvatarPendantPerItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public AvatarPendantPerItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.avatar_pendant_per_item, this);
        this.nIz = (HeadPendantView) this.mRootView.findViewById(R.id.avatar_image);
        this.lok = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.lok.setDefaultResource(R.drawable.transparent_bg);
        this.lok.setDefaultBgResource(R.drawable.transparent_bg);
        this.nIA = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.jqG = (TextView) this.mRootView.findViewById(R.id.text_pendant_name);
        this.nIz.setHasPendantStyle();
        if (this.nIz.getHeadView() != null) {
            this.nIz.getHeadView().setIsRound(true);
            this.nIz.getHeadView().setDrawBorder(false);
        }
        if (this.nIz.getPendantView() != null) {
            this.nIz.getPendantView().setIsRound(true);
            this.nIz.getPendantView().setDrawBorder(false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nIc = dressItemData;
            boolean inUse = dressItemData.getInUse();
            if (dressItemData.isPropIdEven()) {
                if (this.nIz.getHeadView() != null) {
                    this.nIz.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_woman), 24, false);
                }
            } else if (this.nIz.getHeadView() != null) {
                this.nIz.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_man), 24, false);
            }
            if (au.byteLength(dressItemData.getTitle()) > 8) {
                this.jqG.setText(au.cutString(dressItemData.getTitle(), 8));
            } else {
                this.jqG.setText(dressItemData.getTitle());
            }
            if (inUse) {
                this.nIA.setVisibility(0);
                ap.setImageResource(this.nIA, R.drawable.icon_shop_selected);
            } else {
                this.nIA.setVisibility(8);
            }
            this.lok.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.nIz.BG(dressItemData.getExampleImgUrl());
            this.nIz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantPerItemView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && AvatarPendantPerItemView.this.nIB != null) {
                        if (AvatarPendantPerItemView.this.nIc == null || !AvatarPendantPerItemView.this.nIc.getInUse() || !TbadkCoreApplication.isLogin()) {
                            AvatarPendantPerItemView.this.nIB.b(AvatarPendantPerItemView.this.nIc);
                        }
                    }
                }
            });
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        }
    }

    public void setAvatarPendantItemClickListener(c.a aVar) {
        this.nIB = aVar;
    }
}
