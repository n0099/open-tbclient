package com.baidu.tieba;

import android.content.ClipboardManager;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class q36 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<o36> a;
    public TbPageContext<?> b;
    public int c;

    /* loaded from: classes5.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o36 a;
        public final /* synthetic */ q36 b;

        public a(q36 q36Var, o36 o36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q36Var, o36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q36Var;
            this.a = o36Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                String h = this.a.h();
                if (StringUtils.isNull(h)) {
                    return false;
                }
                ClipboardManager clipboardManager = (ClipboardManager) this.b.b.getPageActivity().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
                clipboardManager.setText(h);
                if (clipboardManager.getText() != null) {
                    ej.M(this.b.b.getPageActivity(), R.string.obfuscated_res_0x7f0f0457);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o36 a;
        public final /* synthetic */ q36 b;

        public b(q36 q36Var, o36 o36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q36Var, o36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q36Var;
            this.a = o36Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UrlManager.getInstance().dealOneLink(this.b.b, new String[]{this.a.c()});
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TbImageView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public View h;
        public TextView i;
        public TextView j;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public q36(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        this.c = i;
    }

    public final SpannableString b(int i, long j, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2, AbsoluteSizeSpan absoluteSizeSpan, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan, Integer.valueOf(i2)})) == null) {
            String string = this.b.getString(i);
            String formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(i2, j);
            String str = string + "    [icon]" + formatOverBaiwanNum;
            SpannableString spannableString = new SpannableString(str);
            UtilHelper.setSpan(spannableString, str, str, foregroundColorSpan);
            Drawable moneyIcon = CurrencySwitchUtil.getMoneyIcon(i2);
            int f = ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701e8);
            moneyIcon.setBounds(0, 0, f, f);
            aj5 aj5Var = new aj5(moneyIcon);
            aj5Var.b(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070230));
            aj5Var.c(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070230));
            UtilHelper.setSpan(spannableString, str, "[icon]", aj5Var);
            UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, foregroundColorSpan2);
            UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, absoluteSizeSpan);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final SpannableString c(int i, long j, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), foregroundColorSpan, foregroundColorSpan2})) == null) {
            String string = this.b.getString(i);
            String long2String = StringHelper.long2String(j, "yyyy-MM-dd HH:mm");
            String str = string + "    " + long2String;
            SpannableString spannableString = new SpannableString(str);
            UtilHelper.setSpan(spannableString, str, str, foregroundColorSpan);
            UtilHelper.setSpan(spannableString, str, long2String, foregroundColorSpan2);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final SpannableString d(int i, String str, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, foregroundColorSpan, foregroundColorSpan2})) == null) {
            String str2 = this.b.getString(i) + "    " + str;
            SpannableString spannableString = new SpannableString(str2);
            UtilHelper.setSpan(spannableString, str2, str2, foregroundColorSpan);
            UtilHelper.setSpan(spannableString, str2, str, foregroundColorSpan2);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final void e(c cVar, o36 o36Var) {
        SpannableString spannableString;
        SpannableString spannableString2;
        SpannableString spannableString3;
        SpannableString spannableString4;
        String l;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, cVar, o36Var) == null) || cVar == null || o36Var == null) {
            return;
        }
        cVar.g.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0d24) + "    ");
        cVar.a.setText(o36Var.h());
        cVar.a.setOnLongClickListener(new a(this, o36Var));
        if (o36Var.k() == 1) {
            cVar.b.K(String.valueOf((int) R.drawable.obfuscated_res_0x7f0808bf), 24, false);
            SkinManager.setViewTextColor(cVar.b, R.color.CAM_X0305, 1);
        } else {
            cVar.b.K(String.valueOf((int) R.drawable.obfuscated_res_0x7f0808be), 24, false);
            SkinManager.setViewTextColor(cVar.b, R.color.CAM_X0109, 1);
        }
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105));
        new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305));
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(24, true);
        int i3 = this.c;
        if (i3 == 1) {
            SpannableString d = d(R.string.obfuscated_res_0x7f0f035e, o36Var.l(), foregroundColorSpan, foregroundColorSpan2);
            spannableString3 = b(R.string.obfuscated_res_0x7f0f0445, o36Var.m(), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan, o36Var.e());
            spannableString = c(R.string.obfuscated_res_0x7f0f0360, o36Var.d(), foregroundColorSpan, foregroundColorSpan2);
            spannableString4 = d;
            spannableString2 = null;
        } else if (i3 == 2) {
            SpannableString d2 = d(R.string.obfuscated_res_0x7f0f07ca, o36Var.l(), foregroundColorSpan, foregroundColorSpan2);
            spannableString3 = b(CurrencySwitchUtil.isYyIsConvert(o36Var.e()) ? R.string.obfuscated_res_0x7f0f07cb : R.string.obfuscated_res_0x7f0f07c8, o36Var.m(), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan, o36Var.e());
            spannableString = c(R.string.obfuscated_res_0x7f0f0360, o36Var.d(), foregroundColorSpan, foregroundColorSpan2);
            String str = "" + o36Var.j();
            String str2 = this.b.getString(R.string.obfuscated_res_0x7f0f0281) + "    " + str;
            SpannableString spannableString5 = new SpannableString(str2);
            UtilHelper.setSpan(spannableString5, str2, str2, foregroundColorSpan);
            UtilHelper.setSpan(spannableString5, str2, str, foregroundColorSpan2);
            spannableString2 = spannableString5;
            spannableString4 = d2;
        } else if (i3 == 3) {
            String string = this.b.getString(R.string.obfuscated_res_0x7f0f0fad);
            if (CurrencySwitchUtil.isYyIsConvert(o36Var.e())) {
                l = String.format(this.b.getString(R.string.obfuscated_res_0x7f0f1628), g(Double.valueOf(o36Var.i())));
            } else {
                l = o36Var.l();
            }
            String str3 = string + "    " + l;
            spannableString4 = new SpannableString(str3);
            UtilHelper.setSpan(spannableString4, str3, str3, foregroundColorSpan);
            UtilHelper.setSpan(spannableString4, str3, l, foregroundColorSpan2);
            String str4 = ("" + o36Var.g()) + this.b.getString(R.string.obfuscated_res_0x7f0f0fb2);
            String str5 = this.b.getString(R.string.obfuscated_res_0x7f0f0fac) + "    " + str4;
            SpannableString spannableString6 = new SpannableString(str5);
            UtilHelper.setSpan(spannableString6, str5, str5, foregroundColorSpan);
            UtilHelper.setSpan(spannableString6, str5, str4, foregroundColorSpan2);
            UtilHelper.setSpan(spannableString6, str5, str4, absoluteSizeSpan);
            spannableString3 = spannableString6;
            SpannableString c2 = c(R.string.obfuscated_res_0x7f0f0fb1, o36Var.f(), foregroundColorSpan, foregroundColorSpan2);
            String str6 = "" + o36Var.j();
            String str7 = this.b.getString(R.string.obfuscated_res_0x7f0f0fab) + "    " + str6;
            spannableString2 = new SpannableString(str7);
            UtilHelper.setSpan(spannableString2, str7, str7, foregroundColorSpan);
            UtilHelper.setSpan(spannableString2, str7, str6, foregroundColorSpan2);
            spannableString = c2;
        } else {
            spannableString = null;
            spannableString2 = null;
            spannableString3 = null;
            spannableString4 = null;
        }
        cVar.c.setText(spannableString4);
        cVar.d.setText(spannableString3);
        cVar.e.setText(spannableString);
        if (!StringUtils.isNull(o36Var.j()) && ((i2 = this.c) == 3 || i2 == 2)) {
            cVar.f.setVisibility(0);
            cVar.f.setText(spannableString2);
        } else {
            cVar.f.setVisibility(8);
        }
        if (!StringUtils.isNull(o36Var.b())) {
            cVar.i.setText(o36Var.b());
            if (!StringUtils.isNull(o36Var.a())) {
                cVar.j.setText(o36Var.a());
                i = 0;
                cVar.j.setVisibility(0);
            } else {
                i = 0;
                cVar.j.setVisibility(8);
            }
            cVar.j.setOnClickListener(new b(this, o36Var));
            cVar.h.setVisibility(i);
            return;
        }
        cVar.h.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: f */
    public o36 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ArrayList<o36> arrayList = this.a;
            if (arrayList == null || arrayList.size() <= 0 || i < 0 || i >= getCount()) {
                return null;
            }
            return this.a.get(i);
        }
        return (o36) invokeI.objValue;
    }

    public final String g(Double d) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, d)) == null) {
            if (d.doubleValue() == d.intValue()) {
                return d.intValue() + "";
            }
            return d + "";
        }
        return (String) invokeL.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList<o36> arrayList = this.a;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            o36 item = getItem(i);
            if (view2 != null) {
                cVar = (c) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d077f, viewGroup, false);
                cVar = new c();
                cVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091750);
                cVar.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091754);
                cVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091756);
                cVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091753);
                cVar.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091751);
                cVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09174d);
                cVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091755);
                cVar.h = view2.findViewById(R.id.obfuscated_res_0x7f09174e);
                cVar.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090076);
                cVar.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090073);
                view2.setTag(cVar);
            }
            e(cVar, item);
            this.b.getLayoutMode().k(view2);
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void h(ArrayList<o36> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) {
            this.a = arrayList;
        }
    }
}
