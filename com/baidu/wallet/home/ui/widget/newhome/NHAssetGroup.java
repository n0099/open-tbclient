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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class NHAssetGroup extends BaseItemLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<BaseItemView> f25170a;
    public ImageView mEye;
    public NetImageView mGroupCorner;
    public MaskTextView mGroupDesc;
    public MaskTextView mGroupTitle;
    public LinearLayout mItemPanel;
    public NetImageView mLoginBg;
    public Button mLoginButton;
    public RelativeLayout mLoginPanel;
    public RelativeLayout mMainPanel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHAssetGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f25170a = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25170a : (List) invokeV.objValue;
    }

    public void initItems() {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout.LayoutParams layoutParams3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
                        this.f25170a.add(nHAssetItem);
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
                    int i2 = ((displayWidth - dip2px) - dip2px3) - dip2px2;
                    int i3 = i2 / 2;
                    boolean z = a2 > i3;
                    boolean z2 = a3 > i3;
                    LinearLayout.LayoutParams layoutParams5 = null;
                    if (z == z2) {
                        layoutParams5 = new LinearLayout.LayoutParams(0, -1);
                        layoutParams5.weight = 1.0f;
                        layoutParams = new LinearLayout.LayoutParams(0, -1);
                        layoutParams.weight = 1.0f;
                    } else if (z) {
                        if ((i2 - a2) - a3 <= 0) {
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
                    } else if ((i2 - a2) - a3 <= 0) {
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
                    this.f25170a.add(nHAssetItem2);
                    this.f25170a.add(nHAssetItem3);
                    return;
                }
            }
            this.mItemPanel.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mConfigData != null : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void onEyeMaskChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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
                this.mEye.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.home.ui.widget.newhome.NHAssetGroup.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ NHAssetGroup f25171a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f25171a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || CheckUtils.isFastDoubleClick()) {
                            return;
                        }
                        this.f25171a.getWalletInterface().onEyeMaskBtnClick();
                    }
                });
                this.mMainPanel.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.home.ui.widget.newhome.NHAssetGroup.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ NHAssetGroup f25172a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f25172a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f25172a.getWalletInterface().jump(this.f25172a.mConfigData.getGroup_name(), this.f25172a.mConfigData.getGroup_type(), this.f25172a.mConfigData.getGroup_link(), this.f25172a.mConfigData.getGroup_prevlogin());
                        }
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
            this.mLoginButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.home.ui.widget.newhome.NHAssetGroup.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NHAssetGroup f25173a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25173a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || CheckUtils.isFastDoubleClick()) {
                        return;
                    }
                    this.f25173a.getWalletInterface().login();
                }
            });
        }
    }

    private int a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, view)) == null) {
            com.baidu.wallet.home.ui.a.a(view);
            return view.getMeasuredWidth();
        }
        return invokeL.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHAssetGroup(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25170a = new ArrayList();
    }
}
