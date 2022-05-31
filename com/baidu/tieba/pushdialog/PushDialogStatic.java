package com.baidu.tieba.pushdialog;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PushDialogActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.pushdialog.data.PullTidHttpRespMessage;
import com.baidu.tieba.pushdialog.data.PullTidSocketResponseMessage;
import com.baidu.tieba.pushdialog.data.PushDialogHttpResMsg;
import com.baidu.tieba.pushdialog.data.PushDialogSocketResMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c68;
import com.repackage.dq4;
import com.repackage.ig8;
import com.repackage.ys4;
import com.squareup.wire.Wire;
/* loaded from: classes3.dex */
public class PushDialogStatic {
    public static /* synthetic */ Interceptable $ic;
    public static Wire a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements CustomMessageTask.CustomRunnable {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                PushDialogLoopManager.i();
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements CustomMessageTask.CustomRunnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes3.dex */
        public class a implements dq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbPageContextSupport a;

            public a(b bVar, TbPageContextSupport tbPageContextSupport) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, tbPageContextSupport};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = tbPageContextSupport;
            }

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                    dq4Var.dismiss();
                    Intent intent = new Intent();
                    intent.setAction("miui.intent.action.APP_PERM_EDITOR_PRIVATE");
                    intent.putExtra("extra_pkgname", this.a.getPageContext().getPageActivity().getPackageName());
                    intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                    try {
                        this.a.getPageContext().getPageActivity().startActivity(intent);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        /* renamed from: com.baidu.tieba.pushdialog.PushDialogStatic$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0230b implements dq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbPageContextSupport a;

            public C0230b(b bVar, TbPageContextSupport tbPageContextSupport) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, tbPageContextSupport};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = tbPageContextSupport;
            }

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                    dq4Var.dismiss();
                    Intent intent = new Intent();
                    intent.setAction("com.iqoo.secure.PERMISSION_MANAGER");
                    intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                    try {
                        this.a.getPageContext().getPageActivity().startActivity(intent);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements dq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public c(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
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

        public b() {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage customMessage) {
            InterceptResult invokeL;
            dq4.e eVar;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof TbPageContextSupport)) {
                    int l = ys4.k().l("lock_permission_guide_set", 0);
                    if (!(l >= 2) && TbSingleton.getInstance().canShowPermDialog()) {
                        TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) customMessage.getData();
                        if (tbPageContextSupport.getPageContext() != null && tbPageContextSupport.getPageContext().getPageActivity() != null) {
                            if (c68.a()) {
                                eVar = new a(this, tbPageContextSupport);
                                i = R.string.obfuscated_res_0x7f0f0f2c;
                            } else if (c68.b()) {
                                eVar = new C0230b(this, tbPageContextSupport);
                                i = R.string.obfuscated_res_0x7f0f0f2d;
                            } else {
                                eVar = null;
                                i = 0;
                            }
                            if (eVar != null) {
                                dq4 dq4Var = new dq4(tbPageContextSupport.getPageContext().getPageActivity());
                                dq4Var.setTitle(R.string.obfuscated_res_0x7f0f0f2e);
                                dq4Var.setMessageId(i);
                                dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f07bc, eVar);
                                dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f081f, new c(this));
                                dq4Var.create(tbPageContextSupport.getPageContext());
                                dq4Var.show();
                                TbSingleton.getInstance().setHasShowPermDlg(true);
                                TbSingleton.getInstance().setExceptInsertAdDiaShow(true);
                            }
                            ys4.k().w("lock_permission_guide_set", l + 1);
                        }
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1667037972, "Lcom/baidu/tieba/pushdialog/PushDialogStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1667037972, "Lcom/baidu/tieba/pushdialog/PushDialogStatic;");
                return;
            }
        }
        a = new Wire(new Class[0]);
        TbadkApplication.getInst().RegisterIntent(PushDialogActivityConfig.class, PushDialogActivity.class);
        a();
    }

    public PushDialogStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            ig8.h(309614, PushDialogSocketResMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PUSH_DIALOG_DATA, ig8.a(TbConfig.GET_PUSH_DIALOG_DETAIL, 309614));
            tbHttpMessageTask.setResponsedClass(PushDialogHttpResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            ig8.h(309618, PullTidSocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PUSH_DIALOG_TID, ig8.a(TbConfig.GET_PUSH_DIALOG_TID, 309618));
            tbHttpMessageTask2.setResponsedClass(PullTidHttpRespMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask2);
            CustomMessageTask customMessageTask = new CustomMessageTask(2921359, new a());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(2921360, new b());
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
        }
    }
}
