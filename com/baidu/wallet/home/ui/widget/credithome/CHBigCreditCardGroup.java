package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.storage.a;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class CHBigCreditCardGroup extends BaseItemLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int q = 24;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f58396a;

    /* renamed from: b  reason: collision with root package name */
    public final int f58397b;

    /* renamed from: c  reason: collision with root package name */
    public final int f58398c;

    /* renamed from: e  reason: collision with root package name */
    public final float f58399e;

    /* renamed from: f  reason: collision with root package name */
    public final float f58400f;

    /* renamed from: g  reason: collision with root package name */
    public NetImageView f58401g;

    /* renamed from: h  reason: collision with root package name */
    public MaskTextView f58402h;

    /* renamed from: i  reason: collision with root package name */
    public NetImageView f58403i;
    public MaskTextView j;
    public LinearLayout k;
    public Button l;
    public View m;
    public LinearLayout n;
    public NetImageView o;
    public boolean p;
    public List<BaseItemView> r;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(425880897, "Lcom/baidu/wallet/home/ui/widget/credithome/CHBigCreditCardGroup;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(425880897, "Lcom/baidu/wallet/home/ui/widget/credithome/CHBigCreditCardGroup;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CHBigCreditCardGroup(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58396a = 3;
        this.f58397b = 44;
        this.f58398c = 22;
        this.f58399e = 19.0f;
        this.f58400f = 10.0f;
        this.p = true;
        this.r = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.r : (List) invokeV.objValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_credit_card_layout"), this);
            this.o = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_credit_card_bg"));
            this.f58401g = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_credit_card_logo"));
            this.f58402h = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_card_title"));
            this.j = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_card_lines_number"));
            this.k = (LinearLayout) findViewById(ResUtils.id(getContext(), "ch_credit_card_tips"));
            this.l = (Button) findViewById(ResUtils.id(getContext(), "ch_credit_card_button"));
            this.m = findViewById(ResUtils.id(getContext(), "ch_credit_card_next_repayment_divider"));
            this.n = (LinearLayout) findViewById(ResUtils.id(getContext(), "ch_credit_card_repayment_layout"));
            this.f58403i = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_credit_card_eye"));
            this.j.setOnClickListener(this);
            this.l.setOnClickListener(this);
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        InterceptResult invokeV;
        HomeCfgResponse.DataItem[] dataItemArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HomeCfgResponse.ConfigData configData = this.mConfigData;
            return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length == 0 || dataItemArr[0] == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && isDataValid()) {
            if (view == this.f58403i) {
                if (CheckUtils.isFastDoubleClick()) {
                    return;
                }
                getWalletInterface().onEyeMaskBtnClick();
            } else if (view == this.j) {
                if (!CheckUtils.isFastDoubleClick() && isDataValid()) {
                    b walletInterface = getWalletInterface();
                    HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
                    walletInterface.jump(dataItemArr[0].name, dataItemArr[0].type, dataItemArr[0].link_addr, dataItemArr[0].getPrevlogin());
                }
            } else if (view == this.l && !CheckUtils.isFastDoubleClick() && isDataValid()) {
                HomeCfgResponse.DataItem[] dataItemArr2 = this.mConfigData.list;
                if (dataItemArr2[0].buttons == null || dataItemArr2[0].buttons.length == 0 || dataItemArr2[0].buttons[0] == null) {
                    return;
                }
                b walletInterface2 = getWalletInterface();
                HomeCfgResponse.DataItem[] dataItemArr3 = this.mConfigData.list;
                walletInterface2.jump(dataItemArr3[0].buttons[0].name, dataItemArr3[0].buttons[0].type, dataItemArr3[0].buttons[0].link_addr, dataItemArr3[0].getPrevlogin());
            }
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void onEyeMaskChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onEyeMaskChanged();
            this.j.resetMaskText();
            if (this.f58403i != null) {
                this.f58403i.setImageResource(ResUtils.drawable(getContext(), a.a(getContext()) ? "wallet_home_ch_eye_close" : "wallet_home_ch_eye_open"));
            }
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            NetImageView netImageView = this.o;
            netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + this.mConfigData.group_background);
            if (!TextUtils.isEmpty(this.mConfigData.list[0].logo)) {
                this.f58401g.setVisibility(0);
                NetImageView netImageView2 = this.f58401g;
                netImageView2.setImageUrl(getWalletInterface().getAndroidPrefix() + this.mConfigData.list[0].logo);
            } else {
                this.f58401g.setVisibility(8);
            }
            this.f58402h.setMaskText(this.mConfigData.list[0].name);
            this.j.setMaskText(this.mConfigData.list[0].value2);
            boolean z = !TextUtils.isEmpty(this.mConfigData.list[0].value2) && this.mConfigData.list[0].value2.contains(PayTypeItemView.PayTypeItemViewData.MASK_FLAG);
            this.j.setTextSize(1, z ? 44.0f : 22.0f);
            this.j.setPadding(0, DisplayUtils.dip2px(getContext(), z ? 0.0f : 19.0f), 0, DisplayUtils.dip2px(getContext(), z ? 0.0f : 10.0f));
            HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
            if (dataItemArr[0].icons != null && dataItemArr[0].icons.length > 0) {
                int length = dataItemArr[0].icons.length <= 3 ? dataItemArr[0].icons.length : 3;
                int i2 = q / length;
                for (int i3 = 0; i3 < length; i3++) {
                    HomeCfgResponse.DataItem[] dataItemArr2 = this.mConfigData.list;
                    if (dataItemArr2[0].icons[i3] != null && !TextUtils.isEmpty(dataItemArr2[0].icons[i3].name)) {
                        CHBigCreditCardTipsItem cHBigCreditCardTipsItem = new CHBigCreditCardTipsItem(getContext());
                        cHBigCreditCardTipsItem.setMaxLength(i2);
                        cHBigCreditCardTipsItem.setData(this.mConfigData.list[0].icons[i3], getWalletInterface());
                        if (i3 == length - 1) {
                            cHBigCreditCardTipsItem.setShowDivider(false);
                        }
                        cHBigCreditCardTipsItem.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.home.ui.widget.credithome.CHBigCreditCardGroup.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ CHBigCreditCardGroup f58404a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f58404a = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Interceptable interceptable2 = $ic;
                                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || CheckUtils.isFastDoubleClick()) {
                                    return;
                                }
                                this.f58404a.getWalletInterface().jump(this.f58404a.mConfigData.list[0].name, this.f58404a.mConfigData.list[0].type, this.f58404a.mConfigData.list[0].link_addr, this.f58404a.mConfigData.list[0].getPrevlogin());
                            }
                        });
                        this.k.addView(cHBigCreditCardTipsItem);
                        this.r.add(cHBigCreditCardTipsItem);
                    }
                }
            }
            HomeCfgResponse.DataItem[] dataItemArr3 = this.mConfigData.list;
            if (dataItemArr3[0].buttons != null && dataItemArr3[0].buttons.length > 0) {
                if (dataItemArr3[0].buttons[0] != null) {
                    this.l.setText(dataItemArr3[0].buttons[0].name);
                } else {
                    this.l.setVisibility(8);
                }
                HomeCfgResponse.DataItem[] dataItemArr4 = this.mConfigData.list;
                if (dataItemArr4[0].buttons.length > 1 && dataItemArr4[0].buttons[1] != null) {
                    this.m.setVisibility(0);
                    MaskTextView maskTextView = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_card_next_repayment_time"));
                    MaskTextView maskTextView2 = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_card_repayment_button_text"));
                    NetImageView netImageView3 = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_credit_card_next_repayment_icon"));
                    this.n.setVisibility(0);
                    if (!TextUtils.isEmpty(this.mConfigData.list[0].buttons[1].icon)) {
                        netImageView3.setVisibility(0);
                        netImageView3.setImageUrl(getWalletInterface().getAndroidPrefix() + this.mConfigData.list[0].buttons[1].icon);
                    } else {
                        netImageView3.setVisibility(8);
                    }
                    maskTextView.setMaskText(this.mConfigData.list[0].buttons[1].btn_type);
                    if (!TextUtils.isEmpty(this.mConfigData.list[0].buttons[1].name)) {
                        maskTextView2.setVisibility(0);
                        maskTextView2.setMaskText(this.mConfigData.list[0].buttons[1].name);
                    } else {
                        maskTextView2.setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(this.mConfigData.list[0].buttons[1].type) && !TextUtils.isEmpty(this.mConfigData.list[0].buttons[1].link_addr)) {
                        findViewById(ResUtils.id(getContext(), "ch_credit_card_next_repayment_button")).setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.home.ui.widget.credithome.CHBigCreditCardGroup.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ CHBigCreditCardGroup f58405a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f58405a = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                    this.f58405a.getWalletInterface().jump(this.f58405a.mConfigData.list[0].buttons[1].name, this.f58405a.mConfigData.list[0].buttons[1].type, this.f58405a.mConfigData.list[0].buttons[1].link_addr, this.f58405a.mConfigData.list[0].getPrevlogin());
                                }
                            }
                        });
                    }
                } else {
                    this.m.setVisibility(8);
                    this.n.setVisibility(8);
                }
            }
            HomeCfgResponse.DataItem[] dataItemArr5 = this.mConfigData.list;
            if (dataItemArr5[0].value3 != null && TextUtils.equals(dataItemArr5[0].value3, "1")) {
                this.f58403i.setVisibility(8);
                return;
            }
            this.f58403i.setVisibility(0);
            this.f58403i.setImageResource(ResUtils.drawable(getContext(), a.a(getContext()) ? "wallet_home_ch_eye_close" : "wallet_home_ch_eye_open"));
            this.f58403i.setOnClickListener(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CHBigCreditCardGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f58396a = 3;
        this.f58397b = 44;
        this.f58398c = 22;
        this.f58399e = 19.0f;
        this.f58400f = 10.0f;
        this.p = true;
        this.r = new ArrayList();
    }
}
