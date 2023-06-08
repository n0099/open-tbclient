package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public LinearLayout g;
    public LinearLayout h;
    public TextView i;
    public b j;
    public AlaEnterEffectData k;
    public Context l;

    /* loaded from: classes8.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yg6 a;

        public a(yg6 yg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yg6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.j != null) {
                this.a.j.a();
            }
        }
    }

    public yg6(Context context, AlaEnterEffectData alaEnterEffectData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, alaEnterEffectData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (alaEnterEffectData != null && context != null) {
            this.l = context;
            this.k = alaEnterEffectData;
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00f1, (ViewGroup) null);
            this.a = relativeLayout;
            this.b = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f09097e);
            this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0914a8);
            this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091565);
            this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090791);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092283);
            this.g = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092284);
            this.h = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090818);
            this.i = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090817);
            c(alaEnterEffectData);
        }
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.j = bVar;
        }
    }

    public RelativeLayout b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void c(AlaEnterEffectData alaEnterEffectData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, alaEnterEffectData) != null) || alaEnterEffectData == null) {
            return;
        }
        this.k = alaEnterEffectData;
        this.e.setEnabled(true);
        int i = this.k.categoryType;
        if (3 != i) {
            if (2 == i) {
                this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f0801ef);
                this.e.setTextColor(this.l.getResources().getColor(R.color.CAM_X0201));
                this.g.setVisibility(0);
                this.f.setText(AlaStringHelper.formatLowercasekDou((float) alaEnterEffectData.price));
                Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize = this.l.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070215);
                normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                this.f.setCompoundDrawablePadding(this.l.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07035d));
                this.f.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                this.h.setVisibility(0);
                this.i.setText(AlaStringHelper.formatLowercasekDou((float) TbadkCoreApplication.getInst().currentAccountTdouNum));
                Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize2 = this.l.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
                normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.i.setCompoundDrawablePadding(this.l.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224));
                this.i.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
            } else {
                this.d.setVisibility(0);
                this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f46);
                this.e.setTextColor(this.l.getResources().getColorStateList(R.color.obfuscated_res_0x7f0607c7));
            }
        }
        AlaEnterEffectData alaEnterEffectData2 = this.k;
        if (alaEnterEffectData2.isOwn) {
            if (alaEnterEffectData2.isUsing()) {
                this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f43);
                this.e.setTextColor(this.l.getResources().getColorStateList(R.color.obfuscated_res_0x7f0607c6));
                this.e.setText(R.string.obfuscated_res_0x7f0f0279);
                if (2 == this.k.categoryType) {
                    this.h.setVisibility(8);
                }
            } else {
                this.e.setText(R.string.obfuscated_res_0x7f0f024a);
            }
        } else {
            int i2 = alaEnterEffectData2.categoryType;
            if (3 == i2) {
                this.e.setText(R.string.obfuscated_res_0x7f0f0264);
                this.c.setText(this.l.getString(R.string.obfuscated_res_0x7f0f023c, alaEnterEffectData.nobilityName));
            } else if (2 == i2) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.k.price) {
                    this.e.setText(R.string.obfuscated_res_0x7f0f0241);
                } else {
                    this.e.setText(R.string.obfuscated_res_0x7f0f023a);
                }
            } else {
                this.e.setBackgroundDrawable(null);
                this.e.setTextColor(this.l.getResources().getColor(R.color.white_alpha60));
                this.e.setText(R.string.obfuscated_res_0x7f0f023e);
                this.e.setEnabled(false);
            }
        }
        this.e.setOnClickListener(new a(this));
        if (!StringUtils.isNull(alaEnterEffectData.name)) {
            this.b.setText(alaEnterEffectData.name);
        }
        long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
        if (currentTimeMillis >= 0) {
            this.c.setText(this.l.getResources().getString(R.string.obfuscated_res_0x7f0f024d, StringHelper.formatDayOrHourTime(currentTimeMillis)));
        }
        if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
            this.d.setText(alaEnterEffectData.effect_range_name);
        }
    }
}
