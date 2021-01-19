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
    private DressItemData nvM;
    private HeadPendantView nwj;
    private ImageView nwk;
    private c.a nwl;

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
        this.nwj = (HeadPendantView) this.mRootView.findViewById(R.id.avatar_image);
        this.ldO = (TbImageView) this.mRootView.findViewById(R.id.permission_icon);
        this.ldO.setDefaultResource(R.drawable.transparent_bg);
        this.ldO.setDefaultBgResource(R.drawable.transparent_bg);
        this.nwk = (ImageView) this.mRootView.findViewById(R.id.choosed_icon);
        this.jjc = (TextView) this.mRootView.findViewById(R.id.text_pendant_name);
        this.nwj.setHasPendantStyle();
        if (this.nwj.getHeadView() != null) {
            this.nwj.getHeadView().setIsRound(true);
            this.nwj.getHeadView().setDrawBorder(false);
        }
        if (this.nwj.getPendantView() != null) {
            this.nwj.getPendantView().setIsRound(true);
            this.nwj.getPendantView().setDrawBorder(false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nvM = dressItemData;
            boolean inUse = dressItemData.getInUse();
            if (dressItemData.isPropIdEven()) {
                if (this.nwj.getHeadView() != null) {
                    this.nwj.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_woman), 24, false);
                }
            } else if (this.nwj.getHeadView() != null) {
                this.nwj.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_man), 24, false);
            }
            if (at.byteLength(dressItemData.getTitle()) > 8) {
                this.jjc.setText(at.cutString(dressItemData.getTitle(), 8));
            } else {
                this.jjc.setText(dressItemData.getTitle());
            }
            if (inUse) {
                this.nwk.setVisibility(0);
                ao.setImageResource(this.nwk, R.drawable.icon_shop_selected);
            } else {
                this.nwk.setVisibility(8);
            }
            this.ldO.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.nwj.Bi(dressItemData.getExampleImgUrl());
            this.nwj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantPerItemView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && AvatarPendantPerItemView.this.nwl != null) {
                        if (AvatarPendantPerItemView.this.nvM == null || !AvatarPendantPerItemView.this.nvM.getInUse() || !TbadkCoreApplication.isLogin()) {
                            AvatarPendantPerItemView.this.nwl.b(AvatarPendantPerItemView.this.nvM);
                        }
                    }
                }
            });
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        }
    }

    public void setAvatarPendantItemClickListener(c.a aVar) {
        this.nwl = aVar;
    }
}
