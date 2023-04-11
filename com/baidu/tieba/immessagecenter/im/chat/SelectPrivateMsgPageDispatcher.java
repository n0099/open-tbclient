package com.baidu.tieba.immessagecenter.im.chat;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tieba.cr5;
import com.baidu.tieba.fq5;
import com.baidu.tieba.gg;
import com.baidu.tieba.gr5;
import com.baidu.tieba.hz7;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.xc9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SelectPrivateMsgPageDispatcher implements xc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a extends cr5<ImMessageCenterPojo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(SelectPrivateMsgPageDispatcher selectPrivateMsgPageDispatcher, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectPrivateMsgPageDispatcher, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cr5
        /* renamed from: a */
        public ImMessageCenterPojo doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return hz7.f().i(this.a);
            }
            return (ImMessageCenterPojo) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements fq5<ImMessageCenterPojo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ArrayList b;

        public b(SelectPrivateMsgPageDispatcher selectPrivateMsgPageDispatcher, String str, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectPrivateMsgPageDispatcher, str, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = arrayList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fq5
        /* renamed from: a */
        public void onReturnDataInUI(ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, imMessageCenterPojo) != null) || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
                return;
            }
            if (imMessageCenterPojo != null) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity(), gg.g(imMessageCenterPojo.getGid(), 0L), imMessageCenterPojo.getGroup_name(), imMessageCenterPojo.getNameShow(), this.a, 0);
                personalChatActivityConfig.setRequestCode(12019);
                personalChatActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                personalChatActivityConfig.setIsReportSelect(true);
                personalChatActivityConfig.setSelectList(this.b);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personalChatActivityConfig));
                return;
            }
            PersonalChatActivityConfig personalChatActivityConfig2 = new PersonalChatActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity(), 0L, "", "", this.a, 0);
            personalChatActivityConfig2.setRequestCode(12019);
            personalChatActivityConfig2.setIntentAction(IntentAction.ActivityForResult);
            personalChatActivityConfig2.setIsReportSelect(true);
            personalChatActivityConfig2.setSelectList(this.b);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personalChatActivityConfig2));
        }
    }

    public SelectPrivateMsgPageDispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.xc9
    @RequiresApi(api = 19)
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("msgArray");
            String optString = jSONObject.optString("portrait");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        String optString2 = jSONObject2.optString("reportContent");
                        String str = null;
                        if (!TextUtils.isEmpty(optString2)) {
                            str = new String(Base64.decode(optString2, 2), StandardCharsets.UTF_8);
                        }
                        arrayList.add(new ReportPrivateMsgData(jSONObject2.optString("msgId"), str, jSONObject2.optString(FileMetaUtil.CREATE_TIME)));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            gr5.c(new a(this, optString), new b(this, optString, arrayList));
        }
    }
}
