package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.storage.a;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes5.dex */
public class CHFinanceUserItem extends BaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f25286a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f25287b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f25288c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f25289d;

    /* renamed from: e  reason: collision with root package name */
    public MaskTextView f25290e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f25291f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CHFinanceUserItem(Context context) {
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
            return false;
        }
        return invokeV.booleanValue;
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_finance_user_item"), this);
            this.f25287b = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_fu_item_bg"));
            this.f25286a = (RelativeLayout) findViewById(ResUtils.id(getContext(), "ch_fu_item_panel"));
            this.f25288c = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fu_item_income"));
            this.f25289d = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fu_item_total_value"));
            this.f25290e = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fu_item_asset_value"));
            this.f25291f = (ImageView) findViewById(ResUtils.id(getContext(), "ch_fu_item_eye"));
            setOnClickListener(null);
            this.f25286a.setOnClickListener(this);
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onEyeMaskChanged();
            this.f25288c.resetMaskText();
            this.f25289d.resetMaskText();
            this.f25290e.resetMaskText();
            if (this.f25291f != null) {
                this.f25291f.setImageResource(ResUtils.drawable(getContext(), a.a(getContext()) ? "wallet_home_ch_eye_close" : "wallet_home_ch_eye_open"));
            }
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || getData() == null) {
            return;
        }
        setNetImageViewUrl(this.f25287b, getData().logo);
        this.f25288c.setMaskText(getData().value1);
        this.f25289d.setMaskText(getData().value2);
        this.f25290e.setMaskText(getData().value3);
        this.f25291f.setImageResource(ResUtils.drawable(getContext(), a.a(getContext()) ? "wallet_home_ch_eye_close" : "wallet_home_ch_eye_open"));
        this.f25291f.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.home.ui.widget.credithome.CHFinanceUserItem.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CHFinanceUserItem f25292a;

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
                this.f25292a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || CheckUtils.isFastDoubleClick()) {
                    return;
                }
                this.f25292a.getWalletInterface().onEyeMaskBtnClick();
            }
        });
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
    public CHFinanceUserItem(Context context, AttributeSet attributeSet) {
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
