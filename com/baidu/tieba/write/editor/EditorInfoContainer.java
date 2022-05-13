package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.view.CustomPrivacyDialogView;
import com.baidu.tieba.write.write.TransmitPostEditActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iu4;
import com.repackage.j15;
import com.repackage.mi;
import com.repackage.n25;
import com.repackage.nr4;
import com.repackage.w05;
import com.repackage.wy8;
import com.repackage.yu4;
/* loaded from: classes4.dex */
public class EditorInfoContainer extends RelativeLayout implements j15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LocationInfoView a;
    public TBSpecificationBtn b;
    public TBSpecificationBtn c;
    public EditorTools d;
    public int e;
    public boolean f;
    public String g;
    public String h;
    public String i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;
        public final /* synthetic */ nr4 b;
        public final /* synthetic */ EditorInfoContainer c;

        public a(EditorInfoContainer editorInfoContainer, g gVar, nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, gVar, nr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = editorInfoContainer;
            this.a = gVar;
            this.b = nr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null) {
                    TiebaStatic.log(new StatisticItem("c13805").param("obj_locate", 2));
                    this.a.a(true);
                }
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;
        public final /* synthetic */ nr4 b;
        public final /* synthetic */ EditorInfoContainer c;

        public b(EditorInfoContainer editorInfoContainer, g gVar, nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, gVar, nr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = editorInfoContainer;
            this.a = gVar;
            this.b = nr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null) {
                    TiebaStatic.log(new StatisticItem("c13805").param("obj_locate", 1));
                    this.a.a(false);
                }
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements LocationInfoView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        public c(EditorInfoContainer editorInfoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorInfoContainer;
        }

        @Override // com.baidu.tbadk.editortools.editorinfotool.LocationInfoView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 3));
                this.a.g(new w05(18, -1, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        public d(EditorInfoContainer editorInfoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorInfoContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.g(new w05(43, -1, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ EditorInfoContainer b;

        /* loaded from: classes4.dex */
        public class a implements g {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // com.baidu.tieba.write.editor.EditorInfoContainer.g
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    if (TransmitPostEditActivity.FROM_SHARE_WRITE.equals(this.a.b.h)) {
                        if (!"1".equals(this.a.b.g)) {
                            if ("2".equals(this.a.b.g)) {
                                TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 5));
                            }
                        } else {
                            TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 6));
                        }
                    }
                    if (z) {
                        int i = ((Integer) this.a.b.b.a).intValue() == 0 ? 1 : 0;
                        this.a.b.u(i);
                        if ("2".equals(this.a.b.g)) {
                            wy8.b(this.a.b.i, i);
                        }
                    }
                }
            }
        }

        public e(EditorInfoContainer editorInfoContainer, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = editorInfoContainer;
            this.a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", ((Integer) this.b.b.a).intValue() == 0 ? 11 : 12));
                EditorInfoContainer editorInfoContainer = this.b;
                editorInfoContainer.t(this.a, ((Integer) editorInfoContainer.b.a).intValue(), new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements wy8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        public f(EditorInfoContainer editorInfoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorInfoContainer;
        }

        @Override // com.repackage.wy8.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.u(i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface g {
        void a(boolean z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (AttributeSet) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.j15
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f) {
                this.f = false;
                g(new w05(18, -1, Config.TRACE_VISIT_FIRST));
            }
            setVisibility(0);
        }
    }

    @Override // com.repackage.j15
    public void g(w05 w05Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w05Var) == null) || (editorTools = this.d) == null) {
            return;
        }
        editorTools.A(w05Var);
    }

    @Override // com.repackage.j15
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : invokeV.intValue;
    }

    @Override // com.repackage.j15
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            i();
            setVisibility(8);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.repackage.j15
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, mi.f(getContext(), R.dimen.tbds62));
            layoutParams.addRule(1, R.id.obfuscated_res_0x7f090865);
            yu4 yu4Var = new yu4();
            yu4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            yu4Var.h(R.color.CAM_X0110);
            yu4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            yu4Var.m(mi.f(getContext(), R.dimen.M_W_X004), mi.f(getContext(), R.dimen.M_W_X004));
            yu4Var.n(mi.f(getContext(), R.dimen.M_H_X002));
            yu4Var.i(R.drawable.obfuscated_res_0x7f080600, 0, TBSpecificationButtonConfig.IconType.WEBP);
            yu4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.c = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(yu4Var);
            this.c.setTextSize(R.dimen.T_X09);
            this.c.setText(getContext().getString(R.string.obfuscated_res_0x7f0f00d4));
            this.c.setOnClickListener(new d(this));
            addView(this.c, layoutParams);
        }
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            LocationInfoView locationInfoView = new LocationInfoView(context);
            this.a = locationInfoView;
            locationInfoView.setId(R.id.obfuscated_res_0x7f090865);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            this.a.setLocationClickListener(new c(this));
            addView(this.a, layoutParams);
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, mi.f(getContext(), R.dimen.tbds62));
            layoutParams.addRule(11);
            yu4 yu4Var = new yu4();
            yu4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            yu4Var.h(R.color.CAM_X0302);
            yu4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            yu4Var.m(mi.f(getContext(), R.dimen.M_W_X004), mi.f(getContext(), R.dimen.M_W_X004));
            yu4Var.n(mi.f(getContext(), R.dimen.M_H_X002));
            yu4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.b = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(yu4Var);
            this.b.setTextSize(R.dimen.T_X09);
            u(0);
            this.b.setLayoutParams(layoutParams);
            this.b.setOnClickListener(new e(this, context));
            addView(this.b);
        }
    }

    public void o(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048586, this, str, i) == null) && "2".equals(this.g)) {
            this.i = str;
            wy8.a(str, i, new f(this));
        }
    }

    @Override // com.repackage.x05
    public void onAction(w05 w05Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, w05Var) == null) || w05Var == null) {
            return;
        }
        int i = w05Var.a;
        if (i == 19) {
            LocationInfoView locationInfoView = this.a;
            if (locationInfoView == null) {
                return;
            }
            Object obj = w05Var.c;
            if (obj instanceof n25) {
                n25 n25Var = (n25) obj;
                locationInfoView.setState(n25Var.a, n25Var.b);
                return;
            }
            locationInfoView.setState(0, null);
        } else if (i == 20) {
            LocationInfoView locationInfoView2 = this.a;
            if (locationInfoView2 == null) {
                return;
            }
            locationInfoView2.setState(0, null);
        } else if (i == 54) {
            g(new w05(55, -1, Boolean.valueOf(r())));
        } else if (i != 57) {
        } else {
            g(new w05(58, -1, Boolean.FALSE));
        }
    }

    @Override // com.repackage.j15
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            LocationInfoView locationInfoView = this.a;
            if (locationInfoView != null) {
                locationInfoView.b(i);
            }
            TBSpecificationBtn tBSpecificationBtn = this.b;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.c;
            if (tBSpecificationBtn2 != null) {
                tBSpecificationBtn2.k();
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
            super.onMeasure(i, i2);
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && "2".equals(this.g)) {
            u(i);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            TBSpecificationBtn tBSpecificationBtn2 = this.b;
            return (tBSpecificationBtn2 == null || ((Integer) tBSpecificationBtn2.a).intValue() != 0) && (tBSpecificationBtn = this.b) != null && ((Integer) tBSpecificationBtn.a).intValue() == 1;
        }
        return invokeV.booleanValue;
    }

    public void s(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (tBSpecificationBtn = this.c) == null) {
            return;
        }
        tBSpecificationBtn.setVisibility(z ? 0 : 8);
    }

    @Override // com.repackage.j15
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, editorTools) == null) {
            this.d = editorTools;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.h = str;
        }
    }

    @Override // com.repackage.j15
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.e = i;
        }
    }

    public final void t(Context context, int i, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048597, this, context, i, gVar) == null) {
            boolean h = iu4.k().h("show_privacy_dialog", false);
            if (i == 1 || h) {
                if (gVar != null) {
                    gVar.a(true);
                    return;
                }
                return;
            }
            iu4.k().u("show_privacy_dialog", true);
            BaseActivity baseActivity = (BaseActivity) context;
            nr4 nr4Var = new nr4(baseActivity);
            nr4Var.setCancelable(false);
            nr4Var.setPositiveButton((String) null, (nr4.e) null);
            nr4Var.setNegativeButton((String) null, (nr4.e) null);
            nr4Var.setContentViewSize(6);
            CustomPrivacyDialogView customPrivacyDialogView = new CustomPrivacyDialogView(context);
            customPrivacyDialogView.setMessageTextViewMessage(context.getString(R.string.obfuscated_res_0x7f0f15bb));
            customPrivacyDialogView.setMessageTextViewColor(SkinManager.getColor(R.color.CAM_X0107));
            customPrivacyDialogView.setPrivacyDialogCancelButtonText(context.getString(R.string.obfuscated_res_0x7f0f15b9));
            customPrivacyDialogView.setPrivacyDialogConfirmButtonText(context.getString(R.string.obfuscated_res_0x7f0f15ba));
            customPrivacyDialogView.setPrivacyDialogCancelButtonListener(new a(this, gVar, nr4Var));
            customPrivacyDialogView.setPrivacyDialogConfirmButtonListener(new b(this, gVar, nr4Var));
            nr4Var.setContentView(customPrivacyDialogView);
            nr4Var.create(baseActivity.getPageContext()).show();
            TiebaStatic.log(new StatisticItem("c13804"));
        }
    }

    public final void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.b.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0f11));
            this.b.getStyleConfig().i(i == 0 ? R.drawable.obfuscated_res_0x7f080977 : R.drawable.obfuscated_res_0x7f080976, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.b.getStyleConfig().h(i == 0 ? R.color.CAM_X0302 : R.color.CAM_X0110);
            this.b.a = Integer.valueOf(i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = true;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(0, (int) context.getResources().getDimension(R.dimen.M_H_X004), 0, (int) context.getResources().getDimension(R.dimen.M_H_X003));
        setGravity(16);
        this.g = str;
        m(context);
        l(context);
        n(context);
    }
}
