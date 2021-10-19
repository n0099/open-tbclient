package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes8.dex */
public class NHAssetItem extends BaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MaskTextView f61594a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f61595b;

    /* renamed from: c  reason: collision with root package name */
    public NetImageView f61596c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f61597d;

    /* renamed from: e  reason: collision with root package name */
    public MaskTextView f61598e;

    /* renamed from: f  reason: collision with root package name */
    public MaskTextView f61599f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHAssetItem(Context context, AttributeSet attributeSet) {
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
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean isShowRedDot = isShowRedDot();
            this.f61596c.setVisibility(isShowRedDot ? 0 : 8);
            this.f61596c.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_home_red_star"));
            return isShowRedDot;
        }
        return invokeV.booleanValue;
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_asset_item"), this);
            this.f61594a = (MaskTextView) findViewById(ResUtils.id(getContext(), "asset_item_subtitle"));
            this.f61595b = (MaskTextView) findViewById(ResUtils.id(getContext(), "asset_item_title"));
            this.f61596c = (NetImageView) findViewById(ResUtils.id(getContext(), "asset_item_star"));
            this.f61597d = (LinearLayout) findViewById(ResUtils.id(getContext(), "asset_item_desc_panel"));
            this.f61598e = (MaskTextView) findViewById(ResUtils.id(getContext(), "asset_item_subdesc"));
            this.f61599f = (MaskTextView) findViewById(ResUtils.id(getContext(), "asset_item_desc"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onEyeMaskChanged();
            this.f61594a.resetMaskText();
            this.f61595b.resetMaskText();
            this.f61598e.resetMaskText();
            this.f61599f.resetMaskText();
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || getData() == null) {
            return;
        }
        this.f61594a.setMaskText(getData().name);
        this.f61595b.setMaskText(getData().value1);
        if (TextUtils.isEmpty(getData().value3)) {
            this.f61597d.setVisibility(8);
        } else {
            this.f61597d.setVisibility(0);
            this.f61598e.setMaskText(getData().value2);
            this.f61599f.setMaskText(getData().value3);
        }
        handlePoint();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, dataItem, bVar) == null) {
            super.setData(dataItem, bVar);
            initView();
            refresh();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHAssetItem(Context context) {
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
    }
}
