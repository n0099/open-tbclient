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
import com.baidu.tieba.p7a;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class naa extends raa<nba> implements taa, p7a.a, PopupWindow.OnDismissListener {
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
    public p7a k;
    @Nullable
    public an6 l;
    public ArrayList<WritePrefixItemLayout> m;

    @Override // com.baidu.tieba.waa
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.waa
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.waa
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
        public final /* synthetic */ p7a d;
        public final /* synthetic */ naa e;

        public a(naa naaVar, TextView textView, LinearLayout linearLayout, ImageView imageView, p7a p7aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {naaVar, textView, linearLayout, imageView, p7aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = naaVar;
            this.a = textView;
            this.b = linearLayout;
            this.c = imageView;
            this.d = p7aVar;
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
                    this.e.b.B();
                    this.e.b.p(false);
                }
                ug.l(this.d, view2, 0, ri.d(this.e.a.getPageActivity(), 1.0f));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;
        public final /* synthetic */ p7a c;
        public final /* synthetic */ naa d;

        public b(naa naaVar, TextView textView, ImageView imageView, p7a p7aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {naaVar, textView, imageView, p7aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = naaVar;
            this.a = textView;
            this.b = imageView;
            this.c = p7aVar;
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
                    this.d.b.B();
                    this.d.b.p(false);
                }
                ug.l(this.c, view2, 0, ri.d(this.d.a.getPageActivity(), 1.0f));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public naa(TbPageContext<?> tbPageContext) {
        super(tbPageContext, nba.class);
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
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || i >= this.m.size()) {
            return;
        }
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            this.m.get(i2).b(false);
        }
        this.m.get(i).b(true);
    }

    public final void L(@NonNull WriteData writeData, @NonNull p7a p7aVar, @NonNull TextView textView) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, writeData, p7aVar, textView) == null) {
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
                p7aVar.a(writePrefixItemLayout);
            }
            p7aVar.c(0);
            textView.setText(prefixs.get(0));
        }
    }

    public final void M(@NonNull TextView textView, @NonNull ImageView imageView, @NonNull p7a p7aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, imageView, p7aVar) == null) {
            textView.setOnClickListener(new b(this, textView, imageView, p7aVar));
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
            p7a p7aVar = new p7a(this.a.getPageActivity());
            this.k = p7aVar;
            p7aVar.e(this);
            this.k.d(ri.g(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0703df));
            this.k.setOutsideTouchable(true);
            this.k.setFocusable(true);
            this.k.setOnDismissListener(this);
            this.k.setBackgroundDrawable(SkinManager.getDrawable(R.color.CAM_X0201));
        }
    }

    public final void O(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull p7a p7aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, linearLayout, textView, imageView, p7aVar) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(imageView, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            linearLayout.setOnClickListener(new a(this, textView, linearLayout, imageView, p7aVar));
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a.getPageActivity() != null && this.l == null) {
            an6 an6Var = new an6(this.a, this.g);
            this.l = an6Var;
            an6Var.L(R.drawable.bg_tip_blue_up_left);
            this.l.o(16);
            this.l.x(true);
            this.l.N(true);
            this.l.Q(ri.g(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070207));
        }
    }

    public final void S() {
        an6 an6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (an6Var = this.l) != null) {
            an6Var.U(this.a.getString(R.string.obfuscated_res_0x7f0f1834), "write_title_prefix_tip_key", true);
        }
    }

    @Override // com.baidu.tieba.raa, com.baidu.tieba.waa
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.d();
            an6 an6Var = this.l;
            if (an6Var != null) {
                an6Var.h();
            }
        }
    }

    @Override // com.baidu.tieba.raa, com.baidu.tieba.waa
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            p7a p7aVar = this.k;
            if (p7aVar != null && p7aVar.isShowing()) {
                ug.d(this.k, this.a.getPageActivity());
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.p7a.a
    public void S0(int i) {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && this.k != null && this.h != null && (writeData = this.e) != null && writeData.getPrefixData() != null) {
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
            yaa yaaVar = this.b;
            if (yaaVar != null) {
                yaaVar.i();
            }
            ug.d(this.k, this.a.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.waa
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0210);
            p45 d = p45.d(this.h);
            d.w(R.color.CAM_X0105);
            d.C(R.string.F_X02);
            d.f(R.color.CAM_X0201);
            if (this.j != null) {
                p7a p7aVar = this.k;
                if (p7aVar != null && p7aVar.isShowing()) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null);
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
                }
            }
        }
    }

    @Override // com.baidu.tieba.taa
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

    @Override // com.baidu.tieba.waa
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0527, viewGroup, false);
            this.c = inflate;
            this.g = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091c36);
            this.h = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091c35);
            this.i = this.c.findViewById(R.id.obfuscated_res_0x7f091c56);
            this.j = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091c57);
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
            yaa yaaVar = this.b;
            if (yaaVar != null) {
                yaaVar.p(true);
            }
        }
    }
}
