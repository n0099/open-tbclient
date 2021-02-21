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
    private TextView joX;
    private TbImageView lmf;
    private Context mContext;
    private View mRootView;
    private DressItemData nFW;
    private HeadPendantView nGt;
    private ImageView nGu;
    private c.a nGv;

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
        this.nGt = (HeadPendantView) this.mRootView.findViewById(R.id.avatar_image);
        this.lmf = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.lmf.setDefaultResource(R.drawable.transparent_bg);
        this.lmf.setDefaultBgResource(R.drawable.transparent_bg);
        this.nGu = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.joX = (TextView) this.mRootView.findViewById(R.id.text_pendant_name);
        this.nGt.setHasPendantStyle();
        if (this.nGt.getHeadView() != null) {
            this.nGt.getHeadView().setIsRound(true);
            this.nGt.getHeadView().setDrawBorder(false);
        }
        if (this.nGt.getPendantView() != null) {
            this.nGt.getPendantView().setIsRound(true);
            this.nGt.getPendantView().setDrawBorder(false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nFW = dressItemData;
            boolean inUse = dressItemData.getInUse();
            if (dressItemData.isPropIdEven()) {
                if (this.nGt.getHeadView() != null) {
                    this.nGt.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_woman), 24, false);
                }
            } else if (this.nGt.getHeadView() != null) {
                this.nGt.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_man), 24, false);
            }
            if (au.byteLength(dressItemData.getTitle()) > 8) {
                this.joX.setText(au.cutString(dressItemData.getTitle(), 8));
            } else {
                this.joX.setText(dressItemData.getTitle());
            }
            if (inUse) {
                this.nGu.setVisibility(0);
                ap.setImageResource(this.nGu, R.drawable.icon_shop_selected);
            } else {
                this.nGu.setVisibility(8);
            }
            this.lmf.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.nGt.Bz(dressItemData.getExampleImgUrl());
            this.nGt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantPerItemView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && AvatarPendantPerItemView.this.nGv != null) {
                        if (AvatarPendantPerItemView.this.nFW == null || !AvatarPendantPerItemView.this.nFW.getInUse() || !TbadkCoreApplication.isLogin()) {
                            AvatarPendantPerItemView.this.nGv.b(AvatarPendantPerItemView.this.nFW);
                        }
                    }
                }
            });
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        }
    }

    public void setAvatarPendantItemClickListener(c.a aVar) {
        this.nGv = aVar;
    }
}
