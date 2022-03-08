package com.baidu.wallet.home.ui.widget.umoneyhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes6.dex */
public class UMHBigCreditCardRepayTipView extends BaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MaskTextView a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f49909b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f49910c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f49911d;

    /* renamed from: e  reason: collision with root package name */
    public NetImageView f49912e;

    /* renamed from: f  reason: collision with root package name */
    public Button f49913f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49914g;

    /* renamed from: h  reason: collision with root package name */
    public HomeCfgResponse.DataItem f49915h;

    /* renamed from: i  reason: collision with root package name */
    public b f49916i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f49917j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UMHBigCreditCardRepayTipView(Context context) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            HomeCfgResponse.DataItem dataItem = this.f49915h;
            return (dataItem == null || dataItem.repay == null) ? false : true;
        }
        return invokeV.booleanValue;
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
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_big_credit_card_tip_item_layout"), this);
            this.a = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_text"));
            this.f49909b = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_money"));
            this.f49912e = (NetImageView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_img"));
            this.f49910c = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_tip"));
            this.f49911d = (MaskTextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_tip_sub_tip"));
            this.f49913f = (Button) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_button"));
            this.f49914g = (TextView) findViewById(ResUtils.id(getContext(), "umh_big_credit_card_content_button1"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView, android.view.View.OnClickListener
    public void onClick(View view) {
        HomeCfgResponse.DataButton[] dataButtonArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || CheckUtils.isFastDoubleClick() || this.f49915h == null || getWalletInterface() == null || (dataButtonArr = this.f49915h.repay.buttons) == null || dataButtonArr.length <= 0 || dataButtonArr[0] == null) {
            return;
        }
        b bVar = this.f49916i;
        String name = dataButtonArr[0].stat != null ? dataButtonArr[0].stat.getName() : dataButtonArr[0].name;
        HomeCfgResponse.DataButton[] dataButtonArr2 = this.f49915h.repay.buttons;
        bVar.jump(name, dataButtonArr2[0].type, dataButtonArr2[0].link_addr, "1".equalsIgnoreCase(dataButtonArr2[0].prevlogin));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onEyeMaskChanged();
            this.f49911d.resetMaskText();
            this.f49910c.resetMaskText();
            this.f49909b.resetMaskText();
            this.a.resetMaskText();
        }
    }

    public void refresh() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            HomeCfgResponse.DataRepay dataRepay = this.f49915h.repay;
            if (!TextUtils.isEmpty(dataRepay.name)) {
                this.a.setVisibility(0);
                this.a.setMaskText(dataRepay.name);
            } else {
                this.a.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dataRepay.label)) {
                this.f49909b.setVisibility(0);
                this.f49909b.setMaskText(dataRepay.label);
            } else {
                this.f49909b.setVisibility(8);
            }
            HomeCfgResponse.DataButton[] dataButtonArr = dataRepay.buttons;
            if (dataButtonArr != null && dataButtonArr.length > 0 && dataButtonArr[0] != null && !TextUtils.isEmpty(dataButtonArr[0].name)) {
                this.f49913f.setText(dataRepay.buttons[0].name);
                this.f49914g.setText(dataRepay.buttons[0].name);
                this.f49913f.setOnClickListener(this);
                this.f49914g.setOnClickListener(this);
                z = true;
            } else {
                this.f49913f.setVisibility(8);
                this.f49914g.setVisibility(8);
                z = false;
            }
            if (!TextUtils.isEmpty(dataRepay.value)) {
                this.f49910c.setVisibility(0);
                this.f49910c.setMaskText(dataRepay.value);
                if (z) {
                    this.f49913f.setVisibility(0);
                    this.f49914g.setVisibility(8);
                }
                if (!TextUtils.isEmpty(dataRepay.desc)) {
                    this.f49911d.setVisibility(0);
                    this.f49911d.setMaskText(dataRepay.desc);
                } else {
                    this.f49911d.setVisibility(8);
                }
                if (!TextUtils.isEmpty(dataRepay.type) && TextUtils.equals("2", dataRepay.type)) {
                    setBackgroundColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_fff6f6"));
                    int color = ResUtils.getColor(getContext(), "wallet_home_umh_text_fa5050");
                    a(color, color, ResUtils.getColor(getContext(), "wallet_home_umh_text_aafa5050"), color, color);
                    this.f49913f.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_credit_card_button_light_red"));
                    this.f49912e.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_tip_jin_tan_hao"));
                    return;
                }
                setBackgroundColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_f7f9fc"));
                int color2 = ResUtils.getColor(getContext(), "wallet_home_umh_text_121c32");
                int color3 = ResUtils.getColor(getContext(), "wallet_home_umh_text_868e9e");
                int color4 = ResUtils.getColor(getContext(), "wallet_home_umh_text_397be6");
                int color5 = ResUtils.getColor(getContext(), "wallet_home_umh_text_cba14e");
                if (this.f49917j) {
                    a(color2, color2, color3, color2, color4);
                    this.f49913f.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_credit_card_button_wathet"));
                } else {
                    a(color2, color2, color3, color2, color5);
                    this.f49913f.setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_credit_card_button_light_yellow"));
                }
                this.f49912e.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_home_umh_big_credit_card_tip_ri_li"));
                return;
            }
            this.f49912e.setVisibility(8);
            this.f49910c.setVisibility(8);
            this.f49911d.setVisibility(8);
            this.f49913f.setVisibility(8);
            if (z) {
                this.f49913f.setVisibility(8);
                this.f49914g.setVisibility(0);
            }
            setBackgroundColor(ResUtils.getColor(getContext(), "wallet_home_umh_text_f7f9fc"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, dataItem, bVar) == null) {
            super.setData(dataItem, bVar);
            this.f49915h = getData();
            this.f49916i = bVar;
            if (a()) {
                initView();
                refresh();
            }
        }
    }

    public void setIsManYiDai(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f49917j = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UMHBigCreditCardRepayTipView(Context context, AttributeSet attributeSet) {
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

    private void a(int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            this.a.setTextColor(i2);
            this.f49909b.setTextColor(i3);
            this.f49910c.setTextColor(i4);
            this.f49911d.setTextColor(i5);
            this.f49913f.setTextColor(i6);
        }
    }
}
