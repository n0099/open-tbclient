package com.baidu.tieba.newfaceshop.nativemotionmanager.model;

import androidx.core.view.InputDeviceCompat;
import b.a.e.e.m.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.data.NativeManageEmotionModel;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.data.SingleThreadEmotionResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class SingleThreadEmotionModel extends NativeManageEmotionModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.f2.h.e.a.a f51930e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f51931f;

    /* renamed from: g  reason: collision with root package name */
    public final HttpMessageListener f51932g;

    /* loaded from: classes9.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SingleThreadEmotionModel f51933a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SingleThreadEmotionModel singleThreadEmotionModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleThreadEmotionModel, Integer.valueOf(i2)};
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
            this.f51933a = singleThreadEmotionModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003386 && (httpResponsedMessage instanceof SingleThreadEmotionResponseMessage)) {
                SingleThreadEmotionResponseMessage singleThreadEmotionResponseMessage = (SingleThreadEmotionResponseMessage) httpResponsedMessage;
                if (this.f51933a.f51930e != null) {
                    if (singleThreadEmotionResponseMessage.data != null) {
                        this.f51933a.f51930e.onSuccess(this.f51933a.A(singleThreadEmotionResponseMessage.data.pkg_list));
                    } else {
                        this.f51933a.f51930e.onFail();
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SingleThreadEmotionModel f51934e;

        public b(SingleThreadEmotionModel singleThreadEmotionModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleThreadEmotionModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51934e = singleThreadEmotionModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51934e.D();
                List<MyEmotionGroupData> f2 = b.a.r0.f2.c.i().f();
                JSONArray jSONArray = new JSONArray();
                if (f2 != null && !f2.isEmpty()) {
                    for (MyEmotionGroupData myEmotionGroupData : f2) {
                        if (myEmotionGroupData != null) {
                            jSONArray.put(myEmotionGroupData.getGroupId());
                            this.f51934e.F(myEmotionGroupData.getGroupId());
                        }
                    }
                }
                SingleThreadEmotionModel singleThreadEmotionModel = this.f51934e;
                e.a().post(new c(singleThreadEmotionModel, singleThreadEmotionModel));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<SingleThreadEmotionModel> f51935e;

        public c(SingleThreadEmotionModel singleThreadEmotionModel, SingleThreadEmotionModel singleThreadEmotionModel2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleThreadEmotionModel, singleThreadEmotionModel2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51935e = new WeakReference<>(singleThreadEmotionModel2);
        }

        @Override // java.lang.Runnable
        public void run() {
            SingleThreadEmotionModel singleThreadEmotionModel;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (singleThreadEmotionModel = this.f51935e.get()) == null) {
                return;
            }
            singleThreadEmotionModel.sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_EMOTION_SINGLE_THREAD));
        }
    }

    public SingleThreadEmotionModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51932g = new a(this, CmdConfigHttp.CMD_GET_EMOTION_SINGLE_THREAD);
        this.f51931f = new ArrayList();
        registerTask();
        this.f51932g.setTag(getUniqueId());
        this.f51932g.setSelfListener(true);
        registerListener(this.f51932g);
    }

    public final List<EmotionPackageData> A(List<EmotionPackageData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                List<String> B = B();
                for (EmotionPackageData emotionPackageData : list) {
                    int i2 = emotionPackageData.status;
                    if (i2 == 5 || i2 == 1) {
                        if (emotionPackageData.status == 1 && B.contains(String.valueOf(emotionPackageData.id))) {
                            emotionPackageData.ishasdownload = true;
                        }
                        arrayList.add(emotionPackageData);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final synchronized List<String> B() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList(this.f51931f);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f51932g == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.f51932g);
    }

    public final synchronized void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.f51931f.clear();
            }
        }
    }

    public void E(b.a.r0.f2.h.e.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f51930e = aVar;
        }
    }

    public final synchronized void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this) {
                this.f51931f.add(str);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b.a.r0.f2.a.b().a(new b(this));
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_EMOTION_SINGLE_THREAD, TbConfig.SERVER_ADDRESS + "c/e/meme/getMyForumPackage");
            tbHttpMessageTask.setResponsedClass(SingleThreadEmotionResponseMessage.class);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
