package com.baidu.tieba.newfaceshop.nativemotionmanager.model;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
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
/* loaded from: classes7.dex */
public class MyEmotionManagerModel extends NativeManageEmotionModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.d2.h.e.a.a f54552e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f54553f;

    /* renamed from: g  reason: collision with root package name */
    public List<EmotionPackageData> f54554g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<BaseFragmentActivity> f54555h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f54556i;

    /* renamed from: j  reason: collision with root package name */
    public final HttpMessageListener f54557j;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyEmotionManagerModel f54558a;

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
            this.f54558a = myEmotionManagerModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Pair)) {
                Pair pair = (Pair) customResponsedMessage.getData();
                this.f54558a.M(((Integer) pair.first).intValue(), ((Integer) pair.second).intValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyEmotionManagerModel f54559a;

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
            this.f54559a = myEmotionManagerModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003385 && (httpResponsedMessage instanceof EmotionManageResponseMessage)) {
                EmotionManageResponseMessage emotionManageResponseMessage = (EmotionManageResponseMessage) httpResponsedMessage;
                if (this.f54559a.f54552e != null) {
                    if (emotionManageResponseMessage.data != null) {
                        this.f54559a.f54554g.clear();
                        if (emotionManageResponseMessage.data.data != null) {
                            this.f54559a.f54554g.addAll(emotionManageResponseMessage.data.data);
                        }
                        Pair E = this.f54559a.E(emotionManageResponseMessage.data.data);
                        this.f54559a.f54552e.onSuccess(new Pair(E.first, E.second));
                        return;
                    }
                    this.f54559a.f54552e.onFail();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MyEmotionManagerModel f54560e;

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
            this.f54560e = myEmotionManagerModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f54560e.O();
                List<MyEmotionGroupData> f2 = c.a.q0.d2.c.i().f();
                JSONArray jSONArray = new JSONArray();
                if (f2 != null && !f2.isEmpty()) {
                    for (MyEmotionGroupData myEmotionGroupData : f2) {
                        if (myEmotionGroupData != null) {
                            jSONArray.put(myEmotionGroupData.getGroupId());
                            this.f54560e.Q(myEmotionGroupData.getGroupId());
                        }
                    }
                }
                MyEmotionManagerModel myEmotionManagerModel = this.f54560e;
                c.a.e.e.m.e.a().post(new g(myEmotionManagerModel, myEmotionManagerModel, jSONArray));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MyEmotionManagerModel f54561e;

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
            this.f54561e = myEmotionManagerModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f54561e.O();
                List<MyEmotionGroupData> f2 = c.a.q0.d2.c.i().f();
                JSONArray jSONArray = new JSONArray();
                if (f2 != null && !f2.isEmpty()) {
                    for (MyEmotionGroupData myEmotionGroupData : f2) {
                        if (myEmotionGroupData != null) {
                            jSONArray.put(myEmotionGroupData.getGroupId());
                            this.f54561e.Q(myEmotionGroupData.getGroupId());
                        }
                    }
                }
                if (this.f54561e.f54552e != null) {
                    MyEmotionManagerModel myEmotionManagerModel = this.f54561e;
                    Pair E = myEmotionManagerModel.E(myEmotionManagerModel.f54554g);
                    this.f54561e.f54552e.onSuccess(new Pair(E.first, E.second));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MyEmotionManagerModel f54562e;

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
            this.f54562e = myEmotionManagerModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f54562e.f54552e == null) {
                return;
            }
            this.f54562e.f54552e.redraw();
            if (c.a.q0.d2.h.a.b().a()) {
                return;
            }
            this.f54562e.L();
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MyEmotionManagerModel f54563e;

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
            this.f54563e = myEmotionManagerModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.d2.c.i().j(this.f54563e.G(), true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<MyEmotionManagerModel> f54564e;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f54565f;

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
            this.f54564e = new WeakReference<>(myEmotionManagerModel2);
            this.f54565f = jSONArray;
            if (jSONArray == null) {
                this.f54565f = new JSONArray();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            MyEmotionManagerModel myEmotionManagerModel;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (myEmotionManagerModel = this.f54564e.get()) == null) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_EMOTION_MINE_MANAGER);
            httpMessage.addParam("ids", this.f54565f);
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54556i = new a(this, 2921312);
        this.f54557j = new b(this, CmdConfigHttp.CMD_GET_EMOTION_MINE_MANAGER);
        this.f54555h = tbPageContext;
        this.f54553f = new ArrayList();
        this.f54554g = new ArrayList();
        registerTask();
        this.f54557j.setTag(getUniqueId());
        this.f54557j.setSelfListener(true);
        registerListener(this.f54557j);
        registerListener(this.f54556i);
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
                arrayList = new ArrayList(this.f54553f);
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
            LoadData();
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.q0.d2.a.b().a(new d(this));
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f54557j != null) {
                MessageManager.getInstance().unRegisterListener(this.f54557j);
            }
            if (this.f54556i != null) {
                MessageManager.getInstance().unRegisterListener(this.f54556i);
            }
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (c.a.q0.d2.d.m().o()) {
                l.L(this.f54555h.getPageActivity(), R.string.face_group_is_syncing);
            } else {
                c.a.q0.d2.a.b().a(new f(this));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.q0.d2.a.b().a(new c(this));
            return false;
        }
        return invokeV.booleanValue;
    }

    public final synchronized void M(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            synchronized (this) {
                try {
                    this.f54553f.add(i3, this.f54553f.remove(i2));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.e.e.m.e.a().post(new e(this));
        }
    }

    public final synchronized void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                this.f54553f.clear();
            }
        }
    }

    public void P(c.a.q0.d2.h.e.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.f54552e = aVar;
        }
    }

    public final synchronized void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            synchronized (this) {
                this.f54553f.add(str);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
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
