package com.baidu.tieba;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.forumMember.member.ManagerApplyViewHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jg7 extends fi7<kg7, ManagerApplyViewHolder> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: n */
    public static final int obfuscated = 2131296987;
    public transient /* synthetic */ FieldHolder $fh;
    public qg5 l;
    public View.OnClickListener m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947882415, "Lcom/baidu/tieba/jg7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947882415, "Lcom/baidu/tieba/jg7;");
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jg7 a;

        public a(jg7 jg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jg7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Object tag = view2.getTag(jg7.obfuscated);
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) m9.a(this.a.mContext), new String[]{tag.toString()});
                } else {
                    this.a.L(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jg7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = new a(this);
    }

    public void onDestroy() {
        qg5 qg5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (qg5Var = this.l) != null) {
            qg5Var.s();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: J */
    public ManagerApplyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            return new ManagerApplyViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0390, (ViewGroup) null));
        }
        return (ManagerApplyViewHolder) invokeL.objValue;
    }

    public View K(int i, View view2, ViewGroup viewGroup, kg7 kg7Var, ManagerApplyViewHolder managerApplyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, kg7Var, managerApplyViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) kg7Var, (kg7) managerApplyViewHolder);
            if (kg7Var != null && !kg7Var.c() && managerApplyViewHolder != null) {
                if (kg7Var.c()) {
                    managerApplyViewHolder.d.setVisibility(8);
                    return view2;
                }
                if (managerApplyViewHolder.e != this.f) {
                    SkinManager.setViewTextColor(managerApplyViewHolder.b, R.color.CAM_X0109, 1);
                    SkinManager.setViewTextColor(managerApplyViewHolder.a, R.color.CAM_X0105, 1);
                    SkinManager.setBackgroundResource(managerApplyViewHolder.c, R.drawable.frs_member_manito_bg);
                }
                int b = kg7Var.b();
                if (b > 0) {
                    managerApplyViewHolder.b.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), StringHelper.numberUniformFormat(b)));
                    managerApplyViewHolder.c.setTag(obfuscated, kg7Var.a());
                    managerApplyViewHolder.c.setOnClickListener(this.m);
                    managerApplyViewHolder.c.setEnabled(true);
                    managerApplyViewHolder.c.setClickable(true);
                } else {
                    managerApplyViewHolder.b.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
                    managerApplyViewHolder.c.setEnabled(false);
                    managerApplyViewHolder.c.setClickable(false);
                }
                managerApplyViewHolder.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                managerApplyViewHolder.e = this.f;
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void L(AccountData accountData) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
            BdPageContext<?> a2 = m9.a(this.mContext);
            if (a2 instanceof TbPageContext) {
                activity = ((TbPageContext) a2).getPageActivity();
            } else {
                activity = null;
            }
            if (this.l == null) {
                this.l = new qg5(activity);
            }
            this.l.p();
            this.l.u(accountData);
            this.l.z(1);
        }
    }

    @Override // com.baidu.tieba.fi7, com.baidu.tieba.pm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        K(i, view2, viewGroup, (kg7) obj, (ManagerApplyViewHolder) viewHolder);
        return view2;
    }
}
