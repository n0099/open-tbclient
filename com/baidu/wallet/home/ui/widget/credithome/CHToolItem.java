package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
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
public class CHToolItem extends BaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f61043a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f61044b;

    /* renamed from: c  reason: collision with root package name */
    public NetImageView f61045c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f61046d;

    /* renamed from: e  reason: collision with root package name */
    public MaskTextView f61047e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CHToolItem(Context context) {
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

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean isShowRedDot = isShowRedDot();
            this.f61045c.setVisibility(isShowRedDot ? 0 : 8);
            this.f61045c.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_home_red_star"));
            return isShowRedDot;
        }
        return invokeV.booleanValue;
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_tool_item_view"), this);
            this.f61043a = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_tool_item_icon"));
            this.f61044b = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_tool_item_title"));
            this.f61045c = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_tool_item_star"));
            this.f61046d = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_tool_item_corner"));
            this.f61047e = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_tool_item_money"));
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || getData() == null) {
            return;
        }
        setNetImageViewUrl(this.f61043a, getData().getPicAddr());
        this.f61044b.setMaskText(getData().name);
        if (!handlePoint() && !TextUtils.isEmpty(getData().desc)) {
            this.f61046d.setVisibility(0);
            this.f61046d.setMaskText(getData().desc);
        } else {
            this.f61046d.setVisibility(8);
        }
        if (!TextUtils.isEmpty(getData().value1)) {
            this.f61047e.setVisibility(0);
            this.f61047e.setMaskText(getData().value1);
            return;
        }
        this.f61047e.setVisibility(8);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, dataItem, bVar) == null) {
            super.setData(dataItem, bVar);
            initView();
            refresh();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CHToolItem(Context context, AttributeSet attributeSet) {
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
}
