package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.CommunityConventionView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.b49;
import com.baidu.tieba.e65;
import com.baidu.tieba.iv4;
import com.baidu.tieba.jz4;
import com.baidu.tieba.kw4;
import com.baidu.tieba.ky4;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.q65;
import com.baidu.tieba.write.view.CustomPrivacyDialogView;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class EditorInfoContainer extends LinearLayout implements q65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBSpecificationBtn a;
    public TBSpecificationBtn b;
    public TBSpecificationBtn c;
    public EditorTools d;
    public int e;
    public boolean f;
    public String g;
    public String h;
    public String i;
    public CommunityConventionView j;
    public LinearLayout k;
    public LinearLayout l;
    public HorizontalScrollView m;
    public View n;
    public CustomMessageListener o;

    /* loaded from: classes6.dex */
    public interface i {
        void a(boolean z);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.tieba.q65
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ EditorInfoContainer b;

        /* loaded from: classes6.dex */
        public class a implements i {
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

            @Override // com.baidu.tieba.write.editor.EditorInfoContainer.i
            public void a(boolean z) {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    if ("from_share_write".equals(this.a.b.h)) {
                        if ("1".equals(this.a.b.g)) {
                            TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 6));
                        } else if ("2".equals(this.a.b.g)) {
                            TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 5));
                        }
                    }
                    if (z) {
                        if (((Integer) this.a.b.a.a).intValue() == 0) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        this.a.b.x(i);
                        if ("2".equals(this.a.b.g)) {
                            b49.b(this.a.b.i, i);
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
                editorInfoContainer.w(this.a, ((Integer) editorInfoContainer.a.a).intValue(), new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        public a(EditorInfoContainer editorInfoContainer) {
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
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_COMMUNITY_CONVENTION_CLICK).addParam("obj_locate", "2").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.getContext(), "", TbConfig.COMMUNITY_CONVENTION, true);
                tbWebViewActivityConfig.setFixTitle(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;
        public final /* synthetic */ iv4 b;
        public final /* synthetic */ EditorInfoContainer c;

        public b(EditorInfoContainer editorInfoContainer, i iVar, iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, iVar, iv4Var};
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
            this.a = iVar;
            this.b = iv4Var;
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

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;
        public final /* synthetic */ iv4 b;
        public final /* synthetic */ EditorInfoContainer c;

        public c(EditorInfoContainer editorInfoContainer, i iVar, iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, iVar, iv4Var};
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
            this.a = iVar;
            this.b = iv4Var;
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

    /* loaded from: classes6.dex */
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
                this.a.K(new e65(43, -1, null));
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.y(z);
                ky4.k().u("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements b49.c {
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

        @Override // com.baidu.tieba.b49.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.x(i);
        }
    }

    /* loaded from: classes6.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(EditorInfoContainer editorInfoContainer, int i) {
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
                ky4 k = ky4.k();
                this.a.y(k.h("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), true));
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
        this.f = true;
        this.o = new h(this, 2921756);
        this.g = str;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(0, (int) context.getResources().getDimension(R.dimen.M_H_X004), 0, (int) context.getResources().getDimension(R.dimen.M_H_X003));
        setGravity(16);
        setOrientation(0);
        m(context);
        l(context);
        n(context);
        o(context);
        s(context);
        if (context instanceof BdBaseFragmentActivity) {
            ((BdBaseFragmentActivity) context).registerListener(this.o);
        }
    }

    public final void w(Context context, int i2, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048601, this, context, i2, iVar) == null) {
            boolean h2 = ky4.k().h("show_privacy_dialog", false);
            if (i2 != 1 && !h2) {
                ky4.k().u("show_privacy_dialog", true);
                TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) context;
                if (tbPageContextSupport != null && tbPageContextSupport.getPageContext() != null && tbPageContextSupport.getPageContext().getPageActivity() != null) {
                    iv4 iv4Var = new iv4(tbPageContextSupport.getPageContext().getPageActivity());
                    iv4Var.setCancelable(false);
                    iv4Var.setPositiveButton((String) null, (iv4.e) null);
                    iv4Var.setNegativeButton((String) null, (iv4.e) null);
                    iv4Var.setContentViewSize(6);
                    CustomPrivacyDialogView customPrivacyDialogView = new CustomPrivacyDialogView(context);
                    customPrivacyDialogView.setMessageTextViewMessage(context.getString(R.string.obfuscated_res_0x7f0f1635));
                    customPrivacyDialogView.setMessageTextViewColor(SkinManager.getColor(R.color.CAM_X0107));
                    customPrivacyDialogView.setPrivacyDialogCancelButtonText(context.getString(R.string.obfuscated_res_0x7f0f1633));
                    customPrivacyDialogView.setPrivacyDialogConfirmButtonText(context.getString(R.string.obfuscated_res_0x7f0f1634));
                    customPrivacyDialogView.setPrivacyDialogCancelButtonListener(new b(this, iVar, iv4Var));
                    customPrivacyDialogView.setPrivacyDialogConfirmButtonListener(new c(this, iVar, iv4Var));
                    iv4Var.setContentView(customPrivacyDialogView);
                    iv4Var.create(tbPageContextSupport.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem("c13804"));
                }
            } else if (iVar != null) {
                iVar.a(true);
            }
        }
    }

    @Override // com.baidu.tieba.q65
    public void K(e65 e65Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e65Var) == null) && (editorTools = this.d) != null) {
            editorTools.A(e65Var);
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i2) == null) && "2".equals(this.g)) {
            x(i2);
        }
    }

    @Override // com.baidu.tieba.q65
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, editorTools) == null) {
            this.d = editorTools;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.h = str;
        }
    }

    @Override // com.baidu.tieba.q65
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.e = i2;
        }
    }

    public void v(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048600, this, z) == null) && (tBSpecificationBtn = this.b) != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            tBSpecificationBtn.setVisibility(i2);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    public void p(String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048591, this, str, i2) == null) && "2".equals(this.g)) {
            this.i = str;
            b49.a(str, i2, new g(this));
        }
    }

    @Override // com.baidu.tieba.f65
    public void B(e65 e65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, e65Var) != null) || e65Var == null) {
            return;
        }
        int i2 = e65Var.a;
        if (i2 != 54) {
            if (i2 != 57) {
                if (i2 == 65) {
                    K(new e65(66, -1, Boolean.valueOf(u())));
                    return;
                }
                return;
            }
            K(new e65(58, -1, Boolean.FALSE));
            return;
        }
        K(new e65(55, -1, Boolean.valueOf(t())));
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            LinearLayout linearLayout = new LinearLayout(context);
            this.k = linearLayout;
            linearLayout.setGravity(3);
            addView(this.k, layoutParams);
            HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
            this.m = horizontalScrollView;
            horizontalScrollView.setHorizontalFadingEdgeEnabled(true);
            this.m.setHorizontalScrollBarEnabled(false);
            this.k.addView(this.m);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            LinearLayout linearLayout2 = new LinearLayout(context);
            this.l = linearLayout2;
            this.m.addView(linearLayout2, layoutParams2);
        }
    }

    public final void x(int i2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.a.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0f7e));
            TBSpecificationButtonConfig styleConfig = this.a.getStyleConfig();
            if (i2 == 0) {
                i3 = R.drawable.obfuscated_res_0x7f0809cf;
            } else {
                i3 = R.drawable.obfuscated_res_0x7f0809ce;
            }
            styleConfig.i(i3, 0, TBSpecificationButtonConfig.IconType.WEBP);
            TBSpecificationButtonConfig styleConfig2 = this.a.getStyleConfig();
            if (i2 == 0) {
                i4 = R.color.CAM_X0302;
            } else {
                i4 = R.color.CAM_X0110;
            }
            styleConfig2.h(i4);
            this.a.a = Integer.valueOf(i2);
        }
    }

    public final void y(boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.c.setText(getResources().getString(R.string.obfuscated_res_0x7f0f11cd));
            TBSpecificationButtonConfig styleConfig = this.c.getStyleConfig();
            if (z) {
                i2 = R.drawable.obfuscated_res_0x7f0809cf;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f0809ce;
            }
            styleConfig.i(i2, 0, TBSpecificationButtonConfig.IconType.WEBP);
            TBSpecificationButtonConfig styleConfig2 = this.c.getStyleConfig();
            if (z) {
                i3 = R.color.CAM_X0302;
            } else {
                i3 = R.color.CAM_X0110;
            }
            styleConfig2.h(i3);
            this.c.a = Boolean.valueOf(z);
        }
    }

    @Override // com.baidu.tieba.q65
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f) {
                this.f = false;
            }
            setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.q65
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.q65
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            i();
            setVisibility(8);
        }
    }

    public void k() {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (tBSpecificationBtn = this.c) != null) {
            tBSpecificationBtn.setVisibility(8);
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            TBSpecificationBtn tBSpecificationBtn2 = this.a;
            if ((tBSpecificationBtn2 != null && ((Integer) tBSpecificationBtn2.a).intValue() == 0) || (tBSpecificationBtn = this.a) == null || ((Integer) tBSpecificationBtn.a).intValue() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
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

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            this.n = new View(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds1), UtilHelper.getDimenPixelSize(R.dimen.tbds42));
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds26);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds12);
            layoutParams.gravity = 16;
            addView(this.n, layoutParams);
            CommunityConventionView communityConventionView = new CommunityConventionView(context);
            this.j = communityConventionView;
            communityConventionView.setOnClickListener(new a(this));
            this.j.setId(R.id.obfuscated_res_0x7f09089f);
            addView(this.j, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, xi.g(getContext(), R.dimen.tbds62));
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            jz4 jz4Var = new jz4();
            jz4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            jz4Var.h(R.color.CAM_X0110);
            jz4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            jz4Var.m(xi.g(getContext(), R.dimen.M_W_X004), xi.g(getContext(), R.dimen.M_W_X004));
            jz4Var.n(xi.g(getContext(), R.dimen.M_H_X002));
            jz4Var.i(R.drawable.obfuscated_res_0x7f08061d, 0, TBSpecificationButtonConfig.IconType.WEBP);
            jz4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.b = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(jz4Var);
            this.b.setTextSize(R.dimen.T_X09);
            this.b.setText(getContext().getString(R.string.obfuscated_res_0x7f0f054e));
            this.b.setOnClickListener(new d(this));
            this.l.addView(this.b, layoutParams);
        }
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, xi.g(getContext(), R.dimen.tbds62));
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            jz4 jz4Var = new jz4();
            jz4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            jz4Var.h(R.color.CAM_X0302);
            jz4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            jz4Var.m(xi.g(getContext(), R.dimen.M_W_X004), xi.g(getContext(), R.dimen.M_W_X004));
            jz4Var.n(xi.g(getContext(), R.dimen.M_H_X002));
            jz4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.a = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(jz4Var);
            this.a.setTextSize(R.dimen.T_X09);
            x(0);
            this.a.setLayoutParams(layoutParams);
            this.a.setOnClickListener(new e(this, context));
            this.l.addView(this.a);
        }
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, context) != null) || !ProfileVirtualImageInfo.getInstance().isDisplayVirtual()) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, xi.g(getContext(), R.dimen.tbds62));
        jz4 jz4Var = new jz4();
        jz4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
        jz4Var.h(R.color.CAM_X0302);
        jz4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        jz4Var.m(xi.g(getContext(), R.dimen.M_W_X004), xi.g(getContext(), R.dimen.M_W_X004));
        jz4Var.n(xi.g(getContext(), R.dimen.M_H_X002));
        jz4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
        this.c = tBSpecificationBtn;
        tBSpecificationBtn.setConfig(jz4Var);
        this.c.setTextSize(R.dimen.T_X09);
        this.c.setLayoutParams(layoutParams);
        this.c.setOnClickListener(new f(this));
        this.l.addView(this.c);
        ky4 k = ky4.k();
        y(k.h("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), true));
    }

    @Override // com.baidu.tieba.q65
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            kw4.d(this.n).f(R.color.CAM_X0401);
            TBSpecificationBtn tBSpecificationBtn = this.a;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.b;
            if (tBSpecificationBtn2 != null) {
                tBSpecificationBtn2.k();
            }
            CommunityConventionView communityConventionView = this.j;
            if (communityConventionView != null) {
                communityConventionView.onChangeSkinType(i2);
            }
            TBSpecificationBtn tBSpecificationBtn3 = this.c;
            if (tBSpecificationBtn3 != null) {
                tBSpecificationBtn3.k();
            }
        }
    }
}
