package com.baidu.tieba;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.jv4;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class us8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final zr8 b;
    public final ks8 c;
    public long d;
    public d e;

    /* loaded from: classes6.dex */
    public class a implements ml0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us8 a;

        public a(us8 us8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = us8Var;
        }

        @Override // com.baidu.tieba.ml0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e.sendEmptyMessage(1);
            }
        }

        @Override // com.baidu.tieba.ml0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.e.sendEmptyMessage(1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us8 a;

        public b(us8 us8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = us8Var;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
                if (this.a.c != null && this.a.c.d() != null) {
                    this.a.c.d().b();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us8 a;

        public c(us8 us8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = us8Var;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                try {
                    this.a.a.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    jv4Var.dismiss();
                } catch (Exception unused) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0814);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us8 a;

        public d(us8 us8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = us8Var;
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

        public /* synthetic */ d(us8 us8Var, a aVar) {
            this(us8Var);
        }
    }

    public us8(MainTabActivity mainTabActivity, zr8 zr8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, zr8Var};
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
        this.b = zr8Var;
        this.c = mainTabActivity.e;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new jv4(this.a).setTitle(R.string.obfuscated_res_0x7f0f0448).setCancelable(false).setMessageId(R.string.obfuscated_res_0x7f0f02d4).setPositiveButton(R.string.obfuscated_res_0x7f0f0d0c, new c(this)).setNegativeButton(R.string.obfuscated_res_0x7f0f0c8f, new b(this)).create(x9.a(this.a)).show();
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
            v39 v39Var = this.a.q;
            if (v39Var != null && v39Var.b()) {
                this.a.q.a(true);
                return true;
            } else if (this.b.E()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007010));
                return true;
            } else {
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.FALSE);
                if (runTask3 != null && runTask3.getData() != null && (runTask3.getData() instanceof Boolean) && ((Boolean) runTask3.getData()).booleanValue()) {
                    return true;
                }
                if (System.currentTimeMillis() - this.d > 2000) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0511);
                    this.d = System.currentTimeMillis();
                } else if (!UbsABTestHelper.isExitShowInstallTip()) {
                    g();
                    return false;
                } else {
                    ol0.f().l();
                    ol0.f().i(this.a, new a(this));
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
            ks8 ks8Var = this.c;
            if (ks8Var != null && ks8Var.d() != null) {
                this.c.d().b();
            }
        }
    }
}
