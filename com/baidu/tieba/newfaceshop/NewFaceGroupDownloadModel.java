package com.baidu.tieba.newfaceshop;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.newfaceshop.message.GetFaceGroupInfoResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.c2.d;
import d.a.q0.c2.e.b;
import d.a.q0.p0.g;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class NewFaceGroupDownloadModel extends FaceBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f18929e;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0218a implements b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.c2.f.a f18930a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Boolean f18931b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f18932c;

            /* renamed from: com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0219a extends BdAsyncTask<Void, Void, Boolean> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f18933a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ C0218a f18934b;

                public C0219a(C0218a c0218a, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0218a, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f18934b = c0218a;
                    this.f18933a = str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Boolean doInBackground(Void... voidArr) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                        int f2 = d.a.q0.p0.a.c().f(this.f18934b.f18930a);
                        if (f2 == 0) {
                            return Boolean.FALSE;
                        }
                        EmotionGroupData emotionGroupData = new EmotionGroupData();
                        emotionGroupData.setGroupId(this.f18934b.f18930a.f55233a);
                        emotionGroupData.setEmotionsCount(f2);
                        emotionGroupData.setHeight(this.f18934b.f18930a.f55237e.get(0).f55242i);
                        emotionGroupData.setWidth(this.f18934b.f18930a.f55237e.get(0).j);
                        emotionGroupData.setDownloadTime(System.currentTimeMillis());
                        emotionGroupData.setGroupName(this.f18934b.f18930a.f55234b);
                        emotionGroupData.setStatus(1);
                        if (g.k().e(emotionGroupData)) {
                            return Boolean.valueOf(g.k().f(TbadkCoreApplication.getCurrentAccount(), emotionGroupData));
                        }
                        return Boolean.FALSE;
                    }
                    return (Boolean) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
                        if (bool != null && bool.booleanValue()) {
                            MessageManager.getInstance().runTask(2004603, (Class) null);
                            if (this.f18934b.f18931b.booleanValue()) {
                                d.m().w();
                            }
                            b bVar = this.f18934b.f18932c;
                            if (bVar != null) {
                                bVar.onSuccess(this.f18933a);
                            }
                            d.a.q0.p0.a0.a aVar = new d.a.q0.p0.a0.a();
                            aVar.f61747a = 0;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar));
                            return;
                        }
                        b bVar2 = this.f18934b.f18932c;
                        if (bVar2 != null) {
                            bVar2.onFail("failed to download");
                        }
                        d.a.q0.p0.a0.a aVar2 = new d.a.q0.p0.a0.a();
                        aVar2.f61747a = 1;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar2));
                    }
                }
            }

            public C0218a(a aVar, d.a.q0.c2.f.a aVar2, Boolean bool, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, aVar2, bool, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18930a = aVar2;
                this.f18931b = bool;
                this.f18932c = bVar;
            }

            @Override // d.a.q0.c2.e.b
            public void onFail(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    BdLog.e("FaceDownload:" + str);
                    b bVar = this.f18932c;
                    if (bVar != null) {
                        bVar.onFail(str);
                    }
                    d.a.q0.p0.a0.a aVar = new d.a.q0.p0.a0.a();
                    aVar.f61747a = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar));
                }
            }

            @Override // d.a.q0.c2.e.b
            public void onProgress(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    b bVar = this.f18932c;
                    if (bVar != null) {
                        bVar.onProgress(i2);
                    }
                    d.a.q0.p0.a0.a aVar = new d.a.q0.p0.a0.a();
                    aVar.f61747a = 2;
                    aVar.f61748b = i2;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar));
                }
            }

            @Override // d.a.q0.c2.e.b
            public void onSuccess(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                    new C0219a(this, str).execute(new Void[0]);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NewFaceGroupDownloadModel newFaceGroupDownloadModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceGroupDownloadModel, Integer.valueOf(i2)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Object extra;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003338 && (httpResponsedMessage instanceof GetFaceGroupInfoResponseMessage)) {
                b bVar = null;
                Boolean bool = Boolean.FALSE;
                if (httpResponsedMessage.getOrginalMessage() != null && (extra = httpResponsedMessage.getOrginalMessage().getExtra()) != null && (extra instanceof HashMap)) {
                    HashMap hashMap = (HashMap) extra;
                    Object obj = hashMap.get("callback");
                    if (obj != null && (obj instanceof b)) {
                        bVar = (b) obj;
                    }
                    Object obj2 = hashMap.get("sync");
                    if (obj2 != null && (obj2 instanceof Boolean)) {
                        bool = (Boolean) obj2;
                    }
                }
                d.a.q0.c2.f.a data = ((GetFaceGroupInfoResponseMessage) httpResponsedMessage).getData();
                if (data != null) {
                    d.a.q0.c2.b.c(data, new C0218a(this, data, bool, bVar));
                } else if (bVar != null) {
                    bVar.onFail("group data null");
                }
            }
        }
    }

    public NewFaceGroupDownloadModel() {
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
        this.f18929e = new a(this, CmdConfigHttp.CMD_GET_FACE_GROUP_INFO);
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f18929e.setTag(getUniqueId());
        this.f18929e.setSelfListener(true);
        registerListener(this.f18929e);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MessageManager.getInstance().unRegisterListener(this.f18929e);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_FACE_GROUP_INFO);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FACE_GROUP_INFO, TbConfig.SERVER_ADDRESS + "c/e/meme/download");
            tbHttpMessageTask.setResponsedClass(GetFaceGroupInfoResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void w(String str, Boolean bool, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, bool, bVar) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FACE_GROUP_INFO);
            HashMap hashMap = new HashMap();
            hashMap.put("sync", bool);
            hashMap.put("callback", bVar);
            httpMessage.setExtra(hashMap);
            httpMessage.addParam("id", str);
            sendMessage(httpMessage);
        }
    }
}
