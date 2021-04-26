package com.baidu.wallet.home.ui.widget.umoneyhome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.GridLayout;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import java.util.List;
/* loaded from: classes5.dex */
public class UMHGuideGroup extends BaseItemLayout {
    public static final int LEAST_ITEM = 3;
    public static final int MAX_ITEM = 6;
    public static final int MIN_ITEM = 1;
    public GridLayout mGridLayout;
    public NetImageView mPicture;
    public UMHTitleView mTitle;

    public UMHGuideGroup(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return null;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_guide_layout"), this);
        this.mTitle = (UMHTitleView) findViewById(ResUtils.id(getContext(), "guide_group_title"));
        NetImageView netImageView = (NetImageView) findViewById(ResUtils.id(getContext(), "guide_group_pic"));
        this.mPicture = netImageView;
        ViewGroup.LayoutParams layoutParams = netImageView.getLayoutParams();
        layoutParams.height = (DisplayUtils.getDisplayWidth(getContext()) * 189) / 750;
        this.mPicture.setLayoutParams(layoutParams);
        this.mGridLayout = (GridLayout) findViewById(ResUtils.id(getContext(), "guide_group_grid"));
        this.mPicture.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.umoneyhome.UMHGuideGroup.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UMHGuideGroup.this.getWalletInterface().jump(UMHGuideGroup.this.mConfigData.stat != null ? UMHGuideGroup.this.mConfigData.stat.getName() : UMHGuideGroup.this.mConfigData.getGroup_name(), UMHGuideGroup.this.mConfigData.getGroup_type(), UMHGuideGroup.this.mConfigData.getGroup_link(), UMHGuideGroup.this.mConfigData.getGroup_prevlogin());
            }
        });
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length < 1) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        if (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length < 1) {
            return;
        }
        int i2 = 3;
        this.mGridLayout.setColumnCount(3);
        this.mGridLayout.setHorizontalSpacing(0);
        this.mGridLayout.setVerticalSpacing(0);
        this.mGridLayout.setEmptyAreaColor(ResUtils.getColor(getContext(), "bd_wallet_white"));
        this.mTitle.setData(this.mConfigData, getWalletInterface());
        NetImageView netImageView = this.mPicture;
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + this.mConfigData.group_logo);
        HomeCfgResponse.DataItem[] dataItemArr2 = this.mConfigData.list;
        int length = dataItemArr2.length;
        if (length < 3) {
            this.mGridLayout.setVisibility(8);
            i2 = 0;
        } else if (length >= 6) {
            i2 = 6;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (dataItemArr2[i3] != null) {
                UMHGuideItem uMHGuideItem = new UMHGuideItem(getContext());
                uMHGuideItem.setData(dataItemArr2[i3], getWalletInterface());
                this.mGridLayout.addView(uMHGuideItem);
            }
        }
    }

    public UMHGuideGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
