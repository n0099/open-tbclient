package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishGuideActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.switchs.PublishVideoThreadSwitch;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.n05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class l1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i == 1 || i == 2 : invokeI.booleanValue;
    }

    /* loaded from: classes5.dex */
    public static class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ForumWriteData c;

        public a(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, str, forumWriteData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = str;
            this.c = forumWriteData;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l1a.i(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements n05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ Boolean f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ l05 j;

        public b(String str, String str2, String str3, String str4, int i, Boolean bool, String str5, String str6, String str7, l05 l05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4, Integer.valueOf(i), bool, str5, str6, str7, l05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = i;
            this.f = bool;
            this.g = str5;
            this.h = str6;
            this.i = str7;
            this.j = l05Var;
        }

        @Override // com.baidu.tieba.n05.f
        public void M0(n05 n05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n05Var, i, view2) == null) {
                if (i == 0) {
                    l1a.k(true, true, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
                } else if (i == 1) {
                    l1a.k(true, false, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
                }
                l05 l05Var = this.j;
                if (l05Var != null) {
                    l05Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements n05.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l05 a;

        public c(l05 l05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l05Var;
        }

        @Override // com.baidu.tieba.n05.c
        public void onClick() {
            l05 l05Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (l05Var = this.a) != null) {
                l05Var.dismiss();
            }
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return p45.m().n("key_work_video_guide_pop", -1);
        }
        return invokeV.intValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return !TextUtils.isEmpty(vk9.D());
        }
        return invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (SwitchManager.getInstance().findType(PublishVideoThreadSwitch.PUBLISH_VIDEO_THREAD_KEY) != 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean e(Context context, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i, i2)) == null) {
            WorkPublishGuideActivityConfig workPublishGuideActivityConfig = new WorkPublishGuideActivityConfig(context);
            workPublishGuideActivityConfig.setRequestCode(25064);
            workPublishGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            if (c(i)) {
                workPublishGuideActivityConfig.setPopStatus(i);
                workPublishGuideActivityConfig.setFrom(i2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishGuideActivityConfig));
                return true;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    public static void f(a9 a9Var, String str, String str2, String str3, String str4, int i, Boolean bool, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{a9Var, str, str2, str3, str4, Integer.valueOf(i), bool, str5, str6, str7}) == null) && a9Var != null && a9Var.getPageActivity() != null) {
            String string = a9Var.getString(R.string.work_publish_open_dialog_title);
            l05 l05Var = new l05(a9Var);
            n05 n05Var = new n05(a9Var.getPageActivity());
            n05Var.s(string);
            ArrayList arrayList = new ArrayList();
            j05 j05Var = new j05(0, a9Var.getString(R.string.work_publish_open_dialog_load_draft), n05Var);
            j05Var.q(R.color.CAM_X0105);
            j05Var.o(R.color.CAM_X0204);
            arrayList.add(j05Var);
            j05 j05Var2 = new j05(1, a9Var.getString(R.string.work_publish_open_dialog_add_new), n05Var);
            j05Var2.q(R.color.CAM_X0105);
            j05Var2.o(R.color.CAM_X0204);
            arrayList.add(j05Var2);
            b bVar = new b(str, str2, str3, str4, i, bool, str5, str6, str7, l05Var);
            c cVar = new c(l05Var);
            n05Var.k(arrayList);
            n05Var.p(bVar);
            n05Var.n(cVar);
            l05Var.setCanceledOnTouchOutside(true);
            l05Var.h(n05Var);
            l05Var.k();
        }
    }

    public static void g(String str, String str2, String str3, String str4, int i, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i), bool}) == null) {
            h(str, str2, str3, str4, i, bool, "", "", "");
        }
    }

    public static void h(String str, String str2, String str3, String str4, int i, Boolean bool, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i), bool, str5, str6, str7}) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                f(((TbPageContextSupport) currentActivity).getPageContext(), str, str2, str3, str4, i, bool, str5, str6, str7);
            }
        }
    }

    public static void i(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65544, null, tbPageContext, str, forumWriteData) == null) && forumWriteData != null && tbPageContext != null && d()) {
            RecordVideoActivityConfig.b bVar = new RecordVideoActivityConfig.b(1, forumWriteData, null, str, 0);
            bVar.d(0);
            if (forumWriteData != null) {
                bVar.c(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921615, bVar));
        }
    }

    public static void j(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, str, forumWriteData) == null) && forumWriteData != null && tbPageContext != null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            permissionJudgePolicy.setOnPermissionsGrantedListener(new a(tbPageContext, str, forumWriteData));
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public static void k(boolean z, boolean z2, String str, String str2, String str3, String str4, int i, Boolean bool, String str5, String str6, String str7) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3, str4, Integer.valueOf(i), bool, str5, str6, str7}) == null) {
            if (z) {
                if (z2) {
                    i2 = 2;
                } else {
                    vk9.y("");
                    i2 = 1;
                }
            } else {
                i2 = 0;
            }
            WorkPublishOpenHelper.Companion.c(i2, TbadkCoreApplication.getInst().getCurrentActivity(), str, str2, str3, str4, Integer.valueOf(i), bool.booleanValue(), str5, str6, str7);
        }
    }

    public static void l(EditText editText, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, editText, i) == null) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(editText, Integer.valueOf(i));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
