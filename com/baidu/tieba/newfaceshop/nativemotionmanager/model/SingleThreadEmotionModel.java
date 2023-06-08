package com.baidu.tieba.newfaceshop.nativemotionmanager.model;

import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.o09;
import com.baidu.tieba.rz8;
import com.baidu.tieba.uz8;
import com.baidu.tieba.wg;
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
public class SingleThreadEmotionModel extends NativeManageEmotionModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o09 a;
    public List<String> b;
    public final HttpMessageListener c;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SingleThreadEmotionModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SingleThreadEmotionModel singleThreadEmotionModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleThreadEmotionModel, Integer.valueOf(i)};
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
            this.a = singleThreadEmotionModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003386 && (httpResponsedMessage instanceof SingleThreadEmotionResponseMessage)) {
                SingleThreadEmotionResponseMessage singleThreadEmotionResponseMessage = (SingleThreadEmotionResponseMessage) httpResponsedMessage;
                if (this.a.a != null) {
                    if (singleThreadEmotionResponseMessage.data != null) {
                        this.a.a.onSuccess(this.a.Y(singleThreadEmotionResponseMessage.data.pkg_list));
                    } else {
                        this.a.a.onFail();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SingleThreadEmotionModel a;

        public b(SingleThreadEmotionModel singleThreadEmotionModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleThreadEmotionModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = singleThreadEmotionModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b0();
                List<MyEmotionGroupData> f = uz8.i().f();
                JSONArray jSONArray = new JSONArray();
                if (f != null && !f.isEmpty()) {
                    for (MyEmotionGroupData myEmotionGroupData : f) {
                        if (myEmotionGroupData != null) {
                            jSONArray.put(myEmotionGroupData.getGroupId());
                            this.a.d0(myEmotionGroupData.getGroupId());
                        }
                    }
                }
                SingleThreadEmotionModel singleThreadEmotionModel = this.a;
                wg.a().post(new c(singleThreadEmotionModel, singleThreadEmotionModel));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<SingleThreadEmotionModel> a;

        public c(SingleThreadEmotionModel singleThreadEmotionModel, SingleThreadEmotionModel singleThreadEmotionModel2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleThreadEmotionModel, singleThreadEmotionModel2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(singleThreadEmotionModel2);
        }

        @Override // java.lang.Runnable
        public void run() {
            SingleThreadEmotionModel singleThreadEmotionModel;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (singleThreadEmotionModel = this.a.get()) != null) {
                singleThreadEmotionModel.sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_EMOTION_SINGLE_THREAD));
            }
        }
    }

    public SingleThreadEmotionModel() {
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
        this.c = new a(this, CmdConfigHttp.CMD_GET_EMOTION_SINGLE_THREAD);
        this.b = new ArrayList();
        registerTask();
        this.c.setTag(getUniqueId());
        this.c.setSelfListener(true);
        registerListener(this.c);
    }

    public void c0(o09 o09Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, o09Var) == null) {
            this.a = o09Var;
        }
    }

    public final synchronized void d0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            synchronized (this) {
                this.b.add(str);
            }
        }
    }

    public final List<EmotionPackageData> Y(List<EmotionPackageData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                List<String> Z = Z();
                for (EmotionPackageData emotionPackageData : list) {
                    int i = emotionPackageData.status;
                    if (i == 5 || i == 1) {
                        if (emotionPackageData.status == 1 && Z.contains(String.valueOf(emotionPackageData.id))) {
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

    public final synchronized List<String> Z() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList(this.b);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.c != null) {
            MessageManager.getInstance().unRegisterListener(this.c);
        }
    }

    public final synchronized void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.b.clear();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            rz8.b().a(new b(this));
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
