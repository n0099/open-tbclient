package com.baidu.tieba;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.p55;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final pfa b;
    public final aga c;
    public long d;
    public d e;

    /* loaded from: classes7.dex */
    public class a implements gn0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nga a;

        public a(nga ngaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ngaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ngaVar;
        }

        @Override // com.baidu.tieba.gn0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e.sendEmptyMessage(1);
            }
        }

        @Override // com.baidu.tieba.gn0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.e.sendEmptyMessage(1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nga a;

        public b(nga ngaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ngaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ngaVar;
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
                if (this.a.c != null && this.a.c.d() != null) {
                    this.a.c.d().b();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nga a;

        public c(nga ngaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ngaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ngaVar;
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                try {
                    this.a.a.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    p55Var.dismiss();
                } catch (Exception unused) {
                    this.a.a.showToast(R.string.goto_developActivity_error_toast);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nga a;

        public d(nga ngaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ngaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ngaVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                this.a.g();
            }
        }

        public /* synthetic */ d(nga ngaVar, a aVar) {
            this(ngaVar);
        }
    }

    public nga(MainTabActivity mainTabActivity, pfa pfaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, pfaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 0L;
        this.e = new d(this, null);
        this.a = mainTabActivity;
        this.b = pfaVar;
        this.c = mainTabActivity.e;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new p55(this.a).setTitle(R.string.confirm_title).setCancelable(false).setMessageId(R.string.background_process_permission).setPositiveButton(R.string.now_goto_setting, new c(this)).setNegativeButton(R.string.next_time, new b(this)).create(r9.a(this.a)).show();
        }
    }

    public boolean f(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keyEvent)) == null) {
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return false;
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016322, (Class) null);
            if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                return true;
            }
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2016323, (Class) null);
            if (runTask2 != null && ((Boolean) runTask2.getData()).booleanValue()) {
                return true;
            }
            ota otaVar = this.a.q;
            if (otaVar != null && otaVar.b()) {
                this.a.q.a(true);
                return true;
            } else if (this.b.A()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007010));
                return true;
            } else {
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.FALSE);
                if (runTask3 != null && runTask3.getData() != null && (runTask3.getData() instanceof Boolean) && ((Boolean) runTask3.getData()).booleanValue()) {
                    return true;
                }
                if (System.currentTimeMillis() - this.d > 2000) {
                    this.a.showToast(R.string.double_back_quit);
                    this.d = System.currentTimeMillis();
                } else {
                    in0.f().l();
                    in0.f().i(this.a, new a(this));
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                e();
                return;
            }
            aga agaVar = this.c;
            if (agaVar != null && agaVar.d() != null) {
                this.c.d().b();
            }
        }
    }
}
