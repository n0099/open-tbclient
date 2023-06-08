package com.baidu.tieba.write.editor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.afa;
import com.baidu.tieba.c55;
import com.baidu.tieba.hi5;
import com.baidu.tieba.la5;
import com.baidu.tieba.n95;
import com.baidu.tieba.o75;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.uh5;
import com.baidu.tieba.vi;
import com.baidu.tieba.wj5;
import com.baidu.tieba.write.view.CustomPrivacyDialogView;
import com.baidu.tieba.zh5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class EditorInfoContainer extends LinearLayout implements hi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBSpecificationBtn a;
    public TBSpecificationBtn b;
    public TBSpecificationBtn c;
    public TBSpecificationBtn d;
    public View e;
    public EditorTools f;
    public int g;
    public boolean h;
    public String i;
    public String j;
    public String k;
    public LinearLayout l;
    public LinearLayout m;
    public HorizontalScrollView n;
    public CustomMessageListener o;

    /* loaded from: classes8.dex */
    public interface j {
        void onChange(boolean z);
    }

    @Override // com.baidu.tieba.hi5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ EditorInfoContainer b;

        /* loaded from: classes8.dex */
        public class a implements j {
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

            @Override // com.baidu.tieba.write.editor.EditorInfoContainer.j
            public void onChange(boolean z) {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    if ("from_share_write".equals(this.a.b.j)) {
                        if ("1".equals(this.a.b.i)) {
                            TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 6));
                        } else if ("2".equals(this.a.b.i)) {
                            TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 5));
                        }
                    }
                    if (z) {
                        if (((Integer) this.a.b.a.a).intValue() == 0) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        this.a.b.D(i);
                        if ("2".equals(this.a.b.i)) {
                            afa.b(this.a.b.k, i);
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
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED);
                if (((Integer) this.b.a.a).intValue() == 0) {
                    i = 11;
                } else {
                    i = 12;
                }
                TiebaStatic.log(statisticItem.param("obj_locate", i));
                EditorInfoContainer editorInfoContainer = this.b;
                editorInfoContainer.B(this.a, ((Integer) editorInfoContainer.a.a).intValue(), new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;
        public final /* synthetic */ c55 b;
        public final /* synthetic */ EditorInfoContainer c;

        public a(EditorInfoContainer editorInfoContainer, j jVar, c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, jVar, c55Var};
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
            this.a = jVar;
            this.b = c55Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null) {
                    TiebaStatic.log(new StatisticItem("c13805").param("obj_locate", 2));
                    this.a.onChange(true);
                }
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;
        public final /* synthetic */ c55 b;
        public final /* synthetic */ EditorInfoContainer c;

        public b(EditorInfoContainer editorInfoContainer, j jVar, c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, jVar, c55Var};
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
            this.a = jVar;
            this.b = c55Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null) {
                    TiebaStatic.log(new StatisticItem("c13805").param("obj_locate", 1));
                    this.a.onChange(false);
                }
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                zh5.d(view2);
                StatisticItem addParam = new StatisticItem("c15295").param("obj_source", "1").param("obj_type", "2").addParam("uid", TbadkCoreApplication.getCurrentAccount());
                if (!TextUtils.isEmpty(this.a.k) && !"0".equals(this.a.k)) {
                    addParam.addParam("fid", this.a.k);
                } else if (this.a.f != null && this.a.f.getFid() != 0) {
                    addParam.addParam("fid", String.valueOf(this.a.f.getFid()));
                }
                TiebaStatic.log(addParam);
                this.a.H(new uh5(77, -1, null));
            }
        }
    }

    /* loaded from: classes8.dex */
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
                this.a.H(new uh5(43, -1, null));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = !((Boolean) this.a.c.a).booleanValue();
                this.a.F(z);
                n95.m().w("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), z);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        public g(EditorInfoContainer editorInfoContainer) {
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
                boolean z = !((Boolean) this.a.d.a).booleanValue();
                this.a.E(z);
                n95.m().w(n95.q("key_write_add_bless_enable"), z);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements afa.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        public h(EditorInfoContainer editorInfoContainer) {
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

        @Override // com.baidu.tieba.afa.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.D(i);
        }
    }

    /* loaded from: classes8.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(EditorInfoContainer editorInfoContainer, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorInfoContainer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921756) {
                n95 m = n95.m();
                this.a.F(m.i("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), true));
            }
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (AttributeSet) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = true;
        this.o = new i(this, 2921756);
        this.i = str;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(0, (int) context.getResources().getDimension(R.dimen.M_H_X004), 0, (int) context.getResources().getDimension(R.dimen.M_H_X003));
        setGravity(16);
        setOrientation(0);
        q(context);
        p(context);
        r(context);
        v(context);
        s(context);
        x(context);
        if (context instanceof BdBaseFragmentActivity) {
            ((BdBaseFragmentActivity) context).registerListener(this.o);
        }
    }

    public final void B(Context context, int i2, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, jVar) == null) {
            boolean i3 = n95.m().i("show_privacy_dialog", false);
            if (i2 != 1 && !i3) {
                n95.m().w("show_privacy_dialog", true);
                TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) context;
                if (tbPageContextSupport != null && tbPageContextSupport.getPageContext() != null && tbPageContextSupport.getPageContext().getPageActivity() != null) {
                    c55 c55Var = new c55(tbPageContextSupport.getPageContext().getPageActivity());
                    c55Var.setCancelable(false);
                    c55Var.setPositiveButton((String) null, (c55.e) null);
                    c55Var.setNegativeButton((String) null, (c55.e) null);
                    c55Var.setContentViewSize(6);
                    CustomPrivacyDialogView customPrivacyDialogView = new CustomPrivacyDialogView(context);
                    customPrivacyDialogView.setMessageTextViewMessage(context.getString(R.string.obfuscated_res_0x7f0f1886));
                    customPrivacyDialogView.setMessageTextViewColor(SkinManager.getColor(R.color.CAM_X0107));
                    customPrivacyDialogView.setPrivacyDialogCancelButtonText(context.getString(R.string.obfuscated_res_0x7f0f1884));
                    customPrivacyDialogView.setPrivacyDialogConfirmButtonText(context.getString(R.string.obfuscated_res_0x7f0f1885));
                    customPrivacyDialogView.setPrivacyDialogCancelButtonListener(new a(this, jVar, c55Var));
                    customPrivacyDialogView.setPrivacyDialogConfirmButtonListener(new b(this, jVar, c55Var));
                    c55Var.setContentView(customPrivacyDialogView);
                    c55Var.create(tbPageContextSupport.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem("c13804"));
                }
            } else if (jVar != null) {
                jVar.onChange(true);
            }
        }
    }

    public void A(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (tBSpecificationBtn = this.b) != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            tBSpecificationBtn.setVisibility(i2);
        }
    }

    @Override // com.baidu.tieba.hi5
    public void H(uh5 uh5Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, uh5Var) == null) && (editorTools = this.f) != null) {
            editorTools.C(uh5Var);
        }
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
            FrameLayout a2 = zh5.a(context);
            this.e = a2;
            a2.setOnClickListener(new c(this));
            this.e.setVisibility(8);
            this.m.addView(this.e);
        }
    }

    @Override // com.baidu.tieba.hi5
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, editorTools) == null) {
            this.f = editorTools;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.j = str;
        }
    }

    @Override // com.baidu.tieba.hi5
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.g = i2;
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048601, this, i2) == null) && "2".equals(this.i)) {
            D(i2);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    public void t(String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048600, this, str, i2) == null) && "2".equals(this.i)) {
            this.k = str;
            afa.a(str, i2, new h(this));
        }
    }

    @Override // com.baidu.tieba.vh5
    public void C(uh5 uh5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uh5Var) != null) || uh5Var == null) {
            return;
        }
        int i2 = uh5Var.a;
        if (i2 != 54) {
            if (i2 != 57) {
                if (i2 != 65) {
                    if (i2 == 76) {
                        Object obj = uh5Var.c;
                        if (obj instanceof String) {
                            this.k = (String) obj;
                        }
                        View view2 = this.e;
                        if (view2 != null) {
                            view2.setVisibility(0);
                            StatisticItem addParam = new StatisticItem("c15295").addParam("obj_source", "1").addParam("obj_type", "1").addParam("uid", TbadkCoreApplication.getCurrentAccount());
                            if (!TextUtils.isEmpty(this.k) && !"0".equals(this.k)) {
                                addParam.addParam("fid", this.k);
                            } else {
                                EditorTools editorTools = this.f;
                                if (editorTools != null && editorTools.getFid() != 0) {
                                    addParam.addParam("fid", String.valueOf(this.f.getFid()));
                                }
                            }
                            TiebaStatic.log(addParam);
                            return;
                        }
                        return;
                    }
                    return;
                }
                H(new uh5(66, -1, Boolean.valueOf(z())));
                return;
            }
            H(new uh5(58, -1, Boolean.FALSE));
            return;
        }
        H(new uh5(55, -1, Boolean.valueOf(y())));
    }

    public final TBSpecificationBtn l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, vi.g(getContext(), R.dimen.tbds62));
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            la5 la5Var = new la5();
            la5Var.r(R.color.CAM_X0209, SkinManager.getColor(R.color.CAM_X0105));
            la5Var.y(false);
            la5Var.h(wj5.b(true));
            la5Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            la5Var.n(vi.g(getContext(), R.dimen.M_W_X004), vi.g(getContext(), R.dimen.M_W_X004));
            la5Var.o(vi.g(getContext(), R.dimen.M_H_X002));
            la5Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            tBSpecificationBtn.setConfig(la5Var);
            tBSpecificationBtn.setTextSize(R.dimen.T_X09);
            tBSpecificationBtn.setLayoutParams(layoutParams);
            return tBSpecificationBtn;
        }
        return (TBSpecificationBtn) invokeL.objValue;
    }

    @Override // com.baidu.tieba.hi5
    public void onChangeSkinType(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.a;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.getStyleConfig().k(SkinManager.getColor(R.color.CAM_X0105));
                TBSpecificationButtonConfig styleConfig = this.a.getStyleConfig();
                if (((Integer) this.a.a).intValue() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                styleConfig.h(wj5.b(z));
                this.a.k();
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.b;
            if (tBSpecificationBtn2 != null) {
                tBSpecificationBtn2.k();
            }
            TBSpecificationBtn tBSpecificationBtn3 = this.c;
            if (tBSpecificationBtn3 != null) {
                tBSpecificationBtn3.getStyleConfig().k(SkinManager.getColor(R.color.CAM_X0105));
                this.c.getStyleConfig().h(wj5.b(((Boolean) this.c.a).booleanValue()));
                this.c.k();
            }
            TBSpecificationBtn tBSpecificationBtn4 = this.d;
            if (tBSpecificationBtn4 != null) {
                tBSpecificationBtn4.getStyleConfig().k(SkinManager.getColor(R.color.CAM_X0105));
                this.d.getStyleConfig().h(wj5.b(((Boolean) this.d.a).booleanValue()));
                this.d.k();
            }
            View view2 = this.e;
            if (view2 != null) {
                o75 d2 = o75.d(view2);
                d2.m(R.dimen.L_X02);
                d2.o(R.string.J_X06);
                d2.f(R.color.CAM_X0209);
            }
        }
    }

    public final void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, context) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, vi.g(getContext(), R.dimen.tbds62));
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            la5 la5Var = new la5();
            la5Var.r(R.color.CAM_X0209, R.color.CAM_X0105);
            la5Var.h(R.color.CAM_X0110);
            la5Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            la5Var.n(vi.g(getContext(), R.dimen.M_W_X004), vi.g(getContext(), R.dimen.M_W_X004));
            la5Var.o(vi.g(getContext(), R.dimen.M_H_X002));
            la5Var.i(R.drawable.ic_icon_pure_post_topic12, 0, TBSpecificationButtonConfig.IconType.WEBP);
            la5Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.b = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(la5Var);
            this.b.setTextSize(R.dimen.T_X09);
            this.b.setText(getContext().getString(R.string.editor_hot_tipc));
            this.b.setOnClickListener(new d(this));
            this.m.addView(this.b, layoutParams);
        }
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, context) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, vi.g(getContext(), R.dimen.tbds62));
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            la5 la5Var = new la5();
            la5Var.r(R.color.CAM_X0209, SkinManager.getColor(R.color.CAM_X0105));
            la5Var.y(false);
            la5Var.h(wj5.b(true));
            la5Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            la5Var.n(vi.g(getContext(), R.dimen.M_W_X004), vi.g(getContext(), R.dimen.M_W_X004));
            la5Var.o(vi.g(getContext(), R.dimen.M_H_X002));
            la5Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.a = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(la5Var);
            this.a.setTextSize(R.dimen.T_X09);
            D(0);
            this.a.setLayoutParams(layoutParams);
            this.a.setOnClickListener(new e(this, context));
            this.m.addView(this.a);
        }
    }

    public final void D(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.a.setText(getResources().getString(R.string.obfuscated_res_0x7f0f1130));
            TBSpecificationButtonConfig styleConfig = this.a.getStyleConfig();
            if (i2 == 0) {
                i3 = R.drawable.icon_pure_post_chosen12;
            } else {
                i3 = R.drawable.icon_pure_post_chose12;
            }
            boolean z = false;
            styleConfig.i(i3, 0, TBSpecificationButtonConfig.IconType.WEBP);
            TBSpecificationButtonConfig styleConfig2 = this.a.getStyleConfig();
            if (i2 == 0) {
                z = true;
            }
            styleConfig2.h(wj5.b(z));
            this.a.a = Integer.valueOf(i2);
        }
    }

    public final void E(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.d.setText(getResources().getString(R.string.show_spring_festival));
            TBSpecificationButtonConfig styleConfig = this.d.getStyleConfig();
            if (z) {
                i2 = R.drawable.icon_pure_post_chosen12;
            } else {
                i2 = R.drawable.icon_pure_post_chose12;
            }
            styleConfig.i(i2, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.d.getStyleConfig().h(wj5.b(z));
            this.d.a = Boolean.valueOf(z);
        }
    }

    public final void F(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.c.setText(getResources().getString(R.string.obfuscated_res_0x7f0f1397));
            TBSpecificationButtonConfig styleConfig = this.c.getStyleConfig();
            if (z) {
                i2 = R.drawable.icon_pure_post_chosen12;
            } else {
                i2 = R.drawable.icon_pure_post_chose12;
            }
            styleConfig.i(i2, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.c.getStyleConfig().h(wj5.b(z));
            this.c.a = Boolean.valueOf(z);
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, context) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            LinearLayout linearLayout = new LinearLayout(context);
            this.l = linearLayout;
            linearLayout.setGravity(3);
            addView(this.l, layoutParams);
            HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
            this.n = horizontalScrollView;
            horizontalScrollView.setHorizontalFadingEdgeEnabled(true);
            this.n.setHorizontalScrollBarEnabled(false);
            this.l.addView(this.n);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            LinearLayout linearLayout2 = new LinearLayout(context);
            this.m = linearLayout2;
            this.n.addView(linearLayout2, layoutParams2);
        }
    }

    public final void x(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, context) != null) || !ProfileVirtualImageInfo.getInstance().isDisplayVirtual()) {
            return;
        }
        TBSpecificationBtn l = l(context);
        this.c = l;
        l.setOnClickListener(new f(this));
        this.m.addView(this.c);
        n95 m = n95.m();
        F(m.i("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), true));
    }

    @Override // com.baidu.tieba.hi5
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.h) {
                this.h = false;
            }
            setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.hi5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.hi5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            m();
            setVisibility(8);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.c;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setVisibility(8);
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.d;
            if (tBSpecificationBtn2 != null) {
                tBSpecificationBtn2.setVisibility(8);
            }
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            TBSpecificationBtn tBSpecificationBtn2 = this.a;
            if ((tBSpecificationBtn2 != null && ((Integer) tBSpecificationBtn2.a).intValue() == 0) || (tBSpecificationBtn = this.a) == null || ((Integer) tBSpecificationBtn.a).intValue() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.c;
            if (tBSpecificationBtn != null) {
                Object obj = tBSpecificationBtn.a;
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void v(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048602, this, context) != null) || !wj5.a()) {
            return;
        }
        TBSpecificationBtn l = l(context);
        this.d = l;
        l.setOnClickListener(new g(this));
        this.m.addView(this.d);
        E(n95.m().i(n95.q("key_write_add_bless_enable"), true));
    }
}
