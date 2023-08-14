package com.baidu.tieba.memberCenter.memberpayresult;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MemberPayPrivilegeResultActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.databinding.MemberPayPrivilegeResultActivityBinding;
import com.baidu.tieba.i59;
import com.baidu.tieba.memberCenter.memberpayresult.MemberPayPrivilegeResultActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/tieba/memberCenter/memberpayresult/MemberPayPrivilegeResultActivity;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "()V", "binding", "Lcom/baidu/tieba/databinding/MemberPayPrivilegeResultActivityBinding;", "onChangeSkinType", "", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "overridePendingTransition", "enterAnim", "exitAnim", "memberCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MemberPayPrivilegeResultActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MemberPayPrivilegeResultActivityBinding a;

    public MemberPayPrivilegeResultActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final void s1(MemberPayPrivilegeResultActivity this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setResult(-1, new Intent());
            this$0.finish();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            super.overridePendingTransition(R.anim.anim_alpha_0_to_1_duration_300, R.anim.anim_alpha_1_to_0_duration_300);
        }
    }

    public static final void t1(MemberPayPrivilegeResultActivity this$0, Ref.ObjectRef memberBuyButtonUrl, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, this$0, memberBuyButtonUrl, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(memberBuyButtonUrl, "$memberBuyButtonUrl");
            UrlManager.getInstance().dealOneLink(this$0.getPageContext(), new String[]{(String) memberBuyButtonUrl.element});
            i59.a.a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            MemberPayPrivilegeResultActivityBinding memberPayPrivilegeResultActivityBinding = this.a;
            MemberPayPrivilegeResultActivityBinding memberPayPrivilegeResultActivityBinding2 = null;
            if (memberPayPrivilegeResultActivityBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                memberPayPrivilegeResultActivityBinding = null;
            }
            EMManager.from(memberPayPrivilegeResultActivityBinding.m).setTextColor(R.color.CAM_X0311).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X02);
            MemberPayPrivilegeResultActivityBinding memberPayPrivilegeResultActivityBinding3 = this.a;
            if (memberPayPrivilegeResultActivityBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                memberPayPrivilegeResultActivityBinding3 = null;
            }
            WebPManager.setPureDrawable(memberPayPrivilegeResultActivityBinding3.b, R.drawable.icon_pure_vip_ad_free_guide_del, R.color.CAM_X0626, null);
            MemberPayPrivilegeResultActivityBinding memberPayPrivilegeResultActivityBinding4 = this.a;
            if (memberPayPrivilegeResultActivityBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                memberPayPrivilegeResultActivityBinding4 = null;
            }
            SkinManager.setImageResource(memberPayPrivilegeResultActivityBinding4.h, R.drawable.obfuscated_res_0x7f0810a7);
            MemberPayPrivilegeResultActivityBinding memberPayPrivilegeResultActivityBinding5 = this.a;
            if (memberPayPrivilegeResultActivityBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                memberPayPrivilegeResultActivityBinding5 = null;
            }
            SkinManager.setImageResource(memberPayPrivilegeResultActivityBinding5.i, R.drawable.obfuscated_res_0x7f08156a);
            MemberPayPrivilegeResultActivityBinding memberPayPrivilegeResultActivityBinding6 = this.a;
            if (memberPayPrivilegeResultActivityBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                memberPayPrivilegeResultActivityBinding6 = null;
            }
            SkinManager.setImageResource(memberPayPrivilegeResultActivityBinding6.j, R.drawable.obfuscated_res_0x7f080cc4, i);
            MemberPayPrivilegeResultActivityBinding memberPayPrivilegeResultActivityBinding7 = this.a;
            if (memberPayPrivilegeResultActivityBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                memberPayPrivilegeResultActivityBinding7 = null;
            }
            SkinManager.setImageResource(memberPayPrivilegeResultActivityBinding7.d, R.drawable.obfuscated_res_0x7f0809ca, i);
            MemberPayPrivilegeResultActivityBinding memberPayPrivilegeResultActivityBinding8 = this.a;
            if (memberPayPrivilegeResultActivityBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                memberPayPrivilegeResultActivityBinding8 = null;
            }
            SkinManager.setImageResource(memberPayPrivilegeResultActivityBinding8.c, R.drawable.obfuscated_res_0x7f0809cb, i);
            MemberPayPrivilegeResultActivityBinding memberPayPrivilegeResultActivityBinding9 = this.a;
            if (memberPayPrivilegeResultActivityBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                memberPayPrivilegeResultActivityBinding2 = memberPayPrivilegeResultActivityBinding9;
            }
            EMManager.from(memberPayPrivilegeResultActivityBinding2.f).setGradientColor(new int[]{R.color.CAM_X0201, R.color.CAM_X0202}, Direction.TOP);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v24, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r0v26, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r0v27, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            MemberPayPrivilegeResultActivityBinding c = MemberPayPrivilegeResultActivityBinding.c(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(c, "inflate(layoutInflater)");
            this.a = c;
            MemberPayPrivilegeResultActivityBinding memberPayPrivilegeResultActivityBinding = null;
            if (c == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                c = null;
            }
            setContentView(c.getRoot());
            float dimens = BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.tbds43);
            MemberPayPrivilegeResultActivityBinding memberPayPrivilegeResultActivityBinding2 = this.a;
            if (memberPayPrivilegeResultActivityBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                memberPayPrivilegeResultActivityBinding2 = null;
            }
            memberPayPrivilegeResultActivityBinding2.e.setRoundLayoutRadius(new float[]{dimens, dimens, dimens, dimens, 0.0f, 0.0f, 0.0f, 0.0f});
            MemberPayPrivilegeResultActivityBinding memberPayPrivilegeResultActivityBinding3 = this.a;
            if (memberPayPrivilegeResultActivityBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                memberPayPrivilegeResultActivityBinding3 = null;
            }
            memberPayPrivilegeResultActivityBinding3.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g59
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        MemberPayPrivilegeResultActivity.s1(MemberPayPrivilegeResultActivity.this, view2);
                    }
                }
            });
            MemberPayPrivilegeResultActivityBinding memberPayPrivilegeResultActivityBinding4 = this.a;
            if (memberPayPrivilegeResultActivityBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                memberPayPrivilegeResultActivityBinding4 = null;
            }
            memberPayPrivilegeResultActivityBinding4.d.setUseNightOrDarkMask(true);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            String str4 = "";
            objectRef.element = "";
            if (getIntent() == null) {
                str = "";
                str2 = str4;
            } else {
                String stringExtra = getIntent().getStringExtra(MemberPayPrivilegeResultActivityConfig.MEMBER_PAY_PRIVILEGE_RESULT_TEXT);
                if (stringExtra == null) {
                    str3 = "";
                } else {
                    str3 = stringExtra;
                }
                String replace$default = StringsKt__StringsJVMKt.replace$default(str3, "\\n", "\n", false, 4, (Object) null);
                str = getIntent().getStringExtra(MemberPayPrivilegeResultActivityConfig.MEMBER_PAY_PRIVILEGE_RESULT_LINK_TEXT);
                if (str == null) {
                    str = "";
                }
                String stringExtra2 = getIntent().getStringExtra(MemberPayPrivilegeResultActivityConfig.MEMBER_PAY_PRIVILEGE_RESULT_LINK_URL);
                T t = str4;
                if (stringExtra2 != null) {
                    t = stringExtra2;
                }
                objectRef.element = t;
                str2 = replace$default;
            }
            MemberPayPrivilegeResultActivityBinding memberPayPrivilegeResultActivityBinding5 = this.a;
            if (memberPayPrivilegeResultActivityBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                memberPayPrivilegeResultActivityBinding5 = null;
            }
            memberPayPrivilegeResultActivityBinding5.l.setText(str2);
            MemberPayPrivilegeResultActivityBinding memberPayPrivilegeResultActivityBinding6 = this.a;
            if (memberPayPrivilegeResultActivityBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                memberPayPrivilegeResultActivityBinding6 = null;
            }
            EMManager.from(memberPayPrivilegeResultActivityBinding6.l).setTextSize(R.dimen.T_X08).setTextLinePadding(R.dimen.M_H_X004);
            MemberPayPrivilegeResultActivityBinding memberPayPrivilegeResultActivityBinding7 = this.a;
            if (memberPayPrivilegeResultActivityBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                memberPayPrivilegeResultActivityBinding7 = null;
            }
            memberPayPrivilegeResultActivityBinding7.k.setText(str);
            MemberPayPrivilegeResultActivityBinding memberPayPrivilegeResultActivityBinding8 = this.a;
            if (memberPayPrivilegeResultActivityBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                memberPayPrivilegeResultActivityBinding8 = null;
            }
            EMManager.from(memberPayPrivilegeResultActivityBinding8.k).setTextSize(R.dimen.tbds47).setTextStyle(R.string.F_X02);
            MemberPayPrivilegeResultActivityBinding memberPayPrivilegeResultActivityBinding9 = this.a;
            if (memberPayPrivilegeResultActivityBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                memberPayPrivilegeResultActivityBinding = memberPayPrivilegeResultActivityBinding9;
            }
            memberPayPrivilegeResultActivityBinding.k.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.h59
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        MemberPayPrivilegeResultActivity.t1(MemberPayPrivilegeResultActivity.this, objectRef, view2);
                    }
                }
            });
        }
    }
}
