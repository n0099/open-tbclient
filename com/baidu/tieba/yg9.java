package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.payment.PaymentConfirmActivity;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class yg9 extends BdBaseView<PaymentConfirmActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PaymentConfirmActivity a;
    public ViewGroup b;
    public NavigationBar c;
    public ViewGroup d;
    public ViewGroup e;
    public TbImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public CheckBox m;
    public ViewGroup n;
    public TbImageView o;
    public TextView p;
    public TextView q;
    public ViewGroup r;
    public EditText s;
    public ViewGroup t;
    public TextView u;
    public TextView v;
    public boolean w;
    public int x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yg9(PaymentConfirmActivity paymentConfirmActivity, boolean z, int i) {
        super(paymentConfirmActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {paymentConfirmActivity, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = false;
        this.a = paymentConfirmActivity;
        this.w = z;
        this.x = i;
        paymentConfirmActivity.setContentView(R.layout.obfuscated_res_0x7f0d079b);
        M(paymentConfirmActivity);
        L(paymentConfirmActivity);
    }

    public final SpannableStringBuilder C(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            String str = "" + j;
            if (CurrencySwitchUtil.isYyIsConvert(i)) {
                str = "" + CurrencyHelper.getFormatOverBaiwanNum(i, j);
            }
            String K = K(str);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(K);
            int indexOf = K.indexOf(str);
            if (indexOf >= 0) {
                spannableStringBuilder.insert(indexOf, (CharSequence) " ");
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305));
                km kmVar = new km(getPageContext().getPageActivity(), CurrencySwitchUtil.getMoneyIconBitmap(i), 1);
                int i2 = indexOf + 1;
                spannableStringBuilder.setSpan(kmVar, indexOf, i2, 33);
                spannableStringBuilder.setSpan(foregroundColorSpan, i2, str.length() + i2, 33);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public ViewGroup D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            EditText editText = this.s;
            if (editText != null) {
                return editText.getText().toString();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public CheckBox F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m;
        }
        return (CheckBox) invokeV.objValue;
    }

    public EditText G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.s;
        }
        return (EditText) invokeV.objValue;
    }

    public TextView H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.v;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.q;
        }
        return (TextView) invokeV.objValue;
    }

    public void N() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (viewGroup = this.r) != null && viewGroup.getParent() != null) {
            ((ViewGroup) this.r.getParent()).removeAllViews();
        }
    }

    public void u() {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (editText = this.s) != null) {
            editText.setText("");
        }
    }

    public ViewGroup I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.r == null) {
                this.r = (ViewGroup) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0461, (ViewGroup) null, false);
                vt5.a(this.a.getPageContext(), this.r);
                this.s = (EditText) this.r.findViewById(R.id.obfuscated_res_0x7f0908b1);
                this.t = (ViewGroup) this.r.findViewById(R.id.obfuscated_res_0x7f091a90);
                this.u = (TextView) this.r.findViewById(R.id.obfuscated_res_0x7f091a8f);
                this.v = (TextView) this.r.findViewById(R.id.obfuscated_res_0x7f091a92);
            }
            return this.r;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final String K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (this.w) {
                return this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fb3, str);
            }
            return this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fb4, str);
        }
        return (String) invokeL.objValue;
    }

    public final void L(PaymentConfirmActivity paymentConfirmActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, paymentConfirmActivity) == null) {
            this.d = (ViewGroup) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091aaa);
            this.e = (ViewGroup) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091aab);
            this.f = (TbImageView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091a9e);
            this.g = (TextView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091a9b);
            this.h = (TextView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091a9d);
            this.i = (TextView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091aa2);
            this.j = (TextView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091a9f);
            this.k = (TextView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091a9c);
            this.l = (TextView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091aa1);
            this.m = (CheckBox) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091aa7);
            this.n = (ViewGroup) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091aa5);
            this.o = (TbImageView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091aa4);
            this.p = (TextView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091aa3);
            this.q = (TextView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091aa8);
        }
    }

    public final void M(PaymentConfirmActivity paymentConfirmActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, paymentConfirmActivity) == null) {
            this.b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f091aa9);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f091aa6);
            this.c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            if (CurrencySwitchUtil.isYyIsConvert(this.x)) {
                if (this.w) {
                    this.c.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fc7));
                } else {
                    this.c.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fc9));
                }
            } else if (this.w) {
                this.c.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0faf));
            } else {
                this.c.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fba));
            }
        }
    }

    public void P(int i) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i) == null) && (viewGroup = this.t) != null) {
            if (i == 5) {
                viewGroup.setVisibility(0);
                this.u.setText("");
                this.v.setText(R.string.obfuscated_res_0x7f0f0fc2);
            } else if (i > 0) {
                viewGroup.setVisibility(0);
                this.u.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fc4, Integer.valueOf(i)));
                this.v.setText(R.string.obfuscated_res_0x7f0f0fc2);
            } else {
                viewGroup.setVisibility(0);
                this.u.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fc3));
                this.v.setText(R.string.sapi_forget_password_title);
            }
        }
    }

    public final SpannableString O(String str, String str2, int i) {
        InterceptResult invokeLLI;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048588, this, str, str2, i)) == null) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2) && (indexOf = str.indexOf(str2)) >= 0) {
                return t(str, indexOf, str2.length() + indexOf, i);
            }
            return new SpannableString(str);
        }
        return (SpannableString) invokeLLI.objValue;
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            vt5.a(this.a.getPageContext(), this.b);
            this.c.onChangeSkinType(this.a.getPageContext(), i);
        }
    }

    public void y(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && (editText = this.s) != null) {
            editText.setEnabled(z);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.q.setEnabled(z);
        }
    }

    public final SpannableString t(String str, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048591, this, str, i, i2, i3)) == null) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
            return spannableString;
        }
        return (SpannableString) invokeLIII.objValue;
    }

    public void x(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048593, this, paymentConfirmInfoData, z) != null) || paymentConfirmInfoData == null) {
            return;
        }
        this.e.setVisibility(0);
        PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
        if (goods_info != null) {
            this.f.startLoad(goods_info.getGoods_pic(), 10, false);
            this.g.setText(goods_info.getGoods_name());
            String numFormatOver10000 = StringHelper.numFormatOver10000(goods_info.getGoods_num());
            this.h.setText(O(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fb1, numFormatOver10000) + goods_info.getGoods_unit(), numFormatOver10000, SkinManager.getColor(R.color.CAM_X0305)));
            int goods_duration = goods_info.getGoods_duration();
            if (goods_duration > 0) {
                String numFormatOver100002 = StringHelper.numFormatOver10000(goods_duration);
                this.i.setText(O(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fb6, numFormatOver100002), numFormatOver100002, SkinManager.getColor(R.color.CAM_X0305)));
            } else {
                this.i.setText(t(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fb7), 3, 5, SkinManager.getColor(R.color.CAM_X0305)));
            }
            this.j.setCompoundDrawablesWithIntrinsicBounds(CurrencySwitchUtil.getMoneyIcon(goods_info.getCurrency()), (Drawable) null, (Drawable) null, (Drawable) null);
            if (CurrencySwitchUtil.isYyIsConvert(goods_info.getCurrency())) {
                this.j.setText(CurrencyHelper.getFormatOverBaiwanNum(goods_info.getCurrency(), goods_info.getTdou_num()));
            } else {
                this.j.setText(StringHelper.numFormatOver10000wan(goods_info.getTdou_num()));
            }
            this.k.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fb0, goods_info.getGoods_name()));
            if (z) {
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1);
                this.l.setText(C(goods_info.getTdou_num(), goods_info.getCurrency()));
            } else {
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0301, 1);
                if (CurrencySwitchUtil.isYyIsConvert(goods_info.getCurrency())) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f0fc8);
                } else {
                    this.l.setText(R.string.obfuscated_res_0x7f0f0fb5);
                }
            }
        }
        PaymentConfirmInfoData.OrderInfo order_info = paymentConfirmInfoData.getOrder_info();
        if (order_info != null && (cpath = order_info.getCpath()) != null) {
            PaymentConfirmInfoData.OrderInfo.Cpath.Member member = cpath.getMember();
            if (member != null) {
                String icon = member.getIcon();
                String desc = member.getDesc();
                if (!StringUtils.isNull(icon) && !StringUtils.isNull(desc)) {
                    this.n.setVisibility(0);
                    this.o.startLoad(icon, 10, false);
                    this.p.setText(desc);
                } else {
                    this.n.setVisibility(8);
                }
            }
            if (cpath.getTip_exist() == 1) {
                this.m.setButtonDrawable(SkinManager.getDrawable(R.drawable.payment_confirm_price_tip_check_button));
                this.m.setVisibility(0);
                this.m.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fb8, Integer.valueOf(cpath.getTip_days())));
            } else {
                this.m.setVisibility(8);
            }
        }
        if (z) {
            if (this.w) {
                this.q.setText(R.string.buy_now);
            } else {
                this.q.setText(R.string.goto_exchange);
            }
        } else if (CurrencySwitchUtil.isYyIsConvert(this.x)) {
            this.q.setText(R.string.get_ybean);
        } else {
            this.q.setText(R.string.get_tdou);
        }
    }
}
