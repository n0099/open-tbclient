package com.baidu.tieba.write.editor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.b0b;
import com.baidu.tieba.fj5;
import com.baidu.tieba.hz4;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.oa5;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.si5;
import com.baidu.tieba.tbadkCore.util.AICapacityApplyHelper;
import com.baidu.tieba.vk5;
import com.baidu.tieba.write.view.CustomPrivacyDialogView;
import com.baidu.tieba.x3b;
import com.baidu.tieba.xi5;
import com.baidu.tieba.y45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.JsonSyntaxException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class EditorInfoContainer extends LinearLayout implements fj5 {
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
    public hz4.d o;
    public CustomMessageListener p;

    /* loaded from: classes8.dex */
    public interface k {
        void onChange(boolean z);
    }

    @Override // com.baidu.tieba.fj5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ EditorInfoContainer b;

        /* loaded from: classes8.dex */
        public class a implements k {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // com.baidu.tieba.write.editor.EditorInfoContainer.k
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
                        this.a.b.E(i);
                        if ("2".equals(this.a.b.i)) {
                            b0b.b(this.a.b.k, i);
                        }
                    }
                }
            }
        }

        public g(EditorInfoContainer editorInfoContainer, Context context) {
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
                if (((Integer) this.b.a.a).intValue() == 0) {
                    i = 11;
                } else {
                    i = 12;
                }
                x3b.b(this.a, i);
                EditorInfoContainer editorInfoContainer = this.b;
                editorInfoContainer.D(this.a, ((Integer) editorInfoContainer.a.a).intValue(), new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EditorInfoContainer editorInfoContainer, int i) {
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
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                this.a.H(sharedPrefHelper.getBoolean("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), true));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements hz4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        @Override // com.baidu.tieba.hz4.d
        @NonNull
        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ai.applyCapability" : (String) invokeV.objValue;
        }

        public b(EditorInfoContainer editorInfoContainer) {
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

        @Override // com.baidu.tieba.hz4.c
        public void a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    boolean z = true;
                    if (jSONObject.optInt("status") != 1) {
                        z = false;
                    }
                    this.a.m(z, jSONObject.optString("toastText"));
                } catch (JSONException e) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e("ai.applyCapability", "JSONException:" + e.getMessage());
                    if (!TbadkApplication.getInst().isDebugMode()) {
                        return;
                    }
                    throw new JsonSyntaxException("NotifyDataChanged.applyCapability端能力json解析异常 " + e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;
        public final /* synthetic */ y45 b;
        public final /* synthetic */ EditorInfoContainer c;

        public c(EditorInfoContainer editorInfoContainer, k kVar, y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, kVar, y45Var};
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
            this.a = kVar;
            this.b = y45Var;
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
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;
        public final /* synthetic */ y45 b;
        public final /* synthetic */ EditorInfoContainer c;

        public d(EditorInfoContainer editorInfoContainer, k kVar, y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, kVar, y45Var};
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
            this.a = kVar;
            this.b = y45Var;
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
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        public e(EditorInfoContainer editorInfoContainer) {
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
                xi5.d(view2);
                StatisticItem addParam = new StatisticItem("c15295").param("obj_source", "1").param("obj_type", "2").addParam("uid", TbadkCoreApplication.getCurrentAccount());
                if (!TextUtils.isEmpty(this.a.k) && !"0".equals(this.a.k)) {
                    addParam.addParam("fid", this.a.k);
                } else if (this.a.f != null && this.a.f.getFid() != 0) {
                    addParam.addParam("fid", String.valueOf(this.a.f.getFid()));
                }
                TiebaStatic.log(addParam);
                if (AICapacityApplyHelper.c().b()) {
                    this.a.U(new si5(77, -1, null));
                } else {
                    AICapacityApplyHelper.c().d(AICapacityApplyHelper.capacityApplyType.AI_WRITE_POST);
                }
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
                this.a.U(new si5(43, -1, null));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = !((Boolean) this.a.c.a).booleanValue();
                this.a.H(z);
                SharedPrefHelper.getInstance().putBoolean("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), z);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        public i(EditorInfoContainer editorInfoContainer) {
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
                this.a.F(z);
                SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_write_add_bless_enable"), z);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements b0b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        public j(EditorInfoContainer editorInfoContainer) {
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

        @Override // com.baidu.tieba.b0b.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.E(i);
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
        this.o = new b(this);
        this.p = new a(this, 2921756);
        this.i = str;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(0, (int) context.getResources().getDimension(R.dimen.M_H_X004), 0, (int) context.getResources().getDimension(R.dimen.M_H_X003));
        setGravity(16);
        setOrientation(0);
        t(context);
        s(context);
        u(context);
        y(context);
        v(context);
        z(context);
        if (context instanceof BdBaseFragmentActivity) {
            ((BdBaseFragmentActivity) context).registerListener(this.p);
        }
    }

    public final void D(Context context, int i2, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, context, i2, kVar) == null) {
            boolean z = SharedPrefHelper.getInstance().getBoolean("show_privacy_dialog", false);
            if (i2 != 1 && !z) {
                SharedPrefHelper.getInstance().putBoolean("show_privacy_dialog", true);
                TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) context;
                if (tbPageContextSupport != null && tbPageContextSupport.getPageContext() != null && tbPageContextSupport.getPageContext().getPageActivity() != null) {
                    y45 y45Var = new y45(tbPageContextSupport.getPageContext().getPageActivity());
                    y45Var.setCancelable(false);
                    y45Var.setPositiveButton((String) null, (y45.e) null);
                    y45Var.setNegativeButton((String) null, (y45.e) null);
                    y45Var.setContentViewSize(6);
                    CustomPrivacyDialogView customPrivacyDialogView = new CustomPrivacyDialogView(context);
                    customPrivacyDialogView.setMessageTextViewMessage(context.getString(R.string.obfuscated_res_0x7f0f18ee));
                    customPrivacyDialogView.setMessageTextViewColor(SkinManager.getColor(R.color.CAM_X0107));
                    customPrivacyDialogView.setPrivacyDialogCancelButtonText(context.getString(R.string.obfuscated_res_0x7f0f18ec));
                    customPrivacyDialogView.setPrivacyDialogConfirmButtonText(context.getString(R.string.obfuscated_res_0x7f0f18ed));
                    customPrivacyDialogView.setPrivacyDialogCancelButtonListener(new c(this, kVar, y45Var));
                    customPrivacyDialogView.setPrivacyDialogConfirmButtonListener(new d(this, kVar, y45Var));
                    y45Var.setContentView(customPrivacyDialogView);
                    y45Var.create(tbPageContextSupport.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem("c13804"));
                }
            } else if (kVar != null) {
                kVar.onChange(true);
            }
        }
    }

    public void C(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && (tBSpecificationBtn = this.b) != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            tBSpecificationBtn.setVisibility(i2);
        }
    }

    @Override // com.baidu.tieba.fj5
    public void U(si5 si5Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, si5Var) == null) && (editorTools = this.f) != null) {
            editorTools.D(si5Var);
        }
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, context) == null) {
            FrameLayout a2 = xi5.a(context);
            this.e = a2;
            a2.setOnClickListener(new e(this));
            this.e.setVisibility(8);
            this.m.addView(this.e);
        }
    }

    @Override // com.baidu.tieba.fj5
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, editorTools) == null) {
            this.f = editorTools;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.j = str;
        }
    }

    @Override // com.baidu.tieba.fj5
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.g = i2;
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048605, this, i2) == null) && "2".equals(this.i)) {
            E(i2);
        }
    }

    public final void m(boolean z, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z, str) == null) {
            if (z) {
                AICapacityApplyHelper.c().k(true);
            } else {
                AICapacityApplyHelper.c().j(str);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    public void w(String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048604, this, str, i2) == null) && "2".equals(this.i)) {
            this.k = str;
            b0b.a(str, i2, new j(this));
        }
    }

    public boolean A() {
        InterceptResult invokeV;
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            TBSpecificationBtn tBSpecificationBtn2 = this.a;
            if ((tBSpecificationBtn2 != null && ((Integer) tBSpecificationBtn2.a).intValue() == 0) || (tBSpecificationBtn = this.a) == null || ((Integer) tBSpecificationBtn.a).intValue() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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

    @Override // com.baidu.tieba.fj5
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.h) {
                this.h = false;
            }
            setVisibility(0);
            hz4.a().c(this.o);
        }
    }

    @Override // com.baidu.tieba.fj5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.fj5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            p();
            setVisibility(8);
            hz4.a().e(this.o);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            hz4.a().e(this.o);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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

    public final void E(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.a.setText(getResources().getString(R.string.obfuscated_res_0x7f0f118a));
            TBSpecificationButtonConfig styleConfig = this.a.getStyleConfig();
            if (i2 == 0) {
                i3 = R.drawable.icon_pure_post_chosen12;
            } else {
                i3 = R.drawable.icon_pure_post_chose12;
            }
            boolean z = false;
            styleConfig.j(i3, 0, TBSpecificationButtonConfig.IconType.WEBP);
            TBSpecificationButtonConfig styleConfig2 = this.a.getStyleConfig();
            if (i2 == 0) {
                z = true;
            }
            styleConfig2.i(vk5.b(z));
            this.a.a = Integer.valueOf(i2);
        }
    }

    public final void F(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.d.setText(getResources().getString(R.string.show_spring_festival));
            TBSpecificationButtonConfig styleConfig = this.d.getStyleConfig();
            if (z) {
                i2 = R.drawable.icon_pure_post_chosen12;
            } else {
                i2 = R.drawable.icon_pure_post_chose12;
            }
            styleConfig.j(i2, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.d.getStyleConfig().i(vk5.b(z));
            this.d.a = Boolean.valueOf(z);
        }
    }

    public final void H(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.c.setText(getResources().getString(R.string.obfuscated_res_0x7f0f13f8));
            TBSpecificationButtonConfig styleConfig = this.c.getStyleConfig();
            if (z) {
                i2 = R.drawable.icon_pure_post_chosen12;
            } else {
                i2 = R.drawable.icon_pure_post_chose12;
            }
            styleConfig.j(i2, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.c.getStyleConfig().i(vk5.b(z));
            this.c.a = Boolean.valueOf(z);
        }
    }

    public final void t(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, context) == null) {
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

    public final void z(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048607, this, context) != null) || !ProfileVirtualImageInfo.getInstance().isDisplayVirtual()) {
            return;
        }
        TBSpecificationBtn n = n(context);
        this.c = n;
        n.setOnClickListener(new h(this));
        this.m.addView(this.c);
        SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
        H(sharedPrefHelper.getBoolean("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), true));
    }

    @Override // com.baidu.tieba.ti5
    public void G(si5 si5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, si5Var) != null) || si5Var == null) {
            return;
        }
        int i2 = si5Var.a;
        if (i2 != 54) {
            if (i2 != 57) {
                if (i2 != 65) {
                    if (i2 == 76) {
                        Object obj = si5Var.c;
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
                U(new si5(66, -1, Boolean.valueOf(B())));
                return;
            }
            U(new si5(58, -1, Boolean.FALSE));
            return;
        }
        U(new si5(55, -1, Boolean.valueOf(A())));
    }

    public final TBSpecificationBtn n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, BdUtilHelper.getDimens(getContext(), R.dimen.tbds62));
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            oa5 oa5Var = new oa5();
            oa5Var.s(R.color.CAM_X0209, SkinManager.getColor(R.color.CAM_X0105));
            oa5Var.z(false);
            oa5Var.i(vk5.b(true));
            oa5Var.g(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            oa5Var.o(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004), BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004));
            oa5Var.p(BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X002));
            oa5Var.h(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            tBSpecificationBtn.setConfig(oa5Var);
            tBSpecificationBtn.setTextSize(R.dimen.T_X09);
            tBSpecificationBtn.setLayoutParams(layoutParams);
            return tBSpecificationBtn;
        }
        return (TBSpecificationBtn) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fj5
    public void onChangeSkinType(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.a;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.getStyleConfig().l(SkinManager.getColor(R.color.CAM_X0105));
                TBSpecificationButtonConfig styleConfig = this.a.getStyleConfig();
                if (((Integer) this.a.a).intValue() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                styleConfig.i(vk5.b(z));
                this.a.k();
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.b;
            if (tBSpecificationBtn2 != null) {
                tBSpecificationBtn2.k();
            }
            TBSpecificationBtn tBSpecificationBtn3 = this.c;
            if (tBSpecificationBtn3 != null) {
                tBSpecificationBtn3.getStyleConfig().l(SkinManager.getColor(R.color.CAM_X0105));
                this.c.getStyleConfig().i(vk5.b(((Boolean) this.c.a).booleanValue()));
                this.c.k();
            }
            TBSpecificationBtn tBSpecificationBtn4 = this.d;
            if (tBSpecificationBtn4 != null) {
                tBSpecificationBtn4.getStyleConfig().l(SkinManager.getColor(R.color.CAM_X0105));
                this.d.getStyleConfig().i(vk5.b(((Boolean) this.d.a).booleanValue()));
                this.d.k();
            }
            View view2 = this.e;
            if (view2 != null) {
                EMManager.from(view2).setBorderWidth(R.dimen.L_X02).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0209);
            }
        }
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, context) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, BdUtilHelper.getDimens(getContext(), R.dimen.tbds62));
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            oa5 oa5Var = new oa5();
            oa5Var.s(R.color.CAM_X0209, R.color.CAM_X0105);
            oa5Var.i(R.color.CAM_X0110);
            oa5Var.g(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            oa5Var.o(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004), BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004));
            oa5Var.p(BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X002));
            oa5Var.j(R.drawable.ic_icon_pure_post_topic12, 0, TBSpecificationButtonConfig.IconType.WEBP);
            oa5Var.h(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.b = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(oa5Var);
            this.b.setTextSize(R.dimen.T_X09);
            this.b.setText(getContext().getString(R.string.editor_hot_tipc));
            this.b.setOnClickListener(new f(this));
            this.m.addView(this.b, layoutParams);
        }
    }

    public final void v(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, context) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, BdUtilHelper.getDimens(getContext(), R.dimen.tbds62));
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            oa5 oa5Var = new oa5();
            oa5Var.s(R.color.CAM_X0209, SkinManager.getColor(R.color.CAM_X0105));
            oa5Var.z(false);
            oa5Var.i(vk5.b(true));
            oa5Var.g(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            oa5Var.o(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004), BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004));
            oa5Var.p(BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X002));
            oa5Var.h(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.a = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(oa5Var);
            this.a.setTextSize(R.dimen.T_X09);
            E(0);
            this.a.setLayoutParams(layoutParams);
            this.a.setOnClickListener(new g(this, context));
            this.m.addView(this.a);
        }
    }

    public final void y(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048606, this, context) != null) || !vk5.a()) {
            return;
        }
        TBSpecificationBtn n = n(context);
        this.d = n;
        n.setOnClickListener(new i(this));
        this.m.addView(this.d);
        F(SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_write_add_bless_enable"), true));
    }
}
