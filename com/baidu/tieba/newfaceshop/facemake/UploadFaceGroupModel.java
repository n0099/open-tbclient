package com.baidu.tieba.newfaceshop.facemake;

import android.text.TextUtils;
import c.a.r0.e2.g.e;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class UploadFaceGroupModel extends FaceBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f54778e;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UploadFaceGroupModel f54779a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(UploadFaceGroupModel uploadFaceGroupModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uploadFaceGroupModel, Integer.valueOf(i2)};
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
            this.f54779a = uploadFaceGroupModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            e.l lVar;
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
                Object obj = hashMap.get("callback");
                lVar = (obj == null || !(obj instanceof e.l)) ? null : (e.l) obj;
                Object obj2 = hashMap.get("list");
                arrayList = (obj2 == null || !(obj2 instanceof ArrayList)) ? null : (ArrayList) obj2;
                Object obj3 = hashMap.get("autoInstall");
                if (obj3 != null && (obj3 instanceof Boolean)) {
                    z = ((Boolean) obj3).booleanValue();
                    if (arrayList != null) {
                        this.f54779a.x(lVar, null);
                        BdLog.e("msg extra empty");
                        return;
                    } else if (httpResponsedMessage.getError() != 0) {
                        this.f54779a.x(lVar, httpResponsedMessage.getErrorString());
                        return;
                    } else {
                        String groupId = ((UploadFaceGroupResponseMessage) httpResponsedMessage).getGroupId();
                        if (TextUtils.isEmpty(groupId)) {
                            this.f54779a.x(lVar, httpResponsedMessage.getErrorString());
                            return;
                        }
                        if (lVar != null) {
                            lVar.a(groupId, arrayList);
                        }
                        e.l().u(true, httpResponsedMessage.getErrorString());
                        if (z) {
                            e.l().p(groupId, arrayList, null);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54778e = new a(this, CmdConfigHttp.CMD_UPLOAD_FACE_GROUP);
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f54778e.setTag(getUniqueId());
        this.f54778e.setSelfListener(true);
        registerListener(this.f54778e);
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
            MessageManager.getInstance().unRegisterListener(this.f54778e);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_UPLOAD_FACE_GROUP);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_UPLOAD_FACE_GROUP, TbConfig.SERVER_ADDRESS + "c/e/meme/addPackage");
            tbHttpMessageTask.setResponsedClass(UploadFaceGroupResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void x(e.l lVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, lVar, str) == null) {
            if (lVar != null) {
                lVar.onFail(str);
            }
            e.l().u(false, str);
        }
    }

    public void y(String str, List<FaceData> list, e.l lVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048580, this, str, list, lVar, i2) == null) {
            if (list != null && !list.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    FaceData faceData = list.get(i3);
                    if (faceData != null) {
                        sb.append(faceData.pid);
                        if (i3 < list.size() - 1) {
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
                httpMessage.addParam("forum_id", i2);
                HashMap hashMap = new HashMap();
                hashMap.put("callback", lVar);
                hashMap.put("list", arrayList);
                hashMap.put("autoInstall", Boolean.valueOf(i2 == 0));
                httpMessage.setExtra(hashMap);
                sendMessage(httpMessage);
                return;
            }
            x(lVar, "empty list");
        }
    }
}
