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
/* loaded from: classes9.dex */
public class AvatarPendantPerItemView extends LinearLayout {
    private TextView joJ;
    private TbImageView llR;
    private Context mContext;
    private View mRootView;
    private HeadPendantView nFT;
    private ImageView nFU;
    private c.a nFV;
    private DressItemData nFw;

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
        this.nFT = (HeadPendantView) this.mRootView.findViewById(R.id.avatar_image);
        this.llR = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.llR.setDefaultResource(R.drawable.transparent_bg);
        this.llR.setDefaultBgResource(R.drawable.transparent_bg);
        this.nFU = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.joJ = (TextView) this.mRootView.findViewById(R.id.text_pendant_name);
        this.nFT.setHasPendantStyle();
        if (this.nFT.getHeadView() != null) {
            this.nFT.getHeadView().setIsRound(true);
            this.nFT.getHeadView().setDrawBorder(false);
        }
        if (this.nFT.getPendantView() != null) {
            this.nFT.getPendantView().setIsRound(true);
            this.nFT.getPendantView().setDrawBorder(false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nFw = dressItemData;
            boolean inUse = dressItemData.getInUse();
            if (dressItemData.isPropIdEven()) {
                if (this.nFT.getHeadView() != null) {
                    this.nFT.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_woman), 24, false);
                }
            } else if (this.nFT.getHeadView() != null) {
                this.nFT.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_man), 24, false);
            }
            if (au.byteLength(dressItemData.getTitle()) > 8) {
                this.joJ.setText(au.cutString(dressItemData.getTitle(), 8));
            } else {
                this.joJ.setText(dressItemData.getTitle());
            }
            if (inUse) {
                this.nFU.setVisibility(0);
                ap.setImageResource(this.nFU, R.drawable.icon_shop_selected);
            } else {
                this.nFU.setVisibility(8);
            }
            this.llR.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.nFT.Bz(dressItemData.getExampleImgUrl());
            this.nFT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantPerItemView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && AvatarPendantPerItemView.this.nFV != null) {
                        if (AvatarPendantPerItemView.this.nFw == null || !AvatarPendantPerItemView.this.nFw.getInUse() || !TbadkCoreApplication.isLogin()) {
                            AvatarPendantPerItemView.this.nFV.b(AvatarPendantPerItemView.this.nFw);
                        }
                    }
                }
            });
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        }
    }

    public void setAvatarPendantItemClickListener(c.a aVar) {
        this.nFV = aVar;
    }
}
