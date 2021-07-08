package com.baidu.wallet.personal.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.paysdk.datamodel.CardListResponse;
/* loaded from: classes5.dex */
public class MyBankCardLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int WALLET_BANK_CARD_TYPE = 0;
    public static final int WALLET_EEM_CARD_TYPE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f27184a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyBankCardLayout(Context context) {
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
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            setOrientation(1);
        }
    }

    private View getTransparentStripView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            View view = new View(this.f27184a);
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(this.f27184a, 15.0f)));
            view.setBackgroundColor(getResources().getColor(17170445));
            return view;
        }
        return (View) invokeV.objValue;
    }

    public void setData(boolean z, CardListResponse.Card[] cardArr, int i2, boolean z2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), cardArr, Integer.valueOf(i2), Boolean.valueOf(z2), onClickListener}) == null) {
            this.f27184a = getContext();
            int length = (!z || cardArr == null) ? 0 : cardArr.length;
            removeAllViews();
            LayoutInflater from = LayoutInflater.from(this.f27184a);
            ViewGroup viewGroup = null;
            if (length == 0) {
                View inflate = from.inflate(ResUtils.layout(this.f27184a, "wallet_personal_empty_view_logo"), (ViewGroup) null);
                ImageView imageView = (ImageView) inflate.findViewById(ResUtils.id(this.f27184a, "wallet_personal_logo"));
                TextView textView = (TextView) inflate.findViewById(ResUtils.id(this.f27184a, "wallet_personal_empty_view_tip_action"));
                TextView textView2 = (TextView) inflate.findViewById(ResUtils.id(this.f27184a, "wallet_personal_empty_view_tip_info"));
                if (textView == null || imageView == null) {
                    return;
                }
                if (i2 == 0) {
                    imageView.setImageResource(ResUtils.drawable(this.f27184a, "wallet_personal_my_bank_empty_pic"));
                } else if (i2 == 1) {
                    imageView.setImageResource(ResUtils.drawable(this.f27184a, "wallet_personal_my_ee_bank_empty_pic"));
                }
                if (!z) {
                    textView.setText(ResUtils.getString(this.f27184a, "wallet_personal_bank_list_login_tip"));
                } else if (i2 == 0) {
                    imageView.setImageResource(ResUtils.drawable(this.f27184a, "wallet_personal_my_bank_empty_pic"));
                    textView.setText(ResUtils.getString(this.f27184a, "wallet_base_no_bank_card_tip"));
                } else if (i2 == 1) {
                    imageView.setImageResource(ResUtils.drawable(this.f27184a, "wallet_personal_my_ee_bank_empty_pic"));
                    textView.setText(ResUtils.getString(this.f27184a, "wallet_no_eem_card_tip"));
                    textView2.setVisibility(8);
                }
                textView.setLineSpacing(DisplayUtils.dip2px(getContext(), 5.0f), 1.0f);
                addView(inflate);
                return;
            }
            int i3 = 0;
            while (i3 < length) {
                View inflate2 = from.inflate(ResUtils.layout(this.f27184a, "wallet_personal_bank_card_list_item"), viewGroup);
                ((NetImageView) inflate2.findViewById(ResUtils.id(this.f27184a, "wallet_personal_my_bank_card_icon"))).setImageUrl(cardArr[i3].bank_url);
                NetImageView netImageView = (NetImageView) inflate2.findViewById(ResUtils.id(this.f27184a, "bank_bg"));
                ((TextView) inflate2.findViewById(ResUtils.id(this.f27184a, "wallet_personal_my_bank_card_name"))).setText(cardArr[i3].bank_name);
                ((TextView) inflate2.findViewById(ResUtils.id(this.f27184a, "wallet_personal_my_bank_card_type"))).setText(cardArr[i3].type_name);
                String str = cardArr[i3].account_index;
                ((TextView) inflate2.findViewById(ResUtils.id(this.f27184a, "wallet_personal_my_bank_card_no"))).setText(str.substring(str.length() - 4));
                inflate2.setTag(cardArr[i3].card_detail_url);
                inflate2.setOnClickListener(onClickListener);
                LinearLayout linearLayout = (LinearLayout) inflate2.findViewById(ResUtils.id(this.f27184a, "eem_card_balance_container"));
                TextView textView3 = (TextView) inflate2.findViewById(ResUtils.id(this.f27184a, "tv_available_balance_prefix"));
                TextView textView4 = (TextView) inflate2.findViewById(ResUtils.id(this.f27184a, "tv_available_balance_symbol"));
                TextView textView5 = (TextView) inflate2.findViewById(ResUtils.id(this.f27184a, "tv_wallet_eem_card_available_balance"));
                TextView textView6 = (TextView) inflate2.findViewById(ResUtils.id(this.f27184a, "tv_eem_card_usage_desc"));
                if (i2 == 0) {
                    netImageView.setImageUrl(cardArr[i3].background_url);
                    linearLayout.setVisibility(8);
                    textView6.setVisibility(8);
                } else if (i2 == 1) {
                    linearLayout.setVisibility(0);
                    if (z2) {
                        textView3.setText(ResUtils.string(this.f27184a, "wallet_available_balance_prefix"));
                        textView4.setVisibility(8);
                        textView5.setVisibility(8);
                    } else if (!TextUtils.isEmpty(cardArr[i3].avail_amount)) {
                        textView4.setVisibility(0);
                        textView5.setVisibility(0);
                        textView5.setText(StringUtils.fen2Yuan(cardArr[i3].avail_amount));
                    } else {
                        textView3.setText(ResUtils.string(this.f27184a, "wallet_available_balance_prefix"));
                        textView4.setVisibility(8);
                        textView5.setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(cardArr[i3].usage_desc)) {
                        textView6.setText(cardArr[i3].usage_desc);
                        textView6.setVisibility(0);
                    } else {
                        textView6.setVisibility(8);
                    }
                }
                addView(inflate2);
                addView(getTransparentStripView());
                i3++;
                viewGroup = null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyBankCardLayout(Context context, AttributeSet attributeSet) {
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
        a();
    }
}
