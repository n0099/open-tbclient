package com.baidu.tieba;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.widget.floatball.FullScreenLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class n48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<Activity> a;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n48 n48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n48Var, Integer.valueOf(i)};
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
            this.a = n48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof g45)) {
                this.a.d((g45) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements zz5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(n48 n48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zz5
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                o48.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final n48 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-623312392, "Lcom/baidu/tieba/n48$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-623312392, "Lcom/baidu/tieba/n48$c;");
                    return;
                }
            }
            a = new n48();
        }
    }

    public n48() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashSet();
    }

    public static n48 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return c.a;
        }
        return (n48) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().registerListener(new a(this, 2921698));
        }
    }

    public final void d(g45 g45Var) {
        Activity activity;
        nh5 nh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g45Var) != null) || g45Var == null || (activity = g45Var.b) == null || g45Var.c == null || !"com.duowan.mobile.basemedia.watchlive.activity.LiveTemplateActivity".equals(activity.getClass().getName())) {
            return;
        }
        if (!Lifecycle.Event.ON_START.equals(g45Var.c)) {
            if (Lifecycle.Event.ON_DESTROY.equals(g45Var.c)) {
                this.a.remove(g45Var.b);
            }
        } else if (!this.a.contains(g45Var.b) && (nh5Var = TbSingleton.getInstance().mLiveActivityGuide) != null && nh5Var.isValid()) {
            FullScreenLayout fullScreenLayout = new FullScreenLayout(g45Var.b);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            fullScreenLayout.setFloatData(nh5Var);
            fullScreenLayout.setClickListener(new b(this));
            g45Var.b.addContentView(fullScreenLayout, layoutParams);
            o48.b();
            this.a.add(g45Var.b);
            g45Var.b.getWindow().setCallback(new m48(g45Var.b, fullScreenLayout));
        }
    }
}
