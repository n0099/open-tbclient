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
public class th6 {
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
        public final /* synthetic */ th6 a;

        public a(th6 th6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = th6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.j != null) {
                this.a.j.a();
            }
        }
    }

    public th6(Context context, AlaEnterEffectData alaEnterEffectData) {
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
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00f7, (ViewGroup) null);
            this.a = relativeLayout;
            this.b = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090996);
            this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091504);
            this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0915c1);
            this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09079d);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0923ad);
            this.g = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0923ae);
            this.h = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090827);
            this.i = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090826);
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
                this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f0801f1);
                this.e.setTextColor(this.l.getResources().getColor(R.color.CAM_X0201));
                this.g.setVisibility(0);
                this.f.setText(AlaStringHelper.formatLowercasekDou((float) alaEnterEffectData.price));
                Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize = this.l.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070215);
                normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                this.f.setCompoundDrawablePadding(this.l.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070367));
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
                this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f9e);
                this.e.setTextColor(this.l.getResources().getColorStateList(R.color.obfuscated_res_0x7f0607d0));
            }
        }
        AlaEnterEffectData alaEnterEffectData2 = this.k;
        if (alaEnterEffectData2.isOwn) {
            if (alaEnterEffectData2.isUsing()) {
                this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f9b);
                this.e.setTextColor(this.l.getResources().getColorStateList(R.color.obfuscated_res_0x7f0607cf));
                this.e.setText(R.string.obfuscated_res_0x7f0f027c);
                if (2 == this.k.categoryType) {
                    this.h.setVisibility(8);
                }
            } else {
                this.e.setText(R.string.obfuscated_res_0x7f0f024d);
            }
        } else {
            int i2 = alaEnterEffectData2.categoryType;
            if (3 == i2) {
                this.e.setText(R.string.obfuscated_res_0x7f0f0267);
                this.c.setText(this.l.getString(R.string.obfuscated_res_0x7f0f023f, alaEnterEffectData.nobilityName));
            } else if (2 == i2) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.k.price) {
                    this.e.setText(R.string.obfuscated_res_0x7f0f0244);
                } else {
                    this.e.setText(R.string.obfuscated_res_0x7f0f023d);
                }
            } else {
                this.e.setBackgroundDrawable(null);
                this.e.setTextColor(this.l.getResources().getColor(R.color.white_alpha60));
                this.e.setText(R.string.obfuscated_res_0x7f0f0241);
                this.e.setEnabled(false);
            }
        }
        this.e.setOnClickListener(new a(this));
        if (!StringUtils.isNull(alaEnterEffectData.name)) {
            this.b.setText(alaEnterEffectData.name);
        }
        long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
        if (currentTimeMillis >= 0) {
            this.c.setText(this.l.getResources().getString(R.string.obfuscated_res_0x7f0f0250, StringHelper.formatDayOrHourTime(currentTimeMillis)));
        }
        if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
            this.d.setText(alaEnterEffectData.effect_range_name);
        }
    }
}
