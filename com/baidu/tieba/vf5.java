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
/* loaded from: classes6.dex */
public class vf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public BdTypeRecyclerView b;
    public final List<Cdo> c;
    public CustomMessageListener d;
    public CustomMessageListener e;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vf5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(vf5 vf5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf5Var, Integer.valueOf(i)};
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
            this.a = vf5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                vf5 vf5Var = this.a;
                vf5Var.c(vf5Var.b, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vf5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(vf5 vf5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf5Var, Integer.valueOf(i)};
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
            this.a = vf5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                vf5 vf5Var = this.a;
                vf5Var.c(vf5Var.b, customResponsedMessage);
            }
        }
    }

    public vf5(BdTypeRecyclerView bdTypeRecyclerView) {
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
        bu4 bu4Var;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bdTypeRecyclerView, customResponsedMessage) == null) || bdTypeRecyclerView == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
            return;
        }
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
                    Cdo B = bdTypeRecyclerView.B(i);
                    if (B instanceof yq4) {
                        yq4 yq4Var = (yq4) B;
                        if (yq4Var.getThreadData() != null && yq4Var.getThreadData().getThreadAlaInfo() != null && optString2.equals(String.valueOf(yq4Var.getThreadData().getThreadAlaInfo().live_id))) {
                            optString = yq4Var.getThreadData().getTid();
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
        Iterator<Cdo> it = this.c.iterator();
        while (it.hasNext()) {
            Cdo next = it.next();
            if ((next instanceof yq4) && (threadData2 = ((yq4) next).getThreadData()) != null && !TextUtils.isEmpty(threadData2.getTid()) && optString.equals(threadData2.getTid())) {
                it.remove();
            }
        }
        List<Cdo> data = bdTypeRecyclerView.getData();
        if (ListUtils.isEmpty(data)) {
            return;
        }
        Iterator<Cdo> it2 = data.iterator();
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = 0;
        while (it2.hasNext()) {
            Cdo next2 = it2.next();
            if ((next2 instanceof bu4) && (threadData = (bu4Var = (bu4) next2).t) != null) {
                if (i2 >= 0) {
                    if (bu4Var.position != i2) {
                        break;
                    }
                    it2.remove();
                    i4 = i5;
                } else if (StringHelper.equals(optString, threadData.getTid())) {
                    i2 = bu4Var.position;
                    it2.remove();
                    i3 = i5;
                }
            }
            i5++;
        }
        if (i3 < i4) {
            bdTypeRecyclerView.E(i3, i4);
        }
    }

    public mf5 d(LoadType loadType, nf5 nf5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, loadType, nf5Var)) == null) {
            if (nf5Var == null) {
                mf5 mf5Var = new mf5();
                mf5Var.a = null;
                return mf5Var;
            }
            List<ThreadData> f = nf5Var.f();
            List<yq4> e = nf5Var.e();
            nf5Var.h(f);
            fg5.b("response threadList =  " + ListUtils.getCount(f));
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
            fg5.b("dataList = " + ListUtils.getCount(arrayList));
            fg5.b("floorList = " + ListUtils.getCount(e));
            if (!ListUtils.isEmpty(e)) {
                for (yq4 yq4Var : e) {
                    gg5.b(arrayList, yq4Var);
                }
            }
            List<Cdo> d = nf5Var.d(arrayList);
            if (d == null) {
                d = gg5.a(arrayList);
            }
            int count = ListUtils.getCount(d);
            int count2 = ListUtils.getCount(f);
            fg5.b("addThreadCount=" + count2 + ",resultThreadList=" + count);
            mf5 mf5Var2 = new mf5();
            mf5Var2.a = d;
            nf5Var.g(mf5Var2);
            return mf5Var2;
        }
        return (mf5) invokeLL.objValue;
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
