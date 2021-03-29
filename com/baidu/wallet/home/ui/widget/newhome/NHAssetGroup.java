package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class NHAssetGroup extends BaseItemLayout {

    /* renamed from: a  reason: collision with root package name */
    public List<BaseItemView> f24710a;
    public ImageView mEye;
    public NetImageView mGroupCorner;
    public MaskTextView mGroupDesc;
    public MaskTextView mGroupTitle;
    public LinearLayout mItemPanel;
    public NetImageView mLoginBg;
    public Button mLoginButton;
    public RelativeLayout mLoginPanel;
    public RelativeLayout mMainPanel;

    public NHAssetGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24710a = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f24710a;
    }

    public void initItems() {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout.LayoutParams layoutParams3;
        this.mItemPanel.removeAllViews();
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        int dip2px = DisplayUtils.dip2px(getContext(), 20.0f);
        int dip2px2 = DisplayUtils.dip2px(getContext(), 20.0f);
        int dip2px3 = DisplayUtils.dip2px(getContext(), 20.0f);
        if (dataItemArr != null) {
            if (dataItemArr.length >= 1) {
                if (dataItemArr.length == 1) {
                    this.mItemPanel.setVisibility(0);
                    NHAssetItem nHAssetItem = new NHAssetItem(getContext());
                    nHAssetItem.setData(dataItemArr[0], getWalletInterface());
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -1);
                    layoutParams4.setMargins(dip2px, 0, dip2px2, 0);
                    this.mItemPanel.addView(nHAssetItem, layoutParams4);
                    this.f24710a.add(nHAssetItem);
                    return;
                }
                this.mItemPanel.setVisibility(0);
                NHAssetItem nHAssetItem2 = new NHAssetItem(getContext());
                nHAssetItem2.setData(dataItemArr[0], getWalletInterface());
                NHAssetItem nHAssetItem3 = new NHAssetItem(getContext());
                nHAssetItem3.setData(dataItemArr[1], getWalletInterface());
                int displayWidth = DisplayUtils.getDisplayWidth(getContext());
                int a2 = a(nHAssetItem2);
                int a3 = a(nHAssetItem3);
                int i = ((displayWidth - dip2px) - dip2px3) - dip2px2;
                int i2 = i / 2;
                boolean z = a2 > i2;
                boolean z2 = a3 > i2;
                LinearLayout.LayoutParams layoutParams5 = null;
                if (z == z2) {
                    layoutParams5 = new LinearLayout.LayoutParams(0, -1);
                    layoutParams5.weight = 1.0f;
                    layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = 1.0f;
                } else if (z) {
                    if ((i - a2) - a3 <= 0) {
                        layoutParams2 = new LinearLayout.LayoutParams(0, -1);
                        layoutParams2.weight = 1.0f;
                        layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
                    } else {
                        layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
                        layoutParams3 = new LinearLayout.LayoutParams(0, -1);
                        layoutParams3.weight = 1.0f;
                    }
                    layoutParams5 = layoutParams2;
                    layoutParams = layoutParams3;
                } else if (!z2) {
                    layoutParams = null;
                } else if ((i - a2) - a3 <= 0) {
                    layoutParams5 = new LinearLayout.LayoutParams(-2, -1);
                    layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = 1.0f;
                } else {
                    layoutParams5 = new LinearLayout.LayoutParams(0, -1);
                    layoutParams5.weight = 1.0f;
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                }
                layoutParams5.setMargins(dip2px, 0, 0, 0);
                layoutParams.setMargins(dip2px3, 0, dip2px2, 0);
                this.mItemPanel.addView(nHAssetItem2, layoutParams5);
                this.mItemPanel.addView(nHAssetItem3, layoutParams);
                this.f24710a.add(nHAssetItem2);
                this.f24710a.add(nHAssetItem3);
                return;
            }
        }
        this.mItemPanel.setVisibility(8);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_asset_layout"), this);
        this.mLoginPanel = (RelativeLayout) findViewById(ResUtils.id(getContext(), "asset_login_panel"));
        this.mLoginBg = (NetImageView) findViewById(ResUtils.id(getContext(), "asset_login_bg"));
        int displayWidth = (DisplayUtils.getDisplayWidth(getContext()) * 122) / 375;
        this.mLoginPanel.setLayoutParams(new LinearLayout.LayoutParams(-1, displayWidth));
        Button button = (Button) findViewById(ResUtils.id(getContext(), "asset_login_button"));
        this.mLoginButton = button;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) button.getLayoutParams();
        layoutParams.topMargin = (displayWidth * 71) / 122;
        this.mLoginButton.setLayoutParams(layoutParams);
        this.mMainPanel = (RelativeLayout) findViewById(ResUtils.id(getContext(), "asset_main_panel"));
        this.mGroupDesc = (MaskTextView) findViewById(ResUtils.id(getContext(), "asset_group_desc"));
        this.mGroupTitle = (MaskTextView) findViewById(ResUtils.id(getContext(), "asset_group_title"));
        this.mGroupCorner = (NetImageView) findViewById(ResUtils.id(getContext(), "asset_group_corner"));
        this.mEye = (ImageView) findViewById(ResUtils.id(getContext(), "asset_eye"));
        this.mItemPanel = (LinearLayout) findViewById(ResUtils.id(getContext(), "asset_item_panel"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        return this.mConfigData != null;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        this.mGroupDesc.resetMaskText();
        this.mGroupTitle.resetMaskText();
        if (this.mEye != null) {
            this.mEye.setImageResource(ResUtils.drawable(getContext(), com.baidu.wallet.home.storage.a.a(getContext()) ? "wallet_home_nh_cye_mask_on" : "wallet_home_nh_cye_mask_off"));
        }
        if (isDataValid()) {
            initItems();
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        boolean isLoginData = getWalletInterface().isLoginData();
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        boolean z = dataItemArr != null && dataItemArr.length > 0;
        if (isLoginData) {
            this.mLoginPanel.setVisibility(8);
            this.mMainPanel.setVisibility(0);
            this.mGroupTitle.setMaskText(this.mConfigData.getGroup_name());
            this.mGroupDesc.setMaskText(this.mConfigData.getGroup_desc());
            if (!TextUtils.isEmpty(this.mConfigData.group_corner_addr)) {
                this.mGroupCorner.setVisibility(0);
                if (getWalletInterface() != null) {
                    NetImageView netImageView = this.mGroupCorner;
                    netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + this.mConfigData.group_corner_addr);
                }
            } else {
                this.mGroupCorner.setVisibility(8);
            }
            this.mEye.setImageResource(ResUtils.drawable(getContext(), com.baidu.wallet.home.storage.a.a(getContext()) ? "wallet_home_nh_cye_mask_on" : "wallet_home_nh_cye_mask_off"));
            this.mEye.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.newhome.NHAssetGroup.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CheckUtils.isFastDoubleClick()) {
                        return;
                    }
                    NHAssetGroup.this.getWalletInterface().onEyeMaskBtnClick();
                }
            });
            this.mMainPanel.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.newhome.NHAssetGroup.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    NHAssetGroup.this.getWalletInterface().jump(NHAssetGroup.this.mConfigData.getGroup_name(), NHAssetGroup.this.mConfigData.getGroup_type(), NHAssetGroup.this.mConfigData.getGroup_link(), NHAssetGroup.this.mConfigData.getGroup_prevlogin());
                }
            });
            this.mItemPanel.setVisibility(z ? 0 : 8);
            if (z) {
                initItems();
                return;
            }
            return;
        }
        this.mLoginPanel.setVisibility(0);
        this.mMainPanel.setVisibility(8);
        this.mItemPanel.setVisibility(8);
        NetImageView netImageView2 = this.mLoginBg;
        netImageView2.setImageUrl(getWalletInterface().getAndroidPrefix() + this.mConfigData.getGroup_logo());
        this.mLoginButton.setText(this.mConfigData.getGroup_name());
        this.mLoginButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.newhome.NHAssetGroup.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CheckUtils.isFastDoubleClick()) {
                    return;
                }
                NHAssetGroup.this.getWalletInterface().login();
            }
        });
    }

    private int a(View view) {
        com.baidu.wallet.home.ui.a.a(view);
        return view.getMeasuredWidth();
    }

    public NHAssetGroup(Context context) {
        super(context);
        this.f24710a = new ArrayList();
    }
}
