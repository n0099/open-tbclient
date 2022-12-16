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
import com.baidu.tieba.g79;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class y99 extends ca9<ya9> implements ea9, g79.a, PopupWindow.OnDismissListener {
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
    public g79 k;
    @Nullable
    public x66 l;
    public ArrayList<WritePrefixItemLayout> m;

    @Override // com.baidu.tieba.ha9
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.ha9
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.ha9
    public void e(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, writeData) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ LinearLayout b;
        public final /* synthetic */ ImageView c;
        public final /* synthetic */ g79 d;
        public final /* synthetic */ y99 e;

        public a(y99 y99Var, TextView textView, LinearLayout linearLayout, ImageView imageView, g79 g79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y99Var, textView, linearLayout, imageView, g79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = y99Var;
            this.a = textView;
            this.b = linearLayout;
            this.c = imageView;
            this.d = g79Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = new StatisticItem("c13013");
                if (this.e.e != null) {
                    str = this.e.e.getForumId();
                } else {
                    str = "";
                }
                TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.a.setVisibility(0);
                this.b.setSelected(true);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.c, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null);
                if (this.e.b != null) {
                    this.e.b.C();
                    this.e.b.p(false);
                }
                ch.l(this.d, view2, 0, yi.d(this.e.a.getPageActivity(), 1.0f));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;
        public final /* synthetic */ g79 c;
        public final /* synthetic */ y99 d;

        public b(y99 y99Var, TextView textView, ImageView imageView, g79 g79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y99Var, textView, imageView, g79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = y99Var;
            this.a = textView;
            this.b = imageView;
            this.c = g79Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = new StatisticItem("c13013");
                if (this.d.e != null) {
                    str = this.d.e.getForumId();
                } else {
                    str = "";
                }
                TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.a.setSelected(true);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.b, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null);
                if (this.d.b != null) {
                    this.d.b.C();
                    this.d.b.p(false);
                }
                ch.l(this.c, view2, 0, yi.d(this.d.a.getPageActivity(), 1.0f));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y99(TbPageContext<?> tbPageContext) {
        super(tbPageContext, ya9.class);
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

    public void R(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048583, this, i) != null) || i >= this.m.size()) {
            return;
        }
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            this.m.get(i2).b(false);
        }
        this.m.get(i).b(true);
    }

    public final void L(@NonNull WriteData writeData, @NonNull g79 g79Var, @NonNull TextView textView) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, writeData, g79Var, textView) == null) {
            this.m.clear();
            ArrayList<String> prefixs = writeData.getPrefixData().getPrefixs();
            int size = prefixs.size();
            int color = SkinManager.getColor(R.color.CAM_X0105);
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(this.a.getPageActivity());
                this.m.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                writePrefixItemLayout.setPrefixTextColor(color);
                int i2 = size - 1;
                boolean z2 = true;
                if (i == i2) {
                    z = true;
                } else {
                    z = false;
                }
                writePrefixItemLayout.c(z);
                if (i != i2) {
                    z2 = false;
                }
                writePrefixItemLayout.setDividerStyle(z2);
                g79Var.a(writePrefixItemLayout);
            }
            g79Var.c(0);
            textView.setText(prefixs.get(0));
        }
    }

    public final void M(@NonNull TextView textView, @NonNull ImageView imageView, @NonNull g79 g79Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, imageView, g79Var) == null) {
            textView.setOnClickListener(new b(this, textView, imageView, g79Var));
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Q();
            P();
            if (this.h != null && this.g != null && this.i != null && this.j != null && this.k != null) {
                WriteData writeData = this.e;
                if (writeData != null && writeData.getPrefixData() != null) {
                    if (this.e.getPrefixData().getPrefixs().size() > 1) {
                        this.g.setVisibility(0);
                        this.i.setVisibility(0);
                        S();
                        O(this.g, this.h, this.j, this.k);
                        M(this.h, this.j, this.k);
                        L(this.e, this.k, this.h);
                        R(0);
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
    }

    public final void Q() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a.getPageActivity() != null && (writeData = this.e) != null && writeData.getPrefixData() != null && this.e.getPrefixData().getPrefixs().size() > 1) {
            g79 g79Var = new g79(this.a.getPageActivity());
            this.k = g79Var;
            g79Var.e(this);
            this.k.d(yi.g(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0702d6));
            this.k.setOutsideTouchable(true);
            this.k.setFocusable(true);
            this.k.setOnDismissListener(this);
            this.k.setBackgroundDrawable(SkinManager.getDrawable(R.color.CAM_X0201));
        }
    }

    public final void O(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull g79 g79Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, linearLayout, textView, imageView, g79Var) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(imageView, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            linearLayout.setOnClickListener(new a(this, textView, linearLayout, imageView, g79Var));
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a.getPageActivity() != null && this.l == null) {
            x66 x66Var = new x66(this.a, this.g);
            this.l = x66Var;
            x66Var.L(R.drawable.bg_tip_blue_up_left);
            this.l.o(16);
            this.l.x(true);
            this.l.M(true);
            this.l.P(yi.g(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070207));
        }
    }

    @Override // com.baidu.tieba.g79.a
    public void Q0(int i) {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && this.k != null && this.h != null && (writeData = this.e) != null && writeData.getPrefixData() != null) {
            if (i == ListUtils.getCount(this.e.getPrefixData().getPrefixs()) - 1) {
                TiebaStatic.log(new StatisticItem("c13014").param("obj_type", 1));
            } else {
                TiebaStatic.log(new StatisticItem("c13014").param("obj_type", 2));
            }
            this.k.c(i);
            R(i);
            if (this.h.getText() != null) {
                this.h.setText(this.e.getPrefixData().getPrefixs().get(i));
                if (this.h.getText() != null && !this.h.getText().toString().equals(this.a.getString(R.string.write_no_prefix))) {
                    this.e.setPostPrefix(this.h.getText().toString());
                }
            }
            ja9 ja9Var = this.b;
            if (ja9Var != null) {
                ja9Var.i();
            }
            ch.d(this.k, this.a.getPageActivity());
        }
    }

    public final void S() {
        x66 x66Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (x66Var = this.l) != null) {
            x66Var.T(this.a.getString(R.string.obfuscated_res_0x7f0f168a), "write_title_prefix_tip_key", true);
        }
    }

    @Override // com.baidu.tieba.ca9, com.baidu.tieba.ha9
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.d();
            x66 x66Var = this.l;
            if (x66Var != null) {
                x66Var.h();
            }
        }
    }

    @Override // com.baidu.tieba.ca9, com.baidu.tieba.ha9
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            g79 g79Var = this.k;
            if (g79Var != null && g79Var.isShowing()) {
                ch.d(this.k, this.a.getPageActivity());
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ha9
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0210);
            rw4 d = rw4.d(this.h);
            d.v(R.color.CAM_X0105);
            d.A(R.string.F_X02);
            d.f(R.color.CAM_X0201);
            if (this.j != null) {
                g79 g79Var = this.k;
                if (g79Var != null && g79Var.isShowing()) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null);
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ea9
    public void onUpdate(Object obj) {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, obj) == null) && (obj instanceof SelectForumData) && (writeData = this.e) != null) {
            writeData.setPrefixData(null);
            SelectForumData selectForumData = (SelectForumData) obj;
            PostPrefixData postPrefixData = selectForumData.postPrefix;
            if (postPrefixData != null && !ListUtils.isEmpty(postPrefixData.getPrefixs())) {
                selectForumData.postPrefix.getPrefixs().add(this.a.getString(R.string.write_no_prefix));
                this.e.setPrefixData(selectForumData.postPrefix);
            }
            N();
        }
    }

    @Override // com.baidu.tieba.ha9
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04e4, viewGroup, false);
            this.c = inflate;
            this.g = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091aff);
            this.h = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091afe);
            this.i = this.c.findViewById(R.id.obfuscated_res_0x7f091b1e);
            this.j = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091b1f);
            N();
            return this.c;
        }
        return (View) invokeL.objValue;
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
            ja9 ja9Var = this.b;
            if (ja9Var != null) {
                ja9Var.p(true);
            }
        }
    }
}
