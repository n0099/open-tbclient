package com.baidu.tieba.tbadkCore.util;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountRestoreActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.repackage.dq4;
import com.repackage.f9;
import com.repackage.ki;
import com.repackage.li;
import com.repackage.sk4;
import com.repackage.ys4;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AntiHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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

        public OperationType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes4.dex */
    public static class a implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                ys4.k().u("anti_vcode_no_longer_tip", true);
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ BlockPopInfoData c;

        public b(k kVar, Context context, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, context, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
            this.b = context;
            this.c = blockPopInfoData;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                k kVar = this.a;
                if (kVar != null) {
                    kVar.onPositiveButtonClick(dq4Var);
                }
                dq4Var.dismiss();
                sk4.o(this.b, this.c.ahead_url);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        public c(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                k kVar = this.a;
                if (kVar != null) {
                    kVar.onNavigationButtonClick(dq4Var);
                }
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public d(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
                sk4.o(this.a, "http://tieba.baidu.com/mo/q/userappeal");
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public f(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
                sk4.o(this.a, "http://tieba.baidu.com/mo/q/userappeal");
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class g implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class h implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class i implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ PageType b;

        public i(Context context, PageType pageType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, pageType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = pageType;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountRestoreActivityConfig(this.a, this.b)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class j implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j() {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface k {
        void onNavigationButtonClick(dq4 dq4Var);

        void onPositiveButtonClick(dq4 dq4Var);
    }

    public static void A(Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        String string;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, antiData, operationType, pageType) == null) {
            dq4 dq4Var = new dq4(f9.a(context).getPageActivity());
            if (operationType == OperationType.SIGN) {
                String string3 = context.getString(R.string.obfuscated_res_0x7f0f0282);
                if (n(antiData)) {
                    string2 = context.getString(R.string.obfuscated_res_0x7f0f0289);
                } else if (g(antiData)) {
                    string2 = context.getString(R.string.obfuscated_res_0x7f0f0288);
                } else if (h(antiData)) {
                    string2 = context.getString(R.string.obfuscated_res_0x7f0f028a);
                } else {
                    string2 = context.getString(R.string.obfuscated_res_0x7f0f0287);
                }
                string = MessageFormat.format(string3, string2, context.getString(R.string.obfuscated_res_0x7f0f0284));
            } else {
                string = context.getString(R.string.obfuscated_res_0x7f0f027e);
            }
            dq4Var.setMessage(string);
            dq4Var.setPositiveButton(context.getString(R.string.obfuscated_res_0x7f0f028c), new d(context));
            dq4Var.setNegativeButton(context.getString(R.string.obfuscated_res_0x7f0f027d), new e());
            if (context instanceof Activity) {
                dq4Var.create(f9.a(context)).show();
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

    public static boolean b(TbPageContext<?> tbPageContext, ThreadData threadData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbPageContext, threadData)) == null) {
            if (tbPageContext == null || !j(threadData)) {
                return false;
            }
            li.O(tbPageContext.getPageActivity(), StringUtils.isNull(threadData.noCommetStr) ? tbPageContext.getString(R.string.obfuscated_res_0x7f0f064d) : threadData.noCommetStr);
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
            li.O(tbPageContext.getPageActivity(), StringUtils.isNull(videoItemData.noCommetStr) ? tbPageContext.getString(R.string.obfuscated_res_0x7f0f064d) : videoItemData.noCommetStr);
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

    public static boolean e(Context context, ThreadData threadData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, threadData)) == null) {
            if (context == null || !o(threadData)) {
                return false;
            }
            li.N(context, R.string.obfuscated_res_0x7f0f0600);
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

    public static boolean j(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, threadData)) == null) ? threadData != null && threadData.isUgcThreadType() && threadData.forbidComment : invokeL.booleanValue;
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
            if (ki.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f027c);
            }
            BdToast.h(TbadkCoreApplication.getInst().getContext(), str, R.drawable.obfuscated_res_0x7f0809ca, 3000, true).n();
            return true;
        }
        return invokeIL.booleanValue;
    }

    public static boolean n(AntiData antiData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, antiData)) == null) ? antiData != null && antiData.getBlock_stat() == 2 : invokeL.booleanValue;
    }

    public static boolean o(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, threadData)) == null) ? threadData != null && threadData.partialVisible && threadData.isUgcThreadType() : invokeL.booleanValue;
    }

    public static void p(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, context, str) == null) || context == null || ki.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("nomenu", "1"));
        arrayList.add(new Pair("noshare", "1"));
        sk4.o(context, sk4.d(str, arrayList));
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            ys4.k().D("anti_vcode_no_longer_tip");
        }
    }

    public static void r(Context context, AntiData antiData, PageType pageType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65554, null, context, antiData, pageType) == null) || ys4.k().h("anti_vcode_no_longer_tip", false)) {
            return;
        }
        boolean isHas_chance = antiData.isHas_chance();
        dq4 dq4Var = new dq4(f9.a(context).getPageActivity());
        dq4Var.setMessage(context.getString(isHas_chance ? R.string.obfuscated_res_0x7f0f028e : R.string.obfuscated_res_0x7f0f028d));
        if (!isHas_chance) {
            dq4Var.setNegativeButton(context.getString(R.string.obfuscated_res_0x7f0f028c), new i(context, pageType));
        } else {
            dq4Var.setNegativeButton(context.getString(R.string.obfuscated_res_0x7f0f042e), new j());
        }
        dq4Var.setPositiveButton(context.getString(R.string.obfuscated_res_0x7f0f028b), new a());
        if (context instanceof Activity) {
            dq4Var.create(f9.a(context)).show();
        }
    }

    public static dq4 s(Context context, BlockPopInfoData blockPopInfoData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, blockPopInfoData)) == null) ? t(context, blockPopInfoData, null) : (dq4) invokeLL.objValue;
    }

    public static dq4 t(Context context, BlockPopInfoData blockPopInfoData, k kVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65556, null, context, blockPopInfoData, kVar)) == null) {
            if (blockPopInfoData == null) {
                return null;
            }
            dq4 dq4Var = new dq4(f9.a(context).getPageActivity());
            if (blockPopInfoData.block_info == null) {
                blockPopInfoData.block_info = "";
            }
            dq4Var.setMessage(blockPopInfoData.block_info);
            dq4Var.setPositiveButton(ki.isEmpty(blockPopInfoData.ahead_info) ? context.getString(R.string.obfuscated_res_0x7f0f028c) : blockPopInfoData.ahead_info, new b(kVar, context, blockPopInfoData));
            dq4Var.setNegativeButton(ki.isEmpty(blockPopInfoData.ok_info) ? context.getString(R.string.obfuscated_res_0x7f0f027d) : blockPopInfoData.ok_info, new c(kVar));
            if (context instanceof Activity) {
                dq4Var.create(f9.a(context)).show();
                return dq4Var;
            }
            return null;
        }
        return (dq4) invokeLLL.objValue;
    }

    public static dq4 u(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, str)) == null) ? v(context, str, 0) : (dq4) invokeLL.objValue;
    }

    public static dq4 v(Context context, String str, int i2) {
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
        return (dq4) invokeLLI.objValue;
    }

    public static dq4 w(Context context, String str, int i2, k kVar) {
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
        return (dq4) invokeLLIL.objValue;
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
            dq4 dq4Var = new dq4(f9.a(context).getPageActivity());
            if (operationType == OperationType.SIGN) {
                String string2 = context.getString(R.string.obfuscated_res_0x7f0f0282);
                if (n(antiData)) {
                    string = context.getString(R.string.obfuscated_res_0x7f0f0289);
                } else if (g(antiData)) {
                    string = context.getString(R.string.obfuscated_res_0x7f0f0288);
                } else if (h(antiData)) {
                    string = context.getString(R.string.obfuscated_res_0x7f0f028a);
                } else {
                    string = context.getString(R.string.obfuscated_res_0x7f0f0287);
                }
                format = MessageFormat.format(string2, string, context.getString(R.string.obfuscated_res_0x7f0f0283));
            } else {
                format = MessageFormat.format(context.getString(R.string.obfuscated_res_0x7f0f0281), antiData.getBlock_forum_name(), Integer.valueOf(antiData.getDays_tofree()));
            }
            dq4Var.setMessage(format);
            dq4Var.setPositiveButton(context.getString(R.string.obfuscated_res_0x7f0f028c), new f(context));
            dq4Var.setNegativeButton(context.getString(R.string.obfuscated_res_0x7f0f027d), new g());
            if (context instanceof Activity) {
                dq4Var.create(f9.a(context)).show();
            }
        }
    }

    public static void z(Context context, AntiData antiData, OperationType operationType) {
        String string;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65562, null, context, antiData, operationType) == null) {
            dq4 dq4Var = new dq4(f9.a(context).getPageActivity());
            if (operationType == OperationType.SIGN) {
                String string3 = context.getString(R.string.obfuscated_res_0x7f0f0282);
                if (n(antiData)) {
                    string2 = context.getString(R.string.obfuscated_res_0x7f0f0289);
                } else if (g(antiData)) {
                    string2 = context.getString(R.string.obfuscated_res_0x7f0f0288);
                } else if (h(antiData)) {
                    string2 = context.getString(R.string.obfuscated_res_0x7f0f028a);
                } else {
                    string2 = context.getString(R.string.obfuscated_res_0x7f0f0287);
                }
                string = MessageFormat.format(string3, string2, context.getString(R.string.obfuscated_res_0x7f0f0285));
            } else {
                string = context.getString(R.string.obfuscated_res_0x7f0f0286);
            }
            dq4Var.setMessage(string);
            dq4Var.setPositiveButton(context.getString(R.string.obfuscated_res_0x7f0f042e), new h());
            if (context instanceof Activity) {
                dq4Var.create(f9.a(context)).show();
            }
        }
    }
}
