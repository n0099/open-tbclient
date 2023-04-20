package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.template.model.LoadType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class po5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public BdTypeRecyclerView b;
    public final List<in> c;
    public CustomMessageListener d;
    public CustomMessageListener e;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ po5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(po5 po5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po5Var, Integer.valueOf(i)};
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
            this.a = po5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                po5 po5Var = this.a;
                po5Var.c(po5Var.b, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ po5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(po5 po5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po5Var, Integer.valueOf(i)};
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
            this.a = po5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                po5 po5Var = this.a;
                po5Var.c(po5Var.b, customResponsedMessage);
            }
        }
    }

    public po5(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.d = new a(this, 2016488);
        this.e = new b(this, 2016553);
        this.b = bdTypeRecyclerView;
    }

    public final void c(BdTypeRecyclerView bdTypeRecyclerView, CustomResponsedMessage<?> customResponsedMessage) {
        pz4 pz4Var;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bdTypeRecyclerView, customResponsedMessage) == null) && bdTypeRecyclerView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (bdTypeRecyclerView != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= bdTypeRecyclerView.getCount()) {
                            break;
                        }
                        in item = bdTypeRecyclerView.getItem(i);
                        if (item instanceof kw4) {
                            kw4 kw4Var = (kw4) item;
                            if (kw4Var.getThreadData() != null && kw4Var.getThreadData().getThreadAlaInfo() != null && optString2.equals(String.valueOf(kw4Var.getThreadData().getThreadAlaInfo().live_id))) {
                                optString = kw4Var.getThreadData().getTid();
                                break;
                            }
                        }
                        i++;
                    }
                }
            }
            if (StringUtils.isNull(optString)) {
                return;
            }
            Iterator<in> it = this.c.iterator();
            while (it.hasNext()) {
                in next = it.next();
                if ((next instanceof kw4) && (threadData2 = ((kw4) next).getThreadData()) != null && !TextUtils.isEmpty(threadData2.getTid()) && optString.equals(threadData2.getTid())) {
                    it.remove();
                }
            }
            List<in> data = bdTypeRecyclerView.getData();
            if (ListUtils.isEmpty(data)) {
                return;
            }
            Iterator<in> it2 = data.iterator();
            int i2 = -1;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            while (it2.hasNext()) {
                in next2 = it2.next();
                if ((next2 instanceof pz4) && (threadData = (pz4Var = (pz4) next2).t) != null) {
                    if (i2 >= 0) {
                        if (pz4Var.position != i2) {
                            break;
                        }
                        it2.remove();
                        i4 = i5;
                    } else if (StringHelper.equals(optString, threadData.getTid())) {
                        i2 = pz4Var.position;
                        it2.remove();
                        i3 = i5;
                    }
                }
                i5++;
            }
            if (i3 < i4) {
                bdTypeRecyclerView.removeItemList(i3, i4);
            }
        }
    }

    public go5 d(LoadType loadType, ho5 ho5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, loadType, ho5Var)) == null) {
            if (ho5Var == null) {
                go5 go5Var = new go5();
                go5Var.a = null;
                return go5Var;
            }
            List<ThreadData> f = ho5Var.f();
            List<kw4> e = ho5Var.e();
            ho5Var.h(f);
            zo5.b("response threadList =  " + ListUtils.getCount(f));
            if (!ListUtils.isEmpty(f)) {
                if (loadType == LoadType.REFRESH) {
                    this.c.clear();
                    this.c.addAll(f);
                } else if (loadType == LoadType.PREPEND) {
                    this.c.addAll(0, f);
                } else {
                    this.c.addAll(f);
                }
            }
            ArrayList arrayList = new ArrayList(ListUtils.getCount(this.c) + ListUtils.getCount(e));
            arrayList.addAll(this.c);
            zo5.b("dataList = " + ListUtils.getCount(arrayList));
            zo5.b("floorList = " + ListUtils.getCount(e));
            if (!ListUtils.isEmpty(e)) {
                for (kw4 kw4Var : e) {
                    ap5.b(arrayList, kw4Var);
                }
            }
            List<in> d = ho5Var.d(arrayList);
            if (d == null) {
                d = ap5.a(arrayList);
            }
            int count = ListUtils.getCount(d);
            int count2 = ListUtils.getCount(f);
            zo5.b("addThreadCount=" + count2 + ",resultThreadList=" + count);
            go5 go5Var2 = new go5();
            go5Var2.a = d;
            ho5Var.g(go5Var2);
            return go5Var2;
        }
        return (go5) invokeLL.objValue;
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            if (this.a != bdUniqueId) {
                this.d.setTag(bdUniqueId);
                this.e.setTag(bdUniqueId);
                MessageManager.getInstance().unRegisterListener(this.d);
                MessageManager.getInstance().unRegisterListener(this.e);
                MessageManager.getInstance().registerListener(this.d);
                MessageManager.getInstance().registerListener(this.e);
            }
            this.a = bdUniqueId;
        }
    }
}
