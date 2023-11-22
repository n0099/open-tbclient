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
import com.baidu.tieba.forumMember.member.PrivateMgrApplyViewHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wn7 extends qp7<xn7, PrivateMgrApplyViewHolder> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: n */
    public static final int obfuscated = 2131303872;
    public transient /* synthetic */ FieldHolder $fh;
    public wb5 l;
    public View.OnClickListener m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948276425, "Lcom/baidu/tieba/wn7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948276425, "Lcom/baidu/tieba/wn7;");
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wn7 a;

        public a(wn7 wn7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wn7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wn7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    this.a.M(TbadkCoreApplication.getCurrentAccountInfo());
                    return;
                }
                Object tag = view2.getTag(wn7.obfuscated);
                if (tag != null && !tag.toString().equals("")) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) a5.a(this.a.mContext), new String[]{tag.toString()});
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wn7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        wb5 wb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (wb5Var = this.l) != null) {
            wb5Var.s();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: K */
    public PrivateMgrApplyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            return new PrivateMgrApplyViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d083d, (ViewGroup) null));
        }
        return (PrivateMgrApplyViewHolder) invokeL.objValue;
    }

    public View L(int i, View view2, ViewGroup viewGroup, xn7 xn7Var, PrivateMgrApplyViewHolder privateMgrApplyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, xn7Var, privateMgrApplyViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) xn7Var, (xn7) privateMgrApplyViewHolder);
            if (xn7Var != null && !xn7Var.d() && privateMgrApplyViewHolder != null) {
                if (xn7Var.d()) {
                    privateMgrApplyViewHolder.e.setVisibility(8);
                    return view2;
                }
                boolean z = true;
                if (privateMgrApplyViewHolder.f != this.f) {
                    SkinManager.setBackgroundColor(privateMgrApplyViewHolder.d, R.color.CAM_X0204);
                    SkinManager.setViewTextColor(privateMgrApplyViewHolder.b, R.color.CAM_X0109, 1);
                    SkinManager.setViewTextColor(privateMgrApplyViewHolder.a, R.color.CAM_X0105, 1);
                    SkinManager.setBackgroundResource(privateMgrApplyViewHolder.c, R.drawable.frs_member_manito_bg);
                }
                int a2 = xn7Var.a();
                String string = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f165f);
                if (a2 == -1) {
                    int c = xn7Var.c();
                    String numberUniformFormat = StringHelper.numberUniformFormat(c);
                    if (c > 0) {
                        string = String.format(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1659), numberUniformFormat);
                        privateMgrApplyViewHolder.c.setOnClickListener(this.m);
                        privateMgrApplyViewHolder.b.setText(string);
                        privateMgrApplyViewHolder.c.setTag(obfuscated, xn7Var.b());
                        privateMgrApplyViewHolder.c.setEnabled(z);
                        privateMgrApplyViewHolder.c.setClickable(z);
                        privateMgrApplyViewHolder.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                        privateMgrApplyViewHolder.f = this.f;
                    }
                    z = false;
                    privateMgrApplyViewHolder.c.setOnClickListener(this.m);
                    privateMgrApplyViewHolder.b.setText(string);
                    privateMgrApplyViewHolder.c.setTag(obfuscated, xn7Var.b());
                    privateMgrApplyViewHolder.c.setEnabled(z);
                    privateMgrApplyViewHolder.c.setClickable(z);
                    privateMgrApplyViewHolder.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    privateMgrApplyViewHolder.f = this.f;
                } else {
                    if (a2 == 0) {
                        string = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f165d);
                    } else if (a2 == 1) {
                        string = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f165b);
                    } else {
                        if (a2 == 2) {
                            string = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f165a);
                        }
                        z = false;
                    }
                    privateMgrApplyViewHolder.c.setOnClickListener(this.m);
                    privateMgrApplyViewHolder.b.setText(string);
                    privateMgrApplyViewHolder.c.setTag(obfuscated, xn7Var.b());
                    privateMgrApplyViewHolder.c.setEnabled(z);
                    privateMgrApplyViewHolder.c.setClickable(z);
                    privateMgrApplyViewHolder.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    privateMgrApplyViewHolder.f = this.f;
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void M(AccountData accountData) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
            BdPageContext<?> a2 = a5.a(this.mContext);
            if (a2 instanceof TbPageContext) {
                activity = ((TbPageContext) a2).getPageActivity();
            } else {
                activity = null;
            }
            if (this.l == null) {
                this.l = new wb5(activity);
            }
            this.l.p();
            this.l.u(accountData);
            this.l.z(1);
        }
    }

    @Override // com.baidu.tieba.qp7, com.baidu.tieba.bi
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        L(i, view2, viewGroup, (xn7) obj, (PrivateMgrApplyViewHolder) viewHolder);
        return view2;
    }
}
