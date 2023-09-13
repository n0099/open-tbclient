package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import com.baidu.tieba.ij5;
import com.baidu.tieba.x47;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class y47 extends ij5 {
    public static /* synthetic */ Interceptable $ic;
    public static y47 b;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<lj5> a;

    @Override // com.baidu.tieba.ij5
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y47 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(y47 y47Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y47Var, Integer.valueOf(i)};
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
            this.a = y47Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001444) {
                Object data = customResponsedMessage.getData();
                if (data == null || !(data instanceof SingleBarEmotionRecommendData)) {
                    this.a.g(null);
                    return;
                }
                SingleBarEmotionRecommendData singleBarEmotionRecommendData = (SingleBarEmotionRecommendData) data;
                LinkedList linkedList = new LinkedList();
                if (singleBarEmotionRecommendData == null || TextUtils.isEmpty(singleBarEmotionRecommendData.pkg_id) || TextUtils.isEmpty(singleBarEmotionRecommendData.cover)) {
                    this.a.g(null);
                    return;
                }
                linkedList.add(singleBarEmotionRecommendData);
                this.a.g(linkedList);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements x47.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(y47 y47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.x47.b
        public void a(x47 x47Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x47Var) == null) {
                MessageManager.getInstance().runTask(2004603, (Class) null);
            }
        }
    }

    public y47() {
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

    public static y47 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (y47.class) {
                    if (b == null) {
                        b = new y47();
                    }
                }
            }
            return b;
        }
        return (y47) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ij5
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().registerListener(new a(this, 2001444));
        }
    }

    @Override // com.baidu.tieba.ij5
    public void b(ij5.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && FileHelper.checkSD() && this.a != null) {
            for (int i = 0; i < this.a.size(); i++) {
                x47 x47Var = (x47) this.a.get(i);
                if (x47Var.u() && je9.i().g(x47Var.f()) == null && aVar != null) {
                    aVar.a(x47Var);
                }
            }
        }
    }

    public final synchronized void g(List<h47> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            synchronized (this) {
                if (list != null) {
                    if (!list.isEmpty()) {
                        if (this.a != null) {
                            this.a = null;
                        }
                        LinkedList<lj5> linkedList = new LinkedList<>();
                        boolean z = false;
                        for (h47 h47Var : list) {
                            if (h47Var != null && !StringUtils.isNull(h47Var.getGroupId()) && h47Var.IsValid()) {
                                x47 x47Var = new x47(h47Var);
                                linkedList.add(x47Var);
                                z = x47Var.v(h47Var, new b(this));
                            }
                        }
                        this.a = linkedList;
                        if (z) {
                            MessageManager.getInstance().runTask(2004603, (Class) null);
                        }
                    }
                }
                if (this.a != null) {
                    this.a = null;
                    MessageManager.getInstance().runTask(2004603, (Class) null);
                }
            }
        }
    }
}
