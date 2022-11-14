package com.baidu.tieba.tbadkCore.util;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountRestoreActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.R;
import com.baidu.tieba.jv4;
import com.baidu.tieba.py4;
import com.baidu.tieba.sp4;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.x9;
import com.baidu.tieba.xi;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class AntiHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface k {
        void onNavigationButtonClick(jv4 jv4Var);

        void onPositiveButtonClick(jv4 jv4Var);
    }

    public static boolean d(TbPageContext<?> tbPageContext, AntiData antiData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, tbPageContext, antiData)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) ? i2 == 3250012 : invokeI.booleanValue;
    }

    public static boolean l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i2)) == null) ? i2 == 3250002 || i2 == 3250001 || i2 == 3250003 || i2 == 3250004 || i2 == 3250013 : invokeI.booleanValue;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (OperationType) Enum.valueOf(OperationType.class, str);
            }
            return (OperationType) invokeL.objValue;
        }

        public static OperationType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (OperationType[]) $VALUES.clone();
            }
            return (OperationType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                py4.k().u("anti_vcode_no_longer_tip", true);
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                k kVar = this.a;
                if (kVar != null) {
                    kVar.onPositiveButtonClick(jv4Var);
                }
                jv4Var.dismiss();
                sp4.o(this.b, this.c.ahead_url);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                k kVar = this.a;
                if (kVar != null) {
                    kVar.onNavigationButtonClick(jv4Var);
                }
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
                sp4.o(this.a, AntiHelper.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
                sp4.o(this.a, AntiHelper.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountRestoreActivityConfig(this.a, this.b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(265801538, "Lcom/baidu/tieba/tbadkCore/util/AntiHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(265801538, "Lcom/baidu/tieba/tbadkCore/util/AntiHelper;");
                return;
            }
        }
        a = TbConfig.TIEBA_ADDRESS + "mo/q/userappeal";
    }

    public static void A(Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        String string;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, context, antiData, operationType, pageType) == null) {
            jv4 jv4Var = new jv4(x9.a(context).getPageActivity());
            if (operationType == OperationType.SIGN) {
                String string3 = context.getString(R.string.obfuscated_res_0x7f0f028f);
                if (n(antiData)) {
                    string2 = context.getString(R.string.obfuscated_res_0x7f0f0296);
                } else if (g(antiData)) {
                    string2 = context.getString(R.string.obfuscated_res_0x7f0f0295);
                } else if (h(antiData)) {
                    string2 = context.getString(R.string.obfuscated_res_0x7f0f0297);
                } else {
                    string2 = context.getString(R.string.obfuscated_res_0x7f0f0294);
                }
                string = MessageFormat.format(string3, string2, context.getString(R.string.obfuscated_res_0x7f0f0291));
            } else {
                string = context.getString(R.string.obfuscated_res_0x7f0f028b);
            }
            jv4Var.setMessage(string);
            jv4Var.setPositiveButton(context.getString(R.string.obfuscated_res_0x7f0f0299), new d(context));
            jv4Var.setNegativeButton(context.getString(R.string.obfuscated_res_0x7f0f028a), new e());
            if (context instanceof Activity) {
                jv4Var.create(x9.a(context)).show();
            }
        }
    }

    public static boolean a(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, context, i2, str)) == null) {
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
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, tbPageContext, threadData)) == null) {
            if (tbPageContext != null && j(threadData)) {
                if (StringUtils.isNull(threadData.noCommetStr)) {
                    str = tbPageContext.getString(R.string.obfuscated_res_0x7f0f0676);
                } else {
                    str = threadData.noCommetStr;
                }
                yi.P(tbPageContext.getPageActivity(), str);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(TbPageContext<?> tbPageContext, VideoItemData videoItemData) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, videoItemData)) == null) {
            if (tbPageContext != null && k(videoItemData)) {
                if (StringUtils.isNull(videoItemData.noCommetStr)) {
                    str = tbPageContext.getString(R.string.obfuscated_res_0x7f0f0676);
                } else {
                    str = videoItemData.noCommetStr;
                }
                yi.P(tbPageContext.getPageActivity(), str);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void p(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65553, null, context, str) == null) && context != null && !xi.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair(BaseWebViewActivity.KEY_NO_MENU, "1"));
            arrayList.add(new Pair(BaseWebViewActivity.KEY_NO_SHARE, "1"));
            sp4.o(context, sp4.d(str, arrayList));
        }
    }

    public static boolean e(Context context, ThreadData threadData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, threadData)) == null) {
            if (context != null && o(threadData)) {
                yi.O(context, R.string.obfuscated_res_0x7f0f0623);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static jv4 s(Context context, BlockPopInfoData blockPopInfoData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, blockPopInfoData)) == null) {
            return t(context, blockPopInfoData, null);
        }
        return (jv4) invokeLL.objValue;
    }

    public static jv4 u(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, context, str)) == null) {
            return v(context, str, 0);
        }
        return (jv4) invokeLL.objValue;
    }

    public static boolean f(AntiData antiData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, antiData)) == null) {
            if (antiData != null && antiData.getVcode_stat() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean g(AntiData antiData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, antiData)) == null) {
            if (antiData != null && antiData.getBlock_stat() == 3) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean h(AntiData antiData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, antiData)) == null) {
            if (antiData != null && antiData.getHide_stat() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, threadData)) == null) {
            if (threadData != null && threadData.isUgcThreadType() && threadData.forbidComment) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(VideoItemData videoItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, videoItemData)) == null) {
            if (videoItemData != null && videoItemData.isBjhVideo && videoItemData.forbidComment) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean n(AntiData antiData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, antiData)) == null) {
            if (antiData != null && antiData.getBlock_stat() == 2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean o(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, threadData)) == null) {
            if (threadData != null && threadData.partialVisible && threadData.isUgcThreadType()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean m(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65550, null, i2, str)) == null) {
            if (i2 == 3250013) {
                if (xi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0289);
                }
                BdToast b2 = BdToast.b(TbadkCoreApplication.getInst().getContext(), str);
                b2.f(BdToast.ToastIcon.FAILURE);
                b2.c(3000);
                b2.i();
                return true;
            } else if (i2 == 3250002 || i2 == 3250001 || i2 == 3250003 || i2 == 3250004 || i2 == 3250013) {
                return true;
            } else {
                return false;
            }
        }
        return invokeIL.booleanValue;
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            py4.k().D("anti_vcode_no_longer_tip");
        }
    }

    public static void r(Context context, AntiData antiData, PageType pageType) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65555, null, context, antiData, pageType) != null) || py4.k().h("anti_vcode_no_longer_tip", false)) {
            return;
        }
        boolean isHas_chance = antiData.isHas_chance();
        jv4 jv4Var = new jv4(x9.a(context).getPageActivity());
        if (isHas_chance) {
            i2 = R.string.obfuscated_res_0x7f0f029b;
        } else {
            i2 = R.string.obfuscated_res_0x7f0f029a;
        }
        jv4Var.setMessage(context.getString(i2));
        if (!isHas_chance) {
            jv4Var.setNegativeButton(context.getString(R.string.obfuscated_res_0x7f0f0299), new i(context, pageType));
        } else {
            jv4Var.setNegativeButton(context.getString(R.string.obfuscated_res_0x7f0f0440), new j());
        }
        jv4Var.setPositiveButton(context.getString(R.string.obfuscated_res_0x7f0f0298), new a());
        if (context instanceof Activity) {
            jv4Var.create(x9.a(context)).show();
        }
    }

    public static jv4 t(Context context, BlockPopInfoData blockPopInfoData, k kVar) {
        InterceptResult invokeLLL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65557, null, context, blockPopInfoData, kVar)) == null) {
            if (blockPopInfoData == null) {
                return null;
            }
            jv4 jv4Var = new jv4(x9.a(context).getPageActivity());
            if (blockPopInfoData.block_info == null) {
                blockPopInfoData.block_info = "";
            }
            jv4Var.setMessage(blockPopInfoData.block_info);
            if (xi.isEmpty(blockPopInfoData.ahead_info)) {
                str = context.getString(R.string.obfuscated_res_0x7f0f0299);
            } else {
                str = blockPopInfoData.ahead_info;
            }
            jv4Var.setPositiveButton(str, new b(kVar, context, blockPopInfoData));
            if (xi.isEmpty(blockPopInfoData.ok_info)) {
                str2 = context.getString(R.string.obfuscated_res_0x7f0f028a);
            } else {
                str2 = blockPopInfoData.ok_info;
            }
            jv4Var.setNegativeButton(str2, new c(kVar));
            if (!(context instanceof Activity)) {
                return null;
            }
            jv4Var.create(x9.a(context)).show();
            return jv4Var;
        }
        return (jv4) invokeLLL.objValue;
    }

    public static jv4 v(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65559, null, context, str, i2)) == null) {
            if (str == null) {
                str = "";
            }
            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
            blockPopInfoData.block_info = str;
            if (i2 == 0) {
                str2 = a;
            } else {
                str2 = a + "?block_errno=" + i2;
            }
            blockPopInfoData.ahead_url = str2;
            return s(context, blockPopInfoData);
        }
        return (jv4) invokeLLI.objValue;
    }

    public static jv4 w(Context context, String str, int i2, k kVar) {
        InterceptResult invokeLLIL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65560, null, context, str, i2, kVar)) == null) {
            if (str == null) {
                str = "";
            }
            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
            blockPopInfoData.block_info = str;
            if (i2 == 0) {
                str2 = a;
            } else {
                str2 = a + "?block_errno=" + i2;
            }
            blockPopInfoData.ahead_url = str2;
            return t(context, blockPopInfoData, kVar);
        }
        return (jv4) invokeLLIL.objValue;
    }

    public static boolean x(Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65561, null, context, antiData, operationType, pageType)) == null) {
            if (!f(antiData)) {
                q();
            }
            if (!n(antiData) && !h(antiData)) {
                if (g(antiData)) {
                    y(context, antiData, operationType);
                } else if (f(antiData) && operationType == OperationType.REPLY) {
                    r(context, antiData, pageType);
                } else {
                    return false;
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
        if (interceptable == null || interceptable.invokeLLL(65562, null, context, antiData, operationType) == null) {
            jv4 jv4Var = new jv4(x9.a(context).getPageActivity());
            if (operationType == OperationType.SIGN) {
                String string2 = context.getString(R.string.obfuscated_res_0x7f0f028f);
                if (n(antiData)) {
                    string = context.getString(R.string.obfuscated_res_0x7f0f0296);
                } else if (g(antiData)) {
                    string = context.getString(R.string.obfuscated_res_0x7f0f0295);
                } else if (h(antiData)) {
                    string = context.getString(R.string.obfuscated_res_0x7f0f0297);
                } else {
                    string = context.getString(R.string.obfuscated_res_0x7f0f0294);
                }
                format = MessageFormat.format(string2, string, context.getString(R.string.obfuscated_res_0x7f0f0290));
            } else {
                format = MessageFormat.format(context.getString(R.string.obfuscated_res_0x7f0f028e), antiData.getBlock_forum_name(), Integer.valueOf(antiData.getDays_tofree()));
            }
            jv4Var.setMessage(format);
            jv4Var.setPositiveButton(context.getString(R.string.obfuscated_res_0x7f0f0299), new f(context));
            jv4Var.setNegativeButton(context.getString(R.string.obfuscated_res_0x7f0f028a), new g());
            if (context instanceof Activity) {
                jv4Var.create(x9.a(context)).show();
            }
        }
    }

    public static void z(Context context, AntiData antiData, OperationType operationType) {
        String string;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65563, null, context, antiData, operationType) == null) {
            jv4 jv4Var = new jv4(x9.a(context).getPageActivity());
            if (operationType == OperationType.SIGN) {
                String string3 = context.getString(R.string.obfuscated_res_0x7f0f028f);
                if (n(antiData)) {
                    string2 = context.getString(R.string.obfuscated_res_0x7f0f0296);
                } else if (g(antiData)) {
                    string2 = context.getString(R.string.obfuscated_res_0x7f0f0295);
                } else if (h(antiData)) {
                    string2 = context.getString(R.string.obfuscated_res_0x7f0f0297);
                } else {
                    string2 = context.getString(R.string.obfuscated_res_0x7f0f0294);
                }
                string = MessageFormat.format(string3, string2, context.getString(R.string.obfuscated_res_0x7f0f0292));
            } else {
                string = context.getString(R.string.obfuscated_res_0x7f0f0293);
            }
            jv4Var.setMessage(string);
            jv4Var.setPositiveButton(context.getString(R.string.obfuscated_res_0x7f0f0440), new h());
            if (context instanceof Activity) {
                jv4Var.create(x9.a(context)).show();
            }
        }
    }
}
