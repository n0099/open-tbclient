package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.bd5;
import com.baidu.tieba.ii;
import com.baidu.tieba.n55;
import com.baidu.tieba.p45;
import com.baidu.tieba.pc5;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.qe5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, bd5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBSpecificationBtn a;
    public TBSpecificationBtn b;
    public EditorTools c;
    public int d;
    public boolean e;

    @Override // com.baidu.tieba.bd5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.baidu.tieba.bd5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
        }
    }

    /* loaded from: classes5.dex */
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
                p45.m().w("key_virtual_image_and_state_ying_has_show", z);
                this.a.k(z);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                boolean z = !((Boolean) this.a.b.a).booleanValue();
                p45.m().w(p45.q("key_reply_add_bless_enable"), z);
                this.a.j(z);
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
        this.d = 0;
        this.e = true;
        h();
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, context) != null) || !qe5.a()) {
            return;
        }
        this.b = f(context);
        j(p45.m().i(p45.q("key_reply_add_bless_enable"), true));
        this.b.setOnClickListener(new b(this));
        addView(this.b);
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, context) != null) || !ProfileVirtualImageInfo.getInstance().isDisplayVirtual()) {
            return;
        }
        this.a = f(context);
        k(p45.m().i("key_virtual_image_and_state_ying_has_show", true));
        this.a.setOnClickListener(new a(this));
        addView(this.a);
    }

    @Override // com.baidu.tieba.qc5
    public void C(pc5 pc5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, pc5Var) == null) && pc5Var != null && pc5Var.a == 68) {
            p45.m().w("key_virtual_image_and_state_has_show", false);
            k(false);
        }
    }

    @Override // com.baidu.tieba.bd5
    public void H(pc5 pc5Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pc5Var) == null) && (editorTools = this.c) != null) {
            editorTools.C(pc5Var);
        }
    }

    @Override // com.baidu.tieba.bd5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            e(i);
        }
    }

    @Override // com.baidu.tieba.bd5
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, editorTools) == null) {
            this.c = editorTools;
        }
    }

    @Override // com.baidu.tieba.bd5
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.d = i;
        }
    }

    @Override // com.baidu.tieba.bd5
    public void display() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.e) {
            this.e = false;
        }
    }

    @Override // com.baidu.tieba.bd5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setGravity(16);
            setOrientation(0);
            g(getContext());
            i(getContext());
        }
    }

    public void e(int i) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || (tBSpecificationBtn = this.a) == null) {
            return;
        }
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.getStyleConfig().k(SkinManager.getColor(R.color.CAM_X0105));
            this.a.getStyleConfig().h(qe5.b(((Boolean) this.a.a).booleanValue()));
            this.a.l(i);
        }
        TBSpecificationBtn tBSpecificationBtn2 = this.b;
        if (tBSpecificationBtn2 != null) {
            tBSpecificationBtn2.getStyleConfig().k(SkinManager.getColor(R.color.CAM_X0105));
            this.b.getStyleConfig().h(qe5.b(((Boolean) this.b.a).booleanValue()));
            this.b.l(i);
        }
    }

    public final TBSpecificationBtn f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            n55 n55Var = new n55();
            n55Var.r(R.color.CAM_X0209, SkinManager.getColor(R.color.CAM_X0105));
            n55Var.y(false);
            n55Var.h(qe5.b(true));
            n55Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            n55Var.n(ii.g(getContext(), R.dimen.M_W_X004), ii.g(getContext(), R.dimen.M_W_X004));
            n55Var.o(ii.g(getContext(), R.dimen.M_H_X002));
            n55Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            tBSpecificationBtn.setConfig(n55Var);
            tBSpecificationBtn.setTextSize(R.dimen.T_X09);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ii.g(getContext(), R.dimen.tbds63));
            layoutParams.rightMargin = ii.g(context, R.dimen.M_W_X007);
            tBSpecificationBtn.setLayoutParams(layoutParams);
            return tBSpecificationBtn;
        }
        return (TBSpecificationBtn) invokeL.objValue;
    }

    public final void j(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (tBSpecificationBtn = this.b) != null) {
            tBSpecificationBtn.setText(BdBaseApplication.getInst().getResources().getString(R.string.show_spring_festival));
            TBSpecificationButtonConfig styleConfig = this.b.getStyleConfig();
            if (z) {
                i = R.drawable.icon_pure_post_chosen12;
            } else {
                i = R.drawable.icon_pure_post_chose12;
            }
            styleConfig.i(i, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.b.getStyleConfig().h(qe5.b(z));
            this.b.a = Boolean.valueOf(z);
        }
    }

    public final void k(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.a;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setText(BdBaseApplication.getInst().getResources().getString(R.string.show_virtual_image_state));
                TBSpecificationButtonConfig styleConfig = this.a.getStyleConfig();
                if (z) {
                    i = R.drawable.icon_pure_post_chosen12;
                } else {
                    i = R.drawable.icon_pure_post_chose12;
                }
                styleConfig.i(i, 0, TBSpecificationButtonConfig.IconType.WEBP);
                this.a.getStyleConfig().h(qe5.b(z));
                this.a.a = Boolean.valueOf(z);
            }
            H(new pc5(67, -1, Boolean.valueOf(z)));
        }
    }
}
