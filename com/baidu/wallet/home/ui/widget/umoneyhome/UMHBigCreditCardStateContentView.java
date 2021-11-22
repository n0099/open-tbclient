package com.baidu.wallet.home.ui.widget.umoneyhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes10.dex */
public class UMHBigCreditCardStateContentView extends BaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MaskTextView f59494a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f59495b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59496c;

    /* renamed from: d  reason: collision with root package name */
    public HomeCfgResponse.DataItem f59497d;

    /* renamed from: e  reason: collision with root package name */
    public b f59498e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59499f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UMHBigCreditCardStateContentView(Context context, AttributeSet attributeSet) {
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
            return false;
        }
        return invokeV.booleanValue;
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_state_content_view_layout"), this);
            this.f59494a = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_shengpi_tip"));
            this.f59495b = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_shengpi_text"));
            this.f59496c = (TextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_shengpi_button"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onEyeMaskChanged();
            this.f59495b.resetMaskText();
            this.f59494a.resetMaskText();
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f59494a.setMaskText(this.f59497d.value1);
            if (!TextUtils.isEmpty(this.f59497d.value2)) {
                this.f59495b.setVisibility(0);
                this.f59495b.setMaskText(this.f59497d.value2);
            } else {
                this.f59495b.setVisibility(8);
            }
            HomeCfgResponse.DataButton[] dataButtonArr = this.f59497d.buttons;
            if (dataButtonArr != null && dataButtonArr.length > 0 && dataButtonArr[0] != null && !TextUtils.isEmpty(dataButtonArr[0].name)) {
                this.f59496c.setText(this.f59497d.buttons[0].name);
                this.f59496c.setVisibility(0);
                this.f59496c.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.home.ui.widget.umoneyhome.UMHBigCreditCardStateContentView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ UMHBigCreditCardStateContentView f59500a;

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
                        this.f59500a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f59500a.f59498e == null) {
                            return;
                        }
                        this.f59500a.f59498e.jump(this.f59500a.f59497d.buttons[0].stat != null ? this.f59500a.f59497d.buttons[0].stat.getName() : this.f59500a.f59497d.buttons[0].name, this.f59500a.f59497d.buttons[0].type, this.f59500a.f59497d.buttons[0].link_addr, "1".equals(this.f59500a.f59497d.buttons[0].prevlogin));
                    }
                });
            } else {
                this.f59496c.setVisibility(8);
            }
            if (this.f59499f) {
                this.f59496c.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_blue_button_bg"));
            } else {
                this.f59496c.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_yellow_button_bg"));
            }
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, dataItem, bVar) == null) {
            super.setData(dataItem, bVar);
            this.f59497d = dataItem;
            this.f59498e = bVar;
            if (a()) {
                initView();
                refresh();
            }
        }
    }

    public void setIsManYiDai(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f59499f = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UMHBigCreditCardStateContentView(Context context) {
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

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.f59497d != null : invokeV.booleanValue;
    }
}
