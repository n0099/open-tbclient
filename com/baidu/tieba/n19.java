package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class n19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public TableLayout b;
    public View c;
    public TextView d;
    public View e;

    public n19(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && this.d != null) {
            if (!StringUtils.isNull(str)) {
                this.d.setText(str);
            } else {
                this.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a36));
            }
        }
    }

    public void i(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            View view2 = this.e;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public View a(j19 j19Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, j19Var, i)) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0896, (ViewGroup) null);
            TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0924d2);
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0910b9);
            if (j19Var != null) {
                int c = j19Var.c();
                imageView.setVisibility(0);
                imageView.setTag(Integer.valueOf(c));
                g(imageView, c, TbadkCoreApplication.getInst().getSkinType());
                textView.setText(e(j19Var.b(), 8));
                linearLayout.setTag(j19Var);
            } else {
                textView.setText(R.string.obfuscated_res_0x7f0f0a0b);
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
                imageView.setVisibility(8);
            }
            b(linearLayout, i, this.b, 2);
            return linearLayout;
        }
        return (View) invokeLI.objValue;
    }

    public final void b(View view2, int i, TableLayout tableLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, Integer.valueOf(i), tableLayout, Integer.valueOf(i2)}) == null) {
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703c8), -2);
            if (i % i2 == 0) {
                TableRow tableRow = new TableRow(this.a.getPageActivity());
                tableRow.addView(view2, layoutParams);
                tableLayout.addView(tableRow);
            } else if (tableLayout.getChildCount() != 0) {
                ((TableRow) tableLayout.getChildAt(tableLayout.getChildCount() - 1)).addView(view2, layoutParams);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.removeAllViews();
            this.c.setVisibility(8);
            this.b.setVisibility(8);
            this.d.setVisibility(8);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            f(TbadkCoreApplication.getInst().getSkinType());
            this.c.setVisibility(0);
            this.b.setVisibility(0);
            this.d.setVisibility(0);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0895, (ViewGroup) null);
            this.c = inflate;
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f0925ac);
            this.e = findViewById;
            findViewById.setVisibility(0);
            this.b = (TableLayout) this.c.findViewById(R.id.obfuscated_res_0x7f092157);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0922cb);
            this.d = textView;
            textView.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a36));
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public final String e(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            if (str.length() <= i) {
                return str;
            }
            String substring = str.substring(0, i - 1);
            return substring + this.a.getString(R.string.obfuscated_res_0x7f0f0639);
        }
        return (String) invokeLI.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public void f(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.getLayoutMode().onModeChanged(this.c);
            int childCount = this.b.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                TableRow tableRow = (TableRow) this.b.getChildAt(i3);
                int childCount2 = tableRow.getChildCount();
                for (int i4 = 0; i4 < childCount2; i4++) {
                    LinearLayout linearLayout = (LinearLayout) tableRow.getChildAt(i4);
                    if (linearLayout.getChildCount() != 0) {
                        TextView textView = (TextView) linearLayout.getChildAt(0);
                        ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                        if (i3 == childCount - 1 && i4 == childCount2 - 1) {
                            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
                        } else {
                            if (imageView.getTag() != null) {
                                i2 = ((Integer) imageView.getTag()).intValue();
                            } else {
                                i2 = 0;
                            }
                            g(imageView, i2, i);
                            SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1, i);
                        }
                        SkinManager.setBackgroundResource(textView, R.drawable.square_search_item_bg, i);
                    }
                }
            }
        }
    }

    public final void g(ImageView imageView, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048582, this, imageView, i, i2) != null) || imageView == null) {
            return;
        }
        imageView.setImageDrawable(null);
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    imageView.setVisibility(8);
                    return;
                } else {
                    SkinManager.setImageResource(imageView, R.drawable.icon_topic_recommend, i2);
                    return;
                }
            }
            SkinManager.setImageResource(imageView, R.drawable.icon_topic_hot, i2);
            return;
        }
        SkinManager.setImageResource(imageView, R.drawable.icon_topic_new, i2);
    }
}
