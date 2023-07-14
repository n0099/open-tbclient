package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.cl5;
import com.baidu.tieba.d85;
import com.baidu.tieba.da5;
import com.baidu.tieba.ej5;
import com.baidu.tieba.hb5;
import com.baidu.tieba.mj5;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.yi;
import com.baidu.tieba.zi5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, mj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBSpecificationBtn a;
    public TBSpecificationBtn b;
    public View c;
    public EditorTools d;
    public int e;
    public boolean f;
    public String g;

    @Override // com.baidu.tieba.mj5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.baidu.tieba.mj5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbLocationInfoContainer a;

        public a(PbLocationInfoContainer pbLocationInfoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbLocationInfoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbLocationInfoContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = !((Boolean) this.a.a.a).booleanValue();
                da5.p().A("key_virtual_image_and_state_ying_has_show", z);
                this.a.n(z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbLocationInfoContainer a;

        public b(PbLocationInfoContainer pbLocationInfoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbLocationInfoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbLocationInfoContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ej5.d(view2);
                StatisticItem addParam = new StatisticItem("c15295").param("obj_source", "2").param("obj_type", "2").addParam("fid", this.a.d.getFid()).addParam("uid", TbadkCoreApplication.getCurrentAccount());
                if (!TextUtils.isEmpty(this.a.g) && !"0".equals(this.a.g)) {
                    addParam.addParam("fid", this.a.g);
                } else if (this.a.d != null && this.a.d.getFid() != 0) {
                    addParam.addParam("fid", String.valueOf(this.a.d.getFid()));
                }
                TiebaStatic.log(addParam);
                this.a.G(new zi5(77, -1, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbLocationInfoContainer a;

        public c(PbLocationInfoContainer pbLocationInfoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbLocationInfoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbLocationInfoContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = !((Boolean) this.a.b.a).booleanValue();
                da5.p().A(da5.t("key_reply_add_bless_enable"), z);
                this.a.m(z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbLocationInfoContainer(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.f = true;
        k();
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, context) != null) || !cl5.a()) {
            return;
        }
        this.b = h(context);
        m(da5.p().l(da5.t("key_reply_add_bless_enable"), true));
        this.b.setOnClickListener(new c(this));
        addView(this.b);
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, context) != null) || !ProfileVirtualImageInfo.getInstance().isDisplayVirtual()) {
            return;
        }
        this.a = h(context);
        n(da5.p().l("key_virtual_image_and_state_ying_has_show", true));
        this.a.setOnClickListener(new a(this));
        addView(this.a);
    }

    @Override // com.baidu.tieba.mj5
    public void G(zi5 zi5Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zi5Var) == null) && (editorTools = this.d) != null) {
            editorTools.D(zi5Var);
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            FrameLayout a2 = ej5.a(context);
            this.c = a2;
            a2.setOnClickListener(new b(this));
            this.c.setVisibility(8);
            addView(this.c);
        }
    }

    @Override // com.baidu.tieba.mj5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            g(i);
        }
    }

    @Override // com.baidu.tieba.mj5
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, editorTools) == null) {
            this.d = editorTools;
        }
    }

    @Override // com.baidu.tieba.mj5
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.e = i;
        }
    }

    @Override // com.baidu.tieba.aj5
    public void B(zi5 zi5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, zi5Var) != null) || zi5Var == null) {
            return;
        }
        if (zi5Var.a == 68) {
            da5.p().A("key_virtual_image_and_state_has_show", false);
            n(false);
        }
        if (zi5Var.a == 76 && this.c != null) {
            Object obj = zi5Var.c;
            if (obj instanceof String) {
                this.g = (String) obj;
            }
            this.c.setVisibility(0);
            StatisticItem addParam = new StatisticItem("c15295").param("obj_source", "2").param("obj_type", "1").addParam("uid", TbadkCoreApplication.getCurrentAccount());
            if (!TextUtils.isEmpty(this.g) && !"0".equals(this.g)) {
                addParam.addParam("fid", this.g);
            } else {
                EditorTools editorTools = this.d;
                if (editorTools != null && editorTools.getFid() != 0) {
                    addParam.addParam("fid", String.valueOf(this.d.getFid()));
                }
            }
            TiebaStatic.log(addParam);
        }
    }

    @Override // com.baidu.tieba.mj5
    public void display() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f) {
            this.f = false;
        }
    }

    @Override // com.baidu.tieba.mj5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            setGravity(16);
            setOrientation(0);
            i(getContext());
            j(getContext());
            l(getContext());
        }
    }

    public void g(int i) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || (tBSpecificationBtn = this.a) == null) {
            return;
        }
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.getStyleConfig().l(SkinManager.getColor(R.color.CAM_X0105));
            this.a.getStyleConfig().i(cl5.b(((Boolean) this.a.a).booleanValue()));
            this.a.l(i);
        }
        TBSpecificationBtn tBSpecificationBtn2 = this.b;
        if (tBSpecificationBtn2 != null) {
            tBSpecificationBtn2.getStyleConfig().l(SkinManager.getColor(R.color.CAM_X0105));
            this.b.getStyleConfig().i(cl5.b(((Boolean) this.b.a).booleanValue()));
            this.b.l(i);
        }
        View view2 = this.c;
        if (view2 != null) {
            d85 d = d85.d(view2);
            d.m(R.dimen.L_X02);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0209);
        }
    }

    public final TBSpecificationBtn h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            hb5 hb5Var = new hb5();
            hb5Var.s(R.color.CAM_X0209, SkinManager.getColor(R.color.CAM_X0105));
            hb5Var.z(false);
            hb5Var.i(cl5.b(true));
            hb5Var.g(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            hb5Var.o(yi.g(getContext(), R.dimen.M_W_X004), yi.g(getContext(), R.dimen.M_W_X004));
            hb5Var.p(yi.g(getContext(), R.dimen.M_H_X002));
            hb5Var.h(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            tBSpecificationBtn.setConfig(hb5Var);
            tBSpecificationBtn.setTextSize(R.dimen.T_X09);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, yi.g(getContext(), R.dimen.tbds63));
            layoutParams.rightMargin = yi.g(context, R.dimen.M_W_X007);
            tBSpecificationBtn.setLayoutParams(layoutParams);
            return tBSpecificationBtn;
        }
        return (TBSpecificationBtn) invokeL.objValue;
    }

    public final void m(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (tBSpecificationBtn = this.b) != null) {
            tBSpecificationBtn.setText(BdBaseApplication.getInst().getResources().getString(R.string.show_spring_festival));
            TBSpecificationButtonConfig styleConfig = this.b.getStyleConfig();
            if (z) {
                i = R.drawable.icon_pure_post_chosen12;
            } else {
                i = R.drawable.icon_pure_post_chose12;
            }
            styleConfig.j(i, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.b.getStyleConfig().i(cl5.b(z));
            this.b.a = Boolean.valueOf(z);
        }
    }

    public final void n(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.a;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setText(BdBaseApplication.getInst().getResources().getString(R.string.show_virtual_image_state));
                TBSpecificationButtonConfig styleConfig = this.a.getStyleConfig();
                if (z) {
                    i = R.drawable.icon_pure_post_chosen12;
                } else {
                    i = R.drawable.icon_pure_post_chose12;
                }
                styleConfig.j(i, 0, TBSpecificationButtonConfig.IconType.WEBP);
                this.a.getStyleConfig().i(cl5.b(z));
                this.a.a = Boolean.valueOf(z);
            }
            G(new zi5(67, -1, Boolean.valueOf(z)));
        }
    }
}
