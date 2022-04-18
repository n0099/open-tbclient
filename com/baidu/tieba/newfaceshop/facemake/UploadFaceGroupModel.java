package com.baidu.tieba.newfaceshop.facemake;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.tieba.newfaceshop.FaceBaseModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.repackage.ko7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class UploadFaceGroupModel extends FaceBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HttpMessageListener a;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UploadFaceGroupModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(UploadFaceGroupModel uploadFaceGroupModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uploadFaceGroupModel, Integer.valueOf(i)};
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
            this.a = uploadFaceGroupModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ko7.l lVar;
            ArrayList arrayList;
            boolean z;
            Object extra;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003345 || !(httpResponsedMessage instanceof UploadFaceGroupResponseMessage)) {
                return;
            }
            if (httpResponsedMessage.getOrginalMessage() == null || (extra = httpResponsedMessage.getOrginalMessage().getExtra()) == null || !(extra instanceof HashMap)) {
                lVar = null;
                arrayList = null;
            } else {
                HashMap hashMap = (HashMap) extra;
                Object obj = hashMap.get(WebChromeClient.KEY_ARG_CALLBACK);
                lVar = (obj == null || !(obj instanceof ko7.l)) ? null : (ko7.l) obj;
                Object obj2 = hashMap.get("list");
                arrayList = (obj2 == null || !(obj2 instanceof ArrayList)) ? null : (ArrayList) obj2;
                Object obj3 = hashMap.get("autoInstall");
                if (obj3 != null && (obj3 instanceof Boolean)) {
                    z = ((Boolean) obj3).booleanValue();
                    if (arrayList != null) {
                        this.a.z(lVar, null);
                        BdLog.e("msg extra empty");
                        return;
                    } else if (httpResponsedMessage.getError() != 0) {
                        this.a.z(lVar, httpResponsedMessage.getErrorString());
                        return;
                    } else {
                        String groupId = ((UploadFaceGroupResponseMessage) httpResponsedMessage).getGroupId();
                        if (TextUtils.isEmpty(groupId)) {
                            this.a.z(lVar, httpResponsedMessage.getErrorString());
                            return;
                        }
                        if (lVar != null) {
                            lVar.a(groupId, arrayList);
                        }
                        ko7.l().u(true, httpResponsedMessage.getErrorString());
                        if (z) {
                            ko7.l().p(groupId, arrayList, null);
                            return;
                        }
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("upload_result", new Boolean(true));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921040, hashMap2));
                        return;
                    }
                }
            }
            z = true;
            if (arrayList != null) {
            }
        }
    }

    public UploadFaceGroupModel() {
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
        this.a = new a(this, CmdConfigHttp.CMD_UPLOAD_FACE_GROUP);
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.a.setTag(getUniqueId());
        this.a.setSelfListener(true);
        registerListener(this.a);
    }

    public void A(String str, List<FaceData> list, ko7.l lVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048576, this, str, list, lVar, i) == null) {
            if (list != null && !list.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    FaceData faceData = list.get(i2);
                    if (faceData != null) {
                        sb.append(faceData.pid);
                        if (i2 < list.size() - 1) {
                            sb.append("_");
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                Collections.sort(arrayList);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_UPLOAD_FACE_GROUP);
                httpMessage.addParam("name", str);
                httpMessage.addParam(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, ((FaceData) arrayList.get(0)).pid);
                httpMessage.addParam("memes", sb.toString());
                httpMessage.addParam("forum_id", i);
                HashMap hashMap = new HashMap();
                hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, lVar);
                hashMap.put("list", arrayList);
                hashMap.put("autoInstall", Boolean.valueOf(i == 0));
                httpMessage.setExtra(hashMap);
                sendMessage(httpMessage);
                return;
            }
            z(lVar, "empty list");
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MessageManager.getInstance().unRegisterListener(this.a);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_UPLOAD_FACE_GROUP);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_UPLOAD_FACE_GROUP, TbConfig.SERVER_ADDRESS + "c/e/meme/addPackage");
            tbHttpMessageTask.setResponsedClass(UploadFaceGroupResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void z(ko7.l lVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, lVar, str) == null) {
            if (lVar != null) {
                lVar.onFail(str);
            }
            ko7.l().u(false, str);
        }
    }
}
