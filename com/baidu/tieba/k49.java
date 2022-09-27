package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.w19;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class k49 extends n49<h59> implements p49, w19.a, PopupWindow.OnDismissListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public LinearLayout g;
    @Nullable
    public TextView h;
    @Nullable
    public View i;
    @Nullable
    public ImageView j;
    @Nullable
    public w19 k;
    @Nullable
    public x36 l;
    public ArrayList<WritePrefixItemLayout> m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ LinearLayout b;
        public final /* synthetic */ ImageView c;
        public final /* synthetic */ w19 d;
        public final /* synthetic */ k49 e;

        public a(k49 k49Var, TextView textView, LinearLayout linearLayout, ImageView imageView, w19 w19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k49Var, textView, linearLayout, imageView, w19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = k49Var;
            this.a = textView;
            this.b = linearLayout;
            this.c = imageView;
            this.d = w19Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13013").param("fid", this.e.e != null ? this.e.e.getForumId() : "").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.a.setVisibility(0);
                this.b.setSelected(true);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.c, R.drawable.obfuscated_res_0x7f080951, R.color.CAM_X0105, null);
                if (this.e.b != null) {
                    this.e.b.C();
                    this.e.b.p(false);
                }
                ih.l(this.d, view2, 0, ej.d(this.e.a.getPageActivity(), 1.0f));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;
        public final /* synthetic */ w19 c;
        public final /* synthetic */ k49 d;

        public b(k49 k49Var, TextView textView, ImageView imageView, w19 w19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k49Var, textView, imageView, w19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = k49Var;
            this.a = textView;
            this.b = imageView;
            this.c = w19Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13013").param("fid", this.d.e != null ? this.d.e.getForumId() : "").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.a.setSelected(true);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.b, R.drawable.obfuscated_res_0x7f080951, R.color.CAM_X0105, null);
                if (this.d.b != null) {
                    this.d.b.C();
                    this.d.b.p(false);
                }
                ih.l(this.c, view2, 0, ej.d(this.d.a.getPageActivity(), 1.0f));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k49(TbPageContext<?> tbPageContext) {
        super(tbPageContext, h59.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new ArrayList<>();
    }

    public final void J(@NonNull WriteData writeData, @NonNull w19 w19Var, @NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, writeData, w19Var, textView) == null) {
            this.m.clear();
            ArrayList<String> prefixs = writeData.getPrefixData().getPrefixs();
            int size = prefixs.size();
            int color = SkinManager.getColor(R.color.CAM_X0105);
            int i = 0;
            while (i < size) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(this.a.getPageActivity());
                this.m.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                writePrefixItemLayout.setPrefixTextColor(color);
                int i2 = size - 1;
                boolean z = true;
                writePrefixItemLayout.c(i == i2);
                if (i != i2) {
                    z = false;
                }
                writePrefixItemLayout.setDividerStyle(z);
                w19Var.a(writePrefixItemLayout);
                i++;
            }
            w19Var.c(0);
            textView.setText(prefixs.get(0));
        }
    }

    public final void K(@NonNull TextView textView, @NonNull ImageView imageView, @NonNull w19 w19Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, imageView, w19Var) == null) {
            textView.setOnClickListener(new b(this, textView, imageView, w19Var));
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            O();
            N();
            if (this.h == null || this.g == null || this.i == null || this.j == null || this.k == null) {
                return;
            }
            WriteData writeData = this.e;
            if (writeData != null && writeData.getPrefixData() != null) {
                if (this.e.getPrefixData().getPrefixs().size() > 1) {
                    this.g.setVisibility(0);
                    this.i.setVisibility(0);
                    Q();
                    M(this.g, this.h, this.j, this.k);
                    K(this.h, this.j, this.k);
                    J(this.e, this.k, this.h);
                    P(0);
                    return;
                }
                this.g.setVisibility(8);
                this.i.setVisibility(8);
                return;
            }
            this.g.setVisibility(8);
            this.i.setVisibility(8);
        }
    }

    public final void M(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull w19 w19Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, linearLayout, textView, imageView, w19Var) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(imageView, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            linearLayout.setOnClickListener(new a(this, textView, linearLayout, imageView, w19Var));
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a.getPageActivity() != null && this.l == null) {
            x36 x36Var = new x36(this.a, this.g);
            this.l = x36Var;
            x36Var.q0(R.drawable.obfuscated_res_0x7f0802f5);
            this.l.T(16);
            this.l.c0(true);
            this.l.r0(true);
            this.l.u0(ej.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070207));
        }
    }

    public final void O() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a.getPageActivity() == null || (writeData = this.e) == null || writeData.getPrefixData() == null || this.e.getPrefixData().getPrefixs().size() <= 1) {
            return;
        }
        w19 w19Var = new w19(this.a.getPageActivity());
        this.k = w19Var;
        w19Var.e(this);
        this.k.d(ej.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0702d6));
        this.k.setOutsideTouchable(true);
        this.k.setFocusable(true);
        this.k.setOnDismissListener(this);
        this.k.setBackgroundDrawable(SkinManager.getDrawable(R.color.CAM_X0201));
    }

    public void P(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || i >= this.m.size()) {
            return;
        }
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            this.m.get(i2).b(false);
        }
        this.m.get(i).b(true);
    }

    public final void Q() {
        x36 x36Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (x36Var = this.l) == null) {
            return;
        }
        x36Var.y0(this.a.getString(R.string.obfuscated_res_0x7f0f160d), "write_title_prefix_tip_key", true);
    }

    @Override // com.baidu.tieba.w19.a
    public void T0(int i) {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || this.k == null || this.h == null || (writeData = this.e) == null || writeData.getPrefixData() == null) {
            return;
        }
        if (i == ListUtils.getCount(this.e.getPrefixData().getPrefixs()) - 1) {
            TiebaStatic.log(new StatisticItem("c13014").param("obj_type", 1));
        } else {
            TiebaStatic.log(new StatisticItem("c13014").param("obj_type", 2));
        }
        this.k.c(i);
        P(i);
        if (this.h.getText() != null) {
            this.h.setText(this.e.getPrefixData().getPrefixs().get(i));
            this.e.setPostPrefix(this.h.getText().toString());
        }
        u49 u49Var = this.b;
        if (u49Var != null) {
            u49Var.h();
        }
        ih.d(this.k, this.a.getPageActivity());
    }

    @Override // com.baidu.tieba.s49
    public void b(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.c();
            x36 x36Var = this.l;
            if (x36Var != null) {
                x36Var.N();
            }
        }
    }

    @Override // com.baidu.tieba.s49
    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            w19 w19Var = this.k;
            if (w19Var == null || !w19Var.isShowing()) {
                return false;
            }
            ih.d(this.k, this.a.getPageActivity());
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.s49
    public void k(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.s49
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0210);
            hv4 d = hv4.d(this.h);
            d.v(R.color.CAM_X0105);
            d.A(R.string.F_X02);
            d.f(R.color.CAM_X0201);
            if (this.j != null) {
                w19 w19Var = this.k;
                if (w19Var != null && w19Var.isShowing()) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f080951, R.color.CAM_X0105, null);
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
                }
            }
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            LinearLayout linearLayout = this.g;
            if (linearLayout != null) {
                linearLayout.setSelected(false);
            }
            if (this.j != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            }
            u49 u49Var = this.b;
            if (u49Var != null) {
                u49Var.p(true);
            }
        }
    }

    @Override // com.baidu.tieba.p49
    public void onUpdate(Object obj) {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, obj) == null) && (obj instanceof SelectForumData) && (writeData = this.e) != null) {
            writeData.setPrefixData(null);
            SelectForumData selectForumData = (SelectForumData) obj;
            PostPrefixData postPrefixData = selectForumData.postPrefix;
            if (postPrefixData != null && !ListUtils.isEmpty(postPrefixData.getPrefixs())) {
                selectForumData.postPrefix.getPrefixs().add(this.a.getString(R.string.obfuscated_res_0x7f0f15f7));
                this.e.setPrefixData(selectForumData.postPrefix);
            }
            L();
        }
    }

    @Override // com.baidu.tieba.s49
    public View q(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04c6, viewGroup, false);
            this.c = inflate;
            this.g = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091a4a);
            this.h = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091a49);
            this.i = this.c.findViewById(R.id.obfuscated_res_0x7f091a69);
            this.j = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091a6a);
            L();
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
