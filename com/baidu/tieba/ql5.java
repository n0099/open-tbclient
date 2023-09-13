package com.baidu.tieba;

import android.app.Activity;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public class ql5 {
    public static /* synthetic */ Interceptable $ic;
    public static ql5 m;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Activity b;
    public WindowManager c;
    public View d;
    public pl5 e;
    public boolean f;
    public Runnable g;
    public int h;
    public int i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948095695, "Lcom/baidu/tieba/ql5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948095695, "Lcom/baidu/tieba/ql5;");
        }
    }

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ql5 ql5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ql5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof BackgroundSwitchMessage) || (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            if (data.booleanValue()) {
                this.a.f = true;
                if (this.a.a != null) {
                    ql5 ql5Var = this.a;
                    ql5Var.b = ql5Var.a;
                }
                this.a.i(true);
                return;
            }
            this.a.f = false;
            if (this.a.b != null) {
                ql5 ql5Var2 = this.a;
                ql5Var2.a = ql5Var2.b;
                this.a.b = null;
                if (BdActivityStack.getInst().isExitAt(this.a.a) != -1) {
                    this.a.j();
                    this.a.o(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ql5 ql5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ql5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Map map;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (map = (Map) customResponsedMessage.getData()) != null) {
                String str = (String) map.get("lifeCycle");
                if ("BarBroadcastEditPage".equals((String) map.get("name"))) {
                    if (("0".equals(str) || "1".equals(str)) && (this.a.e instanceof nl5)) {
                        this.a.i(false);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ql5 ql5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ql5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && this.a.d != null && this.a.e != null) {
                this.a.e.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql5 a;

        public d(ql5 ql5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ql5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int isExitAt;
            int size;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.a != null && (isExitAt = BdActivityStack.getInst().isExitAt(this.a.a)) != -1 && isExitAt < BdActivityStack.getInst().getSize() && (size = BdActivityStack.getInst().getSize() - isExitAt) >= 0) {
                    BdActivityStack.getInst().popNumberActivtiy(size);
                }
                if (this.a.e != null) {
                    this.a.e.onClick();
                }
                this.a.i(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(ql5 ql5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 1));
            }
        }
    }

    public ql5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = 85;
        this.i = 0;
        this.j = new a(this, 2001011);
        this.k = new b(this, 2921478);
        this.l = new c(this, 2001304);
    }

    public void m(pl5 pl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pl5Var) == null) {
            this.e = pl5Var;
        }
    }

    public static ql5 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (m == null) {
                m = new ql5();
            }
            return m;
        }
        return (ql5) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.c != null && (view2 = this.d) != null && view2.getParent() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            i(false);
            this.b = null;
            this.a = null;
            this.e = null;
            this.d = null;
            m = null;
            if (this.g != null) {
                SafeHandler.getInst().removeCallbacks(this.g);
            }
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (this.c == null) {
                this.c = (WindowManager) TbadkCoreApplication.getInst().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            }
            View view2 = this.d;
            if (view2 != null && view2.getParent() != null) {
                try {
                    if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                        if (this.c != null && this.d != null) {
                            this.c.removeView(this.d);
                        }
                        this.c = null;
                        this.d = null;
                        return;
                    }
                    this.c.removeView(this.d);
                    this.d = null;
                    this.c = null;
                    if (!z && !this.f) {
                        this.g = new e(this);
                        SafeHandler.getInst().postDelayed(this.g, 300L);
                    }
                } catch (SecurityException unused) {
                    this.c = null;
                    this.d = null;
                }
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            pl5 pl5Var = this.e;
            if (pl5Var == null) {
                return false;
            }
            View view2 = this.d;
            if (view2 == null) {
                View view3 = pl5Var.getView();
                this.d = view3;
                view3.setOnClickListener(new d(this));
                return true;
            } else if (view2.getParent() != null) {
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void n(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048581, this, i, i2, i3) == null) {
            this.h = i;
            this.i = i2;
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = qqa.a(2002);
            layoutParams.flags = 65800;
            layoutParams.format = -3;
            int i = this.i;
            layoutParams.x = i;
            layoutParams.y = i;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = this.h;
            if (this.c == null) {
                this.c = (WindowManager) TbadkCoreApplication.getInst().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            }
            try {
                if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                    this.c = null;
                    this.d = null;
                } else if (j()) {
                    if (this.d != null && this.d.getParent() == null) {
                        this.c.addView(this.d, layoutParams);
                        if (z) {
                            this.a = BdActivityStack.getInst().currentActivity();
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    MessageManager.getInstance().registerListener(this.j);
                    MessageManager.getInstance().registerListener(this.l);
                    MessageManager.getInstance().registerListener(this.k);
                }
            } catch (SecurityException unused) {
                this.c = null;
                this.d = null;
            }
        }
    }
}
