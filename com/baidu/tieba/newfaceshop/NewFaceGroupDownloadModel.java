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
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.dt7;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.ft7;
import com.baidu.tieba.ht7;
import com.baidu.tieba.ie6;
import com.baidu.tieba.it7;
import com.baidu.tieba.newfaceshop.message.GetFaceGroupInfoResponseMessage;
import com.baidu.tieba.qe6;
import com.baidu.tieba.xf6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class NewFaceGroupDownloadModel extends FaceBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HttpMessageListener a;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0362a implements ht7 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ it7 a;
            public final /* synthetic */ Boolean b;
            public final /* synthetic */ ht7 c;

            /* renamed from: com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0363a extends BdAsyncTask<Void, Void, Boolean> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ C0362a b;

                public C0363a(C0362a c0362a, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0362a, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = c0362a;
                    this.a = str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Boolean doInBackground(Void... voidArr) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                        int f = ie6.c().f(this.b.a);
                        if (f == 0) {
                            return Boolean.FALSE;
                        }
                        EmotionGroupData emotionGroupData = new EmotionGroupData();
                        emotionGroupData.setGroupId(this.b.a.a);
                        emotionGroupData.setEmotionsCount(f);
                        emotionGroupData.setHeight(this.b.a.e.get(0).e);
                        emotionGroupData.setWidth(this.b.a.e.get(0).f);
                        emotionGroupData.setDownloadTime(System.currentTimeMillis());
                        emotionGroupData.setGroupName(this.b.a.b);
                        emotionGroupData.setStatus(1);
                        if (qe6.o().g(emotionGroupData)) {
                            return Boolean.valueOf(qe6.o().h(TbadkCoreApplication.getCurrentAccount(), emotionGroupData));
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
                            if (this.b.b.booleanValue()) {
                                ft7.o().z();
                            }
                            ht7 ht7Var = this.b.c;
                            if (ht7Var != null) {
                                ht7Var.onSuccess(this.a);
                            }
                            xf6 xf6Var = new xf6();
                            xf6Var.a = 0;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, xf6Var));
                            return;
                        }
                        ht7 ht7Var2 = this.b.c;
                        if (ht7Var2 != null) {
                            ht7Var2.onFail("failed to download");
                        }
                        xf6 xf6Var2 = new xf6();
                        xf6Var2.a = 1;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, xf6Var2));
                    }
                }
            }

            public C0362a(a aVar, it7 it7Var, Boolean bool, ht7 ht7Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, it7Var, bool, ht7Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = it7Var;
                this.b = bool;
                this.c = ht7Var;
            }

            @Override // com.baidu.tieba.ht7
            public void onFail(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    BdLog.e("FaceDownload:" + str);
                    ht7 ht7Var = this.c;
                    if (ht7Var != null) {
                        ht7Var.onFail(str);
                    }
                    xf6 xf6Var = new xf6();
                    xf6Var.a = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, xf6Var));
                }
            }

            @Override // com.baidu.tieba.ht7
            public void onProgress(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    ht7 ht7Var = this.c;
                    if (ht7Var != null) {
                        ht7Var.onProgress(i);
                    }
                    xf6 xf6Var = new xf6();
                    xf6Var.a = 2;
                    xf6Var.b = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921375, xf6Var));
                }
            }

            @Override // com.baidu.tieba.ht7
            public void onSuccess(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                    new C0363a(this, str).execute(new Void[0]);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NewFaceGroupDownloadModel newFaceGroupDownloadModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceGroupDownloadModel, Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Object extra;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003338 && (httpResponsedMessage instanceof GetFaceGroupInfoResponseMessage)) {
                ht7 ht7Var = null;
                Boolean bool = Boolean.FALSE;
                if (httpResponsedMessage.getOrginalMessage() != null && (extra = httpResponsedMessage.getOrginalMessage().getExtra()) != null && (extra instanceof HashMap)) {
                    HashMap hashMap = (HashMap) extra;
                    Object obj = hashMap.get(WebChromeClient.KEY_ARG_CALLBACK);
                    if (obj != null && (obj instanceof ht7)) {
                        ht7Var = (ht7) obj;
                    }
                    Object obj2 = hashMap.get(NativeConstants.COMPONENT_SYNC_TEXT_VIEW);
                    if (obj2 != null && (obj2 instanceof Boolean)) {
                        bool = (Boolean) obj2;
                    }
                }
                it7 data = ((GetFaceGroupInfoResponseMessage) httpResponsedMessage).getData();
                if (data == null) {
                    if (ht7Var != null) {
                        ht7Var.onFail("group data null");
                        return;
                    }
                    return;
                }
                dt7.c(data, new C0362a(this, data, bool, ht7Var));
            }
        }
    }

    public NewFaceGroupDownloadModel() {
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
        this.a = new a(this, CmdConfigHttp.CMD_GET_FACE_GROUP_INFO);
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.a.setTag(getUniqueId());
        this.a.setSelfListener(true);
        registerListener(this.a);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MessageManager.getInstance().unRegisterListener(this.a);
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

    public void z(String str, Boolean bool, ht7 ht7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, bool, ht7Var) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FACE_GROUP_INFO);
            HashMap hashMap = new HashMap();
            hashMap.put(NativeConstants.COMPONENT_SYNC_TEXT_VIEW, bool);
            hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, ht7Var);
            httpMessage.setExtra(hashMap);
            httpMessage.addParam("id", str);
            sendMessage(httpMessage);
        }
    }
}
