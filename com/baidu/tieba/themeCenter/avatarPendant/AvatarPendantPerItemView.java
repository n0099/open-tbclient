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
/* loaded from: classes8.dex */
public class AvatarPendantPerItemView extends LinearLayout {
    private TextView jjc;
    private TbImageView ldO;
    private Context mContext;
    private View mRootView;
    private DressItemData nvL;
    private HeadPendantView nwi;
    private ImageView nwj;
    private c.a nwk;

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
        this.nwi = (HeadPendantView) this.mRootView.findViewById(R.id.avatar_image);
        this.ldO = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.ldO.setDefaultResource(R.drawable.transparent_bg);
        this.ldO.setDefaultBgResource(R.drawable.transparent_bg);
        this.nwj = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.jjc = (TextView) this.mRootView.findViewById(R.id.text_pendant_name);
        this.nwi.setHasPendantStyle();
        if (this.nwi.getHeadView() != null) {
            this.nwi.getHeadView().setIsRound(true);
            this.nwi.getHeadView().setDrawBorder(false);
        }
        if (this.nwi.getPendantView() != null) {
            this.nwi.getPendantView().setIsRound(true);
            this.nwi.getPendantView().setDrawBorder(false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nvL = dressItemData;
            boolean inUse = dressItemData.getInUse();
            if (dressItemData.isPropIdEven()) {
                if (this.nwi.getHeadView() != null) {
                    this.nwi.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_woman), 24, false);
                }
            } else if (this.nwi.getHeadView() != null) {
                this.nwi.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_man), 24, false);
            }
            if (at.byteLength(dressItemData.getTitle()) > 8) {
                this.jjc.setText(at.cutString(dressItemData.getTitle(), 8));
            } else {
                this.jjc.setText(dressItemData.getTitle());
            }
            if (inUse) {
                this.nwj.setVisibility(0);
                ao.setImageResource(this.nwj, R.drawable.icon_shop_selected);
            } else {
                this.nwj.setVisibility(8);
            }
            this.ldO.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.nwi.Bi(dressItemData.getExampleImgUrl());
            this.nwi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantPerItemView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && AvatarPendantPerItemView.this.nwk != null) {
                        if (AvatarPendantPerItemView.this.nvL == null || !AvatarPendantPerItemView.this.nvL.getInUse() || !TbadkCoreApplication.isLogin()) {
                            AvatarPendantPerItemView.this.nwk.b(AvatarPendantPerItemView.this.nvL);
                        }
                    }
                }
            });
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        }
    }

    public void setAvatarPendantItemClickListener(c.a aVar) {
        this.nwk = aVar;
    }
}
