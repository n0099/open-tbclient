package com.baidu.tieba.tbadkCore.util;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountRestoreActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.R;
import com.baidu.tieba.ei;
import com.baidu.tieba.m9;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.y45;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class AntiHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface k {
        void onNavigationButtonClick(y45 y45Var);

        void onPositiveButtonClick(y45 y45Var);
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
    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public class a implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                SharedPrefHelper.getInstance().putBoolean("anti_vcode_no_longer_tip", true);
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                k kVar = this.a;
                if (kVar != null) {
                    kVar.onPositiveButtonClick(y45Var);
                }
                y45Var.dismiss();
                BrowserHelper.startWebActivity(this.b, this.c.ahead_url);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                k kVar = this.a;
                if (kVar != null) {
                    kVar.onNavigationButtonClick(y45Var);
                }
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
                BrowserHelper.startWebActivity(this.a, AntiHelper.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
                BrowserHelper.startWebActivity(this.a, AntiHelper.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountRestoreActivityConfig(this.a, this.b)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
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
            y45 y45Var = new y45(m9.a(context).getPageActivity());
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
            y45Var.setMessage(string);
            y45Var.setPositiveButton(context.getString(R.string.anti_vcode_pos), new d(context));
            y45Var.setNegativeButton(context.getString(R.string.anti_account_exception_neg), new e());
            if (context instanceof Activity) {
                y45Var.create(m9.a(context)).show();
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
                    str = tbPageContext.getString(R.string.forbiden_comment_text);
                } else {
                    str = threadData.noCommetStr;
                }
                BdUtilHelper.showToast(tbPageContext.getPageActivity(), str);
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
                    str = tbPageContext.getString(R.string.forbiden_comment_text);
                } else {
                    str = videoItemData.noCommetStr;
                }
                BdUtilHelper.showToast(tbPageContext.getPageActivity(), str);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void p(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65553, null, context, str) == null) && context != null && !ei.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair(BaseWebViewActivity.KEY_NO_MENU, "1"));
            arrayList.add(new Pair(BaseWebViewActivity.KEY_NO_SHARE, "1"));
            BrowserHelper.startWebActivity(context, BrowserHelper.appendParams(str, arrayList));
        }
    }

    public static boolean e(Context context, ThreadData threadData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, threadData)) == null) {
            if (context != null && o(threadData)) {
                BdUtilHelper.showToast(context, (int) R.string.feed_thread_state_under_review_text);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static y45 s(Context context, BlockPopInfoData blockPopInfoData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, blockPopInfoData)) == null) {
            return t(context, blockPopInfoData, null);
        }
        return (y45) invokeLL.objValue;
    }

    public static y45 u(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, context, str)) == null) {
            return v(context, str, 0);
        }
        return (y45) invokeLL.objValue;
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
                if (ei.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
                }
                BdToast.makeText(TbadkCoreApplication.getInst().getContext(), str).setIcon(BdToast.ToastIcon.FAILURE).setDuration(3000).show();
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
            SharedPrefHelper.getInstance().remove("anti_vcode_no_longer_tip");
        }
    }

    public static void r(Context context, AntiData antiData, PageType pageType) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65555, null, context, antiData, pageType) != null) || SharedPrefHelper.getInstance().getBoolean("anti_vcode_no_longer_tip", false)) {
            return;
        }
        boolean isHas_chance = antiData.isHas_chance();
        y45 y45Var = new y45(m9.a(context).getPageActivity());
        if (isHas_chance) {
            i2 = R.string.anti_vocode_on_chance_tip;
        } else {
            i2 = R.string.anti_vcode_tip;
        }
        y45Var.setMessage(context.getString(i2));
        if (!isHas_chance) {
            y45Var.setNegativeButton(context.getString(R.string.anti_vcode_pos), new i(context, pageType));
        } else {
            y45Var.setNegativeButton(context.getString(R.string.obfuscated_res_0x7f0f04c4), new j());
        }
        y45Var.setPositiveButton(context.getString(R.string.anti_vcode_neg), new a());
        if (context instanceof Activity) {
            y45Var.create(m9.a(context)).show();
        }
    }

    public static y45 t(Context context, BlockPopInfoData blockPopInfoData, k kVar) {
        InterceptResult invokeLLL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65557, null, context, blockPopInfoData, kVar)) == null) {
            if (blockPopInfoData == null) {
                return null;
            }
            y45 y45Var = new y45(m9.a(context).getPageActivity());
            if (blockPopInfoData.block_info == null) {
                blockPopInfoData.block_info = "";
            }
            y45Var.setMessage(blockPopInfoData.block_info);
            if (ei.isEmpty(blockPopInfoData.ahead_info)) {
                str = context.getString(R.string.anti_vcode_pos);
            } else {
                str = blockPopInfoData.ahead_info;
            }
            y45Var.setPositiveButton(str, new b(kVar, context, blockPopInfoData));
            if (ei.isEmpty(blockPopInfoData.ok_info)) {
                str2 = context.getString(R.string.anti_account_exception_neg);
            } else {
                str2 = blockPopInfoData.ok_info;
            }
            y45Var.setNegativeButton(str2, new c(kVar));
            if (!(context instanceof Activity)) {
                return null;
            }
            y45Var.create(m9.a(context)).show();
            return y45Var;
        }
        return (y45) invokeLLL.objValue;
    }

    public static y45 v(Context context, String str, int i2) {
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
        return (y45) invokeLLI.objValue;
    }

    public static y45 w(Context context, String str, int i2, k kVar) {
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
        return (y45) invokeLLIL.objValue;
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
            y45 y45Var = new y45(m9.a(context).getPageActivity());
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
            y45Var.setMessage(format);
            y45Var.setPositiveButton(context.getString(R.string.anti_vcode_pos), new f(context));
            y45Var.setNegativeButton(context.getString(R.string.anti_account_exception_neg), new g());
            if (context instanceof Activity) {
                y45Var.create(m9.a(context)).show();
            }
        }
    }

    public static void z(Context context, AntiData antiData, OperationType operationType) {
        String string;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65563, null, context, antiData, operationType) == null) {
            y45 y45Var = new y45(m9.a(context).getPageActivity());
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
            y45Var.setMessage(string);
            y45Var.setPositiveButton(context.getString(R.string.obfuscated_res_0x7f0f04c4), new h());
            if (context instanceof Activity) {
                y45Var.create(m9.a(context)).show();
            }
        }
    }
}
