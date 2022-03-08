package com.baidu.tieba.newfaceshop.nativemotionmanager.model;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.data.EmotionManageResponseMessage;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.data.NativeManageEmotionModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class MyEmotionManagerModel extends NativeManageEmotionModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.p2.h.e.a.a f44807e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f44808f;

    /* renamed from: g  reason: collision with root package name */
    public List<EmotionPackageData> f44809g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<BaseFragmentActivity> f44810h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f44811i;

    /* renamed from: j  reason: collision with root package name */
    public final HttpMessageListener f44812j;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyEmotionManagerModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MyEmotionManagerModel myEmotionManagerModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionManagerModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myEmotionManagerModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Pair)) {
                Pair pair = (Pair) customResponsedMessage.getData();
                this.a.L(((Integer) pair.first).intValue(), ((Integer) pair.second).intValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyEmotionManagerModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MyEmotionManagerModel myEmotionManagerModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionManagerModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myEmotionManagerModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003385 && (httpResponsedMessage instanceof EmotionManageResponseMessage)) {
                EmotionManageResponseMessage emotionManageResponseMessage = (EmotionManageResponseMessage) httpResponsedMessage;
                if (this.a.f44807e != null) {
                    if (emotionManageResponseMessage.data != null) {
                        this.a.f44809g.clear();
                        if (emotionManageResponseMessage.data.data != null) {
                            this.a.f44809g.addAll(emotionManageResponseMessage.data.data);
                        }
                        Pair E = this.a.E(emotionManageResponseMessage.data.data);
                        this.a.f44807e.onSuccess(new Pair(E.first, E.second));
                        return;
                    }
                    this.a.f44807e.onFail();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MyEmotionManagerModel f44813e;

        public c(MyEmotionManagerModel myEmotionManagerModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionManagerModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44813e = myEmotionManagerModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44813e.N();
                List<MyEmotionGroupData> f2 = c.a.r0.p2.c.i().f();
                JSONArray jSONArray = new JSONArray();
                if (f2 != null && !f2.isEmpty()) {
                    for (MyEmotionGroupData myEmotionGroupData : f2) {
                        if (myEmotionGroupData != null) {
                            jSONArray.put(myEmotionGroupData.getGroupId());
                            this.f44813e.P(myEmotionGroupData.getGroupId());
                        }
                    }
                }
                if (this.f44813e.f44807e != null) {
                    MyEmotionManagerModel myEmotionManagerModel = this.f44813e;
                    Pair E = myEmotionManagerModel.E(myEmotionManagerModel.f44809g);
                    this.f44813e.f44807e.onSuccess(new Pair(E.first, E.second));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MyEmotionManagerModel f44814e;

        public d(MyEmotionManagerModel myEmotionManagerModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionManagerModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44814e = myEmotionManagerModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44814e.N();
                List<MyEmotionGroupData> f2 = c.a.r0.p2.c.i().f();
                JSONArray jSONArray = new JSONArray();
                if (f2 != null && !f2.isEmpty()) {
                    for (MyEmotionGroupData myEmotionGroupData : f2) {
                        if (myEmotionGroupData != null) {
                            jSONArray.put(myEmotionGroupData.getGroupId());
                            this.f44814e.P(myEmotionGroupData.getGroupId());
                        }
                    }
                }
                MyEmotionManagerModel myEmotionManagerModel = this.f44814e;
                c.a.d.f.m.e.a().post(new g(myEmotionManagerModel, myEmotionManagerModel, jSONArray));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MyEmotionManagerModel f44815e;

        public e(MyEmotionManagerModel myEmotionManagerModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionManagerModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44815e = myEmotionManagerModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f44815e.f44807e == null) {
                return;
            }
            this.f44815e.f44807e.redraw();
            if (c.a.r0.p2.h.a.b().a()) {
                return;
            }
            this.f44815e.K();
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MyEmotionManagerModel f44816e;

        public f(MyEmotionManagerModel myEmotionManagerModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionManagerModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44816e = myEmotionManagerModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.p2.c.i().j(this.f44816e.G(), true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<MyEmotionManagerModel> f44817e;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f44818f;

        public g(MyEmotionManagerModel myEmotionManagerModel, MyEmotionManagerModel myEmotionManagerModel2, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionManagerModel, myEmotionManagerModel2, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44817e = new WeakReference<>(myEmotionManagerModel2);
            this.f44818f = jSONArray;
            if (jSONArray == null) {
                this.f44818f = new JSONArray();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            MyEmotionManagerModel myEmotionManagerModel;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (myEmotionManagerModel = this.f44817e.get()) == null) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_EMOTION_MINE_MANAGER);
            httpMessage.addParam("ids", this.f44818f);
            myEmotionManagerModel.sendMessage(httpMessage);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyEmotionManagerModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44811i = new a(this, 2921312);
        this.f44812j = new b(this, CmdConfigHttp.CMD_GET_EMOTION_MINE_MANAGER);
        this.f44810h = tbPageContext;
        this.f44808f = new ArrayList();
        this.f44809g = new ArrayList();
        registerTask();
        this.f44812j.setTag(getUniqueId());
        this.f44812j.setSelfListener(true);
        registerListener(this.f44812j);
        registerListener(this.f44811i);
    }

    public final Pair<List<EmotionPackageData>, Integer> E(List<EmotionPackageData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (list == null) {
                return new Pair<>(arrayList, 0);
            }
            int size = list.size();
            String id = TbadkCoreApplication.getCurrentAccountObj().getID();
            if (id == null) {
                id = "";
            }
            List<String> G = G();
            for (String str : G) {
                EmotionPackageData F = F(str, list);
                if (F != null) {
                    F.ishasdownload = true;
                    F.typeofemotion = H(F, id);
                    arrayList.add(F);
                }
            }
            int size2 = arrayList.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                EmotionPackageData emotionPackageData = list.get(i2);
                if (emotionPackageData.status == 1 && !G.contains(String.valueOf(emotionPackageData.id))) {
                    if (!z) {
                        emotionPackageData.isUndownloadheader = true;
                        z = true;
                    }
                    emotionPackageData.ishasdownload = false;
                    int H = H(emotionPackageData, id);
                    emotionPackageData.typeofemotion = H;
                    if (H == 1) {
                        arrayList2.add(emotionPackageData);
                    }
                }
            }
            arrayList.addAll(arrayList2);
            return new Pair<>(arrayList, Integer.valueOf(size2));
        }
        return (Pair) invokeL.objValue;
    }

    public final synchronized EmotionPackageData F(String str, List<EmotionPackageData> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list)) == null) {
            synchronized (this) {
                if (str == null || list == null) {
                    return null;
                }
                try {
                    for (EmotionPackageData emotionPackageData : list) {
                        if (Integer.valueOf(str).intValue() == emotionPackageData.id) {
                            return emotionPackageData;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (EmotionPackageData) invokeLL.objValue;
    }

    public final synchronized List<String> G() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList(this.f44808f);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final synchronized int H(EmotionPackageData emotionPackageData, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, emotionPackageData, str)) == null) {
            synchronized (this) {
                if (emotionPackageData == null) {
                    return 0;
                }
                if (str.equals(emotionPackageData.owner)) {
                    return 1;
                }
                return emotionPackageData.forum_id > 0 ? 2 : 0;
            }
        }
        return invokeLL.intValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.r0.p2.a.b().a(new c(this));
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f44812j != null) {
                MessageManager.getInstance().unRegisterListener(this.f44812j);
            }
            if (this.f44811i != null) {
                MessageManager.getInstance().unRegisterListener(this.f44811i);
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (c.a.r0.p2.d.m().o()) {
                n.M(this.f44810h.getPageActivity(), R.string.face_group_is_syncing);
            } else {
                c.a.r0.p2.a.b().a(new f(this));
            }
        }
    }

    public final synchronized void L(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            synchronized (this) {
                try {
                    this.f44808f.add(i3, this.f44808f.remove(i2));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.d.f.m.e.a().post(new e(this));
        }
    }

    public final synchronized void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                this.f44808f.clear();
            }
        }
    }

    public void O(c.a.r0.p2.h.e.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f44807e = aVar;
        }
    }

    public final synchronized void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            synchronized (this) {
                this.f44808f.add(str);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            c.a.r0.p2.a.b().a(new d(this));
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_EMOTION_MINE_MANAGER, TbConfig.SERVER_ADDRESS + "c/e/meme/mgetmeme");
            tbHttpMessageTask.setResponsedClass(EmotionManageResponseMessage.class);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
