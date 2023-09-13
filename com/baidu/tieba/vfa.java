package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
/* loaded from: classes8.dex */
public class vfa {
    public static /* synthetic */ Interceptable $ic;
    public static vfa g;
    public transient /* synthetic */ FieldHolder $fh;
    public final ufa a;
    public int b;
    public SparseArray<HashSet<String>> c;
    public c d;
    public Handler e;
    public CustomMessageListener f;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(vfa vfaVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vfaVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 5) {
                    Object obj = message.obj;
                    if ((obj instanceof c) && (cVar = (c) obj) != null) {
                        cVar.d = false;
                        cVar.a = false;
                        cVar.b = 0;
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vfa a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(vfa vfaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vfaVar, Integer.valueOf(i)};
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
            this.a = vfaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.c != null) {
                this.a.c.clear();
            }
            this.a.a.g();
        }
    }

    /* loaded from: classes8.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public int b;
        public long c;
        public boolean d;

        public c(vfa vfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
            this.b = 0;
            this.c = 0L;
            this.d = false;
        }

        public /* synthetic */ c(vfa vfaVar, a aVar) {
            this(vfaVar);
        }
    }

    public vfa() {
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
        this.e = new a(this, Looper.getMainLooper());
        this.f = new b(this, 2005016);
        this.b = SharedPrefHelper.getInstance().getInt("card_show_statistic_max_count", 200);
        this.a = new ufa();
        MessageManager.getInstance().registerListener(this.f);
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.d == null) {
                this.d = new c(this, null);
            }
            if (this.d.d) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            c cVar = this.d;
            if (cVar.a) {
                int i = cVar.b + 1;
                cVar.b = i;
                if (currentTimeMillis - cVar.c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                    if (i >= this.b) {
                        cVar.d = true;
                        f(cVar);
                        return true;
                    }
                } else {
                    cVar.a = false;
                    cVar.b = 0;
                }
            } else {
                cVar.a = true;
                cVar.c = currentTimeMillis;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            Message obtainMessage = this.e.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = cVar;
            this.e.removeMessages(5);
            this.e.sendMessageDelayed(obtainMessage, 300000L);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            BdUtilHelper.checkMainThread();
            if (bdUniqueId == null) {
                return;
            }
            this.a.f(bdUniqueId);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        SparseArray<HashSet<String>> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) && (sparseArray = this.c) != null) {
            sparseArray.remove(bdUniqueId.getId());
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            BdUtilHelper.checkMainThread();
            if (bdUniqueId == null) {
                return;
            }
            this.a.h(bdUniqueId);
            j(bdUniqueId);
        }
    }

    public static vfa g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (g == null) {
                synchronized (vfa.class) {
                    if (g == null) {
                        g = new vfa();
                    }
                }
            }
            return g;
        }
        return (vfa) invokeV.objValue;
    }

    public void c(BdUniqueId bdUniqueId, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bdUniqueId, statisticItem) == null) {
            this.a.d(bdUniqueId, true);
            TiebaStatic.log(statisticItem);
        }
    }

    public void h(BdUniqueId bdUniqueId, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, bdUniqueId, z) == null) {
            if (BdLog.isDebugMode()) {
                BdLog.d("logStatisticByKey start write log ");
            }
            this.a.d(bdUniqueId, z);
        }
    }

    public void d(BdUniqueId bdUniqueId, String str, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId, str, statisticItem) == null) && bdUniqueId != null && statisticItem != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.a.c(bdUniqueId)) {
                BdLog.e("error, bdUniqueId not register");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                BdLog.e("id is null, statistic key is=" + statisticItem.getKey());
            }
            if (this.c == null) {
                this.c = new SparseArray<>();
            }
            HashSet<String> hashSet = this.c.get(bdUniqueId.getId());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.c.put(bdUniqueId.getId(), hashSet);
            }
            String str2 = statisticItem.getKey() + "_" + str;
            if (hashSet.contains(str2) || e()) {
                return;
            }
            hashSet.add(str2);
            this.a.a(bdUniqueId, statisticItem);
            if (BdLog.isDebugMode()) {
                BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }
}
