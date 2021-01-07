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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.avatarPendant.c;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes9.dex */
public class AvatarPendantPerItemView extends LinearLayout {
    private TextView jnJ;
    private TbImageView liu;
    private Context mContext;
    private View mRootView;
    private HeadPendantView nAN;
    private ImageView nAO;
    private c.a nAP;
    private DressItemData nAq;

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
        this.nAN = (HeadPendantView) this.mRootView.findViewById(R.id.avatar_image);
        this.liu = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.liu.setDefaultResource(R.drawable.transparent_bg);
        this.liu.setDefaultBgResource(R.drawable.transparent_bg);
        this.nAO = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.jnJ = (TextView) this.mRootView.findViewById(R.id.text_pendant_name);
        this.nAN.setHasPendantStyle();
        if (this.nAN.getHeadView() != null) {
            this.nAN.getHeadView().setIsRound(true);
            this.nAN.getHeadView().setDrawBorder(false);
        }
        if (this.nAN.getPendantView() != null) {
            this.nAN.getPendantView().setIsRound(true);
            this.nAN.getPendantView().setDrawBorder(false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nAq = dressItemData;
            boolean inUse = dressItemData.getInUse();
            if (dressItemData.isPropIdEven()) {
                if (this.nAN.getHeadView() != null) {
                    this.nAN.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_woman), 24, false);
                }
            } else if (this.nAN.getHeadView() != null) {
                this.nAN.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_man), 24, false);
            }
            if (at.byteLength(dressItemData.getTitle()) > 8) {
                this.jnJ.setText(at.cutString(dressItemData.getTitle(), 8));
            } else {
                this.jnJ.setText(dressItemData.getTitle());
            }
            if (inUse) {
                this.nAO.setVisibility(0);
                ao.setImageResource(this.nAO, R.drawable.icon_shop_selected);
            } else {
                this.nAO.setVisibility(8);
            }
            this.liu.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.nAN.Ct(dressItemData.getExampleImgUrl());
            this.nAN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantPerItemView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && AvatarPendantPerItemView.this.nAP != null) {
                        if (AvatarPendantPerItemView.this.nAq == null || !AvatarPendantPerItemView.this.nAq.getInUse() || !TbadkCoreApplication.isLogin()) {
                            AvatarPendantPerItemView.this.nAP.b(AvatarPendantPerItemView.this.nAq);
                        }
                    }
                }
            });
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        }
    }

    public void setAvatarPendantItemClickListener(c.a aVar) {
        this.nAP = aVar;
    }
}
