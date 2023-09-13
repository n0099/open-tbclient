package com.baidu.tieba.write;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.TbCaptureActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishGuideActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.switchs.PicCaptureModeSwitch;
import com.baidu.tbadk.switchs.PublishVideoThreadSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.e55;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.g55;
import com.baidu.tieba.i55;
import com.baidu.tieba.wga;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class WriteVideoUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean isShowGuide(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i == 1 || i == 2 : invokeI.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
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
                WriteVideoUtil.publishVideo(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements i55.f {
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
        public final /* synthetic */ g55 j;

        public b(String str, String str2, String str3, String str4, int i, Boolean bool, String str5, String str6, String str7, g55 g55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4, Integer.valueOf(i), bool, str5, str6, str7, g55Var};
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
            this.j = g55Var;
        }

        @Override // com.baidu.tieba.i55.f
        public void G0(i55 i55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, i55Var, i, view2) == null) {
                if (i == 0) {
                    WriteVideoUtil.sendThread(true, true, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
                } else if (i == 1) {
                    WriteVideoUtil.sendThread(true, false, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
                }
                g55 g55Var = this.j;
                if (g55Var != null) {
                    g55Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements i55.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g55 a;

        public c(g55 g55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g55Var;
        }

        @Override // com.baidu.tieba.i55.c
        public void onClick() {
            g55 g55Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (g55Var = this.a) != null) {
                g55Var.dismiss();
            }
        }
    }

    public WriteVideoUtil() {
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

    public static int getGuideStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return SharedPrefHelper.getInstance().getInt("key_work_video_guide_pop", -1);
        }
        return invokeV.intValue;
    }

    public static boolean hasDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return !TextUtils.isEmpty(wga.G());
        }
        return invokeV.booleanValue;
    }

    public static boolean isTbVideoAviable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (SwitchManager.getInstance().findType(PublishVideoThreadSwitch.PUBLISH_VIDEO_THREAD_KEY) != 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean jumpWorkVideoGuide(Context context, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, context, i, i2)) == null) {
            WorkPublishGuideActivityConfig workPublishGuideActivityConfig = new WorkPublishGuideActivityConfig(context);
            workPublishGuideActivityConfig.setRequestCode(25064);
            workPublishGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            if (isShowGuide(i)) {
                workPublishGuideActivityConfig.setPopStatus(i);
                workPublishGuideActivityConfig.setFrom(i2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishGuideActivityConfig));
                return true;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    public static void openBottomActionSheet(BdPageContext bdPageContext, String str, String str2, String str3, String str4, int i, Boolean bool, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{bdPageContext, str, str2, str3, str4, Integer.valueOf(i), bool, str5, str6, str7}) == null) && bdPageContext != null && bdPageContext.getPageActivity() != null) {
            String string = bdPageContext.getString(R.string.work_publish_open_dialog_title);
            g55 g55Var = new g55(bdPageContext);
            i55 i55Var = new i55(bdPageContext.getPageActivity());
            i55Var.t(string);
            ArrayList arrayList = new ArrayList();
            e55 e55Var = new e55(0, bdPageContext.getString(R.string.work_publish_open_dialog_load_draft), i55Var);
            e55Var.r(R.color.CAM_X0105);
            e55Var.p(R.color.CAM_X0204);
            arrayList.add(e55Var);
            e55 e55Var2 = new e55(1, bdPageContext.getString(R.string.work_publish_open_dialog_add_new), i55Var);
            e55Var2.r(R.color.CAM_X0105);
            e55Var2.p(R.color.CAM_X0204);
            arrayList.add(e55Var2);
            b bVar = new b(str, str2, str3, str4, i, bool, str5, str6, str7, g55Var);
            c cVar = new c(g55Var);
            i55Var.l(arrayList);
            i55Var.q(bVar);
            i55Var.o(cVar);
            g55Var.setCanceledOnTouchOutside(true);
            g55Var.h(i55Var);
            g55Var.l();
        }
    }

    public static void openBottomActionSheet(String str, String str2, String str3, String str4, int i, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i), bool}) == null) {
            openBottomActionSheet(str, str2, str3, str4, i, bool, "", "", "");
        }
    }

    public static void openBottomActionSheet(String str, String str2, String str3, String str4, int i, Boolean bool, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i), bool, str5, str6, str7}) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                openBottomActionSheet(((TbPageContextSupport) currentActivity).getPageContext(), str, str2, str3, str4, i, bool, str5, str6, str7);
            }
        }
    }

    public static void publishVideo(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, str, forumWriteData) == null) && forumWriteData != null && tbPageContext != null && isTbVideoAviable()) {
            if (PicCaptureModeSwitch.Companion.isOn()) {
                TbCaptureActivityConfig tbCaptureActivityConfig = new TbCaptureActivityConfig(tbPageContext.getPageActivity());
                tbCaptureActivityConfig.getIntent().putExtra("forum_write_data", forumWriteData);
                tbCaptureActivityConfig.setCaptureType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbCaptureActivityConfig));
                return;
            }
            RecordVideoActivityConfig.b bVar = new RecordVideoActivityConfig.b(1, forumWriteData, null, str, 0);
            bVar.d(0);
            if (forumWriteData != null) {
                bVar.c(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921615, bVar));
        }
    }

    public static void publishVideoWrite(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, str, forumWriteData) == null) && forumWriteData != null && tbPageContext != null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            permissionJudgePolicy.setOnPermissionsGrantedListener(new a(tbPageContext, str, forumWriteData));
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public static void sendThread(boolean z, boolean z2, String str, String str2, String str3, String str4, int i, Boolean bool, String str5, String str6, String str7) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3, str4, Integer.valueOf(i), bool, str5, str6, str7}) == null) {
            if (z) {
                if (z2) {
                    i2 = 2;
                } else {
                    wga.B("");
                    i2 = 1;
                }
            } else {
                i2 = 0;
            }
            WorkPublishOpenHelper.Companion.c(i2, TbadkCoreApplication.getInst().getCurrentActivity(), str, str2, str3, str4, Integer.valueOf(i), bool.booleanValue(), str5, str6, str7);
        }
    }

    public static void setCursorColor(EditText editText, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, editText, i) == null) {
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
