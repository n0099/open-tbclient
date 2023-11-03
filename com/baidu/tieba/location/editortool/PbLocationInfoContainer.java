package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.de5;
import com.baidu.tieba.gu4;
import com.baidu.tieba.le5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.sg5;
import com.baidu.tieba.tbadkCore.util.AICapacityApplyHelper;
import com.baidu.tieba.u55;
import com.baidu.tieba.xd5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.JsonSyntaxException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, le5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBSpecificationBtn a;
    public TBSpecificationBtn b;
    public View c;
    public EditorTools d;
    public int e;
    public boolean f;
    public String g;
    public gu4.d h;

    @Override // com.baidu.tieba.le5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements gu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbLocationInfoContainer a;

        @Override // com.baidu.tieba.gu4.d
        @NonNull
        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ai.applyCapability" : (String) invokeV.objValue;
        }

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

        @Override // com.baidu.tieba.gu4.c
        public void a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    boolean z = true;
                    if (jSONObject.optInt("status") != 1) {
                        z = false;
                    }
                    this.a.h(z, jSONObject.optString("toastText"));
                } catch (JSONException e) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e("ai.applyCapability", "JSONException:" + e.getMessage());
                    if (!TbadkApplication.getInst().isDebugMode()) {
                        return;
                    }
                    throw new JsonSyntaxException("NotifyDataChanged.applyCapability端能力json解析失败 " + e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
                boolean z = !((Boolean) this.a.a.a).booleanValue();
                SharedPrefHelper.getInstance().putBoolean("key_virtual_image_and_state_has_show", z);
                this.a.q(z);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                de5.d(view2);
                StatisticItem addParam = new StatisticItem("c15295").param("obj_source", "2").param("obj_type", "2").addParam("fid", this.a.d.getFid()).addParam("uid", TbadkCoreApplication.getCurrentAccount());
                if (!TextUtils.isEmpty(this.a.g) && !"0".equals(this.a.g)) {
                    addParam.addParam("fid", this.a.g);
                } else if (this.a.d != null && this.a.d.getFid() != 0) {
                    addParam.addParam("fid", String.valueOf(this.a.d.getFid()));
                }
                TiebaStatic.log(addParam);
                if (AICapacityApplyHelper.c().b()) {
                    this.a.g0(new xd5(77, -1, null));
                } else {
                    AICapacityApplyHelper.c().d(AICapacityApplyHelper.capacityApplyType.AI_WRITE_REPLY);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbLocationInfoContainer a;

        public d(PbLocationInfoContainer pbLocationInfoContainer) {
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
                SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reply_add_bless_enable"), z);
                this.a.p(z);
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
        this.h = new a(this);
        n();
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, context) != null) || !sg5.a()) {
            return;
        }
        this.b = k(context);
        p(SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reply_add_bless_enable"), true));
        this.b.setOnClickListener(new d(this));
        addView(this.b);
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, context) != null) || !ProfileVirtualImageInfo.getInstance().isDisplayVirtual()) {
            return;
        }
        this.a = k(context);
        q(SharedPrefHelper.getInstance().getBoolean("key_virtual_image_and_state_has_show", true));
        this.a.setOnClickListener(new b(this));
        addView(this.a);
    }

    @Override // com.baidu.tieba.le5
    public void g0(xd5 xd5Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xd5Var) == null) && (editorTools = this.d) != null) {
            editorTools.K(xd5Var);
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            FrameLayout a2 = de5.a(context);
            this.c = a2;
            a2.setOnClickListener(new c(this));
            this.c.setVisibility(8);
            addView(this.c);
        }
    }

    @Override // com.baidu.tieba.le5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            i(i);
        }
    }

    @Override // com.baidu.tieba.le5
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, editorTools) == null) {
            this.d = editorTools;
        }
    }

    @Override // com.baidu.tieba.le5
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.e = i;
        }
    }

    public final void h(boolean z, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) {
            if (z) {
                AICapacityApplyHelper.c().k(true);
            } else {
                AICapacityApplyHelper.c().j(str);
            }
        }
    }

    @Override // com.baidu.tieba.yd5
    public void S(xd5 xd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, xd5Var) != null) || xd5Var == null) {
            return;
        }
        if (xd5Var.a == 68) {
            SharedPrefHelper.getInstance().putBoolean("key_virtual_image_and_state_has_show", false);
            q(false);
        }
        if (xd5Var.a == 76 && this.c != null) {
            Object obj = xd5Var.c;
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

    @Override // com.baidu.tieba.le5
    public void display() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f) {
            this.f = false;
            gu4.a().c(this.h);
        }
    }

    @Override // com.baidu.tieba.le5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.le5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            gu4.a().e(this.h);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            setGravity(16);
            setOrientation(0);
            l(getContext());
            m(getContext());
            o(getContext());
        }
    }

    public void i(int i) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || (tBSpecificationBtn = this.a) == null) {
            return;
        }
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.getStyleConfig().l(SkinManager.getColor(R.color.CAM_X0105));
            this.a.getStyleConfig().i(sg5.b(((Boolean) this.a.a).booleanValue()));
            this.a.l(i);
        }
        TBSpecificationBtn tBSpecificationBtn2 = this.b;
        if (tBSpecificationBtn2 != null) {
            tBSpecificationBtn2.getStyleConfig().l(SkinManager.getColor(R.color.CAM_X0105));
            this.b.getStyleConfig().i(sg5.b(((Boolean) this.b.a).booleanValue()));
            this.b.l(i);
        }
        View view2 = this.c;
        if (view2 != null) {
            EMManager.from(view2).setBorderWidth(R.dimen.L_X02).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0209);
        }
    }

    public final TBSpecificationBtn k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            u55 u55Var = new u55();
            u55Var.s(R.color.CAM_X0209, SkinManager.getColor(R.color.CAM_X0105));
            u55Var.y(false);
            u55Var.i(sg5.b(true));
            u55Var.g(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            u55Var.o(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004), BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004));
            u55Var.p(BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X002));
            u55Var.h(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            tBSpecificationBtn.setConfig(u55Var);
            tBSpecificationBtn.setTextSize(R.dimen.T_X09);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, BdUtilHelper.getDimens(getContext(), R.dimen.tbds63));
            layoutParams.rightMargin = BdUtilHelper.getDimens(context, R.dimen.M_W_X007);
            tBSpecificationBtn.setLayoutParams(layoutParams);
            return tBSpecificationBtn;
        }
        return (TBSpecificationBtn) invokeL.objValue;
    }

    public final void p(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && (tBSpecificationBtn = this.b) != null) {
            tBSpecificationBtn.setText(BdBaseApplication.getInst().getResources().getString(R.string.show_spring_festival));
            TBSpecificationButtonConfig styleConfig = this.b.getStyleConfig();
            if (z) {
                i = R.drawable.icon_pure_post_chosen12;
            } else {
                i = R.drawable.icon_pure_post_chose12;
            }
            styleConfig.j(i, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.b.getStyleConfig().i(sg5.b(z));
            this.b.a = Boolean.valueOf(z);
        }
    }

    public final void q(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
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
                this.a.getStyleConfig().i(sg5.b(z));
                this.a.a = Boolean.valueOf(z);
            }
            g0(new xd5(67, -1, Boolean.valueOf(z)));
        }
    }
}
