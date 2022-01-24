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
/* loaded from: classes13.dex */
public class UMHBigCreditCardContentView extends BaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MaskTextView a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f51303b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f51304c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f51305d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f51306e;

    /* renamed from: f  reason: collision with root package name */
    public HomeCfgResponse.DataItem f51307f;

    /* renamed from: g  reason: collision with root package name */
    public b f51308g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51309h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UMHBigCreditCardContentView(Context context) {
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
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_content_view_layout"), this);
            this.a = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_tip"));
            this.f51303b = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_tip_detail"));
            this.f51304c = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_money"));
            this.f51305d = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_text"));
            this.f51306e = (TextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_button"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onEyeMaskChanged();
            this.a.resetMaskText();
            this.f51305d.resetMaskText();
            this.f51304c.resetMaskText();
            this.f51303b.resetMaskText();
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.setMaskText(this.f51307f.label);
            if (TextUtils.isEmpty(this.f51307f.value1)) {
                this.f51304c.setVisibility(8);
                this.f51306e.setVisibility(8);
                findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty1")).setVisibility(8);
                findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty2")).setVisibility(0);
                findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty3")).setVisibility(0);
                this.a.setTextSize(1, 15.0f);
                int color = ResUtils.getColor(getContext(), "wallet_home_umh_text_5d667a");
                this.a.setTextColor(color);
                this.f51305d.setTextColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_b2b7c2"));
                if (!TextUtils.isEmpty(this.f51307f.detail)) {
                    this.f51303b.setVisibility(0);
                    this.f51303b.setMaskText(this.f51307f.detail);
                    this.f51303b.setTextSize(1, 19.0f);
                    this.f51303b.setTextColor(color);
                } else {
                    this.f51303b.setVisibility(8);
                }
            } else {
                this.a.setTextSize(1, 12.0f);
                this.f51303b.setVisibility(8);
                this.f51304c.setVisibility(0);
                findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty1")).setVisibility(0);
                findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty2")).setVisibility(8);
                findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_empty3")).setVisibility(8);
                this.f51304c.setMaskText(this.f51307f.value1);
                HomeCfgResponse.DataButton[] dataButtonArr = this.f51307f.buttons;
                if (dataButtonArr != null && dataButtonArr.length > 0 && dataButtonArr[0] != null && !TextUtils.isEmpty(dataButtonArr[0].name)) {
                    this.f51306e.setVisibility(0);
                    this.f51306e.setText(this.f51307f.buttons[0].name);
                    this.f51306e.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.home.ui.widget.umoneyhome.UMHBigCreditCardContentView.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ UMHBigCreditCardContentView a;

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
                            this.a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.a.f51308g == null) {
                                return;
                            }
                            this.a.f51308g.jump(this.a.f51307f.buttons[0].stat != null ? this.a.f51307f.buttons[0].stat.getName() : this.a.f51307f.buttons[0].name, this.a.f51307f.buttons[0].type, this.a.f51307f.buttons[0].link_addr, "1".equals(this.a.f51307f.buttons[0].prevlogin));
                        }
                    });
                } else {
                    this.f51306e.setVisibility(8);
                }
                if (this.f51309h) {
                    this.f51304c.setTextColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_397be6"));
                    this.f51306e.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_blue_button_bg"));
                } else {
                    this.f51304c.setTextColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_d862b7"));
                    this.f51306e.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_yellow_button_bg"));
                }
            }
            if (!TextUtils.isEmpty(this.f51307f.value2)) {
                this.f51305d.setVisibility(0);
                this.f51305d.setMaskText(this.f51307f.value2);
                return;
            }
            this.f51305d.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, dataItem, bVar) == null) {
            super.setData(dataItem, bVar);
            this.f51307f = dataItem;
            this.f51308g = bVar;
            if (a()) {
                initView();
                refresh();
            }
        }
    }

    public void setIsManYiDai(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f51309h = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UMHBigCreditCardContentView(Context context, AttributeSet attributeSet) {
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

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.f51307f != null : invokeV.booleanValue;
    }
}
