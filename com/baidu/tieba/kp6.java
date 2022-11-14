package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class kp6 extends mp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LabelDataList c;
    public Context d;
    public int e;
    public final int f;

    @Override // com.baidu.tieba.mp6
    public long e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
    }

    public kp6(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.d = context;
        this.f = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070258);
    }

    @Override // com.baidu.tieba.mp6
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ListUtils.getCount(this.c);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.mp6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.mp6
    public Object c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return ListUtils.getItem(this.c, i);
        }
        return invokeI.objValue;
    }

    @Override // com.baidu.tieba.mp6
    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.e = i;
            this.c.setSelectedIndex(i);
            notifyDataSetChanged();
        }
    }

    public void n(LabelDataList labelDataList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, labelDataList) == null) {
            this.c = labelDataList;
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.mp6
    public View g(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        TextView m;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
            if (view2 instanceof TextView) {
                m = (TextView) view2;
            } else {
                m = m();
            }
            bp6 bp6Var = (bp6) ListUtils.getItem(this.c, i);
            if (bp6Var != null) {
                m.setText(bp6Var.b);
            }
            if (this.e == i) {
                z = true;
            } else {
                z = false;
            }
            l(m, z);
            return m;
        }
        return (View) invokeILL.objValue;
    }

    public void l(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, textView, z) == null) {
            if (z) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0302);
                SkinManager.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_s);
                return;
            }
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0106);
            SkinManager.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_n);
        }
    }

    public final TextView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TextView textView = new TextView(this.d);
            textView.setTextSize(0, this.d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07032d));
            textView.setGravity(17);
            textView.setHeight(d());
            return textView;
        }
        return (TextView) invokeV.objValue;
    }
}
