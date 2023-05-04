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
public class ip5 {
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
        public final /* synthetic */ ip5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ip5 ip5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ip5Var, Integer.valueOf(i)};
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
            this.a = ip5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                ip5 ip5Var = this.a;
                ip5Var.c(ip5Var.b, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ip5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ip5 ip5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ip5Var, Integer.valueOf(i)};
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
            this.a = ip5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                ip5 ip5Var = this.a;
                ip5Var.c(ip5Var.b, customResponsedMessage);
            }
        }
    }

    public ip5(BdTypeRecyclerView bdTypeRecyclerView) {
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
        f05 f05Var;
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
                        if (item instanceof ax4) {
                            ax4 ax4Var = (ax4) item;
                            if (ax4Var.getThreadData() != null && ax4Var.getThreadData().getThreadAlaInfo() != null && optString2.equals(String.valueOf(ax4Var.getThreadData().getThreadAlaInfo().live_id))) {
                                optString = ax4Var.getThreadData().getTid();
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
                if ((next instanceof ax4) && (threadData2 = ((ax4) next).getThreadData()) != null && !TextUtils.isEmpty(threadData2.getTid()) && optString.equals(threadData2.getTid())) {
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
                if ((next2 instanceof f05) && (threadData = (f05Var = (f05) next2).t) != null) {
                    if (i2 >= 0) {
                        if (f05Var.position != i2) {
                            break;
                        }
                        it2.remove();
                        i4 = i5;
                    } else if (StringHelper.equals(optString, threadData.getTid())) {
                        i2 = f05Var.position;
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

    public zo5 d(LoadType loadType, ap5 ap5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, loadType, ap5Var)) == null) {
            if (ap5Var == null) {
                zo5 zo5Var = new zo5();
                zo5Var.a = null;
                return zo5Var;
            }
            List<ThreadData> f = ap5Var.f();
            List<ax4> e = ap5Var.e();
            ap5Var.h(f);
            sp5.b("response threadList =  " + ListUtils.getCount(f));
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
            sp5.b("dataList = " + ListUtils.getCount(arrayList));
            sp5.b("floorList = " + ListUtils.getCount(e));
            if (!ListUtils.isEmpty(e)) {
                for (ax4 ax4Var : e) {
                    tp5.b(arrayList, ax4Var);
                }
            }
            List<in> d = ap5Var.d(arrayList);
            if (d == null) {
                d = tp5.a(arrayList);
            }
            int count = ListUtils.getCount(d);
            int count2 = ListUtils.getCount(f);
            sp5.b("addThreadCount=" + count2 + ",resultThreadList=" + count);
            zo5 zo5Var2 = new zo5();
            zo5Var2.a = d;
            ap5Var.g(zo5Var2);
            return zo5Var2;
        }
        return (zo5) invokeLL.objValue;
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
