package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class u69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText a;
    public ImageView b;
    public TextView c;
    public ViewGroup d;
    public BaseActivity<?> e;
    public Window f;
    public ImageView g;
    public EditorTools h;
    public FrameLayout i;
    public ProgressBar j;

    public u69(BaseActivity<?> baseActivity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, onClickListener, onClickListener2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = baseActivity;
        Window window = baseActivity.getWindow();
        this.f = window;
        this.d = (ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f092435);
        this.a = (EditText) this.f.findViewById(R.id.obfuscated_res_0x7f092433);
        ImageView imageView = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f092436);
        this.b = imageView;
        imageView.setOnClickListener(onClickListener);
        ImageView imageView2 = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f09242e);
        this.g = imageView2;
        imageView2.setOnClickListener(onClickListener2);
        this.c = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f092437);
        this.i = (FrameLayout) this.f.findViewById(R.id.obfuscated_res_0x7f092432);
        this.j = (ProgressBar) this.f.findViewById(R.id.obfuscated_res_0x7f092434);
    }

    public void a(dd5 dd5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, dd5Var, str) == null) {
            this.h = new EditorTools(this.e.getPageContext().getPageActivity());
            d();
            c(dd5Var);
            b(dd5Var, str);
            this.h.f();
            this.h.D(new cd5(35, 5, Boolean.FALSE));
            this.h.j();
            o(this.h);
        }
    }

    public final void b(dd5 dd5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dd5Var, str) == null) {
            this.h.d(new y69(this.e.getPageContext(), 2, str));
            this.h.setActionListener(26, dd5Var);
            this.h.setActionListener(3, dd5Var);
        }
    }

    public final void c(dd5 dd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dd5Var) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.h.h(arrayList);
            od5 p = this.h.p(5);
            if (p != null) {
                p.l = 1;
                p.f(false);
            }
            this.h.setActionListener(24, dd5Var);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.h.setBarMaxLauCount(4);
            this.h.setBarLauncherType(1);
            this.h.F(true);
            this.h.setBackgroundColorId(R.color.CAM_X0201);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e.ShowSoftKeyPadDelay(this.a);
            EditText editText = this.a;
            editText.setSelection(editText.length());
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a.getText().toString();
        }
        return (String) invokeV.objValue;
    }

    public EditText h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (EditText) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.j.setVisibility(8);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.h.t();
            this.h.D(new cd5(5, -1, null));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            EditText editText = this.a;
            editText.setSelection(editText.length());
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.j.setVisibility(0);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.a.getSelectionStart() <= 0) {
            return;
        }
        String substring = this.a.getText().toString().substring(0, this.a.getSelectionStart());
        Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
        int i = 1;
        if (matcher.find()) {
            i = substring.length() - matcher.replaceFirst("").length();
        }
        this.a.getText().delete(this.a.getSelectionStart() - i, this.a.getSelectionStart());
    }

    public void l(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            BDLayoutMode layoutMode = this.e.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.e.getLayoutMode().onModeChanged(this.d);
            this.h.z(i);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.a.setTextColor(q79.a(str));
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.a.setText(TbFaceManager.i().t(this.e.getPageContext().getPageActivity(), str, null));
        }
    }

    public void o(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, editorTools) == null) {
            this.i.addView(editorTools, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.b.setEnabled(z);
        }
    }

    public void s(TailData tailData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, tailData) == null) && tailData != null) {
            n(tailData.getContent());
            m(tailData.getFontColor());
        }
    }

    public void q(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) {
            TextView textView = this.c;
            textView.setText(i + "/" + i2);
            if (i == i2) {
                i3 = R.color.CAM_X0301;
            } else {
                i3 = R.color.CAM_X0109;
            }
            SkinManager.setViewTextColor(this.c, i3, 1);
        }
    }
}
