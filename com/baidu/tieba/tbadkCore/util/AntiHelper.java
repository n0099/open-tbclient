package com.baidu.tieba.tbadkCore.util;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.r0.s.r.d2;
import c.a.r0.s.t.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountRestoreActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes12.dex */
public class AntiHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes12.dex */
    public static final class OperationType {
        public static final /* synthetic */ OperationType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final OperationType ACCOUNT_RESTORE;
        public static final OperationType CREATE_THREAD;
        public static final OperationType LIKE;
        public static final OperationType REPLY;
        public static final OperationType SIGN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56553691, "Lcom/baidu/tieba/tbadkCore/util/AntiHelper$OperationType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-56553691, "Lcom/baidu/tieba/tbadkCore/util/AntiHelper$OperationType;");
                    return;
                }
            }
            ACCOUNT_RESTORE = new OperationType("ACCOUNT_RESTORE", 0);
            CREATE_THREAD = new OperationType("CREATE_THREAD", 1);
            SIGN = new OperationType("SIGN", 2);
            LIKE = new OperationType("LIKE", 3);
            OperationType operationType = new OperationType("REPLY", 4);
            REPLY = operationType;
            $VALUES = new OperationType[]{ACCOUNT_RESTORE, CREATE_THREAD, SIGN, LIKE, operationType};
        }

        public OperationType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static OperationType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (OperationType) Enum.valueOf(OperationType.class, str) : (OperationType) invokeL.objValue;
        }

        public static OperationType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (OperationType[]) $VALUES.clone() : (OperationType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.r0.s.g0.b.j().t("anti_vcode_no_longer_tip", true);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f49846e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f49847f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfoData f49848g;

        public b(k kVar, Context context, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, context, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49846e = kVar;
            this.f49847f = context;
            this.f49848g = blockPopInfoData;
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                k kVar = this.f49846e;
                if (kVar != null) {
                    kVar.onPositiveButtonClick(aVar);
                }
                aVar.dismiss();
                c.a.r0.m.a.m(this.f49847f, this.f49848g.ahead_url);
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f49849e;

        public c(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49849e = kVar;
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                k kVar = this.f49849e;
                if (kVar != null) {
                    kVar.onNavigationButtonClick(aVar);
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f49850e;

        public d(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49850e = context;
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                c.a.r0.m.a.m(this.f49850e, "http://tieba.baidu.com/mo/q/userappeal");
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f49851e;

        public f(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49851e = context;
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                c.a.r0.m.a.m(this.f49851e, "http://tieba.baidu.com/mo/q/userappeal");
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class i implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f49852e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PageType f49853f;

        public i(Context context, PageType pageType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, pageType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49852e = context;
            this.f49853f = pageType;
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountRestoreActivityConfig(this.f49852e, this.f49853f)));
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class j implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface k {
        void onNavigationButtonClick(c.a.r0.s.t.a aVar);

        void onPositiveButtonClick(c.a.r0.s.t.a aVar);
    }

    public static void A(Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        String string;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, antiData, operationType, pageType) == null) {
            c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(c.a.d.a.j.a(context).getPageActivity());
            if (operationType == OperationType.SIGN) {
                String string3 = context.getString(R.string.anti_appeal_sign_base_tip);
                if (n(antiData)) {
                    string2 = context.getString(R.string.anti_type_forbid_sys);
                } else if (g(antiData)) {
                    string2 = context.getString(R.string.anti_type_forbid_bawu);
                } else if (h(antiData)) {
                    string2 = context.getString(R.string.anti_type_hide);
                } else {
                    string2 = context.getString(R.string.anti_type_exception);
                }
                string = MessageFormat.format(string3, string2, context.getString(R.string.anti_appeal_sign_com_tip));
            } else {
                string = context.getString(R.string.anti_account_exception_tip);
            }
            aVar.setMessage(string);
            aVar.setPositiveButton(context.getString(R.string.anti_vcode_pos), new d(context));
            aVar.setNegativeButton(context.getString(R.string.anti_account_exception_neg), new e());
            if (context instanceof Activity) {
                aVar.create(c.a.d.a.j.a(context)).show();
            }
        }
    }

    public static boolean a(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, context, i2, str)) == null) {
            if (i(i2)) {
                p(context, str);
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static boolean b(TbPageContext<?> tbPageContext, d2 d2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbPageContext, d2Var)) == null) {
            if (tbPageContext == null || !j(d2Var)) {
                return false;
            }
            m.M(tbPageContext.getPageActivity(), StringUtils.isNull(d2Var.p2) ? tbPageContext.getString(R.string.forbiden_comment_text) : d2Var.p2);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(TbPageContext<?> tbPageContext, VideoItemData videoItemData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, tbPageContext, videoItemData)) == null) {
            if (tbPageContext == null || !k(videoItemData)) {
                return false;
            }
            m.M(tbPageContext.getPageActivity(), StringUtils.isNull(videoItemData.noCommetStr) ? tbPageContext.getString(R.string.forbiden_comment_text) : videoItemData.noCommetStr);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean d(TbPageContext<?> tbPageContext, AntiData antiData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, antiData)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean e(Context context, d2 d2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, d2Var)) == null) {
            if (context == null || !o(d2Var)) {
                return false;
            }
            m.L(context, R.string.feed_thread_state_under_review_text);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean f(AntiData antiData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, antiData)) == null) ? antiData != null && antiData.getVcode_stat() == 1 : invokeL.booleanValue;
    }

    public static boolean g(AntiData antiData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, antiData)) == null) ? antiData != null && antiData.getBlock_stat() == 3 : invokeL.booleanValue;
    }

    public static boolean h(AntiData antiData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, antiData)) == null) ? antiData != null && antiData.getHide_stat() == 1 : invokeL.booleanValue;
    }

    public static boolean i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) ? i2 == 3250012 : invokeI.booleanValue;
    }

    public static boolean j(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, d2Var)) == null) ? d2Var != null && d2Var.G2() && d2Var.o2 : invokeL.booleanValue;
    }

    public static boolean k(VideoItemData videoItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, videoItemData)) == null) ? videoItemData != null && videoItemData.isBjhVideo && videoItemData.forbidComment : invokeL.booleanValue;
    }

    public static boolean l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) ? i2 == 3250002 || i2 == 3250001 || i2 == 3250003 || i2 == 3250004 || i2 == 3250013 : invokeI.booleanValue;
    }

    public static boolean m(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65549, null, i2, str)) == null) {
            if (i2 != 3250013) {
                return i2 == 3250002 || i2 == 3250001 || i2 == 3250003 || i2 == 3250004 || i2 == 3250013;
            }
            if (l.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
            }
            BdToast.h(TbadkCoreApplication.getInst().getContext(), str, R.drawable.icon_pure_toast_mistake40_svg, 3000, false).q();
            return true;
        }
        return invokeIL.booleanValue;
    }

    public static boolean n(AntiData antiData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, antiData)) == null) ? antiData != null && antiData.getBlock_stat() == 2 : invokeL.booleanValue;
    }

    public static boolean o(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, d2Var)) == null) ? d2Var != null && d2Var.v1 && d2Var.G2() : invokeL.booleanValue;
    }

    public static void p(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, context, str) == null) || context == null || l.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("nomenu", "1"));
        arrayList.add(new Pair("noshare", "1"));
        c.a.r0.m.a.m(context, c.a.r0.m.a.c(str, arrayList));
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            c.a.r0.s.g0.b.j().C("anti_vcode_no_longer_tip");
        }
    }

    public static void r(Context context, AntiData antiData, PageType pageType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65554, null, context, antiData, pageType) == null) || c.a.r0.s.g0.b.j().g("anti_vcode_no_longer_tip", false)) {
            return;
        }
        boolean isHas_chance = antiData.isHas_chance();
        c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(c.a.d.a.j.a(context).getPageActivity());
        aVar.setMessage(context.getString(isHas_chance ? R.string.anti_vocode_on_chance_tip : R.string.anti_vcode_tip));
        if (!isHas_chance) {
            aVar.setNegativeButton(context.getString(R.string.anti_vcode_pos), new i(context, pageType));
        } else {
            aVar.setNegativeButton(context.getString(R.string.confirm), new j());
        }
        aVar.setPositiveButton(context.getString(R.string.anti_vcode_neg), new a());
        if (context instanceof Activity) {
            aVar.create(c.a.d.a.j.a(context)).show();
        }
    }

    public static c.a.r0.s.t.a s(Context context, BlockPopInfoData blockPopInfoData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, blockPopInfoData)) == null) ? t(context, blockPopInfoData, null) : (c.a.r0.s.t.a) invokeLL.objValue;
    }

    public static c.a.r0.s.t.a t(Context context, BlockPopInfoData blockPopInfoData, k kVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65556, null, context, blockPopInfoData, kVar)) == null) {
            if (blockPopInfoData == null) {
                return null;
            }
            c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(c.a.d.a.j.a(context).getPageActivity());
            if (blockPopInfoData.block_info == null) {
                blockPopInfoData.block_info = "";
            }
            aVar.setMessage(blockPopInfoData.block_info);
            aVar.setPositiveButton(l.isEmpty(blockPopInfoData.ahead_info) ? context.getString(R.string.anti_vcode_pos) : blockPopInfoData.ahead_info, new b(kVar, context, blockPopInfoData));
            aVar.setNegativeButton(l.isEmpty(blockPopInfoData.ok_info) ? context.getString(R.string.anti_account_exception_neg) : blockPopInfoData.ok_info, new c(kVar));
            if (context instanceof Activity) {
                aVar.create(c.a.d.a.j.a(context)).show();
                return aVar;
            }
            return null;
        }
        return (c.a.r0.s.t.a) invokeLLL.objValue;
    }

    public static c.a.r0.s.t.a u(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, str)) == null) ? v(context, str, 0) : (c.a.r0.s.t.a) invokeLL.objValue;
    }

    public static c.a.r0.s.t.a v(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65558, null, context, str, i2)) == null) {
            if (str == null) {
                str = "";
            }
            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
            blockPopInfoData.block_info = str;
            if (i2 == 0) {
                str2 = "http://tieba.baidu.com/mo/q/userappeal";
            } else {
                str2 = "http://tieba.baidu.com/mo/q/userappeal?block_errno=" + i2;
            }
            blockPopInfoData.ahead_url = str2;
            return s(context, blockPopInfoData);
        }
        return (c.a.r0.s.t.a) invokeLLI.objValue;
    }

    public static c.a.r0.s.t.a w(Context context, String str, int i2, k kVar) {
        InterceptResult invokeLLIL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65559, null, context, str, i2, kVar)) == null) {
            if (str == null) {
                str = "";
            }
            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
            blockPopInfoData.block_info = str;
            if (i2 == 0) {
                str2 = "http://tieba.baidu.com/mo/q/userappeal";
            } else {
                str2 = "http://tieba.baidu.com/mo/q/userappeal?block_errno=" + i2;
            }
            blockPopInfoData.ahead_url = str2;
            return t(context, blockPopInfoData, kVar);
        }
        return (c.a.r0.s.t.a) invokeLLIL.objValue;
    }

    public static boolean x(Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65560, null, context, antiData, operationType, pageType)) == null) {
            if (!f(antiData)) {
                q();
            }
            if (!n(antiData) && !h(antiData)) {
                if (g(antiData)) {
                    y(context, antiData, operationType);
                } else if (!f(antiData) || operationType != OperationType.REPLY) {
                    return false;
                } else {
                    r(context, antiData, pageType);
                }
            } else if (antiData.isHas_chance()) {
                A(context, antiData, operationType, pageType);
            } else {
                z(context, antiData, operationType);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public static void y(Context context, AntiData antiData, OperationType operationType) {
        String format;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65561, null, context, antiData, operationType) == null) {
            c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(c.a.d.a.j.a(context).getPageActivity());
            if (operationType == OperationType.SIGN) {
                String string2 = context.getString(R.string.anti_appeal_sign_base_tip);
                if (n(antiData)) {
                    string = context.getString(R.string.anti_type_forbid_sys);
                } else if (g(antiData)) {
                    string = context.getString(R.string.anti_type_forbid_bawu);
                } else if (h(antiData)) {
                    string = context.getString(R.string.anti_type_hide);
                } else {
                    string = context.getString(R.string.anti_type_exception);
                }
                format = MessageFormat.format(string2, string, context.getString(R.string.anti_appeal_sign_bawu_tip));
            } else {
                format = MessageFormat.format(context.getString(R.string.anti_appeal_com_tip), antiData.getBlock_forum_name(), Integer.valueOf(antiData.getDays_tofree()));
            }
            aVar.setMessage(format);
            aVar.setPositiveButton(context.getString(R.string.anti_vcode_pos), new f(context));
            aVar.setNegativeButton(context.getString(R.string.anti_account_exception_neg), new g());
            if (context instanceof Activity) {
                aVar.create(c.a.d.a.j.a(context)).show();
            }
        }
    }

    public static void z(Context context, AntiData antiData, OperationType operationType) {
        String string;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65562, null, context, antiData, operationType) == null) {
            c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(c.a.d.a.j.a(context).getPageActivity());
            if (operationType == OperationType.SIGN) {
                String string3 = context.getString(R.string.anti_appeal_sign_base_tip);
                if (n(antiData)) {
                    string2 = context.getString(R.string.anti_type_forbid_sys);
                } else if (g(antiData)) {
                    string2 = context.getString(R.string.anti_type_forbid_bawu);
                } else if (h(antiData)) {
                    string2 = context.getString(R.string.anti_type_hide);
                } else {
                    string2 = context.getString(R.string.anti_type_exception);
                }
                string = MessageFormat.format(string3, string2, context.getString(R.string.anti_appeal_sign_no_chance_tip));
            } else {
                string = context.getString(R.string.anti_no_chance_com_tip);
            }
            aVar.setMessage(string);
            aVar.setPositiveButton(context.getString(R.string.confirm), new h());
            if (context instanceof Activity) {
                aVar.create(c.a.d.a.j.a(context)).show();
            }
        }
    }
}
