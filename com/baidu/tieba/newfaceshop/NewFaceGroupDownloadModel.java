package com.baidu.tieba.newfaceshop;

import b.a.r0.f2.d;
import b.a.r0.f2.e.b;
import b.a.r0.s0.g;
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
import java.util.HashMap;
/* loaded from: classes9.dex */
public class NewFaceGroupDownloadModel extends FaceBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f51804e;

    /* loaded from: classes9.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1738a implements b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b.a.r0.f2.f.a f51805a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Boolean f51806b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f51807c;

            /* renamed from: com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class C1739a extends BdAsyncTask<Void, Void, Boolean> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f51808a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ C1738a f51809b;

                public C1739a(C1738a c1738a, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1738a, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f51809b = c1738a;
                    this.f51808a = str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Boolean doInBackground(Void... voidArr) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                        int f2 = b.a.r0.s0.a.c().f(this.f51809b.f51805a);
                        if (f2 == 0) {
                            return Boolean.FALSE;
                        }
                        EmotionGroupData emotionGroupData = new EmotionGroupData();
                        emotionGroupData.setGroupId(this.f51809b.f51805a.f16427a);
                        emotionGroupData.setEmotionsCount(f2);
                        emotionGroupData.setHeight(this.f51809b.f51805a.f16431e.get(0).f16436i);
                        emotionGroupData.setWidth(this.f51809b.f51805a.f16431e.get(0).j);
                        emotionGroupData.setDownloadTime(System.currentTimeMillis());
                        emotionGroupData.setGroupName(this.f51809b.f51805a.f16428b);
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
                            if (this.f51809b.f51806b.booleanValue()) {
                                d.m().w();
                            }
                            b bVar = this.f51809b.f51807c;
                            if (bVar != null) {
                                bVar.onSuccess(this.f51808a);
                            }
                            b.a.r0.s0.z.a aVar = new b.a.r0.s0.z.a();
                            aVar.f23489a = 0;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar));
                            return;
                        }
                        b bVar2 = this.f51809b.f51807c;
                        if (bVar2 != null) {
                            bVar2.onFail("failed to download");
                        }
                        b.a.r0.s0.z.a aVar2 = new b.a.r0.s0.z.a();
                        aVar2.f23489a = 1;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar2));
                    }
                }
            }

            public C1738a(a aVar, b.a.r0.f2.f.a aVar2, Boolean bool, b bVar) {
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
                this.f51805a = aVar2;
                this.f51806b = bool;
                this.f51807c = bVar;
            }

            @Override // b.a.r0.f2.e.b
            public void onFail(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    BdLog.e("FaceDownload:" + str);
                    b bVar = this.f51807c;
                    if (bVar != null) {
                        bVar.onFail(str);
                    }
                    b.a.r0.s0.z.a aVar = new b.a.r0.s0.z.a();
                    aVar.f23489a = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar));
                }
            }

            @Override // b.a.r0.f2.e.b
            public void onProgress(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    b bVar = this.f51807c;
                    if (bVar != null) {
                        bVar.onProgress(i2);
                    }
                    b.a.r0.s0.z.a aVar = new b.a.r0.s0.z.a();
                    aVar.f23489a = 2;
                    aVar.f23490b = i2;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, aVar));
                }
            }

            @Override // b.a.r0.f2.e.b
            public void onSuccess(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                    new C1739a(this, str).execute(new Void[0]);
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
                b.a.r0.f2.f.a data = ((GetFaceGroupInfoResponseMessage) httpResponsedMessage).getData();
                if (data != null) {
                    b.a.r0.f2.b.c(data, new C1738a(this, data, bool, bVar));
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
        this.f51804e = new a(this, CmdConfigHttp.CMD_GET_FACE_GROUP_INFO);
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f51804e.setTag(getUniqueId());
        this.f51804e.setSelfListener(true);
        registerListener(this.f51804e);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MessageManager.getInstance().unRegisterListener(this.f51804e);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_FACE_GROUP_INFO);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
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
