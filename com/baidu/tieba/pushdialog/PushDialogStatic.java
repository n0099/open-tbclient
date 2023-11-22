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
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.dra;
import com.baidu.tieba.lba;
import com.baidu.tieba.pushdialog.data.PullTidHttpRespMessage;
import com.baidu.tieba.pushdialog.data.PullTidSocketResponseMessage;
import com.baidu.tieba.pushdialog.data.PushDialogHttpResMsg;
import com.baidu.tieba.pushdialog.data.PushDialogSocketResMsg;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
/* loaded from: classes7.dex */
public class PushDialogStatic {
    public static /* synthetic */ Interceptable $ic;
    public static Wire a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class b implements CustomMessageTask.CustomRunnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements zz4.e {
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

            @Override // com.baidu.tieba.zz4.e
            public void onClick(zz4 zz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                    zz4Var.dismiss();
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
        /* loaded from: classes7.dex */
        public class C0457b implements zz4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbPageContextSupport a;

            public C0457b(b bVar, TbPageContextSupport tbPageContextSupport) {
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

            @Override // com.baidu.tieba.zz4.e
            public void onClick(zz4 zz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                    zz4Var.dismiss();
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

        /* loaded from: classes7.dex */
        public class c implements zz4.e {
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

            @Override // com.baidu.tieba.zz4.e
            public void onClick(zz4 zz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                    zz4Var.dismiss();
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
            boolean z;
            zz4.e eVar;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof TbPageContextSupport)) {
                    int i2 = SharedPrefHelper.getInstance().getInt("lock_permission_guide_set", 0);
                    if (i2 >= 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z && TbSingleton.getInstance().canShowPermDialog()) {
                        TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) customMessage.getData();
                        if (tbPageContextSupport.getPageContext() != null && tbPageContextSupport.getPageContext().getPageActivity() != null) {
                            if (lba.a()) {
                                eVar = new a(this, tbPageContextSupport);
                                i = R.string.obfuscated_res_0x7f0f11d0;
                            } else if (lba.b()) {
                                eVar = new C0457b(this, tbPageContextSupport);
                                i = R.string.obfuscated_res_0x7f0f11d1;
                            } else {
                                eVar = null;
                                i = 0;
                            }
                            if (eVar != null) {
                                zz4 zz4Var = new zz4(tbPageContextSupport.getPageContext().getPageActivity());
                                zz4Var.setTitle(R.string.obfuscated_res_0x7f0f11d2);
                                zz4Var.setMessageId(i);
                                zz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f091a, eVar);
                                zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09ca, new c(this));
                                zz4Var.create(tbPageContextSupport.getPageContext());
                                zz4Var.show();
                                TbSingleton.getInstance().setHasShowPermDlg(true);
                                TbSingleton.getInstance();
                                TbSingleton.setExceptInsertAdDiaShow(true);
                            }
                            SharedPrefHelper.getInstance().putInt("lock_permission_guide_set", i2 + 1);
                        }
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class a implements CustomMessageTask.CustomRunnable {
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
            dra.h(309614, PushDialogSocketResMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PUSH_DIALOG_DATA, dra.a(TbConfig.GET_PUSH_DIALOG_DETAIL, 309614));
            tbHttpMessageTask.setResponsedClass(PushDialogHttpResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            dra.h(309618, PullTidSocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PUSH_DIALOG_TID, dra.a(TbConfig.GET_PUSH_DIALOG_TID, 309618));
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
